package com.reina.ogmios.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class Amount {

    private String unit;
    private BigInteger quantity;
}
