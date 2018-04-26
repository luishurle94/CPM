package igu.PanelCardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import igu.VentanaPrincipal;

public class PanelResumen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7743075418381115341L;
	private VentanaPrincipal vp;
	private JLabel lblResumenDeLa;
	private JButton btnCancelarResumen;
	private JButton btnConfrimarResumen;
	private JButton btnAtrasResumen;
	private JPanel pnBotonesResumen;
	private JPanel pnDatosResumen;
	private JPanel pnTituloResumen;
	private JLabel lblEspacioResumen1;
	private JLabel lblEspacioResumen2;
	private JScrollPane scResumen;
	private JTextArea txtAreaReserva;

	public PanelResumen(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnTituloResumen(), BorderLayout.NORTH);
		this.add(getPnDatosResumen(), BorderLayout.CENTER);
		this.add(getPnBotonesResumen(), BorderLayout.SOUTH);
		this.add(getLblEspacioResumen1(), BorderLayout.WEST);
		this.add(getLblEspacioResumen2(), BorderLayout.EAST);
	}

	private JPanel getPnTituloResumen() {
		if (pnTituloResumen == null) {
			pnTituloResumen = new JPanel();
			pnTituloResumen.add(getLblResumenDeLa());
		}
		return pnTituloResumen;
	}

	private JPanel getPnDatosResumen() {
		if (pnDatosResumen == null) {
			pnDatosResumen = new JPanel();
			pnDatosResumen.setLayout(new BorderLayout(0, 0));
			pnDatosResumen.add(getScResumen(), BorderLayout.CENTER);
		}
		return pnDatosResumen;
	}

	private JScrollPane getScResumen() {
		if (scResumen == null) {
			scResumen = new JScrollPane();
			scResumen.setViewportView(getTxtAreaReserva());
		}
		return scResumen;
	}

	private JTextArea getTxtAreaReserva() {
		if (txtAreaReserva == null) {
			txtAreaReserva = new JTextArea();
			txtAreaReserva.setEditable(false);
			txtAreaReserva.setLineWrap(true);
			txtAreaReserva.setWrapStyleWord(true);
			txtAreaReserva.setFont(new Font("Monospaced", Font.PLAIN, 14));
		}
		return txtAreaReserva;
	}

	private JPanel getPnBotonesResumen() {
		if (pnBotonesResumen == null) {
			pnBotonesResumen = new JPanel();
			pnBotonesResumen.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnBotonesResumen.add(getBtnAtrasResumen());
			pnBotonesResumen.add(getBtnConfrimarResumen());
			pnBotonesResumen.add(getBtnCancelarResumen());
		}
		return pnBotonesResumen;
	}

	private JButton getBtnAtrasResumen() {
		if (btnAtrasResumen == null) {
			btnAtrasResumen = new JButton("Atras");
			btnAtrasResumen.setToolTipText(
					"Vuelve a la venta de modificaci\u00F3n de la lista de camarotes");
			btnAtrasResumen.setMnemonic('A');
			btnAtrasResumen.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAtrasResumen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout) vp.getPnReservas().getLayout())
							.previous(vp.getPnReservas());
				}
			});
		}
		return btnAtrasResumen;
	}

	public JButton getBtnConfrimarResumen() {
		if (btnConfrimarResumen == null) {
			btnConfrimarResumen = new JButton("Confirmar");
			btnConfrimarResumen.setToolTipText("Confirma la reserva");
			btnConfrimarResumen.setMnemonic('C');
			btnConfrimarResumen.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnConfrimarResumen.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					Calendar a = Calendar.getInstance();
					String fecha = a.getTime().getDate() + "_"
							+ (a.getTime().getMonth() + 1) + "_"
							+ (a.getTime().getYear() + 1900);
					vp.grabarReserva(vp.getCliente().getDni() + "_" + fecha);
					((CardLayout) vp.getPnReservas().getLayout())
							.next(vp.getPnReservas());
					// getBtnFinalizar().grabFocus();
				}
			});
		}
		return btnConfrimarResumen;
	}

	private JButton getBtnCancelarResumen() {
		if (btnCancelarResumen == null) {
			btnCancelarResumen = new JButton("Cancelar");
			btnCancelarResumen.setToolTipText(
					"Borra todos los datos vuelve a la pantalla de inicio");
			btnCancelarResumen.setMnemonic('C');
			btnCancelarResumen.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelarResumen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vp.inicializar();
				}
			});
		}
		return btnCancelarResumen;
	}

	private JLabel getLblResumenDeLa() {
		if (lblResumenDeLa == null) {
			lblResumenDeLa = new JLabel("Resumen de la Reserva");
			lblResumenDeLa.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblResumenDeLa;
	}

	private JLabel getLblEspacioResumen1() {
		if (lblEspacioResumen1 == null) {
			lblEspacioResumen1 = new JLabel("                           ");
		}
		return lblEspacioResumen1;
	}

	private JLabel getLblEspacioResumen2() {
		if (lblEspacioResumen2 == null) {
			lblEspacioResumen2 = new JLabel("                           ");
		}
		return lblEspacioResumen2;
	}

}
