package model;

public class Package {

	
		private String codePackage;
		private String namePackage;
		private String codePark;
		private String codeAccomodation;
		private int days;
		private double childPricePackage;
		private double adultPricePackage;
		
		
		public Package(String codePackage, String namePackage, String codePark,
				String codeAccomodation, int days, double childPricePackage,
				double adultPricePackage) {
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


		public double getChildPricePackage() {
			return childPricePackage;
		}


		public void setChildPricePackage(double childPricePackage) {
			this.childPricePackage = childPricePackage;
		}


		public double getAdultPricePackage() {
			return adultPricePackage;
		}


		public void setAdultPricePackage(double adultPricePackage) {
			this.adultPricePackage = adultPricePackage;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((codePackage == null) ? 0 : codePackage.hashCode());
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
			Package other = (Package) obj;
			if (codePackage == null) {
				if (other.codePackage != null)
					return false;
			} else if (!codePackage.equals(other.codePackage))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Package [codePackage=" + codePackage + ", namePackage="
					+ namePackage + ", codePark=" + codePark
					+ ", codeAccomodation=" + codeAccomodation + ", days="
					+ days + ", childPricePackage=" + childPricePackage
					+ ", adultPricePackage=" + adultPricePackage + "]";
		}
	
		
		

}
