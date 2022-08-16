package io.adabox.model.base.iface;

import io.adabox.model.query.response.*;
import io.adabox.model.query.response.models.PointOrOrigin;

import java.security.InvalidParameterException;
import java.util.List;

public interface LocalStateQuery {

    /**
     * The chain’s highest block number.
     *
     * @return {@link BlockHeight}
     */
    BlockHeight blockHeight();

    /**
     * The chain’s current tip.
     *
     * @return {@link ChainTip}
     */
    ChainTip chainTip();

    /**
     * Get the current Epoch.
     *
     * @return {@link CurrentEpoch}
     */
    CurrentEpoch currentEpoch();

    /**
     * Get the current Protocol Parameters.
     *
     * @return {@link CurrentProtocolParameters}
     */
    CurrentProtocolParameters currentProtocolParameters();

    /**
     * Current delegation settings and rewards of given reward accounts.
     *
     * @param credentials List of A Blake2b 28-byte digest of a verification key or a script.
     * @return {@link DelegationsAndRewards}
     */
    DelegationsAndRewards delegationsAndRewards(List<String> credentials);

    /**
     * The information regarding the beginning of the current era.
     *
     * @return {@link EraStart}
     */
    EraStart eraStart();

    /**
     * Era bounds and slotting parameters details, required for proper slot arithmetic.
     *
     * @return {@link EraSummaries}
     */
    EraSummaries eraSummaries();

    /**
     * Get the Shelley's genesis configuration.
     *
     * @return {@link GenesisConfig}
     */
    GenesisConfig genesisConfig();

    /**
     * Get the current ledger tip. Will resolve the acquired point if any.
     *
     * @return {@link PointOrOrigin}
     */
    LedgerTip ledgerTip();

    /**
     * Rewards that can be expected assuming a pool is fully saturated. Such rewards are said non-myopic,
     * in opposition to short-sighted rewards looking at immediate benefits. Keys of the map can be either Lovelace
     * amounts or account credentials depending on the query.
     *
     * @param credentials List of A Blake2b 28-byte digest of a verification key or a script.
     * @return {@link NonMyopicMemberRewards}
     */
    NonMyopicMemberRewards nonMyopicMemberRewardsByCredentials(List<String> credentials);

    /**
     * Rewards that can be expected assuming a pool is fully saturated. Such rewards are said non-myopic,
     * in opposition to short-sighted rewards looking at immediate benefits. Keys of the map can be either Lovelace
     * amounts or account credentials depending on the query.
     *
     * @param amounts List of lovelace amounts.
     * @return {@link NonMyopicMemberRewards}
     */
    NonMyopicMemberRewards nonMyopicMemberRewardsByAmounts(List<Integer> amounts);

    /**
     * The chain's start time (UTC).
     * @return {@link SystemStart}
     */
    SystemStart systemStart();

    /**
     * Queries the Utxo associated with some Address.
     *
     * @param address Wallet Address
     * @return {@link UtxoByAddress}
     */
    UtxoByAddress utxoByAddress(String address) throws InvalidParameterException;
}
