package com.example.withSwing.Loguin;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    public VentanaLogin() {
        inicializar();
    }

    private void inicializar() {
        setTitle("Sistema de Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Credenciales"));

        panelFormulario.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        panelFormulario.add(txtUsuario);

        panelFormulario.add(new JLabel("Contrasena:"));
        txtContrasena = new JPasswordField();
        panelFormulario.add(txtContrasena);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(e -> validarLogin());
        panelBotones.add(btnIngresar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        panelBotones.add(btnSalir);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        setVisible(true);
    }

    private void validarLogin() {
        try {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String usuarioCorrecto = "admin";
            String contrasenaCorrecto = "1234";

            if (usuario.equals(usuarioCorrecto) && contrasena.equals(contrasenaCorrecto)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesion exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contrasena incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                limpiarCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtContrasena.setText("");
        txtUsuario.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaLogin());
    }
}