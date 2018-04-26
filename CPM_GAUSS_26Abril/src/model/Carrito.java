package model;

import java.util.List;

public class Carrito {

	private List<Skins> skins;
	private List<Armas> armas;
	private List<Pack> packs;
	private float total;
	private int contador;
	
	public Carrito(List<Skins> skins, List<Armas> armas, List<Pack> packs,
			float total, int contador) {
		super();
		this.skins = skins;
		this.armas = armas;
		this.packs = packs;
		this.total = total;
		this.contador = contador;
	}

	public List<Skins> getSkins() {
		return skins;
	}

	public void setSkins(List<Skins> skins) {
		this.skins = skins;
	}

	public List<Armas> getArmas() {
		return armas;
	}

	public void setArmas(List<Armas> armas) {
		this.armas = armas;
	}

	public List<Pack> getPacks() {
		return packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((armas == null) ? 0 : armas.hashCode());
		result = prime * result + ((packs == null) ? 0 : packs.hashCode());
		result = prime * result + ((skins == null) ? 0 : skins.hashCode());
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
		Carrito other = (Carrito) obj;
		if (armas == null) {
			if (other.armas != null)
				return false;
		} else if (!armas.equals(other.armas))
			return false;
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
		return true;
	}
	
	
	
}
