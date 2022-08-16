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
public class DelegationAndRewardsDto {

    /**
     * Bech32 Pool Id
     */
    private String delegate;

    /**
     * A number of lovelace, possibly large when summed up.
     */
    private String rewards;

    public static DelegationAndRewardsDto deserialize(JsonNode jsonNode) {
        return new DelegationAndRewardsDto(jsonNode.get("delegate").asText(), jsonNode.get("rewards").asText());
    }
}
