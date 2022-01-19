package com.reina.ogmios;

import com.reina.ogmios.model.base.Message;
import com.reina.ogmios.model.base.Request;
import com.reina.ogmios.model.base.Response;
import com.reina.ogmios.model.base.iface.LocalChainSync;
import com.reina.ogmios.model.base.iface.LocalStateQuery;
import com.reina.ogmios.model.base.iface.LocalTxSubmission;
import com.reina.ogmios.model.chain.request.RequestNext;
import com.reina.ogmios.model.chain.response.AcquireResponse;
import com.reina.ogmios.model.chain.response.RequestNextResponse;
import com.reina.ogmios.model.query.request.GenesisConfigRequest;
import com.reina.ogmios.model.query.request.LedgerTipRequest;
import com.reina.ogmios.model.query.request.UtxoByAddressRequest;
import com.reina.ogmios.model.query.response.GenesisConfig;
import com.reina.ogmios.model.query.response.LedgerTip;
import com.reina.ogmios.model.query.response.UtxoByAddress;
import com.reina.ogmios.model.tx.request.SubmitTxRequest;
import com.reina.ogmios.model.tx.response.SubmitTxResponse;
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
    public SubmitTxResponse submitTransaction(byte[] cborData) throws InvalidParameterException {
        if (cborData.length == 0) {
            throw new InvalidParameterException();
        }
        return (SubmitTxResponse) send(new SubmitTxRequest(cborData));
    }
}