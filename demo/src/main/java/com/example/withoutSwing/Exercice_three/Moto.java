package com.example.withoutSwing.Exercice_three;

public class Moto extends Vehiculo {
    public Moto(String placa, String marca, String modelo, double tarifaBase) {
        super(placa, marca, modelo, tarifaBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        return tarifaBase * dias * 0.8;
    }

    @Override
    public String toString() {
        return "Moto;" + placa + ";" + marca + ";" + modelo + ";" + tarifaBase;
    }
}
