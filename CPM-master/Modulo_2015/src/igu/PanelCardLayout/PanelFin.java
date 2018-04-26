package igu.PanelCardLayout;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import igu.VentanaPrincipal;
import igu.PanelesAuxiliares.PanelImagenRedimensionable;

public class PanelFin extends JPanel {

	private static final long serialVersionUID = 707274369724195168L;
	private VentanaPrincipal vp;
	private JPanel pnMensajeFin;
	private PanelImagenRedimensionable pnImagenFin;
	private JPanel pnMensaje1;
	private JPanel pnMensaje2;
	private JPanel pnMensaje3;
	private JLabel lblMensaje1;
	private JLabel lblMensaje2;
	private JLabel lblMensaje3;
	private JPanel pnFinalizar;
	private JButton btnFinalizar;

	public PanelFin(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new GridLayout(2, 0, 0, 0));
		this.add(getPnImagenFin());
		this.add(getPnMensajeFin());
	}

	private JPanel getPnMensajeFin() {
		if (pnMensajeFin == null) {
			pnMensajeFin = new JPanel();
			pnMensajeFin.setLayout(new GridLayout(4, 0, 0, 0));
			pnMensajeFin.add(getPnMensaje1());
			pnMensajeFin.add(getPnMensaje2());
			pnMensajeFin.add(getPnMensaje3());
			pnMensajeFin.add(getPnFinalizar());
		}
		return pnMensajeFin;
	}

	private PanelImagenRedimensionable getPnImagenFin() {
		if (pnImagenFin == null) {
			pnImagenFin = new PanelImagenRedimensionable("Fin");
		}
		return pnImagenFin;
	}

	private JPanel getPnMensaje1() {
		if (pnMensaje1 == null) {
			pnMensaje1 = new JPanel();
			pnMensaje1.add(getLblMensaje1());
		}
		return pnMensaje1;
	}

	private JPanel getPnMensaje2() {
		if (pnMensaje2 == null) {
			pnMensaje2 = new JPanel();
			pnMensaje2.add(getLblMensaje2());
		}
		return pnMensaje2;
	}

	private JPanel getPnMensaje3() {
		if (pnMensaje3 == null) {
			pnMensaje3 = new JPanel();
			pnMensaje3.add(getLblMensaje3());
		}
		return pnMensaje3;
	}

	private JLabel getLblMensaje1() {
		if (lblMensaje1 == null) {
			lblMensaje1 = new JLabel(
					"Su reserva se ha realizado correctamente.");
			lblMensaje1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		}
		return lblMensaje1;
	}

	private JLabel getLblMensaje2() {
		if (lblMensaje2 == null) {
			lblMensaje2 = new JLabel("Gracias por su compra.");
			lblMensaje2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		}
		return lblMensaje2;
	}

	private JLabel getLblMensaje3() {
		if (lblMensaje3 == null) {
			lblMensaje3 = new JLabel("Disfrute de su viaje.");
			lblMensaje3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		}
		return lblMensaje3;
	}

	private JPanel getPnFinalizar() {
		if (pnFinalizar == null) {
			pnFinalizar = new JPanel();
			pnFinalizar.add(getBtnFinalizar());
		}
		return pnFinalizar;
	}

	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.setToolTipText(
					"Finaliza la reserva y vuelve a la pantalla de inicio");
			btnFinalizar.setMnemonic('F');
			btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vp.inicializar();
					// getBtnComenzar().grabFocus();
				}
			});
		}
		return btnFinalizar;
	}

}
