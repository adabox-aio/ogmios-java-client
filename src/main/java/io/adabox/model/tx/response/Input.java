package io.adabox.model.tx.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
public class Input {

    private String txId;
    private Long index;

    public static Input deserialize(JSONObject jsonObject) {
        Input input = new Input();
        if (jsonObject.has("txId")) {
            input.setTxId(jsonObject.getString("txId"));
        }
        if (jsonObject.has("index")) {
            input.setIndex(jsonObject.getLong("index"));
        }
        return input;
    }
}
