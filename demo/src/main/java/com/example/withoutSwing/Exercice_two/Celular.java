package com.example.withoutSwing.Exercice_two;

public class Celular extends Dispositivo {
    private double costo;

    public Celular(String marca, String modelo, String numeroSerie) {
        super(marca, modelo, numeroSerie);
        this.costo = 50.0;
    }

    @Override
    public double calcularCostoReparacion() {
        return costo;
    }

    @Override
    public String toString() {
        return "Celular;" + marca + ";" + modelo + ";" + numeroSerie + ";" + calcularCostoReparacion();
    }
}
