package com.example.withoutSwing.Exercise_one;

public class Habitacion {
    protected int numero;
    protected double precioBase;

    public Habitacion(int numero, double precioBase) {
        this.numero = numero;
        this.precioBase = precioBase;
    }

    public double calcularCosto() {
        return precioBase;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    @Override
    public String toString() {
        return numero + ";" + precioBase + ";" + calcularCosto();
    }
}
