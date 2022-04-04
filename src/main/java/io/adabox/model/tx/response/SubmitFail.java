package io.adabox.model.tx.response;

import lombok.Data;
import lombok.ToString;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@ToString
public class SubmitFail {

    List<TxError> txErrorList;

    public static SubmitFail deserialize(JSONArray submitFailArray) {
        SubmitFail submitFail = new SubmitFail();
        Iterator<Object> submitFailIterator = submitFailArray.iterator();
        List<TxError> txErrors = new ArrayList<>();
        while (submitFailIterator.hasNext()) {
            txErrors.add(TxError.deserialize((JSONObject) submitFailIterator.next()));
        }
        submitFail.setTxErrorList(txErrors);
        return submitFail;
    }
}
