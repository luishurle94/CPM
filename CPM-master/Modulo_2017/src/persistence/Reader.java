package persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Accomodation;
import model.PackagePark;
import model.ThemePark;
import model.Ticket;
import model.types.AccomodationType;

public class Reader {
	public static BufferedReader b;
	private static final String ACCOMODATION_FILE = "data/output/alojamientos.dat";
	private static final String TICKET_FILE = "data/output/entradas.dat";
	private static final String THEMEPARK_FILE = "data/output/tematicos.dat";
	private static final String PACKAGE_FILE = "data/output/paquetes.dat";

	public static HashMap<String, ThemePark> loadPark() {
		List<String> lines = readFile(THEMEPARK_FILE);
		HashMap<String, ThemePark> themeParks = new HashMap<>();
		for (String line : lines) {
			String[] date = line.split("@");
			String codePark = date[0];
			String namePark = date[1];
			String country = date[2];
			String city = date[3];
			String description = date[4];
			ThemePark themePark = new ThemePark(codePark, namePark, country,
					city, description);
			themeParks.put(themePark.getCodePark(), themePark);
		}
		return themeParks;
	}

	public static HashMap<String, Ticket> loadTicket() {
		List<String> lines = readFile(TICKET_FILE);
		HashMap<String, Ticket> tickets = new HashMap<>();
		for (String line : lines) {
			String[] date = line.split("@");
			String codeTicket = date[0];
			String codePark = date[1];
			float childPriceTicket = Float.parseFloat(date[2]);
			float adultPriceTicket = Float.parseFloat(date[3]);
			Ticket ticket = new Ticket(codeTicket, codePark, childPriceTicket,
					adultPriceTicket);
			tickets.put(ticket.getCodeTicket(), ticket);
		}
		return tickets;
	}

	public static HashMap<String, Accomodation> loadAccomodation() {
		List<String> lines = readFile(ACCOMODATION_FILE);
		HashMap<String, Accomodation> accomodations = new HashMap<>();
		for (String line : lines) {
			String[] date = line.split("@");
			String codeAccomodation = date[0];
			AccomodationType type = AccomodationType.valueOf(date[1]);
			int category = Integer.parseInt(date[2]);
			String name = date[3];
			String codePark = date[4];
			int numRooms = Integer.parseInt(date[5]);
			float price = Float.parseFloat(date[6]);
			Accomodation accomodation = new Accomodation(codeAccomodation, name,
					codePark, category, numRooms, type, price);
			accomodations.put(accomodation.getCodeAccomodation(), accomodation);
		}
		return accomodations;
	}

	public static HashMap<String, PackagePark> loadPackage() {
		List<String> lines = readFile(PACKAGE_FILE);
		HashMap<String, PackagePark> packages = new HashMap<>();
		for (String line : lines) {
			String[] date = line.split("@");
			PackagePark e = new PackagePark(date[0], date[1], date[2], date[3],
					Integer.parseInt(date[4]), Float.parseFloat(date[5]),
					Float.parseFloat(date[6]));
			packages.put(e.getCodePackage(), e);
		}
		return packages;
	}

	private static List<String> readFile(String file) {
		List<String> lines = new ArrayList<>();
		try {
			b = new BufferedReader(new FileReader(file));
			while (b.ready()) {
				lines.add(b.readLine());
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("El archivo fichero " + file + " no se encontro");
		} catch (IOException e) {
			new RuntimeException(
					"Error de entrada/salida con el fichero " + file);
		}
		return lines;
	}

}
