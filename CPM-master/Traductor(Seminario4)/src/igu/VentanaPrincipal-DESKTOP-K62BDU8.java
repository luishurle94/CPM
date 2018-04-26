package igu;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
	private JButton btEspañol;
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

	private String[] titulosCuadros = { "Documento Original",
			"Documento traducido" };
	private FocusArea focusArea;// Ejercicio 1
	private BordeBoton bordeBoton;// Ejercicio 3
	private JToggleButton tglbtnNumeros;
	private NumeroTeclado numeroTeclado; // Ejercicio 4

	// Ejercicio 1 - Inicio //

	class FocusArea implements FocusListener {
		@Override
		public void focusGained(FocusEvent arg0) {
			JTextArea area = (JTextArea) arg0.getSource();
			area.setBackground(Color.WHITE);
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			JTextArea area = (JTextArea) arg0.getSource();
			area.setBackground(Color.LIGHT_GRAY);
		}
	}

	private JScrollPane nuevoScrollPanel(JPanel panel, JTextArea area,
			String titulo) {
		JScrollPane aux = new JScrollPane();
		aux.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				titulo, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
				new java.awt.Color(51, 51, 51)));
		aux.setViewportView(area);
		return aux;
	}

	private JTextArea nuevoJTextArea() {
		JTextArea aux = new JTextArea();
		aux.setBorder(javax.swing.BorderFactory
				.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		aux.setWrapStyleWord(true);
		aux.setBackground(java.awt.Color.lightGray);
		aux.setLineWrap(true);
		aux.addFocusListener(focusArea);
		return aux;
	}

	private void crearJScrollPanel(JPanel panel, String[] titulos,
			int numScrollPanel) {
		for (int i = 0; i < numScrollPanel; i++) {
			JScrollPane aux;
			if (i >= titulos.length)
				aux = nuevoScrollPanel(panel, nuevoJTextArea(), "Sin titulo");
			else
				aux = nuevoScrollPanel(panel, nuevoJTextArea(), titulos[i]);
			panel.add(aux);
		}
	}

	// Ejercicio 1 - Fin //

	// Ejercicio 3 - Inicio //

	class BordeBoton implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JButton boton = (JButton) e.getSource();
			boton.setBorderPainted(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JButton boton = (JButton) e.getSource();
			boton.setBorderPainted(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

	}

	private void asociarBordeBoton(JToolBar barra) {
		for (int i = 0; i < barra.getComponentCount(); i++) {
			JButton boton = (JButton) barra.getComponent(i);
			boton.addMouseListener(bordeBoton);
		}
	}

	// Ejercicio 3 - Fin //

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
			barraHerramientas.add(getBtEspañol());
			barraHerramientas.add(getBtFrances());
			asociarBordeBoton(barraHerramientas); // Ejercicio 3
			barraHerramientas.add(getTglbtnNumeros());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon("img/Nuevo.png"));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.setPreferredSize(new java.awt.Dimension(24, 24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24, 24));
			btNuevo.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardarDocumento(); // Ejercicio 5
				}
			});
			btGuardar.setIcon(new ImageIcon("img/Guardar.png"));
			btGuardar.setBorderPainted(false);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24, 24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24, 24));
			btGuardar.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btGuardar;
	}

	// Ejercicio 5
	private void guardarDocumento() {
		JOptionPane.showInputDialog(null, "Introduce titulo al documento");
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon("img/Abrir.png"));
			btAbrir.setBorderPainted(false);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24, 24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24, 24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24, 24));
			btAbrir.setMargin(new java.awt.Insets(0, 0, 0, 0));
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon("img/Imprimir.png"));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24, 24));
			btImprimir.setMargin(new java.awt.Insets(0, 0, 0, 0));
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
			etDocOriginal.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etDocOriginal
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocOriginal;
	}

	private JLabel getEtIdOriginal() {
		if (etIdOriginal == null) {
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Español");
			etIdOriginal.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etIdOriginal
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etIdOriginal;
	}

	private JLabel getEtDocTraducido() {
		if (etDocTraducido == null) {
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
			etDocTraducido
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocTraducido;
	}

	private JLabel getEtIdTraducido() {
		if (etIdTraducido == null) {
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Inglés");
			etIdTraducido
					.setBorder(javax.swing.BorderFactory
							.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog",
					java.awt.Font.PLAIN, 12));
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
			crearJScrollPanel(pnTextos, titulosCuadros, 2); // Ejercicio 2
		}
		return pnTextos;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton();
			btEspañol.setText("ES");
			btEspañol.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					14));
			btEspañol.setBorderPainted(false);
			btEspañol.setPreferredSize(new java.awt.Dimension(24, 24));
			btEspañol.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btEspañol.setMaximumSize(new java.awt.Dimension(24, 24));
			btEspañol.setMinimumSize(new java.awt.Dimension(24, 24));
			btEspañol.setContentAreaFilled(false);

		}
		return btEspañol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					14));
			btFrances.setPreferredSize(new java.awt.Dimension(25, 24));
			btFrances.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btFrances.setMaximumSize(new java.awt.Dimension(25, 24));
			btFrances.setMinimumSize(new java.awt.Dimension(25, 24));
			btFrances.setContentAreaFilled(false);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN,
					14));
			btIngles.setPreferredSize(new java.awt.Dimension(24, 24));
			btIngles.setMargin(new java.awt.Insets(0, 0, 0, 0));
			btIngles.setMaximumSize(new java.awt.Dimension(24, 24));
			btIngles.setMinimumSize(new java.awt.Dimension(24, 24));
			btIngles.setContentAreaFilled(false);
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
			itGuardarComo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					guardarDocumento(); // Ejercicio 5
				}
			});
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
			itSalir.setText("Salir");
		}
		return itSalir;
	}

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

	public VentanaPrincipal() {
		focusArea = new FocusArea(); // Ejercicio 1
		bordeBoton = new BordeBoton(); // Ejercicio 3
		numeroTeclado = new NumeroTeclado(); // Ejercicio 4

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

		// Ejercicio 2 - Inicio //
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				JComponent panel = (JComponent) pnTextos.getComponent(0);
				JComponent scroll = (JComponent) panel.getComponent(0);
				JComponent textArea = (JComponent) scroll.getComponent(0);
				JTextArea aux = (JTextArea) textArea;
				aux.grabFocus();
			}
			// Ejercicio 2 - Fin //
			
			// Ejercicio 6 - Inicio //
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				int confirmado = JOptionPane.showConfirmDialog(null, "¿Seguro qué desea cerrar el programa");
				if(confirmado == 0)
					System.exit(0);
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
			
			// Ejercicio 6 - Fin //
		});
		
		

	}

	// Ejercicio 4 - Inicio //

	class NumeroTeclado implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {		
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			compruebaTecla(arg0);
		}

	}

	void compruebaTecla(KeyEvent e) {
		char teclapulsada = e.getKeyChar();
		if (Character.isDigit(teclapulsada))
			e.consume();
	}

	private JToggleButton getTglbtnNumeros() {
		if (tglbtnNumeros == null) {
			tglbtnNumeros = new JToggleButton("N\u00FAmeros");
			tglbtnNumeros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JComponent panel = (JComponent) pnTextos.getComponent(0);
					JComponent scroll = (JComponent) panel.getComponent(0);
					JComponent textArea = (JComponent) scroll.getComponent(0);
					JTextArea aux = (JTextArea) textArea;
					if (tglbtnNumeros.isSelected()) {
						aux.addKeyListener(numeroTeclado);
					} else
						aux.removeKeyListener(numeroTeclado);
					aux.grabFocus();
				}
			});
		}
		return tglbtnNumeros;
	}

	// Ejercicio 4 - Fin //
}
