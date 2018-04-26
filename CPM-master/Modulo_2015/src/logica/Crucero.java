package logica;

import java.util.ArrayList;

/**
 * Clase que simula a un crucero de vacaciones
 * 
 * @author Iván González Mahagamage
 *
 */
public class Crucero {
	private String codigo;
	private String zona;
	private String denominacion;
	private String puertoSalida;
	private String itinerario;
	private String descripcion;
	private boolean menores;
	private int duracionDias;
	private String[] fechas;
	private ArrayList<ArrayList<Camarote>> camarotesFechas;
	private Barco barco;
	private boolean descuento;

	/**
	 * Constructor con par�metros
	 * 
	 * @param codigo
	 *            Codigo de identificaci�n
	 * @param zona
	 *            Zona geogr�fica por las que pasa durante su trayecto
	 * @param denominacion
	 *            Denominaci�n de la zona
	 * @param puertoSalida
	 *            Puerto de salida del crucero
	 * @param itinerario
	 *            Ciudades por las que pasa el barco durante el crucero
	 * @param descripcion
	 *            Descripci�n del crucero
	 * @param menores
	 *            Indica si se permiten menores de edad
	 * @param duracionDias
	 *            Dias que dira el crucero
	 * @param fechas
	 *            Fechas en las que se realiza el crucero
	 * @param barco
	 *            Barco que se utiliza en el crucero
	 */
	public Crucero(String codigo, String zona, String denominacion,
			String puertoSalida, String itinerario, String descripcion,
			boolean menores, int duracionDias, String[] fechas, Barco barco) {
		this.codigo = codigo;
		this.zona = zona;
		this.denominacion = denominacion;
		this.puertoSalida = puertoSalida;
		this.itinerario = itinerario;
		this.descripcion = descripcion;
		this.menores = menores;
		this.duracionDias = duracionDias;
		this.fechas = fechas;
		this.barco = barco;
		camarotesFechas = new ArrayList<ArrayList<Camarote>>();
		for (int i = 0; i < fechas.length; i++)
			camarotesFechas
					.add((ArrayList<Camarote>) barco.getCamarotesBarco());
		descuento = false;
	}

	/**
	 * M�todo que devuelve el c�digo del crucero
	 * 
	 * @return El c�digo del crucero
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo que modifica el c�digo del crucero
	 * 
	 * @param codigo
	 *            Nuevo c�digo del crucero
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo que devuelve la zona donde transcurre el crucero
	 * 
	 * @return La zona donde transcurre el crucero
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * M�todo que modifica la zona donde transcurre el crucero
	 * 
	 * @param zona
	 *            Nueva zona donde transcurre el crucero
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 * M�todo que devuelve la denominaci�n del crucero
	 * 
	 * @return La denominaci�n del crucero
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * M�todo que modifica la denominaci�n del crucero
	 * 
	 * @param denominacion
	 *            Nueva denominaci�n del crucero
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * M�todo que devuelve el puerto de salida de un crucero
	 * 
	 * @return El puerta de salida de un crucero
	 */
	public String getPuertoSalida() {
		return puertoSalida;
	}

	/**
	 * M�todo que modifica el puerto de salida de un crucero
	 * 
	 * @param puertoSalida
	 *            Nuevo puerta de salida de un crucero
	 */
	public void setPuertoSalida(String puertoSalida) {
		this.puertoSalida = puertoSalida;
	}

	/**
	 * M�todo que devuelve el itinerario del crucero
	 * 
	 * @return El itinerario del crucero
	 */
	public String getItinerario() {
		return itinerario;
	}

	/**
	 * M�todo que modifica el itinerario del crucero
	 * 
	 * @param itinerario
	 *            Nuevo itinerario del crucero
	 */
	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	/**
	 * M�todo que devuelve la descripci�n del crucero
	 * 
	 * @return La descripci�n del crucero
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo que modifica la descripci�n del crucero
	 * 
	 * @param descripcion
	 *            Nueva descripci�n del crucero
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * M�todo que devuelve si en el crucero se admiten menores
	 * 
	 * @return True si se admiten menores en el crucero. En caso contrario false
	 */
	public boolean isMenores() {
		return menores;
	}

	/**
	 * M�todo que modifica el permiso para que entren menores en el crucero
	 * 
	 * @param menores
	 *            Nuevo permiso para que entren menores en el crucero
	 */
	public void setMenores(boolean menores) {
		this.menores = menores;
	}

	/**
	 * M�todo que devuelve la duraci�n del crucero
	 * 
	 * @return La duraci�n del crucero
	 */
	public int getDuracionDias() {
		return duracionDias;
	}

	/**
	 * M�todo que modifica la duraci�n del crucero
	 * 
	 * @param duracionDias
	 *            Nueva duraci�n del crucero
	 */
	public void setDuracionDias(int duracionDias) {
		this.duracionDias = duracionDias;
	}

	/**
	 * M�todo que devuelve las fechas de salida del crucero
	 * 
	 * @return Las fechas de salida del crucero
	 */
	public String[] getFechas() {
		return fechas;
	}

	/**
	 * M�todo que modifica las fechas de salida del crucero
	 * 
	 * @param fechas
	 *            Nuevas fechas de salida del crucero
	 */
	public void setFechas(String[] fechas) {
		this.fechas = fechas;
	}

	/**
	 * M�todo que devuelve el barco que se usa durante el crucero
	 * 
	 * @return El barco del crucero
	 */
	public Barco getBarco() {
		return barco;
	}

	/**
	 * M�todo que modifica el barco del crucero
	 * 
	 * @param barco
	 *            Nuevo barco del crucero
	 */
	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public ArrayList<ArrayList<Camarote>> getPasajerosFechas() {
		return camarotesFechas;
	}

	public void setPasajerosFechas(
			ArrayList<ArrayList<Camarote>> pasajerosFechas) {
		this.camarotesFechas = pasajerosFechas;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

}
