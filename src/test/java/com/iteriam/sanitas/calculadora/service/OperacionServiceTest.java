package com.iteriam.sanitas.calculadora.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;

@SpringBootTest
class OperacionServiceTest {

    @Autowired
    private OperacionServiceImpl operacionServiceImpl;

    /**
     * test servicio operacion suma
     */
    @Test
    void operacionServiceTestSuma() {
        Assertions.assertEquals(operacionServiceImpl.execute("1", Operador.SUMA, "2").getResult(),
                new Resultado(new BigDecimal(3)).getResult());
    }

    /**
     * test servicio operacion resta
     */
    @Test
    void operacionServiceTestResta() {
        Assertions.assertEquals(operacionServiceImpl.execute("1", Operador.RESTA, "2").getResult(),
                new Resultado(new BigDecimal(-1)).getResult());
    }

    /**
     * test servicio operacion thrown IllegalArgumentException
     */
    @Test
    void operacionServiceIllegalArgumentException() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            operacionServiceImpl.execute("1", null, "2");
        });
        Assertions.assertEquals("operador incorrecto.", thrown.getMessage());
    }

}
