package io.adabox.model.query.request;

import io.adabox.model.query.request.base.QueryRequest;
import io.adabox.model.query.request.base.QueryType;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PoolParametersRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.POOL_PARAMETERS;
    private final List<String> poolIds;

    public String getQueryArgs() {
        return "{\""+QUERY_TYPE.getValue()+"\": ["+wrapWithQuotesAndJoin(poolIds)+"] }" ;
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }

    String wrapWithQuotesAndJoin(List<String> strings) {
        return strings.stream().collect(Collectors.joining("\", \"", "\"", "\""));
    }
}
