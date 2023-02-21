package com.iteriam.sanitas.calculadora.service;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;

public interface OperacionService {
        Resultado execute(String num1, Operador operador, String num2);
}
