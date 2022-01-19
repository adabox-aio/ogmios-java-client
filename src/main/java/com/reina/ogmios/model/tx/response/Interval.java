package com.reina.ogmios.model.tx.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
public class Interval {

    private Long invalidHereafter;
    private Long invalidBefore;

    public static Interval deserialize(JSONObject jsonObject) {
        Interval interval = new Interval();
        if (jsonObject.has("invalidHereafter")) {
            Object invalidHereafter = jsonObject.get("invalidHereafter");
            if (invalidHereafter instanceof Integer) {
                interval.setInvalidHereafter(jsonObject.getLong("invalidHereafter"));
            }
        }
        if (jsonObject.has("invalidBefore")) {
            Object invalidBefore = jsonObject.get("invalidBefore");
            if (invalidBefore instanceof Integer) {
                interval.setInvalidBefore(jsonObject.getLong("invalidBefore"));
            }
        }
        return interval;
    }
}
