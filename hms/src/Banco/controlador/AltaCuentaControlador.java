package Banco.controlador;

import Banco.modelo.ApiBanco;

public class AltaCuentaControlador implements AltaCuentaControladorInterfaz {
	
	private ApiBanco api=ApiBanco.getInstance();
	


	public String altaCuenta(String nombre, String numeroCuenta) {
		api.altaCuenta(nombre, numeroCuenta);
		return null;
	}
}
