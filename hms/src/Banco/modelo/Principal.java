package Banco.modelo;

	import java.util.ArrayList;
	import java.util.List;

public class Principal {
	    private final int MAXIMO_USUARIOS = 100;
	    private static List<Usuario> usuarios;

	    public Principal() {
	        usuarios = new ArrayList<>();
	    }

	    public static void main(String[] args) {
	      

	     
	        Usuario usuario1 = new Usuario("Juan Perez",  "123");
	        Usuario usuario2 = new Usuario("Maria Gomez", "456");

	    
	        CuentaBancaria cuenta1 = new CuentaBancaria("1234567890");
	        cuenta1.ingresar(500.0);
	        usuario1.agregarCuentaBancaria(cuenta1);

	        CuentaBancaria cuenta2 = new CuentaBancaria("0987654321");
	        cuenta2.ingresar(1000.0);
	        usuario2.agregarCuentaBancaria(cuenta2);

	     
	        TarjetaBancaria tarjeta1 = new TarjetaBancaria("1111222233334444", "Crédito", 2000.0, usuario1);
	        usuario1.setTarjetaBancaria(tarjeta1);

	        TarjetaBancaria tarjeta2 = new TarjetaBancaria("5555666677778888", "Débito", 1500.0, usuario2);
	        usuario2.setTarjetaBancaria(tarjeta2);

	     

	       consultarSaldo("Juan Perez", "1234567890");

	      ingresar("Maria Gomez", "0987654321", 200.0);

	        // Retirar dinero de una cuenta
	     retirar("Juan Perez", "1234567890", 100.0);

	        // Consultar saldo después de retirar
	       consultarSaldo("Juan Perez", "1234567890");
	    }
	

	    public static Usuario obtenerUsuario(String nombre) {
	        for (Usuario usuario : usuarios) {
	            if (usuario.getNombre().equals(nombre)) {
	                return usuario;
	            }
	        }
	        return null;
	    }

	    public boolean agregarCuentaBancaria(String nombre, CuentaBancaria cuenta) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            usuario.agregarCuentaBancaria(cuenta);
	            return true;
	        }
	        return false;
	    }

	    public boolean agregarTarjetaBancaria(String nombre, TarjetaBancaria tarjeta) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            usuario.setTarjetaBancaria(tarjeta);
	            return true;
	        }
	        return false;
	    }

	    public List<CuentaBancaria> obtenerCuentasUsuario(String nombre) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            return usuario.getCuentasBancarias();
	        }
	        return null;
	    }

	    public List<TarjetaBancaria> obtenerTarjetaUsuario(String nombre) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            return usuario.getTarjetaBancaria();
	        }
	        return null;
	    }

	    public static void consultarSaldo(String nombre, String numeroCuenta) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            for (CuentaBancaria cuenta : usuario.getCuentasBancarias()) {
	                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
	                    cuenta.consultarSaldo();
	                    return;
	                }
	            }
	        }
	        System.out.println("Usuario o cuenta no encontrada.");
	    }

	    public static void ingresar(String nombre, String numeroCuenta, double cantidad) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            for (CuentaBancaria cuenta : usuario.getCuentasBancarias()) {
	                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
	                    cuenta.ingresar(cantidad);
	                    return;
	                }
	            }
	        }
	        System.out.println("Usuario o cuenta no encontrada.");
	    }

	    public static void retirar(String nombre, String numeroCuenta, double cantidad) {
	        Usuario usuario = obtenerUsuario(nombre);
	        if (usuario != null) {
	            for (CuentaBancaria cuenta : usuario.getCuentasBancarias()) {
	                if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
	                    cuenta.retirar(cantidad);
	                    return;
	                }
	            }
	        }
	        System.out.println("Usuario o cuenta no encontrada.");
	    }
	    
	}


