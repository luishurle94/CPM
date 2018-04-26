package igu.PanelCardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import igu.VentanaPrincipal;
import igu.VentanasAuxiliares.VentanaAñadirPasajero;
import logica.Pasajero;

public class PanelPasajeros extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5245380327901137550L;
	private VentanaPrincipal vp;
	private JPanel pnTituloPasajeros;
	private JPanel pnListaPasajeros;
	private JPanel pnBotonesPasajeros;
	private JLabel lblListaDePasajeros;
	private JButton btnAtrasPasajeros;
	private JButton btnSiguientePasajeros;
	private JTable tablaPasajeros;
	private DefaultTableModel modeloTablaPasajeros;
	private JButton btnCancelarPasajeros;
	private JLabel lblPorFavorIntroduzca;
	private JScrollPane scPasajeros;
	private JPanel pnBotonesModificarPasajeros;
	private JButton btnAñadirPasajero;
	private JPanel pnEspacio1RegistroPasajeros;
	private JPanel pnEspacio2RegistroPasajeros;
	private JLabel lblEspacio1RegistroPasajeros;
	private JLabel lblEspacio2RegistroPasajeros;
	private JButton btnBorrarPasajero;

	public PanelPasajeros(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnTituloPasajeros(), BorderLayout.NORTH);
		this.add(getPnListaPasajeros(), BorderLayout.CENTER);
		this.add(getPnBotonesPasajeros(), BorderLayout.SOUTH);
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

	private JLabel getLblPorFavorIntroduzca() {
		if (lblPorFavorIntroduzca == null) {
			lblPorFavorIntroduzca = new JLabel(
					"Por favor introduzca a las personas que van a realizar el crucero:");
			lblPorFavorIntroduzca.setHorizontalAlignment(SwingConstants.CENTER);
			lblPorFavorIntroduzca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblPorFavorIntroduzca;
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
		VentanaAñadirPasajero vap = new VentanaAñadirPasajero(vp);
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
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
					vp.borrarModelo(modeloTablaPasajeros);
					vp.setListaPasajeros(new ArrayList<Pasajero>());
					btnSiguientePasajeros.setEnabled(false);
					// btnSiguienteListaCruceros.grabFocus();
					((CardLayout) vp.getPnReservas().getLayout())
							.previous(vp.getPnReservas());
					// getCbFechas().grabFocus();
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
						// getBtnAñadirReservaCamarotes().grabFocus();
						// btnBorrarReservaCamarotes.setEnabled(false);
						// btnAñadirReservaCamarotes.setEnabled(true);
						// btnSiguienteReservaCamarotes.setEnabled(false);
					} else
						JOptionPane.showMessageDialog(null,
								"Entre los pasajeros debe haber uno que sea mayor de edad",
								"Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
		return btnSiguientePasajeros;
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

	private JButton getBtnCancelarPasajeros() {
		if (btnCancelarPasajeros == null) {
			btnCancelarPasajeros = new JButton("Cancelar");
			btnCancelarPasajeros.setToolTipText(
					"Borra todos los datos vuelve a la pantalla de inicio");
			btnCancelarPasajeros.setMnemonic('C');
			btnCancelarPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelarPasajeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vp.inicializar();
				}
			});
		}
		return btnCancelarPasajeros;
	}

	private JScrollPane getScPasajeros() {
		if (scPasajeros == null) {
			scPasajeros = new JScrollPane();
			scPasajeros.setViewportView(getTablaPasajeros());
		}
		return scPasajeros;
	}

}
