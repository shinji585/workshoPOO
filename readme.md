# Workshop POO - Sistema de Inventario y Ventas

[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/shinji585/workshoPOO)

## Descripción General

Este proyecto contiene **12 ejercicios** del taller de **Programación Orientada a Objetos (POO)** en **Java**. Los ejercicios están divididos en dos categorías: 5 ejercicios de POO puro y 7 ejercicios usando interfaz gráfica con Swing. 

Cada ejercicio implementa conceptos como herencia, polimorfismo, encapsulación, abstracción y patrones de diseño.

## Estructura del Proyecto

```
src/main/java/com/example/
├── withoutSwing/
│   ├── Ejercicio_one/
│   ├── Ejercicio_two/
│   ├── Ejercicio_three/
│   ├── Ejercicio_four/
│   ├── Ejercicio_five/
│   └── Main.java
├── withSwing/
│   ├── Calculadora/
│   ├── Login/
│   ├── RegistroEstudiante/
│   ├── Sistema_De_Gestion.../
│   ├── Sistema_Vehiculos_Us.../
│   └── SistemaVentasVehicul.../
└── Main.java
```

## Conceptos de POO Implementados

### 1. **Herencia**
Cada ejercicio implementa clases padre que son extendidas por subclases especializadas. Ejemplo: Habitacion → HabitacionSimple, HabitacionDoble, Suite.

### 2. **Polimorfismo**
Los métodos redefinidos en las subclases permiten comportamientos diferentes. Ejemplo: calcularCosto() varía según el tipo de habitación.

### 3. **Encapsulación**
Los atributos son privados y se accede a ellos mediante getters y setters públicos.

### 4. **Abstracción**
Las clases padre definen la interfaz general que las subclases implementan según su contexto específico.

### 5. **Collections**
Uso de ArrayList y List para almacenar y gestionar múltiples objetos en cada ejercicio.

## Ejercicios Implementados

El proyecto contiene **12 ejercicios** divididos en dos categorías:

### Ejercicios sin Swing (POO Puro)
1. Sistema de Reservas de Hotel
2. Sistema de Mantenimiento de Dispositivos
3. Sistema de Alquiler de Vehículos
4. Sistema de Ventas de Tienda Virtual
5. Sistema de Gestión de Cursos en Línea

### Ejercicios con Swing (Interfaz Gráfica)
1. Sistema de Gestión de Empleados
2. Calculadora Básica
3. Registro de Estudiantes
4. Sistema de Ventas de Vehículos Nuevos
5. Sistema de Login
6. Sistema de Venta de Vehículos Usados
7. Sistema Integrado de Inventario y Ventas (SynchroSale)

## Funcionalidades Principales

### 📦 Inventario
- Crear, leer, actualizar y eliminar productos
- Buscar productos por nombre
- Validación de precios y stock
- Categorización de productos

### 🛒 Punto de Venta
- Agregar productos al carrito
- Modificar cantidades
- Calcular automáticamente IVA (16%)
- Procesar ventas y descontar stock
- Selección de cliente

### 📊 Reportes
- Productos más vendidos
- Historial de ventas
- Productos con stock bajo
- Estadísticas generales
- Listas completas de productos y clientes

## Tecnologías Utilizadas

- **Lenguaje:** Java 11+
- **Build Tool:** Maven
- **GUI Framework:** Swing
- **Patrón:** MVC (Model-View-Controller)
- **Patrón de Diseño:** Singleton

## Requisitos Previos

- JDK 11 o superior
- Maven 3.6+
- Git

## Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone <URL_DEL_REPO>
cd Sistema_Inventario
```

### 2. Compilar el proyecto
```bash
mvn clean compile
```

### 3. Ejecutar la aplicación
```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

O ejecutar directamente desde tu IDE favorito.

## Estructura de Datos

### Producto
```java
- id: int
- nombre: String
- descripcion: String
- precio: double
- stock: int
- categoria: String
```

### Cliente
```java
- id: int
- nombre: String
- telefono: String
- email: String
- direccion: String
```

### Venta
```java
- id: int
- cliente: Cliente
- items: List<ItemVenta>
- fecha: LocalDateTime
- total: double (incluye IVA)
```

## Diagrama UML

Para visualizar los diagramas UML completos de cada clase y sus relaciones, ingresa a:

[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/shinji585/workshoPOO)

## Video Explicativo

Se incluye video grabado explicando los conceptos principales de POO implementados en los ejercicios.

## Mejoras Futuras

- [ ] Persistencia en base de datos (SQL)
- [ ] Exportar reportes a PDF
- [ ] Autenticación de usuarios
- [ ] Sistema de permisos por rol
- [ ] Historial de cambios en inventario

## Autor

**Nombre:** [Tu Nombre]  
**Fecha:** 2024  
**Institución:** [Tu Universidad]

## Licencia

Este proyecto es para fines educativos. Siéntete libre de usar y modificar el código.

---

**¡Gracias por revisar este proyecto!** 🚀