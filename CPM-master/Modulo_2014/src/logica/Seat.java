package logica;

import java.util.HashMap;

/**
 * Clase 'Butaca' para el módulo entregable de CPM. Esta clase representa a cada
 * butaca de una sala.
 * 
 * @author UO236852
 *
 */
public class Seat {
	/**
	 * Constante para una butaca libre
	 */
	public static final int LIBRE = 0;
	/**
	 * Constante para una butaca ocupada
	 */
	public static final int OCUPADA = 1;
	/**
	 * Constante para una butaca que el cliente actual ha seleccionado
	 */
	public static final int PARA_MI = 2;

	/**
	 * Posición de esta butaca (por ejemplo 'Fila: 2 Asiento: 3')
	 */
	private String posicion;
	/**
	 * Estado de esta butaca (libre, ocupada o seleccionada)
	 */
	private HashMap<Moment, Integer> estado;

	/**
	 * Constructor para la clase 'Butaca'
	 */
	public Seat(String posicion, Moment[] momentos) {
		this.estado = new HashMap<Moment, Integer>();
		for (Moment m : momentos)
			estado.put(m, Seat.LIBRE);
		this.posicion = posicion;
	}

	/**
	 * Método que devuelve el estado de esta butaca
	 * 
	 * @return Estado de la butaca
	 */
	public int getEstado(Moment momento) {
		if (!estado.containsKey(momento))
			throw new IllegalStateException();
		return this.estado.get(momento);
	}

	public void setEstado(int estado, Moment momento) {
		this.estado.remove(momento);
		this.estado.put(momento, estado);
	}

	@Override
	public String toString() {
		return this.posicion;
	}
}
