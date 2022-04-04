package io.adabox.model.query.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
public class Prices {

    private String memory;
    private String steps;

    public static Prices deserialize(JSONObject jsonObject) {
        Prices prices = new Prices();
        if (jsonObject.has("memory")) {
            prices.setMemory(jsonObject.getString("memory"));
        }
        if (jsonObject.has("steps")) {
            prices.setSteps(jsonObject.getString("steps"));
        }
        return prices;
    }
}
