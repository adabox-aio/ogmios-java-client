package io.adabox.model.tx.response;

public enum RedeemerTag {
    Spend(0),
    Mint(1),
    Cert(2),
    Reward(3);

    public final int value;

    RedeemerTag(int value) {
        this.value = value;
    }
}
