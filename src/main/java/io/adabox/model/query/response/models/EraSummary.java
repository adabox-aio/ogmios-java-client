package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Summary of the confirmed parts of the ledger.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class EraSummary {

    private Bound start;
    private Bound end;
    private EraParameters parameters;

    public static EraSummary deserialize(JsonNode jsonNode) {
        return new EraSummary(Bound.deserialize(jsonNode.get("start")), Bound.deserialize(jsonNode.get("end")), EraParameters.deserialize(jsonNode.get("parameters")));
    }
}
