package com.co.ias.activity.infraestructure.models;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BirdDAO {
    private Long id;
    private String commonName;
    private String scientificName;
    private String areaName;
    private Integer confirmedQuantity;

    public BirdDAO(Long id, String commonName, String scientificName, String areaName, Integer confirmedQuantity) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.areaName = areaName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdDAO() {
    }

    public Bird toDomain() {
        return new Bird(
                new BirdId(id),
                new BirdCommonName(commonName),
                new BirdScientificName(scientificName),
                new BirdAreaName(areaName),
                new BirdConfirmedQuantity(confirmedQuantity)
        );
    }

    public static BirdDAO fromDomain(Bird bird) {
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setId( bird.getId().getValue() );
        birdDAO.setCommonName( bird.getCommonName().getValue() );
        birdDAO.setScientificName( bird.getScientificName().getValue() );
        birdDAO.setAreaName( bird.getAreaName().getValue() );
        birdDAO.setConfirmedQuantity( bird.getConfirmedQuantity().getValue() );
        return  birdDAO;
    }

    public static BirdDAO fromResultSet(ResultSet resultSet) throws SQLException {
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setId( resultSet.getLong("id") );
        birdDAO.setCommonName( resultSet.getString("common_name") );
        birdDAO.setScientificName( resultSet.getString("scientific_name") );
        birdDAO.setAreaName( resultSet.getString("area_name") );
        birdDAO.setConfirmedQuantity( resultSet.getInt("confirmed_quantity") );
        return birdDAO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
