package com.example.withoutSwing.Exercise_one;

public class HabitacionSimple extends Habitacion {
    private double servicioInternet;

    public HabitacionSimple(int numero, double precioBase, double servicioInternet) {
        super(numero, precioBase);
        this.servicioInternet = servicioInternet;
    }

    @Override
    public double calcularCosto() {
        return precioBase + servicioInternet;
    }

    public double getServicioInternet() {
        return servicioInternet;
    }

    @Override
    public String toString() {
        return numero + ";Simple;" + precioBase + ";" + servicioInternet + ";" + calcularCosto();
    }
}