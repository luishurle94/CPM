package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import logica.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JTextField txtPuntuacionLiebre;
	private JTextField txtPuntuacionTortuga;
	private JButton btnDado;
	private JLabel lblPuntuacion;
	private JPanel pnLiebre;
	private JButton btnLiebre00;
	private JButton btnLiebre01;
	private JTextField txtMovimientos;
	private JButton btnLiebre02;
	private JButton btnLiebre03;
	private JButton btnLiebre04;
	private JButton btnLiebre05;
	private JButton btnLiebre06;
	private JButton btnLiebre07;
	private JButton btnLiebre08;
	private JButton btnLiebre09;
	private JButton btnLiebre10;
	private JPanel pnTortuga;
	private JButton btnTortuga00;
	private JButton btnTortuga01;
	private JButton btnTortuga02;
	private JButton btnTortuga03;
	private JButton btnTortuga04;
	private JButton btnTortuga05;
	private JButton btnTortuga06;
	private JButton btnTortuga07;
	private JButton btnTortuga08;
	private JButton btnTortuga09;
	private JButton btnTortuga10;

	private Carrera carrera;
	private JLabel lbLiebre;
	private JLabel lblTortuga;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
		setTitle("El juego de la liebre y la tortuga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 351);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.BLACK);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getTxtPuntuacionLiebre());
		pnPrincipal.add(getTxtPuntuacionTortuga());
		pnPrincipal.add(getBtnDado());
		pnPrincipal.add(getTxtMovimientos());
		pnPrincipal.add(getLblPuntuacion());
		pnPrincipal.add(getPnLiebre());
		pnPrincipal.add(getPnTortuga());
		activarPanel(pnLiebre, false);
		activarPanel(pnTortuga, false);
		pnPrincipal.add(getLbLiebre());
		pnPrincipal.add(getLblTortuga());
		carrera = new Carrera();
		pintarLiebre();
		pintarTortuga();
		this.setLocationRelativeTo(null);
	}

	private JLabel getLbLiebre() {
		if (lbLiebre == null) {
			lbLiebre = new JLabel("");
			lbLiebre.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
			lbLiebre.setBounds(548, 36, 35, 32);
		}
		return lbLiebre;
	}

	private JLabel getLblTortuga() {
		if (lblTortuga == null) {
			lblTortuga = new JLabel("");
			lblTortuga.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/tortuga_peq.JPG")));
			lblTortuga.setBounds(548, 75, 35, 32);
		}
		return lblTortuga;
	}

	private JTextField getTxtPuntuacionLiebre() {
		if (txtPuntuacionLiebre == null) {
			txtPuntuacionLiebre = new JTextField();
			txtPuntuacionLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacionLiebre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPuntuacionLiebre.setText("0");
			txtPuntuacionLiebre.setForeground(Color.MAGENTA);
			txtPuntuacionLiebre.setBackground(Color.BLACK);
			txtPuntuacionLiebre.setEditable(false);
			txtPuntuacionLiebre.setBounds(593, 39, 125, 32);
			txtPuntuacionLiebre.setColumns(10);
		}
		return txtPuntuacionLiebre;
	}

	private JTextField getTxtPuntuacionTortuga() {
		if (txtPuntuacionTortuga == null) {
			txtPuntuacionTortuga = new JTextField();
			txtPuntuacionTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacionTortuga.setForeground(Color.MAGENTA);
			txtPuntuacionTortuga.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPuntuacionTortuga.setText("0");
			txtPuntuacionTortuga.setBackground(Color.BLACK);
			txtPuntuacionTortuga.setEditable(false);
			txtPuntuacionTortuga.setColumns(10);
			txtPuntuacionTortuga.setBounds(593, 75, 125, 32);
		}
		return txtPuntuacionTortuga;
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (carrera.lanzarDado()) {
						txtMovimientos.setText(
								String.valueOf(carrera.getNumeroDado()));
						activarCalle(carrera.getCorredorActivo());
						btnDado.setEnabled(false);
					} else {
						txtMovimientos.setText(
								String.valueOf(carrera.getNumeroDado()));
						JOptionPane.showMessageDialog(null,
								"Movimiento no válido.\nPasa turno");
					}
				}
			});
			btnDado.setToolTipText("Click para lanzar el dado");
			btnDado.setBorderPainted(false);
			btnDado.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setBounds(38, 24, 67, 92);
		}
		return btnDado;
	}

	private void activarCalle(Corredor corredor) {
		if (corredor.getNombre().equals("liebre")) {
			activarPanel(pnTortuga, false);
			activarPanel(pnLiebre, true);
		} else {
			activarPanel(pnTortuga, true);
			activarPanel(pnLiebre, false);
		}
	}

	private void activarPanel(JPanel panel, boolean habilitado) {
		Component[] botones = panel.getComponents();
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			boton.setEnabled(habilitado);
		}
	}

	private JLabel getLblPuntuacion() {
		if (lblPuntuacion == null) {
			lblPuntuacion = new JLabel("SCORE");
			lblPuntuacion.setFont(new Font("Jokerman", Font.PLAIN, 45));
			lblPuntuacion.setForeground(Color.YELLOW);
			lblPuntuacion.setBounds(352, 39, 168, 56);
		}
		return lblPuntuacion;
	}

	private JPanel getPnLiebre() {
		if (pnLiebre == null) {
			pnLiebre = new JPanel();
			pnLiebre.setBorder(new LineBorder(new Color(0, 0, 255)));
			pnLiebre.setBackground(Color.BLUE);
			pnLiebre.setBounds(38, 140, 695, 65);
			// Configura numero de filas, espacio entre filas, columnas, espacio
			// entre columnas
			pnLiebre.setLayout(new GridLayout(1, 0, 0, 0));
			pnLiebre.add(getBtnLiebre00());
			pnLiebre.add(getBtnLiebre01());
			pnLiebre.add(getBtnLiebre02());
			pnLiebre.add(getBtnLiebre03());
			pnLiebre.add(getBtnLiebre04());
			pnLiebre.add(getBtnLiebre05());
			pnLiebre.add(getBtnLiebre06());
			pnLiebre.add(getBtnLiebre07());
			pnLiebre.add(getBtnLiebre08());
			pnLiebre.add(getBtnLiebre09());
			pnLiebre.add(getBtnLiebre10());
		}
		return pnLiebre;
	}

	private JButton getBtnLiebre00() {
		if (btnLiebre00 == null) {
			btnLiebre00 = new JButton("");
			btnLiebre00.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre00.setBorder(new LineBorder(Color.BLUE));
			btnLiebre00.setBackground(Color.BLACK);
			btnLiebre00.setForeground(Color.BLACK);
			btnLiebre00.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		}
		return btnLiebre00;
	}

	private JButton getBtnLiebre01() {
		if (btnLiebre01 == null) {
			btnLiebre01 = new JButton("");
			btnLiebre01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(1);
				}
			});
			btnLiebre01.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre01.setBorder(new LineBorder(Color.BLUE));
			btnLiebre01.setBackground(Color.BLACK);
			btnLiebre01.setForeground(Color.BLACK);
		}
		return btnLiebre01;
	}

	private JTextField getTxtMovimientos() {
		if (txtMovimientos == null) {
			txtMovimientos = new JTextField();
			txtMovimientos.setBorder(null);
			txtMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
			txtMovimientos.setEditable(false);
			txtMovimientos.setForeground(Color.GREEN);
			txtMovimientos
					.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 60));
			txtMovimientos.setBorder(null);
			txtMovimientos.setText("0");
			txtMovimientos.setBackground(Color.BLACK);
			txtMovimientos.setBounds(136, 24, 47, 77);
			txtMovimientos.setColumns(10);
		}
		return txtMovimientos;
	}

	private JButton getBtnLiebre02() {
		if (btnLiebre02 == null) {
			btnLiebre02 = new JButton("");
			btnLiebre02.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(2);
				}
			});
			btnLiebre02.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre02.setBorder(new LineBorder(Color.BLUE));
			btnLiebre02.setBackground(Color.BLACK);
			btnLiebre02.setForeground(Color.BLACK);
		}
		return btnLiebre02;
	}

	private JButton getBtnLiebre03() {
		if (btnLiebre03 == null) {
			btnLiebre03 = new JButton("");
			btnLiebre03.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(3);
				}
			});
			btnLiebre03.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre03.setBorder(new LineBorder(Color.BLUE));
			btnLiebre03.setBackground(Color.BLACK);
			btnLiebre03.setForeground(Color.BLACK);
		}
		return btnLiebre03;
	}

	private JButton getBtnLiebre04() {
		if (btnLiebre04 == null) {
			btnLiebre04 = new JButton("");
			btnLiebre04.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(4);
				}
			});
			btnLiebre04.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre04.setBorder(new LineBorder(Color.BLUE));
			btnLiebre04.setBackground(Color.BLACK);
			btnLiebre04.setForeground(Color.BLACK);
		}
		return btnLiebre04;
	}

	private JButton getBtnLiebre05() {
		if (btnLiebre05 == null) {
			btnLiebre05 = new JButton("");
			btnLiebre05.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(5);
				}
			});
			btnLiebre05.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre05.setBorder(new LineBorder(Color.BLUE));
			btnLiebre05.setBackground(Color.BLACK);
			btnLiebre05.setForeground(Color.BLACK);
		}
		return btnLiebre05;
	}

	private JButton getBtnLiebre06() {
		if (btnLiebre06 == null) {
			btnLiebre06 = new JButton("");
			btnLiebre06.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(6);
				}
			});
			btnLiebre06.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre06.setBorder(new LineBorder(Color.BLUE));
			btnLiebre06.setBackground(Color.BLACK);
			btnLiebre06.setForeground(Color.BLACK);
		}
		return btnLiebre06;
	}

	private JButton getBtnLiebre07() {
		if (btnLiebre07 == null) {
			btnLiebre07 = new JButton("");
			btnLiebre07.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(7);
				}
			});
			btnLiebre07.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre07.setBorder(new LineBorder(Color.BLUE));
			btnLiebre07.setBackground(Color.BLACK);
			btnLiebre07.setForeground(Color.BLACK);
		}
		return btnLiebre07;
	}

	private JButton getBtnLiebre08() {
		if (btnLiebre08 == null) {
			btnLiebre08 = new JButton("");
			btnLiebre08.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(8);
				}
			});
			btnLiebre08.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre08.setBorder(new LineBorder(Color.BLUE));
			btnLiebre08.setBackground(Color.BLACK);
			btnLiebre08.setForeground(Color.BLACK);
		}
		return btnLiebre08;
	}

	private JButton getBtnLiebre09() {
		if (btnLiebre09 == null) {
			btnLiebre09 = new JButton("");
			btnLiebre09.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(9);
				}
			});
			btnLiebre09.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre09.setBorder(new LineBorder(Color.BLUE));
			btnLiebre09.setBackground(Color.BLACK);
			btnLiebre09.setForeground(Color.BLACK);
		}
		return btnLiebre09;
	}

	private JButton getBtnLiebre10() {
		if (btnLiebre10 == null) {
			btnLiebre10 = new JButton("");
			btnLiebre10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(10);
				}
			});
			btnLiebre10.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btnLiebre10.setBorder(new LineBorder(Color.BLUE));
			btnLiebre10.setBackground(Color.BLACK);
			btnLiebre10.setForeground(Color.BLACK);
		}
		return btnLiebre10;
	}

	private JPanel getPnTortuga() {
		if (pnTortuga == null) {
			pnTortuga = new JPanel();
			pnTortuga.setBorder(new LineBorder(new Color(0, 0, 255)));
			pnTortuga.setBackground(Color.BLACK);
			pnTortuga.setBounds(38, 223, 695, 65);
			pnTortuga.setLayout(new GridLayout(1, 0, 0, 0));
			pnTortuga.add(getBtnTortuga00());
			pnTortuga.add(getBtnTortuga01());
			pnTortuga.add(getBtnTortuga02());
			pnTortuga.add(getBtnTortuga03());
			pnTortuga.add(getBtnTortuga04());
			pnTortuga.add(getBtnTortuga05());
			pnTortuga.add(getBtnTortuga06());
			pnTortuga.add(getBtnTortuga07());
			pnTortuga.add(getBtnTortuga08());
			pnTortuga.add(getBtnTortuga09());
			pnTortuga.add(getBtnTortuga10());
		}
		return pnTortuga;
	}

	private JButton getBtnTortuga00() {
		if (btnTortuga00 == null) {
			btnTortuga00 = new JButton("");
			btnTortuga00.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga00.setBorder(new LineBorder(Color.BLUE));
			btnTortuga00.setBackground(Color.BLACK);
			btnTortuga00.setForeground(Color.BLACK);
			btnTortuga00.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
		}
		return btnTortuga00;
	}

	private JButton getBtnTortuga01() {
		if (btnTortuga01 == null) {
			btnTortuga01 = new JButton("");
			btnTortuga01.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(1);
				}
			});
			btnTortuga01.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga01.setBorder(new LineBorder(Color.BLUE));
			btnTortuga01.setBackground(Color.BLACK);
			btnTortuga01.setForeground(Color.BLACK);
		}
		return btnTortuga01;
	}

	private JButton getBtnTortuga02() {
		if (btnTortuga02 == null) {
			btnTortuga02 = new JButton("");
			btnTortuga02.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(2);
				}
			});
			btnTortuga02.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga02.setBorder(new LineBorder(Color.BLUE));
			btnTortuga02.setBackground(Color.BLACK);
			btnTortuga02.setForeground(Color.BLACK);
		}
		return btnTortuga02;
	}

	private JButton getBtnTortuga03() {
		if (btnTortuga03 == null) {
			btnTortuga03 = new JButton("");
			btnTortuga03.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(3);
				}
			});
			btnTortuga03.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga03.setBorder(new LineBorder(Color.BLUE));
			btnTortuga03.setBackground(Color.BLACK);
			btnTortuga03.setForeground(Color.BLACK);
		}
		return btnTortuga03;
	}

	private JButton getBtnTortuga04() {
		if (btnTortuga04 == null) {
			btnTortuga04 = new JButton("");
			btnTortuga04.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(4);
				}
			});
			btnTortuga04.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga04.setBorder(new LineBorder(Color.BLUE));
			btnTortuga04.setBackground(Color.BLACK);
			btnTortuga04.setForeground(Color.BLACK);
		}
		return btnTortuga04;
	}

	private JButton getBtnTortuga05() {
		if (btnTortuga05 == null) {
			btnTortuga05 = new JButton("");
			btnTortuga05.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(5);
				}
			});
			btnTortuga05.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga05.setBorder(new LineBorder(Color.BLUE));
			btnTortuga05.setBackground(Color.BLACK);
			btnTortuga05.setForeground(Color.BLACK);
		}
		return btnTortuga05;
	}

	private JButton getBtnTortuga06() {
		if (btnTortuga06 == null) {
			btnTortuga06 = new JButton("");
			btnTortuga06.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(6);
				}
			});
			btnTortuga06.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga06.setBorder(new LineBorder(Color.BLUE));
			btnTortuga06.setBackground(Color.BLACK);
			btnTortuga06.setForeground(Color.BLACK);
		}
		return btnTortuga06;
	}

	private JButton getBtnTortuga07() {
		if (btnTortuga07 == null) {
			btnTortuga07 = new JButton("");
			btnTortuga07.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(7);
				}
			});
			btnTortuga07.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga07.setBorder(new LineBorder(Color.BLUE));
			btnTortuga07.setBackground(Color.BLACK);
			btnTortuga07.setForeground(Color.BLACK);
		}
		return btnTortuga07;
	}

	private JButton getBtnTortuga08() {
		if (btnTortuga08 == null) {
			btnTortuga08 = new JButton("");
			btnTortuga08.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(8);
				}
			});
			btnTortuga08.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga08.setBorder(new LineBorder(Color.BLUE));
			btnTortuga08.setBackground(Color.BLACK);
			btnTortuga08.setForeground(Color.BLACK);
		}
		return btnTortuga08;
	}

	private JButton getBtnTortuga09() {
		if (btnTortuga09 == null) {
			btnTortuga09 = new JButton("");
			btnTortuga09.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(9);
				}
			});
			btnTortuga09.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga09.setBorder(new LineBorder(Color.BLUE));
			btnTortuga09.setBackground(Color.BLACK);
			btnTortuga09.setForeground(Color.BLACK);
		}
		return btnTortuga09;
	}

	private JButton getBtnTortuga10() {
		if (btnTortuga10 == null) {
			btnTortuga10 = new JButton("");
			btnTortuga10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(10);
				}
			});
			btnTortuga10.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btnTortuga10.setBorder(new LineBorder(Color.BLUE));
			btnTortuga10.setBackground(Color.BLACK);
			btnTortuga10.setForeground(Color.BLACK);
		}
		return btnTortuga10;
	}

	private void jugar(int posicion) {
		if (carrera.resolverJugada(posicion)) {
			representaEstado();
			activarPanel(pnLiebre, false);
			activarPanel(pnTortuga, false);
			btnDado.setEnabled(true);
		}
		if (carrera.isPartidaFinalizadaLiebre()) {
			JOptionPane.showMessageDialog(null,
					"Partida finalizada\n" + "El ganador es: la liebre");
			btnDado.setEnabled(false);
		} else if (carrera.isPartidaFinalizadaTortuga()) {
			JOptionPane.showMessageDialog(null,
					"Partida finalizada\n" + "El ganador es: la tortuga");
			btnDado.setEnabled(false);
		}
	}

	private void representaEstado() {
		txtMovimientos.setText("");
		txtPuntuacionLiebre
				.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		txtPuntuacionTortuga
				.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
		pintarLiebre();
		pintarTortuga();
	}

	private void pintarCalle(Corredor corredor, Component[] botones) {
		String imagen = "/img/" + corredor.getFoto();
		String imagenArbol = "/img/arbol.jpg";
		String durmiendo = "/img/liebre_durmiendo.jpg";
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			if (i == corredor.getPosicion()) {
				if (corredor.getCalleAsignada().getCasilla(i).tieneArbol()) {
					boton.setIcon(
							new ImageIcon(getClass().getResource(durmiendo)));
					boton.setDisabledIcon(
							new ImageIcon(getClass().getResource(durmiendo)));
				} else {
					boton.setIcon(
							new ImageIcon(getClass().getResource(imagen)));
					boton.setDisabledIcon(
							new ImageIcon(getClass().getResource(imagen)));
				}
			} else if (corredor.getCalleAsignada().getCasilla(i).tieneArbol()) {
				boton.setIcon(
						new ImageIcon(getClass().getResource(imagenArbol)));
				boton.setDisabledIcon(
						new ImageIcon(getClass().getResource(imagenArbol)));
			} else
				boton.setIcon(null);
		}
	}

	private void pintarLiebre() {
		pintarCalle(carrera.getLiebre(), pnLiebre.getComponents());
	}

	private void pintarTortuga() {
		pintarCalle(carrera.getTortuga(), pnTortuga.getComponents());
	}
}
