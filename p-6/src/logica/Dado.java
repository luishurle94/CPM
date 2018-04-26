package logica;

public class Dado {
	
	private static int valor;
	
	public static void lanzar (int desplazamiento)
	{
		valor = ((int) (Math.random() * desplazamiento) + 1);
	}

	public static int getValor() {
		return valor;
	}
//Depende de quien tire, la liebre puede obtener un 4
	//y la tortuga en 2 como maximo
}
