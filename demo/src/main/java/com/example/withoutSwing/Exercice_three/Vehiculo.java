package com.example.withoutSwing.Exercice_three;

public class Vehiculo {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected double tarifaBase;

    public Vehiculo(String placa, String marca, String modelo, double tarifaBase) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaBase = tarifaBase;
    }

    public double calcularCostoAlquiler(int dias) {
        return tarifaBase * dias;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    @Override
    public String toString() {
        return placa + ";" + marca + ";" + modelo + ";" + tarifaBase;
    }
}