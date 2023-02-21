package com.iteriam.sanitas.calculadora.service.operaciones;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.iteriam.sanitas.calculadora.model.Operador;

class OperacionSumaTest {

    /**
     * test operacion suma
     */
    @Test
    void testOperacionSuma() {
        OperacionSuma operacionSuma = new OperacionSuma("3.2", Operador.SUMA, "5.3");
        Assertions.assertEquals(operacionSuma.getReultado().getResult(), new BigDecimal("8.5"));
    }

}
