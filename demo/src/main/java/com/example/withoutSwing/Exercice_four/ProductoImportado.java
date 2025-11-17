package com.example.withoutSwing.Exercice_four;

public class ProductoImportado extends Producto {
    private double impuestoImportacion;

    public ProductoImportado(String codigo, String nombre, double precioBase, int cantidad, double impuestoImportacion) {
        super(codigo, nombre, precioBase, cantidad);
        this.impuestoImportacion = impuestoImportacion;
    }

    @Override
    public double calcularPrecioTotal() {
        double subtotal = precioBase * cantidad;
        return subtotal + (subtotal * impuestoImportacion / 100);
    }

    public double getImpuestoImportacion() {
        return impuestoImportacion;
    }

    @Override
    public String toString() {
        return "Importado;" + codigo + ";" + nombre + ";" + precioBase + ";" + cantidad + ";" + impuestoImportacion + "%;" + calcularPrecioTotal();
    }
}