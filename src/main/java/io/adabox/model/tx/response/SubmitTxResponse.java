package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.adabox.model.base.Response;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SubmitTxResponse extends Response {

    private SubmitFail submitFail;

    public SubmitTxResponse(long msgId) {
        super(msgId);
    }

    public static SubmitTxResponse deserialize(long msgId, JsonNode result) {
        SubmitTxResponse submitTxResponse = new SubmitTxResponse(msgId);
        if (result.has("SubmitFail")) {
            submitTxResponse.setSubmitFail(SubmitFail.deserialize((ArrayNode) result.get("SubmitFail")));
        }

        return submitTxResponse;
    }
}
