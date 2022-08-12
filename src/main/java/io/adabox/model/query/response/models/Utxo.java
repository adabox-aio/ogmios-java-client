package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.adabox.model.Amount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Utxo {

    private String txId;
    private Long index;
    private List<Amount> amountList;
    private String datum;

    public static Utxo deserialize(ArrayNode arrayNode) {
        Utxo utxo = null;
        Iterator<JsonNode> iterator = arrayNode.iterator();
        String txId = null;
        Long index = null;
        List<Amount> amountList = null;
        String datum = null;
        while (iterator.hasNext()) {
            JsonNode jsonObject = iterator.next();
            if (jsonObject.has("txId")) {
                txId = jsonObject.get("txId").asText();
            }
            if (jsonObject.has("index")) {
                index = jsonObject.get("index").asLong();
            }
            if (jsonObject.has("value")) {
                amountList = deserializeAmountList(jsonObject.get("value"));
            }
            if (jsonObject.has("datum")) {
                datum = jsonObject.get("datum").asText();
            }
        }
        return new Utxo(txId, index, amountList, datum);
    }

    private static List<Amount> deserializeAmountList(JsonNode jsonNode) {
        List<Amount> amountList = new ArrayList<>();
        amountList.add(new Amount("lovelace", jsonNode.get("coins").bigIntegerValue()));
        JsonNode assets = jsonNode.get("assets");
        Iterator<String> iterator = assets.fieldNames();
        while (iterator.hasNext()) {
            String unit = iterator.next();
            amountList.add(new Amount(unit, assets.get(unit).bigIntegerValue()));
        }
        return amountList;
    }
}
