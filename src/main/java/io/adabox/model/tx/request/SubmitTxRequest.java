package io.adabox.model.tx.request;

import io.adabox.model.base.MethodType;
import io.adabox.model.base.Request;
import lombok.EqualsAndHashCode;

import java.util.Base64;

@EqualsAndHashCode(callSuper = true)
public class SubmitTxRequest extends Request {

    private static final MethodType METHOD_TYPE = MethodType.SUBMIT_TX;
    private final byte[] bytes;

    public SubmitTxRequest(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String getMethodType() {
        return METHOD_TYPE.getValue();
    }

    @Override
    public String getArgs() {
        return "\"bytes\":\"" + Base64.getEncoder().encodeToString(bytes) + "\"";
    }

    @Override
    public String getMirror() {
        return "\"object\":\"" + METHOD_TYPE.getValue() + "\",\"msg_id\":" + getMsgId();
    }
}
