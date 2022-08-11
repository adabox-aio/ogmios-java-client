package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProtocolVersion {

    Integer major;
    Integer minor;

    public static ProtocolVersion deserialize(JsonNode protocolVersion) {
        return new ProtocolVersion(protocolVersion.get("major").intValue(),protocolVersion.get("minor").intValue());
    }
}
