package model;

import java.util.Map;

public class BBDD {

		Map<String, Accomodation> accomodation;
		Map<String, Ticket> ticket;
		Map<String, Package> packages;
		Map<String, ThemePark> themePark;
		
		public BBDD(Map<String, Accomodation> accomodation,
				Map<String, Ticket> ticket, Map<String, Package> packages,
				Map<String, ThemePark> themePark) {
			super();
			this.accomodation = accomodation;
			this.ticket = ticket;
			this.packages = packages;
			this.themePark = themePark;
		}

		public Map<String, Accomodation> getAccomodation() {
			return accomodation;
		}

		public void setAccomodation(Map<String, Accomodation> accomodation) {
			this.accomodation = accomodation;
		}

		public Map<String, Ticket> getTicket() {
			return ticket;
		}

		public void setTicket(Map<String, Ticket> ticket) {
			this.ticket = ticket;
		}

		public Map<String, Package> getPackages() {
			return packages;
		}

		public void setPackages(Map<String, Package> packages) {
			this.packages = packages;
		}

		public Map<String, ThemePark> getThemePark() {
			return themePark;
		}

		public void setThemePark(Map<String, ThemePark> themePark) {
			this.themePark = themePark;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((accomodation == null) ? 0 : accomodation.hashCode());
			result = prime * result
					+ ((packages == null) ? 0 : packages.hashCode());
			result = prime * result
					+ ((themePark == null) ? 0 : themePark.hashCode());
			result = prime * result
					+ ((ticket == null) ? 0 : ticket.hashCode());
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
			BBDD other = (BBDD) obj;
			if (accomodation == null) {
				if (other.accomodation != null)
					return false;
			} else if (!accomodation.equals(other.accomodation))
				return false;
			if (packages == null) {
				if (other.packages != null)
					return false;
			} else if (!packages.equals(other.packages))
				return false;
			if (themePark == null) {
				if (other.themePark != null)
					return false;
			} else if (!themePark.equals(other.themePark))
				return false;
			if (ticket == null) {
				if (other.ticket != null)
					return false;
			} else if (!ticket.equals(other.ticket))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "BBDD [accomodation=" + accomodation + ", ticket=" + ticket
					+ ", packages=" + packages + ", themePark=" + themePark
					+ "]";
		}
		
		
		
		
	

}
