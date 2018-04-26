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
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import logica.Articulo;
import logica.Catalogo;
import logica.Pedido;

import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 5767732953572960676L;
	private JPanel pnPrincipal;
	private JLabel lblLogo;
	private JLabel lblPcAccesorios;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lblAccesorios;
	private JTextField txtCantidad;
	private JLabel lblUnidades;
	private JButton btnAÒadir;
	private JTextField txtPrecio;
	private JLabel lblPrecioPedido;
	private JButton btnCancelar;
	private JButton btnSiguiente;
	private JButton btnRestar;
	private JButton btnCarrito;

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
					// Para importar, boton derecho del proyecto, build path,
					// add external archives
					// Permite cambiar el look and feel
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel
							.setSkin("org.jvnet.substance.skin.DustCoffeeSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.getCbArticulos().grabFocus();
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
		// Cambia el icono de la ventana
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));

		// Primero crea los objetos de la parte de l√≥gica en memoria
		catalogo = new Catalogo();
		pedido = new Pedido();

		// Despu√©s crea la interfaz
		setTitle("PC Accesorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 481);
		setResizable(false); // Bloquea la redimensi√≥n de la ventana

		pnPrincipal = new JPanel();
		setLocationRelativeTo(null);
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
		pnPrincipal.add(getBtnAÒadir());
		pnPrincipal.add(getBtnRestar());
		pnPrincipal.add(getTxtPrecio());
		pnPrincipal.add(getLblPrecioPedido());
		pnPrincipal.add(getBtnCancelar());
		pnPrincipal.add(getBtnSiguiente());
		pnPrincipal.add(getBtnCarrito());
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
				// Se rellena cuando se selecciona el campo
				public void focusGained(FocusEvent arg0) {
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
			txtCantidad.setBounds(414, 278, 64, 23);
			txtCantidad.setColumns(10);
		}
		return txtCantidad;
	}

	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setLabelFor(getTxtCantidad());
			lblUnidades.setDisplayedMnemonic('u'); // Establece el nmemonico
			lblUnidades.setBounds(414, 245, 64, 23);
		}
		return lblUnidades;
	}

	private JButton getBtnAÒadir() {
		if (btnAÒadir == null) {
			btnAÒadir = new JButton("+");
			btnAÒadir.setMnemonic('+');
			btnAÒadir.setMnemonic(KeyEvent.VK_ADD);
			btnAÒadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!txtCantidad.getText().equals("")) {
						cbArticulos.getSelectedItem();
						Integer.parseInt(txtCantidad.getText());
						// AÒade el articulo al pedido
						float precioPedido = pedido.calcularTotalSinIva();
						txtPrecio.setText(
								String.valueOf(precioPedido) + " \u20AC");
						// C√≥digo ASCII del s√≠mbolo de euro

						if (!btnSiguiente.isEnabled())
							btnSiguiente.setEnabled(true);
					} else {
						txtCantidad.grabFocus();
					}
				}
			});
			btnAÒadir.setToolTipText(
					"A\u00F1ade elementos a la cesta de compra");
			btnAÒadir.setBounds(504, 278, 46, 23);
		}
		return btnAÒadir;
	}

	private JButton getBtnRestar() {
		if (btnRestar == null) {
			btnRestar = new JButton("-");
			btnRestar.setMnemonic('-');
			btnRestar.setMnemonic(KeyEvent.VK_SUBTRACT);
			btnRestar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!txtCantidad.getText().equals("")) {
						Articulo articulo = (Articulo) cbArticulos
								.getSelectedItem(); // Crea un objeto articulo
						int unidades = Integer.parseInt(txtCantidad.getText());
						pedido.delete(articulo, unidades);
						float precioPedido = pedido.calcularTotalSinIva();
						txtPrecio.setText(
								String.valueOf(precioPedido) + " \u20AC");
						if (txtPrecio.getText().equals("0.0 \u20AC"))
							txtPrecio.setText("");

						if (txtPrecio.getText().equals(""))
							btnSiguiente.setEnabled(false);
					} else {
						txtCantidad.grabFocus();
					}

				}
			});
			btnRestar.setToolTipText("Quita elementos de la cesta de compra");
			btnRestar.setBounds(560, 278, 46, 23);
		}
		return btnRestar;
	}

	private JTextField getTxtPrecio() {
		if (txtPrecio == null) {
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(414, 347, 86, 20);
			txtPrecio.setColumns(10);
		}
		return txtPrecio;
	}

	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setBounds(414, 321, 86, 20);
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
			btnSiguiente.setEnabled(false);
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

	protected void inicializar() {
		catalogo.inicializar();
		// elimina todos los articulos del pedido
		pedido.inicializar();
		// volver a selecciona el 1¬∫ articulo del combo
		cbArticulos.setSelectedIndex(0);
		txtCantidad.setText(""); // pone unidades a 0
		txtPrecio.setText(""); // pone precio a 0
		btnSiguiente.setEnabled(false); // desahabilita boton siguiente
	}

	protected Pedido getPedido() {
		return pedido;
	}

	private JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("");
			btnCarrito.setToolTipText("Muestra la cesta de la compra");
			btnCarrito.setMnemonic('C');
			btnCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaCarrito();
				}
			});
			btnCarrito.setDefaultCapable(false);
			btnCarrito.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			btnCarrito.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/carro_compra.jpg")));
			btnCarrito.setBounds(560, 25, 40, 40);
		}
		return btnCarrito;
	}

	private void mostrarVentanaCarrito() {
		VentanaCarrito vCarrito = new VentanaCarrito(this);
		vCarrito.setLocationRelativeTo(null);
		vCarrito.setModal(true);
		vCarrito.setVisible(true);
	}
}
