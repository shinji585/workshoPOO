package com.example.withSwing.Sistema_De_Gestion_Empleados;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleados extends JFrame {
    private JTextField txtId, txtNombre, txtCargo, txtSalario, txtHoras;
    private JTable tabla;
    private DefaultTableModel modelo;
    private GestorEmpleados gestor;

    public VentanaEmpleados() {
        this.gestor = new GestorEmpleados();
        inicializar();
    }

    private void inicializar() {
        setTitle("Sistema de Gestion de Empleados");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(5, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos del Empleado"));

        panelSuperior.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelSuperior.add(txtId);

        panelSuperior.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelSuperior.add(txtNombre);

        panelSuperior.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        panelSuperior.add(txtCargo);

        panelSuperior.add(new JLabel("Salario Base:"));
        txtSalario = new JTextField();
        panelSuperior.add(txtSalario);

        panelSuperior.add(new JLabel("Horas Extras:"));
        txtHoras = new JTextField();
        panelSuperior.add(txtHoras);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnAgregar = new JButton("Agregar Empleado");
        btnAgregar.addActionListener(e -> agregarEmpleado());
        panelBotones.add(btnAgregar);

        JButton btnCalcular = new JButton("Calcular Salario");
        btnCalcular.addActionListener(e -> calcularSalario());
        panelBotones.add(btnCalcular);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminarEmpleado());
        panelBotones.add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panelBotones.add(btnLimpiar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(btnSalir);

        modelo = new DefaultTableModel(
                new String[] { "ID", "Nombre", "Cargo", "Salario Base", "Horas Extras", "Salario Total" }, 0);
        tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.add(panelSuperior);
        panelCentral.add(panelBotones);
        panelCentral.add(scrollPane);
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);

        add(panelPrincipal);
        setVisible(true);
    }

    private void agregarEmpleado() {
        try {
            if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCargo.getText().isEmpty() ||
                    txtSalario.getText().isEmpty() || txtHoras.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            String cargo = txtCargo.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            int horas = Integer.parseInt(txtHoras.getText());

            Empleado emp = new Empleado(id, nombre, cargo, salario, horas);
            gestor.agregarEmpleado(emp);
            modelo.addRow(new Object[] { id, nombre, cargo, salario, horas, emp.calcularSalarioTotal() });
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Empleado agregado correctamente", "Exito",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularSalario() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingresa ID del empleado:"));
            Empleado emp = gestor.buscarEmpleado(id);
            if (emp != null) {
                JOptionPane.showMessageDialog(this, "Salario Total: $" + emp.calcularSalarioTotal(),
                        "Calculo de Salario", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarEmpleado() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingresa ID del empleado a eliminar:"));
            Empleado emp = gestor.buscarEmpleado(id);
            if (emp != null) {
                gestor.eliminarEmpleado(id);
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if ((int) modelo.getValueAt(i, 0) == id) {
                        modelo.removeRow(i);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(this, "Empleado eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        txtHoras.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaEmpleados());
    }
}