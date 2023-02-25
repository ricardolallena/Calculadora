package com.iteriam.sanitas.calculadora.service;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;
import com.iteriam.sanitas.calculadora.model.TraceOperacion;
import com.iteriam.sanitas.calculadora.service.operaciones.Operacion;

import jakarta.annotation.PostConstruct;

/**
 * implementacion del servicio operacion
 */
@Service
public class OperacionServiceImpl implements OperacionService {

    @Autowired
    private Tracer tracer;

    @Autowired
    private Map<String, Operacion> operaciones;

    private Map<String, Operacion> operacionesCaseIinsensitiv;

    /**
     * Crea un mapa de operaciones sin case sensitive en get y put, para poder
     * obtener concatenar "operacion" + operador
     */
    @PostConstruct
    public void getOperacionesCaseIinsensitiv() {
        this.operacionesCaseIinsensitiv = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        operacionesCaseIinsensitiv.putAll(this.operaciones);
    }

    /**
     * obtiene, ejecuta y crea la traza de la operacion
     * Devuelve el resultado
     */
    @Override
    public Resultado execute(String num1, Operador operador, String num2) {

        Operacion operacion = this.getOperacion(num1, operador, num2);
        Resultado resultado = operacion.getResultado();
        this.tracer.trace(new TraceOperacion(resultado, operacion));
        return resultado;
    }

    /**
     * Devuelve la operacion a ejecutar.
     * Si no existe el operador genera la excepcion IllegalArgumentException
     * 
     * @param num1
     * @param operador
     * @param num2
     * @return
     */

    private Operacion getOperacion(String num1, Operador operador, String num2) {
        Operacion operacion = null;

        if (operador != null) {
            operacion = this.operacionesCaseIinsensitiv.get("operacion" + operador.name());
        }

        if (operacion != null) {
            operacion.setParametros(num1, operador, num2);
        } else {
            throw new IllegalArgumentException("operador incorrecto.");
        }

        return operacion;
    }

}
