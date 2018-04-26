package logica;


public class Carrera {

	private Corredor liebre;
	private int trapPos;
	private int superPowerPos;

	public Carrera() {
		inicializarJuego();
		setTrapPos();
		setSuperPowerPos();
	}

	public void inicializarJuego() {
		liebre = new Corredor(new Calle(),"liebre","liebre.jpg");
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar();
		if (liebre.getPosicion() + Dado.getValor() < Calle.DIM)
			isPosible = true;
		return isPosible;	
	}

	
	private boolean isJugadaCorrecta(int i) {
		return (liebre.getPosicion() + Dado.getValor() == i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;
		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta (i)){
			liebre.setPosicion(liebre.getPosicion() + Dado.getValor());
			// Incrementamos la puntuacion del corredor
			liebre.incrementaPuntuacion(liebre.getCalleAsignada().puntosCasilla(liebre.getPosicion()));
			superPower();
			
			resuelta = true;
		}
		return resuelta;
	}

	public boolean isPartidaFinalizada() {
		if(liebre.getPosicion() == Calle.POSICION_META){
			return true;
		}
		if(!liebre.isSP()){
			if(liebre.getPosicion() == this.trapPos){
				return true;}
		}		
		return false;
	}
	public void superPower(){
		if(liebre.getPosicion() == superPowerPos){
			liebre.setSP(true);
			liebre.incrementaPuntuacion(500);
		}
		if(liebre.getPosicion() == trapPos && liebre.isSP() == true){
			liebre.incrementaPuntuacion(1000);
		}
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public int getTrapPos() {
		return trapPos;
	}

	public void setTrapPos() {
		this.trapPos = (int) (Math.random() * (Calle.POSICION_META)-1) + 1;
	}

	public int getSuperPowerPos() {
		return superPowerPos;
	}

	public void setSuperPowerPos() {
		this.superPowerPos = (int) (Math.random() * (Calle.POSICION_META)-1) + 1;
		while(trapPos == superPowerPos){
			this.superPowerPos = (int) (Math.random() * (Calle.POSICION_META)-1) + 1;
		}
	}
}