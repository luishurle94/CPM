package igu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.text.DateFormat;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnBotones;
	private JPanel pnFechaHora;
	private JPanel pnBandera;
	private JPanel pnTexto;
	private JButton btEspañol;
	private JButton btIngles;
	private JButton btFrances;
	private JLabel lbFecha;
	private JLabel lbHora;
	private JLabel lbBandera;
	private JTextArea taTexto;

	ResourceBundle textos;
	private JButton btItaliano;
	private JTextField txBandera;

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
		setTitle("Ejemplo de Internacionalización");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnBotones(), BorderLayout.NORTH);
		contentPane.add(getPnFechaHora(), BorderLayout.SOUTH);
		contentPane.add(getPnBandera(), BorderLayout.WEST);
		contentPane.add(getPnTexto(), BorderLayout.CENTER);
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtEspañol());
			pnBotones.add(getBtIngles());
			pnBotones.add(getBtFrances());
			pnBotones.add(getBtItaliano());
		}
		return pnBotones;
	}

	private JPanel getPnFechaHora() {
		if (pnFechaHora == null) {
			pnFechaHora = new JPanel();
			pnFechaHora.setLayout(new GridLayout(1, 2, 0, 0));
			pnFechaHora.add(getLbFecha());
			pnFechaHora.add(getLbHora());
		}
		return pnFechaHora;
	}

	private JPanel getPnBandera() {
		if (pnBandera == null) {
			pnBandera = new JPanel();
			pnBandera.setLayout(new GridLayout(0, 1, 0, 0));
			pnBandera.add(getLbBandera());
			pnBandera.add(getTxBandera());
		}
		return pnBandera;
	}

	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.setLayout(new BorderLayout(0, 0));
			pnTexto.add(getTaTexto(), BorderLayout.CENTER);
		}
		return pnTexto;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton("ES");
			btEspañol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("es"));
				}
			});
		}
		return btEspañol;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton("EN");
			btIngles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					localizar(new Locale("en"));
				}
			});
		}
		return btIngles;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton("FR");
			btFrances.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("fr"));
				}
			});
		}
		return btFrances;
	}

	private JButton getBtItaliano() {
		if (btItaliano == null) {
			btItaliano = new JButton("IT");
			btItaliano.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("it"));
				}
			});
		}
		return btItaliano;
	}

	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("");
		}
		return lbFecha;
	}

	private JLabel getLbHora() {
		if (lbHora == null) {
			lbHora = new JLabel("");
		}
		return lbHora;
	}

	private JLabel getLbBandera() {
		if (lbBandera == null) {
			lbBandera = new JLabel("");
			lbBandera.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/espana.PNG")));
		}
		return lbBandera;
	}

	private JTextArea getTaTexto() {
		if (taTexto == null) {
			taTexto = new JTextArea();
			taTexto.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
			taTexto.setWrapStyleWord(true);
			taTexto.setLineWrap(true);
		}
		return taTexto;
	}

	private void localizar(Locale localizacion) {

		textos = ResourceBundle.getBundle("rcs/textos", localizacion);

		taTexto.setText(textos.getString("texto1"));

		String imagenBandera = "/img/" + textos.getString("texto2") + ".PNG";
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource(imagenBandera)));
		lbBandera.setIcon(new ImageIcon(VentanaPrincipal.class
				.getResource(imagenBandera)));

		txBandera.setText(textos.getString("texto3"));

		Date fechaHora = new Date();
		// Falta que la fecha tenga el formato correspondiente a la localización
		lbFecha.setText(fechaHora.toString());

		DateFormat formatoHora = DateFormat.getTimeInstance(DateFormat.LONG,
				localizacion);
		lbHora.setText(formatoHora.format(fechaHora));
	}

	private JTextField getTxBandera() {
		if (txBandera == null) {
			txBandera = new JTextField();
			txBandera.setBorder(new EmptyBorder(0, 0, 0, 0));
			txBandera.setEditable(false);
			txBandera.setEnabled(false);
			txBandera.setColumns(10);
		}
		return txBandera;
	}
}
