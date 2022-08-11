package io.adabox.model.query.request.base;

public enum QueryType {

    BLOCK_HEIGHT("blockHeight"),
    CHAIN_TIP("chainTip"),
    LEDGER_TIP("ledgerTip"),
    UTXO("utxo"),
    GENESIS_CONFIG("genesisConfig"),
    CURRENT_EPOCH("currentEpoch"),
    CURRENT_PROTOCOL_PARAMETERS("currentProtocolParameters");

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
