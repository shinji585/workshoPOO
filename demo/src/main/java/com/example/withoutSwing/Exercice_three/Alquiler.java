package com.example.withoutSwing.Exercice_three;

import java.util.ArrayList;
import java.util.List;

public class Alquiler {
    private List<Vehiculo> vehiculos;
    private List<Integer> diasAlquiler;

    public Alquiler() {
        this.vehiculos = new ArrayList<>();
        this.diasAlquiler = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo, int dias) {
        vehiculos.add(vehiculo);
        diasAlquiler.add(dias);
    }

    public double calcularTotalAlquiler() {
        double total = 0;
        for (int i = 0; i < vehiculos.size(); i++) {
            total += vehiculos.get(i).calcularCostoAlquiler(diasAlquiler.get(i));
        }
        return total;
    }

    public void mostrarAlquileres() {
        System.out.println("\n=== REGISTRO DE ALQUILERES ===");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            int dias = diasAlquiler.get(i);
            double costo = v.calcularCostoAlquiler(dias);
            System.out.println(v + ";" + dias + " dias;" + costo);
        }
        System.out.println("TOTAL ALQUILER: $" + calcularTotalAlquiler());
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}