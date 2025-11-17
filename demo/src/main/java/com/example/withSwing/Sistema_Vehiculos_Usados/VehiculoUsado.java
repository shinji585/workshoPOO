package com.example.withSwing.Sistema_Vehiculos_Usados;

public class VehiculoUsado {
    private String codigo;
    private String marca;
    private String modelo;
    private int anio;
    private double precioBase;
    private String estado;
    private double ganancia;

    public VehiculoUsado(String codigo, String marca, String modelo, int anio, double precioBase, String estado, double ganancia) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioBase = precioBase;
        this.estado = estado;
        this.ganancia = ganancia;
    }

    public double calcularPrecioVenta() {
        double factorEstado = 0;
        
        switch (estado) {
            case "Excelente":
                factorEstado = 0.20;
                break;
            case "Bueno":
                factorEstado = 0.10;
                break;
            case "Regular":
                factorEstado = 0.05;
                break;
            case "Malo":
                factorEstado = 0;
                break;
        }
        
        return precioBase + (precioBase * factorEstado) + (precioBase * ganancia / 100);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public double getGanancia() {
        return ganancia;
    }

    @Override
    public String toString() {
        return codigo + ";" + marca + ";" + modelo + ";" + anio + ";" + precioBase + ";" + estado + ";" + ganancia + ";" + calcularPrecioVenta();
    }
}