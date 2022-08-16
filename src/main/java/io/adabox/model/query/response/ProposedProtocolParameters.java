package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ProposedProtocolParameters extends QueryResponse {

    private JsonNode protocolParameters;

    public ProposedProtocolParameters(long msgId) {
        super(msgId);
    }

    public static ProposedProtocolParameters deserialize(long msgId, JsonNode jsonNode) {
        ProposedProtocolParameters proposedProtocolParameters = new ProposedProtocolParameters(msgId);
        proposedProtocolParameters.setProtocolParameters(jsonNode);
        return proposedProtocolParameters;
    }
}
