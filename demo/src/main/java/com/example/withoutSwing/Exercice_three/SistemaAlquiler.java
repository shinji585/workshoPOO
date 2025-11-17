package com.example.withoutSwing.Exercice_three;

import java.util.Scanner;

public class SistemaAlquiler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Alquiler alquiler = new Alquiler();
        boolean continuar = true;

        System.out.println("=== SISTEMA DE ALQUILER DE VEHICULOS ===\n");

        while (continuar) {
            System.out.println("\n1. Alquilar Auto");
            System.out.println("2. Alquilar Moto");
            System.out.println("3. Alquilar Camion");
            System.out.println("4. Ver Total Alquiler");
            System.out.println("5. Salir");
            System.out.print("Selecciona opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Placa: ");
                        String placaAuto = scanner.nextLine();
                        System.out.print("Marca: ");
                        String marcaAuto = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloAuto = scanner.nextLine();
                        System.out.print("Tarifa base por dia: ");
                        double tarifaAuto = scanner.nextDouble();
                        System.out.print("Dias de alquiler: ");
                        int diasAuto = scanner.nextInt();
                        alquiler.agregarVehiculo(new Auto(placaAuto, marcaAuto, modeloAuto, tarifaAuto), diasAuto);
                        System.out.println("Auto alquilado");
                        break;

                    case 2:
                        System.out.print("Placa: ");
                        String placaMoto = scanner.nextLine();
                        System.out.print("Marca: ");
                        String marcaMoto = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloMoto = scanner.nextLine();
                        System.out.print("Tarifa base por dia: ");
                        double tarifaMoto = scanner.nextDouble();
                        System.out.print("Dias de alquiler: ");
                        int diasMoto = scanner.nextInt();
                        alquiler.agregarVehiculo(new Moto(placaMoto, marcaMoto, modeloMoto, tarifaMoto), diasMoto);
                        System.out.println("Moto alquilada");
                        break;

                    case 3:
                        System.out.print("Placa: ");
                        String placaCamion = scanner.nextLine();
                        System.out.print("Marca: ");
                        String marcaCamion = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modeloCamion = scanner.nextLine();
                        System.out.print("Tarifa base por dia: ");
                        double tarifaCamion = scanner.nextDouble();
                        System.out.print("Dias de alquiler: ");
                        int diasCamion = scanner.nextInt();
                        alquiler.agregarVehiculo(new Camion(placaCamion, marcaCamion, modeloCamion, tarifaCamion), diasCamion);
                        System.out.println("Camion alquilado");
                        break;

                    case 4:
                        alquiler.mostrarAlquileres();
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