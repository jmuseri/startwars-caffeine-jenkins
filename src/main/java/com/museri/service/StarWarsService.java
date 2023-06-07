package com.museri.service;
import com.museri.model.StarWarsCharacter;

import reactor.core.publisher.Mono;

public interface StarWarsService {
    Mono<StarWarsCharacter> getCharacterById(int id);
}

