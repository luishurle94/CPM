package logica;

public class Corredor {
	private int puntuacion;
	private int posicion;
	private boolean turno;
	private int desplazamiento;
	private String nombre;
	private String foto;
	private Calle calleAsignada;
	private boolean trampa;
	private boolean dormido;
	private boolean SP;
	public final static int POSICION_SALIDA = 0; 
	
	public Corredor(Calle calleAsignada, String nombre, String foto, int desplazamiento, boolean turno) {
		this.calleAsignada = calleAsignada;
		this.nombre = nombre;
		this.foto = foto;
		this.desplazamiento = desplazamiento; 
		this.turno = turno;
		puntuacion = 0;
		posicion = POSICION_SALIDA;
		this.trampa=false;
		this.dormido=false;
	}
	
	

	public String getNombre() {
		return nombre;
	}
	
	public int getDesplazamiento() {
		return desplazamiento;
	}

	public int getPuntuacion() {
		if(getPosicion() == Calle.POSICION_META) {
			incrementaPuntuacion(200);
		}
		return puntuacion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion (int posicion) {
		this.posicion = posicion;
	}
	
	public boolean getTurno() {
		return turno;
	}
	
	public void cambiaTurno() {
		turno = !turno;
	}
	
	public Calle getCalleAsignada() {
		return calleAsignada;
	}

	public String getFoto() {
		return foto;
	}
	
	public void incrementaPuntuacion (int puntos){
		puntuacion += puntos;

	}
	
	public boolean isTrampa() {
		return trampa;
	}

	public void setTrampa(boolean trampa) {
		this.trampa = trampa;
	}

	public boolean isDormido() {
		return dormido;
	}

	public void setDormido(boolean dormido) {
		this.dormido = dormido;
	}
	
	public void dormir() {
		if(dormido = true)
			this.dormido=false;
		this.dormido=true;
	}
	
	public boolean isSP() {
		return SP;
	}

	public void setSP(boolean sP) {
		SP = sP;
	}
	
}
