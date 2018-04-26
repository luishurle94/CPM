package logica;

/**
 * Clase 'Tarifa' para el mï¿½dulo entregable de CPM. Esta clase representa a
 * los precios del cine.
 * 
 * @author UO236852
 *
 */
public class Fare {
	/**
	 * Precio normal
	 */
	private float normal;
	/**
	 * Variaciï¿½n del precio para pelï¿½culas en 3D
	 */
	private float delta3d;
	/**
	 * Variaciï¿½n del precio para packs de cumpleaï¿½os
	 */
	private float deltaCumpleaños;
	/**
	 * Variaciï¿½n del precio para tarifas 'Serafina'
	 */
	private float deltaJubilados;

	/**
	 * Constructor para la clase 'Tarifa'
	 * 
	 * @param normal
	 *            Precio normal
	 * @param delta3d
	 *            Variaciï¿½n para pelï¿½culas 3D
	 * @param deltaCumpleaï¿½os
	 *            Variaciï¿½n par cumpleaï¿½os
	 * @param deltaJubilados
	 *            Variaciï¿½n para Serafina
	 */
	public Fare(float normal, float delta3d, float deltaCumpleaños,
			float deltaJubilados) {
		this.normal = normal;
		this.delta3d = delta3d;
		this.deltaCumpleaños = deltaCumpleaños;
		this.deltaJubilados = deltaJubilados;
	}

	public float getNormal() {
		return normal;
	}

	public float getDelta3d() {
		return delta3d;
	}

	public float getDeltaCumpleaños() {
		return deltaCumpleaños;
	}

	public float getDeltaJubilados() {
		return deltaJubilados;
	}

}
