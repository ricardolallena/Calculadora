package com.iteriam.sanitas.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.sanitas.calculadora.model.Operador;
import com.iteriam.sanitas.calculadora.model.Resultado;
import com.iteriam.sanitas.calculadora.service.OperacionServiceImpl;

@RestController
public class OperacionCotrollerImpl implements OperacionController {

    @Autowired
    private OperacionServiceImpl operacionServiceImpl;
  
    @Override
    public ResponseEntity<Resultado> operacion(String num1, Operador operador, String num2) {
        return new ResponseEntity<>(this.operacionServiceImpl.execute(num1, operador, num2), HttpStatus.OK);
    }

}
