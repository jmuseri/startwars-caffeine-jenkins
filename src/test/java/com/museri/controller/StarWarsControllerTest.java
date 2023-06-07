package com.museri.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCharacterById() throws Exception {
        int characterId = 1;
        // Configurar la URL del endpoint del controlador
        String url = "/characters/" + characterId;
        
        // Realizar la solicitud GET al endpoint
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Luke Skywalker"));
        // Verificar el resultado esperado
    }
}