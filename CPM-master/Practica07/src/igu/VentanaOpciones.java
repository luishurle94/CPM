package igu;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.JSpinner;

import java.awt.event.*;
import java.awt.Cursor;
import java.awt.Toolkit;

public class VentanaOpciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblNmeroDerboles;
	private JSpinner spNumeroArboles;
	private VentanaPrincipal vp;
	private int numArboles;
	private int numCasillas;
	private JLabel lblNumeroCasillas;
	private JSpinner spNumeroCasillas;

	/**
	 * Create the dialog.
	 * 
	 * @param vp
	 */
	public VentanaOpciones(VentanaPrincipal vp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaOpciones.class.getResource("/img/liebre_peq.jpg")));
		this.vp = vp;
		setTitle("Opciones");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNmeroDerboles());
		getContentPane().add(getSpNumeroArboles());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getBtnCancelar());
		getContentPane().add(getLblNumeroCasillas());
		getContentPane().add(getSpNumeroCasillas());
		setBounds(100, 100, 450, 300);
		numArboles = getNumArboles();
		numCasillas = getNumCasillas();
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					spNumeroArboles.setValue(numArboles);
					spNumeroCasillas.setValue(numCasillas);
					dispose();
				}
			});
			btnCancelar.setBounds(335, 227, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setMnemonic('A');
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numArboles = getNumArboles();
					numCasillas = getNumCasillas();
					getVp().inicializar();
					dispose();
				}
			});
			btnAceptar.setBounds(236, 227, 89, 23);
		}
		return btnAceptar;
	}

	private JLabel getLblNmeroDerboles() {
		if (lblNmeroDerboles == null) {
			lblNmeroDerboles = new JLabel("N\u00FAmero de \u00E1rboles");
			lblNmeroDerboles.setFont(new Font("Jokerman", Font.PLAIN, 30));
			lblNmeroDerboles.setForeground(Color.YELLOW);
			lblNmeroDerboles.setBounds(10, 35, 299, 64);
		}
		return lblNmeroDerboles;
	}

	private JSpinner getSpNumeroArboles() {
		if (spNumeroArboles == null) {
			spNumeroArboles = new JSpinner();
			spNumeroArboles.setCursor(
					Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			spNumeroArboles.setModel(new SpinnerNumberModel(2, 0, 9, 1));
			spNumeroArboles.setForeground(Color.GREEN);
			spNumeroArboles.setFont(new Font("Jokerman", Font.PLAIN, 30));
			spNumeroArboles.setBounds(335, 35, 75, 52);
		}
		return spNumeroArboles;
	}

	public int getNumArboles() {
		return (int) spNumeroArboles.getValue();
	}

	public int getNumCasillas() {
		return (int) spNumeroCasillas.getValue();
	}

	private VentanaPrincipal getVp() {
		return vp;
	}

	private JLabel getLblNumeroCasillas() {
		if (lblNumeroCasillas == null) {
			lblNumeroCasillas = new JLabel("N\u00FAmero de casillas");
			lblNumeroCasillas.setForeground(Color.YELLOW);
			lblNumeroCasillas.setFont(new Font("Jokerman", Font.PLAIN, 30));
			lblNumeroCasillas.setBounds(10, 143, 299, 64);
		}
		return lblNumeroCasillas;
	}

	private JSpinner getSpNumeroCasillas() {
		if (spNumeroCasillas == null) {
			spNumeroCasillas = new JSpinner();
			spNumeroCasillas.setModel(new SpinnerNumberModel(10, 10, 14, 1));
			spNumeroCasillas.setFont(new Font("Jokerman", Font.PLAIN, 30));
			spNumeroCasillas.setBounds(335, 143, 75, 52);
		}
		return spNumeroCasillas;
	}
}
