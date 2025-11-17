package com.example.withoutSwing.Exercice_two;

public class Dispositivo {
    protected String marca;
    protected String modelo;
    protected String numeroSerie;

    public Dispositivo(String marca, String modelo, String numeroSerie) {
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
    }

    public double calcularCostoReparacion() {
        return 0;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    @Override
    public String toString() {
        return marca + ";" + modelo + ";" + numeroSerie + ";" + calcularCostoReparacion();
    }
}
