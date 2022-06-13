package com.co.ias.activity.infraestructure.models;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.*;

public class BirdDTO {
    private Long birdId;
    private String commonName;
    private String scientificName;
    private String areaName;
    private Integer confirmedQuantity;

    private String status;

    public BirdDTO(Long birdId, String commonName, String scientificName, String areaName, Integer confirmedQuantity) {
        this.birdId = birdId;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.areaName = areaName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdDTO() {
    }

    public Bird toDomain(){
        return new Bird(
                new BirdId(birdId),
                new BirdCommonName(commonName),
                new BirdScientificName(scientificName),
                new BirdAreaName(areaName),
                new BirdConfirmedQuantity(confirmedQuantity)
        );
    }

    public static BirdDTO fromDomain(Bird bird){
        BirdDTO birdDTO = new BirdDTO();
        birdDTO.setBirdId( bird.getId().getValue() );
        birdDTO.setCommonName( bird.getCommonName().getValue() );
        birdDTO.setScientificName( bird.getScientificName().getValue() );
        birdDTO.setAreaName( bird.getAreaName().getValue() );
        birdDTO.setConfirmedQuantity( bird.getConfirmedQuantity().getValue() );
        return birdDTO;
    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getConfirmedQuantity() {
        return confirmedQuantity;
    }

    public void setConfirmedQuantity(Integer confirmedQuantity) {
        this.confirmedQuantity = confirmedQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BirdDTO{" +
                "birdId=" + birdId +
                ", commonName='" + commonName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", confirmedQuantity=" + confirmedQuantity +
                '}';
    }
}
