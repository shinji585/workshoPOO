package com.example.withSwing.RegistroEstudiante;

import java.util.List;
import java.util.ArrayList; 


public class GestorEstudiantes {
    private List<Estudiante> estudiantes;

    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}