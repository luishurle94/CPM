package logica;

/**
 * Clase que simula un extra en un camarote de barco
 * 
 * @author IvÃ¡n GonzÃ¡lez Mahagamage
 *
 */
public class Extra {
	private String codigo;
	private String descripcion;
	private float precio;
	private boolean añadido;

	/**
	 * Constructor con parï¿½metros
	 * 
	 * @param codigo
	 *            Cï¿½digo para denominar el extra
	 * @param descripcion
	 *            Descripciï¿½n del extra
	 * @param precio
	 *            Precio del extra
	 */
	public Extra(String codigo, String descripcion, float precio) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		añadido = false;
	}

	/**
	 * Mï¿½todo que devuelve el cï¿½digo del extra
	 * 
	 * @return El cï¿½digo del extra
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Mï¿½todo que modifica el codigo del extra
	 * 
	 * @param codigo
	 *            Nuevo cï¿½digo del extra
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Mï¿½todo que devuelve la descripciï¿½n del extra
	 * 
	 * @return La descripciï¿½n del extra
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Mï¿½todo que modifica la descripciï¿½n del extra
	 * 
	 * @param descripcion
	 *            Nueva descripciï¿½n del extra
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Mï¿½todo que devuelve el precio del extra
	 * 
	 * @return El precio del extra
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Mï¿½todo que modifica el precio del extra
	 * 
	 * @param precio
	 *            Nuevo precio del extra
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Mï¿½todo que devuelve el parï¿½metro aï¿½adido del extra
	 * 
	 * @return Parï¿½metro aï¿½adido del extra
	 */
	public boolean isAñadido() {
		return añadido;
	}

	/**
	 * Mï¿½todo que modifica el parï¿½metro aï¿½adido del extra
	 * 
	 * @param aï¿½adido
	 *            El nuevo parï¿½metro añadido del extra
	 */
	public void setAñadido(boolean añadido) {
		this.añadido = añadido;
	}
}
