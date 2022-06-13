package com.co.ias.activity.birds.application.domain;

import com.co.ias.activity.birds.application.domain.valueObjs.*;

public class Bird {
    private final BirdId id;
    private final BirdCommonName commonName;
    private final BirdScientificName scientificName;
    private final BirdAreaName areaName;
    private final BirdConfirmedQuantity confirmedQuantity;

    public Bird(BirdId id, BirdCommonName commonName, BirdScientificName scientificName, BirdAreaName areaName, BirdConfirmedQuantity confirmedQuantity) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.areaName = areaName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdId getId() {
        return id;
    }

    public BirdCommonName getCommonName() {
        return commonName;
    }

    public BirdScientificName getScientificName() {
        return scientificName;
    }

    public BirdAreaName getAreaName() {
        return areaName;
    }

    public BirdConfirmedQuantity getConfirmedQuantity() {
        return confirmedQuantity;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", commonName=" + commonName +
                ", scientificName=" + scientificName +
                ", areaName=" + areaName +
                ", confirmedQuantity=" + confirmedQuantity +
                '}';
    }
}
