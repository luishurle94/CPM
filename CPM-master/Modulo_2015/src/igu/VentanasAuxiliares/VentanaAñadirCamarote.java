package igu.VentanasAuxiliares;

import igu.VentanaPrincipal;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import logica.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class VentanaAñadirCamarote extends JDialog {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal vp;
	private JPanel pnPrincipal;
	private JPanel pnTitulo;
	private JPanel pnDatosCrucero;
	private JPanel pnBotones;
	private JLabel lblAñadirCamarote;
	private JButton btnAñadir;
	private JButton btnCancelar;
	private JPanel pnTipoSituacion;
	private JPanel pnTipo;
	private JPanel pnSituacion;
	private JLabel lblTipo;
	private JComboBox<String> cbTipo;
	private JLabel lblSituacion;
	private JComboBox<String> cbSituacion;
	private JPanel pnExtras;
	private JPanel pnPasajeros;
	private JPanel pnCamaSupletoria;
	private JCheckBox chckbxCamaSupletoria;
	private JComboBox<Pasajero> cbPasajerosMenoresEdad;
	private JPanel pnRestoExtras;
	private JPanel pnSeleccionPasajeros;
	private JScrollPane pnPasajerosCamarote;
	private JTable tablaPasajeros;
	private JLabel lblSeleccioneUnPasajero;
	private JComboBox<Pasajero> cbPasajeros;
	private JPanel pnBotonesSeleccionPasajeros;
	private JButton btnAgregarPasajero;
	private JButton btnBorrarPasajero;
	private DefaultTableModel modeloTablaPasajeros;
	private DefaultComboBoxModel<Pasajero> modeloComboMenores;
	private DefaultComboBoxModel<Pasajero> modeloComboPasajeros;
	private ArrayList<Pasajero> pasajerosCamarote;
	private DefaultComboBoxModel<String> modeloComboTipo;
	private DefaultComboBoxModel<String> modeloComboPosicion;
	private int ancho;
	private int alto;

	public VentanaAñadirCamarote(VentanaPrincipal vp) {
		setTitle("A\u00F1adir camarote");
		this.vp = vp;
		ancho = 0;
		alto = 0;
		pasajerosCamarote = new ArrayList<Pasajero>();
		setBounds(100, 100, 615, 500);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnTitulo(), BorderLayout.NORTH);
		pnPrincipal.add(getPnDatosCrucero(), BorderLayout.CENTER);
		pnPrincipal.add(getPnBotones(), BorderLayout.SOUTH);
		modeloComboPasajeros = new DefaultComboBoxModel<Pasajero>();
		for (int i = 0; i < vp.getListaClientes().size(); i++)
			modeloComboPasajeros.addElement(vp.getListaClientes().get(i));
		cbPasajeros.setModel(modeloComboPasajeros);
		añadirExtras();
		comprobarModelos();
		getCbTipo().grabFocus();
		cargaAyuda();
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.add(getLblAñadirCamarote());
		}
		return pnTitulo;
	}

	private JPanel getPnDatosCrucero() {
		if (pnDatosCrucero == null) {
			pnDatosCrucero = new JPanel();
			pnDatosCrucero.setLayout(new BorderLayout(0, 0));
			pnDatosCrucero.add(getPnTipoSituacion(), BorderLayout.NORTH);
			pnDatosCrucero.add(getPnPasajeros(), BorderLayout.CENTER);
			pnDatosCrucero.add(getPnExtras(), BorderLayout.SOUTH);
		}
		return pnDatosCrucero;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtnAñadir());
			pnBotones.add(getBtnCancelar());
		}
		return pnBotones;
	}

	private JLabel getLblAñadirCamarote() {
		if (lblAñadirCamarote == null) {
			lblAñadirCamarote = new JLabel("A\u00F1adir camarote");
			lblAñadirCamarote.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblAñadirCamarote;
	}

	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
			btnAñadir.setToolTipText(
					"Añade al camarote a la lista de camarote de la reserva");
			btnAñadir.setMnemonic('A');
			btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAñadir.setEnabled(false);
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean tipo = false, posicion = false, valido = false;
					String tipo2 = "";
					int plazas;
					if (cbTipo.getSelectedItem().equals("Doble")) {
						plazas = 2;
						tipo2 = "Doble";
					} else {
						tipo2 = "Familiar";
						plazas = 4;
					}

					if (cbTipo.getSelectedItem().equals("Familiar"))
						tipo = true;
					if (cbSituacion.getSelectedItem().equals("Interior"))
						posicion = true;
					ArrayList<Camarote> arrayCamarotes = vp.getCrucero()
							.getPasajerosFechas()
							.get(vp.getCbFechas().getSelectedIndex());
					for (int i = 0; i < arrayCamarotes.size(); i++) {
						if (arrayCamarotes.get(i).isTipo() == tipo
								&& arrayCamarotes.get(i)
										.isPosicion() == posicion
								&& !arrayCamarotes.get(i).isReservada()) {
							for (int j = 0; j < tablaPasajeros
									.getRowCount(); j++) {
								if (tablaPasajeros.getValueAt(j, 0).equals(
										pasajerosCamarote.get(j).getNombre())
										&& tablaPasajeros.getValueAt(j, 1)
												.equals(pasajerosCamarote.get(j)
														.getApellidos())
										&& tablaPasajeros.getValueAt(j, 2)
												.equals(pasajerosCamarote.get(j)
														.getDni())
										&& tablaPasajeros.getValueAt(j, 3)
												.equals(pasajerosCamarote.get(j)
														.getFechaNacimiento())) {
									arrayCamarotes.get(i)
											.getPasajeros()[plazas] = pasajerosCamarote
													.get(j);
									plazas--;
								}
							}
							if (chckbxCamaSupletoria.isSelected())
								arrayCamarotes.get(i)
										.getPasajeros()[plazas] = (Pasajero) cbPasajerosMenoresEdad
												.getSelectedItem();
							arrayCamarotes.get(i).setReservada(true);

							int altoPasajero = 0, anchoPasajeros = 0;
							String pasajeros = "<html>";
							for (int x = 0; x < arrayCamarotes.get(i)
									.getPasajeros().length; x++) {
								if (arrayCamarotes.get(i)
										.getPasajeros()[x] != null) {
									pasajeros += arrayCamarotes.get(i)
											.getPasajeros()[x].getNombre()
											+ " "
											+ arrayCamarotes.get(i)
													.getPasajeros()[x]
															.getApellidos()
											+ " Dni: "
											+ arrayCamarotes.get(i)
													.getPasajeros()[x].getDni()
											+ "<br>";
									altoPasajero++;
									anchoPasajeros += 12
											+ arrayCamarotes.get(i)
													.getPasajeros()[x]
															.getNombre()
															.length()
											+ arrayCamarotes.get(i)
													.getPasajeros()[x]
															.getApellidos()
															.length()
											+ arrayCamarotes.get(i)
													.getPasajeros()[x].getDni()
															.length();
								}
								if (altoPasajero > alto)
									alto = altoPasajero;
								if (ancho < anchoPasajeros)
									ancho = anchoPasajeros;
							}
							pasajeros += "</html>";

							altoPasajero = 0;
							anchoPasajeros = 0;
							String extras = "<html>";
							for (int e = 0; e < pnRestoExtras
									.getComponentCount(); e++) {
								JCheckBox ch = (JCheckBox) pnRestoExtras
										.getComponent(e);
								if (ch.isSelected()) {
									@SuppressWarnings("deprecation")
									String aux = ch.getLabel();
									extras += aux + "<br>";
									altoPasajero++;
									if (altoPasajero > alto)
										alto = altoPasajero;
									int hasta = 0;
									for (int j = 0; j < aux.length(); j++) {
										if (aux.charAt(j) == '(') {
											hasta = j;
											break;
										}
									}
									aux = aux.substring(0, hasta - 1);
									for (int j = 0; j < arrayCamarotes.get(i)
											.getExtras().size(); j++) {
										if (arrayCamarotes.get(i).getExtras()
												.get(j).getDescripcion()
												.equals(aux)) {
											arrayCamarotes.get(i).getExtras()
													.get(j).setAñadido(true);
										}
									}
								}
							}
							extras += "</html>";
							vp.getListaCamarotes().add(arrayCamarotes.get(i));
							vp.getModeloTablaCamarotes()
									.addRow(new Object[] { tipo2,
											cbSituacion.getSelectedItem(),
											pasajeros, extras });
							valido = true;
							break;
						}
					}
					for (int i = 0; i < tablaPasajeros.getRowCount(); i++) {
						for (int j = 0; j < pasajerosCamarote.size(); j++) {
							if (tablaPasajeros.getValueAt(i, 0).equals(
									pasajerosCamarote.get(j).getNombre())
									&& tablaPasajeros.getValueAt(i, 1)
											.equals(pasajerosCamarote.get(j)
													.getApellidos())
									&& tablaPasajeros.getValueAt(i, 2).equals(
											pasajerosCamarote.get(j).getDni())
									&& tablaPasajeros.getValueAt(i, 3)
											.equals(pasajerosCamarote.get(j)
													.getFechaNacimiento())) {
								modeloComboPasajeros.removeElement(
										pasajerosCamarote.get(j));
								vp.getListaClientes()
										.remove(pasajerosCamarote.get(j));
								pasajerosCamarote.remove(j);
							}
						}
					}
					while (modeloTablaPasajeros.getRowCount() > 0)
						modeloTablaPasajeros.removeRow(0);
					if (chckbxCamaSupletoria.isSelected()) {
						pasajerosCamarote.remove(
								cbPasajerosMenoresEdad.getSelectedItem());
						vp.getListaClientes().remove(
								cbPasajerosMenoresEdad.getSelectedItem());
						modeloComboMenores.removeElement(
								cbPasajerosMenoresEdad.getSelectedItem());
					}
					chckbxCamaSupletoria.setSelected(false);
					if (!valido) {
						JOptionPane.showMessageDialog(null,
								"No hay suficientes camarotes para todos los pasajeros.\n Por favor seleccione otro crucero u otra fechas",
								"Error", JOptionPane.ERROR_MESSAGE);
						vp.inicializar();
						dispose();
					} else if (modeloComboPasajeros.getSize() > 0) {
						JOptionPane.showMessageDialog(null,
								"Hay pasajeros sin camarote");
						btnAñadir.setEnabled(false);
						btnBorrarPasajero.setEnabled(false);
						for (int i = 0; i < pnRestoExtras
								.getComponentCount(); i++) {
							JCheckBox aux = (JCheckBox) pnRestoExtras
									.getComponent(i);
							aux.setSelected(false);
						}
					} else {
						vp.getBtnSiguienteReservaCamarotes().setEnabled(true);
						vp.getBtnBorrarReservaCamarotes().setEnabled(true);
						vp.getBtnSiguienteReservaCamarotes().grabFocus();
						if (pasajerosCamarote.isEmpty())
							vp.getBtnAñadirReservaCamarotes().setEnabled(false);
						redimensionarTablaCamarotes();
						dispose();
					}
				}
			});
		}
		return btnAñadir;
	}

	protected void redimensionarTablaCamarotes() {
		vp.getTablaCamarotes().setRowHeight(40 * alto);
		vp.getTablaCamarotes().getColumnModel().getColumn(0)
				.setPreferredWidth(100);
		vp.getTablaCamarotes().getColumnModel().getColumn(1)
				.setPreferredWidth(100);
		vp.getTablaCamarotes().getColumnModel().getColumn(2)
				.setPreferredWidth(10 * ancho);
		vp.getTablaCamarotes().getColumnModel().getColumn(3)
				.setPreferredWidth(10 * ancho);
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setToolTipText(
					"Cierra la ventana actual y vuelve a la ventana principal");
			btnCancelar.setMnemonic('C');
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}

	private JPanel getPnTipoSituacion() {
		if (pnTipoSituacion == null) {
			pnTipoSituacion = new JPanel();
			pnTipoSituacion.setBorder(new EmptyBorder(5, 0, 5, 0));
			pnTipoSituacion.setLayout(new GridLayout(1, 0, 0, 0));
			pnTipoSituacion.add(getPnTipo());
			pnTipoSituacion.add(getPnSituacion());
		}
		return pnTipoSituacion;
	}

	private JPanel getPnTipo() {
		if (pnTipo == null) {
			pnTipo = new JPanel();
			pnTipo.setLayout(new GridLayout(0, 2, 0, 0));
			pnTipo.add(getLblTipo());
			pnTipo.add(getCbTipo());
		}
		return pnTipo;
	}

	private JPanel getPnSituacion() {
		if (pnSituacion == null) {
			pnSituacion = new JPanel();
			pnSituacion.setLayout(new GridLayout(0, 2, 0, 0));
			pnSituacion.add(getLblSituacion());
			pnSituacion.add(getCbSituacion());
		}
		return pnSituacion;
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setLabelFor(getCbTipo());
			lblTipo.setDisplayedMnemonic('T');
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblTipo;
	}

	private JComboBox<String> getCbTipo() {
		if (cbTipo == null) {
			cbTipo = new JComboBox<String>();
			cbTipo.setToolTipText("Selecciona el tipo del camarote");
			cbTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int plazas, pasajeroCamarote = tablaPasajeros.getRowCount();
					if (cbTipo.getSelectedItem().equals("Doble"))
						plazas = 2;
					else
						plazas = 4;
					if (plazas == pasajeroCamarote)
						btnAgregarPasajero.setEnabled(false);
					else
						btnAgregarPasajero.setEnabled(true);
					if (pasajeroCamarote > 0)
						btnBorrarPasajero.setEnabled(true);
					else
						btnBorrarPasajero.setEnabled(false);
				}
			});
			String[] aux = new String[] { "Doble", "Familiar" };
			modeloComboTipo = new DefaultComboBoxModel<String>(aux);
			cbTipo.setModel(modeloComboTipo);
		}
		return cbTipo;
	}

	private JLabel getLblSituacion() {
		if (lblSituacion == null) {
			lblSituacion = new JLabel("  Situaci\u00F3n:");
			lblSituacion.setDisplayedMnemonic('S');
			lblSituacion.setLabelFor(getCbSituacion());
			lblSituacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSituacion.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblSituacion;
	}

	private JComboBox<String> getCbSituacion() {
		if (cbSituacion == null) {
			cbSituacion = new JComboBox<String>();
			cbSituacion.setToolTipText(
					"Selecciona la situaci\u00F3n del camarote respecto al barco");
			cbSituacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			String[] aux = new String[] { "Interior", "Exterior" };
			modeloComboPosicion = new DefaultComboBoxModel<String>(aux);
			cbSituacion.setModel(modeloComboPosicion);
		}
		return cbSituacion;
	}

	private JPanel getPnExtras() {
		if (pnExtras == null) {
			pnExtras = new JPanel();
			pnExtras.setBorder(
					new TitledBorder(null, "Extras:", TitledBorder.LEADING,
							TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnExtras.setLayout(new GridLayout(2, 1, 0, 0));
			pnExtras.add(getPnRestoExtras());
			pnExtras.add(getPnCamaSupletoria());
		}
		return pnExtras;
	}

	private JPanel getPnPasajeros() {
		if (pnPasajeros == null) {
			pnPasajeros = new JPanel();
			pnPasajeros.setLayout(new BorderLayout(0, 0));
			pnPasajeros.add(getPnSeleccionPasajeros(), BorderLayout.NORTH);
			pnPasajeros.add(getPnPasajerosCamarote(), BorderLayout.CENTER);
		}
		return pnPasajeros;
	}

	private JPanel getPnCamaSupletoria() {
		if (pnCamaSupletoria == null) {
			pnCamaSupletoria = new JPanel();
			pnCamaSupletoria.setLayout(new GridLayout(0, 2, 0, 0));
			pnCamaSupletoria.add(getChckbxCamaSupletoria());
			pnCamaSupletoria.add(getCbPasajerosMenoresEdad());
		}
		return pnCamaSupletoria;
	}

	private JCheckBox getChckbxCamaSupletoria() {
		if (chckbxCamaSupletoria == null) {
			chckbxCamaSupletoria = new JCheckBox("Cama supletoria");
			chckbxCamaSupletoria.setMnemonic('M');
			chckbxCamaSupletoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (chckbxCamaSupletoria.isSelected()) {
						Pasajero pasajero = (Pasajero) cbPasajerosMenoresEdad
								.getSelectedItem();
						for (int i = 0; i < modeloComboPasajeros
								.getSize(); i++) {
							if (modeloComboPasajeros.getElementAt(i).getNombre()
									.equals(pasajero.getNombre())
									&& modeloComboPasajeros.getElementAt(i)
											.getApellidos()
											.equals(pasajero.getApellidos())
									&& modeloComboPasajeros.getElementAt(i)
											.getDni().equals(pasajero.getDni())
									&& modeloComboPasajeros.getElementAt(i)
											.getFechaNacimiento()
											.equals(pasajero
													.getFechaNacimiento())) {
								modeloComboPasajeros.removeElementAt(i);
							}
						}
					} else {
						modeloComboPasajeros.removeAllElements();
						for (int i = 0; i < vp.getListaClientes().size(); i++)
							modeloComboPasajeros
									.addElement(vp.getListaClientes().get(i));
					}
				}
			});
		}
		return chckbxCamaSupletoria;
	}

	private JComboBox<Pasajero> getCbPasajerosMenoresEdad() {
		if (cbPasajerosMenoresEdad == null) {
			cbPasajerosMenoresEdad = new JComboBox<Pasajero>();
			cbPasajerosMenoresEdad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (chckbxCamaSupletoria.isSelected()) {
						Pasajero pasajero = (Pasajero) cbPasajerosMenoresEdad
								.getSelectedItem();
						if (pasajero != null) {
							modeloComboPasajeros.removeAllElements();
							for (int i = 0; i < vp.getListaClientes()
									.size(); i++)
								modeloComboPasajeros.addElement(
										vp.getListaClientes().get(i));
							for (int i = 0; i < modeloComboPasajeros
									.getSize(); i++) {
								if (modeloComboPasajeros.getElementAt(i)
										.getNombre()
										.equals(pasajero.getNombre())
										&& modeloComboPasajeros.getElementAt(i)
												.getApellidos()
												.equals(pasajero.getApellidos())
										&& modeloComboPasajeros.getElementAt(i)
												.getDni()
												.equals(pasajero.getDni())
										&& modeloComboPasajeros.getElementAt(i)
												.getFechaNacimiento()
												.equals(pasajero
														.getFechaNacimiento())) {
									modeloComboPasajeros.removeElementAt(i);
								}
							}
						}
					}
				}
			});
		}
		return cbPasajerosMenoresEdad;
	}

	private JPanel getPnRestoExtras() {
		if (pnRestoExtras == null) {
			pnRestoExtras = new JPanel();
			pnRestoExtras.setLayout(new GridLayout(0, 3, 0, 0));
		}
		return pnRestoExtras;
	}

	private JPanel getPnSeleccionPasajeros() {
		if (pnSeleccionPasajeros == null) {
			pnSeleccionPasajeros = new JPanel();
			pnSeleccionPasajeros.setBorder(new EmptyBorder(0, 0, 5, 0));
			pnSeleccionPasajeros.setLayout(new GridLayout(1, 0, 1, 0));
			pnSeleccionPasajeros.add(getLblSeleccioneUnPasajero());
			pnSeleccionPasajeros.add(getCbPasajeros());
			pnSeleccionPasajeros.add(getPnBotonesSeleccionPasajeros());
		}
		return pnSeleccionPasajeros;
	}

	private JScrollPane getPnPasajerosCamarote() {
		if (pnPasajerosCamarote == null) {
			pnPasajerosCamarote = new JScrollPane();
			pnPasajerosCamarote.setViewportView(getTablaPasajeros());
		}
		return pnPasajerosCamarote;
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

	private JLabel getLblSeleccioneUnPasajero() {
		if (lblSeleccioneUnPasajero == null) {
			lblSeleccioneUnPasajero = new JLabel("Seleccione un pasajero:");
			lblSeleccioneUnPasajero.setLabelFor(getCbPasajeros());
			lblSeleccioneUnPasajero.setDisplayedMnemonic('P');
			lblSeleccioneUnPasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblSeleccioneUnPasajero;
	}

	private JComboBox<Pasajero> getCbPasajeros() {
		if (cbPasajeros == null) {
			cbPasajeros = new JComboBox<Pasajero>();
			cbPasajeros.setToolTipText(
					"Seleccione al pasajero que va a utilizar el camarote");
			cbPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return cbPasajeros;
	}

	private JPanel getPnBotonesSeleccionPasajeros() {
		if (pnBotonesSeleccionPasajeros == null) {
			pnBotonesSeleccionPasajeros = new JPanel();
			pnBotonesSeleccionPasajeros.add(getBtnAgregarPasajero());
			pnBotonesSeleccionPasajeros.add(getBtnBorrarPasajero());
		}
		return pnBotonesSeleccionPasajeros;
	}

	private JButton getBtnAgregarPasajero() {
		if (btnAgregarPasajero == null) {
			btnAgregarPasajero = new JButton("Agregar");
			btnAgregarPasajero.setToolTipText(
					"Agrega al pasajero seleccionado al camarote");
			btnAgregarPasajero.setMnemonic('G');
			btnAgregarPasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAgregarPasajero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int plazas, pasajeroCamarote = tablaPasajeros.getRowCount();
					if (cbTipo.getSelectedItem().equals("Doble"))
						plazas = 2;
					else
						plazas = 4;
					if (plazas != pasajeroCamarote) {
						Pasajero pasajero = (Pasajero) cbPasajeros
								.getSelectedItem();
						if (pasajero.isMenor()) {
							for (int i = 0; i < modeloComboMenores
									.getSize(); i++) {
								if (modeloComboMenores.getElementAt(i)
										.getNombre()
										.equals(pasajero.getNombre())
										&& modeloComboMenores.getElementAt(i)
												.getApellidos()
												.equals(pasajero.getApellidos())
										&& modeloComboMenores.getElementAt(i)
												.getDni()
												.equals(pasajero.getDni())
										&& modeloComboMenores.getElementAt(i)
												.getFechaNacimiento()
												.equals(pasajero
														.getFechaNacimiento())) {
									modeloComboMenores.removeElementAt(i);
									if (modeloComboMenores.getSize() == 0) {
										chckbxCamaSupletoria.setEnabled(false);
										cbPasajerosMenoresEdad
												.setEnabled(false);
									}
								}
							}
						}
						boolean añadido = false;
						for (int i = 0; i < modeloTablaPasajeros
								.getRowCount(); i++)
							if (modeloTablaPasajeros.getValueAt(i, 0)
									.equals(pasajero.getNombre())
									&& modeloTablaPasajeros.getValueAt(i, 1)
											.equals(pasajero.getApellidos())
									&& modeloTablaPasajeros.getValueAt(i, 2)
											.equals(pasajero.getDni())) {
								añadido = true;
								break;
							}
						if (!añadido) {
							pasajerosCamarote.add(pasajero);
							modeloTablaPasajeros.addRow(new Object[] {
									pasajero.getNombre(),
									pasajero.getApellidos(), pasajero.getDni(),
									pasajero.getFechaNacimiento() });
						} else
							JOptionPane.showMessageDialog(null,
									"Pasajero ya añadido");
					}
					pasajeroCamarote = tablaPasajeros.getRowCount();
					if (plazas == pasajeroCamarote)
						btnAgregarPasajero.setEnabled(false);
					if (pasajeroCamarote > 0) {
						btnBorrarPasajero.setEnabled(true);
						btnAñadir.setEnabled(true);
					}

				}
			});
		}
		return btnAgregarPasajero;
	}

	private JButton getBtnBorrarPasajero() {
		if (btnBorrarPasajero == null) {
			btnBorrarPasajero = new JButton("Borrar");
			btnBorrarPasajero.setToolTipText(
					"Borra al pasajero seleccionado del camarote");
			btnBorrarPasajero.setMnemonic('B');
			btnBorrarPasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnBorrarPasajero.setEnabled(false);
			btnBorrarPasajero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Pasajero pasajero = (Pasajero) cbPasajeros
							.getSelectedItem();
					if (pasajero.isMenor()) {
						boolean añadido = false;
						for (int i = 0; i < modeloComboPasajeros
								.getSize(); i++) {
							if (modeloComboPasajeros.getElementAt(i).getNombre()
									.equals(pasajero.getNombre())
									&& modeloComboPasajeros.getElementAt(i)
											.getApellidos()
											.equals(pasajero.getApellidos())
									&& modeloComboPasajeros.getElementAt(i)
											.getDni().equals(pasajero.getDni())
									&& modeloComboPasajeros.getElementAt(i)
											.getFechaNacimiento()
											.equals(pasajero
													.getFechaNacimiento())) {
								añadido = true;
								break;
							}
						}
						if (añadido)
							modeloComboMenores.addElement(pasajero);
						if (!chckbxCamaSupletoria.isSelected()) {
							chckbxCamaSupletoria.setEnabled(true);
							cbPasajerosMenoresEdad.setEnabled(true);
						}
					}
					for (int i = 0; i < modeloTablaPasajeros
							.getRowCount(); i++) {
						if (modeloTablaPasajeros.getValueAt(i, 0)
								.equals(pasajero.getNombre())
								&& modeloTablaPasajeros.getValueAt(i, 1)
										.equals(pasajero.getApellidos())
								&& modeloTablaPasajeros.getValueAt(i, 2)
										.equals(pasajero.getDni())) {
							pasajerosCamarote.remove(pasajero);
							modeloTablaPasajeros.removeRow(i);
							break;
						}
					}
					int plazas, pasajeroCamarote = tablaPasajeros.getRowCount();
					if (cbTipo.getSelectedItem().equals("Doble"))
						plazas = 2;
					else
						plazas = 4;
					if (plazas != pasajeroCamarote)
						btnAgregarPasajero.setEnabled(true);
					if (pasajeroCamarote == 0) {
						btnBorrarPasajero.setEnabled(false);
						btnAñadir.setEnabled(false);
					}
				}
			});
		}
		return btnBorrarPasajero;
	}

	private void añadirExtras() {
		boolean menor = false, cama = false;
		for (Pasajero pasajero : vp.getListaClientes()) {
			if (pasajero.isMenor()) {
				menor = true;
				break;
			}
		}
		ArrayList<Character> mnemonicosChechBoxes = new ArrayList<Character>();
		mnemonicosChechBoxes.add('C');
		mnemonicosChechBoxes.add('c');
		mnemonicosChechBoxes.add(' ');
		mnemonicosChechBoxes.add('A');
		mnemonicosChechBoxes.add('a');
		mnemonicosChechBoxes.add('M');
		mnemonicosChechBoxes.add('m');
		mnemonicosChechBoxes.add('G');
		mnemonicosChechBoxes.add('g');
		mnemonicosChechBoxes.add('P');
		mnemonicosChechBoxes.add('p');
		mnemonicosChechBoxes.add('S');
		mnemonicosChechBoxes.add('s');
		mnemonicosChechBoxes.add('T');
		mnemonicosChechBoxes.add('t');
		for (Extra a : vp.getCrucero().getBarco().getCamarotesBarco().get(0)
				.getExtras()) {
			if (!a.getDescripcion().equals("Cama supletoria")) {
				int contador = 0;
				boolean correcto = false;
				Character e = a.getDescripcion().charAt(contador);
				do {
					if (mnemonicosChechBoxes.contains(e)) {
						contador++;
						if (contador == a.getDescripcion().length()) {
							e = a.getDescripcion().charAt(0);
							break;
						} else
							e = a.getDescripcion().charAt(contador);
					} else {
						if (Character.isUpperCase(e)) {
							mnemonicosChechBoxes.add(e);
							mnemonicosChechBoxes.add(Character.toLowerCase(e));
						} else {
							mnemonicosChechBoxes.add(e);
							mnemonicosChechBoxes.add(Character.toUpperCase(e));
						}
						correcto = true;
					}
				} while (!correcto);
				JCheckBox aux = new JCheckBox(
						a.getDescripcion() + " (" + a.getPrecio() + " ñ)");
				aux.setMnemonic(e);
				pnRestoExtras.add(aux);
			} else {
				cama = true;
				chckbxCamaSupletoria
						.setText("Cama supletoria (" + a.getPrecio() + " ñ)");
			}
		}
		if (menor && cama) {
			modeloComboMenores = new DefaultComboBoxModel<Pasajero>();
			for (int i = 0; i < vp.getListaClientes().size(); i++) {
				if (vp.getListaClientes().get(i).isMenor()) {
					modeloComboMenores.addElement(vp.getListaClientes().get(i));
				}
			}
			chckbxCamaSupletoria.setEnabled(true);
			cbPasajerosMenoresEdad.setEnabled(true);
			cbPasajerosMenoresEdad.setModel(modeloComboMenores);
		} else {
			chckbxCamaSupletoria.setEnabled(false);
			cbPasajerosMenoresEdad.setEnabled(false);
		}
		pnExtras.updateUI();
		pnExtras.repaint();
		repaint();
	}

	private void comprobarModelos() {
		ArrayList<Camarote> camarotes = vp.getCrucero().getPasajerosFechas()
				.get(vp.getCbFechas().getSelectedIndex());
		int dobleE = 0, dobleI = 0, familiarE = 0, familiarI = 0;
		boolean añadido = false;
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

		if (dobleE == 0 && dobleI == 0)
			modeloComboTipo.removeElement("Doble");

		if (familiarE == 0 && familiarI == 0)
			modeloComboTipo.removeElement("Familiar");

		if (cbTipo.getSelectedItem().equals("Doble") && dobleE == 0)
			modeloComboPosicion.removeElement("Exterior");
		else if (!cbTipo.getSelectedItem().equals("Doble") && dobleE != 0) {
			añadido = false;
			for (int i = 0; i < modeloComboTipo.getSize(); i++) {
				if (modeloComboTipo.getElementAt(i).equals("Doble"))
					añadido = true;
				if (!añadido)
					modeloComboPosicion.addElement("Exterior");
			}
		}

		if (cbTipo.getSelectedItem().equals("Doble") && dobleI == 0)
			modeloComboPosicion.removeElement("Interior");
		else if (!cbTipo.getSelectedItem().equals("Doble") && dobleI != 0) {
			añadido = false;
			for (int i = 0; i < modeloComboTipo.getSize(); i++) {
				if (modeloComboTipo.getElementAt(i).equals("Doble"))
					añadido = true;
				if (!añadido)
					modeloComboPosicion.addElement("Interior");
			}
		}

		if (cbTipo.getSelectedItem().equals("Familiar") && familiarE == 0)
			modeloComboPosicion.removeElement("Exterior");
		else if (!cbTipo.getSelectedItem().equals("Familiar")
				&& familiarE != 0) {
			añadido = false;
			for (int i = 0; i < modeloComboTipo.getSize(); i++) {
				if (modeloComboTipo.getElementAt(i).equals("Familiar"))
					añadido = true;
				if (!añadido)
					modeloComboPosicion.addElement("Exterior");
			}
		}

		if (cbTipo.getSelectedItem().equals("Familiar") && familiarI == 0)
			modeloComboPosicion.removeElement("Interior");
		else if (!cbTipo.getSelectedItem().equals("Familiar")
				&& familiarI != 0) {
			añadido = false;
			for (int i = 0; i < modeloComboTipo.getSize(); i++) {
				if (modeloComboTipo.getElementAt(i).equals("Familiar"))
					añadido = true;
				if (!añadido)
					modeloComboPosicion.addElement("Interior");
			}
		}
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
		hb.enableHelpKey(pnPrincipal, "ventanaAñadirCamarote", hs);
	}
}