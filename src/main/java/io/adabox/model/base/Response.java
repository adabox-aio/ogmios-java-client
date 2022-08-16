package io.adabox.model.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import io.adabox.exception.ApiRuntimeException;
import io.adabox.model.query.request.base.QueryType;
import io.adabox.model.query.response.base.QueryResponse;
import io.adabox.model.tx.response.EvaluateTxResponse;
import io.adabox.model.tx.response.SubmitTxResponse;
import io.adabox.util.JsonHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
@Setter
public class Response extends Message {

    private JsonNode fault;

    public static Response deserialize(String messageJson) {
        try {
            RawResponse rawResponse = JsonHelper.toObject(messageJson, RawResponse.class);
            if (rawResponse == null)
                throw new ApiRuntimeException("Could not parse response");
            long msgId = 0;
            if (rawResponse.getReflection() != null && rawResponse.getReflection() != NullNode.getInstance()) {
                msgId = rawResponse.getReflection().get("msg_id").asLong();
            }
            if (rawResponse.getType().equals("jsonwsp/fault")) {
                Error error = new Error(msgId);
                error.setFault(rawResponse.getFault());
                if (rawResponse.getFault().has("string")) {
                    error.setErrorMsg(rawResponse.getFault().get("string").asText());
                }
                return error;
            } else {
                MethodType methodType = MethodType.convert(rawResponse.getMethodname());
                switch (Objects.requireNonNull(methodType)) {
                    case SUBMIT_TX:
                        return SubmitTxResponse.deserialize(msgId, rawResponse.getResult());
                    case REQUEST_NEXT:
                        return new Response(0);
                    case EVALUATE_TX:
                        return EvaluateTxResponse.deserialize(msgId, rawResponse.getResult());
                    case QUERY: {
                        QueryType queryType = QueryType.convert(rawResponse.getReflection().get("object").asText());
                        return QueryResponse.parse(queryType, msgId, rawResponse.getResult());
                    }
                }
            }
        } catch (JsonProcessingException e) {
            log.warn("Cannot deserialize message. Message does not contain \"reflection\" parameter", e);
        }
        return null;
    }

    public Response(long msgId) {
        super(msgId);
    }
}
