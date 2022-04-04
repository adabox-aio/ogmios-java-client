package io.adabox.model.query.response;

import io.adabox.model.query.ProtocolParameters;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

import java.math.BigInteger;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class GenesisConfig extends QueryResponse {

    private String activeSlotsCoefficient;
    private long updateQuorum;
    private long slotLength;
    private long maxKesEvolutions;
    private long slotsPerKesPeriod;
    private OffsetDateTime systemStart;
    private ProtocolParameters protocolParameters;
    private long epochLength;
    private long securityParameter;
    private BigInteger maxLovelaceSupply;
    private long networkMagic;
    private String network;

    public GenesisConfig(long msgId) {
        super(msgId);
    }

    public static GenesisConfig deserialize(JSONObject reflection, JSONObject result) {
        GenesisConfig genesisConfig = new GenesisConfig(reflection.getLong("msg_id"));
        genesisConfig.setActiveSlotsCoefficient(result.getString("activeSlotsCoefficient"));
        genesisConfig.setUpdateQuorum(result.getLong("updateQuorum"));
        genesisConfig.setSlotLength(result.getLong("slotLength"));
        genesisConfig.setMaxKesEvolutions(result.getLong("maxKesEvolutions"));
        genesisConfig.setSlotsPerKesPeriod(result.getLong("slotsPerKesPeriod"));
        genesisConfig.setSystemStart(OffsetDateTime.parse((result.getString("systemStart"))));
        genesisConfig.setProtocolParameters(ProtocolParameters.deserialize(result.getJSONObject("protocolParameters")));
        genesisConfig.setEpochLength(result.getLong("epochLength"));
        genesisConfig.setSecurityParameter(result.getLong("securityParameter"));
        genesisConfig.setMaxLovelaceSupply(result.getBigInteger("maxLovelaceSupply"));
        genesisConfig.setNetworkMagic(result.getLong("networkMagic"));
        genesisConfig.setNetwork(result.getString("network"));
        return genesisConfig;
    }
}
