package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.jvnet.substance.SubstanceLookAndFeel;

import igu.PanelesAuxiliares.PanelImagenRedimensionable;
import igu.VentanasAuxiliares.VentanaAsignarNombreReserva;
import igu.VentanasAuxiliares.VentanaAñadirCamarote;
import igu.VentanasAuxiliares.VentanaAñadirPasajero;
import igu.VentanasAuxiliares.VentanaDetallesBarco;
import logica.Camarote;
import logica.Catalogo;
import logica.Crucero;
import logica.Extra;
import logica.Pasajero;

public class VentanaPrincipal extends JFrame {

	private Catalogo catalogo;
	private Crucero crucero;
	private ArrayList<Pasajero> listaPasajeros;
	public ArrayList<Pasajero> listaClientes;
	public ArrayList<Camarote> listaCamarotes;
	private Pasajero cliente;
	private String numeroContacto;

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JPanel pnOpciones;
	private JPanel pnAyuda;
	private JPanel pnIdiomas;
	private JButton btnAyuda;
	private JButton btnCastellano;
	private JButton btnIngles;
	private JButton btnFrances;
	private JButton btnAleman;
	private JPanel pnReservas;
	private JPanel pnInicio;
	private JPanel pnBienvenido;
	private JPanel pnComenzar;
	private JButton btnComenzar;
	private JLabel lblBienvenido;
	private JPanel pnListaCruceros;
	private JPanel pnTitulo;
	private JLabel lblListaCrucerosDisponibles;
	private JPanel pnTablaCruceros;
	private JPanel pnBotones;
	private ButtonGroup grupoBotonesFiltros;
	private ButtonGroup grupoBotonesTabla;
	private String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
			"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
			"Diciembre" };
	private JPanel pnFiltros;
	private JScrollPane scListaCruceros;
	private JButton btnSiguienteListaCruceros;
	private JButton btnCancelarListaCruceros;
	private JPanel pnTituloSeleccionarCrucero;
	private JPanel pnFiltrosTodos;
	private JLabel lblSeleccionarCrucero;
	private JPanel pnSeleccionFiltros;
	private JScrollPane scOpcionesFiltros;
	private JLabel lblPorFavorSeleccione;
	private JComboBox<String> cbOpcionesFiltros;
	private JPanel pnOpcionesFiltros;
	private JTable tablaCruceros;
	private DefaultTableModel modeloTablaCruceros;
	private JPanel pnDetallesCrucero;
	private JPanel pnDatosCrucero;
	private JPanel pnBotonesDetallesCrucero;
	private JButton btnAtrasDetallesCrucero;
	private JButton btnSiguienteDetallesCrucero;
	private JButton btnCancelarDetallesCrucero;
	private JPanel pnImagenFechas;
	private JPanel pnDescripcionPrecio;
	private PanelImagenRedimensionable pnImagen;
	private JPanel pnFechasSalida;
	private JPanel pnDescripcion;
	private JPanel pnPrecio;
	private JLabel lblDescripcionCrucero;
	private JScrollPane scDescripcion;
	private JTextArea txtAreaDescripcion;
	private JPanel pnTituloFechaSalida;
	private JPanel pnPlazasDisponibles;
	private JLabel lblFechaDeSalida;
	private JPanel pnPlazasDoblesInteriores;
	private JPanel pnPlazasDoblesExteriores;
	private JPanel pnPlazasFamiliaresInteriores;
	private JPanel pnPlazasFamiliaresExteriores;
	private JPanel pnTituloPrecios;
	private JPanel pnPreciosCamarotes;
	private JLabel lblPreciosDeCamarotes;
	private JPanel pnPrecioFamiliarExterior;
	private JPanel pnPrecioDobleInterior;
	private JPanel pnPrecioDobleExterior;
	private JPanel pnPrecioFamiliarInterior;
	private JLabel lblDobleInterior;
	private JTextField txtPrecioDobleInterior;
	private JLabel lblDobleExterior;
	private JTextField txtPrecioDobleExterior;
	private JLabel lblFamiliarInterior;
	private JTextField txtPrecioFamiliarInterior;
	private JLabel lblFamiliarExterior;
	private JTextField txtPrecioFamiliarExterior;
	private JLabel lblCamarotesDoblesInteriores;
	private JTextField txtPlazasDoblesInteriores;
	private JLabel lblCamarotesDoblesExteriores;
	private JTextField txtPlazasDoblesExteriores;
	private JLabel lblCamarotesFamiliarInteriores;
	private JTextField txtPlazasFamiliaresInteriores;
	private JLabel lblCamarotesFamiliarExterior;
	private JTextField txtPlazasFamiliaresExteriores;
	private JPanel pnPasajeros;
	private JPanel pnTituloPasajeros;
	private JPanel pnListaPasajeros;
	private JPanel pnBotonesPasajeros;
	private JLabel lblListaDePasajeros;
	private JButton btnAtrasPasajeros;
	private JButton btnSiguientePasajeros;
	private JButton btnCancelarPasajeros;
	private JLabel lblPorFavorIntroduzca;
	private JScrollPane scPasajeros;
	private JPanel pnBotonesModificarPasajeros;
	private JTable tablaPasajeros;
	private DefaultTableModel modeloTablaPasajeros;
	private JButton btnAñadirPasajero;
	private JButton btnBorrarPasajero;
	private JPanel pnEspacio1RegistroPasajeros;
	private JPanel pnEspacio2RegistroPasajeros;
	private JLabel lblEspacio1RegistroPasajeros;
	private JLabel lblEspacio2RegistroPasajeros;
	private JComboBox<String> cbFechas;
	private JPanel pnCamarotes;
	private JPanel pnBotonesReservaCamarotes;
	private JPanel pnTituloReservaCamarotes;
	private JPanel pnEspacio1ReservaCamarotes;
	private JPanel pnEspacio2ReservaCamarotes;
	private JLabel lblEspacio1ReservaCamarotes;
	private JLabel lblEspacio2ReservaCamarotes;
	private JLabel lblListaDeCamarotes;
	private JButton btnAtrasReservaCamarotes;
	private JButton btnSiguienteReservaCamarotes;
	private JButton btnCancelarReservaCamarotes;
	private JPanel pnListaCamarotes;
	private JPanel pnModificarListaCamarotes;
	private JScrollPane scCamarotes;
	private JTable tablaCamarotes;
	private JButton btnAñadirReservaCamarotes;
	private JButton btnBorrarReservaCamarotes;
	private DefaultTableModel modeloTablaCamarotes;
	private JPanel pnResumen;
	private JPanel pnTituloResumen;
	private JPanel pnDatosResumen;
	private JPanel pnBotonesResumen;
	private JButton btnAtrasResumen;
	private JButton btnConfrimarResumen;
	private JButton btnCancelarResumen;
	private JLabel lblResumenDeLa;
	private JScrollPane scResumen;
	private JTextArea txtAreaReserva;

	private final static String NOMBRE_EMPRESA = "IGM1990";
	private JPanel pnFin;
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
	private JLabel lblPorFavorIntroduzca_1;
	private JLabel lblEspacioResumen1;
	private JLabel lblEspacioResumen2;
	private JPanel pnSeleccionSalida;
	private JPanel pnDetallesBarco;
	private JLabel lblDetallesBarco;
	private JButton btnMostrar;

	class FiltrosCruceros implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			agregarCrucerosTabla();
		}
	}

	class RadioButtonRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (value == null)
				return null;
			return (Component) value;
		}
	}

	class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
		private static final long serialVersionUID = -3406382419304747915L;
		private JRadioButton button;

		public RadioButtonEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) {
			if (value == null)
				return null;
			button = (JRadioButton) value;
			button.addItemListener(this);
			return (Component) value;
		}

		public Object getCellEditorValue() {
			button.removeItemListener(this);
			return button;
		}

		public void itemStateChanged(ItemEvent e) {
			super.fireEditingStopped();
		}

		public boolean isCellEditable() {
			return true;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin(
							"org.jvnet.substance.skin.BusinessBlueSteelSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.getBtnComenzar().grabFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ArrayList<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}

	public void setCliente(Pasajero cliente) {
		this.cliente = cliente;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public ArrayList<Camarote> getListaCamarotes() {
		return listaCamarotes;
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/img/Fin.jpg")));
		setTitle("Reserva de cruceros");
		catalogo = new Catalogo();
		crucero = null;
		cliente = null;
		numeroContacto = new String();
		listaCamarotes = new ArrayList<Camarote>();
		listaPasajeros = new ArrayList<Pasajero>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnOpciones(), BorderLayout.NORTH);
		pnPrincipal.add(getPnReservas(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		cargaAyuda();
	}

	private JPanel getPnOpciones() {
		if (pnOpciones == null) {
			pnOpciones = new JPanel();
			pnOpciones.setLayout(new GridLayout(1, 0, 0, 0));
			pnOpciones.add(getPnAyuda());
			pnOpciones.add(getPnIdiomas());
		}
		return pnOpciones;
	}

	private JPanel getPnAyuda() {
		if (pnAyuda == null) {
			pnAyuda = new JPanel();
			pnAyuda.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			pnAyuda.add(getBtnAyuda());
		}
		return pnAyuda;
	}

	private JPanel getPnIdiomas() {
		if (pnIdiomas == null) {
			pnIdiomas = new JPanel();
			FlowLayout fl_pnIdiomas = (FlowLayout) pnIdiomas.getLayout();
			fl_pnIdiomas.setAlignment(FlowLayout.RIGHT);
			pnIdiomas.add(getBtnCastellano());
			pnIdiomas.add(getBtnIngles());
			pnIdiomas.add(getBtnFrances());
			pnIdiomas.add(getBtnAleman());
		}
		return pnIdiomas;
	}

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("?");
			btnAyuda.setToolTipText("Muestra la ayuda de la aplicaci\u00F3n");
			btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnAyuda;
	}

	private JButton getBtnCastellano() {
		if (btnCastellano == null) {
			btnCastellano = new JButton("");
			btnCastellano.setToolTipText(
					"Cambia el idioma de la aplicaci\u00F3n a castellano");
			btnCastellano.setBackground(Color.WHITE);
			btnCastellano.setBounds(0, 0, 20, 20);
			btnCastellano.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/espa\u00F1ol.jpg")));
			btnCastellano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,
							"En estos momentos nuestra aplicaciï¿½n solo esta disponible en castellano.\nLamentamos las molestias.",
							"Atenciï¿½n", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return btnCastellano;
	}

	private JButton getBtnIngles() {
		if (btnIngles == null) {
			btnIngles = new JButton("");
			btnIngles.setToolTipText(
					"Cambia el idioma de la aplicaci\u00F3n a ingl\u00E9s");
			btnIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null,
							"Right now our application is only available in Spanish.\nSorry for discomfort.",
							"Attention", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnIngles.setBackground(Color.WHITE);
			btnIngles.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/ingles.jpg")));
		}
		return btnIngles;
	}

	private JButton getBtnFrances() {
		if (btnFrances == null) {
			btnFrances = new JButton("");
			btnFrances.setToolTipText(
					"Cambia el idioma de la aplicaci\u00F3n a franc\u00E9s");
			btnFrances.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"En ce moment, notre application est seulement disponible en espagnol.\nDï¿½solï¿½ pour l'inconfort.",
							"Attention", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnFrances.setBackground(Color.WHITE);
			btnFrances.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/frances.jpg")));
		}
		return btnFrances;
	}

	private JButton getBtnAleman() {
		if (btnAleman == null) {
			btnAleman = new JButton("");
			btnAleman.setToolTipText(
					"Cambia el idioma de la aplicaci\u00F3n a alem\u00E1n");
			btnAleman.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Gerade jetzt unsere Anwendung ist nur auf Spanisch erhï¿½ltlich.\n Es tut uns leid fï¿½r die Unannehmlichkeiten.",
							"Aufmerksamkeit", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnAleman.setBackground(Color.WHITE);
			btnAleman.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/aleman.jpg")));
		}
		return btnAleman;
	}

	public JPanel getPnReservas() {
		if (pnReservas == null) {
			pnReservas = new JPanel();
			pnReservas.setLayout(new CardLayout(0, 0));

			// pnInicio = new PanelInicio(this);
			// pnReservas.add(pnInicio, "Inicio");
			//
			// pnListaCruceros = new PanelListaCruceros(this);
			// pnReservas.add(pnListaCruceros, "ListaCruceros");
			//
			// pnDetallesBarco = new PanelDetallesCrucero(this);
			// pnReservas.add(pnDetallesBarco, "DetallesCrucero");
			//
			// pnPasajeros = new PanelPasajeros(this);
			// pnReservas.add(pnPasajeros, "RegistroPasajeros");
			//
			// pnCamarotes = new PanelCamarotes(this);
			// pnReservas.add(pnCamarotes, "ReservaCamarotes");
			//
			// pnResumen = new PanelResumen(this);
			// pnReservas.add(pnResumen, "Resumen");
			//
			// pnFin = new PanelResumen(this);
			// pnReservas.add(pnFin, "Fin");

			pnReservas.add(getPnInicio(), "Inicio");
			pnReservas.add(getPnListaCruceros(), "ListaCruceros");
			pnReservas.add(getPnDetallesCrucero(), "DetallesCrucero");
			pnReservas.add(getPnPasajeros(), "RegistroPasajeros");
			pnReservas.add(getPnCamarotes(), "ReservaCamarotes");
			pnReservas.add(getPnResumen(), "Resumen");
			pnReservas.add(getPnFin(), "Fin");
		}
		return pnReservas;
	}

	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(new BorderLayout(0, 0));
			pnInicio.add(getPnBienvenido(), BorderLayout.NORTH);
			pnInicio.add(getPnComenzar(), BorderLayout.SOUTH);
		}
		return pnInicio;
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

	public JButton getBtnComenzar() {
		if (btnComenzar == null) {
			btnComenzar = new JButton("Comenzar");
			btnComenzar.setToolTipText("Pulsa para comenzar con la reserva");
			btnComenzar.setMnemonic('C');
			btnComenzar.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnComenzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cbOpcionesFiltros.setSelectedIndex(0);
					((CardLayout) pnReservas.getLayout()).next(pnReservas);
					getCbOpciones().grabFocus();
					int contador = 0;
					for (Crucero crucero : catalogo.getCruceros())
						if (crucero.isDescuento())
							contador++;
					String[] crucerosConDescuento = new String[contador];
					contador = 0;
					for (Crucero crucero : catalogo.getCruceros())
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

	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido");
			lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 99));
		}
		return lblBienvenido;
	}

	private JPanel getPnListaCruceros() {
		if (pnListaCruceros == null) {
			pnListaCruceros = new JPanel();
			grupoBotonesFiltros = new ButtonGroup();
			grupoBotonesTabla = new ButtonGroup();
			pnListaCruceros.setLayout(new BorderLayout(0, 0));
			pnListaCruceros.add(getPnTitulo(), BorderLayout.NORTH);
			pnListaCruceros.add(getPnTablaCruceros(), BorderLayout.CENTER);
			pnListaCruceros.add(getPnBotones(), BorderLayout.SOUTH);
			crearFiltros();
			agregarTodo();
			btnSiguienteListaCruceros.setEnabled(false);
		}
		return pnListaCruceros;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.add(getLblListaCrucerosDisponibles());
		}
		return pnTitulo;
	}

	private JLabel getLblListaCrucerosDisponibles() {
		if (lblListaCrucerosDisponibles == null) {
			lblListaCrucerosDisponibles = new JLabel(
					"Lista de cruceros disponibles:");
			lblListaCrucerosDisponibles
					.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblListaCrucerosDisponibles;
	}

	private JPanel getPnTablaCruceros() {
		if (pnTablaCruceros == null) {
			pnTablaCruceros = new JPanel();
			pnTablaCruceros.setLayout(new BorderLayout(0, 0));
			pnTablaCruceros.add(getPnFiltros(), BorderLayout.NORTH);
			pnTablaCruceros.add(getScListaCruceros(), BorderLayout.CENTER);
		}
		return pnTablaCruceros;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtnSiguienteListaCruceros());
			pnBotones.add(getBtnCancelarListaCruceros());
		}
		return pnBotones;
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new BorderLayout(0, 0));
			pnFiltros.add(getPnTituloSeleccionarCrucero(), BorderLayout.NORTH);
			pnFiltros.add(getPnFiltrosTodos(), BorderLayout.CENTER);
		}
		return pnFiltros;
	}

	private JScrollPane getScListaCruceros() {
		if (scListaCruceros == null) {
			scListaCruceros = new JScrollPane();
			scListaCruceros.setViewportView(getTablaCruceros());
		}
		return scListaCruceros;
	}

	private JButton getBtnSiguienteListaCruceros() {
		if (btnSiguienteListaCruceros == null) {
			btnSiguienteListaCruceros = new JButton("Siguiente");
			btnSiguienteListaCruceros.setToolTipText(
					"Muestra los detalles del crucero seleccionado");
			btnSiguienteListaCruceros.setMnemonic('S');
			btnSiguienteListaCruceros
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnSiguienteListaCruceros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < tablaCruceros.getRowCount(); i++) {
						JRadioButton radio = (JRadioButton) tablaCruceros
								.getValueAt(i,
										tablaCruceros.getColumnCount() - 1);
						if (radio.isSelected()) {
							Object[] cruceroSeleccionado = new Object[] {
									tablaCruceros.getValueAt(i, 0),
									tablaCruceros.getValueAt(i, 1),
									tablaCruceros.getValueAt(i, 2),
									tablaCruceros.getValueAt(i, 4),
									tablaCruceros.getValueAt(i, 6) };
							for (int j = 0; j < catalogo.getCruceros()
									.size(); j++) {
								if (catalogo.getCruceros().get(j).getZona()
										.equals(cruceroSeleccionado[0])
										&& catalogo.getCruceros().get(j)
												.getPuertoSalida()
												.equals(cruceroSeleccionado[1])
										&& catalogo.getCruceros().get(j)
												.getItinerario()
												.equals(cruceroSeleccionado[2])
										&& cruceroSeleccionado[3].equals(
												catalogo.getCruceros().get(j)
														.getDuracionDias())
										&& catalogo.getCruceros().get(j)
												.getBarco().getDenominacion()
												.equals(cruceroSeleccionado[4])) {
									crucero = catalogo.getCruceros().get(j);
								}
							}
							break;
						}
					}
					if (crucero != null) {
						cargarCrucero();
						((CardLayout) pnReservas.getLayout()).next(pnReservas);
						getCbFechas().grabFocus();
						if (txtPlazasDoblesExteriores.getText()
								.equals("0 libres")
								&& txtPlazasDoblesInteriores.getText()
										.equals("0 libres")
								&& txtPlazasFamiliaresExteriores.getText()
										.equals("0 libres")
								&& txtPlazasFamiliaresInteriores.getText()
										.equals("0 libres"))
							btnSiguienteDetallesCrucero.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null,
								"Por favor seleccione un crucero", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnSiguienteListaCruceros;
	}

	public void cargarCrucero() {
		txtAreaDescripcion.setText(crucero.getDescripcion());
		cbFechas.setModel(
				new DefaultComboBoxModel<String>(crucero.getFechas()));
		comprobarPlazasDisponibleCrucero();
		txtPrecioDobleExterior.setText(
				"" + crucero.getBarco().getPrecioCamarotesDoblesExteriores()
						+ " ï¿½");
		txtPrecioDobleInterior.setText(
				"" + crucero.getBarco().getPrecioCamarotesDoblesInteriores()
						+ " ï¿½");
		txtPrecioFamiliarExterior.setText(
				"" + crucero.getBarco().getPrecioCamarotesFamiliaresExteriores()
						+ " ï¿½");
		txtPrecioFamiliarInterior.setText(
				"" + crucero.getBarco().getPrecioCamarotesFamiliaresInteriores()
						+ " ï¿½");
		cambiarImagen();

	}

	private void comprobarPlazasDisponibleCrucero() {
		ArrayList<Camarote> camarotes = crucero.getPasajerosFechas()
				.get(cbFechas.getSelectedIndex());
		int dobleE = 0, dobleI = 0, familiarE = 0, familiarI = 0;
		for (Camarote camarote : camarotes) {
			if (!camarote.isReservada())
				if (camarote.isTipo() == Camarote.TIPO_DOBLE) {
					if (camarote.isPosicion() == Camarote.POSICION_EXTERIOR)
						dobleE++;
					else
						dobleI++;
				} else if (camarote.isTipo() == Camarote.TIPO_FAMILIAR) {
					if (camarote.isPosicion() == Camarote.POSICION_EXTERIOR)
						familiarE++;
					else if (camarote.isTipo() == Camarote.POSICION_INTERIOR)
						familiarI++;
				}
		}
		txtPlazasDoblesExteriores.setText("" + dobleE + " libres");
		txtPlazasDoblesInteriores.setText("" + dobleI + " libres");
		txtPlazasFamiliaresExteriores.setText("" + familiarE + " libres");
		txtPlazasFamiliaresInteriores.setText("" + familiarI + " libres");
	}

	private void cambiarImagen() {
		pnImagenFechas.removeAll();
		pnImagen = new PanelImagenRedimensionable(crucero.getCodigo());
		pnImagen.setLayout(new GridLayout(1, 0, 0, 0));
		pnImagenFechas.add(getPnImagen());
		pnImagenFechas.add(getPnFechasSalida());
	}

	private JButton getBtnCancelarListaCruceros() {
		if (btnCancelarListaCruceros == null) {
			btnCancelarListaCruceros = new JButton("Cancelar");
			btnCancelarListaCruceros
					.setToolTipText("Vuelve a la pantalla de inicio");
			btnCancelarListaCruceros.setMnemonic('C');
			btnCancelarListaCruceros
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelarListaCruceros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
		}
		return btnCancelarListaCruceros;
	}

	private JPanel getPnTituloSeleccionarCrucero() {
		if (pnTituloSeleccionarCrucero == null) {
			pnTituloSeleccionarCrucero = new JPanel();
			pnTituloSeleccionarCrucero.add(getLblSeleccionarCrucero());
		}
		return pnTituloSeleccionarCrucero;
	}

	private JPanel getPnFiltrosTodos() {
		if (pnFiltrosTodos == null) {
			pnFiltrosTodos = new JPanel();
			pnFiltrosTodos.setLayout(new BorderLayout(0, 0));
			pnFiltrosTodos.add(getPnSeleccionFiltros(), BorderLayout.NORTH);
			pnFiltrosTodos.add(getScOpcionesFiltros(), BorderLayout.CENTER);
		}
		return pnFiltrosTodos;
	}

	private JLabel getLblSeleccionarCrucero() {
		if (lblSeleccionarCrucero == null) {
			lblSeleccionarCrucero = new JLabel(
					"Por favor seleccione un crucero:");
			lblSeleccionarCrucero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSeleccionarCrucero;
	}

	private JPanel getPnSeleccionFiltros() {
		if (pnSeleccionFiltros == null) {
			pnSeleccionFiltros = new JPanel();
			pnSeleccionFiltros.add(getLblPorFavorSeleccione());
			pnSeleccionFiltros.add(getCbOpciones());
		}
		return pnSeleccionFiltros;
	}

	private JScrollPane getScOpcionesFiltros() {
		if (scOpcionesFiltros == null) {
			scOpcionesFiltros = new JScrollPane();
			scOpcionesFiltros.setViewportView(getPnOpcionesFiltros());
		}
		return scOpcionesFiltros;
	}

	private JLabel getLblPorFavorSeleccione() {
		if (lblPorFavorSeleccione == null) {
			lblPorFavorSeleccione = new JLabel("Filtros: ");
			lblPorFavorSeleccione.setDisplayedMnemonic('F');
			lblPorFavorSeleccione.setLabelFor(getCbOpciones());
			lblPorFavorSeleccione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPorFavorSeleccione;
	}

	private JComboBox<String> getCbOpciones() {
		if (cbOpcionesFiltros == null) {
			String[] opciones = { "Zona", "Puerto de salida", "Itinerario",
					"Admisiï¿½n de menores", "Dias de duraciï¿½n", "Fechas",
					"Barco", "Precio de camarote" };
			cbOpcionesFiltros = new JComboBox<String>();
			cbOpcionesFiltros.setToolTipText(
					"Selecciona la caracteristica por la cual se van ha filtrar los cruceros");
			cbOpcionesFiltros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbOpcionesFiltros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inicializarTablaCruceros();
				}
			});
			cbOpcionesFiltros
					.setModel(new DefaultComboBoxModel<String>(opciones));
		}
		return cbOpcionesFiltros;
	}

	private void inicializarTablaCruceros() {
		borrarTabla();
		grupoBotonesFiltros = new ButtonGroup();
		pnOpcionesFiltros.removeAll();
		crearFiltros();
		pnOpcionesFiltros.updateUI();
		pnOpcionesFiltros.repaint();
		repaint();
		agregarCrucerosTabla();
	}

	private void crearFiltros() {
		if (cbOpcionesFiltros.getSelectedItem().equals("Zona")) {
			cargarFiltrosZona();
			asignarMnemonicosFiltros();
		} else if (cbOpcionesFiltros.getSelectedItem()
				.equals("Puerto de salida")) {
			cargarFiltrosPuertoSalida();
			asignarMnemonicosFiltros();
		} else if (cbOpcionesFiltros.getSelectedItem().equals("Itinerario")) {
			cargarFiltrosItinerario();
			asignarMnemonicosFiltros();
		} else if (cbOpcionesFiltros.getSelectedItem()
				.equals("Admisiï¿½n de menores")) {
			cargarFiltrosMenores();
			asignarMnemonicosFiltros();
		} else if (cbOpcionesFiltros.getSelectedItem()
				.equals("Dias de duraciï¿½n"))
			cargarFiltrosDiasDuracion();
		else if (cbOpcionesFiltros.getSelectedItem().equals("Fechas"))
			cargarFiltrosFechas();
		else if (cbOpcionesFiltros.getSelectedItem().equals("Barco")) {
			cargarFiltrosBarco();
			asignarMnemonicosFiltros();
		} else if (cbOpcionesFiltros.getSelectedItem()
				.equals("Precio de camarote"))
			cargarFiltrosPrecio();
	}

	@SuppressWarnings("deprecation")
	private void asignarMnemonicosFiltros() {
		ArrayList<Character> mnemonicos = new ArrayList<Character>();
		mnemonicos.add(' ');
		mnemonicos.add('F');
		mnemonicos.add('S');
		mnemonicos.add('C');
		mnemonicos.add('f');
		mnemonicos.add('s');
		mnemonicos.add('c');
		for (int i = 0; i < pnOpcionesFiltros.getComponentCount(); i++) {
			JRadioButton radio = (JRadioButton) pnOpcionesFiltros
					.getComponent(i);
			int contador = 0;
			boolean correcto = false;
			Character e = radio.getLabel().charAt(contador);
			do {
				if (mnemonicos.contains(e)) {
					contador++;
					if (contador == radio.getLabel().length()) {
						e = radio.getLabel().charAt(0);
						break;
					} else
						e = radio.getLabel().charAt(contador);
				} else {
					if (Character.isUpperCase(e)) {
						mnemonicos.add(e);
						mnemonicos.add(Character.toLowerCase(e));
					} else {
						mnemonicos.add(e);
						mnemonicos.add(Character.toUpperCase(e));
					}
					correcto = true;
				}
			} while (!correcto);
			radio.setMnemonic(e);
		}

	}

	private void cargarFiltrosZona() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : catalogo.getCruceros())
			if (!filtros.contains(a.getZona()))
				filtros.add(a.getZona());
		añadirRadioBoton(filtros);
	}

	private void cargarFiltrosPuertoSalida() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : catalogo.getCruceros())
			if (!filtros.contains(a.getPuertoSalida()))
				filtros.add(a.getPuertoSalida());
		añadirRadioBoton(filtros);
	}

	private void cargarFiltrosItinerario() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : catalogo.getCruceros())
			if (!filtros.contains(a.getItinerario()))
				filtros.add(a.getItinerario());
		ArrayList<String> ciudades = new ArrayList<String>();
		for (String a : filtros) {
			String[] b = a.split("-");
			for (String c : b)
				if (!ciudades.contains(c))
					ciudades.add(c);
		}
		añadirRadioBoton(ciudades);
	}

	private void cargarFiltrosMenores() {
		JRadioButton radio = new JRadioButton("Si", true);
		radio.addActionListener(new FiltrosCruceros());
		grupoBotonesFiltros.add(radio);
		pnOpcionesFiltros.add(radio);
		JRadioButton radio2 = new JRadioButton("No");
		radio2.addActionListener(new FiltrosCruceros());
		grupoBotonesFiltros.add(radio2);
		pnOpcionesFiltros.add(radio2);
	}

	private void cargarFiltrosDiasDuracion() {
		int max = 0, min = Integer.MAX_VALUE;
		for (Crucero a : catalogo.getCruceros()) {
			if (max < a.getDuracionDias())
				max = a.getDuracionDias();
			if (min > a.getDuracionDias())
				min = a.getDuracionDias();
		}
		JSlider slider = new JSlider(min, max);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				borrarTabla();
				agregarTablaDiasDuracion();
			}
		});
		pnOpcionesFiltros.add(slider);
	}

	private void cargarFiltrosFechas() {
		ArrayList<String> fechasCruceros = new ArrayList<String>();
		for (Crucero crucero : catalogo.getCruceros()) {
			for (String fecha : crucero.getFechas())
				fechasCruceros.add(fecha);
		}
		int mesMax = 0, anioMax = 0, mesMin = Integer.MAX_VALUE,
				anioMin = Integer.MAX_VALUE;
		for (String fecha : fechasCruceros) {
			String[] aux = fecha.split("/");
			int mes = Integer.parseInt(aux[1]);
			int anio = Integer.parseInt(aux[2]);
			if (mesMax < mes)
				mesMax = mes;
			if (mesMin > mes)
				mesMin = mes;
			if (anioMax < anio)
				anioMax = anio;
			if (anioMin > anio)
				anioMin = anio;
		}
		int numeroMeses = mesMax - mesMin + 1;
		if (anioMax > anioMin) {
			int mesesDeMas = 0;
			for (String fecha : fechasCruceros) {
				String[] aux = fecha.split("/");
				if (aux[2].equals(String.valueOf(anioMax)))
					mesesDeMas = Integer.valueOf(aux[1]);
			}
			numeroMeses += mesesDeMas;
		}
		JComboBox<String> mesesSalidasCruceros = new JComboBox<String>();
		String[] salidas = new String[numeroMeses];
		for (int i = 0; i < salidas.length; i++) {
			if (i < 12)
				salidas[i] = meses[i] + " " + anioMin;
			else
				salidas[i] = meses[i - 12] + " " + (anioMin + 1);
		}
		mesesSalidasCruceros.addActionListener(new FiltrosCruceros());
		pnOpcionesFiltros.add(mesesSalidasCruceros);
		mesesSalidasCruceros
				.setModel(new DefaultComboBoxModel<String>(salidas));
	}

	private void cargarFiltrosBarco() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : catalogo.getCruceros())
			if (!filtros.contains(a.getBarco().getDenominacion()))
				filtros.add(a.getBarco().getDenominacion());
		añadirRadioBoton(filtros);
	}

	private void cargarFiltrosPrecio() {
		float precioMaximo = 0;
		for (Crucero crucero : catalogo.getCruceros()) {
			if (crucero.getBarco().getPrecioCamarotesDoblesExteriores() > 0)
				precioMaximo = crucero.getBarco()
						.getPrecioCamarotesDoblesExteriores();
			if (crucero.getBarco().getPrecioCamarotesDoblesInteriores() > 0)
				precioMaximo = crucero.getBarco()
						.getPrecioCamarotesDoblesInteriores();
			if (crucero.getBarco().getPrecioCamarotesFamiliaresExteriores() > 0)
				precioMaximo = crucero.getBarco()
						.getPrecioCamarotesFamiliaresExteriores();
			if (crucero.getBarco().getPrecioCamarotesFamiliaresInteriores() > 0)
				precioMaximo = crucero.getBarco()
						.getPrecioCamarotesFamiliaresInteriores();
		}
		ArrayList<String> precios = new ArrayList<String>();
		while (precioMaximo > 0) {
			precios.add("" + precioMaximo + " ï¿½");
			precioMaximo -= 10;
		}
		DefaultComboBoxModel<String> modeloPrecioDesde = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> modeloPrecioHasta = new DefaultComboBoxModel<String>();
		for (int i = precios.size() - 1; i >= 0; i--) {
			if (i == 0)
				modeloPrecioDesde.addElement(precios.get(i));
			else if (i == precios.size() - 1)
				modeloPrecioHasta.addElement(precios.get(i));
			else {
				modeloPrecioDesde.addElement(precios.get(i));
				modeloPrecioHasta.addElement(precios.get(i));
			}
		}
		JLabel lblDesdePrecio = new JLabel("Desde:");
		pnOpcionesFiltros.add(lblDesdePrecio);
		JComboBox<String> cbDesdePrecio = new JComboBox<String>();
		cbDesdePrecio.setModel(modeloPrecioHasta);
		pnOpcionesFiltros.add(cbDesdePrecio);
		lblDesdePrecio.setLabelFor(cbDesdePrecio);
		lblDesdePrecio.setDisplayedMnemonic('D');

		JLabel lblHastaPrecio = new JLabel("Hasta:");
		pnOpcionesFiltros.add(lblHastaPrecio);
		JComboBox<String> cbHastaPrecio = new JComboBox<String>();
		cbHastaPrecio.setModel(modeloPrecioDesde);
		pnOpcionesFiltros.add(cbHastaPrecio);
		cbHastaPrecio.setSelectedIndex(modeloPrecioDesde.getSize() - 1);
		lblHastaPrecio.setLabelFor(cbHastaPrecio);
		lblHastaPrecio.setDisplayedMnemonic('H');
		cbDesdePrecio.addActionListener(new FiltrosCruceros());
		cbHastaPrecio.addActionListener(new FiltrosCruceros());
	}

	private void añadirRadioBoton(ArrayList<String> filtros) {
		for (String a : filtros) {
			JRadioButton radio = new JRadioButton(a);
			radio.addActionListener(new FiltrosCruceros());
			grupoBotonesFiltros.add(radio);
			pnOpcionesFiltros.add(radio);
		}
		JRadioButton radio = new JRadioButton("Todos", true);
		radio.addActionListener(new FiltrosCruceros());
		grupoBotonesFiltros.add(radio);
		pnOpcionesFiltros.add(radio);
	}

	private void borrarTabla() {
		while (modeloTablaCruceros.getRowCount() > 0) {
			modeloTablaCruceros.removeRow(0);
		}
	}

	private void agregarCrucerosTabla() {
		borrarTabla();
		if (cbOpcionesFiltros.getSelectedIndex() == 0)
			agregarTablaZona();
		else if (cbOpcionesFiltros.getSelectedIndex() == 1)
			agregarTablaPuertoSalida();
		else if (cbOpcionesFiltros.getSelectedIndex() == 2)
			agregarTablaItinerario();
		else if (cbOpcionesFiltros.getSelectedIndex() == 3)
			agregarTablaMenores();
		else if (cbOpcionesFiltros.getSelectedIndex() == 4)
			agregarTablaDiasDuracion();
		else if (cbOpcionesFiltros.getSelectedIndex() == 5)
			agregarTablaFechas();
		else if (cbOpcionesFiltros.getSelectedIndex() == 6)
			agregarTablaBarco();
		else if (cbOpcionesFiltros.getSelectedIndex() == 7)
			agregarTablaPrecio();
	}

	private void agregarTodo() {
		for (Crucero crucero : catalogo.getCruceros())
			añadirCruceroTabla(crucero);
	}

	private void agregarTablaZona() {
		String filtro = new String();
		for (Component componente : pnOpcionesFiltros.getComponents()) {
			JRadioButton radio = (JRadioButton) componente;
			if (radio.isSelected()) {
				filtro = radio.getText();
				break;
			}
		}
		if (filtro.equals("Todos"))
			agregarTodo();
		else {
			for (Crucero crucero : catalogo.getCruceros()) {
				if (crucero.getZona().equals(filtro)) {
					añadirCruceroTabla(crucero);
				}
			}
		}
	}

	private void agregarTablaPuertoSalida() {
		String filtro = new String();
		for (Component componente : pnOpcionesFiltros.getComponents()) {
			JRadioButton radio = (JRadioButton) componente;
			if (radio.isSelected()) {
				filtro = radio.getText();
				break;
			}
		}
		if (filtro.equals("Todos"))
			agregarTodo();
		else {
			for (Crucero crucero : catalogo.getCruceros()) {
				if (crucero.getPuertoSalida().equals(filtro)) {
					añadirCruceroTabla(crucero);
				}
			}
		}
	}

	private void agregarTablaItinerario() {
		String filtro = new String();
		for (Component componente : pnOpcionesFiltros.getComponents()) {
			JRadioButton radio = (JRadioButton) componente;
			if (radio.isSelected()) {
				filtro = radio.getText();
				break;
			}
		}
		if (filtro.equals("Todos"))
			agregarTodo();
		else {
			for (Crucero crucero : catalogo.getCruceros()) {
				String[] ciudades = crucero.getItinerario().split("-");
				for (String ciudad : ciudades)
					if (ciudad.equals(filtro)) {
						añadirCruceroTabla(crucero);
					}
			}
		}
	}

	private void agregarTablaMenores() {
		String filtro = new String();
		for (Component componente : pnOpcionesFiltros.getComponents()) {
			JRadioButton radio = (JRadioButton) componente;
			if (radio.isSelected()) {
				filtro = radio.getText();
				break;
			}
		}
		boolean admisionMenores = false;
		if (filtro.equals("Si"))
			admisionMenores = true;
		for (Crucero crucero : catalogo.getCruceros()) {
			if (crucero.isMenores() == admisionMenores) {
				añadirCruceroTabla(crucero);
			}
		}
	}

	private void agregarTablaDiasDuracion() {
		JSlider radio = (JSlider) pnOpcionesFiltros.getComponent(0);
		int dias = radio.getValue();
		for (Crucero crucero : catalogo.getCruceros()) {
			if (crucero.getDuracionDias() <= dias) {
				añadirCruceroTabla(crucero);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void agregarTablaFechas() {
		JComboBox<String> combo = (JComboBox<String>) pnOpcionesFiltros
				.getComponent(0);
		String seleccion = (String) combo.getSelectedItem();
		String[] aux2 = seleccion.split(" ");
		for (int i = 0; i < meses.length; i++) {
			if (meses[i].equals(aux2[0])) {
				aux2[0] = "" + (i + 1);
				break;
			}
		}
		seleccion = aux2[0] + "/" + aux2[1];
		ArrayList<Crucero> cruceros = new ArrayList<Crucero>();
		for (Crucero crucero : catalogo.getCruceros()) {
			for (int i = 0; i < crucero.getFechas().length; i++) {
				if (!cruceros.contains(crucero)
						&& crucero.getFechas()[i].contains(seleccion)) {
					cruceros.add(crucero);
				}
			}
		}

		for (Crucero crucero : cruceros)
			añadirCruceroTabla(crucero);

	}

	private void agregarTablaBarco() {
		String filtro = new String();
		for (Component componente : pnOpcionesFiltros.getComponents()) {
			JRadioButton radio = (JRadioButton) componente;
			if (radio.isSelected()) {
				filtro = radio.getText();
				break;
			}
		}
		if (filtro.equals("Todos"))
			agregarTodo();
		else {
			for (Crucero crucero : catalogo.getCruceros()) {
				if (crucero.getBarco().getDenominacion().equals(filtro)) {
					añadirCruceroTabla(crucero);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void agregarTablaPrecio() {
		JComboBox<String> desde = (JComboBox<String>) pnOpcionesFiltros
				.getComponent(1);
		JComboBox<String> hasta = (JComboBox<String>) pnOpcionesFiltros
				.getComponent(3);
		String desdeString = (String) desde.getSelectedItem();
		float precioDesde = Float
				.parseFloat(desdeString.substring(0, desdeString.length() - 2));
		String hastaString = (String) hasta.getSelectedItem();
		float precioHasta = Float
				.parseFloat(hastaString.substring(0, desdeString.length() - 2));
		for (Crucero crucero : catalogo.getCruceros()) {
			if (crucero.getBarco()
					.getPrecioCamarotesDoblesExteriores() >= precioDesde
					&& crucero.getBarco()
							.getPrecioCamarotesDoblesExteriores() <= precioHasta
					|| crucero.getBarco()
							.getPrecioCamarotesDoblesInteriores() >= precioDesde
							&& crucero.getBarco()
									.getPrecioCamarotesDoblesInteriores() <= precioHasta
					|| crucero.getBarco()
							.getPrecioCamarotesFamiliaresExteriores() >= precioDesde
							&& crucero.getBarco()
									.getPrecioCamarotesFamiliaresExteriores() <= precioHasta
					|| crucero.getBarco()
							.getPrecioCamarotesFamiliaresInteriores() >= precioDesde
							&& crucero.getBarco()
									.getPrecioCamarotesFamiliaresInteriores() <= precioHasta)
				añadirCruceroTabla(crucero);
		}
	}

	private void añadirCruceroTabla(Crucero crucero) {
		String aux = new String(), menores = "No";
		for (String a : crucero.getFechas())
			aux += a + " - ";
		if (crucero.isMenores())
			menores = "Si";
		String descuento = "No";
		if (crucero.isDescuento())
			descuento = "Si";
		JRadioButton radio = new JRadioButton();
		grupoBotonesTabla.add(radio);
		modeloTablaCruceros.addRow(new Object[] { crucero.getZona(),
				crucero.getPuertoSalida(), crucero.getItinerario(), menores,
				crucero.getDuracionDias(), aux.substring(0, aux.length() - 3),
				crucero.getBarco().getDenominacion(), descuento, radio });

		int[] tamaño = new int[8];
		for (int i = 0; i < tablaCruceros.getColumnCount() - 1; i++) {
			for (int j = 0; j < tablaCruceros.getRowCount(); j++) {
				if (tamaño[i] < tablaCruceros.getValueAt(j, i).toString()
						.length()) {
					tamaño[i] = tablaCruceros.getValueAt(j, i).toString()
							.length();
				}
			}
		}
		tablaCruceros.getColumnModel().getColumn(0)
				.setPreferredWidth(tamaño[0] * 10);
		tablaCruceros.getColumnModel().getColumn(1).setPreferredWidth(125);
		tablaCruceros.getColumnModel().getColumn(2)
				.setPreferredWidth(tamaño[2] * 7);
		tablaCruceros.getColumnModel().getColumn(3).setPreferredWidth(150);
		tablaCruceros.getColumnModel().getColumn(4).setPreferredWidth(125);
		tablaCruceros.getColumnModel().getColumn(5)
				.setPreferredWidth(tamaño[5] * 7);
		tablaCruceros.getColumnModel().getColumn(6)
				.setPreferredWidth(tamaño[6] * 10);
		tablaCruceros.getColumnModel().getColumn(7).setPreferredWidth(100);
		tablaCruceros.getColumnModel().getColumn(8).setPreferredWidth(100);
	}

	private JPanel getPnOpcionesFiltros() {
		if (pnOpcionesFiltros == null) {
			pnOpcionesFiltros = new JPanel();
			pnOpcionesFiltros.setLayout(new GridLayout(0, 2, 0, 0));
		}
		return pnOpcionesFiltros;
	}

	private JTable getTablaCruceros() {
		if (tablaCruceros == null) {
			modeloTablaCruceros = new DefaultTableModel(
					new Object[] { "Zona", "Puerto de salida", "Itinerario",
							"AdmisiÃ³n de menores", "Dias de duraciÃ³n",
							"Fechas", "Barco", "Descuento", "Seleccionado" },
					0);
			tablaCruceros = new JTable(modeloTablaCruceros) {
				private static final long serialVersionUID = 4283967148348124808L;

				@Override
				public boolean isCellEditable(int row, int col) {
					if (col == 8)
						return true;
					return false;
				}

				public void tableChanged(TableModelEvent e) {
					super.tableChanged(e);
					repaint();
				}
			};
			tablaCruceros.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent arg0) {
					activarBotonSiguienteListaCruceros();
				}

			});
			tablaCruceros.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					activarBotonSiguienteListaCruceros();
				}
			});
			tablaCruceros.getTableHeader().setReorderingAllowed(false);
			tablaCruceros.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			DefaultTableCellRenderer celda = new DefaultTableCellRenderer();
			celda.setHorizontalAlignment(SwingConstants.CENTER);
			tablaCruceros.setDefaultRenderer(Object.class, celda);
			tablaCruceros.getColumn("Seleccionado")
					.setCellRenderer(new RadioButtonRenderer());
			tablaCruceros.getColumn("Seleccionado")
					.setCellEditor(new RadioButtonEditor(new JCheckBox()));
		}
		return tablaCruceros;
	}

	private void activarBotonSiguienteListaCruceros() {
		for (int i = 0; i < tablaCruceros.getRowCount(); i++) {
			JRadioButton radio = (JRadioButton) tablaCruceros.getValueAt(i,
					tablaCruceros.getColumnCount() - 1);
			if (radio.isSelected())
				btnSiguienteListaCruceros.setEnabled(true);
		}
	}

	private JPanel getPnDetallesCrucero() {
		if (pnDetallesCrucero == null) {
			pnDetallesCrucero = new JPanel();
			pnDetallesCrucero.setLayout(new BorderLayout(0, 0));
			pnDetallesCrucero.add(getPnDatosCrucero(), BorderLayout.CENTER);
			pnDetallesCrucero.add(getPnBotonesDetallesCrucero(),
					BorderLayout.SOUTH);
		}
		return pnDetallesCrucero;
	}

	private JPanel getPnDatosCrucero() {
		if (pnDatosCrucero == null) {
			pnDatosCrucero = new JPanel();
			pnDatosCrucero.setLayout(new GridLayout(1, 0, 0, 0));
			pnDatosCrucero.add(getPnImagenFechas());
			pnDatosCrucero.add(getPnDescripcionPrecio());
		}
		return pnDatosCrucero;
	}

	private JPanel getPnBotonesDetallesCrucero() {
		if (pnBotonesDetallesCrucero == null) {
			pnBotonesDetallesCrucero = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotonesDetallesCrucero
					.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotonesDetallesCrucero.add(getBtnAtrasDetallesCrucero());
			pnBotonesDetallesCrucero.add(getBtnSiguienteDetallesCrucero());
			pnBotonesDetallesCrucero.add(getBtnCancelarDetallesCrucero());
		}
		return pnBotonesDetallesCrucero;
	}

	private JButton getBtnAtrasDetallesCrucero() {
		if (btnAtrasDetallesCrucero == null) {
			btnAtrasDetallesCrucero = new JButton("Atras");
			btnAtrasDetallesCrucero.setToolTipText(
					"Vuelve a la pantalla de selecci\u00F3n de cruceros");
			btnAtrasDetallesCrucero.setMnemonic('A');
			btnAtrasDetallesCrucero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAtrasDetallesCrucero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbOpcionesFiltros.setSelectedIndex(0);
					btnSiguienteListaCruceros.setEnabled(false);
					((CardLayout) pnReservas.getLayout()).previous(pnReservas);
					getCbOpciones().grabFocus();
				}
			});
		}
		return btnAtrasDetallesCrucero;
	}

	private JButton getBtnSiguienteDetallesCrucero() {
		if (btnSiguienteDetallesCrucero == null) {
			btnSiguienteDetallesCrucero = new JButton("Siguiente");
			btnSiguienteDetallesCrucero
					.setToolTipText("Muestra la pantalla de pasajeros");
			btnSiguienteDetallesCrucero.setMnemonic('S');
			btnSiguienteDetallesCrucero
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnSiguienteDetallesCrucero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnReservas.getLayout()).next(pnReservas);
					getBtnAñadirPasajero().grabFocus();
				}
			});
		}
		return btnSiguienteDetallesCrucero;
	}

	private JButton getBtnCancelarDetallesCrucero() {
		if (btnCancelarDetallesCrucero == null) {
			btnCancelarDetallesCrucero = new JButton("Cancelar");
			btnCancelarDetallesCrucero.setMnemonic('C');
			btnCancelarDetallesCrucero.setToolTipText(
					"Borra todos los datos vuelve a la pantalla de inicio");
			btnCancelarDetallesCrucero
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelarDetallesCrucero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
		}
		return btnCancelarDetallesCrucero;
	}

	private JPanel getPnImagenFechas() {
		if (pnImagenFechas == null) {
			pnImagenFechas = new JPanel();
			pnImagenFechas.setLayout(new GridLayout(0, 1, 0, 0));
			pnImagenFechas.add(getPnImagen());
			pnImagenFechas.add(getPnFechasSalida());
		}
		return pnImagenFechas;
	}

	private JPanel getPnDescripcionPrecio() {
		if (pnDescripcionPrecio == null) {
			pnDescripcionPrecio = new JPanel();
			pnDescripcionPrecio.setLayout(new GridLayout(2, 0, 0, 0));
			pnDescripcionPrecio.add(getPnDescripcion());
			pnDescripcionPrecio.add(getPnPrecio());
		}
		return pnDescripcionPrecio;
	}

	private PanelImagenRedimensionable getPnImagen() {
		if (pnImagen == null) {
			pnImagen = new PanelImagenRedimensionable("CRU0001");
			pnImagen.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return pnImagen;
	}

	private JPanel getPnFechasSalida() {
		if (pnFechasSalida == null) {
			pnFechasSalida = new JPanel();
			pnFechasSalida.setLayout(new BorderLayout(0, 0));
			pnFechasSalida.add(getPnTituloFechaSalida(), BorderLayout.NORTH);
			pnFechasSalida.add(getPnPlazasDisponibles(), BorderLayout.CENTER);
		}
		return pnFechasSalida;
	}

	private JPanel getPnDescripcion() {
		if (pnDescripcion == null) {
			pnDescripcion = new JPanel();
			pnDescripcion.setLayout(new BorderLayout(0, 0));
			pnDescripcion.add(getLblDescripcionCrucero(), BorderLayout.NORTH);
			pnDescripcion.add(getScDescripcion(), BorderLayout.CENTER);
		}
		return pnDescripcion;
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.setLayout(new BorderLayout(0, 0));
			pnPrecio.add(getPnTituloPrecios(), BorderLayout.NORTH);
			pnPrecio.add(getPnPreciosCamarotes(), BorderLayout.CENTER);
		}
		return pnPrecio;
	}

	private JLabel getLblDescripcionCrucero() {
		if (lblDescripcionCrucero == null) {
			lblDescripcionCrucero = new JLabel("Descripci\u00F3n del Crucero:");
			lblDescripcionCrucero.setLabelFor(getTxtAreaDescripcion());
			lblDescripcionCrucero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblDescripcionCrucero;
	}

	private JScrollPane getScDescripcion() {
		if (scDescripcion == null) {
			scDescripcion = new JScrollPane();
			scDescripcion.setViewportView(getTxtAreaDescripcion());
		}
		return scDescripcion;
	}

	private JTextArea getTxtAreaDescripcion() {
		if (txtAreaDescripcion == null) {
			txtAreaDescripcion = new JTextArea();
			txtAreaDescripcion.setToolTipText(
					"Muestra la descripci\u00F3n del crucero seleccionado");
			txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtAreaDescripcion.setEditable(false);
			txtAreaDescripcion.setLineWrap(true);
			txtAreaDescripcion.setWrapStyleWord(true);
		}
		return txtAreaDescripcion;
	}

	private JPanel getPnTituloFechaSalida() {
		if (pnTituloFechaSalida == null) {
			pnTituloFechaSalida = new JPanel();
			pnTituloFechaSalida.setLayout(new GridLayout(2, 1, 0, 0));
			pnTituloFechaSalida.add(getPnSeleccionSalida());
			pnTituloFechaSalida.add(getPnDetallesBarco());
		}
		return pnTituloFechaSalida;
	}

	private JPanel getPnPlazasDisponibles() {
		if (pnPlazasDisponibles == null) {
			pnPlazasDisponibles = new JPanel();
			pnPlazasDisponibles.setLayout(new GridLayout(4, 4, 0, 0));
			pnPlazasDisponibles.add(getPnPlazasDoblesInteriores());
			pnPlazasDisponibles.add(getPnPlazasDoblesExteriores());
			pnPlazasDisponibles.add(getPnPlazasFamiliaresInteriores());
			pnPlazasDisponibles.add(getPnPlazasFamiliaresExteriores());
		}
		return pnPlazasDisponibles;
	}

	private JLabel getLblFechaDeSalida() {
		if (lblFechaDeSalida == null) {
			lblFechaDeSalida = new JLabel("Seleccione una fecha de salida:");
			lblFechaDeSalida.setDisplayedMnemonic('F');
			lblFechaDeSalida.setLabelFor(getCbFechas());
			lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblFechaDeSalida;
	}

	private JPanel getPnPlazasDoblesInteriores() {
		if (pnPlazasDoblesInteriores == null) {
			pnPlazasDoblesInteriores = new JPanel();
			FlowLayout fl_pnPlazasDoblesInteriores = (FlowLayout) pnPlazasDoblesInteriores
					.getLayout();
			fl_pnPlazasDoblesInteriores.setAlignment(FlowLayout.RIGHT);
			pnPlazasDoblesInteriores.add(getLblCamarotesDoblesInteriores());
			pnPlazasDoblesInteriores.add(getTxtPlazasDoblesInteriores());
		}
		return pnPlazasDoblesInteriores;
	}

	private JPanel getPnPlazasDoblesExteriores() {
		if (pnPlazasDoblesExteriores == null) {
			pnPlazasDoblesExteriores = new JPanel();
			FlowLayout fl_pnPlazasDoblesExteriores = (FlowLayout) pnPlazasDoblesExteriores
					.getLayout();
			fl_pnPlazasDoblesExteriores.setAlignment(FlowLayout.RIGHT);
			pnPlazasDoblesExteriores.add(getLblCamarotesDoblesExteriores());
			pnPlazasDoblesExteriores.add(getTxtPlazasDoblesExteriores());
		}
		return pnPlazasDoblesExteriores;
	}

	private JPanel getPnPlazasFamiliaresInteriores() {
		if (pnPlazasFamiliaresInteriores == null) {
			pnPlazasFamiliaresInteriores = new JPanel();
			FlowLayout fl_pnPlazasFamiliaresInteriores = (FlowLayout) pnPlazasFamiliaresInteriores
					.getLayout();
			fl_pnPlazasFamiliaresInteriores.setAlignment(FlowLayout.RIGHT);
			pnPlazasFamiliaresInteriores
					.add(getLblCamarotesFamiliarInteriores());
			pnPlazasFamiliaresInteriores
					.add(getTxtPlazasFamiliaresInteriores());
		}
		return pnPlazasFamiliaresInteriores;
	}

	private JPanel getPnPlazasFamiliaresExteriores() {
		if (pnPlazasFamiliaresExteriores == null) {
			pnPlazasFamiliaresExteriores = new JPanel();
			FlowLayout fl_pnPlazasFamiliaresExteriores = (FlowLayout) pnPlazasFamiliaresExteriores
					.getLayout();
			fl_pnPlazasFamiliaresExteriores.setAlignment(FlowLayout.RIGHT);
			pnPlazasFamiliaresExteriores.add(getLblCamarotesFamiliarExterior());
			pnPlazasFamiliaresExteriores
					.add(getTxtPlazasFamiliaresExteriores());
		}
		return pnPlazasFamiliaresExteriores;
	}

	private JPanel getPnTituloPrecios() {
		if (pnTituloPrecios == null) {
			pnTituloPrecios = new JPanel();
			FlowLayout fl_pnTituloPrecios = (FlowLayout) pnTituloPrecios
					.getLayout();
			fl_pnTituloPrecios.setAlignment(FlowLayout.LEFT);
			pnTituloPrecios.add(getLblPreciosDeCamarotes());
		}
		return pnTituloPrecios;
	}

	private JPanel getPnPreciosCamarotes() {
		if (pnPreciosCamarotes == null) {
			pnPreciosCamarotes = new JPanel();
			pnPreciosCamarotes.setLayout(new GridLayout(4, 0, 0, 0));
			pnPreciosCamarotes.add(getPnPrecioDobleInterior());
			pnPreciosCamarotes.add(getPnPrecioDobleExterior());
			pnPreciosCamarotes.add(getPnPrecioFamiliarInterior());
			pnPreciosCamarotes.add(getPnPrecioFamiliarExterior());
		}
		return pnPreciosCamarotes;
	}

	private JLabel getLblPreciosDeCamarotes() {
		if (lblPreciosDeCamarotes == null) {
			lblPreciosDeCamarotes = new JLabel("Precios de camarotes por dia:");
			lblPreciosDeCamarotes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPreciosDeCamarotes;
	}

	private JPanel getPnPrecioFamiliarExterior() {
		if (pnPrecioFamiliarExterior == null) {
			pnPrecioFamiliarExterior = new JPanel();
			FlowLayout fl_pnPrecioFamiliarExterior = (FlowLayout) pnPrecioFamiliarExterior
					.getLayout();
			fl_pnPrecioFamiliarExterior.setAlignment(FlowLayout.RIGHT);
			pnPrecioFamiliarExterior.add(getLblFamiliarExterior());
			pnPrecioFamiliarExterior.add(getTxtPrecioFamiliarExterior());
		}
		return pnPrecioFamiliarExterior;
	}

	private JPanel getPnPrecioDobleInterior() {
		if (pnPrecioDobleInterior == null) {
			pnPrecioDobleInterior = new JPanel();
			pnPrecioDobleInterior
					.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnPrecioDobleInterior.add(getLblDobleInterior());
			pnPrecioDobleInterior.add(getTxtPrecioDobleInterior());
		}
		return pnPrecioDobleInterior;
	}

	private JPanel getPnPrecioDobleExterior() {
		if (pnPrecioDobleExterior == null) {
			pnPrecioDobleExterior = new JPanel();
			FlowLayout fl_pnPrecioDobleExterior = (FlowLayout) pnPrecioDobleExterior
					.getLayout();
			fl_pnPrecioDobleExterior.setAlignment(FlowLayout.RIGHT);
			pnPrecioDobleExterior.add(getLblDobleExterior());
			pnPrecioDobleExterior.add(getTxtPrecioDobleExterior());
		}
		return pnPrecioDobleExterior;
	}

	private JPanel getPnPrecioFamiliarInterior() {
		if (pnPrecioFamiliarInterior == null) {
			pnPrecioFamiliarInterior = new JPanel();
			FlowLayout fl_pnPrecioFamiliarInterior = (FlowLayout) pnPrecioFamiliarInterior
					.getLayout();
			fl_pnPrecioFamiliarInterior.setAlignment(FlowLayout.RIGHT);
			pnPrecioFamiliarInterior.add(getLblFamiliarInterior());
			pnPrecioFamiliarInterior.add(getTxtPrecioFamiliarInterior());
		}
		return pnPrecioFamiliarInterior;
	}

	private JLabel getLblDobleInterior() {
		if (lblDobleInterior == null) {
			lblDobleInterior = new JLabel("Doble interior:");
			lblDobleInterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblDobleInterior;
	}

	private JTextField getTxtPrecioDobleInterior() {
		if (txtPrecioDobleInterior == null) {
			txtPrecioDobleInterior = new JTextField();
			txtPrecioDobleInterior.setToolTipText(
					"Muestra el precio de un camarote doble interior");
			txtPrecioDobleInterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPrecioDobleInterior.setEditable(false);
			txtPrecioDobleInterior.setColumns(10);
		}
		return txtPrecioDobleInterior;
	}

	private JLabel getLblDobleExterior() {
		if (lblDobleExterior == null) {
			lblDobleExterior = new JLabel("Doble exterior:");
			lblDobleExterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblDobleExterior;
	}

	private JTextField getTxtPrecioDobleExterior() {
		if (txtPrecioDobleExterior == null) {
			txtPrecioDobleExterior = new JTextField();
			txtPrecioDobleExterior.setToolTipText(
					"Muestra el precio de un camarote doble exterior");
			txtPrecioDobleExterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPrecioDobleExterior.setEditable(false);
			txtPrecioDobleExterior.setColumns(10);
		}
		return txtPrecioDobleExterior;
	}

	private JLabel getLblFamiliarInterior() {
		if (lblFamiliarInterior == null) {
			lblFamiliarInterior = new JLabel("Familiar interior:");
			lblFamiliarInterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblFamiliarInterior;
	}

	private JTextField getTxtPrecioFamiliarInterior() {
		if (txtPrecioFamiliarInterior == null) {
			txtPrecioFamiliarInterior = new JTextField();
			txtPrecioFamiliarInterior.setToolTipText(
					"Muestra el precio de un camarote familiar interior");
			txtPrecioFamiliarInterior
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPrecioFamiliarInterior.setEditable(false);
			txtPrecioFamiliarInterior.setColumns(10);
		}
		return txtPrecioFamiliarInterior;
	}

	private JLabel getLblFamiliarExterior() {
		if (lblFamiliarExterior == null) {
			lblFamiliarExterior = new JLabel("Familiar exterior:");
			lblFamiliarExterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblFamiliarExterior;
	}

	private JTextField getTxtPrecioFamiliarExterior() {
		if (txtPrecioFamiliarExterior == null) {
			txtPrecioFamiliarExterior = new JTextField();
			txtPrecioFamiliarExterior.setToolTipText(
					"Muestra el precio de un camarote familiar exterior");
			txtPrecioFamiliarExterior
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPrecioFamiliarExterior.setEditable(false);
			txtPrecioFamiliarExterior.setColumns(10);
		}
		return txtPrecioFamiliarExterior;
	}

	private JLabel getLblCamarotesDoblesInteriores() {
		if (lblCamarotesDoblesInteriores == null) {
			lblCamarotesDoblesInteriores = new JLabel(
					"Camarotes dobles interiores disponibles:");
			lblCamarotesDoblesInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesDoblesInteriores;
	}

	private JTextField getTxtPlazasDoblesInteriores() {
		if (txtPlazasDoblesInteriores == null) {
			txtPlazasDoblesInteriores = new JTextField();
			txtPlazasDoblesInteriores.setToolTipText(
					"Muestra el n\u00FAmero de camarotes dobles interiores disponibles");
			txtPlazasDoblesInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPlazasDoblesInteriores.setEditable(false);
			txtPlazasDoblesInteriores.setColumns(10);
		}
		return txtPlazasDoblesInteriores;
	}

	private JLabel getLblCamarotesDoblesExteriores() {
		if (lblCamarotesDoblesExteriores == null) {
			lblCamarotesDoblesExteriores = new JLabel(
					"Camarotes dobles exteriores disponibles:");
			lblCamarotesDoblesExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesDoblesExteriores;
	}

	private JTextField getTxtPlazasDoblesExteriores() {
		if (txtPlazasDoblesExteriores == null) {
			txtPlazasDoblesExteriores = new JTextField();
			txtPlazasDoblesExteriores.setToolTipText(
					"Muestra el n\u00FAmero de camarotes dobles exteriores disponibles");
			txtPlazasDoblesExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPlazasDoblesExteriores.setEditable(false);
			txtPlazasDoblesExteriores.setColumns(10);
		}
		return txtPlazasDoblesExteriores;
	}

	private JLabel getLblCamarotesFamiliarInteriores() {
		if (lblCamarotesFamiliarInteriores == null) {
			lblCamarotesFamiliarInteriores = new JLabel(
					"Camarotes familiar interiores disponibles:");
			lblCamarotesFamiliarInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesFamiliarInteriores;
	}

	private JTextField getTxtPlazasFamiliaresInteriores() {
		if (txtPlazasFamiliaresInteriores == null) {
			txtPlazasFamiliaresInteriores = new JTextField();
			txtPlazasFamiliaresInteriores.setToolTipText(
					"Muestra el n\u00FAmero de camarotes familiares interiores disponibles");
			txtPlazasFamiliaresInteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPlazasFamiliaresInteriores.setEditable(false);
			txtPlazasFamiliaresInteriores.setColumns(10);
		}
		return txtPlazasFamiliaresInteriores;
	}

	private JLabel getLblCamarotesFamiliarExterior() {
		if (lblCamarotesFamiliarExterior == null) {
			lblCamarotesFamiliarExterior = new JLabel(
					"Camarotes familiar exteriores disponibles:");
			lblCamarotesFamiliarExterior
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesFamiliarExterior;
	}

	private JTextField getTxtPlazasFamiliaresExteriores() {
		if (txtPlazasFamiliaresExteriores == null) {
			txtPlazasFamiliaresExteriores = new JTextField();
			txtPlazasFamiliaresExteriores.setToolTipText(
					"Muestra el n\u00FAmero de camarotes familiares exteriores disponibles");
			txtPlazasFamiliaresExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPlazasFamiliaresExteriores.setEditable(false);
			txtPlazasFamiliaresExteriores.setColumns(10);
		}
		return txtPlazasFamiliaresExteriores;
	}

	private JPanel getPnPasajeros() {
		if (pnPasajeros == null) {
			pnPasajeros = new JPanel();
			pnPasajeros.setLayout(new BorderLayout(0, 0));
			pnPasajeros.add(getPnTituloPasajeros(), BorderLayout.NORTH);
			pnPasajeros.add(getPnListaPasajeros(), BorderLayout.CENTER);
			pnPasajeros.add(getPnBotonesPasajeros(), BorderLayout.SOUTH);
		}
		return pnPasajeros;
	}

	private JPanel getPnTituloPasajeros() {
		if (pnTituloPasajeros == null) {
			pnTituloPasajeros = new JPanel();
			pnTituloPasajeros.setLayout(new GridLayout(2, 1, 0, 0));
			pnTituloPasajeros.add(getLblListaDePasajeros());
			pnTituloPasajeros.add(getLblPorFavorIntroduzca());
		}
		return pnTituloPasajeros;
	}

	private JPanel getPnListaPasajeros() {
		if (pnListaPasajeros == null) {
			pnListaPasajeros = new JPanel();
			pnListaPasajeros.setLayout(new BorderLayout(0, 0));
			pnListaPasajeros.add(getScPasajeros(), BorderLayout.CENTER);
			pnListaPasajeros.add(getPnBotonesModificarPasajeros(),
					BorderLayout.SOUTH);
			pnListaPasajeros.add(getPnEspacio1RegistroPasajeros(),
					BorderLayout.WEST);
			pnListaPasajeros.add(getPnEspacio2RegistroPasajeros(),
					BorderLayout.EAST);
		}
		return pnListaPasajeros;
	}

	private JPanel getPnBotonesPasajeros() {
		if (pnBotonesPasajeros == null) {
			pnBotonesPasajeros = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotonesPasajeros.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotonesPasajeros.add(getBtnAtrasPasajeros());
			pnBotonesPasajeros.add(getBtnSiguientePasajeros());
			pnBotonesPasajeros.add(getBtnCancelarPasajeros());
		}
		return pnBotonesPasajeros;
	}

	private JLabel getLblListaDePasajeros() {
		if (lblListaDePasajeros == null) {
			lblListaDePasajeros = new JLabel("Lista de pasajeros");
			lblListaDePasajeros.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaDePasajeros.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblListaDePasajeros;
	}

	private JButton getBtnAtrasPasajeros() {
		if (btnAtrasPasajeros == null) {
			btnAtrasPasajeros = new JButton("Atras");
			btnAtrasPasajeros.setToolTipText(
					"Vuelve a la pantalla de detalles del crucero");
			btnAtrasPasajeros.setMnemonic('A');
			btnAtrasPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAtrasPasajeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					borrarModelo(modeloTablaPasajeros);
					listaPasajeros = new ArrayList<Pasajero>();
					btnSiguientePasajeros.setEnabled(false);
					btnSiguienteListaCruceros.grabFocus();
					((CardLayout) pnReservas.getLayout()).previous(pnReservas);
					getCbFechas().grabFocus();
				}
			});
		}
		return btnAtrasPasajeros;
	}

	public void activarBtnSiguientePasajeros() {
		btnSiguientePasajeros.setEnabled(true);
	}

	public JButton getBtnSiguientePasajeros() {
		if (btnSiguientePasajeros == null) {
			btnSiguientePasajeros = new JButton("Siguiente");
			btnSiguientePasajeros.setToolTipText(
					"Muestra la ventana de reserva de camarotes");
			btnSiguientePasajeros.setMnemonic('S');
			btnSiguientePasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnSiguientePasajeros.setEnabled(false);
			btnAñadirPasajero.setEnabled(true);
			btnBorrarPasajero.setEnabled(false);
			btnSiguientePasajeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean mayor = false;
					for (Pasajero p : listaPasajeros) {
						if (!p.isMenor()) {
							mayor = true;
							break;
						}
					}
					if (mayor) {
						listaClientes = new ArrayList<Pasajero>();
						for (Pasajero p : listaPasajeros)
							listaClientes.add(p);
						((CardLayout) pnReservas.getLayout()).next(pnReservas);
						getBtnAñadirReservaCamarotes().grabFocus();
						btnBorrarReservaCamarotes.setEnabled(false);
						btnAñadirReservaCamarotes.setEnabled(true);
						btnSiguienteReservaCamarotes.setEnabled(false);
					} else
						JOptionPane.showMessageDialog(null,
								"Entre los pasajeros debe haber uno que sea mayor de edad",
								"Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
		return btnSiguientePasajeros;
	}

	private JButton getBtnCancelarPasajeros() {
		if (btnCancelarPasajeros == null) {
			btnCancelarPasajeros = new JButton("Cancelar");
			btnCancelarPasajeros.setToolTipText(
					"Borra todos los datos vuelve a la pantalla de inicio");
			btnCancelarPasajeros.setMnemonic('C');
			btnCancelarPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelarPasajeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
		}
		return btnCancelarPasajeros;
	}

	private JLabel getLblPorFavorIntroduzca() {
		if (lblPorFavorIntroduzca == null) {
			lblPorFavorIntroduzca = new JLabel(
					"Por favor introduzca a las personas que van a realizar el crucero:");
			lblPorFavorIntroduzca.setHorizontalAlignment(SwingConstants.CENTER);
			lblPorFavorIntroduzca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPorFavorIntroduzca;
	}

	private JScrollPane getScPasajeros() {
		if (scPasajeros == null) {
			scPasajeros = new JScrollPane();
			scPasajeros.setViewportView(getTablaPasajeros());
		}
		return scPasajeros;
	}

	private JPanel getPnBotonesModificarPasajeros() {
		if (pnBotonesModificarPasajeros == null) {
			pnBotonesModificarPasajeros = new JPanel();
			pnBotonesModificarPasajeros
					.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnBotonesModificarPasajeros.add(getBtnAñadirPasajero());
			pnBotonesModificarPasajeros.add(getBtnBorrarPasajero());
		}
		return pnBotonesModificarPasajeros;
	}

	private JTable getTablaPasajeros() {
		if (tablaPasajeros == null) {
			modeloTablaPasajeros = new DefaultTableModel(new Object[] {
					"Nombre", "Apellidos", "Dni", "Fecha de nacimiento" }, 0);
			tablaPasajeros = new JTable(modeloTablaPasajeros) {
				private static final long serialVersionUID = -3502508279470742363L;

				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			tablaPasajeros.getTableHeader().setReorderingAllowed(false);
			DefaultTableCellRenderer celda = new DefaultTableCellRenderer();
			celda.setHorizontalAlignment(SwingConstants.CENTER);
			tablaPasajeros.setDefaultRenderer(Object.class, celda);
		}
		return tablaPasajeros;
	}

	public DefaultTableModel getModeloListaPasajeros() {
		return modeloTablaPasajeros;
	}

	private JButton getBtnAñadirPasajero() {
		if (btnAñadirPasajero == null) {
			btnAñadirPasajero = new JButton("A\u00F1adir");
			btnAñadirPasajero.setToolTipText(
					"A\u00F1ade un pasajero a la lista de pasajero de la reserva");
			btnAñadirPasajero.setMnemonic('ñ');
			btnAñadirPasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAñadirPasajero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaAñadirPasajero();
				}
			});
		}
		return btnAñadirPasajero;
	}

	private void mostrarVentanaAñadirPasajero() {
		VentanaAñadirPasajero vap = new VentanaAñadirPasajero(this);
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
	}

	public JButton getBtnBorrarPasajero() {
		if (btnBorrarPasajero == null) {
			btnBorrarPasajero = new JButton("Borrar");
			btnBorrarPasajero.setToolTipText(
					"Borra al pasajero seleccionado de la lista de pasajeros de la reserva");
			btnBorrarPasajero.setMnemonic('B');
			btnBorrarPasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnBorrarPasajero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pasajero = tablaPasajeros.getSelectedRow();
					if (pasajero == -1)
						JOptionPane.showMessageDialog(null,
								"Por favor seleccione un pasajero", "Error",
								JOptionPane.ERROR_MESSAGE);
					else {
						modeloTablaPasajeros.removeRow(pasajero);
						listaPasajeros.remove(pasajero);
					}
					if (modeloTablaPasajeros.getRowCount() == 0) {
						btnSiguientePasajeros.setEnabled(false);
						btnBorrarPasajero.setEnabled(false);
					}
				}
			});
		}
		return btnBorrarPasajero;
	}

	private JPanel getPnEspacio1RegistroPasajeros() {
		if (pnEspacio1RegistroPasajeros == null) {
			pnEspacio1RegistroPasajeros = new JPanel();
			pnEspacio1RegistroPasajeros.add(getLblEspacio1RegistroPasajeros());
		}
		return pnEspacio1RegistroPasajeros;
	}

	private JPanel getPnEspacio2RegistroPasajeros() {
		if (pnEspacio2RegistroPasajeros == null) {
			pnEspacio2RegistroPasajeros = new JPanel();
			pnEspacio2RegistroPasajeros.add(getLblEspacio2RegistroPasajeros());
		}
		return pnEspacio2RegistroPasajeros;
	}

	private JLabel getLblEspacio1RegistroPasajeros() {
		if (lblEspacio1RegistroPasajeros == null) {
			lblEspacio1RegistroPasajeros = new JLabel(
					"                           ");
		}
		return lblEspacio1RegistroPasajeros;
	}

	private JLabel getLblEspacio2RegistroPasajeros() {
		if (lblEspacio2RegistroPasajeros == null) {
			lblEspacio2RegistroPasajeros = new JLabel(
					"                           ");
		}
		return lblEspacio2RegistroPasajeros;
	}

	public JComboBox<String> getCbFechas() {
		if (cbFechas == null) {
			cbFechas = new JComboBox<String>();
			cbFechas.setToolTipText(
					"Selecciona la fecha de partida del crucero");
			cbFechas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbFechas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (txtPlazasDoblesExteriores.getText().equals("0 libres")
							&& txtPlazasDoblesInteriores.getText()
									.equals("0 libres")
							&& txtPlazasFamiliaresExteriores.getText()
									.equals("0 libres")
							&& txtPlazasFamiliaresInteriores.getText()
									.equals("0 libres"))
						btnSiguienteDetallesCrucero.setEnabled(false);
					else
						btnSiguienteDetallesCrucero.setEnabled(true);
				}
			});
		}
		return cbFechas;
	}

	private JPanel getPnCamarotes() {
		if (pnCamarotes == null) {
			pnCamarotes = new JPanel();
			pnCamarotes.setLayout(new BorderLayout(0, 0));
			pnCamarotes.add(getPnTituloReservaCamarotes(), BorderLayout.NORTH);
			pnCamarotes.add(getPnEspacio1ReservaCamarotes(), BorderLayout.WEST);
			pnCamarotes.add(getPnEspacio2ReservaCamarotes(), BorderLayout.EAST);
			pnCamarotes.add(getPnListaCamarotes(), BorderLayout.CENTER);
			pnCamarotes.add(getPnBotonesReservaCamarotes(), BorderLayout.SOUTH);
		}
		return pnCamarotes;
	}

	private JPanel getPnBotonesReservaCamarotes() {
		if (pnBotonesReservaCamarotes == null) {
			pnBotonesReservaCamarotes = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotonesReservaCamarotes
					.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotonesReservaCamarotes.add(getBtnAtrasReservaCamarotes());
			pnBotonesReservaCamarotes.add(getBtnSiguienteReservaCamarotes());
			pnBotonesReservaCamarotes.add(getBtnCancelarReservaCamarotes());
		}
		return pnBotonesReservaCamarotes;
	}

	private JPanel getPnTituloReservaCamarotes() {
		if (pnTituloReservaCamarotes == null) {
			pnTituloReservaCamarotes = new JPanel();
			pnTituloReservaCamarotes.setLayout(new GridLayout(2, 1, 0, 0));
			pnTituloReservaCamarotes.add(getLblListaDeCamarotes());
			pnTituloReservaCamarotes.add(getLblPorFavorIntroduzca_1());
		}
		return pnTituloReservaCamarotes;
	}

	private JPanel getPnEspacio1ReservaCamarotes() {
		if (pnEspacio1ReservaCamarotes == null) {
			pnEspacio1ReservaCamarotes = new JPanel();
			pnEspacio1ReservaCamarotes.add(getLblEspacio1ReservaCamarotes());
		}
		return pnEspacio1ReservaCamarotes;
	}

	private JPanel getPnEspacio2ReservaCamarotes() {
		if (pnEspacio2ReservaCamarotes == null) {
			pnEspacio2ReservaCamarotes = new JPanel();
			pnEspacio2ReservaCamarotes
					.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnEspacio2ReservaCamarotes.add(getLblEspacio2ReservaCamarotes());
		}
		return pnEspacio2ReservaCamarotes;
	}

	private JLabel getLblEspacio1ReservaCamarotes() {
		if (lblEspacio1ReservaCamarotes == null) {
			lblEspacio1ReservaCamarotes = new JLabel(
					"                           ");
		}
		return lblEspacio1ReservaCamarotes;
	}

	private JLabel getLblEspacio2ReservaCamarotes() {
		if (lblEspacio2ReservaCamarotes == null) {
			lblEspacio2ReservaCamarotes = new JLabel(
					"                           ");
		}
		return lblEspacio2ReservaCamarotes;
	}

	private JLabel getLblListaDeCamarotes() {
		if (lblListaDeCamarotes == null) {
			lblListaDeCamarotes = new JLabel("Lista de camarotes");
			lblListaDeCamarotes.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaDeCamarotes.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblListaDeCamarotes;
	}

	private JButton getBtnAtrasReservaCamarotes() {
		if (btnAtrasReservaCamarotes == null) {
			btnAtrasReservaCamarotes = new JButton("Atras");
			btnAtrasReservaCamarotes.setToolTipText(
					"Vuelve a la pantalla de modificaci\u00F3n de la lista de pasajeros");
			btnAtrasReservaCamarotes.setMnemonic('A');
			btnAtrasReservaCamarotes
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAtrasReservaCamarotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listaClientes = null;
					borrarModelo(getModeloTablaCamarotes());
					Iterator<Camarote> it = listaCamarotes.iterator();
					while (it.hasNext())
						desreservarCamarote(it.next());
					listaCamarotes.clear();
					btnAñadirReservaCamarotes.setEnabled(false);
					btnBorrarPasajero.setEnabled(true);
					((CardLayout) pnReservas.getLayout()).previous(pnReservas);
					btnAñadirPasajero.grabFocus();
				}
			});
		}
		return btnAtrasReservaCamarotes;
	}

	public JButton getBtnSiguienteReservaCamarotes() {
		if (btnSiguienteReservaCamarotes == null) {
			btnSiguienteReservaCamarotes = new JButton("Siguiente");
			btnSiguienteReservaCamarotes.setMnemonic('S');
			btnSiguienteReservaCamarotes.setToolTipText(
					"Muestra la ventana para asignar a un pasajero la reserva");
			btnSiguienteReservaCamarotes
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnSiguienteReservaCamarotes.setEnabled(false);
			btnSiguienteReservaCamarotes
					.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							mostrarVentanaAsignarNombreReserva();
						}
					});
		}
		return btnSiguienteReservaCamarotes;
	}

	private void mostrarVentanaAsignarNombreReserva() {
		VentanaAsignarNombreReserva vap = new VentanaAsignarNombreReserva(this);
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
	}

	private JButton getBtnCancelarReservaCamarotes() {
		if (btnCancelarReservaCamarotes == null) {
			btnCancelarReservaCamarotes = new JButton("Cancelar");
			btnCancelarReservaCamarotes.setToolTipText(
					"Borra todos los datos vuelve a la pantalla de inicio");
			btnCancelarReservaCamarotes.setMnemonic('C');
			btnCancelarReservaCamarotes
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelarReservaCamarotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
		}
		return btnCancelarReservaCamarotes;
	}

	private JPanel getPnListaCamarotes() {
		if (pnListaCamarotes == null) {
			pnListaCamarotes = new JPanel();
			pnListaCamarotes.setLayout(new BorderLayout(0, 0));
			pnListaCamarotes.add(getScCamarotes(), BorderLayout.CENTER);
			pnListaCamarotes.add(getPnModificarListaCamarotes(),
					BorderLayout.SOUTH);
		}
		return pnListaCamarotes;
	}

	private JPanel getPnModificarListaCamarotes() {
		if (pnModificarListaCamarotes == null) {
			pnModificarListaCamarotes = new JPanel();
			pnModificarListaCamarotes.add(getBtnAñadirReservaCamarotes());
			pnModificarListaCamarotes.add(getBtnBorrarReservaCamarotes());
		}
		return pnModificarListaCamarotes;
	}

	private JScrollPane getScCamarotes() {
		if (scCamarotes == null) {
			scCamarotes = new JScrollPane();
			scCamarotes.setViewportView(getTablaCamarotes());
		}
		return scCamarotes;
	}

	public JTable getTablaCamarotes() {
		if (tablaCamarotes == null) {
			setModeloTablaCamarotes(new DefaultTableModel(new Object[] { "Tipo",
					"Situaciï¿½n", "Pasajeros", "Extras" }, 0));
			tablaCamarotes = new JTable(getModeloTablaCamarotes()) {
				private static final long serialVersionUID = 4283967148348124808L;

				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			tablaCamarotes.getTableHeader().setReorderingAllowed(false);
			DefaultTableCellRenderer celda = new DefaultTableCellRenderer();
			celda.setHorizontalAlignment(SwingConstants.CENTER);
			tablaCamarotes.setDefaultRenderer(Object.class, celda);
		}
		return tablaCamarotes;
	}

	public JButton getBtnAñadirReservaCamarotes() {
		if (btnAñadirReservaCamarotes == null) {
			btnAñadirReservaCamarotes = new JButton("A\u00F1adir");
			btnAñadirReservaCamarotes.setToolTipText(
					"A\u00F1ade un camarote a la lista de camarotes de la reserva");
			btnAñadirReservaCamarotes.setMnemonic('ñ');
			btnAñadirReservaCamarotes
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAñadirReservaCamarotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaAñadirCamarote();
				}
			});
		}
		return btnAñadirReservaCamarotes;
	}

	private void mostrarVentanaAñadirCamarote() {
		VentanaAñadirCamarote vap = new VentanaAñadirCamarote(this);
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
	}

	public JButton getBtnBorrarReservaCamarotes() {
		if (btnBorrarReservaCamarotes == null) {
			btnBorrarReservaCamarotes = new JButton("Borrar");
			btnBorrarReservaCamarotes.setEnabled(false);
			btnBorrarReservaCamarotes.setToolTipText(
					"Borra el camarote seleccionado de la lista de camarotes de la reserva");
			btnBorrarReservaCamarotes.setMnemonic('B');
			btnBorrarReservaCamarotes
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnBorrarReservaCamarotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int camarote = tablaCamarotes.getSelectedRow();
					if (camarote == -1)
						JOptionPane.showMessageDialog(null,
								"Por favor seleccione un camarote", "Error",
								JOptionPane.ERROR_MESSAGE);
					else {
						getModeloTablaCamarotes().removeRow(camarote);
						for (Pasajero pasajero : listaCamarotes.get(camarote)
								.getPasajeros())
							if (pasajero != null)
								listaClientes.add(pasajero);
						Camarote aux = buscarCamarote(
								listaCamarotes.get(camarote));
						desreservarCamarote(aux);
						listaCamarotes.remove(camarote);
					}
					if (getModeloTablaCamarotes().getRowCount() == 0) {
						btnSiguienteReservaCamarotes.setEnabled(false);
						btnBorrarReservaCamarotes.setEnabled(false);
					}

					if (!listaClientes.isEmpty()) {
						btnSiguienteReservaCamarotes.setEnabled(false);
						btnAñadirReservaCamarotes.setEnabled(true);
					}
				}
			});
		}
		return btnBorrarReservaCamarotes;
	}

	public Camarote buscarCamarote(Camarote camarote) {
		Camarote resultado = null;
		for (Camarote a : crucero.getPasajerosFechas()
				.get(cbFechas.getSelectedIndex())) {
			if (a.equals(camarote)) {
				resultado = a;
				break;
			}
		}
		return resultado;
	}

	public void desreservarCamarote(Camarote camarote) {
		camarote.setReservada(false);
		for (Extra extra : camarote.getExtras())
			extra.setAñadido(false);
		for (int i = 0; i < camarote.getPasajeros().length; i++)
			camarote.getPasajeros()[i] = null;
	}

	public Crucero getCrucero() {
		return crucero;
	}

	public DefaultTableModel getModeloTablaCamarotes() {
		return modeloTablaCamarotes;
	}

	private JPanel getPnResumen() {
		if (pnResumen == null) {
			pnResumen = new JPanel();
			pnResumen.setLayout(new BorderLayout(0, 0));
			pnResumen.add(getPnTituloResumen(), BorderLayout.NORTH);
			pnResumen.add(getPnDatosResumen(), BorderLayout.CENTER);
			pnResumen.add(getPnBotonesResumen(), BorderLayout.SOUTH);
			pnResumen.add(getLblEspacioResumen1(), BorderLayout.WEST);
			pnResumen.add(getLblEspacioResumen2(), BorderLayout.EAST);
		}
		return pnResumen;
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
					((CardLayout) pnReservas.getLayout()).previous(pnReservas);
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
					grabarReserva(cliente.getDni() + "_" + fecha);
					((CardLayout) pnReservas.getLayout()).next(pnReservas);
					getBtnFinalizar().grabFocus();
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
					inicializar();
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

	public ArrayList<Pasajero> getListaClientes() {
		return listaClientes;
	}

	public void crearResumen() {
		Calendar c = Calendar.getInstance();
		@SuppressWarnings("deprecation")
		String fecha = c.getTime().getDate() + "/"
				+ (c.getTime().getMonth() + 1) + "/"
				+ (c.getTime().getYear() + 1900);
		float precioCamarotes = 0, precioExtras = 0, precioDescuento = 0;
		String aux = "JUSTIFICANTE RESERVA - " + NOMBRE_EMPRESA + " - " + fecha
				+ "\n";
		for (int i = 0; i < 60; i++)
			aux += "- ";
		aux += "\n";
		aux += "NOMBRE: " + cliente.getNombre() + " " + cliente.getApellidos()
				+ "	" + "NIF: " + cliente.getDni() + "	TEL:" + numeroContacto
				+ "\n";
		aux += "	** DATOS DEL CRUCERO **\n";
		aux += "Crucero: " + crucero.getDenominacion() + " / "
				+ crucero.getCodigo() + "\n";
		aux += "Barco: " + crucero.getBarco().getDenominacion() + "\n";
		aux += "Fecha salida: " + cbFechas.getSelectedItem() + "\n";
		aux += "Dï¿½as: " + crucero.getDuracionDias() + "\n";
		aux += "Salida: " + crucero.getPuertoSalida() + "\n";
		aux += "N. Pasajeros: " + listaPasajeros.size() + "\n";
		aux += "Camarote:\n";
		String tipo = "", posicion = "";
		for (Camarote camarote : listaCamarotes) {
			precioCamarotes += camarote.getPrecio() * crucero.getDuracionDias();
			if (camarote.isTipo())
				tipo = "Familiar";
			else
				tipo = "Doble";
			if (camarote.isPosicion())
				posicion = "Interior";
			else
				posicion = "Exterior";
			aux += "1 " + tipo + " " + posicion + " / ";
			String extras = "";
			for (int i = 0; i < camarote.getExtras().size(); i++) {
				if (camarote.getExtras().get(i).isAñadido()) {
					extras += camarote.getExtras().get(i).getDescripcion()
							+ ", ";
					precioExtras += camarote.getExtras().get(i).getPrecio()
							* crucero.getDuracionDias();
				}
			}
			if (!extras.equals(""))
				aux += extras.substring(0, extras.length() - 2) + ";\n";
			else
				aux += aux.substring(0, aux.length() - 3) + "\n";
		}
		aux += "\n	** PAGADO RESERVA **\n";
		aux += "Camarotes:				" + precioCamarotes + " ï¿½\n";
		aux += "Extras:					" + precioExtras + " ï¿½\n";
		if (crucero.isDescuento()) {
			precioDescuento = (float) ((precioCamarotes + precioExtras) * 0.15);
			aux += "Descuento:				" + precioDescuento + " ï¿½\n";
		}
		aux += "\nImporte Total:				"
				+ (precioCamarotes + precioExtras - precioDescuento) + " ï¿½\n";
		txtAreaReserva.setText(aux);
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

	public void grabarReserva(String nombreFichero) {
		try {
			BufferedWriter fichero = new BufferedWriter(
					new FileWriter("files/reservas/" + nombreFichero + ".dat"));
			String[] linea = txtAreaReserva.getText().split("\n");
			for (int i = 0; i < linea.length; i++)
				fichero.write(linea[i] + "\r\n");
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private JPanel getPnFin() {
		if (pnFin == null) {
			pnFin = new JPanel();
			pnFin.setLayout(new GridLayout(2, 0, 0, 0));
			pnFin.add(getPnImagenFin());
			pnFin.add(getPnMensajeFin());
		}
		return pnFin;
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
					inicializar();
					getBtnComenzar().grabFocus();
				}
			});
		}
		return btnFinalizar;
	}

	public void inicializar() {
		crucero = null;
		cliente = null;
		numeroContacto = new String();
		for (Camarote camarote : listaCamarotes) {
			desreservarCamarote(camarote);
			listaCamarotes.remove(camarote);
		}
		listaPasajeros = new ArrayList<Pasajero>();
		pnPrincipal.removeAll();
		pnPrincipal.add(getPnOpciones(), BorderLayout.NORTH);
		pnPrincipal.add(getPnReservas(), BorderLayout.CENTER);
		borrarModelo(getModeloTablaCamarotes());
		borrarModelo(modeloTablaCruceros);
		borrarModelo(modeloTablaPasajeros);
		((CardLayout) pnReservas.getLayout()).first(pnReservas);
		btnSiguienteListaCruceros.setEnabled(false);
		btnSiguientePasajeros.setEnabled(false);
		btnSiguienteReservaCamarotes.setEnabled(false);
		getBtnComenzar().grabFocus();
	}

	public void borrarModelo(DefaultTableModel modelo) {
		while (modelo.getRowCount() > 0)
			modelo.removeRow(0);
	}

	private JLabel getLblPorFavorIntroduzca_1() {
		if (lblPorFavorIntroduzca_1 == null) {
			lblPorFavorIntroduzca_1 = new JLabel(
					"Por favor introduzca los camarotes que desee reservar");
			lblPorFavorIntroduzca_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPorFavorIntroduzca_1
					.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPorFavorIntroduzca_1;
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

	private JPanel getPnSeleccionSalida() {
		if (pnSeleccionSalida == null) {
			pnSeleccionSalida = new JPanel();
			pnSeleccionSalida
					.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnSeleccionSalida.add(getLblFechaDeSalida());
			pnSeleccionSalida.add(getCbFechas());
		}
		return pnSeleccionSalida;
	}

	private JPanel getPnDetallesBarco() {
		if (pnDetallesBarco == null) {
			pnDetallesBarco = new JPanel();
			pnDetallesBarco.add(getLblDetallesBarco());
			pnDetallesBarco.add(getBtnMostrar());
		}
		return pnDetallesBarco;
	}

	private JLabel getLblDetallesBarco() {
		if (lblDetallesBarco == null) {
			lblDetallesBarco = new JLabel("Detalles Barco:");
			lblDetallesBarco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblDetallesBarco;
	}

	private JButton getBtnMostrar() {
		if (btnMostrar == null) {
			btnMostrar = new JButton("Mostrar");
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaDetallesBarco();
				}

			});
			btnMostrar.setToolTipText(
					"Muestra todos los detalles del barco del crucero");
			btnMostrar.setMnemonic('M');
			btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return btnMostrar;
	}

	private void mostrarVentanaDetallesBarco() {
		VentanaDetallesBarco vap = new VentanaDetallesBarco(crucero);
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
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
		hb.enableHelpKey(pnPrincipal, "introduccion", hs);
		// Asigna la ayuda al componente
		hb.enableHelpOnButton(btnAyuda, "introduccion", hs);
		// Ayuda sensible al contexto
		hb.enableHelp(pnInicio, "pnInicio", hs);
		hb.enableHelp(pnListaCruceros, "pnListaCruceros", hs);
		hb.enableHelp(pnDetallesCrucero, "pnDetallesCrucero", hs);
		hb.enableHelp(pnPasajeros, "pnPasajeros", hs);
		hb.enableHelp(pnCamarotes, "pnCamarotes", hs);
		hb.enableHelp(pnResumen, "pnResumen", hs);
		hb.enableHelp(pnFin, "pnFin", hs);
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Pasajero getCliente() {
		return cliente;
	}

	public void setCrucero(Crucero crucero) {
		this.crucero = crucero;
	}

	public String[] getMeses() {
		return meses;
	}

	public void setMeses(String[] meses) {
		this.meses = meses;
	}

	public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}

	public void setListaClientes(ArrayList<Pasajero> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void setListaCamarotes(ArrayList<Camarote> listaCamarotes) {
		this.listaCamarotes = listaCamarotes;
	}

	public void setModeloTablaCamarotes(
			DefaultTableModel modeloTablaCamarotes) {
		this.modeloTablaCamarotes = modeloTablaCamarotes;
	}

}
