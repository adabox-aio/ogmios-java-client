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
public class LedgerTip extends QueryResponse {

    private PointOrOrigin pointOrOrigin;

    public LedgerTip(long msgId) {
        super(msgId);
    }

    public LedgerTip(long msgId, long slot, String hash) {
        this(msgId);
        setPointOrOrigin(new PointOrOrigin(slot, hash));
    }

    public static LedgerTip deserialize(long msgId, JsonNode jsonNode) {
        return new LedgerTip(msgId, jsonNode.get("slot").longValue(), jsonNode.get("hash").asText());
    }
}
