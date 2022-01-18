package com.reina.ogmios.model.query.response;

import com.reina.ogmios.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class LedgerTip extends QueryResponse {

    private long slot;
    private String hash;

    public LedgerTip(long msgId) {
        super(msgId);
    }

    public LedgerTip(long msgId, long slot, String hash) {
        this(msgId);
        setSlot(slot);
        setHash(hash);
    }

    public static LedgerTip deserialize(JSONObject reflection, JSONObject result) {
        long msgId = reflection.getLong("msg_id");
        return new LedgerTip(msgId,result.getLong("slot"), result.getString("hash"));
    }
}
