package logica;

public class Calle {

	public static int dim;
	public static int posicionMeta;
	private Casilla[] casillas;

	public Calle(int tamano, int arboles, boolean agujero, boolean premio) {
		dim = tamano + 1;
		posicionMeta = dim - 1;
		casillas = new Casilla[dim];
		for (int i = 0; i < dim; i++) {
			casillas[i] = new Casilla();
		}
		numeroArboles(arboles);
		if (arboles < dim - 2) {
			if (agujero)
				colocarAgujero();
			if (premio)
				colocarPremio();
		}
	}

	public void numeroArboles(int n) {
		for (int i = 1; i <= n; i++) {
			colocarArbol();
		}
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}

	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}

	private void colocarArbol() {
		int columna;
		// Metemos -1 para que nunca caiga un �rbol en la casilla de meta
		int semilla = dim - 1;
		do
			columna = ((int) (Math.random() * semilla));
		while (columna == 0 || casillas[columna].tieneArbol());
		casillas[columna].plantarArbol();
	}

	public void borrarArbol() {
		for (int i = 1; i <= dim; i++) {
			if (casillas[i].tieneArbol()) {
				casillas[i].sacarArbol();
				break;
			}
		}
	}

	private void colocarAgujero() {
		int columna;
		// Metemos -1 para que nunca caiga un �rbol en la casilla de meta
		int semilla = dim;
		do {
			columna = ((int) (Math.random() * semilla));
		} while (casillas[columna].tieneArbol() || columna == 0);
		casillas[columna].cavarAgujero();
	}

	private void colocarPremio() {
		int columna;
		// Metemos -1 para que nunca caiga un �rbol en la casilla de meta
		int semilla = dim;
		do {
			columna = ((int) (Math.random() * semilla));
		} while (casillas[columna].tieneArbol() || columna == 0
				|| casillas[columna].tieneAgujero());
		casillas[columna].ponerPremio();
	}

	public int getCasillas() {
		return dim;
	}
}
