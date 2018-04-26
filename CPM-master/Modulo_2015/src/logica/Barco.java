package logica;

import java.util.*;

/**
 * Clase que simula un barco de crucero
 * 
 * @author Iván González Mahagamage
 *
 */
public class Barco {
	private String codigo;
	private String denominacion;
	private String descripcion;
	private int numCamarotesDoblesInteriores;
	private int numCamarotesDoblesExteriores;
	private int numCamarotesFamiliaresInteriores;
	private int numCamarotesFamiliaresExteriores;
	private float precioCamarotesDoblesInteriores;
	private float precioCamarotesDoblesExteriores;
	private float precioCamarotesFamiliaresInteriores;
	private float precioCamarotesFamiliaresExteriores;
	private List<Camarote> camarotesBarco;
	private Capitan capitan;

	/**
	 * Constructor con par�metros
	 * 
	 * @param codigo
	 *            C�digo del barco
	 * @param denominacion
	 *            Denominaci�n del barco
	 * @param descripcion
	 *            Descripci�n del barco
	 * @param numCamarotesDoblesInteriores
	 *            N�mero de camarotes dobles interiores
	 * @param numCamarotesDoblesExteriores
	 *            N�mero de camarotes dobles exteriores
	 * @param numCamarotesFamiliaresInteriores
	 *            N�mero de camarotes familiares interiores
	 * @param numCamarotesFamiliaresExteriores
	 *            N�mero de camarotes familiares exteriores
	 * @param precioCamarotesDoblesInteriores
	 *            Precio de los camarotes dobles interiores
	 * @param precioCamarotesDoblesExteriores
	 *            Precio de los camarotes dobles exteriores
	 * @param precioCamarotesFamiliaresInteriores
	 *            Precio de los camarotes familiares interiores
	 * @param precioCamarotesFamiliaresExteriores
	 *            Precio de los camarotes familiares exteriores
	 */
	public Barco(String codigo, String denominacion, Capitan capitan,
			String descripcion, int numCamarotesDoblesInteriores,
			int numCamarotesDoblesExteriores,
			int numCamarotesFamiliaresInteriores,
			int numCamarotesFamiliaresExteriores,
			float precioCamarotesDoblesInteriores,
			float precioCamarotesDoblesExteriores,
			float precioCamarotesFamiliaresInteriores,
			float precioCamarotesFamiliaresExteriores) {
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.capitan = capitan;
		this.descripcion = descripcion;
		this.numCamarotesDoblesInteriores = numCamarotesDoblesInteriores;
		this.numCamarotesDoblesExteriores = numCamarotesDoblesExteriores;
		this.numCamarotesFamiliaresInteriores = numCamarotesFamiliaresInteriores;
		this.numCamarotesFamiliaresExteriores = numCamarotesFamiliaresExteriores;
		this.precioCamarotesDoblesInteriores = precioCamarotesDoblesInteriores;
		this.precioCamarotesDoblesExteriores = precioCamarotesDoblesExteriores;
		this.precioCamarotesFamiliaresInteriores = precioCamarotesFamiliaresInteriores;
		this.precioCamarotesFamiliaresExteriores = precioCamarotesFamiliaresExteriores;
		camarotesBarco = new ArrayList<Camarote>();
		crearCamarotes();
	}

	/**
	 * Rellena la lista de camarotes
	 */
	private void crearCamarotes() {
		for (int i = 0; i < numCamarotesDoblesInteriores; i++)
			camarotesBarco.add(new Camarote(Camarote.TIPO_DOBLE,
					Camarote.POSICION_INTERIOR,
					precioCamarotesDoblesInteriores));
		for (int i = 0; i < numCamarotesDoblesExteriores; i++)
			camarotesBarco.add(new Camarote(Camarote.TIPO_DOBLE,
					Camarote.POSICION_EXTERIOR,
					precioCamarotesDoblesExteriores));
		for (int i = 0; i < numCamarotesFamiliaresInteriores; i++)
			camarotesBarco.add(new Camarote(Camarote.TIPO_FAMILIAR,
					Camarote.POSICION_INTERIOR,
					precioCamarotesFamiliaresInteriores));
		for (int i = 0; i < numCamarotesFamiliaresExteriores; i++)
			camarotesBarco.add(new Camarote(Camarote.TIPO_FAMILIAR,
					Camarote.POSICION_EXTERIOR,
					precioCamarotesFamiliaresExteriores));
	}

