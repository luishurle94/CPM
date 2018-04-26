package logica;

import java.io.*;
import java.util.*;

/**
 * Clase que simula un camarote de un barco de crucero
 * 
 * @author Iván González Mahagamage
 *
 */
public class Camarote {
	private boolean tipo;
	private boolean posicion;
	private float precio;
	private List<Extra> listaExtras;
	private boolean reservada;
	private Pasajero[] pasajeros;

	public static boolean TIPO_FAMILIAR = true;
	public static boolean TIPO_DOBLE = false;
	public static boolean POSICION_INTERIOR = true;
	public static boolean POSICION_EXTERIOR = false;
	private static final String FICHERO_EXTRAS = "files/extras.dat";

	/**
	 * Constructor con par�metros
	 * 
	 * @param tipo
	 *            Tipo del camarote
	 * @param posicion
	 *            Posici�n del camarote respecto al barco
	 * @param precio
	 *            Precio del camarote
	 */
	public Camarote(boolean tipo, boolean posicion, float precio) {
		this.tipo = tipo;
		this.posicion = posicion;
		this.precio = precio;
		listaExtras = new ArrayList<Extra>();
		cargarExtras();
		reservada = false;
		if (tipo)
			pasajeros = new Pasajero[5];
		else
			pasajeros = new Pasajero[3];
	}

	/**
	 * M�todo que devuelve el tipo del camarote
	 * 
	 * @return El tipo del camarote
	 */
	public boolean isTipo() {
		return tipo;
	}

	/**
	 * M�todo que modifica el tipo del camarote
	 * 
	 * @param tipo
	 *            Nuevo tipo del camarote
	 */
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	/**
	 * M�todo que devuelve la posici�n del camarote
	 * 
	 * @return La posici�n del camarote
	 */
	public boolean isPosicion() {
		return posicion;
	}

	/**
	 * M�todo que modifica la posici�n del camarote
	 * 
	 * @param posicion
	 *            Nueva posici�n del camarote
	 */
	public void setPosicion(boolean posicion) {
		this.posicion = posicion;
	}

	/**
	 * M�todo que devuelve el precio del camarote
	 * 
	 * @return El precio del camarote
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * M�todo que modifica el precio del camarote
	 * 
	 * @param precio
	 *            Nuevo precio del camarote
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * M�todo que devuelve la lista de extras del camarote
	 * 
	 * @return Los extras del camarote
	 */
	public List<Extra> getExtras() {
		return listaExtras;
	}

	/**
	 * M�todo que modifica la lista de extras del camarote
	 * 
	 * @param extras
	 *            Nueva lista de extras del camarote
	 */
	public void setExtras(List<Extra> extras) {
		this.listaExtras = extras;
	}

	/**
	 * M�todo que devuelve la reserva del camarote
	 * 
	 * @return La reserva del camarote
	 */
	public boolean isReservada() {
		return reservada;
	}

	/**
	 * M�todo que modifica la reserva del camarote
	 * 
	 * @param reservada
	 *            Nueva reserva del camarote
	 */
	public void setReservada(boolean reservada) {
		this.reservada = reservada;
	}

	/**
	 * Carga la lista de extras disponibles para los camarotes
	 */
	private void cargarExtras() {
		try {
			BufferedReader fichero = new BufferedReader(
					new FileReader(FICHERO_EXTRAS));
			while (fichero.ready()) {
				String linea = fichero.readLine();
				String[] datosExtra = linea.split(";");
				listaExtras.add(new Extra(datosExtra[0], datosExtra[1],
						Float.parseFloat(datosExtra[2])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo extras.dat no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public Pasajero[] getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Pasajero[] pasajeros) {
		this.pasajeros = pasajeros;
	}

}
