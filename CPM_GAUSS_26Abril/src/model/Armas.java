package model;

public class Armas {
	
	private long id;
	private String nombre;
	private RarezaEnum rareza;
	private int numBalas;
	private float daño;
	private float precio;
	
	public Armas(long id, String nombre, RarezaEnum rareza, int numBalas,
			float daño, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rareza = rareza;
		this.numBalas = numBalas;
		this.daño = daño;
		this.precio = precio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public RarezaEnum getRareza() {
		return rareza;
	}

	public void setRareza(RarezaEnum rareza) {
		this.rareza = rareza;
	}

	public int getNumBalas() {
		return numBalas;
	}

	public void setNumBalas(int numBalas) {
		this.numBalas = numBalas;
	}

	public float getDaño() {
		return daño;
	}

	public void setDaño(float daño) {
		this.daño = daño;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Armas other = (Armas) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