	/**
	 * M�todo que devuelve el c�digo del barco
	 * 
	 * @return El c�digo del barco
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo que modifica el c�digo del barco
	 * 
	 * @param codigo
	 *            Nuevo c�digo del barco
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo que devuelve la denominaci�n del barco
	 * 
	 * @return La denominaci�n del barco
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * M�todo que modifica la denominaci�n del barco
	 * 
	 * @param denominacion
	 *            Nueva denominaci�n del barco
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * M�todo que devuelve la descripci�n del barco
	 * 
	 * @return La descripci�n del barco
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * M�todo que modifica la descripci�n del barco
	 * 
	 * @param descripcion
	 *            Nueva descripci�n del barco
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * M�todo que devuelve el n�mero de camarotes dobles interiores del
	 * barco
	 * 
	 * @return El n�mero de camarotes dobles interiores del barco
	 */
	public int getNumCamarotesDoblesInteriores() {
		return numCamarotesDoblesInteriores;
	}

	/**
	 * M�todo que modifica el n�mero de camarotes dobles interiores del
	 * barco
	 * 
	 * @param numCamarotesDoblesInteriores
	 *            Nuevo n�mero de camarotes dobles interiores del barco
	 */
	public void setNumCamarotesDoblesInteriores(
			int numCamarotesDoblesInteriores) {
		this.numCamarotesDoblesInteriores = numCamarotesDoblesInteriores;
	}

	/**
	 * M�todo que devuelve el n�mero de camarotes dobles exteriores del
	 * barco
	 * 
	 * @return El n�mero de camarotes dobles exteriores del barco
	 */
	public int getNumCamarotesDoblesExteriores() {
		return numCamarotesDoblesExteriores;
	}

	/**
	 * M�todo que modifica el n�mero de camarotes dobles exteriores del
	 * barco
	 * 
	 * @param numCamarotesDoblesExteriores
	 *            Nuevo n�mero de camarotes dobles exteriores del barco
	 */
	public void setNumCamarotesDoblesExteriores(
			int numCamarotesDoblesExteriores) {
		this.numCamarotesDoblesExteriores = numCamarotesDoblesExteriores;
	}

	/**
	 * M�todo que devuelve el n�mero de camarotes familiares interiores del
	 * barco
	 * 
	 * @return El n�mero de camarotes familiares interiores del barco
	 */
	public int getNumCamarotesFamiliaresInteriores() {
		return numCamarotesFamiliaresInteriores;
	}

	/**
	 * M�todo que modifica el n�mero de camarotes familiares interiores del
	 * barco
	 * 
	 * @param numCamarotesFamiliaresInteriores
	 *            Nuevo n�mero de camarotes familiares interiores del barco
	 */
	public void setNumCamarotesFamiliaresInteriores(
			int numCamarotesFamiliaresInteriores) {
		this.numCamarotesFamiliaresInteriores = numCamarotesFamiliaresInteriores;
	}

	/**
	 * M�todo que devuelve el n�mero de camarotes familiares exteriores del
	 * barco
	 * 
	 * @return El n�mero de camarotes familiares exteriores del barco
	 */
	public int getNumCamarotesFamiliaresExteriores() {
		return numCamarotesFamiliaresExteriores;
	}

	/**
	 * M�todo que modifica el n�mero de camarotes familiares exteriores del
	 * barco
	 * 
	 * @param numCamarotesFamiliaresExteriores
	 *            Nuevo n�mero de camarotes familiares exteriores del barco
	 */
	public void setNumCamarotesFamiliaresExteriores(
			int numCamarotesFamiliaresExteriores) {
		this.numCamarotesFamiliaresExteriores = numCamarotesFamiliaresExteriores;
	}

