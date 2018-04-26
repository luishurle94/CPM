package igu.PanelCardLayout;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;

import igu.VentanaPrincipal;
import igu.PanelCardLayout.util.FiltrosCruceros;
import igu.PanelCardLayout.util.RadioButtonEditor;
import igu.PanelCardLayout.util.RadioButtonRenderer;
import logica.Crucero;

public class PanelListaCruceros extends JPanel {

	private static final long serialVersionUID = 4598024009655129251L;
	private ButtonGroup grupoBotonesFiltros, grupoBotonesTabla;
	private JPanel pnTitulo;
	private JLabel lblListaCrucerosDisponibles;
	private JPanel pnTablaCruceros;
	private JPanel pnFiltros;
	private JPanel pnTituloSeleccionarCrucero;
	private JScrollPane scListaCruceros;
	private DefaultTableModel modeloTablaCruceros;
	private JTable tablaCruceros;
	private JButton btnSiguienteListaCruceros;
	private JComboBox<String> cbOpcionesFiltros;
	private JPanel pnOpcionesFiltros;
	private JPanel pnFiltrosTodos;
	private JPanel pnSeleccionFiltros;
	private JLabel lblPorFavorSeleccione;
	private JScrollPane scOpcionesFiltros;
	private JPanel pnBotones;
	private JLabel lblSeleccionarCrucero;
	private JButton btnCancelarListaCruceros;

	private VentanaPrincipal vp;

