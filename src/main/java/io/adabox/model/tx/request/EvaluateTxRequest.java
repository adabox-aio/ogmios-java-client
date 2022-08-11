package io.adabox.model.tx.request;

import io.adabox.model.base.MethodType;
import io.adabox.model.base.Request;
import io.adabox.util.HexUtil;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class EvaluateTxRequest extends Request {

    private static final MethodType METHOD_TYPE = MethodType.EVALUATE_TX;
    private final byte[] cborBytes;

    public EvaluateTxRequest(byte[] cborBytes) {
        this.cborBytes = cborBytes;
    }

    @Override
    protected String getMethodType() {
        return METHOD_TYPE.getValue();
    }

    @Override
    public String getArgs() {
        return "\"evaluate\":\"" + HexUtil.encodeHexString(cborBytes) + "\"";
    }

    @Override
    public String getMirror() {
        return "\"object\":\"" + METHOD_TYPE.getValue() + "\",\"msg_id\":" + getMsgId();
    }
}
