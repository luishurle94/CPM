package logica;

public class Alojamiento {
	
	private String codigoAlojamiento;
	//tipo
	private TipoApartamento tipo;
	private int categoria; //num de estrellas
	private String denominacion;
	private String codigoParque;
	private int numeroPlazas;
	private double precioAlojamiento;
	
	public Alojamiento(String codigoAlojamiento, TipoApartamento tipo,
			int categoria, String denominacion, String codigoParque,
			int numeroPlazas, double precioAlojamiento) {
		
		this.codigoAlojamiento = codigoAlojamiento;
		this.tipo = tipo;
		this.categoria = categoria;
		this.denominacion = denominacion;
		this.codigoParque = codigoParque;
		this.numeroPlazas = numeroPlazas;
		this.precioAlojamiento = precioAlojamiento;
	}

	public String getCodigoAlojamiento() {
		return codigoAlojamiento;
	}

	public void setCodigoAlojamiento(String codigoAlojamiento) {
		this.codigoAlojamiento = codigoAlojamiento;
	}

	public TipoApartamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoApartamento tipo) {
		this.tipo = tipo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public void setNumeroPlazas(int numeroPlazas) {
		this.numeroPlazas = numeroPlazas;
	}

	public double getPrecioAlojamiento() {
		return precioAlojamiento;
	}

	public void setPrecioAlojamiento(double precioAlojamiento) {
		this.precioAlojamiento = precioAlojamiento;
	}

	@Override
	public String toString() {
		return "Alojamiento [codigoAlojamiento=" + codigoAlojamiento
				+ ", codigoParque=" + codigoParque + "]";
	}
	
	

	
}
