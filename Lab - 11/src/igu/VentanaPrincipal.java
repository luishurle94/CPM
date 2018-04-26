package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.DebugGraphics;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.SystemColor;
import java.util.List;

import logica.Inmobiliaria;
import logica.Mansion;

import igu.ModeloNoEditable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1;
	private Inmobiliaria inmobiliaria;
	private JPanel contentPane;
	private JLabel lblTitutlo;
	private JLabel lblIcono;
	private JTabbedPane tabbedPane;
	private JPanel panelVentas;
	private JPanel panelAlquiler;
	private JScrollPane scrollPaneMansiones;
	private JPanel panelFiltro;
	private JLabel lblIndiqueLasZonas;
	private JCheckBox cBNorte;
	private JCheckBox cBCentro;
	private JCheckBox cBSur;
	private JTable tablaMansiones;
	private ModeloNoEditable modeloTabla;
	private JScrollPane scrollPaneDescripcionMansiones;
	private JPanel pnMansionesAVisitar;
	private JPanel panelPagoInicial;
	private JScrollPane scrollPaneVisitas;
	private JPanel pnBotones;
	private JButton btnAñadir;
	private JButton btnEliminar;
	private JList listaVisitas;
	private JSpinner spinnerPorcentaje;
	private JTextArea txtareaDescripcion;
	private DefaultListModel<String> modeloLista;
	private JButton btnCalcular;
	private JTextArea txtAreaPrecioInicial;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistSilverSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		inmobiliaria = new Inmobiliaria();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/llave.JPG")));
		setTitle("Agencia inmobiliaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTitutlo());
		contentPane.add(getLblIcono());
		contentPane.add(getTabbedPane());
		contentPane.add(getScrollPane_1_1());
		contentPane.add(getPnMansionesAVisitar());
		contentPane.add(getPanelPagoInicial());
		contentPane.add(getBtnAceptar());
		contentPane.add(getBtnCancelar());
		setLocationRelativeTo(null);
		añadirFilas(cBNorte.isSelected(), cBCentro.isSelected(), cBSur.isSelected());
	}
	private JLabel getLblTitutlo() {
		if (lblTitutlo == null) {
			lblTitutlo = new JLabel("AGENCIA INMOBILIARIA EII");
			lblTitutlo.setForeground(Color.ORANGE);
			lblTitutlo.setFont(new Font("Tahoma", Font.PLAIN, 42));
			lblTitutlo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitutlo.setBounds(10, 11, 585, 90);
		}
		return lblTitutlo;
	}
	private JLabel getLblIcono() {
		if (lblIcono == null) {
			lblIcono = new JLabel("");
			lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
			lblIcono.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/llave.JPG")));
			lblIcono.setBounds(605, 11, 111, 90);
		}
		return lblIcono;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 111, 528, 307);
			tabbedPane.addTab("Venta de mansiones", null, getPanelVentas(), null);
			tabbedPane.setMnemonicAt(0, 86);
			tabbedPane.setDisplayedMnemonicIndexAt(0, 0);
			tabbedPane.addTab("Alquiler de mansiones", null, getPanelAlquiler(), null);
			tabbedPane.setMnemonicAt(1, 65);
			tabbedPane.setDisplayedMnemonicIndexAt(1, 0);
		}
		return tabbedPane;
	}
	private JPanel getPanelVentas() {
		if (panelVentas == null) {
			panelVentas = new JPanel();
			panelVentas.setLayout(new BorderLayout(0, 0));
			panelVentas.add(getScrollPane_1(), BorderLayout.CENTER);
			panelVentas.add(getPanelFiltro(), BorderLayout.NORTH);
		}
		return panelVentas;
	}
	private JPanel getPanelAlquiler() {
		if (panelAlquiler == null) {
			panelAlquiler = new JPanel();
		}
		return panelAlquiler;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPaneMansiones == null) {
			scrollPaneMansiones = new JScrollPane();
			scrollPaneMansiones.setViewportView(getTablaMansiones());
		}
		return scrollPaneMansiones;
	}
	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.add(getLblIndiqueLasZonas());
			panelFiltro.add(getCBNorte());
			panelFiltro.add(getCBCentro());
			panelFiltro.add(getCBSur());
		}
		return panelFiltro;
	}
	private JLabel getLblIndiqueLasZonas() {
		if (lblIndiqueLasZonas == null) {
			lblIndiqueLasZonas = new JLabel("Indique las zonas: ");
			lblIndiqueLasZonas.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIndiqueLasZonas.setForeground(Color.ORANGE);
		}
		return lblIndiqueLasZonas;
	}
	private JCheckBox getCBNorte() {
		if (cBNorte == null) {
			cBNorte = new JCheckBox("Norte");
			cBNorte.setForeground(Color.ORANGE);
			cBNorte.setFont(new Font("Tahoma", Font.BOLD, 16));
			cBNorte.setSelected(true);
			cBNorte.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					mostrarMansionesZona();
				}
			});
			
			
		}
		return cBNorte;
	}
	private JCheckBox getCBCentro() {
		if (cBCentro == null) {
			cBCentro = new JCheckBox("Centro");
			cBCentro.setForeground(Color.ORANGE);
			cBCentro.setFont(new Font("Tahoma", Font.BOLD, 16));
			cBCentro.setSelected(true);
			cBCentro.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					mostrarMansionesZona();
				}
			});
			
			
		}
		return cBCentro;
	}
	

	private JCheckBox getCBSur() {
		if (cBSur == null) {
			cBSur = new JCheckBox("Sur");
			cBSur.setForeground(Color.ORANGE);
			cBSur.setFont(new Font("Tahoma", Font.BOLD, 16));
			cBSur.setSelected(true);
			cBSur.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					mostrarMansionesZona();
				}
			});
			
		}
		return cBSur;
	}
	
	protected void mostrarMansionesZona() {
		modeloTabla.getDataVector().clear();
		añadirFilas(cBNorte.isSelected(), cBCentro.isSelected(), cBSur.isSelected());
		modeloTabla.fireTableDataChanged(); //repinta la tabla cuando queda vacia
		
	}
	
	private JTable getTablaMansiones() {
		if (tablaMansiones == null) {
			String[] nombreColumnas = {"Codigo", "Zona" , "Localidad", "Precio"};
			modeloTabla = new ModeloNoEditable(nombreColumnas, 0);
			tablaMansiones = new JTable(modeloTabla);
			tablaMansiones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String codigoSeleccionado = (String)tablaMansiones.getValueAt(tablaMansiones.getSelectedRow(), 0);
					txtareaDescripcion.setText(inmobiliaria.getDescripcionMansion(codigoSeleccionado));
					if(e.getClickCount() == 2 && !modeloLista.contains(codigoSeleccionado)){
						modeloLista.addElement(codigoSeleccionado);
					}}//cambiar el color a rojo del seleccionado
			});
			tablaMansiones.getTableHeader().setReorderingAllowed(false);
			tablaMansiones.setRowSorter(new TableRowSorter<DefaultTableModel>(modeloTabla));
			
			
		}
		return tablaMansiones;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPaneDescripcionMansiones == null) {
			scrollPaneDescripcionMansiones = new JScrollPane();
			scrollPaneDescripcionMansiones.setBounds(10, 429, 528, 103);
			scrollPaneDescripcionMansiones.setViewportView(getTxtareaDescripcion());
		}
		return scrollPaneDescripcionMansiones;
	}
	private JPanel getPnMansionesAVisitar() {
		if (pnMansionesAVisitar == null) {
			pnMansionesAVisitar = new JPanel();
			pnMansionesAVisitar.setBorder(new TitledBorder(null, "Mansiones a visitar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
			pnMansionesAVisitar.setBounds(548, 133, 188, 285);
			pnMansionesAVisitar.setLayout(new BorderLayout(0, 0));
			pnMansionesAVisitar.add(getScrollPaneVisitas(), BorderLayout.CENTER);
			pnMansionesAVisitar.add(getPnBotones(), BorderLayout.SOUTH);
		}
		return pnMansionesAVisitar;
	}
	private JPanel getPanelPagoInicial() {
		if (panelPagoInicial == null) {
			panelPagoInicial = new JPanel();
			panelPagoInicial.setBorder(new TitledBorder(null, "Pago inicial", TitledBorder.LEFT, TitledBorder.TOP, null, null));
			panelPagoInicial.setBounds(548, 424, 188, 108);
			panelPagoInicial.setLayout(null);
			panelPagoInicial.add(getSpinnerPorcentaje());
			panelPagoInicial.add(getBtnCalcular());
			panelPagoInicial.add(getTxtAreaPrecioInicial());
		}
		return panelPagoInicial;
	}
	private JScrollPane getScrollPaneVisitas() {
		if (scrollPaneVisitas == null) {
			scrollPaneVisitas = new JScrollPane();
			scrollPaneVisitas.setViewportView(getListaVisitas());
		}
		return scrollPaneVisitas;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotones.add(getBtnAñadir());
			pnBotones.add(getBtnEliminar());
		}
		return pnBotones;
	}
	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
		}
		return btnAñadir;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
		}
		return btnEliminar;
	}
	private JList getListaVisitas() {
		if (listaVisitas == null) {
			modeloLista = new DefaultListModel<String>();
			listaVisitas = new JList<String>(modeloLista);
		}
		return listaVisitas;
	}
	private JSpinner getSpinnerPorcentaje() {
		if (spinnerPorcentaje == null) {
			spinnerPorcentaje = new JSpinner();
			spinnerPorcentaje.setToolTipText("");
			spinnerPorcentaje.setModel(new SpinnerNumberModel(15, 5, 20, 1));
			spinnerPorcentaje.setBounds(10, 25, 60, 20);
		}
		return spinnerPorcentaje;
	}
	private JTextArea getTxtareaDescripcion() {
		if (txtareaDescripcion == null) {
			txtareaDescripcion = new JTextArea();
			txtareaDescripcion.setLineWrap(true);
			txtareaDescripcion.setDisabledTextColor(new Color(109, 109, 109));
			txtareaDescripcion.setBackground(Color.LIGHT_GRAY);
			txtareaDescripcion.setForeground(Color.BLACK);
			txtareaDescripcion.setEditable(false);
			txtareaDescripcion.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
			txtareaDescripcion.setWrapStyleWord(true);
		}
		return txtareaDescripcion;
	}
	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(80, 24, 89, 23);
		}
		return btnCalcular;
	}
	private JTextArea getTxtAreaPrecioInicial() {
		if (txtAreaPrecioInicial == null) {
			txtAreaPrecioInicial = new JTextArea();
			txtAreaPrecioInicial.setEditable(false);
			txtAreaPrecioInicial.setBounds(10, 75, 168, 22);
		}
		return txtAreaPrecioInicial;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(558, 548, 89, 23);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(657, 548, 89, 23);
		}
		return btnCancelar;
	}
	
	private void añadirFilas(boolean norte, boolean centro, boolean sur){
		Object[] nuevaFila = new Object[4];
		List<Mansion> relacionMansiones = inmobiliaria.getRelacionMansiones();
		for (Mansion m:relacionMansiones){
			String zonaM = m.getZona();
			if((norte&&zonaM.equals("Norte"))	|| (centro&&zonaM.equals("Centro"))	|| (sur&&zonaM.equals("Sur"))){
				nuevaFila[0] = m.getCodigo();
				nuevaFila[1] = m.getZona();
				nuevaFila[2] = m.getLocalidad();
				nuevaFila[3] = m.getPrecio();
				modeloTabla.addRow(nuevaFila);
			}
		}
	}
}