	/**
	 * M�todo que devuelve el precio de los camarotes familiares exteriores
	 * del barco
	 * 
	 * @return El precio de los camarotes familiares exteriores del barco
	 */
	public float getPrecioCamarotesDoblesInteriores() {
		return precioCamarotesDoblesInteriores;
	}

	/**
	 * M�todo que modifica el precio de los camarotes dobles interiores del
	 * barco
	 * 
	 * @param precioCamarotesDoblesInteriores
	 *            Nuevo precio de los camarotes dobles interiores
	 */
	public void setPrecioCamarotesDoblesInteriores(
			float precioCamarotesDoblesInteriores) {
		this.precioCamarotesDoblesInteriores = precioCamarotesDoblesInteriores;
	}

	/**
	 * M�todo que devuelve el precio de camarotes dobles exteriores del barco
	 * 
	 * @return El precio de camarotes dobles exteriores del barco
	 */
	public float getPrecioCamarotesDoblesExteriores() {
		return precioCamarotesDoblesExteriores;
	}

	/**
	 * M�todo que modifica el n�mero de camarotes dobles exteriores del
	 * barco
	 * 
	 * @param numCamarotesDoblesExteriores
	 *            Nuevo n�mero de camarotes dobles exteriores del barco
	 */
	public void setPrecioCamarotesDoblesExteriores(
			float precioCamarotesDoblesExteriores) {
		this.precioCamarotesDoblesExteriores = precioCamarotesDoblesExteriores;
	}

	/**
	 * M�todo que devuelve el precio de camarotes familiares interiores del
	 * barco
	 * 
	 * @return El precio de camarotes familiares interiores del barco
	 */
	public float getPrecioCamarotesFamiliaresInteriores() {
		return precioCamarotesFamiliaresInteriores;
	}

	/**
	 * M�todo que modifica el precio de los camarotes familiares interiores
	 * del barco
	 * 
	 * @param precioCamarotesFamiliaresInteriores
	 *            Nuevoprecio de camarotes familiares exteriores del barco
	 */
	public void setPrecioCamarotesFamiliaresInteriores(
			float precioCamarotesFamiliaresInteriores) {
		this.precioCamarotesFamiliaresInteriores = precioCamarotesFamiliaresInteriores;
	}

	/**
	 * M�todo que devuelve el precio de camarotes familiares exteriores del
	 * barco
	 * 
	 * @return El precio de camarotes familiares exteriores del barco
	 */
	public float getPrecioCamarotesFamiliaresExteriores() {
		return precioCamarotesFamiliaresExteriores;
	}

	/**
	 * M�todo que modifica el precio de los camarotes familiares exteriores
	 * del barco
	 * 
	 * @param precioCamarotesFamiliaresExteriores
	 *            Nuevo precio de camarotes familiares exteriores del barco
	 */
	public void setPrecioCamarotesFamiliaresExteriores(
			float precioCamarotesFamiliaresExteriores) {
		this.precioCamarotesFamiliaresExteriores = precioCamarotesFamiliaresExteriores;
	}

	/**
	 * M�todo que devuelve la lista de los camarotes del barcos
	 * 
	 * @return List de objetos Camarote
	 */
	public List<Camarote> getCamarotesBarco() {
		return camarotesBarco;
	}

	/**
	 * M�todo que cambia la lista de los camarotes del barco
	 * 
	 * @param camarotesBarco
	 *            Nueva lista de camarotes
	 */
	public void setCamarotesBarco(List<Camarote> camarotesBarco) {
		this.camarotesBarco = camarotesBarco;
	}

	public Capitan getCapitan() {
		return capitan;
	}

	public void setCapitan(Capitan capitan) {
		this.capitan = capitan;
	}

}
