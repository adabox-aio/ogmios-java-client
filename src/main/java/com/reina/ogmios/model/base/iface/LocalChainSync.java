package com.reina.ogmios.model.base.iface;

import com.reina.ogmios.model.chain.response.AcquireResponse;
import com.reina.ogmios.model.chain.response.RequestNextResponse;

public interface LocalChainSync {

    /**
     * Acquire a point on chain from which run queries.
     *
     * @param point Points of interest as block hash
     * @return {@link AcquireResponse}
     */
    AcquireResponse acquire(String point);

    /**
     * Request next block from the current cardano-node's cursor.
     *
     * @return {@link RequestNextResponse}
     */
    RequestNextResponse requestNext();
}
