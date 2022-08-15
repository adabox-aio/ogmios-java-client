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
public class SystemStart extends QueryResponse {

    private String utcTime;

    public SystemStart(long msgId, String utcTime) {
        super(msgId);
        setUtcTime(utcTime);
    }

    public static SystemStart deserialize(long msgId, JsonNode jsonNode) {
        return new SystemStart(msgId, jsonNode.asText());
    }
}
