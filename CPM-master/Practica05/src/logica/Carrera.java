package logica;

public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;
	private int numeroDado;

	public Carrera() {
		inicializarJuego();
	}

	public void inicializarJuego() {
		liebre = new Corredor(new Calle(1), "liebre", "liebre.jpg", 4);
		tortuga = new Corredor(new Calle(0), "tortuga", "tortuga.jpg", 2);
		numeroDado = 0;
		// Establecemos el corredor activo apuntando a la tortuga ya que sale la
		// primera
		this.setCorredorActivo(tortuga);
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		numeroDado = Dado.lanzar(getCorredorActivo());
		if (corredorActivo.getPosicion() + numeroDado < Calle.DIM)
			isPosible = true;
		else {
			cambiarTurnos();
		}
		return isPosible;
	}

	private boolean isJugadaCorrecta(int i) {
		return (corredorActivo.getPosicion() + numeroDado == i);
	}

	public boolean resolverJugada(int i) {
		if (isJugadaCorrecta(i)) {
			corredorActivo
					.setPosicion(corredorActivo.getPosicion() + numeroDado);
			// Si tenemos un arbol en la casilla, ponemos a dormir al corredor
			if (corredorActivo.getCalleAsignada()
					.getCasilla(corredorActivo.getPosicion()).tieneArbol())
				corredorActivo.dormir();
			// Incrementamos la puntuci�n del corredor
			corredorActivo
					.incrementaPuntuacion(corredorActivo.getCalleAsignada()
							.puntosCasilla(corredorActivo.getPosicion()));
			// Intercambiamos los turnos
			cambiarTurnos();
			return true;
		}
		return false;
	}

	public Corredor getCorredorActivo() {
		return corredorActivo;
	}

	public Corredor getCorredorNoActivo() {
		if (corredorActivo == liebre) {
			return tortuga;
		}
		return liebre;
	}

	private void cambiarTurnos() {
		// Cambiamos el turno
		if (getCorredorNoActivo().isDurmiendo()) {
			// Si el corredor no activo está durmiendo, lo despertamos para el
			// siguiente turno pero NO CAMBIAMOS EL TURNO
			getCorredorNoActivo().despertar();
		} else {
			// Cambiamos el turno
			corredorActivo = getCorredorNoActivo();
		}
	}

	public boolean isPartidaFinalizadaLiebre() {
		return (liebre.getPosicion() == Calle.POSICION_META);
	}

	public boolean isPartidaFinalizadaTortuga() {
		return (tortuga.getPosicion() == Calle.POSICION_META);
	}

	public int getNumeroDado() {
		return numeroDado;
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public Corredor getTortuga() {
		return tortuga;
	}

	private void setCorredorActivo(Corredor corredorActivo) {
		this.corredorActivo = corredorActivo;
	}

}