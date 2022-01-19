package com.reina.ogmios.model.query.response.base;

import com.reina.ogmios.model.base.Response;
import com.reina.ogmios.model.query.response.GenesisConfig;
import com.reina.ogmios.model.query.response.LedgerTip;
import com.reina.ogmios.model.query.request.QueryType;
import com.reina.ogmios.model.query.response.UtxoByAddress;
import org.json.JSONObject;

import java.util.Objects;

public class QueryResponse extends Response {

    public QueryResponse(long msgId) {
        super(msgId);
    }

    public static QueryResponse deserialize(JSONObject reflection, JSONObject jsonObject) {
        QueryType queryType = QueryType.convert(reflection.getString("object"));
        switch (Objects.requireNonNull(queryType)) {
            case LEDGER_TIP:
                return LedgerTip.deserialize(reflection,jsonObject.getJSONObject("result"));
            case UTXO:
                return UtxoByAddress.deserialize(reflection,jsonObject.getJSONArray("result"));
            case GENESIS_CONFIG:
                return GenesisConfig.deserialize(reflection,jsonObject.getJSONObject("result"));
        }
        return null;
    }
}
