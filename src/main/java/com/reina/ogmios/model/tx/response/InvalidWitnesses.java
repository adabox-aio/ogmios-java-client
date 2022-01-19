package com.reina.ogmios.model.tx.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONArray;

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

    public static InvalidWitnesses deserialize(JSONArray invalidWitnessesEntity) {
        List<String> witnesses = new ArrayList<>();
        for (Object o : invalidWitnessesEntity) {
            witnesses.add((String) o);
        }
        return new InvalidWitnesses(witnesses);
    }
}
