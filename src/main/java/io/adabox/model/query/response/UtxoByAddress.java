package io.adabox.model.query.response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.adabox.model.query.response.models.Utxo;
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
public class UtxoByAddress extends QueryResponse {

    private List<Utxo> utxos;

    public UtxoByAddress(long msgId) {
        super(msgId);
    }

    public UtxoByAddress(long msgId, List<Utxo> utxos) {
        this(msgId);
        setUtxos(utxos);
    }

    public static UtxoByAddress deserialize(long msgId, JsonNode jsonNode) {
        List<Utxo> utxos = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            utxos.add(Utxo.deserialize((ArrayNode) node));
        }
        return new UtxoByAddress(msgId, utxos);
    }
}
