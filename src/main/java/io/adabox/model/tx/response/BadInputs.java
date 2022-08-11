package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BadInputs extends TxError {

    private List<Input> badInputsList;

    public BadInputs() {
        super(TxErrorType.BAD_INPUTS);
    }

    public static BadInputs deserialize(ArrayNode jsonArray) {
        BadInputs badInputs = new BadInputs();
        Iterator<JsonNode> objectIterator = jsonArray.iterator();
        List<Input> badInputsList = new ArrayList<>();
        while (objectIterator.hasNext()) {
            JsonNode jsonObject = objectIterator.next();
            badInputsList.add(Input.deserialize(jsonObject));
        }
        badInputs.setBadInputsList(badInputsList);
        return badInputs;
    }
}
