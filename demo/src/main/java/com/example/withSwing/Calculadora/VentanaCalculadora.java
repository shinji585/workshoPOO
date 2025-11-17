package com.example.withSwing.Calculadora;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaCalculadora extends JFrame {
    private JTextField pantalla;
    private double numeroGuardado = 0;
    private String operador = "";
    private boolean nuevoNumero = true;

    public VentanaCalculadora() {
        inicializar();
    }

    private void inicializar() {
        setTitle("Calculadora Basica");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.PLAIN, 24));
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setText("0");
        panelPrincipal.add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 4, 5, 5));

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "Limpiar", "", ""
        };

        for (String boton : botones) {
            if (boton.isEmpty()) {
                panelBotones.add(new JPanel());
            } else {
                JButton btn = new JButton(boton);
                btn.setFont(new Font("Arial", Font.PLAIN, 18));
                btn.addActionListener(this::procesarBoton);
                panelBotones.add(btn);
            }
        }

        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        add(panelPrincipal);
        setVisible(true);
    }

    private void procesarBoton(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            if (comando.matches("[0-9]")) {
                if (nuevoNumero) {
                    pantalla.setText(comando);
                    nuevoNumero = false;
                } else {
                    pantalla.setText(pantalla.getText() + comando);
                }
            } else if (comando.equals(".")) {
                if (!pantalla.getText().contains(".")) {
                    pantalla.setText(pantalla.getText() + ".");
                }
            } else if (comando.equals("C")) {
                pantalla.setText("0");
                numeroGuardado = 0;
                operador = "";
                nuevoNumero = true;
            } else if (comando.equals("Limpiar")) {
                pantalla.setText("0");
                numeroGuardado = 0;
                operador = "";
                nuevoNumero = true;
            } else if (comando.matches("[+\\-*/]")) {
                double numero = Double.parseDouble(pantalla.getText());
                
                if (!operador.isEmpty()) {
                    calcular(numero);
                } else {
                    numeroGuardado = numero;
                }
                
                operador = comando;
                nuevoNumero = true;
            } else if (comando.equals("=")) {
                double numero = Double.parseDouble(pantalla.getText());
                calcular(numero);
                operador = "";
                nuevoNumero = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "error de tipo: " + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcular(double numero) {
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = numeroGuardado + numero;
                break;
            case "-":
                resultado = numeroGuardado - numero;
                break;
            case "*":
                resultado = numeroGuardado * numero;
                break;
            case "/":
                if (numero == 0) {
                    JOptionPane.showMessageDialog(this, "No se puede dividir entre cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                resultado = numeroGuardado / numero;
                break;
        }

        pantalla.setText(String.valueOf(resultado));
        numeroGuardado = resultado;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCalculadora());
    }
}