	public PanelListaCruceros(VentanaPrincipal vp) {
		this.setVp(vp);
		getCbOpciones().grabFocus();
		grupoBotonesFiltros = new ButtonGroup();
		grupoBotonesTabla = new ButtonGroup();
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnTitulo(), BorderLayout.NORTH);
		this.add(getPnTablaCruceros(), BorderLayout.CENTER);
		this.add(getPnBotones(), BorderLayout.SOUTH);
		crearFiltros();
		agregarTodo();
		btnSiguienteListaCruceros.setEnabled(false);
		cbOpcionesFiltros.setSelectedIndex(0);
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

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new BorderLayout(0, 0));
			pnFiltros.add(getPnTituloSeleccionarCrucero(), BorderLayout.NORTH);
			pnFiltros.add(getPnFiltrosTodos(), BorderLayout.CENTER);
		}
		return pnFiltros;
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

	private JScrollPane getScOpcionesFiltros() {
		if (scOpcionesFiltros == null) {
			scOpcionesFiltros = new JScrollPane();
			scOpcionesFiltros.setViewportView(getPnOpcionesFiltros());
		}
		return scOpcionesFiltros;
	}

	private JPanel getPnSeleccionFiltros() {
		if (pnSeleccionFiltros == null) {
			pnSeleccionFiltros = new JPanel();
			pnSeleccionFiltros.add(getLblPorFavorSeleccione());
			pnSeleccionFiltros.add(getCbOpciones());
		}
		return pnSeleccionFiltros;
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

	private JPanel getPnTituloSeleccionarCrucero() {
		if (pnTituloSeleccionarCrucero == null) {
			pnTituloSeleccionarCrucero = new JPanel();
			pnTituloSeleccionarCrucero.add(getLblSeleccionarCrucero());
		}
		return pnTituloSeleccionarCrucero;
	}

	private JLabel getLblSeleccionarCrucero() {
		if (lblSeleccionarCrucero == null) {
			lblSeleccionarCrucero = new JLabel(
					"Por favor seleccione un crucero:");
			lblSeleccionarCrucero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblSeleccionarCrucero;
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

	JButton getBtnSiguienteListaCruceros() {
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
							for (int j = 0; j < getVp().getCatalogo()
									.getCruceros().size(); j++) {
								if (getVp().getCatalogo().getCruceros().get(j)
										.getZona()
										.equals(cruceroSeleccionado[0])
										&& getVp().getCatalogo().getCruceros()
												.get(j).getPuertoSalida()
												.equals(cruceroSeleccionado[1])
										&& getVp().getCatalogo().getCruceros()
												.get(j).getItinerario()
												.equals(cruceroSeleccionado[2])
										&& cruceroSeleccionado[3].equals(getVp()
												.getCatalogo().getCruceros()
												.get(j).getDuracionDias())
										&& getVp().getCatalogo().getCruceros()
												.get(j).getBarco()
												.getDenominacion()
												.equals(cruceroSeleccionado[4])) {
									getVp().setCrucero(getVp().getCatalogo()
											.getCruceros().get(j));
								}
							}
							break;
						}
					}
					if (getVp().getCrucero() != null) {
						vp.cargarCrucero();
						((CardLayout) getVp().getPnReservas().getLayout())
								.next(getVp().getPnReservas());
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
					getVp().inicializar();
				}
			});
		}
		return btnCancelarListaCruceros;
	}

	private JScrollPane getScListaCruceros() {
		if (scListaCruceros == null) {
			scListaCruceros = new JScrollPane();
			scListaCruceros.setViewportView(getTablaCruceros());
		}
		return scListaCruceros;
	}

	private JTable getTablaCruceros() {
		if (tablaCruceros == null) {
			setModeloTablaCruceros(new DefaultTableModel(
					new Object[] { "Zona", "Puerto de salida", "Itinerario",
							"AdmisiÃ³n de menores", "Dias de duraciÃ³n",
							"Fechas", "Barco", "Descuento", "Seleccionado" },
					0));
			tablaCruceros = new JTable(getModeloTablaCruceros()) {
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

	private void crearFiltros() {
		if (getCbOpcionesFiltros().getSelectedItem().equals("Zona")) {
			cargarFiltrosZona();
			asignarMnemonicosFiltros();
		} else if (getCbOpcionesFiltros().getSelectedItem()
				.equals("Puerto de salida")) {
			cargarFiltrosPuertoSalida();
			asignarMnemonicosFiltros();
		} else if (getCbOpcionesFiltros().getSelectedItem()
				.equals("Itinerario")) {
			cargarFiltrosItinerario();
			asignarMnemonicosFiltros();
		} else if (getCbOpcionesFiltros().getSelectedItem()
				.equals("AdmisiÃ³n de menores")) {
			cargarFiltrosMenores();
			asignarMnemonicosFiltros();
		} else if (getCbOpcionesFiltros().getSelectedItem()
				.equals("Dias de duraciÃ³n"))
			cargarFiltrosDiasDuracion();
		else if (getCbOpcionesFiltros().getSelectedItem().equals("Fechas"))
			cargarFiltrosFechas();
		else if (getCbOpcionesFiltros().getSelectedItem().equals("Barco")) {
			cargarFiltrosBarco();
			asignarMnemonicosFiltros();
		} else if (getCbOpcionesFiltros().getSelectedItem()
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
		for (Crucero a : getVp().getCatalogo().getCruceros())
			if (!filtros.contains(a.getZona()))
				filtros.add(a.getZona());
		añadirRadioBoton(filtros);
	}

	private void añadirRadioBoton(ArrayList<String> filtros) {
		for (String a : filtros) {
			JRadioButton radio = new JRadioButton(a);
			radio.addActionListener(new FiltrosCruceros(this));
			grupoBotonesFiltros.add(radio);
			pnOpcionesFiltros.add(radio);
		}
		JRadioButton radio = new JRadioButton("Todos", true);
		radio.addActionListener(new FiltrosCruceros(this));
		grupoBotonesFiltros.add(radio);
		pnOpcionesFiltros.add(radio);
	}

	JComboBox<String> getCbOpciones() {
		if (getCbOpcionesFiltros() == null) {
			String[] opciones = { "Zona", "Puerto de salida", "Itinerario",
					"AdmisiÃ³n de menores", "Dias de duraciÃ³n", "Fechas",
					"Barco", "Precio de camarote" };
			setCbOpcionesFiltros(new JComboBox<String>());
			getCbOpcionesFiltros().setToolTipText(
					"Selecciona la caracteristica por la cual se van ha filtrar los cruceros");
			getCbOpcionesFiltros().setFont(new Font("Tahoma", Font.PLAIN, 12));
			getCbOpcionesFiltros().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inicializarTablaCruceros();
				}
			});
			getCbOpcionesFiltros()
					.setModel(new DefaultComboBoxModel<String>(opciones));
		}
		return getCbOpcionesFiltros();
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

	private void borrarTabla() {
		while (getModeloTablaCruceros().getRowCount() > 0) {
			getModeloTablaCruceros().removeRow(0);
		}
	}

	public JPanel getPnOpcionesFiltros() {
		if (pnOpcionesFiltros == null) {
			pnOpcionesFiltros = new JPanel();
			pnOpcionesFiltros.setLayout(new GridLayout(0, 2, 0, 0));
		}
		return pnOpcionesFiltros;
	}

	private void agregarCrucerosTabla() {
		borrarTabla();
		if (getCbOpcionesFiltros().getSelectedIndex() == 0)
			agregarTablaZona();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 1)
			agregarTablaPuertoSalida();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 2)
			agregarTablaItinerario();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 3)
			agregarTablaMenores();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 4)
			agregarTablaDiasDuracion();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 5)
			agregarTablaFechas();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 6)
			agregarTablaBarco();
		else if (getCbOpcionesFiltros().getSelectedIndex() == 7)
			agregarTablaPrecio();
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
			for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
				if (crucero.getZona().equals(filtro)) {
					añadirCruceroTabla(crucero);
				}
			}
		}
	}

	public void agregarTablaPuertoSalida() {
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
			for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
				if (crucero.getPuertoSalida().equals(filtro)) {
					añadirCruceroTabla(crucero);
				}
			}
		}
	}

	public void agregarTablaItinerario() {
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
			for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
				String[] ciudades = crucero.getItinerario().split("-");
				for (String ciudad : ciudades)
					if (ciudad.equals(filtro)) {
						añadirCruceroTabla(crucero);
					}
			}
		}
	}

	public void agregarTablaMenores() {
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
		for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
			if (crucero.isMenores() == admisionMenores) {
				añadirCruceroTabla(crucero);
			}
		}
	}

	public void agregarTablaDiasDuracion() {
		JSlider radio = (JSlider) pnOpcionesFiltros.getComponent(0);
		int dias = radio.getValue();
		for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
			if (crucero.getDuracionDias() <= dias) {
				añadirCruceroTabla(crucero);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void agregarTablaFechas() {
		JComboBox<String> combo = (JComboBox<String>) pnOpcionesFiltros
				.getComponent(0);
		String seleccion = (String) combo.getSelectedItem();
		String[] aux2 = seleccion.split(" ");
		for (int i = 0; i < getVp().getMeses().length; i++) {
			if (getVp().getMeses()[i].equals(aux2[0])) {
				aux2[0] = "" + (i + 1);
				break;
			}
		}
		seleccion = aux2[0] + "/" + aux2[1];
		ArrayList<Crucero> cruceros = new ArrayList<Crucero>();
		for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
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

	public void agregarTablaBarco() {
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
			for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
				if (crucero.getBarco().getDenominacion().equals(filtro)) {
					añadirCruceroTabla(crucero);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void agregarTablaPrecio() {
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
		for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
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

	public void añadirCruceroTabla(Crucero crucero) {
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
		getModeloTablaCruceros().addRow(new Object[] { crucero.getZona(),
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

	public void agregarTodo() {
		for (Crucero crucero : getVp().getCatalogo().getCruceros())
			añadirCruceroTabla(crucero);
	}

	private void cargarFiltrosPuertoSalida() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : getVp().getCatalogo().getCruceros())
			if (!filtros.contains(a.getPuertoSalida()))
				filtros.add(a.getPuertoSalida());
		añadirRadioBoton(filtros);
	}

	private void cargarFiltrosItinerario() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : getVp().getCatalogo().getCruceros())
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
		radio.addActionListener(new FiltrosCruceros(this));
		grupoBotonesFiltros.add(radio);
		pnOpcionesFiltros.add(radio);
		JRadioButton radio2 = new JRadioButton("No");
		radio2.addActionListener(new FiltrosCruceros(this));
		grupoBotonesFiltros.add(radio2);
		pnOpcionesFiltros.add(radio2);
	}

	private void cargarFiltrosDiasDuracion() {
		int max = 0, min = Integer.MAX_VALUE;
		for (Crucero a : getVp().getCatalogo().getCruceros()) {
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
		for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
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
				salidas[i] = getVp().getMeses()[i] + " " + anioMin;
			else
				salidas[i] = getVp().getMeses()[i - 12] + " " + (anioMin + 1);
		}
		mesesSalidasCruceros.addActionListener(new FiltrosCruceros(this));
		pnOpcionesFiltros.add(mesesSalidasCruceros);
		mesesSalidasCruceros
				.setModel(new DefaultComboBoxModel<String>(salidas));
	}

	private void cargarFiltrosBarco() {
		ArrayList<String> filtros = new ArrayList<String>();
		for (Crucero a : getVp().getCatalogo().getCruceros())
			if (!filtros.contains(a.getBarco().getDenominacion()))
				filtros.add(a.getBarco().getDenominacion());
		añadirRadioBoton(filtros);
	}

	private void cargarFiltrosPrecio() {
		float precioMaximo = 0;
		for (Crucero crucero : getVp().getCatalogo().getCruceros()) {
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
			precios.add("" + precioMaximo + " â‚¬");
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
		cbDesdePrecio.addActionListener(new FiltrosCruceros(this));
		cbHastaPrecio.addActionListener(new FiltrosCruceros(this));
	}

	public JComboBox<String> getCbOpcionesFiltros() {
		return cbOpcionesFiltros;
	}

	public void setCbOpcionesFiltros(JComboBox<String> cbOpcionesFiltros) {
		this.cbOpcionesFiltros = cbOpcionesFiltros;
	}

	public DefaultTableModel getModeloTablaCruceros() {
		return modeloTablaCruceros;
	}

	public void setModeloTablaCruceros(DefaultTableModel modeloTablaCruceros) {
		this.modeloTablaCruceros = modeloTablaCruceros;
	}

	public VentanaPrincipal getVp() {
		return vp;
	}

	public void setVp(VentanaPrincipal vp) {
		this.vp = vp;
	}
}
