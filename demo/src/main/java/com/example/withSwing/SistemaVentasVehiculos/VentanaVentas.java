package com.example.withSwing.SistemaVentasVehiculos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class VentanaVentas extends JFrame {
    private JTextField txtPlaca, txtModeloVeh, txtPrecioBase, txtDescuento, txtCliente;
    private JComboBox<String> cmbMarca;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTotal;
    private GestorVentas gestor;

    public VentanaVentas() {
        this.gestor = new GestorVentas();
        inicializar();
    }

    private void inicializar() {
        setTitle("Sistema de Ventas de Vehiculos Nuevos");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(6, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos de la Venta"));

        panelSuperior.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panelSuperior.add(txtPlaca);

        panelSuperior.add(new JLabel("Marca:"));
        cmbMarca = new JComboBox<>(new String[]{"Toyota", "Mazda", "Renault", "Chevrolet", "Nissan"});
        panelSuperior.add(cmbMarca);

        panelSuperior.add(new JLabel("Modelo:"));
        txtModeloVeh = new JTextField();
        panelSuperior.add(txtModeloVeh);

        panelSuperior.add(new JLabel("Precio Base:"));
        txtPrecioBase = new JTextField();
        panelSuperior.add(txtPrecioBase);

        panelSuperior.add(new JLabel("Descuento (%):"));
        txtDescuento = new JTextField();
        panelSuperior.add(txtDescuento);

        panelSuperior.add(new JLabel("Nombre Cliente:"));
        txtCliente = new JTextField();
        panelSuperior.add(txtCliente);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnAgregar = new JButton("Agregar Venta");
        btnAgregar.addActionListener(e -> agregarVenta());
        panelBotones.add(btnAgregar);

        JButton btnCalcular = new JButton("Calcular Total");
        btnCalcular.addActionListener(e -> calcularTotal());
        panelBotones.add(btnCalcular);

        JButton btnEliminar = new JButton("Eliminar Venta");
        btnEliminar.addActionListener(e -> eliminarVenta());
        panelBotones.add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panelBotones.add(btnLimpiar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(btnSalir);

        modelo = new DefaultTableModel(new String[]{"Placa", "Marca", "Modelo", "Cliente", "Precio Base", "Descuento %", "Total a Pagar"}, 0);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        lblTotal = new JLabel("Total Ventas del Dia: $0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(panelSuperior);
        panelCentral.add(panelBotones);
        panelCentral.add(scrollPane);
        panelCentral.add(lblTotal);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(panelPrincipal);
        setVisible(true);
    }

    private void agregarVenta() {
        try {
            if (txtPlaca.getText().isEmpty() || txtModeloVeh.getText().isEmpty() || 
                txtPrecioBase.getText().isEmpty() || txtDescuento.getText().isEmpty() || txtCliente.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String placa = txtPlaca.getText();
            String marca = (String) cmbMarca.getSelectedItem();
            String modeloVeh = txtModeloVeh.getText();
            double precioBase = Double.parseDouble(txtPrecioBase.getText());
            double descuento = Double.parseDouble(txtDescuento.getText());
            String cliente = txtCliente.getText();

            if (descuento < 0 || descuento > 100) {
                JOptionPane.showMessageDialog(this, "El descuento debe estar entre 0 y 100", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            VentaVehiculo venta = new VentaVehiculo(placa, marca, modeloVeh, cliente, precioBase, descuento);
            gestor.agregarVenta(venta);
            modelo.addRow(new Object[]{placa, marca, modeloVeh, cliente, precioBase, descuento, venta.calcularTotalPagar()});
            actualizarTotal();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Venta agregada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularTotal() {
        double total = gestor.calcularTotalVentas();
        JOptionPane.showMessageDialog(this, "Total de Ventas: $" + total, "Total Ventas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void eliminarVenta() {
        try {
            String placa = JOptionPane.showInputDialog(this, "Ingresa placa de la venta a eliminar:");
            if (placa != null && !placa.isEmpty()) {
                gestor.eliminarVenta(placa);
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (modelo.getValueAt(i, 0).equals(placa)) {
                        modelo.removeRow(i);
                        break;
                    }
                }
                actualizarTotal();
                JOptionPane.showMessageDialog(this, "Venta eliminada", "Exito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTotal() {
        double total = gestor.calcularTotalVentas();
        lblTotal.setText("Total Ventas del Dia: $" + String.format("%.2f", total));
    }

    private void limpiarCampos() {
        txtPlaca.setText("");
        txtModeloVeh.setText("");
        txtPrecioBase.setText("");
        txtDescuento.setText("");
        txtCliente.setText("");
        cmbMarca.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaVentas());
    }
}