package persistencia;

//package logica.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import logica.Alojamiento;
import logica.Entrada;
import logica.Paquete;
import logica.ParqueTematico;
import logica.TipoApartamento;

public class Lector {

	private static final String FICHERO_ALOJAMIENTO = "src/data/alojamientos.dat";
	private static final String FICHERO_ENTRADAS = "src/data/entradas.dat";
	private static final String FICHERO_PARQUE = "src/data/tematicos.dat";
	private static final String FICHERO_PAQUETE = "src/data/paquetes.dat";
	private static BufferedReader b;

	public static HashMap<String, Entrada> cargarEntradas() {
		HashMap<String, Entrada> entradas = new HashMap<String, Entrada>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_ENTRADAS));
			while (b.ready()) {
				String entrada = b.readLine();
				String[] datosEntrada = entrada.split("@");
				Entrada e = new Entrada(datosEntrada[0], datosEntrada[1], Long.parseLong(datosEntrada[2]),
						Long.parseLong(datosEntrada[3]));
				entradas.put(e.getCodigoEntrada(),e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero entradas no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return entradas;

	}

	public static HashMap<String, ParqueTematico> cargarParques() {
		HashMap<String, ParqueTematico> parques = new HashMap<String, ParqueTematico>();

		try {
			b = new BufferedReader(new FileReader(FICHERO_PARQUE));
			while (b.ready()) {
				String parque = b.readLine();
				String[] datosParque = parque.split("@");
				

				ParqueTematico p = new ParqueTematico(datosParque[0], datosParque[1], datosParque[2], datosParque[3], datosParque[4]);
				parques.put(p.getCodigoParque(), p);
			}
			HashMap<String, Entrada> entradas = cargarEntradas();

		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero parques no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return parques;

	}

	public static HashMap<String, Alojamiento> cargarAlojamiento() {
		HashMap<String, Alojamiento> alojamientos = new HashMap<String, Alojamiento>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_ALOJAMIENTO));
			while (b.ready()) {
				String alojamiento = b.readLine();
				String[] datosAlojamiento = alojamiento.split("@");
				Alojamiento a = new Alojamiento(datosAlojamiento[0], 
						TipoApartamento.valueOf(datosAlojamiento[1]),
						Integer.parseInt(datosAlojamiento[2]), 
						datosAlojamiento[3], 
						datosAlojamiento[4],
						Integer.parseInt(datosAlojamiento[5]), 
						Double.parseDouble(datosAlojamiento[6]));
				alojamientos.put(a.getCodigoAlojamiento(), a);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero alojamiento no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return alojamientos;

	}

	public static HashMap<String, Paquete> cargarPaquetes() {
		HashMap<String, Paquete> paquetes = new HashMap<String, Paquete>();
		try {
			b = new BufferedReader(new FileReader(FICHERO_PAQUETE));
			while (b.ready()) {
				String paquete = b.readLine();
				String[] datosPaquetes = paquete.split("@");
				Paquete e = new Paquete(datosPaquetes[0], datosPaquetes[1], datosPaquetes[2], datosPaquetes[3],
						Integer.parseInt(datosPaquetes[4]), Long.parseLong(datosPaquetes[5]),
						Long.parseLong(datosPaquetes[6]));
				paquetes.put(e.getCodigoPaquete(), e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo fichero paquetes no se encontro");
		} catch (IOException e) {
			new RuntimeException("Error de entrada/salida");
		}
		return paquetes;

	}
	
	

}
