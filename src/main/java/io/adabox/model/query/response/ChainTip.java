package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.PointOrOrigin;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ChainTip extends QueryResponse {

    private PointOrOrigin pointOrOrigin;

    public ChainTip(long msgId) {
        super(msgId);
    }

    public ChainTip(long msgId, long slot, String hash) {
        this(msgId);
        setPointOrOrigin(new PointOrOrigin(slot, hash));
    }

    public static ChainTip deserialize(long msgId, JsonNode jsonNode) {
        return new ChainTip(msgId, jsonNode.get("slot").longValue(), jsonNode.get("hash").asText());
    }
}
