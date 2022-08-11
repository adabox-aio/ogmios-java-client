package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Prices {

    private String memory;
    private String steps;

    public static Prices deserialize(JsonNode jsonObject) {
        Prices prices = new Prices();
        if (jsonObject.has("memory")) {
            prices.setMemory(jsonObject.get("memory").asText());
        }
        if (jsonObject.has("steps")) {
            prices.setSteps(jsonObject.get("steps").asText());
        }
        return prices;
    }
}
