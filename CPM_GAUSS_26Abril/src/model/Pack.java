package model;

public class Pack {
	
	private long id;
	private long idSkins;
	private long idArma;
	private float precio;
	private String nombre;
	
	public Pack(long id, long idSkins, long idArma, float precio,
			String nombre) {
		super();
		this.id = id;
		this.idSkins = idSkins;
		this.idArma = idArma;
		this.precio = precio;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdSkins() {
		return idSkins;
	}

	public void setIdSkins(long idSkins) {
		this.idSkins = idSkins;
	}

	public long getIdArma() {
		return idArma;
	}

	public void setIdArma(long idArma) {
		this.idArma = idArma;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		Pack other = (Pack) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
