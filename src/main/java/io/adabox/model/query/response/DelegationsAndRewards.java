package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.DelegationAndReward;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class DelegationsAndRewards extends QueryResponse {

    private final Map<String, DelegationAndReward> delegationAndRewardMap = new HashMap<>();

    public DelegationsAndRewards(long msgId) {
        super(msgId);
    }

    public static DelegationsAndRewards deserialize(long msgId, JsonNode jsonNode) {
        DelegationsAndRewards delegationsAndRewards = new DelegationsAndRewards(msgId);
        Iterator<String> iterator = jsonNode.fieldNames();
        while (iterator.hasNext()) {
            String key = iterator.next();
            delegationsAndRewards.getDelegationAndRewardMap().put(key, DelegationAndReward.deserialize(jsonNode.get(key)));
        }
        return delegationsAndRewards;
    }
}
