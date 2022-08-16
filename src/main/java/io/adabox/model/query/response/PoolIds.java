package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class PoolIds extends QueryResponse {

    private List<String> poolIdList;

    public PoolIds(long msgId) {
        super(msgId);
    }

    public static PoolIds deserialize(long msgId, JsonNode jsonNode) {
        PoolIds poolIds = new PoolIds(msgId);
        List<String> list = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            list.add(node.asText());
        }
        poolIds.setPoolIdList(list);
        return poolIds;
    }
}
