package model;

public class PackagePark {
	private String codePackage, namePackage, codePark, codeAccomodation;
	private int days;
	private float childPricePackage, adultPricePackage;

	public PackagePark(String codePackage, String namePackage, String codePark,
			String codeAccomodation, int days, float childPricePackage,
			float adultPricePackage) {
		super();
		this.codePackage = codePackage;
		this.namePackage = namePackage;
		this.codePark = codePark;
		this.codeAccomodation = codeAccomodation;
		this.days = days;
		this.childPricePackage = childPricePackage;
		this.adultPricePackage = adultPricePackage;
	}

	public String getCodePackage() {
		return codePackage;
	}

	public void setCodePackage(String codePackage) {
		this.codePackage = codePackage;
	}

	public String getNamePackage() {
		return namePackage;
	}

	public void setNamePackage(String namePackage) {
		this.namePackage = namePackage;
	}

	public String getCodePark() {
		return codePark;
	}

	public void setCodePark(String codePark) {
		this.codePark = codePark;
	}

	public String getCodeAccomodation() {
		return codeAccomodation;
	}

	public void setCodeAccomodation(String codeAccomodation) {
		this.codeAccomodation = codeAccomodation;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public float getChildPricePackage() {
		return childPricePackage;
	}

	public void setChildPricePackage(float childPricePackage) {
		this.childPricePackage = childPricePackage;
	}

	public float getAdultPricePackage() {
		return adultPricePackage;
	}

	public void setAdultPricePackage(float adultPricePackage) {
		this.adultPricePackage = adultPricePackage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeAccomodation == null) ? 0
				: codeAccomodation.hashCode());
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
		PackagePark other = (PackagePark) obj;
		if (codeAccomodation == null) {
			if (other.codeAccomodation != null)
				return false;
		} else if (!codeAccomodation.equals(other.codeAccomodation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Package [codePackage=" + codePackage + ", namePackage="
				+ namePackage + ", codePark=" + codePark + ", codeAccomodation="
				+ codeAccomodation + ", days=" + days + ", childPricePackage="
				+ childPricePackage + ", adultPricePackage=" + adultPricePackage
				+ "]";
	}

}
