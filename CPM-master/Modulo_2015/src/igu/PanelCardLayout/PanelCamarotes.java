package igu.PanelCardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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
import igu.VentanasAuxiliares.VentanaAsignarNombreReserva;
import igu.VentanasAuxiliares.VentanaAñadirCamarote;
import logica.Camarote;
import logica.Pasajero;

public class PanelCamarotes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -345188618460122400L;
	private VentanaPrincipal vp;
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
	private JPanel pnBotonesReservaCamarotes;
	private JLabel lblPorFavorIntroduzca_1;
	private JButton btnBorrarReservaCamarotes;

	public PanelCamarotes(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnTituloReservaCamarotes(), BorderLayout.NORTH);
		this.add(getPnEspacio1ReservaCamarotes(), BorderLayout.WEST);
		this.add(getPnEspacio2ReservaCamarotes(), BorderLayout.EAST);
		this.add(getPnListaCamarotes(), BorderLayout.CENTER);
		this.add(getPnBotonesReservaCamarotes(), BorderLayout.SOUTH);
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
					vp.setListaClientes(null);
					vp.borrarModelo(vp.getModeloTablaCamarotes());
					Iterator<Camarote> it = vp.getListaCamarotes().iterator();
					while (it.hasNext())
						vp.desreservarCamarote(it.next());
					vp.getListaCamarotes().clear();
					((CardLayout) vp.getPnReservas().getLayout())
							.previous(vp.getPnReservas());
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
		VentanaAsignarNombreReserva vap = new VentanaAsignarNombreReserva(vp);
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
					vp.inicializar();
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
						vp.getModeloTablaCamarotes().removeRow(camarote);
						for (Pasajero pasajero : vp.getListaCamarotes()
								.get(camarote).getPasajeros())
							if (pasajero != null)
								vp.getListaClientes().add(pasajero);
						Camarote aux = vp.buscarCamarote(
								vp.getListaCamarotes().get(camarote));
						vp.desreservarCamarote(aux);
						vp.listaCamarotes.remove(camarote);
					}
					if (vp.getModeloTablaCamarotes().getRowCount() == 0) {
						btnSiguienteReservaCamarotes.setEnabled(false);
						btnBorrarReservaCamarotes.setEnabled(false);
					}

					if (!vp.listaClientes.isEmpty()) {
						btnSiguienteReservaCamarotes.setEnabled(false);
						btnAñadirReservaCamarotes.setEnabled(true);
					}
				}
			});
		}
		return btnBorrarReservaCamarotes;
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
			vp.setModeloTablaCamarotes(new DefaultTableModel(new Object[] {
					"Tipo", "Situaciï¿½n", "Pasajeros", "Extras" }, 0));
			tablaCamarotes = new JTable(vp.getModeloTablaCamarotes()) {
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
		VentanaAñadirCamarote vap = new VentanaAñadirCamarote(vp);
		vap.setLocationRelativeTo(null);
		vap.setModal(true);
		vap.setVisible(true);
	}

}
