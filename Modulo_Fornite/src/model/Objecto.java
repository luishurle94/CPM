package model;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Objecto extends JPanel {
	public Objecto(String nombre, String precio, String imagen) {
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		setLayout(new BorderLayout(0, 0));
		add(getPnSur(), BorderLayout.SOUTH);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnSur;
	private JPanel pnNombre;
	private JPanel pnPrecio;
	private JButton btnVistaPrevia;
	private JPanel pnPrecioNum;
	private JButton btnComprar;
	private String precio;
	private String nombre;
	private String imagen;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	private JPanel getPnSur() {
		if (pnSur == null) {
			pnSur = new JPanel();
			pnSur.setLayout(new GridLayout(0, 1, 0, 0));
			pnSur.add(getPnNombre());
			pnSur.add(getPnPrecio());
		}
		return pnSur;
	}

	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.add(getLblNewLabel());
		}
		return pnNombre;
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.setLayout(new GridLayout(0, 3, 0, 0));
			pnPrecio.add(getBtnVistaPrevia());
			pnPrecio.add(getPnPrecioNum());
			pnPrecio.add(getBtnComprar());
		}
		return pnPrecio;
	}

	private JButton getBtnVistaPrevia() {
		if (btnVistaPrevia == null) {
			btnVistaPrevia = new JButton("VD");
		}
		return btnVistaPrevia;
	}

	private JPanel getPnPrecioNum() {
		if (pnPrecioNum == null) {
			pnPrecioNum = new JPanel();
			pnPrecioNum.add(getLblNewLabel_1());
		}
		return pnPrecioNum;
	}

	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("C");
		}
		return btnComprar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(nombre);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel(precio);
		}
		return lblNewLabel_1;
	}
}
