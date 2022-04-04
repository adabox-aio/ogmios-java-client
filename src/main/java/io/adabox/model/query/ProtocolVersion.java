package io.adabox.model.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;

@Data
@AllArgsConstructor
public class ProtocolVersion {

    long major;
    long minor;

    public static ProtocolVersion deserialize(JSONObject protocolVersion) {
        return new ProtocolVersion(protocolVersion.getLong("major"),protocolVersion.getLong("minor"));
    }
}
