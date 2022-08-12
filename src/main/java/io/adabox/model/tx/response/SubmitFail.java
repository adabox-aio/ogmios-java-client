package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@ToString
public class SubmitFail {

    List<TxError> txErrorList;

    public static SubmitFail deserialize(ArrayNode submitFailArray) {
        SubmitFail submitFail = new SubmitFail();
        Iterator<JsonNode> submitFailIterator = submitFailArray.iterator();
        List<TxError> txErrors = new ArrayList<>();
        while (submitFailIterator.hasNext()) {
            txErrors.add(TxError.deserialize(submitFailIterator.next()));
        }
        submitFail.setTxErrorList(txErrors);
        return submitFail;
    }
}
