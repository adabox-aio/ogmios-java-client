package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Input {

    private String txId;
    private Long index;

    public static Input deserialize(JsonNode jsonObject) {
        Input input = new Input();
        if (jsonObject.has("txId")) {
            input.setTxId(jsonObject.get("txId").asText());
        }
        if (jsonObject.has("index")) {
            input.setIndex(jsonObject.get("index").longValue());
        }
        return input;
    }
}
