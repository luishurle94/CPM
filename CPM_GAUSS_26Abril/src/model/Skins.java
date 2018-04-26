package model;

public class Skins {
	
	private long id;
	private float precio;
	private RarezaEnum rareza;
	private String nombre;
	private String img;
	
	public Skins(long id, float precio, RarezaEnum rareza, String nombre,
			String img) {
		super();
		this.id = id;
		this.precio = precio;
		this.rareza = rareza;
		this.nombre = nombre;
		this.img = img;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public RarezaEnum getRareza() {
		return rareza;
	}

	public void setRareza(RarezaEnum rareza) {
		this.rareza = rareza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
		Skins other = (Skins) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

	
}
