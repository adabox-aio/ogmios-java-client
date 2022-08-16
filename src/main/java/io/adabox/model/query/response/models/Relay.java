package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Relay {

    private Integer port;

    private String hostname;

    private String ipv4;

    private String ipv6;

    public static Relay deserialize(JsonNode jsonNode) {
        Relay relay = new Relay();
        if (jsonNode.has("port")) {
            relay.setPort(jsonNode.get("port").asInt());
        }
        if (jsonNode.has("hostname")) {
            relay.setHostname(jsonNode.get("hostname").asText());
        }
        if (jsonNode.has("ipv4")) {
            relay.setHostname(jsonNode.get("ipv4").asText());
        }
        if (jsonNode.has("ipv6")) {
            relay.setHostname(jsonNode.get("ipv6").asText());
        }
        return relay;
    }
}
