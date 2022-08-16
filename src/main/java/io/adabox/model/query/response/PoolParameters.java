package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.PoolParametersDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class PoolParameters extends QueryResponse {

    private final Map<String, PoolParametersDto> poolParametersMap = new HashMap<>();

    public PoolParameters(long msgId) {
        super(msgId);
    }

    public static PoolParameters deserialize(long msgId, JsonNode jsonNode) {
        PoolParameters poolParameters = new PoolParameters(msgId);
        Iterator<String> iterator = jsonNode.fieldNames();
        while (iterator.hasNext()) {
            String key = iterator.next();
            poolParameters.getPoolParametersMap().put(key, PoolParametersDto.deserialize(jsonNode.get(key)));
        }
        return poolParameters;
    }
}
