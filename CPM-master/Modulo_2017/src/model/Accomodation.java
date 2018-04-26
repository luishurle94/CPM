package model;

import model.types.AccomodationType;

public class Accomodation {
	private String codeAccomodation, name, codePark;
	private int category, numRooms;
	private AccomodationType type;
	private float price;

	public Accomodation(String codeAccomodation, String name, String codePark,
			int category, int numRooms, AccomodationType type, float price) {
		super();
		this.codeAccomodation = codeAccomodation;
		this.name = name;
		this.codePark = codePark;
		this.category = category;
		this.numRooms = numRooms;
		this.type = type;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeAccomodation() {
		return codeAccomodation;
	}

	public void setCodeAccomodation(String codeAccomodation) {
		this.codeAccomodation = codeAccomodation;
	}

	public String getCodePark() {
		return codePark;
	}

	public void setCodePark(String codePark) {
		this.codePark = codePark;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}

	public AccomodationType getType() {
		return type;
	}

	public void setType(AccomodationType type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeAccomodation == null) ? 0
				: codeAccomodation.hashCode());
		result = prime * result
				+ ((codePark == null) ? 0 : codePark.hashCode());
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
		Accomodation other = (Accomodation) obj;
		if (codeAccomodation == null) {
			if (other.codeAccomodation != null)
				return false;
		} else if (!codeAccomodation.equals(other.codeAccomodation))
			return false;
		if (codePark == null) {
			if (other.codePark != null)
				return false;
		} else if (!codePark.equals(other.codePark))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accomodation [codeAccomodation=" + codeAccomodation
				+ ", codePark=" + codePark + ", category=" + category
				+ ", numRooms=" + numRooms + ", type=" + type + ", price="
				+ price + "]";
	}

}
