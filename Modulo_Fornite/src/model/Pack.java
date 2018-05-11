package model;

public class Pack {

	private String idPack;
	private String idSkin;
	private String idWeapon;
	private float price;
	private String name;

	public Pack(String idPack, String idSkin, String idWeapon) {
		super();
		this.idPack = idPack;
		this.idSkin = idSkin;
		this.idWeapon = idWeapon;
	}

	public String getIdPack() {
		return idPack;
	}

	public void setIdPack(String idPack) {
		this.idPack = idPack;
	}

	public String getIdSkin() {
		return idSkin;
	}

	public void setIdSkin(String idSkin) {
		this.idSkin = idSkin;
	}

	public String getIdWeapon() {
		return idWeapon;
	}

	public void setIdWeapon(String idWeapon) {
		this.idWeapon = idWeapon;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSkin == null) ? 0 : idSkin.hashCode());
		result = prime * result
				+ ((idWeapon == null) ? 0 : idWeapon.hashCode());
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
		if (idSkin == null) {
			if (other.idSkin != null)
				return false;
		} else if (!idSkin.equals(other.idSkin))
			return false;
		if (idWeapon == null) {
			if (other.idWeapon != null)
				return false;
		} else if (!idWeapon.equals(other.idWeapon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pack [idPack=" + idPack + ", idSkin=" + idSkin + ", idWeapon="
				+ idWeapon + ", price=" + price + ", name=" + name + "]";
	}

}
