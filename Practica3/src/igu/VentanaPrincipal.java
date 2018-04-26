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

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DropMode;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblPCACC;
	private JLabel lblArticulos;
	private JComboBox comboArticulos;
	private JLabel lblUnidades;
	private JTextField txtUnidades;
	private JButton btnComprar;
	private JLabel lblPrecioPedido;
	private JTextField textPrecio;
	private JButton btnSiguiente;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setTitle("Venta de Accesorios de Ordenador\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogo());
		contentPane.add(getLblPCACC());
		contentPane.add(getLblArticulos());
		contentPane.add(getComboArticulos());
		contentPane.add(getLblUnidades());
		contentPane.add(getTxtUnidades());
		contentPane.add(getBtnComprar());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getTextPrecio());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
			lblLogo.setBounds(10, 11, 134, 138);
		}
		return lblLogo;
	}
	private JLabel getLblPCACC() {
		if (lblPCACC == null) {
			lblPCACC = new JLabel("PC-ACCESORIOS\r\n\r\n");
			lblPCACC.setHorizontalAlignment(SwingConstants.CENTER);
			lblPCACC.setForeground(Color.MAGENTA);
			lblPCACC.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
			lblPCACC.setBounds(278, 11, 384, 107);
		}
		return lblPCACC;
	}
	private JLabel getLblArticulos() {
		if (lblArticulos == null) {
			lblArticulos = new JLabel("Art\u00EDculos\r\n");
			lblArticulos.setDisplayedMnemonic('a');
			lblArticulos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblArticulos.setBounds(10, 195, 74, 14);
		}
		return lblArticulos;
	}
	private JComboBox getComboArticulos() {
		if (comboArticulos == null) {
			comboArticulos = new JComboBox();
			comboArticulos.setBounds(10, 220, 384, 32);
		}
		return comboArticulos;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades");
			lblUnidades.setLabelFor(getTxtUnidades());
			lblUnidades.setDisplayedMnemonic('u');
			lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblUnidades.setBounds(505, 195, 63, 14);
		}
		return lblUnidades;
	}
	private JTextField getTxtUnidades() {
		if (txtUnidades == null) {
			txtUnidades = new JTextField();
			txtUnidades.setBounds(505, 220, 63, 32);
			txtUnidades.setColumns(10);
		}
		return txtUnidades;
	}
	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.setMnemonic('o');
			btnComprar.setBounds(601, 217, 89, 35);
		}
		return btnComprar;
	}
	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido");
			lblPrecioPedido.setBounds(505, 272, 86, 14);
		}
		return lblPrecioPedido;
	}
	private JTextField getTextPrecio() {
		if (textPrecio == null) {
			textPrecio = new JTextField();
			textPrecio.setEditable(false);
			textPrecio.setBounds(505, 297, 185, 23);
			textPrecio.setColumns(10);
		}
		return textPrecio;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaRegistro vR = new VentanaRegistro();
					//vR.setLocationRelativeTo(this);
					vR.setModal(true);
					vR.setVisible(true);
				}
			});
			btnSiguiente.setMnemonic('s');
			btnSiguiente.setBounds(505, 331, 107, 32);
		}
		return btnSiguiente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setMnemonic('c');
			btnCancelar.setBounds(622, 331, 100, 32);
		}
		return btnCancelar;
	}
}
