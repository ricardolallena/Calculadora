package com.iteriam.sanitas.calculadora.service.operaciones;

import com.iteriam.sanitas.calculadora.model.Resultado;

/**
 * interfaz para las operaciones. 
 * Toda nueva operacion debe implementar esta interfaz para poder integrase en el micro servicio.
 */
public interface Operacion {

    Resultado getReultado();

}
