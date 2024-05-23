package Banco.modelo;
	import java.util.ArrayList;
	import java.util.List;

	public class CuentaBancaria {
	    private String numeroCuenta;
	    private double saldo;
	    private List<String> historialTransacciones;

		    // Constructor
	    public CuentaBancaria(String numeroCuenta) {
	        this.numeroCuenta = numeroCuenta;
	        this.saldo = 0.0;
	        this.historialTransacciones = new ArrayList<>();
		    }

		    // Getters y Setters
	    public String getNumeroCuenta() {
			return numeroCuenta;
		}

		public void setNumeroCuenta(String numeroCuenta) {
			this.numeroCuenta = numeroCuenta;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public List<String> getHistorialTransacciones() {
			return historialTransacciones;
		}

		public void setHistorialTransacciones(List<String> historialTransacciones) {
			this.historialTransacciones = historialTransacciones;
		}
	    
		 @Override
			public String toString() {
				return "CuentaBancaria [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", historialTransacciones="
						+ historialTransacciones + "]";
			}
	    

	   
		public void consultarSaldo() {
	        System.out.println("Saldo actual: " + saldo);
		    }

		public void consultarHistorialTransacciones() {
	        System.out.println("Historial de transacciones:");
	        for (String transaccion : historialTransacciones) {
	            System.out.println(transaccion);
		        }
		    }
		public void ingresar(double cantidad) {
	        this.saldo += cantidad;
	        this.historialTransacciones.add("Depósito de $" + cantidad);
	    }

		public void retirar(double cantidad) {
	        if (this.saldo >= cantidad) {
	            this.saldo -= cantidad;
	            this.historialTransacciones.add("Retiro de $" + cantidad);
	            System.out.println("Retiro exitoso de $" + cantidad);
	        } else {
	            System.out.println("Saldo insuficiente para realizar el retiro.");
	        }
		}
	
}
