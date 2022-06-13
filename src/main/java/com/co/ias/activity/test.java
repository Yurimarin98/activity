package com.co.ias.activity;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.*;
import com.co.ias.activity.infraestructure.models.BirdDTO;

public class test {
    public static void main(String[] args) {
        try {
            Bird bird = new Bird(
                    null,
                    new BirdCommonName("Pinguino"),
                    new BirdScientificName("Pinguino"),
                    new BirdAreaName("Pinguino"),
                    new BirdConfirmedQuantity(null)
            );
            System.out.println(bird.toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
