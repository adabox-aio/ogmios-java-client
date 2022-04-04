package io.adabox.model.query;

import lombok.Data;
import org.json.JSONObject;

@Data
public class ProtocolParameters {

    private Long maxBlockBodySize;
    private String decentralizationParameter;
    private String monetaryExpansion;
    private Long minPoolCost;
    private Long maxBlockHeaderSize;
    private Long poolRetirementEpochBound;
    private Long minFeeCoefficient;
    private Long poolDeposit;
    private String poolInfluence;
    private Long maxTxSize;
    private String extraEntropy;
    private Long minUtxoValue;
    private String treasuryExpansion;
    private ProtocolVersion protocolVersion;
    private Long stakeKeyDeposit;
    private Long minFeeConstant;
    private Long desiredNumberOfPools;

    public static ProtocolParameters deserialize(JSONObject jsonObject) {
        ProtocolParameters protocolParameters = new ProtocolParameters();
        if (jsonObject.has("maxBlockBodySize")) {
            protocolParameters.setMaxBlockBodySize(jsonObject.getLong("maxBlockBodySize"));
        }
        if (jsonObject.has("decentralizationParameter")) {
            protocolParameters.setDecentralizationParameter(jsonObject.getString("decentralizationParameter"));
        }
        if (jsonObject.has("monetaryExpansion")) {
            protocolParameters.setMonetaryExpansion(jsonObject.getString("monetaryExpansion"));
        }
        if (jsonObject.has("minPoolCost")) {
            protocolParameters.setMinPoolCost(jsonObject.getLong("minPoolCost"));
        }
        if (jsonObject.has("maxBlockHeaderSize")) {
            protocolParameters.setMaxBlockHeaderSize(jsonObject.getLong("maxBlockHeaderSize"));
        }
        if (jsonObject.has("poolRetirementEpochBound")) {
            protocolParameters.setPoolRetirementEpochBound(jsonObject.getLong("poolRetirementEpochBound"));
        }
        if (jsonObject.has("minFeeCoefficient")) {
            protocolParameters.setMinFeeCoefficient(jsonObject.getLong("minFeeCoefficient"));
        }
        if (jsonObject.has("poolDeposit")) {
            protocolParameters.setPoolDeposit(jsonObject.getLong("poolDeposit"));
        }
        if (jsonObject.has("poolInfluence")) {
            protocolParameters.setPoolInfluence(jsonObject.getString("poolInfluence"));
        }
        if (jsonObject.has("maxTxSize")) {
            protocolParameters.setMaxTxSize(jsonObject.getLong("maxTxSize"));
        }
        if (jsonObject.has("extraEntropy")) {
            protocolParameters.setExtraEntropy(jsonObject.getString("extraEntropy"));
        }
        if (jsonObject.has("minUtxoValue")) {
            protocolParameters.setMinUtxoValue(jsonObject.getLong("minUtxoValue"));
        }
        if (jsonObject.has("treasuryExpansion")) {
            protocolParameters.setTreasuryExpansion(jsonObject.getString("treasuryExpansion"));
        }
        if (jsonObject.has("protocolVersion")) {
            protocolParameters.setProtocolVersion(ProtocolVersion.deserialize(jsonObject.getJSONObject("protocolVersion")));
        }
        if (jsonObject.has("stakeKeyDeposit")) {
            protocolParameters.setStakeKeyDeposit(jsonObject.getLong("stakeKeyDeposit"));
        }
        if (jsonObject.has("minFeeConstant")) {
            protocolParameters.setMinFeeConstant(jsonObject.getLong("minFeeConstant"));
        }
        if (jsonObject.has("desiredNumberOfPools")) {
            protocolParameters.setDesiredNumberOfPools(jsonObject.getLong("desiredNumberOfPools"));
        }
        return protocolParameters;
    }
}
