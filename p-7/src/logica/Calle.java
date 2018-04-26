package logica;

public class Calle {
	
	public static int DIM = 0;
	public static final int POSICION_META = DIM -1;
	private Casilla[] casillas = new Casilla[DIM];

	public Calle (int dim2) {
		DIM=dim2;
		for (int i = 0; i < DIM; i++) {		
			casillas[i] = new Casilla();
		}
	}

	public int puntosCasilla(int posicion) {
		return casillas[posicion].getValor();
	}
	
	public Casilla getCasilla(int posicion) {
		return casillas[posicion];
	}
}
