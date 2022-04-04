package com.reina.ogmios.model.tx.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class EvaluationFailure {

    String errorMsg;
}
