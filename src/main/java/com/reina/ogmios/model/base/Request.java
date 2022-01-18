package com.reina.ogmios.model.base;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public abstract class Request extends Message {

    private static final String TYPE = "jsonwsp/request";
    private static final String VERSION = "1.0";
    private static final String SERVICE_NAME = "ogmios";
    private final MethodType methodType;

    public Request(MethodType methodType) {
        this.methodType = methodType;
    }

    protected Request(long msgId, MethodType methodType) {
        super(msgId);
        this.methodType = methodType;
    }

    @Override
    public String toString() {
        return "{\"type\":\"" + TYPE + "\",\"version\":\"" + VERSION + "\",\"servicename\":\"" + SERVICE_NAME + "\",\"methodname\":\"" + methodType.getValue() + "\",\"mirror\":{" + getMirror() + "},\"args\":{" + getArgs() + "}}";
    }

    public abstract String getArgs();

    public abstract String getMirror();
}
