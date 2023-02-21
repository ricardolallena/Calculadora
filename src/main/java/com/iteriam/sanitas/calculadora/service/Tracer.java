package com.iteriam.sanitas.calculadora.service;

import org.springframework.stereotype.Service;

import io.corp.calculator.TracerImpl;

/**
 * servicio para TracerImpl
 */
@Service
public class Tracer {
    private TracerImpl tracerImpl = null;

    public Tracer() {
        this.tracerImpl = new TracerImpl();
    }

    /**
     * metodo para generar la traza
     * 
     * @param <T>
     * @param t
     * @return
     */
    public <T> boolean trace(T t) {
        boolean result = true;
        try {
            this.tracerImpl.trace(t);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
