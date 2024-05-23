package Banco.modelo;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
	    private String nombre;
	    private String contrasena;
	    private List<CuentaBancaria> cuentasBancarias;
	    private List<TarjetaBancaria> tarjetaBancaria;


	    // Constructor
	    public Usuario(String nombre, String contrasena) {
	        this.nombre = nombre;
	        this.contrasena=contrasena;
	        this.cuentasBancarias = new ArrayList<>();
	        this.tarjetaBancaria= new ArrayList<>();
	    }

	

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		

	    

		public boolean inicioDeSesion(String nombreUsuario, String contrasena) {
	        return this.nombre != null && this.nombre.equals(nombreUsuario)
	        		&& this.contrasena != null && this.contrasena.equals(contrasena);
	    }

	    public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public void agregarCuentaBancaria(CuentaBancaria cuentaBancaria) {
	        this.cuentasBancarias.add(cuentaBancaria);
	    }

	    public List<CuentaBancaria> getCuentasBancarias() {
	        return cuentasBancarias;
	    }

		public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
			this.cuentasBancarias = cuentasBancarias;
		}

		public void setTarjetaBancaria(TarjetaBancaria tarjeta) {
	
			
		}



		public List<TarjetaBancaria> getTarjetaBancaria() {
			// TODO Auto-generated method stub
			return null;
		}
	    
	
}
