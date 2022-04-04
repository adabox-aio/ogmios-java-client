package com.reina.ogmios.model.base;

public enum MethodType {

    QUERY("Query"),
    REQUEST_NEXT("RequestNext"),
    SUBMIT_TX("SubmitTx"),
    EVALUATE_TX("EvaluateTx");

    private final String value;

    MethodType(String value) {
        this.value = value;
    }

    public static MethodType convert(String type) {
        for (MethodType methodType : values()) {
            if (methodType.getValue().equals(type)) {
                return methodType;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
