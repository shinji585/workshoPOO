package com.example.withoutSwing.Exercice_two;

import java.util.Scanner;

public class SistemaMantenimiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Servicio servicio = new Servicio();
        boolean continuar = true;

        System.out.println("=== SISTEMA DE MANTENIMIENTO DE DISPOSITIVOS ===\n");

        while (continuar) {
            System.out.println("\n1. Agregar Celular");
            System.out.println("2. Agregar Computador");
            System.out.println("3. Agregar Tablet");
            System.out.println("4. Ver Resumen");
            System.out.println("5. Salir");
            System.out.print("Selecciona opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Marca: ");
                        String marcaCelular = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloCelular = scanner.nextLine();
                        System.out.print("Numero serie: ");
                        String serieCelular = scanner.nextLine();
                        servicio.agregarDispositivo(new Celular(marcaCelular, modeloCelular, serieCelular));
                        System.out.println("Celular agregado");
                        break;

                    case 2:
                        System.out.print("Marca: ");
                        String marcaComputador = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloComputador = scanner.nextLine();
                        System.out.print("Numero serie: ");
                        String serieComputador = scanner.nextLine();
                        servicio.agregarDispositivo(new Computador(marcaComputador, modeloComputador, serieComputador));
                        System.out.println("Computador agregado");
                        break;

                    case 3:
                        System.out.print("Marca: ");
                        String marcaTablet = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloTablet = scanner.nextLine();
                        System.out.print("Numero serie: ");
                        String serieTablet = scanner.nextLine();
                        servicio.agregarDispositivo(new Tablet(marcaTablet, modeloTablet, serieTablet));
                        System.out.println("Tablet agregada");
                        break;

                    case 4:
                        servicio.mostrarResumen();
                        break;

                    case 5:
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