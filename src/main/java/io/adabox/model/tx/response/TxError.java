package io.adabox.model.tx.response;

import lombok.Data;
import lombok.ToString;
import org.json.JSONObject;

@Data
@ToString
public class TxError {

    private final TxErrorType txErrorType;

    public TxError(TxErrorType txErrorType) {
        this.txErrorType = txErrorType;
    }

    public static TxError deserialize(JSONObject txError) {
        if (txError.has("networkMismatch")) {
            return NetworkMismatch.deserialize(txError.getJSONObject("networkMismatch"));
        } else if (txError.has("invalidWitnesses")) {
            return InvalidWitnesses.deserialize(txError.getJSONArray("invalidWitnesses"));
        } else if (txError.has("valueNotConserved")) {
            return ValueNotConserved.deserialize(txError.getJSONObject("valueNotConserved"));
        } else if (txError.has("badInputs")) {
            return BadInputs.deserialize(txError.getJSONArray("badInputs"));
        } else if (txError.has("feeTooSmall")) {
            return FeeTooSmall.deserialize(txError.getJSONObject("feeTooSmall"));
        } else if (txError.has("outsideOfValidityInterval")) {
            return OutsideOfValidityInterval.deserialize(txError.getJSONObject("outsideOfValidityInterval"));
        }
        return null;
    }
}
