package model;

public class Accomodation {

	
	    private String codeAccomodation;
	    private String type;
	    private String category;
	    private String nameAccomodation;
	    private String codePark;
	    private int numRooms;
	    private double price;
	    
	    
	    
		public Accomodation(String codeAccomodation, String type,
				String category, String nameAccomodation, String codePark,
				int numRooms, double price) {
			super();
			this.codeAccomodation = codeAccomodation;
			this.type = type;
			this.category = category;
			this.nameAccomodation = nameAccomodation;
			this.codePark = codePark;
			this.numRooms = numRooms;
			this.price = price;
		}
		public String getCodeAccomodation() {
			return codeAccomodation;
		}
		public void setCodeAccomodation(String codeAccomodation) {
			this.codeAccomodation = codeAccomodation;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getNameAccomodation() {
			return nameAccomodation;
		}
		public void setNameAccomodation(String nameAccomodation) {
			this.nameAccomodation = nameAccomodation;
		}
		public String getCodePark() {
			return codePark;
		}
		public void setCodePark(String codePark) {
			this.codePark = codePark;
		}
		public int getNumRooms() {
			return numRooms;
		}
		public void setNumRooms(int numRooms) {
			this.numRooms = numRooms;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
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
			Accomodation other = (Accomodation) obj;
			if (codeAccomodation == null) {
				if (other.codeAccomodation != null)
					return false;
			} else if (!codeAccomodation.equals(other.codeAccomodation))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Accomodation [codeAccomodation=" + codeAccomodation
					+ ", type=" + type + ", category=" + category
					+ ", nameAccomodation=" + nameAccomodation + ", codePark="
					+ codePark + ", numRooms=" + numRooms + ", price=" + price
					+ "]";
		}
	    
	    
}
