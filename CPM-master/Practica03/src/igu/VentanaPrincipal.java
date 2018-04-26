package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import logica.Articulo;
import logica.Catalogo;
import logica.Pedido;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 5767732953572960676L;
	private JPanel pnPrincipal;
	private JLabel lblLogo;
	private JLabel lblPcAccesorios;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lblAccesorios;
	private JTextField txtCantidad;
	private JLabel lblUnidades;
	private JButton btnAñadir;
	private JTextField txtPrecio;
	private JLabel lblPrecioPedido;
	private JButton btnCancelar;
	private JButton btnSiguiente;

	// Crea los objetos de la parte de logica
	private Catalogo catalogo;
	private Pedido pedido;

	/**
	 * Lanza la aplicacion
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana principal
	 */
	public VentanaPrincipal() {
		// Primero crea los objetos de la parte de logica en memoria
		catalogo = new Catalogo();
		pedido = new Pedido();

		// Despues crea la interfaz
		setTitle("PC Accesorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 481);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getLblLogo());
		pnPrincipal.add(getLblPcAccesorios());
		pnPrincipal.add(getCbArticulos());
		pnPrincipal.add(getLblAccesorios());
		pnPrincipal.add(getTxtCantidad());
		pnPrincipal.add(getLblUnidades());
		pnPrincipal.add(getBtnAñadir());
		pnPrincipal.add(getTxtPrecio());
		pnPrincipal.add(getLblPrecioPedido());
		pnPrincipal.add(getBtnCancelar());
		pnPrincipal.add(getBtnSiguiente());
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/logo.jpg")));
			lblLogo.setBounds(46, 11, 150, 202);
		}
		return lblLogo;
	}

	private JLabel getLblPcAccesorios() {
		if (lblPcAccesorios == null) {
			lblPcAccesorios = new JLabel("PC ACCESORIOS");
			lblPcAccesorios.setForeground(Color.BLUE);
			lblPcAccesorios.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblPcAccesorios.setBounds(238, 67, 213, 50);
		}
		return lblPcAccesorios;
	}

	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			// Rellena el combo con el catalogo
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(
					catalogo.getArticulos()));
			cbArticulos.setBounds(24, 278, 325, 25);
		}
		return cbArticulos;
	}

	private JLabel getLblAccesorios() {
		if (lblAccesorios == null) {
			lblAccesorios = new JLabel("Accesorios:");
			lblAccesorios.setLabelFor(getCbArticulos());
			lblAccesorios.setDisplayedMnemonic('a');
			lblAccesorios.setBounds(24, 245, 72, 25);
		}
		return lblAccesorios;
	}

	private JTextField getTxtCantidad() {
		if (txtCantidad == null) {
			txtCantidad = new JTextField();
			txtCantidad.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					// Se rellena cuando se selecciona el campo
					txtCantidad.setText("1");
					txtCantidad.selectAll();
				}

				@Override
				public void focusLost(FocusEvent e) {
					boolean error = false;
					int unidades = 0;
					try {
						unidades = Integer.parseInt(txtCantidad.getText());
					} catch (Exception e2) {
						error = true;
					}
					if ((error) || unidades <= 0)
						txtCantidad.setText("");
				}
			});
			txtCantidad.setBounds(424, 279, 64, 23);
			txtCantidad.setColumns(10);
		}
		return txtCantidad;
	}

	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setLabelFor(getTxtCantidad()); // Establece el nmemonico
			lblUnidades.setDisplayedMnemonic('u');
			lblUnidades.setBounds(424, 246, 64, 23);
		}
		return lblUnidades;
	}

	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("+");
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!txtCantidad.getText().equals("")) {
						// Crea un objeto articulo
						Articulo articulo = (Articulo) cbArticulos
								.getSelectedItem();
						// Coge las unidades que deseamos
						int unidades = Integer.parseInt(txtCantidad.getText());
						// Añade el articulo al pedido
						pedido.add(articulo, unidades);
						float precioPedido = pedido.calcularTotalSinIva();
						txtPrecio.setText(
								String.valueOf(precioPedido) + " \u20AC");

						if (!btnSiguiente.isEnabled())
							btnSiguiente.setEnabled(true);
					}
				}
			});
			btnAñadir.setToolTipText(
					"A\u00F1ade elementos a la cesta de compra");
			btnAñadir.setMnemonic('+');
			btnAñadir.setMnemonic(KeyEvent.VK_PLUS);
			btnAñadir.setBounds(514, 279, 46, 23);
		}
		return btnAñadir;
	}

	private JTextField getTxtPrecio() {
		if (txtPrecio == null) {
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(424, 347, 86, 20);
			txtPrecio.setColumns(10);
		}
		return txtPrecio;
	}

	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setBounds(424, 322, 86, 20);
		}
		return lblPrecioPedido;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(517, 409, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('S');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}
			});
			btnSiguiente.setEnabled(true);
			btnSiguiente.setBounds(421, 409, 89, 23);
		}
		return btnSiguiente;
	}

	private void mostrarVentanaRegistro() {
		VentanaRegistro vRegistro = new VentanaRegistro(this);
		vRegistro.setLocationRelativeTo(null);
		vRegistro.setModal(true);
		vRegistro.setVisible(true);
	}
}
