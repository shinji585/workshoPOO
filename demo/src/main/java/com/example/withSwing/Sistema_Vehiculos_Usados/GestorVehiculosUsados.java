package com.example.withSwing.Sistema_Vehiculos_Usados;

import java.util.ArrayList;
import java.util.List;

public class GestorVehiculosUsados {
    private List<VehiculoUsado> vehiculos;

    public GestorVehiculosUsados() {
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(VehiculoUsado vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(String codigo) {
        vehiculos.removeIf(v -> v.getCodigo().equals(codigo));
    }

    public VehiculoUsado buscarVehiculo(String codigo) {
        for (VehiculoUsado v : vehiculos) {
            if (v.getCodigo().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    public VehiculoUsado getVehiculoMasCaro() {
        if (vehiculos.isEmpty()) return null;
        VehiculoUsado masCaro = vehiculos.get(0);
        for (VehiculoUsado v : vehiculos) {
            if (v.calcularPrecioVenta() > masCaro.calcularPrecioVenta()) {
                masCaro = v;
            }
        }
        return masCaro;
    }

    public VehiculoUsado getVehiculoMasEconomico() {
        if (vehiculos.isEmpty()) return null;
        VehiculoUsado masEconomico = vehiculos.get(0);
        for (VehiculoUsado v : vehiculos) {
            if (v.calcularPrecioVenta() < masEconomico.calcularPrecioVenta()) {
                masEconomico = v;
            }
        }
        return masEconomico;
    }

    public List<VehiculoUsado> getVehiculos() {
        return vehiculos;
    }
}
