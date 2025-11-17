package com.example.withoutSwing.Exercise_one;

public class HabitacionDoble extends Habitacion {
    private double servicioInternet;
    private double desayuno;

    public HabitacionDoble(int numero, double precioBase, double servicioInternet, double desayuno) {
        super(numero, precioBase);
        this.servicioInternet = servicioInternet;
        this.desayuno = desayuno;
    }

    @Override
    public double calcularCosto() {
        return precioBase + servicioInternet + desayuno;
    }

    public double getServicioInternet() {
        return servicioInternet;
    }

    public double getDesayuno() {
        return desayuno;
    }

    @Override
    public String toString() {
        return numero + ";Doble;" + precioBase + ";" + servicioInternet + ";" + desayuno + ";" + calcularCosto();
    }
}