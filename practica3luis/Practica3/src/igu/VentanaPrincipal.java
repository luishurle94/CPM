package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import logica.*;

import org.jvnet.substance.*;

public class VentanaPrincipal extends JFrame {

	private JPanel pnPrincipal;
	private JLabel lbLogo;
	private JLabel lbEmpresa;
	private JLabel lbArticulos;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lbUnidades;
	private JTextField txUnidades;
	private JButton btComprar;
	private JLabel lbPrecio;
	private JTextField txPrecio;
	private JButton btSiguiente;
	private JButton btCancelar;
	private Catalogo catalogo;
	private Pedido pedido;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin");
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
		
		catalogo = new Catalogo();
		pedido = new Pedido();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setTitle("Venta de Accesorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 462);
		pnPrincipal = new JPanel();
		pnPrincipal.setForeground(Color.LIGHT_GRAY);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getLbLogo());
		pnPrincipal.add(getLbEmpresa());
		pnPrincipal.add(getLbArticulos());
		pnPrincipal.add(getCbArticulos());
		pnPrincipal.add(getLbUnidades());
		pnPrincipal.add(getTxUnidades());
		pnPrincipal.add(getBtComprar());
		pnPrincipal.add(getLbPrecio());
		pnPrincipal.add(getTxPrecio());
		pnPrincipal.add(getBtSiguiente());
		pnPrincipal.add(getBtCancelar());
		pnPrincipal.add(getBtnEliminar());
		
		
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
			lbLogo.setBounds(10, 31, 154, 180);
			setLocationRelativeTo(null);
		}
		return lbLogo;
	}
	private JLabel getLbEmpresa() {
		if (lbEmpresa == null) {
			lbEmpresa = new JLabel("PC-ACCESORIOS");
			lbEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmpresa.setForeground(Color.BLUE);
			lbEmpresa.setFont(new Font("Tahoma", Font.BOLD, 30));
			lbEmpresa.setBounds(218, 66, 303, 84);
		}
		return lbEmpresa;
	}
	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Art\u00EDculos:");
			lbArticulos.setLabelFor(getCbArticulos());
			lbArticulos.setDisplayedMnemonic('A');
			lbArticulos.setBounds(10, 222, 154, 14);
		}
		return lbArticulos;
	}
	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(catalogo.getArticulos()));
			cbArticulos.setBounds(10, 255, 233, 32);
		}
		return cbArticulos;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades");
			lbUnidades.setLabelFor(getTxUnidades());
			lbUnidades.setDisplayedMnemonic('U');
			lbUnidades.setBounds(344, 222, 87, 14);
		}
		return lbUnidades;
	}
	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txUnidades.setText("1");
					txUnidades.selectAll();
				}
				@Override
				public void focusLost(FocusEvent e) {
					
					int unidades = 0;
					boolean error = false;
					try {
						unidades = Integer.parseInt(txUnidades.getText()); 
					}
					catch (NumberFormatException ex) {
						error = true;
					}
					
					if (error || unidades<0)
						txUnidades.setText("");
					
				}
			});
			txUnidades.setBounds(344, 255, 118, 32);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}
	private JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar");
			btComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!txUnidades.getText().equals("")) {
						Articulo articuloSeleccionado = (Articulo)cbArticulos.getSelectedItem();
						int unidadesSolicitadas = Integer.parseInt(txUnidades.getText());
						pedido.add(articuloSeleccionado,unidadesSolicitadas);
						float precioPedido = pedido.calcularTotalSinIva();
						txPrecio.setText(String.valueOf(precioPedido)+  " \u20AC");
						if(articuloSeleccionado.getUnidades() > 10)
							JOptionPane.showMessageDialog(null, "Descuento del 15% aplicado en " + articuloSeleccionado);
						if(!btSiguiente.isEnabled())
							btSiguiente.setEnabled(true);
					}
					else
						txUnidades.grabFocus();
					
				}
			});
			btComprar.setMnemonic('o');
			btComprar.setBounds(472, 255, 89, 32);
		}
		return btComprar;
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio pedido");
			lbPrecio.setDisplayedMnemonic('P');
			lbPrecio.setBounds(344, 304, 112, 20);
		}
		return lbPrecio;
	}
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setEditable(false);
			txPrecio.setBounds(344, 335, 163, 32);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			VentanaPrincipal vvvppp = this;
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VentanaRegistro vR = new VentanaRegistro(vvvppp);
					vR.setLocationRelativeTo(vvvppp);
					vR.setModal(true);
					vR.setVisible(true);
				}
			});
			btSiguiente.setMnemonic('S');
			btSiguiente.setBounds(342, 377, 89, 23);
		}
		return btSiguiente;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btCancelar.setEnabled(true);
			buttonGroup.add(btCancelar);
			btCancelar.setMnemonic('C');
			btCancelar.setBounds(458, 377, 89, 23);
		}
		return btCancelar;
	}
	
	public Pedido getPedido() {
		return this.pedido;
	}
	
	public void Inicializar(){
		pedido.inicializar();
		cbArticulos.setSelectedIndex(0);
		txUnidades.setText("");
		txPrecio.setText("");
		btSiguiente.setEnabled(false);
	}
	private JButton getBtnEliminar() { //cambiarlo todo para que me elimine el numero de unidades que tengo metido
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnEliminar.setMnemonic('e');
			btnEliminar.setBounds(573, 255, 89, 32);
		}
		return btnEliminar;
	}
}
