package com.co.ias.activity.birds.application.ports.input;

import com.co.ias.activity.commons.UseCase;
import com.co.ias.activity.infraestructure.models.BirdDTO;

import java.util.Optional;

public interface QueryBirdByIdUseCase extends UseCase<Long, Optional<BirdDTO>> {
}
