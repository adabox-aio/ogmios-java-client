package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.models.ProtocolParameters;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CurrentProtocolParameters extends QueryResponse {

    private ProtocolParameters protocolParameters;

    public CurrentProtocolParameters(long msgId, ProtocolParameters protocolParameters) {
        super(msgId);
        setProtocolParameters(protocolParameters);
    }

    public static CurrentProtocolParameters deserialize(long msgId, JsonNode jsonNode) {
        return new CurrentProtocolParameters(msgId, ProtocolParameters.deserialize(jsonNode));
    }
}
