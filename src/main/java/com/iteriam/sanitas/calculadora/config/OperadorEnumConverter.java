package com.iteriam.sanitas.calculadora.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.iteriam.sanitas.calculadora.model.Operador;

/**
 * Implementacion de Coverter para poder escribir los operadores (SUMA,RESTA) en
 * minusculas o mayusculas en las request.
 */
@Component
public class OperadorEnumConverter implements Converter<String, Operador> {

    @Override
    @Nullable
    public Operador convert(String operador) {
        return Operador.valueOf(operador.toUpperCase().trim());
    }

}
