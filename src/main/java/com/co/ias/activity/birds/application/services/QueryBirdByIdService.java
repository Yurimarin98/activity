package com.co.ias.activity.birds.application.services;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdId;
import com.co.ias.activity.birds.application.ports.input.QueryBirdByIdUseCase;
import com.co.ias.activity.birds.application.ports.output.BirdRepository;
import com.co.ias.activity.infraestructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryBirdByIdService implements QueryBirdByIdUseCase {
    private final BirdRepository birdRepository;

    public QueryBirdByIdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Optional<BirdDTO> execute(Long id) {
        BirdId birdId = new BirdId(id);
        Optional<Bird> birdOptional = birdRepository.get(birdId);
        return birdOptional.map(bird -> {
           BirdDTO birdDTO = BirdDTO.fromDomain(bird);
           return  birdDTO;
        });
    }
}
