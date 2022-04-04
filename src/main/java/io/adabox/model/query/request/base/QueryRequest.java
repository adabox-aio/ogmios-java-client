package io.adabox.model.query.request.base;

import io.adabox.model.base.MethodType;
import io.adabox.model.base.Request;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class QueryRequest extends Request {

    private static final MethodType METHOD_TYPE = MethodType.QUERY;

    protected QueryRequest(long msgId) {
        super(msgId);
    }

    public String getArgs() {
        return "\"query\":"+getQueryArgs();
    }

    @Override
    public String getMethodType() {
        return METHOD_TYPE.getValue();
    }

    public abstract String getQueryArgs();

    public abstract String getMirror();
}
