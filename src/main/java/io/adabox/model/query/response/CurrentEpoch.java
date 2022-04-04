package io.adabox.model.query.response;

import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CurrentEpoch extends QueryResponse {

    private long epoch;

    public CurrentEpoch(long msgId) {
        super(msgId);
    }

    public CurrentEpoch(long msgId, long epoch) {
        this(msgId);
        setEpoch(epoch);
    }

    public static CurrentEpoch deserialize(JSONObject reflection, long epoch) {
        long msgId = reflection.getLong("msg_id");
        return new CurrentEpoch(msgId, epoch);
    }
}
