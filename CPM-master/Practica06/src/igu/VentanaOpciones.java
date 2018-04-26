package igu;

import javax.swing.JDialog;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class VentanaOpciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblNmeroDerboles;
	private JSpinner spNumeroArboles;
	private VentanaPrincipal vp;
	private int numArboles;

	/**
	 * Create the dialog.
	 * 
	 * @param vp
	 */
	public VentanaOpciones(VentanaPrincipal vp) {
		this.vp = vp;
		setTitle("Opciones");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNmeroDerboles());
		getContentPane().add(getSpNumeroArboles());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getBtnCancelar());
		setBounds(100, 100, 450, 300);
		numArboles = getNumArboles();
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					spNumeroArboles.setValue(numArboles);
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
			lblNmeroDerboles.setBounds(10, 21, 299, 64);
		}
		return lblNmeroDerboles;
	}

	private JSpinner getSpNumeroArboles() {
		if (spNumeroArboles == null) {
			spNumeroArboles = new JSpinner();
			spNumeroArboles.setCursor(
					Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			spNumeroArboles.setModel(new SpinnerNumberModel(2, 0, 10, 1));
			spNumeroArboles.setForeground(Color.GREEN);
			spNumeroArboles.setFont(new Font("Jokerman", Font.PLAIN, 30));
			spNumeroArboles.setBounds(335, 35, 75, 52);
		}
		return spNumeroArboles;
	}

	public int getNumArboles() {
		return (int) spNumeroArboles.getValue();
	}

	private VentanaPrincipal getVp() {
		return vp;
	}
}
