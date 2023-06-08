package com.museri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.museri.model.StarWarsCharacter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StarWarsServiceImpl implements StarWarsService {

	@Value("${api.url}")
    private String apiUrl;



    @Cacheable("characters")
    public StarWarsCharacter getCharacterById(int id) {
        String url = apiUrl + id + "/";
        return WebClient.create().get()
                .uri(url)
                .retrieve()
                .bodyToMono(StarWarsCharacter.class)
                .block();

    }

}