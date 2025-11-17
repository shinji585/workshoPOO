package com.example.withoutSwing.Exercice_three;

public class Camion extends Vehiculo {
    public Camion(String placa, String marca, String modelo, double tarifaBase) {
        super(placa, marca, modelo, tarifaBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return tarifaBase * dias * 1.5;
    }

    @Override
    public String toString() {
        return "Camion;" + placa + ";" + marca + ";" + modelo + ";" + tarifaBase;
    }
}
