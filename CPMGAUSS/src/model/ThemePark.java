package model;



public class ThemePark {

	    private String codePark;
	    private String name;
	    private String country;
	    private String city;
	    private String description;
		
		
		
		public ThemePark(String codePark, String name, String country,
				String city, String description) {
			super();
			this.codePark = codePark;
			this.name = name;
			this.country = country;
			this.city = city;
			this.description = description;
		}

		public String getCodePark() {
			return codePark;
		}
		
		public void setCodePark(String codePark) {
			this.codePark = codePark;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getCountry() {
			return country;
		}
		
		public void setCountry(String country) {
			this.country = country;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String description) {
			this.description = description;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			ThemePark other = (ThemePark) obj;
			if (codePark == null) {
				if (other.codePark != null)
					return false;
			} else if (!codePark.equals(other.codePark))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "ThemePark [codePark=" + codePark + ", name=" + name
					+ ", country=" + country + ", city=" + city
					+ ", description=" + description + "]";
		}
		
		
}
