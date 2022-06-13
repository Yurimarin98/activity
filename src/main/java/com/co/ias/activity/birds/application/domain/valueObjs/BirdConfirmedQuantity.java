package com.co.ias.activity.birds.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdConfirmedQuantity {
    private final Integer value;

    public BirdConfirmedQuantity(Integer value) {

        if (value != null && value != 0){
            Validate.inclusiveBetween(1, 100000, value, "Bird confirmed quantity is not in range (1-100000)");
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
