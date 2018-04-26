package igu;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import javafx.scene.control.ToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar barraMenu;
	private JToolBar barraHerramientas;
	private JButton btNuevo;
	private JButton btGuardar;
	private JButton btAbrir;
	private JButton btImprimir;
	private JPanel barraEstado;
	private JPanel pnTextos;
	private JScrollPane scOriginal;
	private JScrollPane scTraducido;
	private JTextArea arOriginal;
	private JTextArea arTraducido;
	private JButton btEspa�ol;
	private JButton btFrances;
	private JButton btIngles;
	private JLabel etDocOriginal;
	private JLabel etIdOriginal;
	private JLabel etDocTraducido;
	private JLabel etIdTraducido;
	private JMenu menuArchivo;
	private JMenu menuEditar;
	private JMenu menuTraducir;
	private JMenu menuHerramientas;
	private JMenu menuAyuda;
	private JMenuItem itGuardarComo;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private pintarBorde pB = null;
	private static openWindow oW = null;
	private colorFondo cL;
	private JToggleButton tglbtnSinNmeros;
	private boolean pN;
	private noNum nN;

	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuEditar());
			barraMenu.add(getMenuTraducir());
			barraMenu.add(getMenuHerramientas());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208, 204, 204));
			barraHerramientas.add(getBtNuevo());
			barraHerramientas.add(getBtAbrir());
			barraHerramientas.add(getBtGuardar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtIngles());
			barraHerramientas.add(getBtEspa�ol());
			barraHerramientas.add(getBtFrances());
			barraHerramientas.add(getTglbtnSinNmeros());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Nuevo.png")));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.setPreferredSize(new java.awt.Dimension(24, 24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btNuevo.addMouseListener(pB);
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Guardar.png")));
			btGuardar.setBorderPainted(false);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24, 24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btGuardar.addMouseListener(pB);
		}
		return btGuardar;
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Abrir.png")));
			btAbrir.setBorderPainted(false);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24, 24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24, 24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24, 24));
			btAbrir.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btAbrir.addMouseListener(pB);
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Imprimir.png")));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btImprimir.addMouseListener(pB);
		}
		return btImprimir;
	}

	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			barraEstado = new JPanel();
			barraEstado.setLayout(new GridLayout(1, 4, 0, 0));
			barraEstado.add(getEtDocOriginal());
			barraEstado.add(getEtIdOriginal());
			barraEstado.add(getEtDocTraducido());
			barraEstado.add(getEtIdTraducido());
		}
		return barraEstado;
	}

	private JLabel getEtDocOriginal() {
		if (etDocOriginal == null) {
			etDocOriginal = new JLabel();
			etDocOriginal.setText("Documento Original");
			etDocOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocOriginal
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocOriginal;
	}

	private JLabel getEtIdOriginal() {
		if (etIdOriginal == null) {
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Espa�ol");
			etIdOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etIdOriginal
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etIdOriginal;
	}

	private JLabel getEtDocTraducido() {
		if (etDocTraducido == null) {
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocTraducido
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocTraducido;
	}

	private JLabel getEtIdTraducido() {
		if (etIdTraducido == null) {
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Ingl�s");
			etIdTraducido
					.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		}
		return etIdTraducido;
	}

	private JPanel getPnTextos() {
		if (pnTextos == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnTextos = new JPanel();
			pnTextos.setLayout(gridLayout);
			pnTextos.add(getScOriginal(), null);
			pnTextos.add(getScTraducido(), null);
		}
		return pnTextos;
	}

	private JScrollPane getScOriginal() {
		if (scOriginal == null) {
			scOriginal = new JScrollPane();
			scOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Original",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51, 51, 51)));
			scOriginal.setViewportView(getArOriginal());
		}
		return scOriginal;
	}

	private JScrollPane getScTraducido() {
		if (scTraducido == null) {
			scTraducido = new JScrollPane();
			scTraducido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Traducido",
					javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
					javax.swing.border.TitledBorder.DEFAULT_POSITION,
					new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51, 51, 51)));
			scTraducido.setViewportView(getArTraducido());
		}
		return scTraducido;
	}

	private JTextArea getArOriginal() {
		if (arOriginal == null) {
			arOriginal = new JTextArea();
			arOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arOriginal.setWrapStyleWord(true);
			arOriginal.setBackground(java.awt.Color.lightGray);
			arOriginal.setLineWrap(true);
			arOriginal.addFocusListener(cL);

		}
		return arOriginal;
	}

	private JTextArea getArTraducido() {
		if (arTraducido == null) {
			arTraducido = new JTextArea();
			arTraducido.setWrapStyleWord(true);
			arTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arTraducido.setBackground(java.awt.Color.lightGray);
			arTraducido.setLineWrap(true);
			arTraducido.addFocusListener(cL);
		}
		return arTraducido;
	}

	private JButton getBtEspa�ol() {
		if (btEspa�ol == null) {
			btEspa�ol = new JButton();
			btEspa�ol.setText("ES");
			btEspa�ol.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14));
			btEspa�ol.setBorderPainted(false);
			btEspa�ol.setPreferredSize(new java.awt.Dimension(24, 24));
			btEspa�ol.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btEspa�ol.setMaximumSize(new java.awt.Dimension(24, 24));
			btEspa�ol.setMinimumSize(new java.awt.Dimension(24, 24));
			btEspa�ol.setContentAreaFilled(false);
			btEspa�ol.addMouseListener(pB);

		}
		return btEspa�ol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14));
			btFrances.setPreferredSize(new java.awt.Dimension(25, 24));
			btFrances.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btFrances.setMaximumSize(new java.awt.Dimension(25, 24));
			btFrances.setMinimumSize(new java.awt.Dimension(25, 24));
			btFrances.setContentAreaFilled(false);
			btFrances.addMouseListener(pB);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 14));
			btIngles.setPreferredSize(new java.awt.Dimension(24, 24));
			btIngles.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btIngles.setMaximumSize(new java.awt.Dimension(24, 24));
			btIngles.setMinimumSize(new java.awt.Dimension(24, 24));
			btIngles.setContentAreaFilled(false);
			btIngles.addMouseListener(pB);
		}
		return btIngles;
	}

	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setText("Archivo");
			menuArchivo.add(getItNuevo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItGuardarComo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItSalir());
		}
		return menuArchivo;
	}

	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu();
			menuEditar.setText("Editar");
		}
		return menuEditar;
	}

	private JMenu getMenuTraducir() {
		if (menuTraducir == null) {
			menuTraducir = new JMenu();
			menuTraducir.setText("Traducir");
		}
		return menuTraducir;
	}

	private JMenu getMenuHerramientas() {
		if (menuHerramientas == null) {
			menuHerramientas = new JMenu();
			menuHerramientas.setText("Herramientas");
		}
		return menuHerramientas;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
		}
		return menuAyuda;
	}

	private JMenuItem getItGuardarComo() {
		if (itGuardarComo == null) {
			itGuardarComo = new JMenuItem();
			itGuardarComo.setText("Guardar como...");
		}
		return itGuardarComo;
	}

	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem();
			itNuevo.setText("Nuevo");
		}
		return itNuevo;
	}

	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem();
			itSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					itSalir.addActionListener((ActionListener) oW);8
				}
			});			
			itSalir.setText("Salir");
		}
		return itSalir;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.addWindowListener(oW);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		pB = new pintarBorde();
		oW = new openWindow();
		cL = new colorFondo();
		nN = new noNum();
		pN = false;
		setSize(981, 586);
		setJMenuBar(getBarraMenu());
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setTitle("Traductor de Textos");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(getBarraHerramientas(), java.awt.BorderLayout.NORTH);
		contentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
		contentPane.add(getPnTextos(), java.awt.BorderLayout.CENTER);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}

	// 1
	class colorFondo extends FocusAdapter {
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(java.awt.Color.white);
		}

		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(java.awt.Color.LIGHT_GRAY);
		}
	}

	// 2 y 6
	class openWindow extends WindowAdapter {
		public void windowOpened(WindowEvent e) {
			arOriginal.grabFocus();
		}
		public void windowClosing(WindowEvent e) {
			if (JOptionPane.showConfirmDialog(null, "�Desea guardar los cambios?", getTitle(),
					getDefaultCloseOperation()) == JOptionPane.YES_OPTION)
				System.exit(EXIT_ON_CLOSE);
		}
	}

	// 3
	class pintarBorde extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			((JButton) e.getSource()).setBorderPainted(true);
		}

		public void mouseExited(MouseEvent e) {
			((JButton) e.getSource()).setBorderPainted(false);
		}
	}

	// 4
	class noNum extends KeyAdapter {
		public void compruebaTecla(KeyEvent e) {
			char teclaPulsada = e.getKeyChar();
			if (Character.isDigit(teclaPulsada)) {
				e.consume();
			}
		}

		public void keyTyped(KeyEvent e) {
			compruebaTecla(e);
		}
	}

	private JToggleButton getTglbtnSinNmeros() {
		if (tglbtnSinNmeros == null) {
			tglbtnSinNmeros = new JToggleButton("NUM");
			tglbtnSinNmeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (pN) {
						pN = false;
						arOriginal.removeKeyListener(nN);
					} else {
						pN = true;
						arOriginal.addKeyListener(nN);
					}
					arOriginal.grabFocus();
				}
			});
		}
		return tglbtnSinNmeros;
	}


	

		
	
}
