package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.query.response.models.EraSummary;
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
public class EraSummaries extends QueryResponse {

    private List<EraSummary> eraSummaryList = new ArrayList<>();

    public EraSummaries(long msgId) {
        super(msgId);
    }


    public static EraSummaries deserialize(long msgId, JsonNode jsonNode) {
        EraSummaries eraSummaries = new EraSummaries(msgId);
        for (JsonNode node : jsonNode) {
            eraSummaries.getEraSummaryList().add(EraSummary.deserialize(node));
        }
        return eraSummaries;
    }
}
