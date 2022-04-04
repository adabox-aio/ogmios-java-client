package io.adabox.model.query.response.base;

import io.adabox.model.base.Response;
import io.adabox.model.query.request.QueryType;
import io.adabox.model.query.response.*;
import org.json.JSONObject;

import java.util.Objects;

public class QueryResponse extends Response {

    public QueryResponse(long msgId) {
        super(msgId);
    }

    public static QueryResponse deserialize(JSONObject reflection, JSONObject jsonObject) {
        QueryType queryType = QueryType.convert(reflection.getString("object"));
        switch (Objects.requireNonNull(queryType)) { //TODO Use Reflection
            case LEDGER_TIP:
                return LedgerTip.deserialize(reflection,jsonObject.getJSONObject("result"));
            case UTXO:
                return UtxoByAddress.deserialize(reflection,jsonObject.getJSONArray("result"));
            case GENESIS_CONFIG:
                return GenesisConfig.deserialize(reflection,jsonObject.getJSONObject("result"));
            case CURRENT_EPOCH:
                return CurrentEpoch.deserialize(reflection,jsonObject.getLong("result"));
            case CURRENT_PROTOCOL_PARAMETERS:
                return CurrentProtocolParameters.deserialize(reflection,jsonObject.getJSONObject("result"));
        }
        return null;
    }
}
