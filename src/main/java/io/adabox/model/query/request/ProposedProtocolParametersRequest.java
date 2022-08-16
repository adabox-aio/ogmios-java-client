package io.adabox.model.query.request;

import io.adabox.model.query.request.base.QueryRequest;
import io.adabox.model.query.request.base.QueryType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProposedProtocolParametersRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.PROPOSED_PROTOCOL_PARAMETERS;

    public String getQueryArgs() {
        return "\""+QUERY_TYPE.getValue()+"\"";
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }
}
