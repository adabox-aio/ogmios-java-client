package io.adabox.model.query.response.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PointOrOrigin {

    private Long slot;
    private String hash;

    public PointOrOrigin(Long slot, String hash) {
        this.slot = slot;
        this.hash = hash;
    }
}
