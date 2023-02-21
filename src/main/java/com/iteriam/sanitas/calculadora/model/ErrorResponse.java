package com.iteriam.sanitas.calculadora.model;

import java.util.Date;
/**
 * Modelo para la devolucion de errores
 */
public class ErrorResponse {
    private int statusCode;
    private Date fecha;
    private String mensaje;
    private String descripcion;

    public ErrorResponse(int statusCode, Date fecha, String mensaje, String descripcion) {
        this.statusCode = statusCode;
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.descripcion = descripcion;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "{" +
                " statusCode='" + getStatusCode() + "'" +
                ", fecha='" + getFecha() + "'" +
                ", mensaje='" + getMensaje() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                "}";
    }

}