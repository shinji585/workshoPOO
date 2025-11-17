package com.example.withSwing.SistemaVentasVehiculos;
public class VentaVehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cliente;
    private double precioBase;
    private double descuento;

    public VentaVehiculo(String placa, String marca, String modelo, String cliente, double precioBase, double descuento) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cliente = cliente;
        this.precioBase = precioBase;
        this.descuento = descuento;
    }

    public double calcularTotalPagar() {
        return precioBase - (precioBase * descuento / 100);
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCliente() {
        return cliente;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public String toString() {
        return placa + ";" + marca + ";" + modelo + ";" + cliente + ";" + precioBase + ";" + descuento + ";" + calcularTotalPagar();
    }
}