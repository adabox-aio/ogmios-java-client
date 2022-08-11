package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExecutionUnit {

    private String memory;
    private String steps;

    public static ExecutionUnit deserialize(JsonNode jsonObject) {
        ExecutionUnit executionUnit = new ExecutionUnit();
        if (jsonObject.has("memory")) {
            executionUnit.setMemory(jsonObject.get("memory").asText());
        }
        if (jsonObject.has("steps")) {
            executionUnit.setSteps(jsonObject.get("steps").asText());
        }
        return executionUnit;
    }
}
