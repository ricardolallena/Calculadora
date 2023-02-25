package com.iteriam.sanitas.calculadora.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteriam.sanitas.calculadora.model.ErrorResponse;
import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;
import com.iteriam.sanitas.calculadora.model.TraceOperacion;
import com.iteriam.sanitas.calculadora.service.operaciones.OperacionSuma;

@SpringBootTest
class TracerTest {

    @Autowired
    private Tracer tracer;

    @Autowired
    private OperacionSuma operacionSuma;

    /**
     * Test tracer String normal
     */
    @Test
    void tracerStringTest() {
        Assertions.assertTrue(tracer.trace("Prueba tracer"), "Error trace");
    }

    /**
     * Test tracer modelo TracerOperacion
     */
    @Test
    void tracerTracerOperacionTest() {
        this.operacionSuma.setParametros("8", Operador.SUMA, "6.2");
        Assertions.assertTrue(tracer.trace(
                new TraceOperacion(new Resultado(new BigDecimal("3.6")), this.operacionSuma)),
                "Error trace");
    }

    /**
     * Test tracer modelo ErrorResponse
     */
    @Test
    void tracerErrorResponseTest() {
        Assertions.assertTrue(
                tracer.trace(new ErrorResponse(0, new Date(), "Prueba tracer", "Prueba tracer descripcion")),
                "Error trace");
    }

    /**
     * Test tracer catch Exception
     */
    @Test
    void tracerCatchTest() {
        Assertions.assertFalse(tracer.trace(null), "Error test catch");
    }

}
