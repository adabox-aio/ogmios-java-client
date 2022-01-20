package com.reina.ogmios.model.base.iface;

import com.reina.ogmios.model.query.response.*;

import java.security.InvalidParameterException;

public interface LocalStateQuery {

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
     * @return {@link LedgerTip}
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
