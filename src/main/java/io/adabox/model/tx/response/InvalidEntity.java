package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InvalidEntity {

    private String type;
    private String entity;

    public static InvalidEntity deserialize(JsonNode jsonObject) {
        InvalidEntity invalidEntity = new InvalidEntity();
        if (jsonObject.has("type")) {
            invalidEntity.setType(jsonObject.get("type").asText());
        }
        if (jsonObject.has("entity")) {
            invalidEntity.setEntity(jsonObject.get("entity").asText());
        }
        return invalidEntity;
    }
}
