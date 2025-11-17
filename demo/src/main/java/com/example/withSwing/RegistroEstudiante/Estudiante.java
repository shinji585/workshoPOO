package com.example.withSwing.RegistroEstudiante;

public class Estudiante {
    private String nombre;
    private String documento;
    private String programa;
    private double promedio;

    public Estudiante(String nombre, String documento, String programa, double promedio) {
        this.nombre = nombre;
        this.documento = documento;
        this.programa = programa;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getPrograma() {
        return programa;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return nombre + ";" + documento + ";" + programa + ";" + promedio;
    }
}

