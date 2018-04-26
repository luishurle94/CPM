package logica;

import java.util.ArrayList;

/**
 * Clase 'Sala' para el módulo entregable de CPM. Esta clase representa cada una
 * de las salas del cine
 * 
 * @author UO236852
 *
 */
public class Room {
	/**
	 * Nombre de la sala
	 */
	private String nombre;
	/**
	 * Lista de todas las butacas de la sala
	 */
	private ArrayList<Seat> butacas;

	/**
	 * Constructor para la clase 'Sala'
	 * 
	 * @param nombre
	 *            Nombre de la sala
	 */
	public Room(String nombre, Moment[] momentos) {
		butacas = new ArrayList<Seat>(30);
		// Crear asientos
		for (int i = 0; i < 30; i++)
			butacas.add(new Seat(String.valueOf(i + 1), momentos));
		// Ocupar algunos de forma aleatoria
		// for (int i = 0; i < 5; i++) {
		// butacas.get(new Random().nextInt(30)).setEstado(Seat.OCUPADA);;
		// }
		this.nombre = nombre;
	}

	public ArrayList<Seat> getButacas() {
		return this.butacas;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
