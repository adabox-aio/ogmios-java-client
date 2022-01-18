package com.reina.ogmios.model.query.request;

import com.reina.ogmios.model.query.QueryType;
import com.reina.ogmios.model.query.request.base.QueryRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LedgerTipRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.LEDGER_TIP;

    public LedgerTipRequest(long msgId) {
        super(msgId);
    }

    public String getQueryArgs() {
        return "\""+QUERY_TYPE.getValue()+"\"";
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }
}
