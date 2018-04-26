package logica;

import java.util.ArrayList;

/**
 * Clase 'Pel�cula' para el m�dulo entregable de CPM. Esta clase contiene
 * todos los datos de una pel�cula determinada
 * 
 * @author UO236852
 *
 */
public class Movie {
	/**
	 * C�digo interno de la pel�cula (no para mostrar al usuario) Nota:
	 * Puede que no se use nunca
	 */
	private String codigo;
	/**
	 * T�tulo de la pel�cula
	 */
	private String titulo;
	/**
	 * Resumen de la pel�cula
	 */
	private String sinopsis;
	/**
	 * G�nero de la pel�cula
	 */
	private String genero;
	/**
	 * Duraci�n (en minutos) de la pel�cula
	 */
	private int duracion;
	/**
	 * Edad m�nima recomendada para ver esta pel�cula (o cero para todos los
	 * p�blicos)
	 */
	private int edad;
	/**
	 * Lista de momentos en las que se puede ver esta pel�cula
	 */
	private ArrayList<Moment> momentos;
	/**
	 * Sala en la que se puede ver esta pel�cula
	 */
	private Room sala;
	/**
	 * Si la pel�cula se proyecta o no en 3D
	 */
	private boolean is3d;

	/**
	 * Constructor completo para la clase 'Pel�cula'
	 * 
	 * @param codigo
	 *            C�digo interno de la pel�cula
	 * @param titulo
	 *            T�tulo de la pel�cula
	 * @param sinopsis
	 *            Resumen de la pel�cula
	 * @param genero
	 *            G�nero de la pel�cula
	 * @param duracion
	 *            Duraci�n (en minutos) de la pel�cula
	 * @param edad
	 *            Edad m�nima recomendada (o cero para todos los p�blicos)
	 * @param fechas
	 *            Lista de fechas
	 * @param horas
	 *            Lista de horas
	 * @param sala
	 *            Sala de proyecci�n
	 * @param is3d
	 *            Si la pel�cula est� o no en 3D
	 */
	public Movie(String codigo, String titulo, String sinopsis, String genero,
			int duracion, int edad, ArrayList<Moment> momentos, Room sala,
			boolean is3d) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.duracion = duracion;
		this.edad = edad;
		this.momentos = momentos;
		this.sala = sala;
		this.is3d = is3d;
	}

	/**
	 * M�todo que crea una pel�cula a partir de una l�nea de datos le�da
	 * del fichero y la devuelve
	 * 
	 * @param line
	 *            L�nea le�da del fichero
	 * @param cine
	 *            Cine al que a�adir la pel�cula
	 * @return Pel�cula
	 */
	public static Movie parseMovie(String line, Cinema cine) {
		String[] split = line.split(";");
		/// DEBUG
		System.out.println("****** Creando nueva pel�cula ******");
		System.out.println(" C�digo: " + split[0]);
		System.out.println(" T�tulo: " + split[1]);
		System.out.println(" Sinopsis: " + split[2]);
		System.out.println(" G�nero: " + split[3]);
		System.out.println(" Duraci�n (I): " + split[4]);
		System.out.println(" Edad (I): " + split[5]);
		System.out.println(" Fechas: " + split[6]);
		System.out.println(" Horas: " + split[7]);
		System.out.println(" Sala: " + split[8]);
		System.out.println(" Formato 3D: " + split[9]);
		///
		String codigo = split[0];
		String titulo = split[1];
		String sinopsis = split[2];
		String genero = split[3];
		int duracion = Integer.valueOf(split[4]);
		System.out.println(" Duraci�n (II): " + duracion);
		int edad = parseEdad(split[5]);
		System.out.println(" Edad (II): " + edad);

		String[] dates = split[6].split("%");
		String[] hours = split[7].split("%");

		String room = split[8];
		Room sala = null;
		for (Room r : cine.getSalas())
			if (r.toString() == room) {
				System.out.println(" Asignando a la sala: " + r);
				sala = r;
			}

		ArrayList<Moment> momentos = new ArrayList<Moment>();
		int wwk = 0;
		for (String f : dates) {
			for (String h : hours)
				momentos.add(new Moment(f, wwk, h));
			wwk++;
		}

		if (sala == null) {
			Room rooom = new Room(room, momentos.toArray(new Moment[0]));
			System.out.println(" Creando nueva sala: " + rooom);
			sala = rooom;
			cine.addSala(rooom);
		}

		String formato = split[9];
		boolean is3d;
		if (formato.contains("S"))
			is3d = true;
		else
			is3d = false;
		System.out.println(" Es 3D?: " + is3d);

		return new Movie(codigo, titulo, sinopsis, genero, duracion, edad,
				momentos, sala, is3d);
	}

	/**
	 * M�todo que convierte la edad recomendada en formato '+16' o 'Todos los
	 * p�blicos' a formato '16' o '0', respectivamente
	 * 
	 * @param edad
	 *            Edad le�da del fichero
	 * @return Edad recomendada sin caracteres extra�os, o cero para todos los
	 *         p�blicos
	 */
	private static int parseEdad(String edad) {
		try {
			Integer.valueOf(edad);
		} catch (NumberFormatException e) {
			return 0;
		}
		return Integer.valueOf(edad);
	}

	/**
	 * M�todo que devuelve un vector de cadenas con los detalles de la
	 * pel�cula para mostrar en la pantalla de selecci�n de pel�cula. El
	 * vector contiene, por este orden, t�tulo, g�nero, edad recomendada,
	 * duraci�n y formato.
	 * 
	 * @return Vector con detalles de la pel�cula
	 */
	public String getDetailsForScreen1(String locale) {
		ArrayList<String> detalles = new ArrayList<String>();
		if (locale.equals("es")) {
			detalles.add("T�tulo: " + this.titulo);
			detalles.add("G�nero: " + this.genero);
			if (this.edad > 0)
				detalles.add("Edad recomendada: " + String.valueOf(this.edad)
						+ " a�os o m�s");
			else
				detalles.add("Edad recomendada: Todos los p�blicos");
			detalles.add("Duraci�n: " + String.valueOf(this.duracion)
					+ " minutos");
			if (this.is3d)
				detalles.add("Formato: 3D");
			else
				detalles.add("Formato: 2D");
		} else if (locale.equals("en")) {
			detalles.add("Title: " + this.titulo);
			detalles.add("Genre: " + this.genero);
			if (this.edad > 0)
				detalles.add("Suggested age: " + String.valueOf(this.edad)
						+ " years at least");
			else
				detalles.add("Suggested age: Anyone");
			detalles.add(
					"Duration: " + String.valueOf(this.duracion) + " minutes");
			if (this.is3d)
				detalles.add("Format: 3D");
			else
				detalles.add("Format: 2D");
		}

		String result = "";
		for (String st : detalles)
			result += st + "\n";

		return result;
	}

	/**
	 * M�todo que devuelve el resumen de la pel�cula
	 * 
	 * @return Resumen de la pel�cula
	 */
	public String getSinopsis(String locale) {
		if (locale.equals("es"))
			return ("Resumen: " + this.sinopsis);
		else
			return ("Summary: " + this.sinopsis);
	}

	public boolean is3d() {
		return is3d;
	}

	/**
	 * M�todo que devuelve la sala en la que se proyecta esta pel�cula
	 * 
	 * @return Sala de esta pel�cula
	 */
	public Room getSala() {
		return this.sala;
	}

	/**
	 * M�todo que devuelve un vector de cadenas con las fechas de proyecci�n
	 * de la pel�cula
	 * 
	 * @return Vector con fechas
	 */
	public String[] getFechas(String locale) {
		ArrayList<String> fechas = new ArrayList<String>();
		for (Moment m : this.momentos)
			if (!fechas.contains(m.getDate(locale)))
				fechas.add(m.getDate(locale));
		return fechas.toArray(new String[0]);
	}

	/**
	 * M�todo que devuelve un vector de cadenas con las horas de proyecci�n
	 * de la pel�cula
	 * 
	 * @return Vector con horas
	 */
	public String[] getHoras(String locale) {
		ArrayList<String> horas = new ArrayList<String>();
		for (Moment m : this.momentos)
			if (!horas.contains(m.getHour(locale)))
				horas.add(m.getHour(locale));
		return horas.toArray(new String[0]);
	}

	public Moment[] getMomentos() {
		return this.momentos.toArray(new Moment[0]);
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	@Override
	public String toString() {
		String formato = "";
		if (this.is3d)
			formato = " (3D)";
		else
			formato = " (2D)";
		return (this.titulo + formato);
	}
}
