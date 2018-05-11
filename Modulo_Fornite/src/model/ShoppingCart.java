package model;

import java.util.List;

public class ShoppingCart {

	private List<Skin> skins;;
	private List<Weapon> weapons;
	private List<Pack> packs;
	private float totalPrice;
	private int counter;
	
	public ShoppingCart(List<Skin> skins, List<Weapon> weapons,
			List<Pack> packs, float totalPrice, int counter) {
		super();
		this.skins = skins;
		this.weapons = weapons;
		this.packs = packs;
		this.totalPrice = totalPrice;
		this.counter = counter;
	}

	public List<Skin> getSkins() {
		return skins;
	}

	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public List<Pack> getPacks() {
		return packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((packs == null) ? 0 : packs.hashCode());
		result = prime * result + ((skins == null) ? 0 : skins.hashCode());
		result = prime * result + ((weapons == null) ? 0 : weapons.hashCode());
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
		ShoppingCart other = (ShoppingCart) obj;
		if (packs == null) {
			if (other.packs != null)
				return false;
		} else if (!packs.equals(other.packs))
			return false;
		if (skins == null) {
			if (other.skins != null)
				return false;
		} else if (!skins.equals(other.skins))
			return false;
		if (weapons == null) {
			if (other.weapons != null)
				return false;
		} else if (!weapons.equals(other.weapons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingCart [skins=" + skins + ", weapons=" + weapons
				+ ", packs=" + packs + ", totalPrice=" + totalPrice
				+ ", counter=" + counter + "]";
	}
	
	
	
}
