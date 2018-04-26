package logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pasajero {
	private String nombre;
	private String apellidos;
	private String dni;
	private String fechaNacimiento;
	private boolean menor;
	private String observaciones;

	public Pasajero(String nombre, String apellidos, String dni,
			String fechaNacimiento, String observaciones) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		if (calcularEdad(fechaNacimiento) >= 16
				|| calcularEdad(fechaNacimiento) < 0)
			menor = false;
		else
			menor = true;
		this.observaciones = observaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String toString() {
		return getNombre() + " | " + getApellidos() + " | " + getDni();
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isMenor() {
		return menor;
	}

	public void setMenor(boolean menor) {
		this.menor = menor;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public static int calcularEdad(String fecha) {
		String datetext = fecha;
		try {
			Calendar birth = new GregorianCalendar();
			Calendar today = new GregorianCalendar();
			int age = 0;
			int factor = 0;
			Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(datetext);
			Date currentDate = new Date();
			birth.setTime(birthDate);
			today.setTime(currentDate);
			if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
					if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
						factor = -1;
					}
				} else {
					factor = -1;
				}
			}
			age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR))
					+ factor;
			return age;
		} catch (ParseException e) {
			return -1;
		}
	}

}
