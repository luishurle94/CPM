package igu.PanelCardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import igu.VentanaPrincipal;
import logica.Crucero;

public class PanelInicio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 84311989366082990L;
	private VentanaPrincipal vp;
	private JPanel pnBienvenido;
	private JPanel pnComenzar;
	private JLabel lblBienvenido;
	private JButton btnComenzar;

	public PanelInicio(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnBienvenido(), BorderLayout.NORTH);
		this.add(getPnComenzar(), BorderLayout.SOUTH);
	}

	private JPanel getPnBienvenido() {
		if (pnBienvenido == null) {
			pnBienvenido = new JPanel();
			pnBienvenido.add(getLblBienvenido());
		}
		return pnBienvenido;
	}

	private JPanel getPnComenzar() {
		if (pnComenzar == null) {
			pnComenzar = new JPanel();
			pnComenzar.add(getBtnComenzar());
		}
		return pnComenzar;
	}

	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido");
			lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 99));
		}
		return lblBienvenido;
	}

	public JButton getBtnComenzar() {
		if (btnComenzar == null) {
			btnComenzar = new JButton("Comenzar");
			btnComenzar.setToolTipText("Pulsa para comenzar con la reserva");
			btnComenzar.setMnemonic('C');
			btnComenzar.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnComenzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout) vp.getPnReservas().getLayout())
							.next(vp.getPnReservas());
					int contador = 0;
					for (Crucero crucero : vp.getCatalogo().getCruceros())
						if (crucero.isDescuento())
							contador++;
					String[] crucerosConDescuento = new String[contador];
					contador = 0;
					for (Crucero crucero : vp.getCatalogo().getCruceros())
						if (crucero.isDescuento()) {
							crucerosConDescuento[contador] = "Zona: "
									+ crucero.getZona() + "; Puerto de salida: "
									+ crucero.getPuertoSalida()
									+ "; Itinerario:" + crucero.getItinerario();
							contador++;
						}
					String aux = "OFERTAS EN CRUCEROS\n";
					aux += "Los siguiente cruceros tienen un descuento del 15%:\n";
					for (int i = 0; i < crucerosConDescuento.length; i++) {
						aux += "\t- " + crucerosConDescuento[i] + "\n";
					}
					JOptionPane.showMessageDialog(null, aux);
				}
			});
		}
		return btnComenzar;
	}

}
