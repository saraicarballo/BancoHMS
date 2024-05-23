package Banco.principal;


	import javax.swing.*;

import Banco.vista.AltaCuentaVista;
import Banco.vista.AltaTarjetaVista;
import Banco.vista.BuscarUsuarioVista;
import Banco.vista.ConsultarSaldoVista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class PantallaInicioBanco extends JFrame implements ActionListener {
		
		private JPanel contentPane;
	    private JMenuItem buscarUsuarioMenuItem;
	    private JMenuItem altaCuentaMenuItem;
	    private JMenuItem altaTarjetaMenuItem;
	    private JMenuItem consultarSaldoMenuItem;

	    public PantallaInicioBanco() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 603, 381);

	        JMenuBar menuBar = new JMenuBar();
	        setJMenuBar(menuBar);

	        JMenu usuarioMenu = new JMenu("Usuario");
	        menuBar.add(usuarioMenu);

	        buscarUsuarioMenuItem = new JMenuItem("Buscar Usuario");
	        usuarioMenu.add(buscarUsuarioMenuItem);
	        buscarUsuarioMenuItem.addActionListener(this);

	        JMenu cuentaMenu = new JMenu("Cuenta");
	        menuBar.add(cuentaMenu);

	        altaCuentaMenuItem = new JMenuItem("Alta Cuenta");
	        cuentaMenu.add(altaCuentaMenuItem);
	        altaCuentaMenuItem.addActionListener(this);

	        JMenu tarjetaMenu = new JMenu("Tarjeta");
	        menuBar.add(tarjetaMenu);

	        altaTarjetaMenuItem = new JMenuItem("Alta Tarjeta");
	        tarjetaMenu.add(altaTarjetaMenuItem);
	        altaTarjetaMenuItem.addActionListener(this);

	        JMenu consultaMenu = new JMenu("Consulta");
	        menuBar.add(consultaMenu);

	        consultarSaldoMenuItem = new JMenuItem("Consultar Saldo");
	        consultaMenu.add(consultarSaldoMenuItem);
	        consultarSaldoMenuItem.addActionListener(this);

	        setVisible(true);
	    }

	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == buscarUsuarioMenuItem) {
	        	BuscarUsuarioVista buscarUsuarioVista = new BuscarUsuarioVista();
	            setContentPane(buscarUsuarioVista);
	            setVisible(true);
	        } else if (e.getSource() == altaTarjetaMenuItem) {
	            AltaTarjetaVista altaTarjetaVista = new AltaTarjetaVista();
	            setContentPane(altaTarjetaVista);
	            setVisible(true);
	        } else if (e.getSource() == consultarSaldoMenuItem) {
	            ConsultarSaldoVista consultarSaldoVista = new ConsultarSaldoVista();
	            setContentPane(consultarSaldoVista);
	        } else if (e.getSource() == altaCuentaMenuItem) {
	            AltaCuentaVista consultarSaldoVista = new AltaCuentaVista();
	            setContentPane(consultarSaldoVista);

	        }else {
	            System.out.println("Fin");
	        }
	    }
	    
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	                PantallaInicioBanco frame = new PantallaInicioBanco();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }
	
}
