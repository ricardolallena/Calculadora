package com.iteriam.sanitas.calculadora.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.iteriam.sanitas.calculadora.model.Operador;

/**
 * test del controlador de la operacion
 */
@SpringBootTest
class OperacionControllerTest {
    
    @Autowired
    private OperacionControllerImpl operacionCotrollerImpl;

    @Test
    void operacionCotrollerImplTest() {
        Assertions.assertInstanceOf(ResponseEntity.class, operacionCotrollerImpl.operacion("1", Operador.SUMA, "2"));
    }

}
