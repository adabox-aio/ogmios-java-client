package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.Bound;
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

    private Bound bound;

    public EraStart(long msgId) {
        super(msgId);
    }

    public static EraStart deserialize(long msgId, JsonNode jsonNode) {
        EraStart eraStart = new EraStart(msgId);
        eraStart.setBound(Bound.deserialize(jsonNode));
        return eraStart;
    }
}
