package com.reina.ogmios.model.base.iface;

import com.reina.ogmios.model.tx.response.SubmitTxResponse;

import java.security.InvalidParameterException;

public interface LocalTxSubmission {

    /**
     * Submit a signed and serialized Utxo transaction to the network.
     * @param cborData CBOR-serialized signed transaction, in base16/base64
     * @return {@link SubmitTxResponse}
     */
    SubmitTxResponse submitTransaction(byte[] cborData) throws InvalidParameterException;
}
