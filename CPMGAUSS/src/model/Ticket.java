package model;

public class Ticket {

	
	    private String codeTicket;
	    private String codePark;
	    private double childPriceTicket;
	    private double adultPriceTicket;
	    
	    
		public Ticket(String codeTicket, String codePark,
				double childPriceTicket, double adultPriceTicket) {
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
		public double getChildPriceTicket() {
			return childPriceTicket;
		}
		public void setChildPriceTicket(double childPriceTicket) {
			this.childPriceTicket = childPriceTicket;
		}
		public double getAdultPriceTicket() {
			return adultPriceTicket;
		}
		public void setAdultPriceTicket(double adultPriceTicket) {
			this.adultPriceTicket = adultPriceTicket;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
