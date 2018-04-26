package logica;

/**
 * Clase que almacena un momento. Cada momento se compone de una fecha y una
 * hora.
 * 
 * @author UO236852
 *
 */
public class Moment {

	/**
	 * Lista de fechas para cada idioma
	 */
	private String[] date;
	/**
	 * Lista de horas para cada idioma
	 */
	private String[] hour;

	/**
	 * �ndice en las listas para el idioma espa�ol
	 */
	private static final int EN = 0;
	/**
	 * �ndice en las listas para el idioma ingl�s
	 */
	private static final int ES = 1;

	/**
	 * Constructor para la clase Momento
	 * 
	 * @param date
	 *            Fecha en formato corto
	 * @param wk
	 *            �ndice que cuenta el d�a de la semana
	 * @param hour
	 *            Hora en formato corto
	 */
	public Moment(String date, int wk, String hour) {
		String[] fechas = new String[2];
		fechas[0] = DateTime.parseDate(date, wk, "en");
		fechas[1] = DateTime.parseDate(date, wk, "es");
		String[] horas = new String[2];
		horas[0] = DateTime.parseHour(hour);
		horas[1] = DateTime.parseHour(hour);

		this.date = fechas;
		this.hour = horas;
	}

	/**
	 * M�todo que devuelve la fecha de este momento para el idioma
	 * correspondiente
	 * 
	 * @param locale
	 *            Idioma
	 * @return Fecha en ese idioma
	 */
	public String getDate(String locale) {
		if (locale.equals("es"))
			return this.date[ES];
		else if (locale.equals("en"))
			return this.date[EN];
		else
			throw new IllegalArgumentException();
	}

	/**
	 * M�todo que devuelve la hora de este momento para el idioma
	 * correspondiente
	 * 
	 * @param locale
	 *            Idioma
	 * @return Hora en ese idioma
	 */
	public String getHour(String locale) {
		if (locale.equals("es"))
			return this.hour[ES];
		else if (locale.equals("en"))
			return this.hour[EN];
		else
			throw new IllegalArgumentException();
	}

	/**
	 * M�todo que devuelve la combinaci�n 'fecha-hora' de este momento en un
	 * formato no legible para el idioma correspondiente. Nota: Puede que este
	 * m�todo no se use
	 * 
	 * @param locale
	 *            Idioma
	 * @return Combinaci�n fecha-hora no legible
	 */
	public String getMomentAsString(String locale) {
		if (locale == "es")
			return this.date[ES] + this.hour[ES];
		else if (locale == "en")
			return this.date[EN] + this.hour[EN];
		else
			throw new IllegalArgumentException();
	}
}
