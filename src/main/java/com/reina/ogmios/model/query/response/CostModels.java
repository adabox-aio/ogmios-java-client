package com.reina.ogmios.model.query.response;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

@Getter
@Setter
public class CostModels extends HashMap<String, HashMap<String, Long>> {

    public static CostModels deserialize(JSONObject jsonObject) {
        CostModels costModels = new CostModels();
        Iterator<String> keysIterator = jsonObject.keys();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            costModels.put(key, deserializeMap(jsonObject.getJSONObject(key)));
        }
        return costModels;
    }

    private static HashMap<String, Long> deserializeMap(JSONObject jsonObject) {
        HashMap<String, Long> map = new HashMap<>();
        Iterator<String> keysIterator = jsonObject.keys();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            map.put(key, jsonObject.getLong(key));
        }
        return map;
    }

    @Override
    public String toString() {
        return keySet().stream().map(key -> key + "=" + get(key)).collect(Collectors.joining(", ", "{", "}"));
    }
}
