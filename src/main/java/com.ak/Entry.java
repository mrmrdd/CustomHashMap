package com.ak;

/**
 * Created by MacDuck on 7/29/17.
 */
public class Entry {
    private final Integer key;
    private final Long value;

    public Entry(Integer key, Long value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }

}
