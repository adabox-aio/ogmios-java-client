package io.adabox.model.query.response.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Rewards that can be expected assuming a pool is fully saturated. Such rewards are said non-myopic,
 * in opposition to short-sighted rewards looking at immediate benefits. Keys of the map can be either Lovelace amounts
 * or account credentials depending on the query.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class NonMyopicMemberReward {

    /**
     * A time in seconds relative to another one (typically, system start or era start). Starting from v5.5.4, this can
     * be a floating number. Before v5.5.4, the floating value would be rounded to the nearest second.
     */
    private String poolId;

    /**
     * An absolute slot number.
     */
    private Integer rewards;
}
