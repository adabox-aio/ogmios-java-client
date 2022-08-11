package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class NetworkMismatch extends TxError {

    private List<InvalidEntity> invalidEntities;
    private String expectedNetwork;

    public NetworkMismatch() {
        super(TxErrorType.NETWORK_MISMATCH);
    }

    public static NetworkMismatch deserialize(JsonNode networkMismatchEntity) {
        NetworkMismatch networkMismatch = new NetworkMismatch();
        if (networkMismatchEntity.has("invalidEntities")) {
            List<InvalidEntity> invalidEntities = new ArrayList<>();
            ArrayNode invalidEntitiesEntity = (ArrayNode) networkMismatchEntity.get("invalidEntities");
            for (Object o : invalidEntitiesEntity) {
                invalidEntities.add(InvalidEntity.deserialize((JsonNode) o));
            }
            networkMismatch.setInvalidEntities(invalidEntities);
        }
        if (networkMismatchEntity.has("expectedNetwork")) {
            networkMismatch.setExpectedNetwork(networkMismatchEntity.get("expectedNetwork").asText());
        }
        return networkMismatch;
    }
}
