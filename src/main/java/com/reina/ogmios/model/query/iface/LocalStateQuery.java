package com.reina.ogmios.model.query.iface;

import com.reina.ogmios.model.query.response.GenesisConfig;
import com.reina.ogmios.model.query.response.LedgerTip;
import com.reina.ogmios.model.query.response.UtxoByAddress;

public interface LocalStateQuery {

    LedgerTip ledgerTip();

    UtxoByAddress utxoByAddress(String address);

    GenesisConfig genesisConfig();

}
