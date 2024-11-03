package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyConverter {
    private static final double USD_TO_BRL = 5.70;
    private static final double BRL_TO_USD = 0.18;
    private static final double USD_TO_ARS = 989.02;
    private static final double ARS_TO_USD = 0.0010;
    private static final double USD_TO_COP = 4418.12;
    private static final double COP_TO_USD = 0.00023;

    public static void showConversionRate(double rate, double amount) {
        double convertedAmount = amount * rate;
        JOptionPane.showMessageDialog(null, "Monto convertido: " + convertedAmount);
    }

    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Conversor de Monedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create components
        JLabel labelOptions = new JLabel("Seleccione una opción:");
        String[] options = { 
            "Dólar => Peso Argentino", 
            "Peso Argentino => Dólar", 
            "Dólar => Real Brasileño",
            "Real Brasileño => Dólar",
            "Dólar => Peso Colombiano",
            "Peso Colombiano => Dólar",
            "Salir"
        };
        JComboBox<String> comboBox = new JComboBox<>(options);
        JLabel labelAmount = new JLabel("Monto:");
        JTextField fieldAmount = new JTextField(10);
        JButton convertButton = new JButton("Convertir");

        // Set up the layout
        frame.setLayout(new GridLayout(4, 1));
        frame.add(labelOptions);
        frame.add(comboBox);
        frame.add(labelAmount);
        frame.add(fieldAmount);
        frame.add(convertButton);

        // Add action listener to the button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedOption = (String) comboBox.getSelectedItem();
                    double amount = Double.parseDouble(fieldAmount.getText());

                    switch (selectedOption) {
                        case "Dólar => Peso Argentino":
                            showConversionRate(USD_TO_ARS, amount);
                            break;
                        case "Peso Argentino => Dólar":
                            showConversionRate(ARS_TO_USD, amount);
                            break;
                        case "Dólar => Real Brasileño":
                            showConversionRate(USD_TO_BRL, amount);
                            break;
                        case "Real Brasileño => Dólar":
                            showConversionRate(BRL_TO_USD, amount);
                            break;
                        case "Dólar => Peso Colombiano":
                            showConversionRate(USD_TO_COP, amount);
                            break;
                        case "Peso Colombiano => Dólar":
                            showConversionRate(COP_TO_USD, amount);
                            break;
                        case "Salir":
                            System.exit(0);
                            break;
                        default:
                            throw new IllegalArgumentException("Opción no válida");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Ingresa un número válido para el monto.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        // Make the window visible
        frame.setVisible(true);
    }
}
