package com.reina.ogmios.model.query.response;

import com.reina.ogmios.model.query.Utxo;
import com.reina.ogmios.model.query.response.base.QueryResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public static UtxoByAddress deserialize(JSONObject reflection, JSONArray result) {
        List<Utxo> utxos = new ArrayList<>();
        long msgId = reflection.getLong("msg_id");
        for (Object o : result) {
            utxos.add(Utxo.deserialize((JSONArray) o));
        }
        return new UtxoByAddress(msgId, utxos);
    }
}
