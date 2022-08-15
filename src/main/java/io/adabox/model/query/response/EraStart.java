package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
public class EraStart extends QueryResponse {

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

    public EraStart(long msgId) {
        super(msgId);
    }

    public static EraStart deserialize(long msgId, JsonNode jsonNode) {
        EraStart eraStart = new EraStart(msgId);
        eraStart.setTime(jsonNode.get("time").asInt());
        eraStart.setSlot(jsonNode.get("slot").asInt());
        eraStart.setEpoch(jsonNode.get("epoch").asInt());
        return eraStart;
    }
}
