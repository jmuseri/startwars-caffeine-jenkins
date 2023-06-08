package com.museri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.museri.model.StarWarsCharacter;

import lombok.extern.slf4j.Slf4j;

@Service
public class StarWarsServiceImpl implements StarWarsService {

	
    private final RestTemplate restTemplate;
    private final String apiUrl;

	@Autowired
    public StarWarsServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }


    @Cacheable("characters")
    public StarWarsCharacter getCharacterById(int id) {
        String url = apiUrl + id + "/";
        StarWarsCharacter character = restTemplate.getForObject(url, StarWarsCharacter.class);
        return character;
    }
}