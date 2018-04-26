package logica;

public class Corredor {
	private int puntuacion;
	private int posicion;
	private int desplazamiento;
	private String nombre;
	private String foto;
	private Calle calleAsignada;
	public final static int POSICION_SALIDA = 0;
	private boolean durmiendo = false;
	private boolean lesionado = false;

	public Corredor(Calle calleAsignada, String nombre, String foto,
			int desplazamiento) {
		this.calleAsignada = calleAsignada;
		this.nombre = nombre;
		this.foto = foto;
		this.desplazamiento = desplazamiento;
		puntuacion = 0;
		posicion = POSICION_SALIDA;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDesplazamiento() {
		return desplazamiento;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public Calle getCalleAsignada() {
		return calleAsignada;
	}

	public String getFoto() {
		return foto;
	}

	public void incrementaPuntuacion(int puntos) {
		puntuacion += puntos;
	}

	public boolean isDurmiendo() {
		return durmiendo;
	}

	public void dormir() {
		durmiendo = true;
	}

	public void despertar() {
		durmiendo = false;
	}

	public void caerse() {
		lesionado = true;
	}

	public boolean lesionado() {
		return lesionado;
	}
}
