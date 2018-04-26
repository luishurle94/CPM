package logica;
import java.io.*;
import java.util.*;

public class Pedido {
	
	private List<Articulo> articulosPedido = null;
	private int codigo;
	
	public Pedido(){
		articulosPedido = new ArrayList<Articulo>();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public void add(Articulo articulo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : articulosPedido){
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			articulo.setUnidades(unidades);
			articulosPedido.add(articulo);
		}
		else{
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}
	
	public float calcularTotalSinIva(){ //15 % de descuento cada de 10 unidades del mismo articulo getPrecio*0.85.getUnidades
		float total = 0.0f;
		for (Articulo a : articulosPedido){
			if(a.getUnidades() > 10){
				total += a.getPrecio()*0.85*a.getUnidades();
			}
			total += a.getPrecio()* a.getUnidades();
		}
		return total;
	}
	
	public void grabarPedido(String nombreFichero){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFichero + ".dat"));
		        String linea = articulosPedido.toString();
		        fichero.write(linea);
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	  }
	
	public String generarCodigo()
	{
		String codigo = "";
		String base = "0123456789abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int longitudCodigo = 10;
		for (int i = 0; i < longitudCodigo; i++){
			int numero = (int)(Math.random()*(base.length()));
			codigo += base.charAt(numero);}
		return codigo;
	}

	public void inicializar(){
		for(Articulo a: articulosPedido){
			a.setUnidades(0);
		}
		articulosPedido.clear();
	}
	
	public void elimina(Articulo articulo, int unidades){
	Articulo articuloenpedido = null;
	for(Articulo a: articulosPedido){
		if(a.getCodigo().equals(articulo.getCodigo()))
			articuloenpedido = a;
	}
	
	if(articuloenpedido != null && articuloenpedido.getUnidades() >= unidades){
		int totalunidades = articuloenpedido.getUnidades() - unidades;
		if(totalunidades == 0){
			articuloenpedido.setUnidades(0);
			articulospedido.remove(articuloenpedido);
		}
		else
			articuloenpedido.setUnidades(totalunidades);
	}
		
		
		
		//si las unidades son 0, ponemos las unidades a 0
	}
}

