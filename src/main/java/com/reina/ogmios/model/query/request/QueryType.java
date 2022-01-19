package com.reina.ogmios.model.query.request;

public enum QueryType {

    LEDGER_TIP("ledgerTip"),
    UTXO("utxo"),
    GENESIS_CONFIG("genesisConfig");

    private final String value;

    QueryType(String value) {
        this.value = value;
    }

    public static QueryType convert(String queryType) {
        for (QueryType type : values()) {
            if (type.getValue().equals(queryType)) {
                return type;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
