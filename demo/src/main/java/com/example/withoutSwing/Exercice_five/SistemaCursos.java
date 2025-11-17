package com.example.withoutSwing.Exercice_five;

import java.util.Scanner;

public class SistemaCursos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plataforma plataforma = new Plataforma();
        boolean continuar = true;

        System.out.println("=== SISTEMA DE GESTION DE CURSOS EN LINEA ===\n");

        while (continuar) {
            System.out.println("\n1. Agregar Curso Presencial");
            System.out.println("2. Agregar Curso Virtual");
            System.out.println("3. Ver Todos los Cursos");
            System.out.println("4. Salir");
            System.out.print("Selecciona opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Codigo: ");
                        String codigoPresencial = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombrePresencial = scanner.nextLine();
                        System.out.print("Duracion (horas): ");
                        int duracionPresencial = scanner.nextInt();
                        System.out.print("Costo base: ");
                        double costoPresencial = scanner.nextDouble();
                        System.out.print("Numero de sesiones: ");
                        int sesiones = scanner.nextInt();
                        System.out.print("Costo adicional por sesion: ");
                        double costoSesion = scanner.nextDouble();
                        plataforma.agregarCurso(new CursoPresencial(codigoPresencial, nombrePresencial, duracionPresencial, costoPresencial, sesiones, costoSesion));
                        System.out.println("Curso presencial agregado");
                        break;

                    case 2:
                        System.out.print("Codigo: ");
                        String codigoVirtual = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombreVirtual = scanner.nextLine();
                        System.out.print("Duracion (horas): ");
                        int duracionVirtual = scanner.nextInt();
                        System.out.print("Costo base: ");
                        double costoVirtual = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Plataforma: ");
                        String plataformaVirtual = scanner.nextLine();
                        System.out.print("Descuento (%): ");
                        double descuento = scanner.nextDouble();
                        plataforma.agregarCurso(new CursoVirtual(codigoVirtual, nombreVirtual, duracionVirtual, costoVirtual, plataformaVirtual, descuento));
                        System.out.println("Curso virtual agregado");
                        break;

                    case 3:
                        plataforma.mostrarCursos();
                        break;

                    case 4:
                        continuar = false;
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }
            } catch (Exception e) {
                System.out.println("error de tipo: " + e.getLocalizedMessage());
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}