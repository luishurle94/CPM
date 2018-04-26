package model;

public class Ticket {
	private String codeTicket, codePark;
	private float childPriceTicket, adultPriceTicket;

	public Ticket(String codeTicket, String codePark, float childPriceTicket,
			float adultPriceTicket) {
		super();
		this.codeTicket = codeTicket;
		this.codePark = codePark;
		this.childPriceTicket = childPriceTicket;
		this.adultPriceTicket = adultPriceTicket;
	}

	public String getCodeTicket() {
		return codeTicket;
	}

	public void setCodeTicket(String codeTicket) {
		this.codeTicket = codeTicket;
	}

	public String getCodePark() {
		return codePark;
	}

	public void setCodePark(String codePark) {
		this.codePark = codePark;
	}

	public float getChildPriceTicket() {
		return childPriceTicket;
	}

	public void setChildPriceTicket(float childPriceTicket) {
		this.childPriceTicket = childPriceTicket;
	}

	public float getAdultPriceTicket() {
		return adultPriceTicket;
	}

	public void setAdultPriceTicket(float adultPriceTicket) {
		this.adultPriceTicket = adultPriceTicket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codePark == null) ? 0 : codePark.hashCode());
		result = prime * result
				+ ((codeTicket == null) ? 0 : codeTicket.hashCode());
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
		Ticket other = (Ticket) obj;
		if (codePark == null) {
			if (other.codePark != null)
				return false;
		} else if (!codePark.equals(other.codePark))
			return false;
		if (codeTicket == null) {
			if (other.codeTicket != null)
				return false;
		} else if (!codeTicket.equals(other.codeTicket))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [codeTicket=" + codeTicket + ", codePark=" + codePark
				+ ", childPriceTicket=" + childPriceTicket
				+ ", adultPriceTicket=" + adultPriceTicket + "]";
	}

}
