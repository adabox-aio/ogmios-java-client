package io.adabox.model.query.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Setter
@ToString
public class ExecutionUnit {

    private Long memory;
    private Long steps;

    public static ExecutionUnit deserialize(JSONObject jsonObject) {
        ExecutionUnit executionUnit = new ExecutionUnit();
        if (jsonObject.has("memory")) {
            executionUnit.setMemory(jsonObject.getLong("memory"));
        }
        if (jsonObject.has("steps")) {
            executionUnit.setSteps(jsonObject.getLong("steps"));
        }
        return executionUnit;
    }
}
