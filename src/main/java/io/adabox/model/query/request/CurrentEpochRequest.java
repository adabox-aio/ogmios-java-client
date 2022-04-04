package io.adabox.model.query.request;

import io.adabox.model.query.request.base.QueryRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CurrentEpochRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.CURRENT_EPOCH;

    public String getQueryArgs() {
        return "\""+QUERY_TYPE.getValue()+"\"";
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }
}
