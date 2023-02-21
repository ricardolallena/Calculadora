package com.iteriam.sanitas.calculadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;
import com.iteriam.sanitas.calculadora.model.TraceOperacion;
import com.iteriam.sanitas.calculadora.service.operaciones.Operacion;
import com.iteriam.sanitas.calculadora.service.operaciones.OperacionResta;
import com.iteriam.sanitas.calculadora.service.operaciones.OperacionSuma;

/**
 * implementacion del servicio operacion
 */
@Service
public class OperacionServiceImpl implements OperacionService {

    @Autowired
    private Tracer tracer;
    
    /**
     * obtiene, ejecuta y crea la traza de la operacion
     * Devuelve el resultado
     */
    @Override
    public Resultado execute(String num1, Operador operador, String num2) {
        Operacion operacion = this.getOperacion(num1, operador, num2);
        Resultado resultado = operacion.getReultado();
        this.tracer.trace(new TraceOperacion(resultado, operacion));
        return resultado;
    }
    /**
     * Devuelve la operacion a ejecutar.
     * Si no existe el operador genera la excepcion IllegalArgumentException
     * @param num1
     * @param operador
     * @param num2
     * @return
     */

    private Operacion getOperacion(String num1, Operador operador, String num2) {
        Operacion operacion = null;

        if (Operador.SUMA.equals(operador)) {
            operacion = new OperacionSuma(num1, operador, num2);
        } else if (Operador.RESTA.equals(operador)) {
            operacion = new OperacionResta(num1, operador, num2);
        } else {
            throw new IllegalArgumentException("operador incorrecto.");
        }

        return operacion;
    }

}
