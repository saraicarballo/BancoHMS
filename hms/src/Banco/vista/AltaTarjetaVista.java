package Banco.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Banco.controlador.AltaTarjetaControlador;
import Banco.controlador.AltaTarjetaInterfaz;

public class AltaTarjetaVista extends JPanel {
    private JTextField nombreTextField;
    private JTextField numeroTarjetaTextField;
    private JTextField tipoTarjetaTextField;
    private JTextField limiteGastoTextField;
    private JTextArea resultadoTextArea;

    public AltaTarjetaVista() {
        setLayout(null);

        JLabel lblAltaTarjeta = new JLabel("ALTA TARJETA");
        lblAltaTarjeta.setFont(new Font("Dialog", Font.BOLD, 18));
        lblAltaTarjeta.setBounds(123, 12, 232, 34);
        add(lblAltaTarjeta);

        JLabel nombreLabel = new JLabel("Nombre Usuario:");
        nombreLabel.setVerticalAlignment(SwingConstants.TOP);
        nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nombreLabel.setBounds(73, 61, 130, 17);
        add(nombreLabel);

        nombreTextField = new JTextField();
        nombreTextField.setBounds(215, 57, 114, 19);
        add(nombreTextField);
        nombreTextField.setColumns(10);

        JLabel numeroTarjetaLabel = new JLabel("Número Tarjeta:");
        numeroTarjetaLabel.setVerticalAlignment(SwingConstants.TOP);
        numeroTarjetaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        numeroTarjetaLabel.setBounds(73, 93, 130, 17);
        add(numeroTarjetaLabel);

        numeroTarjetaTextField = new JTextField();
        numeroTarjetaTextField.setBounds(215, 89, 114, 19);
        add(numeroTarjetaTextField);
        numeroTarjetaTextField.setColumns(10);

        JLabel tipoTarjetaLabel = new JLabel("Tipo Tarjeta:");
        tipoTarjetaLabel.setVerticalAlignment(SwingConstants.TOP);
        tipoTarjetaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tipoTarjetaLabel.setBounds(73, 123, 130, 17);
        add(tipoTarjetaLabel);

        tipoTarjetaTextField = new JTextField();
        tipoTarjetaTextField.setBounds(215, 119, 114, 19);
        add(tipoTarjetaTextField);
        tipoTarjetaTextField.setColumns(10);

        JLabel limiteGastoLabel = new JLabel("Límite Gasto:");
        limiteGastoLabel.setVerticalAlignment(SwingConstants.TOP);
        limiteGastoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        limiteGastoLabel.setBounds(73, 153, 130, 17);
        add(limiteGastoLabel);

        limiteGastoTextField = new JTextField();
        limiteGastoTextField.setBounds(215, 149, 114, 19);
        add(limiteGastoTextField);
        limiteGastoTextField.setColumns(10);

        JButton altaButton = new JButton("Alta");
        altaButton.setBounds(166, 186, 117, 25);
        add(altaButton);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setBounds(73, 223, 289, 80);
        add(resultadoTextArea);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(79, 315, 319, 34);
        add(errorLabel);

        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreTextField.getText();
                    String numeroTarjeta = numeroTarjetaTextField.getText();
                    String tipoTarjeta = tipoTarjetaTextField.getText();
                    double limiteGasto = Double.parseDouble(limiteGastoTextField.getText());

                    AltaTarjetaControlador controlador = new AltaTarjetaControlador();
                    String resultado = controlador.AltaTarjeta(nombre, numeroTarjeta, tipoTarjeta, limiteGasto);
                    if (resultado != null) {
                        resultadoTextArea.setText(resultado);
                        errorLabel.setText("");
                    } else {
                        resultadoTextArea.setText("");
                        errorLabel.setText("Error al dar de alta la tarjeta.");
                    }
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Formato de número incorrecto.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AltaTarjetaVista());
        frame.setVisible(true);
    }
}
