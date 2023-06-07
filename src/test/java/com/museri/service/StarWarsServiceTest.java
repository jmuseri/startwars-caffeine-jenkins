package com.museri.service;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.museri.controller.StarWarsController;
import com.museri.model.StarWarsCharacter;

import reactor.core.publisher.Mono;

public class StarWarsServiceTest {

    private WebTestClient webTestClient;

    @Mock
    private StarWarsService starWarsService;

    @InjectMocks
    private StarWarsController starWarsController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        webTestClient = WebTestClient.bindToController(starWarsController).build();
    }

    @Test
    public void testGetCharacterById() {
        int id = 1;
        StarWarsCharacter character = new StarWarsCharacter();
        character.setName("Luke Skywalker");

        when(starWarsService.getCharacterById(id)).thenReturn(Mono.just(character));

        webTestClient.get()
                .uri("/api/characters/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.name").isEqualTo("Luke Skywalker");
    }
}