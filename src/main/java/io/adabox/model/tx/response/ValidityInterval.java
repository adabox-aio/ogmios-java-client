package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ValidityInterval {

    private Integer invalidBefore;
    private Integer invalidHereafter;

    public static ValidityInterval deserialize(JsonNode jsonObject) {
        ValidityInterval interval = new ValidityInterval();
        if (jsonObject.has("invalidBefore")) {
            interval.setInvalidBefore(jsonObject.get("invalidBefore").intValue());
        }
        if (jsonObject.has("invalidHereafter")) {
            interval.setInvalidHereafter(jsonObject.get("invalidHereafter").intValue());
        }
        return interval;
    }
}
