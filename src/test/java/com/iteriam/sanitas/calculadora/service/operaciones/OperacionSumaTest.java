package com.iteriam.sanitas.calculadora.service.operaciones;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculadora.model.Operador;

@SpringBootTest
class OperacionSumaTest {

    @Autowired
    private OperacionSuma operacionSuma;

    /**
     * test operacion suma
     */
    @Test
    void testOperacionSuma() {
        this.operacionSuma.setParametros("3.2", Operador.SUMA, "5.3");
        Assertions.assertEquals(this.operacionSuma.getResultado().getResult(), new BigDecimal("8.5"));
    }

}
