package logica;


public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;
	
	private int trapPos;
	private int tree;

	public Carrera() {
		inicializarJuego();
		setTrapPos();
		setTreePos();
		
	}

	public void inicializarJuego() {
		liebre = new Corredor(new Calle(),"liebre","liebre.jpg",4,false);
		tortuga = new Corredor(new Calle(),"tortuga","tortuga.jpg",2,true);
		// Establecemos el corredor activo. Será la tortuga ya que es la que tiene el primer turno
		setCorredorActivo();
	}

	public boolean lanzarDado() {
		boolean isPosible = false;
		Dado.lanzar(corredorActivo.getDesplazamiento());
		if (corredorActivo.getPosicion() + Dado.getValor() < Calle.DIM)
			isPosible = true;
		else {
			cambiarTurnos();
		}
		return isPosible;
		
	}

	
	private boolean isJugadaCorrecta(int i) {
		return (corredorActivo.getPosicion() + Dado.getValor() == i);
	}

	public boolean resolverJugada(int i) {
		boolean resuelta = false;
		// Comprobamos que se trata de ir a la casilla correcta
		if (isJugadaCorrecta (i)){
			corredorActivo.setPosicion(corredorActivo.getPosicion() + Dado.getValor());
			
			// Incrementamos la puntuacion del corredor
			corredorActivo.incrementaPuntuacion(corredorActivo.getCalleAsignada().puntosCasilla(corredorActivo.getPosicion()));
			// Intercambiamos los turnos
			if(getLiebre().getPosicion() == tree){
				getLiebre().setSleep(true);
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
		if(getLiebre().isSleep()){
			liebre.cambiaTurno();
			tortuga.cambiaTurno();
			setCorredorActivo();
			getLiebre().setSleep(false);
		}
	}

	private void setCorredorActivo() {
		if (liebre.getTurno()) 
			corredorActivo = liebre;
		else corredorActivo =  tortuga;
	}

	public boolean isPartidaFinalizada() {
		if(liebre.getPosicion() == Calle.POSICION_META || tortuga.getPosicion() == Calle.POSICION_META){
			return true;
		}
		if(corredorActivo.getPosicion() == trapPos && corredorActivo.isTrap()){
			return true;
		}
		return false;
	}

	public Corredor getLiebre() {
		return liebre;
	}

	public Corredor getTortuga() {
		return tortuga;
	}

	public int getTrapPos() {
		return trapPos;
	}

	public void setTrapPos() {
		this.trapPos = ((int) (Math.random() * (Calle.POSICION_META)-1) + 1);
		int corredor = ((int) (Math.random() * (Calle.POSICION_META)-1) + 1);
		if(corredor == 2 || corredor == 5 || corredor == 8 ){
			getLiebre().setTrap(true);
		}
		else{
			getTortuga().setTrap(true);
		}
			
	}

	public int getTreePos() {
		return tree;
	}

	public void setTreePos() {
		this.tree = ((int) (Math.random() * (Calle.POSICION_META)-1) + 1);
		while(trapPos == tree){
			this.tree = ((int) (Math.random() * (Calle.POSICION_META)-1)+ 1);
		}
	}
	
	
	

}