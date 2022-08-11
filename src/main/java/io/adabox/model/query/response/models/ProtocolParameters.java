package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProtocolParameters {

    private Integer minFeeCoefficient;
    private Integer minFeeConstant;
    private Integer maxBlockBodySize;
    private Integer maxBlockHeaderSize;
    private Integer maxTxSize;
    private String stakeKeyDeposit;
    private String poolDeposit;
    private Integer poolRetirementEpochBound;
    private Integer desiredNumberOfPools;
    private String poolInfluence;
    private String monetaryExpansion;
    private String treasuryExpansion;
    private String decentralizationParameter;
    private String extraEntropy;
    private ProtocolVersion protocolVersion;
    private String minUtxoValue;
    private String minPoolCost;
    private String coinsPerUtxoWord;
    private String coinsPerUtxoByte;
    private CostModels costModels;
    private Prices prices;
    private ExecutionUnit maxExecutionUnitsPerTransaction;
    private ExecutionUnit maxExecutionUnitsPerBlock;
    private String maxValueSize;
    private BigDecimal collateralPercentage;
    private Integer maxCollateralInputs;

    public static ProtocolParameters deserialize(JsonNode jsonNode) {
        ProtocolParameters protocolParameters = new ProtocolParameters();
        if (jsonNode.has("minFeeCoefficient")) {
            protocolParameters.setMinFeeCoefficient(jsonNode.get("minFeeCoefficient").intValue());
        }
        if (jsonNode.has("minFeeConstant")) {
            protocolParameters.setMinFeeConstant(jsonNode.get("minFeeConstant").intValue());
        }
        if (jsonNode.has("maxBlockBodySize")) {
            protocolParameters.setMaxBlockBodySize(jsonNode.get("maxBlockBodySize").intValue());
        }
        if (jsonNode.has("maxBlockHeaderSize")) {
            protocolParameters.setMaxBlockHeaderSize(jsonNode.get("maxBlockHeaderSize").intValue());
        }
        if (jsonNode.has("maxTxSize")) {
            protocolParameters.setMaxTxSize(jsonNode.get("maxTxSize").intValue());
        }
        if (jsonNode.has("stakeKeyDeposit")) {
            protocolParameters.setStakeKeyDeposit(jsonNode.get("stakeKeyDeposit").asText());
        }
        if (jsonNode.has("poolDeposit")) {
            protocolParameters.setPoolDeposit(jsonNode.get("poolDeposit").asText());
        }
        if (jsonNode.has("poolRetirementEpochBound")) {
            protocolParameters.setPoolRetirementEpochBound(jsonNode.get("poolRetirementEpochBound").intValue());
        }
        if (jsonNode.has("desiredNumberOfPools")) {
            protocolParameters.setDesiredNumberOfPools(jsonNode.get("desiredNumberOfPools").intValue());
        }
        if (jsonNode.has("poolInfluence")) {
            protocolParameters.setPoolInfluence(jsonNode.get("poolInfluence").asText());
        }
        if (jsonNode.has("monetaryExpansion")) {
            protocolParameters.setMonetaryExpansion(jsonNode.get("monetaryExpansion").asText());
        }
        if (jsonNode.has("treasuryExpansion")) {
            protocolParameters.setTreasuryExpansion(jsonNode.get("treasuryExpansion").asText());
        }
        if (jsonNode.has("decentralizationParameter")) {
            protocolParameters.setDecentralizationParameter(jsonNode.get("decentralizationParameter").asText());
        }
        if (jsonNode.has("extraEntropy")) {
            protocolParameters.setExtraEntropy(jsonNode.get("extraEntropy").asText());
        }
        if (jsonNode.has("protocolVersion")) {
            protocolParameters.setProtocolVersion(ProtocolVersion.deserialize(jsonNode.get("protocolVersion")));
        }
        if (jsonNode.has("minUtxoValue")) {
            protocolParameters.setMinUtxoValue(jsonNode.get("minUtxoValue").asText());
        }
        if (jsonNode.has("minPoolCost")) {
            protocolParameters.setMinPoolCost(jsonNode.get("minPoolCost").asText());
        }
        if (jsonNode.has("coinsPerUtxoWord")) {
            protocolParameters.setCoinsPerUtxoWord(jsonNode.get("coinsPerUtxoWord").asText());
        }
        if (jsonNode.has("coinsPerUtxoByte")) {
            protocolParameters.setCoinsPerUtxoByte(jsonNode.get("coinsPerUtxoByte").asText());
        }
        if (jsonNode.has("costModels")) {
            protocolParameters.setCostModels(CostModels.deserialize(jsonNode.get("costModels")));
        }
        if (jsonNode.has("prices")) {
            protocolParameters.setPrices(Prices.deserialize(jsonNode.get("prices")));
        }
        if (jsonNode.has("maxExecutionUnitsPerTransaction")) {
            protocolParameters.setMaxExecutionUnitsPerTransaction(ExecutionUnit.deserialize(jsonNode.get("maxExecutionUnitsPerTransaction")));
        }
        if (jsonNode.has("maxExecutionUnitsPerBlock")) {
            protocolParameters.setMaxExecutionUnitsPerBlock(ExecutionUnit.deserialize(jsonNode.get("maxExecutionUnitsPerBlock")));
        }
        if (jsonNode.has("maxValueSize")) {
            protocolParameters.setMaxValueSize(jsonNode.get("maxValueSize").asText());
        }
        if (jsonNode.has("collateralPercentage")) {
            protocolParameters.setCollateralPercentage(jsonNode.get("collateralPercentage").decimalValue());
        }
        if (jsonNode.has("maxCollateralInputs")) {
            protocolParameters.setMaxCollateralInputs(jsonNode.get("maxCollateralInputs").intValue());
        }
        return protocolParameters;
    }
}
