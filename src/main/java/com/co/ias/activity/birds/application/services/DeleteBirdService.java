package com.co.ias.activity.birds.application.services;

import com.co.ias.activity.birds.application.domain.Bird;
import com.co.ias.activity.birds.application.domain.valueObjs.BirdId;
import com.co.ias.activity.birds.application.ports.input.DeleteBirdUseCase;
import com.co.ias.activity.birds.application.ports.output.BirdRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBirdService implements DeleteBirdUseCase {
    private final BirdRepository birdRepository;

    public DeleteBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Boolean execute(Long id) {
        BirdId birdId = new BirdId(id);
        Optional<Bird> bird = birdRepository.get(birdId);
        if (bird.isPresent()) {
            birdRepository.delete(birdId);
        }
        return bird.isPresent();
    }
}
