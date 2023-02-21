package com.iteriam.sanitas.calculadora.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * test para el enum Operador
 */
@SpringBootTest
class OperadorTest {

    @Test
    void sumaOperadorTest() {
        Assertions.assertEquals(Operador.SUMA, Operador.valueOf("SUMA"));
    }

    @Test
    void restaOperadorTest() {
        Assertions.assertEquals(Operador.RESTA, Operador.valueOf("RESTA"));
    }

}
