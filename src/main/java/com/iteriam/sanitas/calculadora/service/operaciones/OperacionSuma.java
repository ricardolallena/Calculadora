package com.iteriam.sanitas.calculadora.service.operaciones;

import org.springframework.stereotype.Component;

import com.iteriam.sanitas.calculadora.model.Resultado;

/**
 * realizar la operacion suma
 */
@Component
public class OperacionSuma extends OperacionComun implements Operacion {

    @Override
    public Resultado getResultado() {
        return new Resultado(this.getNum1().add(this.getNum2()));
    }

}