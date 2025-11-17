package com.example.withoutSwing.Exercice_five;

public class Curso {
    protected String codigo;
    protected String nombre;
    protected int duracion;
    protected double costoBase;

    public Curso(String codigo, String nombre, int duracion, double costoBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;
        this.costoBase = costoBase;
    }

    public double calcularCostoTotal() {
        return costoBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getCostoBase() {
        return costoBase;
    }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + duracion + ";" + costoBase + ";" + calcularCostoTotal();
    }
}
