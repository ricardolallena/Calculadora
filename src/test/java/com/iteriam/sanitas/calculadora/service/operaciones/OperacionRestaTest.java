package com.iteriam.sanitas.calculadora.service.operaciones;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.iteriam.sanitas.calculadora.model.Operador;

class OperacionRestaTest {

    /**
     * test operacion resta
     */
    @Test
    void operacionRestaTest() {
        OperacionResta operacionResta = new OperacionResta("-4.6", Operador.RESTA, "-2.2");
        Assertions.assertEquals(operacionResta.getReultado().getResult(), new BigDecimal("-2.4"));
    }
}
