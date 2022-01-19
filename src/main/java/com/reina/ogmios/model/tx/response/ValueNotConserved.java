package com.reina.ogmios.model.tx.response;

import com.reina.ogmios.model.Amount;
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
public class ValueNotConserved extends TxError {

    private List<Amount> consumed;
    private List<Amount> produced;

    public ValueNotConserved() {
        super(TxErrorType.VALUE_NOT_CONSERVED);
    }

    public static ValueNotConserved deserialize(JSONObject jsonObject) {
        ValueNotConserved valueNotConserved = new ValueNotConserved();
        if (jsonObject.has("consumed")) {
            valueNotConserved.setConsumed(fetch(jsonObject.getJSONObject("consumed")));
        }
        if (jsonObject.has("produced")) {
            valueNotConserved.setProduced(fetch(jsonObject.getJSONObject("produced")));
        }
        return valueNotConserved;
    }

    private static List<Amount> fetch(JSONObject jsonObject) {
        List<Amount> list = new ArrayList<>();
        if (jsonObject.has("assets")) {
            Object assets = jsonObject.get("assets");
            if (assets instanceof JSONObject) {
                JSONObject asset = ((JSONObject) assets);
                Iterator<String> iterator = asset.keys();
                while (iterator.hasNext()) {
                    String unit = iterator.next();
                    list.add(new Amount(unit, asset.getBigInteger(unit)));
                }
            } else if (assets instanceof JSONArray) {
                JSONArray assetsArray = ((JSONArray) assets);
                for (Object o : assetsArray) {
                    JSONObject asset = (JSONObject) o;
                    String unit = asset.getString("unit");
                    list.add(new Amount(unit, asset.getBigInteger(unit)));
                }
            }
        }
        if (jsonObject.has("coins")) {
            list.add(new Amount("lovelace", jsonObject.getBigInteger("coins")));
        }
        return list;
    }
}
