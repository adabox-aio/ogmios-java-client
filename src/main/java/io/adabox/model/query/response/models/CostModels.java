package io.adabox.model.query.response.models;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

@Getter
@Setter
public class CostModels extends HashMap<String, HashMap<String, Long>> {

    public static CostModels deserialize(JsonNode jsonObject) {
        CostModels costModels = new CostModels();
        Iterator<String> keysIterator = jsonObject.fieldNames();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            costModels.put(key, deserializeMap(jsonObject.get(key)));
        }
        return costModels;
    }

    private static HashMap<String, Long> deserializeMap(JsonNode jsonObject) {
        HashMap<String, Long> map = new HashMap<>();
        Iterator<String> keysIterator = jsonObject.fieldNames();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            map.put(key, jsonObject.get(key).longValue());
        }
        return map;
    }

    @Override
    public String toString() {
        return keySet().stream().map(key -> key + "=" + get(key)).collect(Collectors.joining(", ", "{", "}"));
    }
}
