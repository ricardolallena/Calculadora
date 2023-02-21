package com.iteriam.sanitas.calculadora.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculadora.model.Operador;

@SpringBootTest
class OperadorEnumConverterTest {

    @Autowired
    private OperadorEnumConverter operadorEnumConverter;

    /**
     * test operadorEnumConverter que se configura para el parametro operador de las peticiones
     */
    @Test
    void operadorEnumConverterOperador() {
        Assertions.assertEquals(Operador.SUMA, operadorEnumConverter.convert("suma"));

        Assertions.assertEquals(Operador.RESTA, operadorEnumConverter.convert("Resta"));
    }
}
