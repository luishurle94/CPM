package logica;

public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;
	private int PosTrampa;
	private int PosArbol;

	public Carrera() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		liebre = new Corredor(new Calle(), "liebre", "liebre.jpg", 4, false);
		tortuga = new Corredor(new Calle(), "tortuga", "tortuga.jpg", 2, true);
		// Establecemos el corredor activo. Será la tortuga ya que es la que tiene el
		// primer turno
		setCorredorActivo();
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar(corredorActivo.getDesplazamiento());
		if (corredorActivo.getPosicion() + Dado.getValor() < Calle.DIM)
			isPosible = true;
		else
			cambiarTurnos();
		return isPosible;
	}

	private boolean isJugadaCorrecta(int i) {
		return (corredorActivo.getPosicion() + Dado.getValor() == i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;
		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta(i)) {
			corredorActivo.setPosicion(corredorActivo.getPosicion() + Dado.getValor());
			// Incrementamos la puntuacion del corredor
			corredorActivo.incrementaPuntuacion(
					corredorActivo.getCalleAsignada().puntosCasilla(corredorActivo.getPosicion()));
			// Intercambiamos los turnos
			if (getLiebre().getPosicion() == PosArbol) {
				getLiebre().setDormido(true);
			}
			cambiarTurnos();
			resuelta = true;
		}
		return resuelta;
	}

	public Corredor getCorredorActivo() {
		return corredorActivo;
	}

	private void cambiarTurnos() {
		// Cambiamos el turno
		liebre.cambiaTurno();
		tortuga.cambiaTurno();
		setCorredorActivo();
		if (getLiebre().isDormido()) {
			liebre.cambiaTurno();
			tortuga.cambiaTurno();
			setCorredorActivo();
			getLiebre().setDormido(false);
		}
	}

	private void setCorredorActivo() {
		if (liebre.getTurno())
			corredorActivo = liebre;
		else
			corredorActivo = tortuga;
	}

	public boolean isPartidaFinalizada() {
		if (liebre.getPosicion() == Calle.POSICION_META || tortuga.getPosicion() == Calle.POSICION_META)
			return true;
		if (corredorActivo.getPosicion() == PosTrampa && corredorActivo.isTrampa())
			return true;
		return false;
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public Corredor getTortuga() {
		return tortuga;
	}

	public int getPosTrampa() {
		return PosTrampa;
	}

	public void setPosTrampa() {
		this.PosTrampa = ((int) (Math.random() * 10) + 1);
		int corredorAct = ((int) (Math.random() * 10) + 1);
		if (corredorAct == 2 || corredorAct == 5 || corredorAct == 8) {
			getLiebre().setTrampa(true);
		} else {
			getTortuga().setTrampa(true);
		}

	}

	public int getPosArbol() {
		return PosArbol;
	}

	public void setPosArbol() {
		this.PosArbol = ((int) (Math.random() * 10) + 1);
		do {
			this.PosArbol = ((int) (Math.random() * 10) + 1);
		} while (PosTrampa == PosArbol);
	}
}