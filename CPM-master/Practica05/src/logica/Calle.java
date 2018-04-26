package logica;

public class Calle {

	public static final int DIM = 11;
	public static final int POSICION_META = DIM - 1;
	private Casilla[] casillas = new Casilla[DIM];

	public Calle(int arboles) {
		for (int i = 0; i < DIM; i++) {
			casillas[i] = new Casilla();
		}
		numeroArboles(arboles);
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
		// Metemos -1 para que nunca caiga un árbol en la casilla de meta
		int semilla = DIM - 1;
		do {
			columna = ((int) (Math.random() * semilla));
		} while (casillas[columna].tieneArbol() || casillas[0].tieneArbol());
		casillas[columna].plantarArbol();
	}

	public void borrarArbol() {
		for (int i = 1; i <= DIM; i++) {
			if (casillas[i].tieneArbol()) {
				casillas[i].sacarArbol();
				break;
			}
		}
	}
}
