package Banco.modelo;
public class TarjetaBancaria {
    private String numeroTarjeta;
    private String tipo; 
    private double limiteGasto;
    private boolean activa;
    private Usuario usuario; 


    public TarjetaBancaria(String numeroTarjeta, String tipo, double limiteGasto, Usuario usuario) {
        this.numeroTarjeta = numeroTarjeta;
        this.tipo = tipo;
        this.limiteGasto = limiteGasto;
        this.activa = false; // Inicialmente la tarjeta está inactiva
        this.usuario = usuario; // Asociar la tarjeta con el usuario proporcionado
    }

    // Getters y Setters
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getLimiteGasto() {
        return limiteGasto;
    }

    public void setLimiteGasto(double limiteGasto) {
        this.limiteGasto = limiteGasto;
    }

    public boolean isActiva() {
        return activa;
    }
    
    @Override
	public String toString() {
		return "TarjetaBancaria [numeroTarjeta=" + numeroTarjeta + ", tipo=" + tipo + ", limiteGasto=" + limiteGasto
				+ ", activa=" + activa + ", usuario=" + usuario + "]";
	}

	// Métodos para activar, bloquear y cancelar la tarjeta
    public void activarTarjeta() {
        if (!activa) {
            activa = true;
            System.out.println("Tarjeta activada.");
        } else {
            System.out.println("La tarjeta ya está activa.");
        }
    }

    public void bloquearTarjeta() {
        if (activa) {
            activa = false;
            System.out.println("Tarjeta bloqueada.");
        } else {
            System.out.println("La tarjeta ya está bloqueada.");
        }
    }

    public void cancelarTarjeta() {
        if (activa) {
            activa = false;
            System.out.println("Tarjeta inactiva.");
        } else {
            System.out.println("Su tarjeta ya ha sido cancelada.");
        }
    }
}
