package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class PoolsRanking extends QueryResponse {

    private JsonNode poolsRanking;

    public PoolsRanking(long msgId, JsonNode poolsRanking) {
        super(msgId);
        setPoolsRanking(poolsRanking);
    }

    public static PoolsRanking deserialize(long msgId, JsonNode jsonNode) {
        return new PoolsRanking(msgId, jsonNode);
    }
}
