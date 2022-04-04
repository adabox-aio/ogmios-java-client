package io.adabox.model.query.response;

import io.adabox.model.query.ProtocolVersion;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CurrentProtocolParameters extends QueryResponse {

    private Integer maxCollateralInputs;
    private Long maxBlockBodySize;
    private String decentralizationParameter;
    private String monetaryExpansion;
    private Long maxValueSize;
    private CostModels costModels;
    private ExecutionUnit executionUnitPerBlock;
    private Long minPoolCost;
    private Long maxBlockHeaderSize;
    private Long poolRetirementEpochBound;
    private Long coinsPerUtxoWord;
    private Long collateralPercentage;
    private Long minFeeCoefficient;
    private Long poolDeposit;
    private String poolInfluence;
    private Long maxTxSize;
    private String extraEntropy;
    private String treasuryExpansion;
    private ProtocolVersion protocolVersion;
    private Long stakeKeyDeposit;
    private Prices prices;
    private Long minFeeConstant;
    private Long desiredNumberOfPools;
    private ExecutionUnit maxExecutionUnitsPerTransaction;

    public CurrentProtocolParameters(long msgId) {
        super(msgId);
    }

    public static CurrentProtocolParameters deserialize(JSONObject reflection, JSONObject jsonObject) {
        CurrentProtocolParameters currentProtocolParameters = new CurrentProtocolParameters(reflection.getLong("msg_id"));
        if (jsonObject.has("maxCollateralInputs")) {
            currentProtocolParameters.setMaxCollateralInputs(jsonObject.getInt("maxCollateralInputs"));
        }
        if (jsonObject.has("maxBlockBodySize")) {
            currentProtocolParameters.setMaxBlockBodySize(jsonObject.getLong("maxBlockBodySize"));
        }
        if (jsonObject.has("decentralizationParameter")) {
            currentProtocolParameters.setDecentralizationParameter(jsonObject.getString("decentralizationParameter"));
        }
        if (jsonObject.has("monetaryExpansion")) {
            currentProtocolParameters.setMonetaryExpansion(jsonObject.getString("monetaryExpansion"));
        }
        if (jsonObject.has("maxValueSize")) {
            currentProtocolParameters.setMaxValueSize(jsonObject.getLong("maxValueSize"));
        }
        if (jsonObject.has("costModels")) {
            currentProtocolParameters.setCostModels(CostModels.deserialize(jsonObject.getJSONObject("costModels")));
        }
        if (jsonObject.has("executionUnitPerBlock")) {
            currentProtocolParameters.setExecutionUnitPerBlock(ExecutionUnit.deserialize(jsonObject.getJSONObject("executionUnitPerBlock")));
        }
        if (jsonObject.has("minPoolCost")) {
            currentProtocolParameters.setMinPoolCost(jsonObject.getLong("minPoolCost"));
        }
        if (jsonObject.has("maxBlockHeaderSize")) {
            currentProtocolParameters.setMaxBlockHeaderSize(jsonObject.getLong("maxBlockHeaderSize"));
        }
        if (jsonObject.has("poolRetirementEpochBound")) {
            currentProtocolParameters.setPoolRetirementEpochBound(jsonObject.getLong("poolRetirementEpochBound"));
        }
        if (jsonObject.has("coinsPerUtxoWord")) {
            currentProtocolParameters.setCoinsPerUtxoWord(jsonObject.getLong("coinsPerUtxoWord"));
        }
        if (jsonObject.has("collateralPercentage")) {
            currentProtocolParameters.setCollateralPercentage(jsonObject.getLong("collateralPercentage"));
        }
        if (jsonObject.has("minFeeCoefficient")) {
            currentProtocolParameters.setMinFeeCoefficient(jsonObject.getLong("minFeeCoefficient"));
        }
        if (jsonObject.has("poolDeposit")) {
            currentProtocolParameters.setPoolDeposit(jsonObject.getLong("poolDeposit"));
        }
        if (jsonObject.has("poolInfluence")) {
            currentProtocolParameters.setPoolInfluence(jsonObject.getString("poolInfluence"));
        }
        if (jsonObject.has("maxTxSize")) {
            currentProtocolParameters.setMaxTxSize(jsonObject.getLong("maxTxSize"));
        }
        if (jsonObject.has("extraEntropy")) {
            currentProtocolParameters.setExtraEntropy(jsonObject.getString("extraEntropy"));
        }
        if (jsonObject.has("treasuryExpansion")) {
            currentProtocolParameters.setTreasuryExpansion(jsonObject.getString("treasuryExpansion"));
        }
        if (jsonObject.has("protocolVersion")) {
            currentProtocolParameters.setProtocolVersion(ProtocolVersion.deserialize(jsonObject.getJSONObject("protocolVersion")));
        }
        if (jsonObject.has("stakeKeyDeposit")) {
            currentProtocolParameters.setStakeKeyDeposit(jsonObject.getLong("stakeKeyDeposit"));
        }
        if (jsonObject.has("prices")) {
            currentProtocolParameters.setPrices(Prices.deserialize(jsonObject.getJSONObject("prices")));
        }
        if (jsonObject.has("minFeeConstant")) {
            currentProtocolParameters.setMinFeeConstant(jsonObject.getLong("minFeeConstant"));
        }
        if (jsonObject.has("desiredNumberOfPools")) {
            currentProtocolParameters.setDesiredNumberOfPools(jsonObject.getLong("desiredNumberOfPools"));
        }
        if (jsonObject.has("maxExecutionUnitsPerTransaction")) {
            currentProtocolParameters.setMaxExecutionUnitsPerTransaction(ExecutionUnit.deserialize(jsonObject.getJSONObject("maxExecutionUnitsPerTransaction")));
        }
        return currentProtocolParameters;
    }
}
