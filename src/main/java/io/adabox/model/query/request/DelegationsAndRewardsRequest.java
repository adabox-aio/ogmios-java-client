package io.adabox.model.query.request;

import io.adabox.model.query.request.base.QueryRequest;
import io.adabox.model.query.request.base.QueryType;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DelegationsAndRewardsRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.DELEGATIONS_AND_REWARDS;
    private final List<String> rewardAccounts;

    public String getQueryArgs() {
        return "{\""+QUERY_TYPE.getValue()+"\": ["+wrapWithQuotesAndJoin(rewardAccounts)+"] }" ;
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }

    String wrapWithQuotesAndJoin(List<String> strings) {
        return strings.stream().collect(Collectors.joining("\", \"", "\"", "\""));
    }
}
