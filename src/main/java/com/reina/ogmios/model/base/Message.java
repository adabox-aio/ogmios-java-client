package com.reina.ogmios.model.base;

import com.reina.ogmios.model.query.response.base.QueryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;

@Data
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
public class Message {

    private long msgId;

    public static Message deserialize(String message) {
        try {
            JSONObject jsonObject = new JSONObject(message);
            MethodType methodType = MethodType.convert(jsonObject.getString("methodname"));
            switch (methodType) {
                case QUERY:
                    return QueryResponse.deserialize(jsonObject.getJSONObject("reflection"),jsonObject);
                case REQUEST_NEXT:
                    return new Message(0);
            }
        } catch (JSONException e) {
            log.warn("Cannot deserialize message. Message does not contain \"reflection\" parameter");
        }
        return null;
    }
}
