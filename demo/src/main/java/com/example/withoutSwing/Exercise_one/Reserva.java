package com.example.withoutSwing.Exercise_one;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private List<Habitacion> habitaciones;

    public Reserva() {
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public double calcularTotalReserva() {
        double total = 0;
        for (Habitacion h : habitaciones) {
            total += h.calcularCosto();
        }
        return total;
    }

    public void mostrarReserva() {
        System.out.println("\n=== DETALLES DE LA RESERVA ===");
        for (Habitacion h : habitaciones) {
            System.out.println(h);
        }
        System.out.println("TOTAL A PAGAR: $" + calcularTotalReserva());
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}