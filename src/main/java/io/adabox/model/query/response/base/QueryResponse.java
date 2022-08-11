package io.adabox.model.query.response.base;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.base.Response;
import io.adabox.model.query.request.base.QueryType;
import io.adabox.model.query.response.*;

import java.util.Objects;

public class QueryResponse extends Response {

    public QueryResponse(long msgId) {
        super(msgId);
    }

    public static QueryResponse parse(QueryType queryType, long msgId, JsonNode jsonNode) {
        switch (Objects.requireNonNull(queryType)) {
            case BLOCK_HEIGHT:
                return BlockHeight.deserialize(msgId, jsonNode);
            case CHAIN_TIP:
                return ChainTip.deserialize(msgId, jsonNode);
            case LEDGER_TIP:
                return LedgerTip.deserialize(msgId, jsonNode);
            case UTXO:
                return UtxoByAddress.deserialize(msgId, jsonNode);
            case GENESIS_CONFIG:
                return GenesisConfig.deserialize(msgId, jsonNode);
            case CURRENT_EPOCH:
                return CurrentEpoch.deserialize(msgId, jsonNode);
            case CURRENT_PROTOCOL_PARAMETERS:
                return CurrentProtocolParameters.deserialize(msgId, jsonNode);
        }
        return null;
    }
}
