package com.example.withSwing.Sistema_De_Gestion_Empleados;

public class Empleado {
    private int id;
    private String nombre;
    private String cargo;
    private double salarioBase;
    private int horasExtras;

    public Empleado(int id, String nombre, String cargo, double salarioBase, int horasExtras) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
    }

    public double calcularSalarioTotal() {
        double valorHoraExtra = (salarioBase * 0.10) / 160;
        return salarioBase + (horasExtras * valorHoraExtra);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasExtras() {
        return horasExtras;
    }
}
