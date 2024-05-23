package Banco.controlador;

import Banco.modelo.ApiBanco;

public class AltaTarjetaControlador implements AltaTarjetaInterfaz{

	private ApiBanco api=ApiBanco.getInstance();


	@Override
	public String AltaTarjeta(String nombreUsuario, String numeroTarjeta, String tipo, double limiteGasto) {
		api.altaTarjeta(nombreUsuario, numeroTarjeta, tipo, limiteGasto);
		return tipo;
		
	}
}