package com.example.withoutSwing.Exercice_four;

import java.util.Scanner;

public class SistemaTienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Venta venta = new Venta();
        boolean continuar = true;

        System.out.println("=== SISTEMA DE VENTAS - TIENDA VIRTUAL ===\n");

        while (continuar) {
            System.out.println("\n1. Agregar Producto Nacional");
            System.out.println("2. Agregar Producto Importado");
            System.out.println("3. Ver Detalle de Ventas");
            System.out.println("4. Salir");
            System.out.print("Selecciona opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Codigo: ");
                        String codigoNacional = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombreNacional = scanner.nextLine();
                        System.out.print("Precio base: ");
                        double precioNacional = scanner.nextDouble();
                        System.out.print("Cantidad: ");
                        int cantidadNacional = scanner.nextInt();
                        venta.agregarProducto(new Producto(codigoNacional, nombreNacional, precioNacional, cantidadNacional));
                        System.out.println("Producto nacional agregado");
                        break;

                    case 2:
                        System.out.print("Codigo: ");
                        String codigoImportado = scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombreImportado = scanner.nextLine();
                        System.out.print("Precio base: ");
                        double precioImportado = scanner.nextDouble();
                        System.out.print("Cantidad: ");
                        int cantidadImportado = scanner.nextInt();
                        System.out.print("Impuesto importacion (%): ");
                        double impuesto = scanner.nextDouble();
                        venta.agregarProducto(new ProductoImportado(codigoImportado, nombreImportado, precioImportado, cantidadImportado, impuesto));
                        System.out.println("Producto importado agregado");
                        break;

                    case 3:
                        venta.mostrarVentas();
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