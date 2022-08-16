package io.adabox.model.query.response.base;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.base.Response;
import io.adabox.model.query.request.base.QueryType;
import io.adabox.model.query.response.*;

import java.util.Objects;

public class QueryResponse extends Response {

    public QueryResponse(long msgId) {
        super(msgId);
    }

    public static QueryResponse parse(QueryType queryType, long msgId, JsonNode jsonNode) {
        switch (Objects.requireNonNull(queryType)) {
            case BLOCK_HEIGHT:
                return BlockHeight.deserialize(msgId, jsonNode);
            case CHAIN_TIP:
                return ChainTip.deserialize(msgId, jsonNode);
            case CURRENT_EPOCH:
                return CurrentEpoch.deserialize(msgId, jsonNode);
            case CURRENT_PROTOCOL_PARAMETERS:
                return CurrentProtocolParameters.deserialize(msgId, jsonNode);
            case DELEGATIONS_AND_REWARDS:
                return DelegationsAndRewards.deserialize(msgId, jsonNode);
            case ERA_START:
                return EraStart.deserialize(msgId, jsonNode);
            case ERA_SUMMARIES:
                return EraSummaries.deserialize(msgId, jsonNode);
            case GENESIS_CONFIG:
                return GenesisConfig.deserialize(msgId, jsonNode);
            case LEDGER_TIP:
                return LedgerTip.deserialize(msgId, jsonNode);
            case NON_MYOPIC_MEMBER_REWARDS:
                return NonMyopicMemberRewards.deserialize(msgId, jsonNode);
            case POOL_IDS:
                return PoolIds.deserialize(msgId, jsonNode);
            case POOL_PARAMETERS:
                return PoolParameters.deserialize(msgId, jsonNode);
            case PROPOSED_PROTOCOL_PARAMETERS:
                return ProposedProtocolParameters.deserialize(msgId, jsonNode);
            case SYSTEM_START:
                return SystemStart.deserialize(msgId, jsonNode);
            case UTXO:
                return UtxoByAddress.deserialize(msgId, jsonNode);
        }
        return null;
    }
}
