package com.reina.ogmios.model.query;

import lombok.Data;
import org.json.JSONObject;

@Data
public class ProtocolParameters {

    private long maxBlockBodySize;
    private String decentralizationParameter;
    private String monetaryExpansion;
    private long minPoolCost;
    private long maxBlockHeaderSize;
    private long poolRetirementEpochBound;
    private long minFeeCoefficient;
    private long poolDeposit;
    private String poolInfluence;
    private long maxTxSize;
    private String extraEntropy;
    private long minUtxoValue;
    private String treasuryExpansion;
    private ProtocolVersion protocolVersion;
    private long stakeKeyDeposit;
    private long minFeeConstant;
    private long desiredNumberOfPools;

    public static ProtocolParameters deserialize(JSONObject protocolParams) {
        ProtocolParameters protocolParameters = new ProtocolParameters();
        protocolParameters.setMaxBlockBodySize(protocolParams.getLong("maxBlockBodySize"));
        protocolParameters.setDecentralizationParameter(protocolParams.getString("decentralizationParameter"));
        protocolParameters.setMonetaryExpansion(protocolParams.getString("monetaryExpansion"));
        protocolParameters.setMinPoolCost(protocolParams.getLong("minPoolCost"));
        protocolParameters.setMaxBlockHeaderSize(protocolParams.getLong("maxBlockHeaderSize"));
        protocolParameters.setPoolRetirementEpochBound(protocolParams.getLong("poolRetirementEpochBound"));
        protocolParameters.setMinFeeCoefficient(protocolParams.getLong("minFeeCoefficient"));
        protocolParameters.setPoolDeposit(protocolParams.getLong("poolDeposit"));
        protocolParameters.setPoolInfluence(protocolParams.getString("poolInfluence"));
        protocolParameters.setMaxTxSize(protocolParams.getLong("maxTxSize"));
        protocolParameters.setExtraEntropy(protocolParams.getString("extraEntropy"));
        protocolParameters.setMinUtxoValue(protocolParams.getLong("minUtxoValue"));
        protocolParameters.setTreasuryExpansion(protocolParams.getString("treasuryExpansion"));
        protocolParameters.setProtocolVersion(ProtocolVersion.deserialize(protocolParams.getJSONObject("protocolVersion")));
        protocolParameters.setStakeKeyDeposit(protocolParams.getLong("stakeKeyDeposit"));
        protocolParameters.setMinFeeConstant(protocolParams.getLong("minFeeConstant"));
        protocolParameters.setDesiredNumberOfPools(protocolParams.getLong("desiredNumberOfPools"));
        return protocolParameters;
    }
}
