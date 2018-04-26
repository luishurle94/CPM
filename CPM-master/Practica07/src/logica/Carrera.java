package logica;

public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;
	private int numeroDado;

	public Carrera() {
		inicializarJuego(11, 2);
	}

	public void inicializarJuego(int casillas, int numArboles) {
		int numAgujero = (int) ((Math.random() * 2));
		int numPremio = (int) ((Math.random() * 2));
		boolean agujero, premio;

		if (numAgujero == 0)
			agujero = true;
		else
			agujero = false;

		if (numPremio == 0)
			premio = true;
		else
			premio = false;

		// Si la calle de la liebre esta completa de arboles, el premio y el
		// agujero van a la calle de la tortuga
		if (numArboles >= casillas - 2) {
			liebre = new Corredor(new Calle(casillas, numArboles, false, false),
					"liebre", "liebre.jpg", 4);
			tortuga = new Corredor(new Calle(casillas, 0, true, true),
					"tortuga", "tortuga.jpg", 2);

		} else {
			liebre = new Corredor(
					new Calle(casillas, numArboles, agujero, premio), "liebre",
					"liebre.jpg", 4);
			tortuga = new Corredor(new Calle(casillas, 0, !agujero, !premio),
					"tortuga", "tortuga.jpg", 2);
		}
		numeroDado = 0;

		// Establecemos el corredor activo apuntando a la tortuga ya que sale la
		// primera
		this.setCorredorActivo(tortuga);
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		numeroDado = Dado.lanzar(getCorredorActivo());
		if (corredorActivo.getPosicion() + numeroDado < Calle.dim)
			isPosible = true;
		else {
			cambiarTurnos();
		}
		return isPosible;
	}

	/**
	 * Comprueba si el movimiento del corredor es posible, es decir, la posicion
	 * a la que quiere acceder esta dentro del panel
	 * 
	 * @param i
	 *            Número de la casilla a la que quiere acceder
	 * @return True si la posicion esta dentro del panel. En caso contrario
	 *         false
	 */
	private boolean isJugadaCorrecta(int i) {
		return (corredorActivo.getPosicion() + numeroDado == i);
	}

	/**
	 * Resuelve la jugada del corredor
	 * 
	 * @param i
	 *            Número de la casilla a la que quiere acceder
	 * @return True si la jugada es posible. En caso contrario false
	 */
	public boolean resolverJugada(int i) {
		if (isJugadaCorrecta(i)) {
			corredorActivo
					.setPosicion(corredorActivo.getPosicion() + numeroDado);
			// Si tenemos un arbol en la casilla, ponemos a dormir al corredor
			if (corredorActivo.getCalleAsignada()
					.getCasilla(corredorActivo.getPosicion()).tieneArbol())
				corredorActivo.dormir();

			// Si hay una agujero en la casilla, el corredor se lesiona y no
			// puede continuar
			if (corredorActivo.getCalleAsignada()
					.getCasilla(corredorActivo.getPosicion()).tieneAgujero())
				corredorActivo.caerse();

			// Incrementamos la puntución del corredor
			corredorActivo
					.incrementaPuntuacion(corredorActivo.getCalleAsignada()
							.puntosCasilla(corredorActivo.getPosicion()));

			// Si hay un premio en la casilla, se duplica la puntuacion actual
			if (corredorActivo.getCalleAsignada()
					.getCasilla(corredorActivo.getPosicion()).tienePremio())
				corredorActivo.duplicarPuntuacion();

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
		if (corredorActivo == liebre)
			return tortuga;
		return liebre;
	}

	/**
	 * Cambia el turno entre los corredores
	 */
	private void cambiarTurnos() {
		// Si el corredor no activo está durmiendo, lo despertamos para el
		// siguiente turno pero NO CAMBIAMOS EL TURNO
		if (getCorredorNoActivo().isDurmiendo()) {
			getCorredorNoActivo().despertar();
		} else {
			// Cambiamos el turno
			corredorActivo = getCorredorNoActivo();
		}
	}

	public boolean isPartidaFinalizadaLiebre() {
		return (liebre.getPosicion() == Calle.posicionMeta);
	}

	public boolean isPartidaFinalizadaTortuga() {
		return (tortuga.getPosicion() == Calle.posicionMeta);
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