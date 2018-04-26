package logica;

/**
 * Clase est�tica que controla todas las operaciones con fechas y horas
 * 
 * @author UO236852
 *
 */
public final class DateTime {

	/**
	 * La clase DateTime no puede ser instanciada
	 */
	private DateTime() {
	}

	/**
	 * M�todo que convierte una fecha en formato 'DD/MM/YYYY' (le�da desde el
	 * fichero) a formato 'dddd, DD de MM', o 'dddd, MM DDth', presuponiendo que
	 * wk=0 es viernes (ver requisitos)
	 * 
	 * @param date
	 *            Fecha con formato corto
	 * @param wk
	 *            �ndice de lectura, que determina el d�a de la semana
	 * @return Fecha con formato largo
	 */
	public static String parseDate(String date, int wk, String locale) {
		StringBuilder sb = new StringBuilder();
		String[] split = date.split("/");
		// Si se proyecta durante m�s de una semana, volver a empezar por
		// viernes
		while (wk > 6)
			wk -= 6;
		// �En qu� d�a estamos? (Versi�n espa�ola)
		if (locale.equals("es")) {
			switch (wk) {
			case 0:
				sb.append("Viernes, ");
				break;
			case 1:
				sb.append("S�bado, ");
				break;
			case 2:
				sb.append("Domingo, ");
				break;
			case 3:
				sb.append("Lunes, ");
				break;
			case 4:
				sb.append("Martes, ");
				break;
			case 5:
				sb.append("Mi�rcoles, ");
				break;
			case 6:
				sb.append("Jueves, ");
				break;
			}
			// Versi�n inglesa
		} else if (locale.equals("en")) {
			switch (wk) {
			case 0:
				sb.append("Friday, ");
				break;
			case 1:
				sb.append("Saturday, ");
				break;
			case 2:
				sb.append("Sunday, ");
				break;
			case 3:
				sb.append("Monday, ");
				break;
			case 4:
				sb.append("Tuesday, ");
				break;
			case 5:
				sb.append("Wednesday, ");
				break;
			case 6:
				sb.append("Thursday, ");
				break;
			}
		}
		if (locale.equals("es")) {
			// Dar formato al d�a, quitando el cero de delante si es menor que
			// diez
			Integer day = Integer.valueOf(split[0]);
			sb.append(String.valueOf(day));
			// �En qu� mes estamos? (Versi�n espa�ola)
			switch (Integer.valueOf(split[1])) {
			case 1:
				sb.append(" de Enero");
				break;
			case 2:
				sb.append(" de Febrero");
				break;
			case 3:
				sb.append(" de Marzo");
				break;
			case 4:
				sb.append(" de Abril");
				break;
			case 5:
				sb.append(" de Mayo");
				break;
			case 6:
				sb.append(" de Junio");
				break;
			case 7:
				sb.append(" de Julio");
				break;
			case 8:
				sb.append(" de Agosto");
				break;
			case 9:
				sb.append(" de Septiembre");
				break;
			case 10:
				sb.append(" de Octubre");
				break;
			case 11:
				sb.append(" de Noviembre");
				break;
			case 12:
				sb.append(" de Diciembre");
				break;
			}
		} else if (locale.equals("en")) {
			// �En qu� mes estamos? (Versi�n inglesa)
			switch (Integer.valueOf(split[1])) {
			case 1:
				sb.append("January ");
				break;
			case 2:
				sb.append("February ");
				break;
			case 3:
				sb.append("March ");
				break;
			case 4:
				sb.append("April ");
				break;
			case 5:
				sb.append("May ");
				break;
			case 6:
				sb.append("June ");
				break;
			case 7:
				sb.append("July ");
				break;
			case 8:
				sb.append("August ");
				break;
			case 9:
				sb.append("September ");
				break;
			case 10:
				sb.append("October ");
				break;
			case 11:
				sb.append("November ");
				break;
			case 12:
				sb.append("December ");
				break;
			}
			// Dar formato al d�a, quitando el cero de delante si es menor que
			// diez (Los ingleses ponen el d�a despu�s del mes)
			Integer day = Integer.valueOf(split[0]);
			sb.append(String.valueOf(day));
			switch (day.intValue() % 10) {
			case 1:
				sb.append("st");
				break;
			case 2:
				sb.append("nd");
				break;
			case 3:
				sb.append("rd");
				break;
			default:
				sb.append("th");
				break;
			}
		}
		return sb.toString();
	}

	/**
	 * M�todo que pone guapa la hora para ense�arla en la interfaz
	 * 
	 * @param hour
	 *            Hora cutre le�da del fichero
	 * @return Hora divina de la muerte
	 */
	public static String parseHour(String hour) {
		return hour + " h";
	}
}
