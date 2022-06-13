package com.co.ias.activity.birds.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdAreaName {
    private final String value;

    public BirdAreaName(String value) {
        Validate.notNull(value, "Bird area name can not be null");
        Validate.isTrue(value.length()<=20, "Bird area name can not be longer than 30 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
