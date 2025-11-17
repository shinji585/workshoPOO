package com.example.withoutSwing.Exercice_two;

public class Tablet extends Dispositivo {
    private double costo;

    public Tablet(String marca, String modelo, String numeroSerie) {
        super(marca, modelo, numeroSerie);
        this.costo = 80.0;
    }

    @Override
    public double calcularCostoReparacion() {
        return costo;
    }

    @Override
    public String toString() {
        return "Tablet;" + marca + ";" + modelo + ";" + numeroSerie + ";" + calcularCostoReparacion();
    }
}