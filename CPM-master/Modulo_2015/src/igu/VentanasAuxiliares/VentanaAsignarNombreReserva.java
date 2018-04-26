package igu.VentanasAuxiliares;

import igu.VentanaPrincipal;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import logica.Pasajero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.io.File;
import java.net.URL;

import javax.swing.SwingConstants;

public class VentanaAsignarNombreReserva extends JDialog {

	private VentanaPrincipal vp;
	private static final long serialVersionUID = -8039785068955588960L;
	private JPanel pnPrincipal;
	private JPanel pnTitulo;
	private JPanel pnBotones;
	private JLabel lblSeleccionaANombre;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JPanel pnDatos;
	private JPanel pnPasajeros;
	private JPanel pnNumeroContacto;
	private JLabel lblPasajeros;
	private JComboBox<Pasajero> cbPasajeros;
	private JLabel lblNmeroDeContacto;
	private JTextField txtNumeroContacto;

	public VentanaAsignarNombreReserva(VentanaPrincipal vp) {
		setTitle("Asignar pasajero a la reserva");
		this.vp = vp;
		setBounds(100, 100, 561, 202);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnTitulo(), BorderLayout.NORTH);
		pnPrincipal.add(getPnDatos(), BorderLayout.CENTER);
		pnPrincipal.add(getPnBotones(), BorderLayout.SOUTH);
		cargaAyuda();
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setLayout(new GridLayout(0, 1, 0, 0));
			pnTitulo.add(getLblSeleccionaANombre());
		}
		return pnTitulo;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtnAceptar());
			pnBotones.add(getBtnCancelar());
		}
		return pnBotones;
	}

	private JLabel getLblSeleccionaANombre() {
		if (lblSeleccionaANombre == null) {
			lblSeleccionaANombre = new JLabel(
					"Selecciona a nombre de que pasajero se realiza la reserva");
			lblSeleccionaANombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeleccionaANombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblSeleccionaANombre;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setToolTipText(
					"Selecciona al pasajero para poner la reserva a su nombre");
			btnAceptar.setMnemonic('A');
			btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!txtNumeroContacto.getText().isEmpty()) {
						vp.setCliente((Pasajero) cbPasajeros.getSelectedItem());
						vp.setNumeroContacto(txtNumeroContacto.getText());
						((CardLayout) vp.getPnReservas().getLayout())
								.next(vp.getPnReservas());
						vp.crearResumen();
						vp.getBtnConfrimarResumen();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"Introduzca un número de contacto", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnAceptar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setToolTipText(
					"Cierra la ventana actual y vuelve a la ventana principal");
			btnCancelar.setMnemonic('C');
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}

	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setLayout(new GridLayout(2, 0, 0, 0));
			pnDatos.add(getPnPasajeros());
			pnDatos.add(getPnNumeroContacto());
		}
		return pnDatos;
	}

	private JPanel getPnPasajeros() {
		if (pnPasajeros == null) {
			pnPasajeros = new JPanel();
			pnPasajeros.setLayout(new GridLayout(1, 0, 0, 0));
			pnPasajeros.add(getLblPasajeros());
			pnPasajeros.add(getCbPasajeros());
		}
		return pnPasajeros;
	}

	private JPanel getPnNumeroContacto() {
		if (pnNumeroContacto == null) {
			pnNumeroContacto = new JPanel();
			pnNumeroContacto.setLayout(new GridLayout(0, 2, 0, 0));
			pnNumeroContacto.add(getLblNmeroDeContacto());
			pnNumeroContacto.add(getTxtNumeroContacto());
		}
		return pnNumeroContacto;
	}

	private JLabel getLblPasajeros() {
		if (lblPasajeros == null) {
			lblPasajeros = new JLabel("Pasajeros:");
			lblPasajeros.setLabelFor(getCbPasajeros());
			lblPasajeros.setDisplayedMnemonic('P');
			lblPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblPasajeros;
	}

	private JComboBox<Pasajero> getCbPasajeros() {
		if (cbPasajeros == null) {
			DefaultComboBoxModel<Pasajero> aux = new DefaultComboBoxModel<Pasajero>();
			for (Pasajero a : vp.getListaPasajeros()) {
				if (!a.isMenor())
					aux.addElement(a);
			}
			cbPasajeros = new JComboBox<Pasajero>();
			cbPasajeros.setToolTipText("Selecciona el pasajero");
			cbPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbPasajeros.setModel(aux);
		}
		return cbPasajeros;
	}

	private JLabel getLblNmeroDeContacto() {
		if (lblNmeroDeContacto == null) {
			lblNmeroDeContacto = new JLabel("Número de contacto:");
			lblNmeroDeContacto.setLabelFor(getTxtNumeroContacto());
			lblNmeroDeContacto.setDisplayedMnemonic('N');
			lblNmeroDeContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblNmeroDeContacto;
	}

	private JTextField getTxtNumeroContacto() {
		if (txtNumeroContacto == null) {
			txtNumeroContacto = new JTextField();
			txtNumeroContacto.setToolTipText(
					"Introduzca el número de contacto para la reserva");
			txtNumeroContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNumeroContacto.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char teclapulsada = e.getKeyChar();
					if (!Character.isDigit(teclapulsada))
						e.consume();
				}
			});
			txtNumeroContacto.setColumns(10);
		}
		return txtNumeroContacto;
	}

	private void cargaAyuda() {
		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/Ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ayuda no encontrada", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		HelpBroker hb = hs.createHelpBroker();
		hb.initPresentation();

		// Asocia un atajo de teclado a la ayuda, a F1
		hb.enableHelpKey(pnPrincipal, "ventanaAsignar", hs);
	}
}
