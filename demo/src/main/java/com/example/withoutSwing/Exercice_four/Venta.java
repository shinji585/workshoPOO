package com.example.withoutSwing.Exercice_four;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<Producto> productos;

    public Venta() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotalVenta() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularPrecioTotal();
        }
        return total;
    }

    public void mostrarVentas() {
        System.out.println("\n=== DETALLE DE VENTAS ===");
        for (Producto p : productos) {
            System.out.println(p);
        }
        System.out.println("TOTAL VENTA: $" + calcularTotalVenta());
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
