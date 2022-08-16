package io.adabox.model.query.request;

import io.adabox.model.query.request.base.QueryRequest;
import io.adabox.model.query.request.base.QueryType;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class NonMyopicMemberRewardsAmountsRequest extends QueryRequest {

    private static final QueryType QUERY_TYPE = QueryType.NON_MYOPIC_MEMBER_REWARDS;
    private final List<Integer> amounts;

    public String getQueryArgs() {
        return "{\""+QUERY_TYPE.getValue()+"\": "+amounts.toString()+" }" ;
    }

    @Override
    public String getMirror() {
        return "\"object\":\""+QUERY_TYPE.getValue()+"\",\"msg_id\":"+getMsgId();
    }
}
