package io.adabox.model.tx.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONObject;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class FeeTooSmall extends TxError {

    private BigInteger requiredFee;
    private BigInteger actualFee;

    public FeeTooSmall() {
        super(TxErrorType.FEE_TOO_SMALL);
    }

    public static FeeTooSmall deserialize(JSONObject jsonObject) {
        FeeTooSmall feeTooSmall = new FeeTooSmall();
        if (jsonObject.has("requiredFee")) {
            feeTooSmall.setRequiredFee(jsonObject.getBigInteger("requiredFee"));
        }
        if (jsonObject.has("actualFee")) {
            feeTooSmall.setActualFee(jsonObject.getBigInteger("actualFee"));
        }
        return feeTooSmall;
    }
}
