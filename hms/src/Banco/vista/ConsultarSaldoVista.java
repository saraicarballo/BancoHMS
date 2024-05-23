package Banco.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Banco.controlador.ConsultarSaldoControlador;
import Banco.controlador.ConsultarSaldoInterfaz;

public class ConsultarSaldoVista extends JPanel {
    private JTextField nombreTextField;
    private JTextField numeroCuentaTextField;
    private JTextArea resultadoTextArea;

    public ConsultarSaldoVista() {
        setLayout(null);

        JLabel lblConsultarSaldo = new JLabel("CONSULTAR SALDO");
        lblConsultarSaldo.setFont(new Font("Dialog", Font.BOLD, 18));
        lblConsultarSaldo.setBounds(123, 12, 232, 34);
        add(lblConsultarSaldo);

        JLabel nombreUsuarioLabel = new JLabel("Nombre Usuario:");
        nombreUsuarioLabel.setVerticalAlignment(SwingConstants.TOP);
        nombreUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nombreUsuarioLabel.setBounds(73, 61, 130, 17);
        add(nombreUsuarioLabel);

        nombreTextField = new JTextField();
        nombreTextField.setBounds(215, 57, 114, 19);
        add(nombreTextField);
        nombreTextField.setColumns(10);

        JLabel numeroCuentaLabel = new JLabel("Número Cuenta:");
        numeroCuentaLabel.setVerticalAlignment(SwingConstants.TOP);
        numeroCuentaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        numeroCuentaLabel.setBounds(73, 93, 130, 17);
        add(numeroCuentaLabel);

        numeroCuentaTextField = new JTextField();
        numeroCuentaTextField.setBounds(215, 89, 114, 19);
        add(numeroCuentaTextField);
        numeroCuentaTextField.setColumns(10);

        JButton consultarButton = new JButton("Consultar");
        consultarButton.setBounds(166, 130, 117, 25);
        add(consultarButton);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setBounds(73, 167, 289, 80);
        add(resultadoTextArea);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(79, 259, 319, 34);
        add(errorLabel);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreTextField.getText();
                    String numeroCuenta = numeroCuentaTextField.getText();

                    ConsultarSaldoControlador controlador = new ConsultarSaldoControlador();
                    double saldo = controlador.ConsultarSaldo(nombre, numeroCuenta);

                    if (saldo >= 0) {
                        resultadoTextArea.setText("Saldo actual: " + saldo);
                        errorLabel.setText("");
                    } else {
                        resultadoTextArea.setText("");
                        errorLabel.setText("Error al consultar el saldo.");
                    }
                } catch (Exception ex) {
                    errorLabel.setText("Error al consultar el saldo.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ConsultarSaldoVista());
        frame.setVisible(true);
    }
}
