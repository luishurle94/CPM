package igu.VentanasAuxiliares;

import igu.PanelesAuxiliares.PanelImagenRedimensionable;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;

import logica.Crucero;

public class VentanaDetallesBarco extends JDialog {

	private Crucero crucero;
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JPanel pnTitulo;
	private JPanel pnBotones;
	private JPanel pnDatos;
	private JButton btnAtras;
	private JLabel lblDatosDelBarco;
	private JPanel pnNombreDescripcioImagen;
	private JPanel pnNumeroCamarotes;
	private JPanel pnNumeroCamarotes2;
	private JPanel pnCamarotesDoblesExteriores;
	private JPanel pnCamarotesFamiliaresExteriores;
	private JPanel pnCamarotesDoblesInteriores;
	private JPanel pnCamarotesFamiliaresInteriores;
	private JPanel pnAux;
	private JPanel pnNombreDescipcion;
	private PanelImagenRedimensionable pnImagen;
	private JPanel pnNombre;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JScrollPane scDescripcion;
	private JLabel lblDescripcion;
	private JTextArea txtAreaDescripcion;
	private JLabel lblCamarotesDoblesExteriores;
	private JTextField txtCamarotesDoblesExteriores;
	private JLabel lblCamarotesDoblesInteriores;
	private JTextField txtCamarotesDoblesInteriores;
	private JLabel lblCamarotesFamiliaresExteriores;
	private JLabel lblCamarotesFamiliaresInteriores;
	private JTextField txtCamarotesFamiliaresExteriores;
	private JTextField txtCamarotesFamiliaresInteriores;
	private JLabel lblNumeroCamarotes;
	private JLabel lblEspacio;
	private JButton btnMostrarCapitan;

