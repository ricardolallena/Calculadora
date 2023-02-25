package com.iteriam.sanitas.calculadora.service.operaciones;

import org.springframework.stereotype.Component;

import com.iteriam.sanitas.calculadora.model.Resultado;

/**
 * Clase para realizar la operacion resta
 */
@Component
public class OperacionResta extends OperacionComun implements Operacion {

    @Override
    public Resultado getResultado() {
        return new Resultado(this.getNum1().subtract(this.getNum2()));
    }

}