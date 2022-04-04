package io.adabox.model.base;

import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.tx.response.SubmitTxResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

@Data
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
public class Message {

    private long msgId;

    public static Message deserialize(String message) {
        try {
            JSONObject jsonObject = new JSONObject(message);
            if (jsonObject.has("type") && jsonObject.get("type").equals("jsonwsp/fault")) {
                JSONObject fault = (JSONObject) jsonObject.get("fault");
                return Error.deserialize(fault);
            } else {
                MethodType methodType = MethodType.convert(jsonObject.getString("methodname"));
                switch (Objects.requireNonNull(methodType)) {
                    case QUERY:
                        return QueryResponse.deserialize(jsonObject.getJSONObject("reflection"),jsonObject);
                    case REQUEST_NEXT:
                        return new Message(0);
                    case SUBMIT_TX:
                        return SubmitTxResponse.deserialize(jsonObject.getJSONObject("reflection").getLong("msg_id"),jsonObject.getJSONObject("result"));
                }
            }
        } catch (JSONException e) {
            log.warn("Cannot deserialize message. Message does not contain \"reflection\" parameter");
        }
        return null;
    }
}
