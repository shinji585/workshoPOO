package com.example.withSwing.SistemaVentasVehiculos;

import java.util.List;
import java.util.ArrayList;

public class GestorVentas {
    private List<VentaVehiculo> ventas;

    public GestorVentas() {
        this.ventas = new ArrayList<>();
    }

    public void agregarVenta(VentaVehiculo venta) {
        ventas.add(venta);
    }

    public void eliminarVenta(String placa) {
        ventas.removeIf(v -> v.getPlaca().equals(placa));
    }

    public double calcularTotalVentas() {
        double total = 0;
        for (VentaVehiculo v : ventas) {
            total += v.calcularTotalPagar();
        }
        return total;
    }

    public List<VentaVehiculo> getVentas() {
        return ventas;
    }
}