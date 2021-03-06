package io.adabox;

import io.adabox.model.base.Message;
import io.adabox.model.base.Request;
import io.adabox.model.base.Response;
import io.adabox.model.base.iface.LocalChainSync;
import io.adabox.model.base.iface.LocalStateQuery;
import io.adabox.model.base.iface.LocalTxSubmission;
import io.adabox.model.chain.request.RequestNext;
import io.adabox.model.chain.response.AcquireResponse;
import io.adabox.model.chain.response.RequestNextResponse;
import io.adabox.model.query.request.*;
import io.adabox.model.query.response.*;
import io.adabox.model.tx.request.EvaluateTxRequest;
import io.adabox.model.tx.request.SubmitTxRequest;
import io.adabox.model.tx.response.EvaluateTxResponse;
import io.adabox.model.tx.response.SubmitTxResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.security.InvalidParameterException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class OgmiosWSClient extends WebSocketClient implements LocalChainSync, LocalStateQuery, LocalTxSubmission {

    private static final long TIMEOUT = 5; // Sec
    private final AtomicLong msgId = new AtomicLong();
    private final ConcurrentHashMap<Long, BlockingQueue<Message>> blockingQueueConcurrentHashMap = new ConcurrentHashMap<>();

    public OgmiosWSClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log.info("Connection Established!");
        if (log.isDebugEnabled()) log.debug("onOpen -> ServerHandshake: {}", serverHandshake);
    }

    @Override
    public void onMessage(String message) {
        if (log.isDebugEnabled()) log.debug("Received: {}", message);
        Message response = Message.deserialize(message);
        if (response == null) {
            log.error("Response is Null");
            return;
        }
        if (blockingQueueConcurrentHashMap.get(response.getMsgId()).offer(response) && log.isDebugEnabled()) {
            log.debug("Message Offered: {}", message);
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("Connection closed by {}, Code: {}{}", (remote ? "remote peer" : "client"), code, StringUtils.isEmpty(reason) ? reason : ", Reason: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        log.error(ex.getMessage());
        // if the error is fatal then onClose will be called additionally
    }

    private Response send(Request request) {
        Response queryResponse = null;
        long msgIdentifier = msgId.incrementAndGet();
        request.setMsgId(msgIdentifier);
        send(request.toString());
        BlockingQueue<Message> messageBlockingQueue = new ArrayBlockingQueue<>(1);
        blockingQueueConcurrentHashMap.put(msgIdentifier, messageBlockingQueue);
        try {
            queryResponse = (Response) messageBlockingQueue.poll(TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return queryResponse;
    }

    @Override
    public AcquireResponse acquire(String point) {
        return null;
    }

    @Override
    public RequestNextResponse requestNext() {
        send(new RequestNext(msgId.incrementAndGet()).toString());
        return null;
    }

    /* LocalStateQuery */
    @Override
    public CurrentEpoch currentEpoch() {
        return (CurrentEpoch) send(new CurrentEpochRequest());
    }

    @Override
    public CurrentProtocolParameters currentProtocolParameters() {
        return (CurrentProtocolParameters) send(new CurrentProtocolParametersRequest());
    }

    @Override
    public LedgerTip ledgerTip() {
        return (LedgerTip) send(new LedgerTipRequest());
    }

    @Override
    public UtxoByAddress utxoByAddress(String address) throws InvalidParameterException {
        return (UtxoByAddress) send(new UtxoByAddressRequest(address));
    }

    @Override
    public GenesisConfig genesisConfig() {
        return (GenesisConfig) send(new GenesisConfigRequest());
    }

    /* LocalTxSubmission */
    @Override
    public SubmitTxResponse submitTx(byte[] cborData) throws InvalidParameterException {
        if (cborData.length == 0) {
            throw new InvalidParameterException();
        }
        return (SubmitTxResponse) send(new SubmitTxRequest(cborData));
    }

    @Override
    public EvaluateTxResponse evaluateTx(byte[] cborData) throws InvalidParameterException {
        if (cborData.length == 0) {
            throw new InvalidParameterException();
        }
        return (EvaluateTxResponse) send(new EvaluateTxRequest(cborData));
    }
}