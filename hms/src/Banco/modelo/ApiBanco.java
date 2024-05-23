package Banco.modelo;
import java.util.ArrayList;
import java.util.List;
public class ApiBanco {

private static ApiBanco instancia = new ApiBanco();
	    
	    private List<Usuario> usuarios;

	    private ApiBanco() {
	        usuarios = new ArrayList<>();
	    }

	    public static ApiBanco getInstance() {
	        return instancia;
	    }

	  
	    public Usuario buscarUsuario(String nombre) {
	        for (Usuario usuario : usuarios) {
	            if (usuario.getNombre().equals(nombre)) {
	                return usuario;
	            }
	        }
	        return null;
	    }

	    public void altaCuenta(String nombre, String numeroCuenta) {
	        Usuario usuario = buscarUsuario(nombre);
	        if (usuario != null) {
	            CuentaBancaria cuentaBancaria = new CuentaBancaria(numeroCuenta);
	            usuario.agregarCuentaBancaria(cuentaBancaria);
	        }
	    }

	    public void altaTarjeta(String nombre, String numeroTarjeta, String tipo, double limiteGasto) {
	        Usuario usuario = buscarUsuario(nombre);
	        if (usuario != null) {
	            TarjetaBancaria tarjetaBancaria = new TarjetaBancaria(numeroTarjeta, tipo, limiteGasto, usuario);
	            usuario.setTarjetaBancaria(tarjetaBancaria);
	        }
	    }

	    public String[] obtenerUsuarios() {
	        String[] usuariosString = new String[usuarios.size()];
	        for (int i = 0; i < usuarios.size(); i++) {
	            Usuario usuario = usuarios.get(i);
	            usuariosString[i] = usuario.getNombre();
	        }
	        return usuariosString;
	    }


	    public String[] obtenerCuentasUsuario(String nombre) {
	        Usuario usuario = buscarUsuario(nombre);
	        if (usuario != null) {
	            List<CuentaBancaria> cuentas = usuario.getCuentasBancarias();
	            String[] cuentasString = new String[cuentas.size()];
	            for (int i = 0; i < cuentas.size(); i++) {
	                cuentasString[i] = cuentas.get(i).getNumeroCuenta() + " - Saldo: " + cuentas.get(i).getSaldo();
	            }
	            return cuentasString;
	        }
	        return null;
	    }

	    public String[] obtenerTarjetasUsuario(String nombre) {
	        Usuario usuario = buscarUsuario(nombre);
	        if (usuario != null) {
	            List<TarjetaBancaria> tarjetas = usuario.getTarjetaBancaria();
	            String[] tarjetasString = new String[tarjetas.size()];
	            for (int i = 0; i < tarjetas.size(); i++) {
	                tarjetasString[i] = tarjetas.get(i).getNumeroTarjeta() + " - Tipo: " + tarjetas.get(i).getTipo() + " - Límite: " + tarjetas.get(i).getLimiteGasto();
	            }
	            return tarjetasString;
	        }
	        return null;
	    }
	    public double consultarSaldo(String nombre, String numeroCuenta) {
	        Usuario usuario = buscarUsuario(nombre);
	        if (usuario != null) {
	            List<CuentaBancaria> cuentas = usuario.getCuentasBancarias();
	            for (CuentaBancaria cuenta : cuentas) {
	                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
	                    return cuenta.getSaldo();
	                }
	            }
	        }
	        return -1; 
	    }

		
	}


