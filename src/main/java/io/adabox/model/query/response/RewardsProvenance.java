package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class RewardsProvenance extends QueryResponse {

    private JsonNode rewardsProvenance;

    public RewardsProvenance(long msgId) {
        super(msgId);
    }

    public static RewardsProvenance deserialize(long msgId, JsonNode jsonNode) {
        RewardsProvenance rewardsProvenance = new RewardsProvenance(msgId);
        rewardsProvenance.setRewardsProvenance(jsonNode);
        return rewardsProvenance;
    }
}
