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
	 * Índice en las listas para el idioma español
	 */
	private static final int EN = 0;
	/**
	 * Índice en las listas para el idioma inglés
	 */
	private static final int ES = 1;

	/**
	 * Constructor para la clase Momento
	 * 
	 * @param date
	 *            Fecha en formato corto
	 * @param wk
	 *            Índice que cuenta el día de la semana
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
	 * Método que devuelve la fecha de este momento para el idioma
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
	 * Método que devuelve la hora de este momento para el idioma
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
	 * Método que devuelve la combinación 'fecha-hora' de este momento en un
	 * formato no legible para el idioma correspondiente. Nota: Puede que este
	 * método no se use
	 * 
	 * @param locale
	 *            Idioma
	 * @return Combinación fecha-hora no legible
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
