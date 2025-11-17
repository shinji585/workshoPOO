package com.example.withSwing.Sistema_De_Gestion_Empleados;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private List<Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(int id) {
        empleados.removeIf(e -> e.getId() == id);
    }

    public Empleado buscarEmpleado(int id) {
        for (Empleado e : empleados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}