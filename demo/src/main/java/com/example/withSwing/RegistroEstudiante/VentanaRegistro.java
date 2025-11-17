package com.example.withSwing.RegistroEstudiante;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

class VentanaRegistro extends JFrame {
    private JTextField txtNombre, txtDocumento, txtPrograma, txtPromedio;
    private JTable tabla;
    private DefaultTableModel modelo;
    private GestorEstudiantes gestor;

    public VentanaRegistro() {
        this.gestor = new GestorEstudiantes();
        inicializar();
    }

    private void inicializar() {
        setTitle("Registro de Estudiantes");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(4, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Datos del Estudiante"));

        panelSuperior.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelSuperior.add(txtNombre);

        panelSuperior.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        panelSuperior.add(txtDocumento);

        panelSuperior.add(new JLabel("Programa:"));
        txtPrograma = new JTextField();
        panelSuperior.add(txtPrograma);

        panelSuperior.add(new JLabel("Promedio:"));
        txtPromedio = new JTextField();
        panelSuperior.add(txtPromedio);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarEstudiante());
        panelBotones.add(btnGuardar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panelBotones.add(btnLimpiar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(btnSalir);

        modelo = new DefaultTableModel(new String[]{"Nombre", "Documento", "Programa", "Promedio"}, 0);
        tabla = new JTable(modelo);
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

    private void guardarEstudiante() {
        try {
            if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || 
                txtPrograma.getText().isEmpty() || txtPromedio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String programa = txtPrograma.getText();
            double promedio = Double.parseDouble(txtPromedio.getText());

            if (promedio < 0 || promedio > 5) {
                JOptionPane.showMessageDialog(this, "El promedio debe estar entre 0 y 5", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Estudiante est = new Estudiante(nombre, documento, programa, promedio);
            gestor.agregarEstudiante(est);
            modelo.addRow(new Object[]{nombre, documento, programa, promedio});
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Estudiante registrado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtPrograma.setText("");
        txtPromedio.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaRegistro());
    }
}