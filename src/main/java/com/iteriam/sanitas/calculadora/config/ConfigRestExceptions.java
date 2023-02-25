package com.iteriam.sanitas.calculadora.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
   * 
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
        exception.getMessage() + "-" + webRequest.getDescription(true));

    this.tracer.trace(errorResponse);
    return errorResponse;
  }

  /**
   * Captura errores al crear el parametro operador (SUMA,RESTA)
   * 
   * @param exception
   * @param webRequest
   * @return
   */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse methodArgumentTypeMismatchExceptionExceptionHandler(Exception exception, WebRequest webRequest) {

    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        new Date(),
        "operador invalido.",
        exception.getMessage() + "-" + webRequest.getDescription(true));

    this.tracer.trace(errorResponse);
    return errorResponse;
  }

  /**
   * Captura errores si faltan parametros en la peticiones
   * 
   * @param exception
   * @param webRequest
   * @return
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse missingServletRequestParameterExceptionHandler(Exception exception, WebRequest webRequest) {
    ErrorResponse errorResponse = new ErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        new Date(),
        "Falta algun parametro en la peticion.",
        exception.getMessage() + "-" + webRequest.getDescription(true));

    this.tracer.trace(errorResponse);
    return errorResponse;
  }

  /**
   * Captura el resto de errores.
   * 
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

    this.tracer.trace(errorResponse);

    return errorResponse;
  }

}