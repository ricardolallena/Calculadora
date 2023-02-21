package com.iteriam.sanitas.calculadora.model;


import com.iteriam.sanitas.calculadora.service.operaciones.Operacion;

/**
 * Modelo para crear la traza cuando se realiza una operacion con exito.
 */
public class TraceOperacion {

    private Resultado resultado;
    private Operacion operacion; 

    public TraceOperacion(Resultado resultado, Operacion operacion) {
        this.resultado = resultado;
        this.operacion = operacion;
    }

    public Resultado getResultado() {
        return this.resultado;
    }

    public Operacion getOperacion() {
        return this.operacion;
    }

    @Override
    public String toString() {
        return "{" +
            " resultado='" + getResultado() + "'" +
            ", operacion='" + getOperacion() + "'" +
            "}";
    }

}
