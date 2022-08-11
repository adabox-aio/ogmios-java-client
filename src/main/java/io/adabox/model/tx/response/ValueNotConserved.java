package io.adabox.model.tx.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.adabox.model.Amount;
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
public class ValueNotConserved extends TxError {

    private List<Amount> consumed;
    private List<Amount> produced;

    public ValueNotConserved() {
        super(TxErrorType.VALUE_NOT_CONSERVED);
    }

    public static ValueNotConserved deserialize(JsonNode jsonObject) {
        ValueNotConserved valueNotConserved = new ValueNotConserved();
        if (jsonObject.has("consumed")) {
            valueNotConserved.setConsumed(fetch(jsonObject.get("consumed")));
        }
        if (jsonObject.has("produced")) {
            valueNotConserved.setProduced(fetch(jsonObject.get("produced")));
        }
        return valueNotConserved;
    }

    private static List<Amount> fetch(JsonNode jsonObject) {
        List<Amount> list = new ArrayList<>();
        if (jsonObject.has("assets")) {
            JsonNode assets = jsonObject.get("assets");
            if (assets.getNodeType() == JsonNodeType.OBJECT) {
                ObjectNode asset = ((ObjectNode) assets);
                Iterator<String> iterator = asset.fieldNames();
                while (iterator.hasNext()) {
                    String unit = iterator.next();
                    list.add(new Amount(unit, asset.get(unit).bigIntegerValue()));
                }
            } else if (assets.getNodeType() == JsonNodeType.ARRAY) {
                ArrayNode assetsArray = ((ArrayNode) assets);
                for (JsonNode asset : assetsArray) {
                    String unit = asset.get("unit").asText();
                    list.add(new Amount(unit, asset.get(unit).bigIntegerValue()));
                }
            }
        }
        if (jsonObject.has("coins")) {
            list.add(new Amount("lovelace", jsonObject.get("coins").bigIntegerValue()));
        }
        return list;
    }
}
