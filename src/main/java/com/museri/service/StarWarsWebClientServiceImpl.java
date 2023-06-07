package com.museri.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.museri.model.StarWarsCharacter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class StarWarsWebClientServiceImpl implements StarWarsService {
	private final WebClient webClient;
	private static final String API_URL = "https://swapi.dev/api/people/";


    public StarWarsWebClientServiceImpl() {
        this.webClient = WebClient.builder()
                .filter((request, next) -> {
                    log.info("Sending request to: {}", request.url());
                    return next.exchange(request);
                })
                .build();
    }

    @Cacheable("characters")
    public Mono<StarWarsCharacter> getCharacterById(int id) {
        String url = API_URL + id + "/";
        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(
                    httpStatus -> httpStatus.isError(),
                    response -> handleErrorResponse(response)
                )
                .bodyToMono(StarWarsCharacter.class)
                .doOnNext(response -> log.info("Received response: {}", response))
                .doOnError(error -> log.error("Error during request: {}", error.getMessage()));
    }

    private Mono<? extends Throwable> handleErrorResponse(ClientResponse response) {
        log.error("Error response status: {}", response.statusCode());
        // Realiza cualquier lógica de manejo de errores adicional aquí
        return Mono.error(new RuntimeException("Error during request"));
    }
	
}
