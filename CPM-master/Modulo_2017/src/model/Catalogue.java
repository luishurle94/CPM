package model;

import java.util.Map;

import persistence.Reader;

public class Catalogue {
	private Map<String, Accomodation> accomodations;
	private Map<String, PackagePark> packages;
	private Map<String, ThemePark> themeParks;
	private Map<String, Ticket> tickets;

	public Catalogue() {
		accomodations = Reader.loadAccomodation();
		packages = Reader.loadPackage();
		themeParks = Reader.loadPark();
		tickets = Reader.loadTicket();
	}

	public Map<String, Accomodation> getAccomodations() {
		return accomodations;
	}

	public void setAccomodations(Map<String, Accomodation> accomodations) {
		this.accomodations = accomodations;
	}

	public Map<String, PackagePark> getPackages() {
		return packages;
	}

	public void setPackages(Map<String, PackagePark> packages) {
		this.packages = packages;
	}

	public Map<String, ThemePark> getThemeParks() {
		return themeParks;
	}

	public void setThemeParks(Map<String, ThemePark> themeParks) {
		this.themeParks = themeParks;
	}

	public Map<String, Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Map<String, Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accomodations == null) ? 0 : accomodations.hashCode());
		result = prime * result
				+ ((packages == null) ? 0 : packages.hashCode());
		result = prime * result
				+ ((themeParks == null) ? 0 : themeParks.hashCode());
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
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
		Catalogue other = (Catalogue) obj;
		if (accomodations == null) {
			if (other.accomodations != null)
				return false;
		} else if (!accomodations.equals(other.accomodations))
			return false;
		if (packages == null) {
			if (other.packages != null)
				return false;
		} else if (!packages.equals(other.packages))
			return false;
		if (themeParks == null) {
			if (other.themeParks != null)
				return false;
		} else if (!themeParks.equals(other.themeParks))
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Catalogue [accomodations=" + accomodations + ", packages="
				+ packages + ", themeParks=" + themeParks + ", tickets="
				+ tickets + "]";
	}

}
