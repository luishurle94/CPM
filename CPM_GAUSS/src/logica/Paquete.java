package logica;

public class Paquete {
	
	private String codigoPaquete;
	private String denominacion;
	private String codigoParque;
	private String codigoAlojamiento;
	private int duracion;
	private double precioAdulto;
	private double precioNiño;
	
	public Paquete(String codigoPaquete, String denominacion,
			String codigoParque, String codigoAlojamiento, int duracion,
			double precioAdulto, double precioNiño) {
		
		this.codigoPaquete = codigoPaquete;
		this.denominacion = denominacion;
		this.codigoParque = codigoParque;
		this.codigoAlojamiento = codigoAlojamiento;
		this.duracion = duracion;
		this.precioAdulto = precioAdulto;
		this.precioNiño = precioNiño;
	}

	public String getCodigoPaquete() {
		return codigoPaquete;
	}

	public void setCodigoPaquete(String codigoPaquete) {
		this.codigoPaquete = codigoPaquete;
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

	public String getCodigoAlojamiento() {
		return codigoAlojamiento;
	}

	public void setCodigoAlojamiento(String codigoAlojamiento) {
		this.codigoAlojamiento = codigoAlojamiento;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoParque == null) ? 0 : codigoParque.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		if (codigoParque == null) {
			if (other.codigoParque != null)
				return false;
		} else if (!codigoParque.equals(other.codigoParque))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paquete [codigoPaquete=" + codigoPaquete + ", denominacion="
				+ denominacion + ", codigoParque=" + codigoParque
				+ ", codigoAlojamiento=" + codigoAlojamiento + ", duracion="
				+ duracion + ", precioAdulto=" + precioAdulto + ", precioNiño="
				+ precioNiño + "]";
	}
	
	
	
	

}
