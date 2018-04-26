package logica;

import java.util.Map;

public class Catalogo {
	
	private Map<String, Alojamiento> alojamientos;
	private Map<String, Paquete> paquetes;
	private Map<String, ParqueTematico> parquesTematicos;
	private Map<String, Entrada> entradas;
	
	public Catalogo(Map<String, Alojamiento> alojamientos,
			Map<String, Paquete> paquetes,
			Map<String, ParqueTematico> parquesTematicos,
			Map<String, Entrada> entradas) {
		
		this.alojamientos = alojamientos;
		this.paquetes = paquetes;
		this.parquesTematicos = parquesTematicos;
		this.entradas = entradas;
	}

	public Map<String, Alojamiento> getAlojamientos() {
		return alojamientos;
	}

	public void setAlojamientos(Map<String, Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}

	public Map<String, Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(Map<String, Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Map<String, ParqueTematico> getParquesTematicos() {
		return parquesTematicos;
	}

	public void setParquesTematicos(Map<String, ParqueTematico> parquesTematicos) {
		this.parquesTematicos = parquesTematicos;
	}

	public Map<String, Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Map<String, Entrada> entradas) {
		this.entradas = entradas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alojamientos == null) ? 0 : alojamientos.hashCode());
		result = prime * result
				+ ((entradas == null) ? 0 : entradas.hashCode());
		result = prime * result
				+ ((paquetes == null) ? 0 : paquetes.hashCode());
		result = prime * result + ((parquesTematicos == null) ? 0
				: parquesTematicos.hashCode());
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
		Catalogo other = (Catalogo) obj;
		if (alojamientos == null) {
			if (other.alojamientos != null)
				return false;
		} else if (!alojamientos.equals(other.alojamientos))
			return false;
		if (entradas == null) {
			if (other.entradas != null)
				return false;
		} else if (!entradas.equals(other.entradas))
			return false;
		if (paquetes == null) {
			if (other.paquetes != null)
				return false;
		} else if (!paquetes.equals(other.paquetes))
			return false;
		if (parquesTematicos == null) {
			if (other.parquesTematicos != null)
				return false;
		} else if (!parquesTematicos.equals(other.parquesTematicos))
			return false;
		return true;
	}
	
	
	
	

}
