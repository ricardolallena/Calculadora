package com.iteriam.sanitas.calculadora.service.operaciones;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;

/**
 * interfaz para las operaciones. 
 * Toda nueva operacion debe implementar esta interfaz para poder integrase en el micro servicio.
 */
public interface Operacion {

    Resultado getResultado();

    void setParametros(String num1, Operador operador, String num2);

}
