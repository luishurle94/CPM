package logica;

public class Entrada {
	
	private String codigoEntrada;
	private String codigoParque;
	private double precioAdulto;
	private double precioNiño;
	
	public Entrada(String codigoEntrada, String codigoParque,
			double precioAdulto, double precioNiño) {
		super();
		this.codigoEntrada = codigoEntrada;
		this.codigoParque = codigoParque;
		this.precioAdulto = precioAdulto;
		this.precioNiño = precioNiño;
		
		
	}

	public String getCodigoEntrada() {
		return codigoEntrada;
	}

	public void setCodigoEntrada(String codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public double getPrecioAdulto() {
		return precioAdulto;
	}

	public void setPrecioAdulto(double precioAdulto) {
		this.precioAdulto = precioAdulto;
	}

	public double getPrecioNiño() {
		return precioNiño;
	}

	public void setPrecioNiño(double precioNiño) {
		this.precioNiño = precioNiño;
	}

}
