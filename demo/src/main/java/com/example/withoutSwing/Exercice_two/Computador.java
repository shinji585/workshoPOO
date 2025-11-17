package com.example.withoutSwing.Exercice_two;

public class Computador extends Dispositivo {
    private double costo;

    public Computador(String marca, String modelo, String numeroSerie) {
        super(marca, modelo, numeroSerie);
        this.costo = 120.0;
    }

    @Override
    public double calcularCostoReparacion() {
        return costo;
    }

    @Override
    public String toString() {
        return "Computador;" + marca + ";" + modelo + ";" + numeroSerie + ";" + calcularCostoReparacion();
    }
}