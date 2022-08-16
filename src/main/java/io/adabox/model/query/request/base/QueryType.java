package io.adabox.model.query.request.base;

public enum QueryType {

    BLOCK_HEIGHT("blockHeight"),
    CHAIN_TIP("chainTip"),
    CURRENT_EPOCH("currentEpoch"),
    CURRENT_PROTOCOL_PARAMETERS("currentProtocolParameters"),
    DELEGATIONS_AND_REWARDS("delegationsAndRewards"),
    ERA_START("eraStart"),
    ERA_SUMMARIES("eraSummaries"),
    GENESIS_CONFIG("genesisConfig"),
    LEDGER_TIP("ledgerTip"),
    NON_MYOPIC_MEMBER_REWARDS("nonMyopicMemberRewards"),
    POOL_IDS("poolIds"),
    POOL_PARAMETERS("poolParameters"),
    SYSTEM_START("systemStart"),
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
