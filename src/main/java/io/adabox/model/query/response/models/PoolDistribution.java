package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PoolDistribution {

    /**
     * A ratio of two integers, to express exact fractions.
     * Examples values: "2/3""7/8"
     */
    private String stake;

    /**
     * A Blake2b 32-byte digest of a VRF verification key.
     * Examples values: "c248757d390181c517a5beadc9c3fe64bf821d3e889a963fc717003ec248757d"
     */
    private String vrf;

    public static PoolDistribution deserialize(JsonNode jsonNode) {
        return new PoolDistribution(jsonNode.get("stake").asText(), jsonNode.get("vrf").asText());
    }
}
