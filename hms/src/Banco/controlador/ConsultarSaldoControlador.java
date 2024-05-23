package Banco.controlador;

import Banco.modelo.ApiBanco;

public class ConsultarSaldoControlador implements ConsultarSaldoInterfaz {
	
	private ApiBanco api=ApiBanco.getInstance();
	
	@Override
	

	public double ConsultarSaldo(String nombre, String numeroCuenta) {
		return api.consultarSaldo(nombre, numeroCuenta);
		
	}
}