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
public class OutsideOfValidityInterval extends TxError {

    private BigInteger currentSlot;
    private Interval interval;

    public OutsideOfValidityInterval() {
        super(TxErrorType.OUTSIDE_OF_VALIDITY_INTERVAL);
    }

    public static OutsideOfValidityInterval deserialize(JSONObject jsonObject) {
        OutsideOfValidityInterval outsideOfValidityInterval = new OutsideOfValidityInterval();
        if (jsonObject.has("currentSlot")) {
            outsideOfValidityInterval.setCurrentSlot(jsonObject.getBigInteger("currentSlot"));
        }
        if (jsonObject.has("interval")) {
            outsideOfValidityInterval.setInterval(Interval.deserialize(jsonObject.getJSONObject("interval")));
        }
        return outsideOfValidityInterval;
    }
}
