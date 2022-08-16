package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.PoolDistribution;
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
public class StakeDistribution extends QueryResponse {

    /**
     * Distribution of stake across registered stake pools. Each key in the map corresponds to a pool id.
     */
    private final Map<String, PoolDistribution> stakeDistributionMap = new HashMap<>();

    public StakeDistribution(long msgId) {
        super(msgId);
    }

    public static StakeDistribution deserialize(long msgId, JsonNode jsonNode) {
        StakeDistribution stakeDistribution = new StakeDistribution(msgId);
        Iterator<String> iterator = jsonNode.fieldNames();
        while (iterator.hasNext()) {
            String key = iterator.next();
            stakeDistribution.getStakeDistributionMap().put(key, PoolDistribution.deserialize(jsonNode.get(key)));
        }
        return stakeDistribution;
    }
}
