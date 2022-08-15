package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * An era bound which captures the time, slot and epoch at which the era start. The time is relative to the start time
 * of the network.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Bound {

    /**
     * A time in seconds relative to another one (typically, system start or era start). Starting from v5.5.4, this can
     * be a floating number. Before v5.5.4, the floating value would be rounded to the nearest second.
     */
    private Integer time;

    /**
     * An absolute slot number.
     */
    private Integer slot;

    /**
     * An epoch number or length.
     */
    private Integer epoch;


    public static Bound deserialize(JsonNode jsonNode) {
        return new Bound(jsonNode.get("time").asInt(), jsonNode.get("slot").asInt(), jsonNode.get("epoch").asInt());
    }
}
