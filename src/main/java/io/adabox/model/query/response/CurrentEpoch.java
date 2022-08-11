package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CurrentEpoch extends QueryResponse {

    /**
     * An epoch number
     */
    private Integer epoch;

    public CurrentEpoch(long msgId) {
        super(msgId);
    }

    public CurrentEpoch(long msgId, int epoch) {
        this(msgId);
        setEpoch(epoch);
    }

    public static CurrentEpoch deserialize(long msgId, JsonNode jsonNode) {
        return new CurrentEpoch(msgId, jsonNode.intValue());
    }
}
