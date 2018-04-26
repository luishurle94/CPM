package igu.PanelCardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import igu.VentanaPrincipal;
import igu.PanelesAuxiliares.PanelImagenRedimensionable;
import igu.VentanasAuxiliares.VentanaDetallesBarco;
import logica.Camarote;
import logica.Pasajero;

public class PanelDetallesCrucero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3012945132912013292L;
	private VentanaPrincipal vp;

	private JPanel pnDatosCrucero;
	private JPanel pnBotonesDetallesCrucero;
	private JPanel pnImagenFechas;
	private JPanel pnFechasSalida;
	private JPanel pnTituloFechaSalida;
	private JPanel pnPlazasDisponibles;
	private JPanel pnSeleccionSalida;
	private JPanel pnDescripcionPrecio;
	private JPanel pnDescripcion;
	private JPanel pnPrecio;
	private JPanel pnTituloPrecios;
	private JPanel pnPreciosCamarotes;
	private JPanel pnPrecioDobleInterior;
	private JPanel pnPrecioDobleExterior;
	private JPanel pnPrecioFamiliarInterior;
	private JPanel pnDetallesBarco;
	private PanelImagenRedimensionable pnImagen;
	private JLabel lblFechaDeSalida;
	private JLabel lblCamarotesFamiliarInteriores;
	private JLabel lblCamarotesFamiliarExterior;
	private JLabel lblDobleInterior;
	private JLabel lblDobleExterior;
	private JLabel lblFamiliarInterior;
	private JLabel lblFamiliarExterior;
	private JLabel lblCamarotesDoblesInteriores;
	private JLabel lblCamarotesDoblesExteriores;
	private JComboBox<String> cbFechas;
	private JTextField txtPlazasDoblesExteriores;
	private JTextField txtPlazasFamiliaresInteriores;
	private JTextField txtPlazasFamiliaresExteriores;
	private JTextField txtPlazasDoblesInteriores;
	private JTextField txtPrecioDobleInterior;
	private JTextField txtPrecioDobleExterior;
	private JTextField txtPrecioFamiliarInterior;
	private JTextField txtPrecioFamiliarExterior;
	private JButton btnAtrasDetallesCrucero;
	private JButton btnSiguienteDetallesCrucero;
	private JButton btnCancelarDetallesCrucero;
	private JPanel pnPrecioFamiliarExterior;
	private JButton btnSiguientePasajeros;
	private DefaultTableModel modeloTablaPasajeros;
	private JButton btnAñadirPasajero;
	private JButton btnBorrarPasajero;
	private JTable tablaPasajeros;
	private JLabel lblPreciosDeCamarotes;
	private JLabel lblDescripcionCrucero;
	private JScrollPane scDescripcion;
	private JTextArea txtAreaDescripcion;
	private JLabel lblDetallesBarco;
	private JButton btnMostrar;
	private JPanel pnPlazasDoblesInteriores;
	private JPanel pnPlazasDoblesExteriores;
	private JPanel pnPlazasFamiliaresInteriores;
	private JPanel pnPlazasFamiliaresExteriores;

	public PanelDetallesCrucero(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnDatosCrucero(), BorderLayout.CENTER);
		this.add(getPnBotonesDetallesCrucero(), BorderLayout.SOUTH);
		getCbFechas().grabFocus();
		if (txtPlazasDoblesExteriores.getText().equals("0 libres")
				&& txtPlazasDoblesInteriores.getText().equals("0 libres")
				&& txtPlazasFamiliaresExteriores.getText().equals("0 libres")
				&& txtPlazasFamiliaresInteriores.getText().equals("0 libres"))
			btnSiguienteDetallesCrucero.setEnabled(false);
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

	private JPanel getPnDescripcionPrecio() {
		if (pnDescripcionPrecio == null) {
			pnDescripcionPrecio = new JPanel();
			pnDescripcionPrecio.setLayout(new GridLayout(2, 0, 0, 0));
			pnDescripcionPrecio.add(getPnDescripcion());
			pnDescripcionPrecio.add(getPnPrecio());
		}
		return pnDescripcionPrecio;
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

	private JLabel getLblCamarotesDoblesExteriores() {
		if (lblCamarotesDoblesExteriores == null) {
			lblCamarotesDoblesExteriores = new JLabel(
					"Camarotes dobles exteriores disponibles:");
			lblCamarotesDoblesExteriores
					.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblCamarotesDoblesExteriores;
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
					for (Pasajero p : vp.getListaPasajeros()) {
						if (!p.isMenor()) {
							mayor = true;
							break;
						}
					}
					if (mayor) {
						vp.setListaClientes(new ArrayList<Pasajero>());
						for (Pasajero p : vp.getListaPasajeros())
							vp.getListaClientes().add(p);
						((CardLayout) vp.getPnReservas().getLayout())
								.next(vp.getPnReservas());

					} else
						JOptionPane.showMessageDialog(null,
								"Entre los pasajeros debe haber uno que sea mayor de edad",
								"Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
		return btnSiguientePasajeros;
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
						vp.getListaPasajeros().remove(pasajero);
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

	private JLabel getLblPreciosDeCamarotes() {
		if (lblPreciosDeCamarotes == null) {
			lblPreciosDeCamarotes = new JLabel("Precios de camarotes por dia:");
			lblPreciosDeCamarotes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPreciosDeCamarotes;
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

	private JLabel getLblDescripcionCrucero() {
		if (lblDescripcionCrucero == null) {
			lblDescripcionCrucero = new JLabel("Descripci\u00F3n del Crucero:");
			lblDescripcionCrucero.setLabelFor(getTxtAreaDescripcion());
			lblDescripcionCrucero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblDescripcionCrucero;
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

	private JScrollPane getScDescripcion() {
		if (scDescripcion == null) {
			scDescripcion = new JScrollPane();
			scDescripcion.setViewportView(getTxtAreaDescripcion());
		}
		return scDescripcion;
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
					((CardLayout) vp.getPnReservas().getLayout())
							.previous(vp.getPnReservas());
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
					((CardLayout) vp.getPnReservas().getLayout())
							.next(vp.getPnReservas());
					// getBtnAñadirPasajero().grabFocus();
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
					vp.inicializar();
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

	private JPanel getPnTituloFechaSalida() {
		if (pnTituloFechaSalida == null) {
			pnTituloFechaSalida = new JPanel();
			pnTituloFechaSalida.setLayout(new GridLayout(2, 1, 0, 0));
			pnTituloFechaSalida.add(getPnSeleccionSalida());
			pnTituloFechaSalida.add(getPnDetallesBarco());
		}
		return pnTituloFechaSalida;
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

	private JLabel getLblFechaDeSalida() {
		if (lblFechaDeSalida == null) {
			lblFechaDeSalida = new JLabel("Seleccione una fecha de salida:");
			lblFechaDeSalida.setDisplayedMnemonic('F');
			lblFechaDeSalida.setLabelFor(getCbFechas());
			lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblFechaDeSalida;
	}

	private JPanel getPnDetallesBarco() {
		if (pnDetallesBarco == null) {
			pnDetallesBarco = new JPanel();
			pnDetallesBarco.add(getLblDetallesBarco());
			pnDetallesBarco.add(getBtnMostrar());
		}
		return pnDetallesBarco;
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
		VentanaDetallesBarco vap = new VentanaDetallesBarco(vp.getCrucero());
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
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

	void cargarCrucero() {
		if (vp.getCrucero() != null) {
			txtAreaDescripcion.setText(vp.getCrucero().getDescripcion());
			cbFechas.setModel(new DefaultComboBoxModel<String>(
					vp.getCrucero().getFechas()));
			comprobarPlazasDisponibleCrucero();
			txtPrecioDobleExterior
					.setText(""
							+ vp.getCrucero().getBarco()
									.getPrecioCamarotesDoblesExteriores()
							+ " â‚¬");
			txtPrecioDobleInterior
					.setText(""
							+ vp.getCrucero().getBarco()
									.getPrecioCamarotesDoblesInteriores()
							+ " â‚¬");
			txtPrecioFamiliarExterior
					.setText(""
							+ vp.getCrucero().getBarco()
									.getPrecioCamarotesFamiliaresExteriores()
							+ " â‚¬");
			txtPrecioFamiliarInterior
					.setText(""
							+ vp.getCrucero().getBarco()
									.getPrecioCamarotesFamiliaresInteriores()
							+ " â‚¬");
			cambiarImagen();
		}
	}

	private void comprobarPlazasDisponibleCrucero() {
		ArrayList<Camarote> camarotes = vp.getCrucero().getPasajerosFechas()
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
		pnImagen = new PanelImagenRedimensionable(vp.getCrucero().getCodigo());
		pnImagen.setLayout(new GridLayout(1, 0, 0, 0));
		pnImagenFechas.add(getPnImagen());
		pnImagenFechas.add(getPnFechasSalida());
	}
}
