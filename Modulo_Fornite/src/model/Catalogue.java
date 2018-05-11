package model;

import java.util.Map;
import java.util.Map.Entry;

import repositories.Reader;

public class Catalogue {

	private Map<String, Weapon> weapons;
	private Map<String, Skin> skins;
	private Map<String, Pack> packs;

	public Catalogue() {
		super();
		this.weapons = Reader.loadWeapon();
		this.skins = Reader.loadSkin();
		this.packs = Reader.loadPacks();
		completePacks();
	}

	private void completePacks() {
		for (Entry<String, Pack> entry : packs.entrySet()) {
			Pack pack = entry.getValue();
			Skin skin = skins.get(pack.getIdSkin());
			Weapon weapon = weapons.get(pack.getIdWeapon());
			pack.setName(skin.getName() + " - " + weapon.getName());
			pack.setPrice(skin.getPrice() + weapon.getPrice());
		}
	}

	public Map<String, Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(Map<String, Weapon> weapons) {
		this.weapons = weapons;
	}

	public Map<String, Skin> getSkins() {
		return skins;
	}

	public void setSkins(Map<String, Skin> skins) {
		this.skins = skins;
	}

	public Map<String, Pack> getPacks() {
		return packs;
	}

	public void setPacks(Map<String, Pack> packs) {
		this.packs = packs;
	}

	@Override
	public String toString() {
		return "Catalogue [weapons=" + weapons + ", skins=" + skins + ", packs="
				+ packs + "]";
	}

}
