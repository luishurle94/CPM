package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase 'Cine' para el módulo entregable de CPM. La clase cine administra todo
 * el tinglado a alto nivel.
 * 
 * @author UO236852
 *
 */
public class Cinema {
	/**
	 * Lista de películas (cargadas desde el fichero) que se ofrecen en el cine
	 */
	private ArrayList<Movie> peliculas;
	/**
	 * Lista de salas del cine
	 */
	private ArrayList<Room> salas;
	/**
	 * Cliente actual del TPV
	 */
	private Client cliente;
	/**
	 * Tarifas de este cine (cargadas desde el fichero)
	 */
	private Fare tarifa;

	/**
	 * Constructor para la clase 'Cine' que carga los datos y prepara un nuevo
	 * cliente
	 * 
	 * @throws IOException
	 *             Algo malo ha pasado
	 */
	public Cinema() throws IOException {

		salas = new ArrayList<Room>();
		peliculas = new ArrayList<Movie>();
		// Cargar fichero de tarifas
		System.out.println("** Abriendo el fichero de precios **");
		BufferedReader sr = new BufferedReader(
				new FileReader("bin/files/precios.dat"));
		while (sr.ready()) {
			String precios = sr.readLine();
			String[] ptr = precios.split(";");
			float base = Float.valueOf(ptr[1]);
			System.out.println(" Precio base: " + Float.valueOf(ptr[1]));
			float p3d = Float.valueOf(ptr[2]);
			System.out.println(" Incremento 3D: " + Float.valueOf(ptr[2]));
			float pcm = Float.valueOf(ptr[3]);
			System.out.println(
					" Incremento cumpleaños: " + Float.valueOf(ptr[3]));
			float pjb = Float.valueOf(ptr[4]);
			System.out
					.println(" Incremento jubilados: " + Float.valueOf(ptr[4]));
			this.tarifa = new Fare(base, p3d, pcm, pjb);
		}
		sr.close();
		System.out.println("** Precios configurados **");
		// Cargar fichero de películas
		System.out.println("** Abriendo el fichero de películas **");
		sr = new BufferedReader(new FileReader("bin/files/cartelera.dat"));
		while (sr.ready()) {
			peliculas.add(Movie.parseMovie(sr.readLine(), this));
		}
		System.out.println("** Todas las películas añadidas **");
		// Crear un nuevo cliente
		cliente = new Client();
	}

	public Client getCliente() {
		return this.cliente;
	}

	public Fare getTarifa() {
		return this.tarifa;
	}

	public ArrayList<Room> getSalas() {
		return this.salas;
	}

	public ArrayList<Movie> getPeliculas() {
		return this.peliculas;
	}

	protected void addSala(Room sala) {
		salas.add(sala);
	}
}
