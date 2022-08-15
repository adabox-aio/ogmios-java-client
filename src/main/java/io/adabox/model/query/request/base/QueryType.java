package io.adabox.model.query.request.base;

public enum QueryType {

    BLOCK_HEIGHT("blockHeight"),
    CHAIN_TIP("chainTip"),
    CURRENT_EPOCH("currentEpoch"),
    CURRENT_PROTOCOL_PARAMETERS("currentProtocolParameters"),
    DELEGATIONS_AND_REWARDS("delegationsAndRewards"),
    GENESIS_CONFIG("genesisConfig"),
    LEDGER_TIP("ledgerTip"),
    UTXO("utxo");

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
