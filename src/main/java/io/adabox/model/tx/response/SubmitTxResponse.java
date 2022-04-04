package io.adabox.model.tx.response;

import io.adabox.model.base.Response;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class SubmitTxResponse extends Response {

    private SubmitFail submitFail;

    public SubmitTxResponse(long msgId) {
        super(msgId);
    }

    public static SubmitTxResponse deserialize(long msgId, JSONObject result) {
        SubmitTxResponse submitTxResponse = new SubmitTxResponse(msgId);
        if (result.has("SubmitFail")) {
            submitTxResponse.setSubmitFail(SubmitFail.deserialize(result.getJSONArray("SubmitFail")));
        }

        return submitTxResponse;
    }
}
