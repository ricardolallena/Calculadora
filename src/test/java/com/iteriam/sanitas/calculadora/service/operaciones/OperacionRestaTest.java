package com.iteriam.sanitas.calculadora.service.operaciones;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculadora.model.Operador;

@SpringBootTest
class OperacionRestaTest {

    @Autowired
    private OperacionResta operacionResta;

    /**
     * test operacion resta
     */
    @Test
    void operacionRestaTest() {
        this.operacionResta.setParametros("-4.6", Operador.RESTA, "-2.2");
        Assertions.assertEquals(this.operacionResta.getResultado().getResult(), new BigDecimal("-2.4"));
    }
}
