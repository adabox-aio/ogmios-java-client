package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BlockHeight extends QueryResponse {

    private Integer blockNoOrOrigin;

    public BlockHeight(long msgId) {
        super(msgId);
    }

    public static BlockHeight deserialize(long msgId, JsonNode jsonNode) {
        BlockHeight blockHeight = new BlockHeight(msgId);
        blockHeight.setBlockNoOrOrigin(jsonNode.intValue());
        return blockHeight;
    }
}
