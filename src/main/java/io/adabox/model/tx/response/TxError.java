package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TxError {

    private final TxErrorType txErrorType;

    public TxError(TxErrorType txErrorType) {
        this.txErrorType = txErrorType;
    }

    public static TxError deserialize(JsonNode txError) {
        if (txError.has("networkMismatch")) {
            return NetworkMismatch.deserialize(txError.get("networkMismatch"));
        } else if (txError.has("invalidWitnesses")) {
            return InvalidWitnesses.deserialize(txError.get("invalidWitnesses"));
        } else if (txError.has("valueNotConserved")) {
            return ValueNotConserved.deserialize(txError.get("valueNotConserved"));
        } else if (txError.has("badInputs")) {
            return BadInputs.deserialize(txError.get("badInputs"));
        } else if (txError.has("feeTooSmall")) {
            return FeeTooSmall.deserialize(txError.get("feeTooSmall"));
        } else if (txError.has("outsideOfValidityInterval")) {
            return OutsideOfValidityInterval.deserialize(txError.get("outsideOfValidityInterval"));
        }
        return null;
    }
}
