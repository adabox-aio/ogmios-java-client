package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProtocolVersion {

    Integer major;
    Integer minor;

    public static ProtocolVersion deserialize(JsonNode protocolVersion) {
        return new ProtocolVersion(protocolVersion.get("major").intValue(),protocolVersion.get("minor").intValue());
    }
}
