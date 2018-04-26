package igu;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class VentanaCarrito extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel pnCarrito;
	private JButton btnAtras;

	private VentanaPrincipal vp;
	private JTextArea txtCarrito;
	private JLabel lblListaDeCompra;

	/**
	 * Create the dialog.
	 * 
	 * @param ventanaPrincipal
	 */
	public VentanaCarrito(VentanaPrincipal ventanaPrincipal) {
		setTitle("Cesta de la compra");
		vp = ventanaPrincipal;
		setBounds(100, 100, 523, 390);
		getContentPane().setLayout(null);
		getContentPane().add(getPnCarrito());

	}

	private JPanel getPnCarrito() {
		if (pnCarrito == null) {
			pnCarrito = new JPanel();
			pnCarrito.setBounds(0, 0, 507, 351);
			pnCarrito.setLayout(null);
			pnCarrito.add(getBtnAtras());
			pnCarrito.add(getTxtCarrito());
			pnCarrito.add(getLblListaDeCompra());
		}
		return pnCarrito;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.setMnemonic('A');
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnAtras.setBounds(408, 317, 89, 23);
		}
		return btnAtras;
	}

	private JTextArea getTxtCarrito() {
		if (txtCarrito == null) {
			txtCarrito = new JTextArea();
			txtCarrito.setEditable(false);
			txtCarrito.setText(vp.getPedido().imprimir());
			txtCarrito.setBounds(10, 38, 487, 268);
			txtCarrito.setColumns(10);
		}
		return txtCarrito;
	}

	private JLabel getLblListaDeCompra() {
		if (lblListaDeCompra == null) {
			lblListaDeCompra = new JLabel("Lista de compra:");
			lblListaDeCompra.setBounds(10, 11, 167, 23);
		}
		return lblListaDeCompra;
	}
}
