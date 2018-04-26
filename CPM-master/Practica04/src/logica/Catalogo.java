package logica;

import java.io.*;
import java.util.*;

/**
 * Clase que almacena los distintos articulos disponibles en la tienda
 * 
 * @author uo239795
 *
 */
public class Catalogo {

	private static final String FICHERO_CATALOGO = "files/articulos.dat";
	private List<Articulo> articulosCatalogo = null;

	public Catalogo() {
		articulosCatalogo = new ArrayList<Articulo>();
		cargarArticulos();
	}

	/**
	 * Lee el catalogo y lo carga a la aplicacion
	 */
	private void cargarArticulos() {
		String linea = "";
		String[] datosArticulo = null;
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(FICHERO_CATALOGO));
			while (fichero.ready()) { // Mientras queden lineas por leer
				linea = fichero.readLine(); // Lee la linea
				datosArticulo = linea.split("@");
				// Corta la linea por el caracter indicado -> crea varias lineas
				// en un array
				articulosCatalogo
						.add(new Articulo(datosArticulo[0], datosArticulo[1],
								Float.parseFloat(datosArticulo[2]), 0));
				// Añade al ArrayList un nuevo Articulo con los campos del
				// array
				// || Float.parseFloat -> convierte String a float
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Convierte un ArrayList a un array, ya que el comboBox no admite ArrayList
	 * 
	 * @return Lista de articulos.
	 */
	public Articulo[] getArticulos() {
		Articulo[] articulos = articulosCatalogo
				.toArray(new Articulo[articulosCatalogo.size()]);
		return articulos;
	}

	/**
	 * Inicializa el catalogo
	 */
	public void inicializar() {
		for (Articulo catalogo : articulosCatalogo) {
			catalogo.setUnidades(0);
		}
	}

}
