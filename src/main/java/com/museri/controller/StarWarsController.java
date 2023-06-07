package com.museri.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.museri.model.StarWarsCharacter;
import com.museri.service.StarWarsService;

import io.swagger.v3.oas.annotations.Operation;
import reactor.core.publisher.Mono;



@RestController
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

	@Operation(summary = "Retrieves a Star wars Character by its ID.")
    @GetMapping("/characters/{id}")
    public Mono<StarWarsCharacter> getCharacterById(@PathVariable int id) {
        return starWarsService.getCharacterById(id);
    }
}