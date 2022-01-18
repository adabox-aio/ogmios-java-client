package com.reina.ogmios;

import com.reina.ogmios.model.RequestNext;
import com.reina.ogmios.model.RequestNextResponse;
import com.reina.ogmios.model.base.Message;
import com.reina.ogmios.model.query.iface.LocalStateQuery;
import com.reina.ogmios.model.query.request.GenesisConfigRequest;
import com.reina.ogmios.model.query.request.LedgerTipRequest;
import com.reina.ogmios.model.query.request.UtxoByAddressRequest;
import com.reina.ogmios.model.query.request.base.QueryRequest;
import com.reina.ogmios.model.query.response.GenesisConfig;
import com.reina.ogmios.model.query.response.LedgerTip;
import com.reina.ogmios.model.query.response.UtxoByAddress;
import com.reina.ogmios.model.query.response.base.QueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class OgmiosWSClient extends WebSocketClient implements ChainSync, LocalStateQuery {

    private static final long TIMEOUT = 5; // Sec
    private final AtomicLong msgId = new AtomicLong();
    private final ConcurrentHashMap<Long, BlockingQueue<Message>> blockingQueueConcurrentHashMap = new ConcurrentHashMap<>();

    public OgmiosWSClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public OgmiosWSClient(URI serverURI) {
        super(serverURI);
    }

    public OgmiosWSClient(URI serverUri, Map<String, String> httpHeaders) {
        super(serverUri, httpHeaders);
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
        log.info("Connection closed by {}, Code: {}{}", (remote ? "remote peer" : "client"), code, StringUtils.isEmpty(reason) ? reason : ", Reason: "+reason);
    }

    @Override
    public void onError(Exception ex) {
        log.error(ex.getMessage());
        // if the error is fatal then onClose will be called additionally
    }

    /**
     * Request next block from the current cardano-node's cursor.
     *
     * @return RequestNextResponse
     */
    public RequestNextResponse requestNext() {
        send(new RequestNext(msgId.incrementAndGet()).toString());
        return null;
    }

    private QueryResponse sendQuery(QueryRequest queryRequest) {
        QueryResponse queryResponse = null;
        long msgIdentifier = msgId.incrementAndGet();
        queryRequest.setMsgId(msgIdentifier);
        send(queryRequest.toString());
        BlockingQueue<Message> messageBlockingQueue = new ArrayBlockingQueue<>(1);
        blockingQueueConcurrentHashMap.put(msgIdentifier, messageBlockingQueue);
        try {
            queryResponse = (QueryResponse) messageBlockingQueue.poll(TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return queryResponse;
    }

    public LedgerTip ledgerTip() {
        return (LedgerTip) sendQuery(new LedgerTipRequest());
    }

    public UtxoByAddress utxoByAddress(String address) {
        return (UtxoByAddress) sendQuery(new UtxoByAddressRequest(address));
    }

    @Override
    public GenesisConfig genesisConfig() {
        return (GenesisConfig) sendQuery(new GenesisConfigRequest());
    }
}