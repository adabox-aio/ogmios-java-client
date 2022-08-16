package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PoolParametersDto {

    /**
     * List of Blake2b 28-byte digest of an Ed25519 verification keys.
     */
    private List<String> owners;

    /**
     * A number of lovelace, possibly large when summed up.
     */
    private String cost;

    /**
     * A ratio of two integers, to express exact fractions.
     * Examples values: "2/3", "7/8"
     */
    private String margin;

    /**
     * A number of lovelace, possibly large when summed up.
     */
    private String pledge;

    /**
     * A Blake2b 32-byte digest of a VRF verification key.
     */
    private String vrf;

    /**
     * One Of:
     * - A Blake2b 32-byte digest of stake pool (canonical) JSON metadata.
     * - Url
     */
    private String metadata;

    /**
     * A Blake2b 32-byte digest of a pool's verification key.
     */
    private String id;

    /**
     * Relays
     */
    private List<Relay> relays;

    /**
     * A reward account, also known as 'stake address'.
     * Examples values: "stake1ux7pt9adw8z46tgqn2f8fvurrhk325gcm4mf75mkmmxpx6gae9mzv"
     */
    private String rewardAccount;

    public static PoolParametersDto deserialize(JsonNode jsonNode) {
        PoolParametersDto poolParametersDto = new PoolParametersDto();
        if (jsonNode.has("id")) {
            poolParametersDto.setId(jsonNode.get("id").asText());
        }
        if (jsonNode.has("vrf")) {
            poolParametersDto.setVrf(jsonNode.get("vrf").asText());
        }
        if (jsonNode.has("pledge")) {
            poolParametersDto.setPledge(jsonNode.get("pledge").asText());
        }
        if (jsonNode.has("cost")) {
            poolParametersDto.setCost(jsonNode.get("cost").asText());
        }
        if (jsonNode.has("margin")) {
            poolParametersDto.setMargin(jsonNode.get("margin").asText());
        }
        if (jsonNode.has("rewardAccount")) {
            poolParametersDto.setRewardAccount(jsonNode.get("rewardAccount").asText());
        }
        if (jsonNode.has("owners")) {
            List<String> owners = new ArrayList<>();
            for (JsonNode node : jsonNode.get("owners")) {
                owners.add(node.asText());
            }
            poolParametersDto.setOwners(owners);
        }
        if (jsonNode.has("relays")) {
            List<Relay> relays = new ArrayList<>();
            for (JsonNode node : jsonNode.get("relays")) {
                relays.add(Relay.deserialize(node));
            }
            poolParametersDto.setRelays(relays);
        }
        if (jsonNode.has("metadata") && jsonNode.get("metadata").getNodeType() != JsonNodeType.NULL) {
            poolParametersDto.setMetadata(jsonNode.get("metadata").asText());
        }
        return poolParametersDto;
    }
}
