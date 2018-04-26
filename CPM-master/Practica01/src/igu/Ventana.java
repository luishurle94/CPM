package igu;

import java.awt.Color;

import javax.swing.*;

public class Ventana extends JFrame { // Ventana principal
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal; // Panel principal
	private JButton btAceptar; // Boton aceptar
	private JButton btCancelar; // Boton cancelar
	private JLabel lbNombre; // Etiqueta
	private JTextField tfNombre; // Campo para introducir el nombre

	public Ventana() {
		this.setTitle("Primera ventana CPM");
		this.setBounds(100, 100, 450, 300); // Posicion x, posicion y, ancho,
											// alto

		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.white); // Establece color de fondo
		this.setContentPane(pnPrincipal); // Establece el contenido de la
											// ventana
		getContentPane().setLayout(null); // Desactiva la colocacion automatica
											// de objetos
		this.setLocationRelativeTo(null);

		btAceptar = new JButton();
		btAceptar.setText("Aceptar");
		btAceptar.setBounds(160, 220, 100, 30);
		btAceptar.setBackground(Color.black);
		btAceptar.setForeground(Color.BLACK); // Establece color de texto

		btCancelar = new JButton();
		btCancelar.setText("Cancelar");
		btCancelar.setBounds(270, 220, 100, 30);
		btCancelar.setBackground(Color.black);
		btCancelar.setForeground(Color.BLACK); // Establece color de texto

		lbNombre = new JLabel();
		lbNombre.setText("Introduzca su nombre:");
		lbNombre.setBounds(20, 63, 300, 10);

		tfNombre = new JTextField();
		tfNombre.setBounds(200, 60, 150, 20);

		pnPrincipal.add(btAceptar);
		pnPrincipal.add(btCancelar);
		pnPrincipal.add(lbNombre);
		pnPrincipal.add(tfNombre);

		this.setVisible(true); // Ponerlo siempre el ultimo o en el main

	}

	public static void main(String[] args) {
		// Primero inicializarlo todo
		@SuppressWarnings("unused")
		Ventana ventana = new Ventana();
	}

}
