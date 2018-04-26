package logica;

import java.util.Random;

public class Carrera {

	private Corredor liebre;
	private Corredor tortuga;
	private Corredor corredorActivo;	
	private int PosTrampa;	
	private int PosPoder;
	
	private int[] arbol;
	private int numArboles;
	
	private boolean superPoder;

	public Carrera(int dimCalle, int nTrees) {
		inicializarJuego(dimCalle, nTrees);
		
	}

	public void inicializarJuego(int dim, int arboles) {
		liebre = new Corredor(new Calle(dim),"liebre","liebre.jpg",4,false);
		tortuga = new Corredor(new Calle(dim),"tortuga","tortuga.jpg",2,true);
		numArboles = arboles;
		setPosTrampa();
		setSuperPowerPos();
		setPosArbol();
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
		if (isJugadaCorrecta (i)){
			corredorActivo.setPosicion(corredorActivo.getPosicion() + Dado.getValor());
			corredorActivo.incrementaPuntuacion(corredorActivo.getCalleAsignada().puntosCasilla(corredorActivo.getPosicion()));
			if(existTree(liebre.getPosicion())){
				liebre.setDormido(true);
			}
			cambiarTurnos();
			superPower();
			resuelta = true;
		}
		return resuelta;
	}

	public Corredor getCorredorActivo() {
		return corredorActivo;
	}
	
	private void cambiarTurnos() {
		if(perderTurno() == false){
			liebre.cambiaTurno();
			tortuga.cambiaTurno();
			setCorredorActivo();
		}else{
			liebre.setDormido(false);
		}
	}
	
	private boolean perderTurno(){
		if(liebre.isDormido()){
			return true;
		}else{
			return false;
		}
	}

	private void setCorredorActivo() {
		if (liebre.getTurno()){	
			corredorActivo = liebre;
			
		}
		
		else corredorActivo =  tortuga;
	}

	public boolean isPartidaFinalizada() {
		if(liebre.getPosicion() == Calle.POSICION_META || tortuga.getPosicion() == Calle.POSICION_META){
			return true;
		}
		if(liebre.getPosicion() == PosTrampa && liebre.isTrampa() && !liebre.isSP()){
			return true;
		}
		if(tortuga.getPosicion() == PosTrampa && tortuga.isTrampa() && !tortuga.isSP()){
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

	public int getPosTrampa() {
		return PosTrampa;
	}

	public void setPosTrampa() {
		this.PosTrampa = ((int) (Math.random() * (Calle.POSICION_META)-1) + 1);
		Random r = new Random();
		boolean B = r.nextBoolean();
		if(B == false){
			getLiebre().setTrampa(true);
		}
		else{
			getTortuga().setTrampa(true);
		}
		System.out.println("trampa"+ PosTrampa);
			
	}

	public int getPosArbol(int i) {
		return arbol[i];
	}

	public void setPosArbol() {
		arbol = new int[numArboles];
		for(int i = 0; i<numArboles;i++){
			int n = ((int) (Math.random() * (Calle.POSICION_META-1) + 1));
			if(i == 0){
				while(n == PosTrampa || n == PosPoder)
				{n = ((int) (Math.random() * (Calle.POSICION_META-1) + 1));}
			}else{
				while(n == PosTrampa || n == PosPoder || existTree(n)){n = ((int) (Math.random() * (Calle.POSICION_META-1) + 1));}
			}
			arbol[i] = n;
			System.out.println("arbol"+n);
		}
	}
	
	public boolean existTree(int n){
		for(int i = 0; i<numArboles;i++){
			if(n == arbol[i]){
				return true;
			}
		}
		return false;
		
	}

	public int getNumArboles() {
		return numArboles;
	}

	public void setNumTrees(int numTrees) {
		this.numArboles = numTrees;
	}
	public void superPower(){
		if(corredorActivo.getPosicion() == PosPoder && corredorActivo.isSP()){
			superPoder = true;
			corredorActivo.incrementaPuntuacion(500);
		}
		if(corredorActivo.getPosicion() == PosTrampa && corredorActivo.isSP()){
			superPoder = true;
			liebre.incrementaPuntuacion(1000);
		}
	}
	
	public int getSuperPowerPos() {
		return PosPoder;
	}
	
	public void setSuperPowerPos() {
		this.PosPoder = (int) (Math.random() * (Calle.POSICION_META)-1) + 1;
		while(PosTrampa == PosPoder){
			this.PosPoder = (int) (Math.random() * (Calle.POSICION_META)-1) + 1;
		}
		Random r = new Random();
		boolean B = r.nextBoolean();
		if(B == false){
			getLiebre().setSP(true);
		}
		else{
			getTortuga().setSP(true);
		}
		System.out.println("SP"+superPoder);
	}
	
	public boolean getSuperPower(){
		return this.superPoder;
	}
	public void sp(){
		this.superPoder = false;
	}
}
	