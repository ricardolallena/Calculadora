package com.iteriam.sanitas.calculadora.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;

public interface OperacionController {
  /**
   * MicroServicio para realizar una operacion aritmetica.
   * @param num1
   * @param operador
   * @param num2
   * @return
   */
    @GetMapping(value = "/operacion", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Resultado> operacion(
            @RequestParam("num1") String num1,
            @RequestParam("operador") Operador operador,
            @RequestParam("num2") String num2);
}