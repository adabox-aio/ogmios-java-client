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
public class OutsideOfValidityInterval extends TxError {

    private BigInteger currentSlot;
    private ValidityInterval interval;

    public OutsideOfValidityInterval() {
        super(TxErrorType.OUTSIDE_OF_VALIDITY_INTERVAL);
    }

    public static OutsideOfValidityInterval deserialize(JsonNode jsonObject) {
        OutsideOfValidityInterval outsideOfValidityInterval = new OutsideOfValidityInterval();
        if (jsonObject.has("currentSlot")) {
            outsideOfValidityInterval.setCurrentSlot(jsonObject.get("currentSlot").bigIntegerValue());
        }
        if (jsonObject.has("interval")) {
            outsideOfValidityInterval.setInterval(ValidityInterval.deserialize(jsonObject.get("interval")));
        }
        return outsideOfValidityInterval;
    }
}
