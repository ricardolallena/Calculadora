package com.iteriam.sanitas.calculadora.service.operaciones;

import java.math.BigDecimal;

import com.iteriam.sanitas.calculadora.model.Operador;

public class OperacionComun {

    private BigDecimal num1;
    private Operador operador;
    private BigDecimal num2;

    public void setParametros(String num1, Operador operador, String num2) {
        this.num1 = new BigDecimal(num1);
        this.operador = operador;
        this.num2 = new BigDecimal(num2);
    }

    public BigDecimal getNum1() {
        return this.num1;
    }

    public Operador getOperador() {
        return this.operador;
    }

    public BigDecimal getNum2() {
        return this.num2;
    }

    @Override
    public String toString() {
        return "{" +
                " num1='" + getNum1() + "'" +
                ", operador='" + getOperador() + "'" +
                ", num2='" + getNum2() + "'" +
                "}";
    }

}
