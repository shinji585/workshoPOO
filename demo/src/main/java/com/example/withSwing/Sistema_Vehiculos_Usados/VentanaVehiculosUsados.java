package com.example.withSwing.Sistema_Vehiculos_Usados;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

 
public class VentanaVehiculosUsados extends JFrame {
    private JTextField txtCodigo, txtMarca, txtModelo, txtAnio, txtPrecioBase, txtGanancia;
    private JComboBox<String> cmbEstado;
    private JTable tabla;
    private DefaultTableModel modeloveh;
    private GestorVehiculosUsados gestor;

    public VentanaVehiculosUsados() {
        this.gestor = new GestorVehiculosUsados();
        inicializar();
    }

    private void inicializar() {
        setTitle("Sistema de Venta de Vehiculos Usados");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(7, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos del Vehiculo"));

        panelSuperior.add(new JLabel("Codigo:"));
        txtCodigo = new JTextField();
        panelSuperior.add(txtCodigo);

        panelSuperior.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelSuperior.add(txtMarca);

        panelSuperior.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panelSuperior.add(txtModelo);

        panelSuperior.add(new JLabel("Año de Fabricacion:"));
        txtAnio = new JTextField();
        panelSuperior.add(txtAnio);

        panelSuperior.add(new JLabel("Precio Base de Compra:"));
        txtPrecioBase = new JTextField();
        panelSuperior.add(txtPrecioBase);

        panelSuperior.add(new JLabel("Estado:"));
        cmbEstado = new JComboBox<>(new String[]{"Excelente", "Bueno", "Regular", "Malo"});
        panelSuperior.add(cmbEstado);

        panelSuperior.add(new JLabel("Porcentaje de Ganancia:"));
        txtGanancia = new JTextField();
        panelSuperior.add(txtGanancia);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnRegistrar = new JButton("Registrar Vehiculo");
        btnRegistrar.addActionListener(e -> registrarVehiculo());
        panelBotones.add(btnRegistrar);

        JButton btnCalcular = new JButton("Calcular Precio Venta");
        btnCalcular.addActionListener(e -> calcularPrecioVenta());
        panelBotones.add(btnCalcular);

        JButton btnMostrar = new JButton("Mostrar Disponibles");
        btnMostrar.addActionListener(e -> mostrarDisponibles());
        panelBotones.add(btnMostrar);

        JButton btnEliminar = new JButton("Eliminar Registro");
        btnEliminar.addActionListener(e -> eliminarRegistro());
        panelBotones.add(btnEliminar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(btnSalir);

        modeloveh = new DefaultTableModel(new String[]{"Codigo", "Marca", "Modelo", "Ano", "Estado", "Precio Base", "Precio Venta"}, 0);
        tabla = new JTable(modeloveh);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(panelSuperior);
        panelCentral.add(panelBotones);
        panelCentral.add(scrollPane);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(panelPrincipal);
        setVisible(true);
    }

    private void registrarVehiculo() {
        try {
            if (txtCodigo.getText().isEmpty() || txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty() ||
                txtAnio.getText().isEmpty() || txtPrecioBase.getText().isEmpty() || txtGanancia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String codigo = txtCodigo.getText();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            double precioBase = Double.parseDouble(txtPrecioBase.getText());
            String estado = (String) cmbEstado.getSelectedItem();
            double ganancia = Double.parseDouble(txtGanancia.getText());

            if (anio < 1900 || anio > 2024) {
                JOptionPane.showMessageDialog(this, "El ano debe estar entre 1900 y 2024", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (ganancia < 0) {
                JOptionPane.showMessageDialog(this, "La ganancia no puede ser negativa", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            VehiculoUsado vehiculo = new VehiculoUsado(codigo, marca, modelo, anio, precioBase, estado, ganancia);
            gestor.agregarVehiculo(vehiculo);
            modeloveh.addRow(new Object[]{codigo, marca, modelo, anio, estado, precioBase, vehiculo.calcularPrecioVenta()});
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Vehiculo registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularPrecioVenta() {
        try {
            String codigo = JOptionPane.showInputDialog(this, "Ingresa codigo del vehiculo:");
            if (codigo != null && !codigo.isEmpty()) {
                VehiculoUsado vehiculo = gestor.buscarVehiculo(codigo);
                if (vehiculo != null) {
                    JOptionPane.showMessageDialog(this, "Precio de Venta: $" + vehiculo.calcularPrecioVenta(), "Precio Venta", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Vehiculo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarDisponibles() {
        try {
            VehiculoUsado masCaro = gestor.getVehiculoMasCaro();
            VehiculoUsado masEconomico = gestor.getVehiculoMasEconomico();

            String mensaje = "Vehiculos Disponibles:\n\n";
            
            if (masCaro != null) {
                mensaje += "Mas Caro:\n" + masCaro.getMarca() + " " + masCaro.getModelo() + " - $" + masCaro.calcularPrecioVenta() + "\n\n";
            }
            
            if (masEconomico != null) {
                mensaje += "Mas Economico:\n" + masEconomico.getMarca() + " " + masEconomico.getModelo() + " - $" + masEconomico.calcularPrecioVenta();
            }

            JOptionPane.showMessageDialog(this, mensaje, "Vehiculos Disponibles", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarRegistro() {
        try {
            String codigo = JOptionPane.showInputDialog(this, "Ingresa codigo del vehiculo a eliminar:");
            if (codigo != null && !codigo.isEmpty()) {
                VehiculoUsado vehiculo = gestor.buscarVehiculo(codigo);
                if (vehiculo != null) {
                    gestor.eliminarVehiculo(codigo);
                    for (int i = 0; i < modeloveh.getRowCount(); i++) {
                        if (modeloveh.getValueAt(i, 0).equals(codigo)) {
                            modeloveh.removeRow(i);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Vehiculo eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Vehiculo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtPrecioBase.setText("");
        txtGanancia.setText("");
        cmbEstado.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaVehiculosUsados());
    }
}