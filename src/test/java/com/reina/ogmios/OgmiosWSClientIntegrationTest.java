package com.reina.ogmios;

import com.reina.ogmios.model.query.response.GenesisConfig;
import com.reina.ogmios.model.query.response.LedgerTip;
import com.reina.ogmios.model.query.response.UtxoByAddress;
import com.reina.ogmios.model.tx.response.SubmitTxResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OgmiosWSClientIntegrationTest {

    private OgmiosWSClient ogmiosWSClient;

    @BeforeAll
    void initiateOgmiosClient() throws InterruptedException, URISyntaxException {
        ogmiosWSClient = new OgmiosWSClient(new URI("ws://127.0.0.1:1337/"));
        ogmiosWSClient.connectBlocking(30, TimeUnit.SECONDS);
    }

    @Test
    void ledgerTipTest() {
        LedgerTip ledgerTip = ogmiosWSClient.ledgerTip();
        log.info(ledgerTip.toString());
        Assertions.assertNotNull(ledgerTip);
    }

    @Test
    void utxoByAddressTest() {
        UtxoByAddress utxoByAddress = ogmiosWSClient.utxoByAddress("addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n");
        log.info(utxoByAddress.toString());
        Assertions.assertNotNull(utxoByAddress);
    }

    @Test
    void genesisConfig() {
        GenesisConfig genesisConfig = ogmiosWSClient.genesisConfig();
        log.info(genesisConfig.toString());
        Assertions.assertNotNull(genesisConfig);
    }

    @Test
    void submitTransaction() {
        String txHash = "g6QAgYJYIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGCglg5AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBGgAehICCWDkBAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIaAHgXXAIaAAH6pAMZHkahAIGCWCABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhA169grjPSrzUUEcFEXHlZBSaZC/pzy7NzK1TvMi2qFC5ohAI0EPi+PBbpvVIHbyuza/ON/gNKnwRljp9WGXq4D/Y=";
        SubmitTxResponse submitTxResponse = ogmiosWSClient.submitTransaction(Base64.getDecoder().decode(txHash));
        log.info(submitTxResponse.toString());
        Assertions.assertNotNull(submitTxResponse);
    }

    @AfterAll
    void terminateOgmiosClient() throws InterruptedException {
        ogmiosWSClient.closeBlocking();
    }
}
