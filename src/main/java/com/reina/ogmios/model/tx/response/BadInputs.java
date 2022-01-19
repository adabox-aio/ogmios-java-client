package com.reina.ogmios.model.tx.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public static BadInputs deserialize(JSONArray jsonArray) {
        BadInputs badInputs = new BadInputs();
        Iterator<Object> objectIterator = jsonArray.iterator();
        List<Input> badInputsList = new ArrayList<>();
        while (objectIterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) objectIterator.next();
            badInputsList.add(Input.deserialize(jsonObject));
        }
        badInputs.setBadInputsList(badInputsList);
        return badInputs;
    }
}
