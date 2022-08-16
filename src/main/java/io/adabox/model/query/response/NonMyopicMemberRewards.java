package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.NonMyopicMemberReward;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class NonMyopicMemberRewards extends QueryResponse {

    /**
     * Rewards that can be expected assuming a pool is fully saturated. Such rewards are said non-myopic,
     * in opposition to short-sighted rewards looking at immediate benefits. Keys of the map can be either
     * Lovelace amounts or account credentials depending on the query.
     */
    private final Map<String, List<NonMyopicMemberReward>> nonMyopicMemberRewardsMap = new HashMap<>();

    public NonMyopicMemberRewards(long msgId) {
        super(msgId);
    }

    public static NonMyopicMemberRewards deserialize(long msgId, JsonNode jsonNode) {
        NonMyopicMemberRewards nonMyopicMemberRewards = new NonMyopicMemberRewards(msgId);
        Iterator<String> iterator = jsonNode.fieldNames();
        while (iterator.hasNext()) {
            String key = iterator.next();
            List<NonMyopicMemberReward> myopicMemberRewards = new ArrayList<>();
            JsonNode jsonNode1 = jsonNode.get(key);
            Iterator<String> poolIdIterator = jsonNode1.fieldNames();
            while (poolIdIterator.hasNext()) {
                String poolId = poolIdIterator.next();
                myopicMemberRewards.add(new NonMyopicMemberReward(poolId, jsonNode1.get(poolId).asInt()));
            }
            nonMyopicMemberRewards.getNonMyopicMemberRewardsMap().put(key, myopicMemberRewards);
        }
        return nonMyopicMemberRewards;
    }
}
