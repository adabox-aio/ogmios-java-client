package com.reina.ogmios.model.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
public class Utxo {

    private String txId;
    private Long index;
    private List<Amount> amountList;
    private String datum;

    public static Utxo deserialize(JSONArray jsonArray) {
        Utxo utxo = null;
        Iterator<Object> iterator = jsonArray.iterator();
        String txId = null;
        Long index = null;
        List<Amount> amountList = null;
        String datum = null;
        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();
            try {
                txId = jsonObject.getString("txId");
            } catch (JSONException ignored) {
                //ignored
            }
            try {
                index = jsonObject.getLong("index");
            } catch (JSONException ignored) {
                //ignored
            }
            try {
                amountList = deserializeAmountList(jsonObject.getJSONObject("value"));
            } catch (JSONException ignored) {
                //ignored
            }
            try {
                datum = jsonObject.getString("datum");
            } catch (JSONException ignored) {
                //ignored
            }
            utxo = new Utxo(txId,index,amountList,datum);
        }
        return utxo;
    }

    private static List<Amount> deserializeAmountList(JSONObject value) {
        List<Amount> amountList = new ArrayList<>();
        amountList.add(new Amount("lovelace", value.getBigInteger("coins")));
        JSONObject assets = value.getJSONObject("assets");
        Iterator<String> iterator = assets.keys();
        while (iterator.hasNext()) {
            String unit = iterator.next();
            amountList.add(new Amount(unit,assets.getBigInteger(unit)));
        }
        return amountList;
    }
}
