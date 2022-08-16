package io.adabox;

import io.adabox.client.OgmiosWSClient;
import io.adabox.model.query.response.*;
import io.adabox.model.tx.response.EvaluateTxResponse;
import io.adabox.model.tx.response.SubmitTxResponse;
import io.adabox.util.HexUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import javax.net.ssl.SSLSocketFactory;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OgmiosWSClientIntegrationTest {

    private OgmiosWSClient ogmiosTestnetClient;
    private OgmiosWSClient ogmiosMainnetClient;

    @BeforeAll
    void initiateOgmiosClient() throws InterruptedException, URISyntaxException {
        ogmiosTestnetClient = new OgmiosWSClient(new URI("wss://ogmios-api.testnet.dandelion.link/"));
        ogmiosTestnetClient.setSocketFactory(SSLSocketFactory.getDefault());
        ogmiosTestnetClient.connectBlocking(60, TimeUnit.SECONDS);
        ogmiosMainnetClient = new OgmiosWSClient(new URI("wss://ogmios-api.mainnet.dandelion.link/"));
        ogmiosMainnetClient.setSocketFactory(SSLSocketFactory.getDefault());
        ogmiosMainnetClient.connectBlocking(60, TimeUnit.SECONDS);
    }

    @Test
    void blockHeightTest() {
        BlockHeight blockHeight = ogmiosTestnetClient.blockHeight();
        log.info(blockHeight.toString());
        Assertions.assertNotNull(blockHeight);
    }

    @Test
    void chainTipTest() {
        ChainTip chainTip = ogmiosTestnetClient.chainTip();
        log.info(chainTip.toString());
        Assertions.assertNotNull(chainTip);
    }

    @Test
    void currentEpochTest() {
        CurrentEpoch currentEpoch = ogmiosTestnetClient.currentEpoch();
        log.info(currentEpoch.toString());
        Assertions.assertNotNull(currentEpoch);
    }

    @Test
    void currentProtocolParametersTest() {
        CurrentProtocolParameters currentProtocolParameters = ogmiosTestnetClient.currentProtocolParameters();
        log.info(currentProtocolParameters.toString());
        Assertions.assertNotNull(currentProtocolParameters);
        Assertions.assertNotNull(currentProtocolParameters.getProtocolParameters());
        Assertions.assertEquals(currentProtocolParameters.getProtocolParameters().getPoolDeposit(),"500000000");
        Assertions.assertEquals(currentProtocolParameters.getProtocolParameters().getCoinsPerUtxoByte(), "4310");
        Assertions.assertNotNull(currentProtocolParameters.getProtocolParameters().getPoolRetirementEpochBound());
        Assertions.assertNotNull(currentProtocolParameters.getProtocolParameters().getDesiredNumberOfPools());
    }

    @Test
    void delegationsAndRewardsTest() {
        List<String> credentials = List.of("7c16240714ea0e12b41a914f2945784ac494bb19573f0ca61a08afa8");
        DelegationsAndRewards delegationsAndRewards = ogmiosTestnetClient.delegationsAndRewards(credentials);
        log.info(delegationsAndRewards.toString());
        Assertions.assertNotNull(delegationsAndRewards);
        Assertions.assertNotNull(delegationsAndRewards.getDelegationAndRewardMap());
    }

    @Test
    void eraStartTest() {
        EraStart eraStart = ogmiosTestnetClient.eraStart();
        log.info(eraStart.toString());
        Assertions.assertNotNull(eraStart);
    }

    @Test
    void eraSummariesTest() {
        EraSummaries eraSummaries = ogmiosTestnetClient.eraSummaries();
        log.info(eraSummaries.toString());
        Assertions.assertNotNull(eraSummaries);
    }

    @Test
    void genesisConfig() {
        GenesisConfig genesisConfig = ogmiosTestnetClient.genesisConfig();
        log.info(genesisConfig.toString());
        Assertions.assertNotNull(genesisConfig);
    }

    @Test
    void ledgerTipTest() {
        LedgerTip ledgerTip = ogmiosTestnetClient.ledgerTip();
        log.info(ledgerTip.toString());
        Assertions.assertNotNull(ledgerTip);
    }

    @Test
    void nonMyopicMemberRewardsByCredentialsTest() {
        List<String> credentials = List.of("7c16240714ea0e12b41a914f2945784ac494bb19573f0ca61a08afa8");
        NonMyopicMemberRewards nonMyopicMemberRewards = ogmiosTestnetClient.nonMyopicMemberRewardsByCredentials(credentials);
        log.info(nonMyopicMemberRewards.toString());
        Assertions.assertNotNull(nonMyopicMemberRewards);
        Assertions.assertNotNull(nonMyopicMemberRewards.getNonMyopicMemberRewardsMap());
    }

    @Test
    void nonMyopicMemberRewardsByAmountsTest() {
        List<Integer> amounts = List.of(42000000);
        NonMyopicMemberRewards nonMyopicMemberRewards = ogmiosTestnetClient.nonMyopicMemberRewardsByAmounts(amounts);
        log.info(nonMyopicMemberRewards.toString());
        Assertions.assertNotNull(nonMyopicMemberRewards);
        Assertions.assertNotNull(nonMyopicMemberRewards.getNonMyopicMemberRewardsMap());
    }

    @Test
    void poolIdsTest() {
        PoolIds poolIds = ogmiosTestnetClient.poolIds();
        log.info(poolIds.toString());
        Assertions.assertNotNull(poolIds);
    }

    @Test
    void poolParametersTest() {
        List<String> poolIds = List.of("pool1rcsezjrma577f06yp40lsz76uvwh7gne35afx3zrq2ktx50f8t8");
        PoolParameters poolParameters = ogmiosTestnetClient.poolParameters(poolIds);
        log.info(poolParameters.toString());
        Assertions.assertNotNull(poolParameters);
        Assertions.assertNotNull(poolParameters.getPoolParametersMap());
    }

    @Test
    void poolsRankingTest() {
        PoolsRanking poolsRanking = ogmiosTestnetClient.poolsRanking();
        log.info(poolsRanking.toString());
        Assertions.assertNotNull(poolsRanking);
    }

    @Test
    void proposedProtocolParametersTest() {
        ProposedProtocolParameters proposedProtocolParameters = ogmiosTestnetClient.proposedProtocolParameters();
        log.info(proposedProtocolParameters.toString());
        Assertions.assertNotNull(proposedProtocolParameters);
    }

    @Test
    void rewardsProvenanceTest() {
        RewardsProvenance rewardsProvenance = ogmiosTestnetClient.rewardsProvenance();
        log.info(rewardsProvenance.toString());
        Assertions.assertNotNull(rewardsProvenance);
    }

    @Test
    void systemStartTest() {
        SystemStart systemStart = ogmiosTestnetClient.systemStart();
        log.info(systemStart.toString());
        Assertions.assertNotNull(systemStart);
    }

    @Test
    void utxoByAddressTest() {
        UtxoByAddress utxoByAddress = ogmiosTestnetClient.utxoByAddress("addr_test1qz0xcyfuwkf6a2c8g0mhjdaxxvtuw2u04dqjx7tt2gwaq5522z65y7wauh6rryspdn7xrg5u7nkf5ung6qk5dn3a7u8syvce7n");
        log.info(utxoByAddress.toString());
        Assertions.assertNotNull(utxoByAddress);
    }

    @Test
    void submitTransaction() {
        String txHash = "g6QAgYJYIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGCglg5AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBGgAehICCWDkBAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIaAHgXXAIaAAH6pAMZHkahAIGCWCABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhA169grjPSrzUUEcFEXHlZBSaZC/pzy7NzK1TvMi2qFC5ohAI0EPi+PBbpvVIHbyuza/ON/gNKnwRljp9WGXq4D/Y=";
        SubmitTxResponse submitTxResponse = ogmiosTestnetClient.submitTx(Base64.getDecoder().decode(txHash));
        log.info(submitTxResponse.toString());
        Assertions.assertNotNull(submitTxResponse);
    }

    @Test
    void evaluateTx() {
        String txHex = "84a500828258208e4dc84c4afc5181b9cc50dfb5e500fd41b37e09415b4bf88ac678f4cfbe3eed00825820a404b56fb13edb31357a308b74e64e167e47b98fc6f8b2f9eb41fc68b55a9ec7000184825839005154f7a46e7fe9eb003e6a1a5a184685dbec77fa336c9f1abcf5c5e601b135a188a0e114739809762b650a2ca5ea8f20060d867bcca39a181a001e8480825839000a9d5c5c76c01cc425b95e250d6883d8ffc005fce89f15322671ece3e8f30e7017bf879fc159b7a5b57729fce3809157de14d21a32a347551a003d0900825839006d80ab5fafa4a486b81b7e599e22dcdc7a8061d560da3b49766005e907834bbc597fd787352df85dd541913f150a449be6d475884d1ebf5d1a001e8480825839006d80ab5fafa4a486b81b7e599e22dcdc7a8061d560da3b49766005e907834bbc597fd787352df85dd541913f150a449be6d475884d1ebf5d1a004300f3021a00094a4d0b582051468fbecc8719f8fbbe71f2e5b3aa54fb177dcacc6fe9909c7b9f05c8c4a3ba0d818258208e4dc84c4afc5181b9cc50dfb5e500fd41b37e09415b4bf88ac678f4cfbe3eed00a40081825820456fb7fa9e644f2c41aed8f4e87f2cdae67492e073c114b2c922b9ba4eef590758401d54335b4426b002ec31807c01ed49cf904b39818fc1d78e1f8ce8fb044ca92621680db9bc2397a738fca70ada0641c8014873b2c9f7a41605d81b9263181e070381590a15590a120100003323322332232323332223233322232333333332222222232333222323333222232323322323332223233322232323322332232323333322222332233223322332233223322223223223232533530333330083333573466e1cd55cea8032400046eb4d5d09aab9e500723504935304a335738921035054310004b499263333573466e1cd55cea8022400046eb4d5d09aab9e500523504935304a3357389201035054310004b499263333573466e1cd55cea8012400046601664646464646464646464646666ae68cdc39aab9d500a480008cccccccccc064cd409c8c8c8cccd5cd19b8735573aa004900011980f981d1aba15002302c357426ae8940088d4164d4c168cd5ce249035054310005b49926135573ca00226ea8004d5d0a80519a8138141aba150093335502e75ca05a6ae854020ccd540b9d728169aba1500733502704335742a00c66a04e66aa0a8098eb4d5d0a8029919191999ab9a3370e6aae754009200023350213232323333573466e1cd55cea80124000466a05266a084eb4d5d0a80118239aba135744a00446a0ba6a60bc66ae712401035054310005f49926135573ca00226ea8004d5d0a8011919191999ab9a3370e6aae7540092000233502733504275a6ae854008c11cd5d09aba2500223505d35305e3357389201035054310005f49926135573ca00226ea8004d5d09aba2500223505935305a3357389201035054310005b49926135573ca00226ea8004d5d0a80219a813bae35742a00666a04e66aa0a8eb88004d5d0a801181c9aba135744a00446a0aa6a60ac66ae71241035054310005749926135744a00226ae8940044d5d1280089aba25001135744a00226ae8940044d5d1280089aba25001135573ca00226ea8004d5d0a8011919191999ab9a3370ea00290031180f181d9aba135573ca00646666ae68cdc3a801240084603a608a6ae84d55cf280211999ab9a3370ea00690011180e98181aba135573ca00a46666ae68cdc3a80224000460406eb8d5d09aab9e50062350503530513357389201035054310005249926499264984d55cea80089baa001357426ae8940088d4124d4c128cd5ce249035054310004b49926104a1350483530493357389201035054350004a4984d55cf280089baa0011375400226ea80048848cc00400c0088004888888888848cccccccccc00402c02802402001c01801401000c00880048848cc00400c008800448848cc00400c0084800448848cc00400c0084800448848cc00400c00848004848888c010014848888c00c014848888c008014848888c004014800448c88c008dd6000990009aa81a111999aab9f0012500e233500d30043574200460066ae880080cc8c8c8c8cccd5cd19b8735573aa006900011998039919191999ab9a3370e6aae754009200023300d303135742a00466a02605a6ae84d5d1280111a81b1a981b99ab9c491035054310003849926135573ca00226ea8004d5d0a801999aa805bae500a35742a00466a01eeb8d5d09aba25002235032353033335738921035054310003449926135744a00226aae7940044dd50009110919980080200180110009109198008018011000899aa800bae75a224464460046eac004c8004d540b888c8cccd55cf80112804919a80419aa81898031aab9d5002300535573ca00460086ae8800c0b84d5d08008891001091091198008020018900089119191999ab9a3370ea002900011a80418029aba135573ca00646666ae68cdc3a801240044a01046a0526a605466ae712401035054310002b499264984d55cea80089baa001121223002003112200112001232323333573466e1cd55cea8012400046600c600e6ae854008dd69aba135744a00446a0466a604866ae71241035054310002549926135573ca00226ea80048848cc00400c00880048c8cccd5cd19b8735573aa002900011bae357426aae7940088d407cd4c080cd5ce24810350543100021499261375400224464646666ae68cdc3a800a40084a00e46666ae68cdc3a8012400446a014600c6ae84d55cf280211999ab9a3370ea00690001280511a8111a981199ab9c490103505431000244992649926135573aa00226ea8004484888c00c0104488800844888004480048c8cccd5cd19b8750014800880188cccd5cd19b8750024800080188d4068d4c06ccd5ce249035054310001c499264984d55ce9baa0011220021220012001232323232323333573466e1d4005200c200b23333573466e1d4009200a200d23333573466e1d400d200823300b375c6ae854014dd69aba135744a00a46666ae68cdc3a8022400c46601a6eb8d5d0a8039bae357426ae89401c8cccd5cd19b875005480108cc048c050d5d0a8049bae357426ae8940248cccd5cd19b875006480088c050c054d5d09aab9e500b23333573466e1d401d2000230133016357426aae7940308d407cd4c080cd5ce2481035054310002149926499264992649926135573aa00826aae79400c4d55cf280109aab9e500113754002424444444600e01044244444446600c012010424444444600a010244444440082444444400644244444446600401201044244444446600201201040024646464646666ae68cdc3a800a400446660106eb4d5d0a8021bad35742a0066eb4d5d09aba2500323333573466e1d400920002300a300b357426aae7940188d4040d4c044cd5ce2490350543100012499264984d55cea80189aba25001135573ca00226ea80048488c00800c888488ccc00401401000c80048c8c8cccd5cd19b875001480088c018dd71aba135573ca00646666ae68cdc3a80124000460106eb8d5d09aab9e500423500a35300b3357389201035054310000c499264984d55cea80089baa001212230020032122300100320011122232323333573466e1cd55cea80124000466aa016600c6ae854008c014d5d09aba25002235007353008335738921035054310000949926135573ca00226ea8004498480048004448848cc00400c008448004448c8c00400488cc00cc008008004ccc888c8c8ccc888ccc888cccccccc88888888cc88ccccc88888cccc8888cc88cc88cc88ccc888cc88cc88ccc888cc88cc88cc88cc88888cc894cd4c0e4008400440e8ccd40d540d800d205433350355036002481508848cc00400c0088004888888888848cccccccccc00402c02802402001c01801401000c00880048848cc00400c008800488848ccc00401000c00880044488008488488cc00401000c48004448848cc00400c0084480048848cc00400c008800448488c00800c44880044800448848cc00400c0084800448848cc00400c0084800448848cc00400c00848004484888c00c010448880084488800448004848888c010014848888c00c014848888c008014848888c00401480048848cc00400c0088004848888888c01c0208848888888cc018024020848888888c014020488888880104888888800c8848888888cc0080240208848888888cc00402402080048488c00800c888488ccc00401401000c80048488c00800c8488c00400c800448004488ccd5cd19b870020010050041220021220012001010481d8799f182aff0581840001d8799f182aff821a00475d541a259aa72ef5f6";
        byte[] cborBytes = HexUtil.decodeHexString(txHex);
        EvaluateTxResponse evaluateTxResponse = ogmiosTestnetClient.evaluateTx(cborBytes);
        log.info(evaluateTxResponse.toString());
        Assertions.assertNotNull(evaluateTxResponse);
        Assertions.assertNotNull(evaluateTxResponse.getEvaluationFailure());
        Assertions.assertNotNull(evaluateTxResponse.getEvaluationResults());
    }

    @AfterAll
    void terminateOgmiosClient() throws InterruptedException {
        ogmiosTestnetClient.closeBlocking();
        ogmiosMainnetClient.closeBlocking();
    }
}
