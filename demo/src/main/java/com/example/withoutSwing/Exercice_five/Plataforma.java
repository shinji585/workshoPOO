package com.example.withoutSwing.Exercice_five;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private List<Curso> cursos;

    public Plataforma() {
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public double calcularTotalCursos() {
        double total = 0;
        for (Curso c : cursos) {
            total += c.calcularCostoTotal();
        }
        return total;
    }

    public void mostrarCursos() {
        System.out.println("\n=== REGISTRO DE CURSOS ===");
        for (Curso c : cursos) {
            System.out.println(c);
        }
        System.out.println("TOTAL INVERSION CURSOS: $" + calcularTotalCursos());
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}