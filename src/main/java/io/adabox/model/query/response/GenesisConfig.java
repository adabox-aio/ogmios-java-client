package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.models.ProtocolParameters;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class GenesisConfig extends QueryResponse {

    private String activeSlotsCoefficient;
    private Integer updateQuorum;
    private Integer slotLength;
    private Integer maxKesEvolutions;
    private Integer slotsPerKesPeriod;
    private OffsetDateTime systemStart;
    private ProtocolParameters protocolParameters;
    private Integer epochLength;
    private Integer securityParameter;
    private String maxLovelaceSupply;
    private Integer networkMagic;
    private String network;

    public GenesisConfig(long msgId) {
        super(msgId);
    }

    public static GenesisConfig deserialize(long msgId, JsonNode jsonNode) {
        GenesisConfig genesisConfig = new GenesisConfig(msgId);
        genesisConfig.setActiveSlotsCoefficient(jsonNode.get("activeSlotsCoefficient").asText());
        genesisConfig.setUpdateQuorum(jsonNode.get("updateQuorum").intValue());
        genesisConfig.setSlotLength(jsonNode.get("slotLength").intValue());
        genesisConfig.setMaxKesEvolutions(jsonNode.get("maxKesEvolutions").intValue());
        genesisConfig.setSlotsPerKesPeriod(jsonNode.get("slotsPerKesPeriod").intValue());
        genesisConfig.setSystemStart(OffsetDateTime.parse((jsonNode.get("systemStart").asText())));
        genesisConfig.setProtocolParameters(ProtocolParameters.deserialize(jsonNode.get("protocolParameters")));
        genesisConfig.setEpochLength(jsonNode.get("epochLength").intValue());
        genesisConfig.setSecurityParameter(jsonNode.get("securityParameter").intValue());
        genesisConfig.setMaxLovelaceSupply(jsonNode.get("maxLovelaceSupply").asText());
        genesisConfig.setNetworkMagic(jsonNode.get("networkMagic").intValue());
        genesisConfig.setNetwork(jsonNode.get("network").asText());
        return genesisConfig;
    }
}
