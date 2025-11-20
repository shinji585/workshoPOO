# Workshop POO - Sistema de Inventario y Ventas

[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/shinji585/workshoPOO)

## Descripción General

Este proyecto es un sistema completo de **Inventario y Ventas** desarrollado en **Java** utilizando arquitectura **Modelo-Vista-Controlador (MVC)**. Implementa conceptos avanzados de **Programación Orientada a Objetos (POO)** como herencia, polimorfismo, encapsulación y abstracción.

El sistema permite:
- ✅ Gestión de productos (CRUD completo)
- ✅ Procesamiento de ventas en tiempo real
- ✅ Generación de reportes dinámicos
- ✅ Interfaz gráfica profesional con Swing
- ✅ Sincronización automática entre inventario y ventas

## Estructura del Proyecto

```
src/main/java/com/example/
├── modelo/
│   ├── Producto.java          # Clase modelo para productos
│   ├── Cliente.java           # Clase modelo para clientes
│   ├── ItemVenta.java         # Clase modelo para items de venta
│   ├── Venta.java             # Clase modelo para ventas
│   └── Inventario.java        # Singleton que gestiona todo
├── vista/
│   ├── VentanaPrincipal.java  # Ventana principal con sidebar
│   ├── PanelInventario.java   # Panel de gestión de inventario
│   ├── PanelPOS.java          # Panel de punto de venta
│   └── PanelReportes.java     # Panel de reportes
├── controlador/
│   ├── ControladorPrincipal.java     # Orquesta los paneles
│   ├── ControladorInventario.java    # Controla inventario
│   ├── ControladorPos.java           # Controla ventas
│   └── ControladorReportes.java      # Controla reportes
└── Main.java                  # Punto de entrada
```

## Conceptos de POO Implementados

### 1. **Encapsulación**
Cada clase encapsula sus datos privados con getters y setters públicos, protegiendo la integridad de los datos.

### 2. **Herencia y Polimorfismo**
Los controladores heredan métodos comunes y se especializan en sus funciones específicas. El patrón MVC permite polimorfismo en la presentación.

### 3. **Singleton Pattern**
`Inventario.getInstance()` implementa el patrón Singleton para garantizar una única instancia en toda la aplicación.

### 4. **Abstracción**
Las vistas abstraen la complejidad de Swing, los controladores abstraen la lógica de negocio.

### 5. **Collections y Streams**
Uso de `ArrayList`, `List` y operaciones funcionales con `stream()` para filtrado y búsqueda de datos.

## Ejercicios Grabados

Se grabaron **4 ejercicios principales** que demuestran los conceptos fundamentales:

1. **Sistema de Reservas de Hotel** - Herencia y polimorfismo básico
2. **Sistema de Alquiler de Vehículos** - Cálculos dinámicos según tipo
3. **Sistema de Ventas (CRUD)** - Operaciones completas de datos
4. **Sistema de Reportes** - Análisis y agregación de datos

> **Nota:** Los ejercicios restantes siguen el mismo patrón, variando solo la lógica de negocio.

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

Se incluye un video grabado explicando los 4 ejercicios principales y cómo funcionan los conceptos de POO en este proyecto.

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