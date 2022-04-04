package io.adabox.model.tx.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
public class InvalidEntity {

    private String type;
    private String entity;

    public static InvalidEntity deserialize(JSONObject jsonObject) {
        InvalidEntity invalidEntity = new InvalidEntity();
        if (jsonObject.has("type")) {
            invalidEntity.setType(jsonObject.getString("type"));
        }
        if (jsonObject.has("entity")) {
            invalidEntity.setEntity(jsonObject.getString("entity"));
        }
        return invalidEntity;
    }
}
