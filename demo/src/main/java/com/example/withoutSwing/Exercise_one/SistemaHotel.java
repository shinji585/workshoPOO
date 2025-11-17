package com.example.withoutSwing.Exercise_one;

import java.util.Scanner;

public class SistemaHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reserva reserva = new Reserva();
        boolean continuar = true;

        System.out.println("=== SISTEMA DE RESERVAS DE HOTEL ===\n");

        while (continuar) {
            System.out.println("\n1. Agregar Habitacion Simple");
            System.out.println("2. Agregar Habitacion Doble");
            System.out.println("3. Agregar Suite");
            System.out.println("4. Ver Total Reserva");
            System.out.println("5. Salir");
            System.out.print("Selecciona opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Numero habitacion: ");
                        int numSimple = scanner.nextInt();
                        System.out.print("Precio base: ");
                        double precioSimple = scanner.nextDouble();
                        System.out.print("Servicio internet: ");
                        double internetSimple = scanner.nextDouble();
                        reserva.agregarHabitacion(new HabitacionSimple(numSimple, precioSimple, internetSimple));
                        System.out.println("Habitacion Simple agregada");
                        break;

                    case 2:
                        System.out.print("Numero habitacion: ");
                        int numDoble = scanner.nextInt();
                        System.out.print("Precio base: ");
                        double precioDoble = scanner.nextDouble();
                        System.out.print("Servicio internet: ");
                        double internetDoble = scanner.nextDouble();
                        System.out.print("Desayuno: ");
                        double desayunoDoble = scanner.nextDouble();
                        reserva.agregarHabitacion(new HabitacionDoble(numDoble, precioDoble, internetDoble, desayunoDoble));
                        System.out.println("Habitacion Doble agregada");
                        break;

                    case 3:
                        System.out.print("Numero habitacion: ");
                        int numSuite = scanner.nextInt();
                        System.out.print("Precio base: ");
                        double precioSuite = scanner.nextDouble();
                        System.out.print("Servicio internet: ");
                        double internetSuite = scanner.nextDouble();
                        System.out.print("Desayuno: ");
                        double desayunoSuite = scanner.nextDouble();
                        System.out.print("Spa: ");
                        double spaSuite = scanner.nextDouble();
                        reserva.agregarHabitacion(new Suite(numSuite, precioSuite, internetSuite, desayunoSuite, spaSuite));
                        System.out.println("Suite agregada");
                        break;

                    case 4:
                        reserva.mostrarReserva();
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