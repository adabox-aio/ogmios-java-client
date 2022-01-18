package com.reina.ogmios.model.query.request.base;

import com.reina.ogmios.model.base.MethodType;
import com.reina.ogmios.model.base.Request;

public abstract class QueryRequest extends Request {

    public QueryRequest() {
        super(MethodType.QUERY);
    }

    protected QueryRequest(long msgId) {
        super(msgId, MethodType.QUERY);
    }

    public String getArgs() {
        return "\"query\":"+getQueryArgs();
    }

    public abstract String getQueryArgs();

    public abstract String getMirror();
}
