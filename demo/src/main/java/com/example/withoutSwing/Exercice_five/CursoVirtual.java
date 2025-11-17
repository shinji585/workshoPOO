package com.example.withoutSwing.Exercice_five;

public class CursoVirtual extends Curso {
    private String plataforma;
    private double descuento;

    public CursoVirtual(String codigo, String nombre, int duracion, double costoBase, String plataforma, double descuento) {
        super(codigo, nombre, duracion, costoBase);
        this.plataforma = plataforma;
        this.descuento = descuento;
    }

    @Override
    public double calcularCostoTotal() {
        return costoBase - (costoBase * descuento / 100);
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return "Virtual;" + codigo + ";" + nombre + ";" + duracion + ";" + costoBase + ";" + plataforma + ";" + descuento + "%;" + calcularCostoTotal();
    }
}