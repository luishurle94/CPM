package igu;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblCheck;
	private JLabel lblEstamosProcesandoSu;
	private JLabel lblElCdigoDe;
	private JTextField txtCodigo;
	private JButton btnFinalizar;

	/**
	 * Create the dialog.
	 * 
	 * @param vR
	 */
	public VentanaConfirmacion(VentanaRegistro vR) {
		getContentPane().setBackground(Color.WHITE);
		setTitle("PC accesorios: Venta de confirmacion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblCheck());
		getContentPane().add(getLblEstamosProcesandoSu());
		getContentPane().add(getLblElCdigoDe());
		getContentPane().add(getTxtCodigo());
		getContentPane().add(getBtnFinalizar());

	}

	private JLabel getLblCheck() {
		if (lblCheck == null) {
			lblCheck = new JLabel("");
			lblCheck.setBackground(Color.WHITE);
			lblCheck.setIcon(new ImageIcon(
					VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblCheck.setBounds(33, 63, 50, 67);
		}
		return lblCheck;
	}

	private JLabel getLblEstamosProcesandoSu() {
		if (lblEstamosProcesandoSu == null) {
			lblEstamosProcesandoSu = new JLabel("Estamos procesando su pedido");
			lblEstamosProcesandoSu.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEstamosProcesandoSu.setBounds(114, 67, 239, 39);
		}
		return lblEstamosProcesandoSu;
	}

	private JLabel getLblElCdigoDe() {
		if (lblElCdigoDe == null) {
			lblElCdigoDe = new JLabel("El c\u00F3digo de recogida es:");
			lblElCdigoDe.setBounds(114, 117, 161, 22);
		}
		return lblElCdigoDe;
	}

	private JTextField getTxtCodigo() {
		if (txtCodigo == null) {
			txtCodigo = new JTextField();
			txtCodigo.setBackground(Color.WHITE);
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(285, 117, 118, 22);
			txtCodigo.setColumns(10);
			txtCodigo.setText(generarCodigo());
		}
		return txtCodigo;
	}

	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnFinalizar.setBounds(335, 228, 89, 23);
		}
		return btnFinalizar;
	}

	private String generarCodigo() {
		String codigo = "";
		String base = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		int longitudCodigo = 10;
		for (int i = 0; i < longitudCodigo; i++) {
			int numero = (int) (Math.random() * (base.length()));
			codigo += base.charAt(numero);
		}
		return codigo;
	}
}
