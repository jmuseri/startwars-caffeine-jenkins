package com.museri.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.museri.model.StarWarsCharacter;

@SpringBootTest
public class StarWarsServiceTest {

    @MockBean
    private StarWarsService starWarsService;

    @Test
    public void testGetCharacterById() {
        int characterId = 1;
        StarWarsCharacter expectedCharacter = new StarWarsCharacter();
        // Configurar el comportamiento esperado del servicio mock
        Mockito.when(starWarsService.getCharacterById(characterId))
               .thenReturn(expectedCharacter);
        
        // Llamar al método del servicio
        StarWarsCharacter actualCharacter = starWarsService.getCharacterById(characterId);

        // Verificar el resultado
        Assertions.assertEquals(expectedCharacter, actualCharacter);
    }
}