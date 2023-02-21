package com.iteriam.sanitas.calculadora.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.iteriam.sanitas.calculadora.model.ErrorResponse;
import com.iteriam.sanitas.calculadora.service.Tracer;

/**
 * Clase que configura de forma global la captura y tratamiento de exepciones. 
 */
@RestControllerAdvice
public class ConfigRestExceptions {

  @Autowired
  private Tracer tracer;

  /**
   * Captura errores de coversion de String a Bigdecimal
   * @param exception
   * @param webRequest
   * @return
   */
  @ExceptionHandler(NumberFormatException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse numberFormatExceptionHandler(Exception exception, WebRequest webRequest) {

    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        new Date(),
        "num1 / num2: número invalido",
        exception.getMessage()+"-"+webRequest.getDescription(true));

    tracer.trace(errorResponse);
    return errorResponse;
  }

  /**
   * Captura el resto de errores no tratados.
   * @param exception
   * @param webRequest
   * @return
   */

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse globalExceptionHandler(Exception exception, WebRequest webRequest) {

    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        exception.getMessage(),
        webRequest.getDescription(true));

    tracer.trace(errorResponse);

    return errorResponse;
  }

}