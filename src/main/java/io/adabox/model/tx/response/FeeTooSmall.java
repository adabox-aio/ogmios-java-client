package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public static FeeTooSmall deserialize(JsonNode jsonObject) {
        FeeTooSmall feeTooSmall = new FeeTooSmall();
        if (jsonObject.has("requiredFee")) {
            feeTooSmall.setRequiredFee(jsonObject.get("requiredFee").bigIntegerValue());
        }
        if (jsonObject.has("actualFee")) {
            feeTooSmall.setActualFee(jsonObject.get("actualFee").bigIntegerValue());
        }
        return feeTooSmall;
    }
}
