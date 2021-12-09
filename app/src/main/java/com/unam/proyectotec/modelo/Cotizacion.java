package com.unam.proyectotec.modelo;

public class Cotizacion {
    public String fecha_nacimiento;
    public String nombre;
    public String modelo_auto;
    public String celular;
    public String cp;

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setModelo_auto(String modelo_auto) {
        this.modelo_auto = modelo_auto;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Cotizacion (){

    }
    public Cotizacion(String fecha_nacimiento, String nombre, String modelo_auto, String celular, String cp) {
        this.fecha_nacimiento = fecha_nacimiento;
        this.nombre = nombre;
        this.modelo_auto = modelo_auto;
        this.celular = celular;
        this.cp = cp;
    }
}
