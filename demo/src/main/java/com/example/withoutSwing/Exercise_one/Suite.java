package com.example.withoutSwing.Exercise_one;

public class Suite extends Habitacion {
    private double servicioInternet;
    private double desayuno;
    private double spa;

    public Suite(int numero, double precioBase, double servicioInternet, double desayuno, double spa) {
        super(numero, precioBase);
        this.servicioInternet = servicioInternet;
        this.desayuno = desayuno;
        this.spa = spa;
    }

    @Override
    public double calcularCosto() {
        return precioBase + servicioInternet + desayuno + spa;
    }

    public double getServicioInternet() {
        return servicioInternet;
    }

    public double getDesayuno() {
        return desayuno;
    }

    public double getSpa() {
        return spa;
    }

    @Override
    public String toString() {
        return numero + ";Suite;" + precioBase + ";" + servicioInternet + ";" + desayuno + ";" + spa + ";" + calcularCosto();
    }
}