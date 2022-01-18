package com.reina.ogmios.model;

import com.reina.ogmios.model.base.MethodType;
import com.reina.ogmios.model.base.Request;
import lombok.Getter;

@Getter
public class RequestNext extends Request {

    private static final String ARGS = "{}";

    public RequestNext(long msgId) {
        super(msgId, MethodType.QUERY);
    }

    public String getArgs() {
        return ARGS;
    }

    public String getMirror() {
        return "RequestNext";
    }
}
