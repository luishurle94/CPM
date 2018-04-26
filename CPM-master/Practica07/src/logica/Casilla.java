package logica;

public class Casilla {

	private int valor;
	private boolean arbol = false;
	private boolean agujero = false;
	private boolean premio = false;

	public Casilla() {
		setValor(50);
	}

	public int getValor() {
		return valor;
	}

	private void setValor(int valor) {
		this.valor = valor;
	}

	public boolean tieneArbol() {
		return arbol;
	}

	public void plantarArbol() {
		arbol = true;
	}

	public void sacarArbol() {
		arbol = false;
	}

	public boolean tieneAgujero() {
		return agujero;
	}

	public void cavarAgujero() {
		agujero = true;
	}

	public boolean tienePremio() {
		return premio;
	}

	public void ponerPremio() {
		premio = true;
	}
}
