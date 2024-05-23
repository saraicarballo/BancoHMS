package Banco.controlador;

import Banco.modelo.ApiBanco;

public class BuscarUsuarioControlador implements BuscarUsuarioControladorInterfaz {
	
	private ApiBanco api=ApiBanco.getInstance();

	@Override
	public String BuscarUsuario(String nombre) {
		api.buscarUsuario(nombre);
		return nombre;
	}
	

	
}