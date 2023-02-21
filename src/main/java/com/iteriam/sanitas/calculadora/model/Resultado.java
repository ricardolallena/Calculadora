package com.iteriam.sanitas.calculadora.model;

import java.math.BigDecimal;

/**
 * Modelo de respuesta para el microservicio.
 */
public class Resultado {

    private BigDecimal result;

    public Resultado(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return "{" +
                " result='" + getResult() + "'" +
                "}";
    }

}
