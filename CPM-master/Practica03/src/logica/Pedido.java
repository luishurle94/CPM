package logica;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {

	private List<Articulo> articulosPedido = null;

	public Pedido() {
		articulosPedido = new ArrayList<Articulo>();
	}

	/**
	 * Añade articulos al pedido
	 * 
	 * @param articulo
	 *            Articulo que añadimos al pedido
	 * @param unidades
	 *            Número de unidades que añadimos al pedido
	 */
	public void add(Articulo articulo, int unidades) {
		Articulo articuloEnPedido = null;
		Iterator<Articulo> iterador = articulosPedido.iterator();
		// Iterador que busca el articulo en catalogo
		while (iterador.hasNext()) {
			Articulo a = iterador.next();
			if (a.getCodigo().equals(articulo.getCodigo())) {
				articuloEnPedido = a;
			}
		}

		if (articuloEnPedido == null) {
			// Si no hay unidades en el pedido, las añade sin problemas
			articulo.setUnidades(unidades);
			articulosPedido.add(articulo);
			// Si hay unidades en el pedido ya, las añade a las ya existentes
		} else {
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}

	/**
	 * Calcula el precio total del pedido sin IVA
	 * 
	 * @return precio total del pedido sin IVA
	 */
	public float calcularTotalSinIva() {
		Articulo articulo = null;
		float total = 0.0f;

		for (int i = 0; i < articulosPedido.size(); i++) {
			articulo = articulosPedido.get(i);
			if (articulo != null) {
				total += articulo.getPrecio() * articulo.getUnidades();
			}
		}
		return total;
	}

	/**
	 * Genera un archivo de texto con el pedido
	 * 
	 * @param nombreFichero
	 *            Nombre del fichero del pedido
	 */
	public void grabarPedido(String nombreFichero) {
		try {
			BufferedWriter fichero = new BufferedWriter(
					new FileWriter("files/" + nombreFichero + ".dat"));
			String linea = articulosPedido.toString();
			fichero.write(linea);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Limpia el pedido, lo borra
	 */
	public void inicializar() {
		articulosPedido.clear();
	}
}
