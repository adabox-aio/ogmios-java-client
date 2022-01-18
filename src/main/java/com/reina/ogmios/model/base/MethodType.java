package com.reina.ogmios.model.base;

public enum MethodType {

    QUERY("Query"),
    REQUEST_NEXT("RequestNext");

    private final String value;

    MethodType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MethodType convert(String methodType) {
        switch (methodType) {
            case "Query":
                return QUERY;
            case "RequestNext":
                return REQUEST_NEXT;
        }
        return null;
    }
}