	/**
	 * Create the dialog.
	 * 
	 * @param ventanaPrincipal
	 */
	public VentanaDetallesBarco(Crucero crucero) {
		setTitle("Detalles del barco");
		this.crucero = crucero;
		setBounds(100, 100, 750, 600);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnTitulo(), BorderLayout.NORTH);
		pnPrincipal.add(getPnDatos(), BorderLayout.CENTER);
		pnPrincipal.add(getPnBotones(), BorderLayout.SOUTH);
		txtNombre.setText(crucero.getBarco().getDenominacion());
		txtAreaDescripcion.setText(crucero.getBarco().getDescripcion());
		txtCamarotesDoblesExteriores.setText(
				"" + crucero.getBarco().getNumCamarotesDoblesExteriores());
		txtCamarotesDoblesInteriores.setText(
				"" + crucero.getBarco().getNumCamarotesDoblesInteriores());
		txtCamarotesFamiliaresExteriores.setText(
				"" + crucero.getBarco().getNumCamarotesFamiliaresExteriores());
		txtCamarotesFamiliaresInteriores.setText(
				"" + crucero.getBarco().getNumCamarotesFamiliaresInteriores());
		cargaAyuda();
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.add(getLblDatosDelBarco());
		}
		return pnTitulo;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtnMostrarCapitan());
			pnBotones.add(getBtnAtras());
		}
		return pnBotones;
	}

	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setLayout(new BorderLayout(0, 0));
			pnDatos.add(getPnNombreDescripcioImagen(), BorderLayout.CENTER);
			pnDatos.add(getPnNumeroCamarotes(), BorderLayout.SOUTH);
		}
		return pnDatos;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atras");
			btnAtras.setToolTipText(
					"Cierra esta ventana y vuelve a la ventan principal");
			btnAtras.setMnemonic('A');
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return btnAtras;
	}

	private JLabel getLblDatosDelBarco() {
		if (lblDatosDelBarco == null) {
			lblDatosDelBarco = new JLabel("Datos del barco");
			lblDatosDelBarco.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblDatosDelBarco;
	}

	private JPanel getPnNombreDescripcioImagen() {
		if (pnNombreDescripcioImagen == null) {
			pnNombreDescripcioImagen = new JPanel();
			pnNombreDescripcioImagen.setLayout(new GridLayout(0, 1, 0, 0));
			pnNombreDescripcioImagen.add(getPnAux());
		}
		return pnNombreDescripcioImagen;
	}

	private JPanel getPnNumeroCamarotes() {
		if (pnNumeroCamarotes == null) {
			pnNumeroCamarotes = new JPanel();
			pnNumeroCamarotes.setLayout(new GridLayout(0, 1, 0, 0));
			pnNumeroCamarotes.add(getPnNumeroCamarotes2());
		}
		return pnNumeroCamarotes;
	}

	private JPanel getPnNumeroCamarotes2() {
		if (pnNumeroCamarotes2 == null) {
			pnNumeroCamarotes2 = new JPanel();
			pnNumeroCamarotes2.setLayout(new GridLayout(3, 2, 0, 0));
			pnNumeroCamarotes2.add(getLblNumeroCamarotes());
			pnNumeroCamarotes2.add(getLblEspacio());
			pnNumeroCamarotes2.add(getPnCamarotesDoblesExteriores());
			pnNumeroCamarotes2.add(getPnCamarotesFamiliaresExteriores());
			pnNumeroCamarotes2.add(getPnCamarotesDoblesInteriores());
			pnNumeroCamarotes2.add(getPnCamarotesFamiliaresInteriores());
		}
		return pnNumeroCamarotes2;
	}

	private JPanel getPnCamarotesDoblesExteriores() {
		if (pnCamarotesDoblesExteriores == null) {
			pnCamarotesDoblesExteriores = new JPanel();
			pnCamarotesDoblesExteriores.setLayout(new GridLayout(0, 2, 0, 0));
			pnCamarotesDoblesExteriores.add(getLblCamarotesDoblesExteriores());
			pnCamarotesDoblesExteriores.add(getTxtCamarotesDoblesExteriores());
		}
		return pnCamarotesDoblesExteriores;
	}

	private JPanel getPnCamarotesFamiliaresExteriores() {
		if (pnCamarotesFamiliaresExteriores == null) {
			pnCamarotesFamiliaresExteriores = new JPanel();
			pnCamarotesFamiliaresExteriores
					.setLayout(new GridLayout(0, 2, 0, 0));
			pnCamarotesFamiliaresExteriores
					.add(getLblCamarotesFamiliaresExteriores());
			pnCamarotesFamiliaresExteriores
					.add(getTxtCamarotesFamiliaresExteriores());
		}
		return pnCamarotesFamiliaresExteriores;
	}

	private JPanel getPnCamarotesDoblesInteriores() {
		if (pnCamarotesDoblesInteriores == null) {
			pnCamarotesDoblesInteriores = new JPanel();
			pnCamarotesDoblesInteriores.setLayout(new GridLayout(0, 2, 0, 0));
			pnCamarotesDoblesInteriores.add(getLblCamarotesDoblesInteriores());
			pnCamarotesDoblesInteriores.add(getTxtCamarotesDoblesInteriores());
		}
		return pnCamarotesDoblesInteriores;
	}

	private JPanel getPnCamarotesFamiliaresInteriores() {
		if (pnCamarotesFamiliaresInteriores == null) {
			pnCamarotesFamiliaresInteriores = new JPanel();
			pnCamarotesFamiliaresInteriores
					.setLayout(new GridLayout(0, 2, 0, 0));
			pnCamarotesFamiliaresInteriores
					.add(getLblCamarotesFamiliaresInteriores());
			pnCamarotesFamiliaresInteriores
					.add(getTxtCamarotesFamiliaresInteriores());
		}
		return pnCamarotesFamiliaresInteriores;
	}

	private JPanel getPnAux() {
		if (pnAux == null) {
			pnAux = new JPanel();
			pnAux.setLayout(new GridLayout(0, 2, 0, 0));
			pnAux.add(getPnNombreDescipcion());
			pnAux.add(getPnImagen());
		}
		return pnAux;
	}

	private JPanel getPnNombreDescipcion() {
		if (pnNombreDescipcion == null) {
			pnNombreDescipcion = new JPanel();
			pnNombreDescipcion.setLayout(new BorderLayout(0, 0));
			pnNombreDescipcion.add(getPnNombre(), BorderLayout.NORTH);
			pnNombreDescipcion.add(getScDescripcion(), BorderLayout.CENTER);
		}
		return pnNombreDescipcion;
	}

	private PanelImagenRedimensionable getPnImagen() {
		if (pnImagen == null) {
			pnImagen = new PanelImagenRedimensionable(
					crucero.getBarco().getCodigo());
		}
		return pnImagen;
	}

	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.setLayout(new GridLayout(0, 2, 0, 0));
			pnNombre.add(getLblNombre());
			pnNombre.add(getTxtNombre());
		}
		return pnNombre;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNombre;
	}

	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setToolTipText(
					"Nombre del barco en el que se realiza el crucero");
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setEditable(false);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}

	private JScrollPane getScDescripcion() {
		if (scDescripcion == null) {
			scDescripcion = new JScrollPane();
			scDescripcion.setColumnHeaderView(getLblDescripcion());
			scDescripcion.setViewportView(getTxtAreaDescripcion());
		}
		return scDescripcion;
	}

	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripci\u00F3n:");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblDescripcion;
	}

	private JTextArea getTxtAreaDescripcion() {
		if (txtAreaDescripcion == null) {
			txtAreaDescripcion = new JTextArea();
			txtAreaDescripcion.setToolTipText(
					"Descripci\u00F3n del barco en el que se realiza el crucero");
			txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtAreaDescripcion.setEditable(false);
			txtAreaDescripcion.setLineWrap(true);
			txtAreaDescripcion.setWrapStyleWord(true);
		}
		return txtAreaDescripcion;
	}

	private JLabel getLblCamarotesDoblesExteriores() {
		if (lblCamarotesDoblesExteriores == null) {
			lblCamarotesDoblesExteriores = new JLabel(
					"Camarotes dobles exteriores:");
			lblCamarotesDoblesExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesDoblesExteriores;
	}

	private JTextField getTxtCamarotesDoblesExteriores() {
		if (txtCamarotesDoblesExteriores == null) {
			txtCamarotesDoblesExteriores = new JTextField();
			txtCamarotesDoblesExteriores.setToolTipText(
					"N\u00FAmero de camarotes dobles exteriores del barco");
			txtCamarotesDoblesExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCamarotesDoblesExteriores.setEditable(false);
			txtCamarotesDoblesExteriores.setColumns(10);
		}
		return txtCamarotesDoblesExteriores;
	}

	private JLabel getLblCamarotesDoblesInteriores() {
		if (lblCamarotesDoblesInteriores == null) {
			lblCamarotesDoblesInteriores = new JLabel(
					"Camarotes dobles interiores:");
			lblCamarotesDoblesInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesDoblesInteriores;
	}

	private JTextField getTxtCamarotesDoblesInteriores() {
		if (txtCamarotesDoblesInteriores == null) {
			txtCamarotesDoblesInteriores = new JTextField();
			txtCamarotesDoblesInteriores.setToolTipText(
					"N\u00FAmero de camarotes dobles interiores del barco");
			txtCamarotesDoblesInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCamarotesDoblesInteriores.setEditable(false);
			txtCamarotesDoblesInteriores.setColumns(10);
		}
		return txtCamarotesDoblesInteriores;
	}

	private JLabel getLblCamarotesFamiliaresExteriores() {
		if (lblCamarotesFamiliaresExteriores == null) {
			lblCamarotesFamiliaresExteriores = new JLabel(
					"Camarotes familiares exteriores");
			lblCamarotesFamiliaresExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesFamiliaresExteriores;
	}

	private JLabel getLblCamarotesFamiliaresInteriores() {
		if (lblCamarotesFamiliaresInteriores == null) {
			lblCamarotesFamiliaresInteriores = new JLabel(
					"Camarotes familiares interiores:");
			lblCamarotesFamiliaresInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesFamiliaresInteriores;
	}

	private JTextField getTxtCamarotesFamiliaresExteriores() {
		if (txtCamarotesFamiliaresExteriores == null) {
			txtCamarotesFamiliaresExteriores = new JTextField();
			txtCamarotesFamiliaresExteriores.setToolTipText(
					"N\u00FAmero de camarotes familiares exteriores del barco");
			txtCamarotesFamiliaresExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCamarotesFamiliaresExteriores.setEditable(false);
			txtCamarotesFamiliaresExteriores.setColumns(10);
		}
		return txtCamarotesFamiliaresExteriores;
	}

	private JTextField getTxtCamarotesFamiliaresInteriores() {
		if (txtCamarotesFamiliaresInteriores == null) {
			txtCamarotesFamiliaresInteriores = new JTextField();
			txtCamarotesFamiliaresInteriores.setToolTipText(
					"N\u00FAmero de camarotes familiares interiores del barco");
			txtCamarotesFamiliaresInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCamarotesFamiliaresInteriores.setEditable(false);
			txtCamarotesFamiliaresInteriores.setColumns(10);
		}
		return txtCamarotesFamiliaresInteriores;
	}

	private JLabel getLblNumeroCamarotes() {
		if (lblNumeroCamarotes == null) {
			lblNumeroCamarotes = new JLabel("N\u00FAmero de camarotes:");
			lblNumeroCamarotes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNumeroCamarotes;
	}

	private JLabel getLblEspacio() {
		if (lblEspacio == null) {
			lblEspacio = new JLabel("");
		}
		return lblEspacio;
	}

	public Crucero getCrucero() {
		return crucero;
	}

	public void setCrucero(Crucero crucero) {
		this.crucero = crucero;
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
		hb.enableHelpKey(pnPrincipal, "ventanaDetalleBarco", hs);
	}

	private JButton getBtnMostrarCapitan() {
		if (btnMostrarCapitan == null) {
			btnMostrarCapitan = new JButton("Mostrar Capitan");
			btnMostrarCapitan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,
							"El capitan del barco es " + crucero.getBarco()
									.getCapitan().getNombre());
				}
			});
		}
		return btnMostrarCapitan;
	}
}
