package com.reina.ogmios.model.tx.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public static NetworkMismatch deserialize(JSONObject networkMismatchEntity) {
        NetworkMismatch networkMismatch = new NetworkMismatch();
        if (networkMismatchEntity.has("invalidEntities")) {
            List<InvalidEntity> invalidEntities = new ArrayList<>();
            JSONArray invalidEntitiesEntity = networkMismatchEntity.getJSONArray("invalidEntities");
            for (Object o : invalidEntitiesEntity) {
                invalidEntities.add(InvalidEntity.deserialize((JSONObject) o));
            }
            networkMismatch.setInvalidEntities(invalidEntities);
        }
        if (networkMismatchEntity.has("expectedNetwork")) {
            networkMismatch.setExpectedNetwork(networkMismatchEntity.getString("expectedNetwork"));
        }
        return networkMismatch;
    }
}
