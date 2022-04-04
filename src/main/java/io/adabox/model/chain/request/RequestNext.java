package io.adabox.model.chain.request;

import io.adabox.model.base.MethodType;
import io.adabox.model.base.Request;
import lombok.Getter;

@Getter
public class RequestNext extends Request {

    private static final MethodType METHOD_TYPE = MethodType.REQUEST_NEXT;

    private static final String ARGS = "{}";

    public RequestNext(long msgId) {
        super(msgId);
    }

    @Override
    public String getMethodType() {
        return METHOD_TYPE.getValue();
    }

    public String getArgs() {
        return ARGS;
    }

    public String getMirror() {
        return "RequestNext";
    }
}
