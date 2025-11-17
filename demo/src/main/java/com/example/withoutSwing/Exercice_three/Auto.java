package com.example.withoutSwing.Exercice_three;

public class Auto extends Vehiculo {
    public Auto(String placa, String marca, String modelo, double tarifaBase) {
        super(placa, marca, modelo, tarifaBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return tarifaBase * dias;
    }

    @Override
    public String toString() {
        return "Auto;" + placa + ";" + marca + ";" + modelo + ";" + tarifaBase;
    }
}
