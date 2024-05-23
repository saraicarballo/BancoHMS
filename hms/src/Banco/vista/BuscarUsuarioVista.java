package Banco.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Banco.controlador.BuscarUsuarioControlador;
import Banco.controlador.BuscarUsuarioControladorInterfaz;

public class BuscarUsuarioVista extends JPanel {
    private JTextField nombreUsuarioTextField;
    private JTextArea resultadoTextArea;

    public BuscarUsuarioVista() {
        setLayout(null);

        JLabel lblBuscarUsuario = new JLabel("BUSCAR USUARIO");
        lblBuscarUsuario.setFont(new Font("Dialog", Font.BOLD, 18));
        lblBuscarUsuario.setBounds(123, 12, 232, 34);
        add(lblBuscarUsuario);

        JLabel nombreUsuarioLabel = new JLabel("Nombre:");
        nombreUsuarioLabel.setVerticalAlignment(SwingConstants.TOP);
        nombreUsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nombreUsuarioLabel.setBounds(73, 61, 60, 17);
        add(nombreUsuarioLabel);

        nombreUsuarioTextField = new JTextField();
        nombreUsuarioTextField.setBounds(201, 57, 114, 19);
        add(nombreUsuarioTextField);
        nombreUsuarioTextField.setColumns(10);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(166, 100, 117, 25);
        add(buscarButton);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setBounds(73, 145, 289, 120);
        add(resultadoTextArea);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setBounds(79, 277, 319, 34);
        add(errorLabel);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreUsuarioTextField.getText();
                    BuscarUsuarioControladorInterfaz controlador = new BuscarUsuarioControlador();
                    String resultado = controlador.BuscarUsuario(nombre);
                    if (resultado != null) {
                        resultadoTextArea.setText(resultado);
                        errorLabel.setText("");
                    } else {
                        resultadoTextArea.setText("");
                        errorLabel.setText("Usuario no encontrado.");
                    }
                } catch (Exception ex) {
                    errorLabel.setText("Error al buscar usuario.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BuscarUsuarioVista());
        frame.setVisible(true);
    }
}
