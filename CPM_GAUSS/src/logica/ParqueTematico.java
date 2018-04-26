package logica;

public class ParqueTematico {

	private String codigoParque;
	private String denominacion;
	private String pais;
	private String localidad;
	private String descripcion;
	
	public ParqueTematico(String codigoParque, String denominacion, String pais,
			String localidad, String descripcion) {
		
		this.codigoParque = codigoParque;
		this.denominacion = denominacion;
		this.pais = pais;
		this.localidad = localidad;
		this.descripcion = descripcion;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		ParqueTematico other = (ParqueTematico) obj;
		if (codigoParque == null) {
			if (other.codigoParque != null)
				return false;
		} else if (!codigoParque.equals(other.codigoParque))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParqueTematico [codigoParque=" + codigoParque
				+ ", denominacion=" + denominacion + ", pais=" + pais
				+ ", localidad=" + localidad + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	
}
