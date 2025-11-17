package com.example.withoutSwing.Exercice_five;

public class CursoPresencial extends Curso {
    private int numeroSesiones;
    private double costoAdicional;

    public CursoPresencial(String codigo, String nombre, int duracion, double costoBase, int numeroSesiones, double costoAdicional) {
        super(codigo, nombre, duracion, costoBase);
        this.numeroSesiones = numeroSesiones;
        this.costoAdicional = costoAdicional;
    }

    @Override
    public double calcularCostoTotal() {
        return costoBase + (numeroSesiones * costoAdicional);
    }

    public int getNumeroSesiones() {
        return numeroSesiones;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    @Override
    public String toString() {
        return "Presencial;" + codigo + ";" + nombre + ";" + duracion + ";" + costoBase + ";" + numeroSesiones + ";" + costoAdicional + ";" + calcularCostoTotal();
    }
}
