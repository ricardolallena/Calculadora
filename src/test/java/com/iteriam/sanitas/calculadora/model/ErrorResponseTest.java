package com.iteriam.sanitas.calculadora.model;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test para el model ErrorResponse
 */
class ErrorResponseTest {

    @Test
    void errorResponseTest() {

        ErrorResponse errorResponse = new ErrorResponse(400, new Date(), "mensaje de error", "descripcion del error");
        //Comprueba la clase de la instancia creada
        Assertions.assertInstanceOf(ErrorResponse.class, errorResponse);

        //Comprueba setStatusCode
        errorResponse.setStatusCode(200);
        Assertions.assertEquals(200, errorResponse.getStatusCode());

        Date date = new Date();
        errorResponse.setFecha(date);
         //Comprueba setFecha
        Assertions.assertEquals(date, errorResponse.getFecha());

        String mensaje = "mensaje de prueba";
        errorResponse.setMensaje(mensaje);
         //Comprueba setMensaje
        Assertions.assertEquals(mensaje, errorResponse.getMensaje());

        String descripcion = "descripcion de prueba";
        errorResponse.setDescripcion(descripcion);
         //Comprueba setDescripcion
        Assertions.assertEquals(descripcion, errorResponse.getDescripcion());
    }

}
