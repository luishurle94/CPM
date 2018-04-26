package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Clase que simula un catï¿½logo de cruceros
 * 
 * @author IvÃ¡n GonzÃ¡lez Mahagamage
 *
 */
public class Catalogo {
	private List<Barco> listaBarcos;
	private List<Crucero> listaCruceros;
	private List<Capitan> listaCapitanes;

	private static final String FICHERO_BARCOS = "files/barcos.dat";
	private static final String FICHERO_CRUCEROS = "files/cruceros.dat";
	private static final String FICHERO_CAPITAN = "files/Capitanes.dat";

	/**
	 * Constructor por defecto
	 */
	public Catalogo() {
		listaCapitanes = new ArrayList<Capitan>();
		cargarCapitan();
		listaBarcos = new ArrayList<Barco>();
		cargarBarcos();
		listaCruceros = new ArrayList<Crucero>();
		cargarCruceros();
		colocarDescuentos();
	}

	private void colocarDescuentos() {
		for (Crucero crucero : getCruceros())
			crucero.setDescuento(false);
		añadirDescuento();
		añadirDescuento();
	}

	private void añadirDescuento() {
		boolean descuento = false;
		do {
			int cruceroConDescuento = (int) (Math.random()
					* getCruceros().size());
			if (!getCruceros().get(cruceroConDescuento).isDescuento()) {
				getCruceros().get(cruceroConDescuento).setDescuento(true);
				descuento = true;
			}
		} while (!descuento);
	}

	/**
	 * Mï¿½todo que devuelve la lista de barcos disponibles
	 * 
	 * @return La lista de barcos disponibles
	 */
	public List<Barco> getBarcos() {
		return listaBarcos;
	}

	/**
	 * Mï¿½todo que modifica la lista de barcos disponibles
	 * 
	 * @param barcos
	 *            Nueva lista de barcos disponibles
	 */
	public void setBarcos(List<Barco> barcos) {
		this.listaBarcos = barcos;
	}

	/**
	 * Mï¿½todo que devuelve la lista de cruceros disponibles
	 * 
	 * @return La lista de cruceros disponibles
	 */
	public List<Crucero> getCruceros() {
		return listaCruceros;
	}

	/**
	 * Mï¿½todo que modifica la lista de cruceros disponibles
	 * 
	 * @param cruceros
	 *            Nueva lista de cruceros
	 */
	public void setCruceros(List<Crucero> cruceros) {
		this.listaCruceros = cruceros;
	}

	private void cargarCapitan() {
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(FICHERO_CAPITAN));
			while (fichero.ready()) {
				String linea = fichero.readLine();
				String[] datosCapitan = linea.split(";");
				listaCapitanes
						.add(new Capitan(datosCapitan[0], datosCapitan[1]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo barcos.dat no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Mï¿½todo que cargo los barcos disponibles de un fichero
	 */
	private void cargarBarcos() {
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(FICHERO_BARCOS));
			while (fichero.ready()) {
				String linea = fichero.readLine();
				String[] datosBarcos = linea.split(";");
				Capitan capitan = null;
				for (Capitan aux : listaCapitanes) {
					if (aux.getCodigo().equals(datosBarcos[2])) {
						capitan = aux;
						break;
					}
				}
				listaBarcos.add(new Barco(datosBarcos[0], datosBarcos[1],
						capitan, datosBarcos[3],
						Integer.parseInt(datosBarcos[4]),
						Integer.parseInt(datosBarcos[5]),
						Integer.parseInt(datosBarcos[6]),
						Integer.parseInt(datosBarcos[7]),
						Float.parseFloat(datosBarcos[8]),
						Float.parseFloat(datosBarcos[9]),
						Float.parseFloat(datosBarcos[10]),
						Float.parseFloat(datosBarcos[11])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo barcos.dat no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Mï¿½todo que cargo los cruceros disponibles de un fichero
	 */
	private void cargarCruceros() {
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(FICHERO_CRUCEROS));
			while (fichero.ready()) {
				String linea = fichero.readLine();
				String[] datosCrucero = linea.split(";");
				boolean menores = false;
				if (datosCrucero[6].equals("S") || datosCrucero[6].equals("s"))
					menores = true;
				else if (datosCrucero[6].equals("N")
						|| datosCrucero[6].equals("n"))
					menores = false;
				String[] fechas = datosCrucero[8].split("%");
				Barco barco = null;
				for (Barco a : listaBarcos)
					if (a.getCodigo().equals(datosCrucero[9]))
						barco = a;
				listaCruceros.add(new Crucero(datosCrucero[0], datosCrucero[1],
						datosCrucero[2], datosCrucero[3], datosCrucero[4],
						datosCrucero[5], menores,
						Integer.parseInt(datosCrucero[7]), fechas, barco));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo barcos.dat no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
}
