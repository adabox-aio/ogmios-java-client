package io.adabox.model.base.iface;

import io.adabox.model.query.response.*;
import io.adabox.model.query.response.models.PointOrOrigin;

import java.security.InvalidParameterException;

public interface LocalStateQuery {

    /**
     * The chain’s highest block number.
     * @return {@link BlockHeight}
     */
    BlockHeight blockHeight();

    /**
     * The chain’s current tip.
     * @return {@link ChainTip}
     */
    ChainTip chainTip();

    /**
     * Get the current Epoch.
     * @return {@link CurrentEpoch}
     */
    CurrentEpoch currentEpoch();

    /**
     * Get the current Protocol Parameters.
     * @return {@link CurrentProtocolParameters}
     */
    CurrentProtocolParameters currentProtocolParameters();

    /**
     * Get the current ledger tip. Will resolve the acquired point if any.
     * @return {@link PointOrOrigin}
     */
    LedgerTip ledgerTip();

    /**
     * Queries the Utxo associated with some Address.
     * @param address Wallet Address
     * @return {@link UtxoByAddress}
     */
    UtxoByAddress utxoByAddress(String address) throws InvalidParameterException;

    /**
     * Get the Shelley's genesis configuration.
     * @return {@link GenesisConfig}
     */
    GenesisConfig genesisConfig();
}
