package model;

import model.types.Rarity;

public class Weapon {

	private String id;
	private String name;
	private Rarity rarity;
	private int magazine, damage, envDamage;
	private float dps, fireRate, price, reloadTime;
	private String image;

	public Weapon(String id, String name, Rarity rarity, int magazine,
			int damage, int envDamage, float dps, float fireRate,
			float reloadTime, String image) {
		this.id = id;
		this.name = name;
		this.rarity = rarity;
		this.magazine = magazine;
		this.damage = damage;
		this.envDamage = envDamage;
		this.dps = dps;
		this.fireRate = fireRate;
		this.price = dps * damage * rarity.getValue();
		this.reloadTime = reloadTime;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public int getMagazine() {
		return magazine;
	}

	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getEnvDamage() {
		return envDamage;
	}

	public void setEnvDamage(int envDamage) {
		this.envDamage = envDamage;
	}

	public float getDps() {
		return dps;
	}

	public void setDps(float dps) {
		this.dps = dps;
	}

	public float getFireRate() {
		return fireRate;
	}

	public void setFireRate(float fireRate) {
		this.fireRate = fireRate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getReloadTime() {
		return reloadTime;
	}

	public void setReloadTime(float reloadTime) {
		this.reloadTime = reloadTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Weapon other = (Weapon) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name + ", rarity=" + rarity
				+ ", magazine=" + magazine + ", damage=" + damage
				+ ", envDamage=" + envDamage + ", dps=" + dps + ", fireRate="
				+ fireRate + ", price=" + price + ", reloadTime=" + reloadTime
				+ ", image=" + image + "]";
	}

}
