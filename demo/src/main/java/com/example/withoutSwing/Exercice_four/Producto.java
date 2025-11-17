package com.example.withoutSwing.Exercice_four;

public  class Producto {
    protected String codigo;
    protected String nombre;
    protected double precioBase;
    protected int cantidad;

    public Producto(String codigo, String nombre, double precioBase, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidad = cantidad;
    }

    public double calcularPrecioTotal() {
        return precioBase * cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + precioBase + ";" + cantidad + ";" + calcularPrecioTotal();
    }
}