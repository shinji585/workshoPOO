package com.example.withoutSwing.Exercice_two;

import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private List<Dispositivo> dispositivos;

    public Servicio() {
        this.dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public double calcularTotalServicio() {
        double total = 0;
        for (Dispositivo d : dispositivos) {
            total += d.calcularCostoReparacion();
        }
        return total;
    }

    public void mostrarResumen() {
        System.out.println("\n=== RESUMEN DE REPARACIONES ===");
        for (Dispositivo d : dispositivos) {
            System.out.println(d);
        }
        System.out.println("TOTAL SERVICIO: $" + calcularTotalServicio());
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }
}