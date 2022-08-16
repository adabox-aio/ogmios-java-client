package io.adabox.model.query.request;

import io.adabox.model.query.request.base.QueryRequest;
import io.adabox.model.query.request.base.QueryType;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class NonMyopicMemberRewardsRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.NON_MYOPIC_MEMBER_REWARDS;
    private final List<String> credentials;

    public String getQueryArgs() {
        return "{\""+QUERY_TYPE.getValue()+"\": ["+wrapWithQuotesAndJoin(credentials)+"] }" ;
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }

    String wrapWithQuotesAndJoin(List<String> strings) {
        return strings.stream().collect(Collectors.joining("\", \"", "\"", "\""));
    }
}
