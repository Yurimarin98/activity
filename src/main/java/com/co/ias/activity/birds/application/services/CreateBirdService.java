package com.co.ias.activity.birds.application.services;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdAreaName;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdCommonName;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdConfirmedQuantity;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdScientificName;
import com.co.ias.activity.birds.application.ports.input.CreateBirdUseCase;
import com.co.ias.activity.birds.application.ports.output.BirdRepository;
import com.co.ias.activity.infraestructure.models.BirdDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateBirdService implements CreateBirdUseCase {
    private final BirdRepository birdRepository;

    public CreateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {
        Bird bird = new Bird(
                null,
                new BirdCommonName( birdDTO.getCommonName() ),
                new BirdScientificName( birdDTO.getScientificName() ),
                new BirdAreaName( birdDTO.getAreaName() ),
                birdDTO.getConfirmedQuantity() != null ? new BirdConfirmedQuantity( birdDTO.getConfirmedQuantity() ) : null
        );

        birdRepository.store(bird);

        birdDTO.setStatus("Created");

        return birdDTO;
    }
}
