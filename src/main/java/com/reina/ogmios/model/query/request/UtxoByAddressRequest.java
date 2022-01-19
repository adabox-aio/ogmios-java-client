package com.reina.ogmios.model.query.request;

import com.reina.ogmios.model.query.request.base.QueryRequest;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class UtxoByAddressRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.UTXO;
    private final String address;

    public UtxoByAddressRequest(String address) {
        this.address = address;
    }

    public String getQueryArgs() {
        return "{\""+QUERY_TYPE.getValue()+"\": [\""+address+"\"] }" ;
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }
}
