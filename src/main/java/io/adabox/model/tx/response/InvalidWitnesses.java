package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
class InvalidWitnesses extends TxError {

    private List<String> witnesses;

    public InvalidWitnesses(List<String> witnesses) {
        super(TxErrorType.INVALID_WITNESSES);
        setWitnesses(witnesses);
    }

    public static InvalidWitnesses deserialize(ArrayNode invalidWitnessesEntity) {
        List<String> witnesses = new ArrayList<>();
        for (JsonNode o : invalidWitnessesEntity) {
            witnesses.add(o.asText());
        }
        return new InvalidWitnesses(witnesses);
    }
}
