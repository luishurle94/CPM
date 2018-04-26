package igu;

import logica.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {

	private JPanel panelPrincipal;
	private JButton btDado;
	private JTextField txDado;
	private JLabel lbScore;
	private JLabel lbPuntosLiebre;
	private JPanel pnLiebre;
	private Carrera carrera;
	private JPanel pnTortuga;
	private JLabel lblPuntosTortuga;
	private JLabel lblLiebrePeque;
	private JLabel label;
	private AccionBoton aB;
	private JButton bt;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private JMenuItem itContenidos;
	private JMenuItem itAcercaDe;
	private JSeparator separator;
	private JSeparator separator_1;
	private JMenu mnConfiguracin;
	private JMenuItem itCasillas;
	private int numCasillas;
	private JMenuItem mntmrboles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Carrera carrera = new Carrera();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(carrera);
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
	public VentanaPrincipal(Carrera c) {
		carrera = c;
		numCasillas=11;
		aB = new AccionBoton();
		
		setResizable(false);
		setTitle("El juego de la liebre y la tortuga");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 375);
		setJMenuBar(getMenuBar_1());
		panelPrincipal = new JPanel();
		panelPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panelPrincipal.setForeground(Color.MAGENTA);
		panelPrincipal.setBackground(Color.BLACK);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.add(getBtDado());
		panelPrincipal.add(getTxDado());
		panelPrincipal.add(getLbScore());
		panelPrincipal.add(getLabel_1());
		panelPrincipal.add(getPnLiebre());
		panelPrincipal.add(getPnTortuga());
		panelPrincipal.add(getLblPuntosTortuga());
		panelPrincipal.add(getLabel_1_1());
		panelPrincipal.add(getLabel());
		setLocationRelativeTo(null);
		deshabilitarPanel();
		CrearBotones(pnLiebre);//lo ponemos antes porque sino no hay eventos que asociar
		CrearBotones(pnTortuga);
		asociarEventos(pnLiebre);
		asociarEventos(pnTortuga);
		representarEstadoJuego();
		
		
	}

	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/dado.JPG")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzarDado();
				}

			});
			btDado.setToolTipText("Haga clic para lanzar el dado");
			btDado.setBorder(null);
			btDado.setBorderPainted(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/dado.JPG")));
			btDado.setBounds(25, 13, 69, 85);
		}
		return btDado;
	}

	private void lanzarDado() {
		boolean posibleJugada = carrera.lanzarDado();
		txDado.setText(String.valueOf(Dado.getValor()));
		if (posibleJugada) {
			habilitarPanelCorredorActivo();
			btDado.setEnabled(false);
		} else {
			mostrarMensajeJuego();

			btDado.setEnabled(true);
			deshabilitarPanel();
		}
	}

	private void mostrarMensajeJuego() {
		JOptionPane.showMessageDialog(this,
				"La jugada no es posible. Se cambia de turno.");
		txDado.setText("");
	}

	private JTextField getTxDado() {
		if (txDado == null) {
			txDado = new JTextField();
			txDado.setBorder(null);
			txDado.setHorizontalAlignment(SwingConstants.CENTER);
			txDado.setText("0");
			txDado.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 60));
			txDado.setForeground(Color.GREEN);
			txDado.setBackground(Color.BLACK);
			txDado.setEditable(false);
			txDado.setBounds(151, 13, 102, 85);
			txDado.setColumns(10);
		}
		return txDado;
	}

	private JLabel getLbScore() {
		if (lbScore == null) {
			lbScore = new JLabel("Score:");
			lbScore.setHorizontalAlignment(SwingConstants.CENTER);
			lbScore.setForeground(Color.YELLOW);
			lbScore.setFont(new Font("Jokerman", Font.PLAIN, 50));
			lbScore.setBackground(Color.BLACK);
			lbScore.setBounds(265, 13, 196, 85);
		}
		return lbScore;
	}

	private JLabel getLabel_1() {
		if (lbPuntosLiebre == null) {
			lbPuntosLiebre = new JLabel("0");
			lbPuntosLiebre.setBorder(new LineBorder(Color.WHITE));
			lbPuntosLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			lbPuntosLiebre.setForeground(Color.MAGENTA);
			lbPuntosLiebre.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lbPuntosLiebre.setBackground(Color.BLACK);
			lbPuntosLiebre.setBounds(548, 25, 167, 32);
		}
		return lbPuntosLiebre;
	}

	private JPanel getPnLiebre() {
		if (pnLiebre == null) {
			pnLiebre = new JPanel();
			pnLiebre.setBackground(Color.BLUE);
			pnLiebre.setBorder(new LineBorder(Color.BLUE, 10));
			pnLiebre.setBounds(25, 129, 690, 85);
			pnLiebre.setLayout(new GridLayout(1, 11, 2, 0));
		}
		return pnLiebre;
	}

	private void modificarPanel(JPanel panel, boolean habilitado) {
		for (Component componente : panel.getComponents()) {
			componente.setEnabled(habilitado);
		}
	}

	private void habilitarPanelCorredorActivo() {
		if (carrera.getCorredorActivo().equals(carrera.getLiebre()))
			modificarPanel(pnLiebre, true);
		modificarPanel(pnTortuga, true);

	}

	private void deshabilitarPanel() {
		modificarPanel(pnLiebre, false);
		modificarPanel(pnTortuga, false);
	}

	private void jugar(int posicion) {
		if (carrera.resolverJugada(posicion)) {
			representarEstadoJuego();
			deshabilitarPanel();
		}
	}

	private void representarEstadoJuego() {
		txDado.setText("");
		pintarPuntos();
		pintarCorredor();
		if (carrera.isPartidaFinalizada()) {
			JOptionPane.showMessageDialog(this, "Partida finalizada.");
			if (carrera.getCorredorActivo().getPosicion() == carrera
					.getPosTrampa() && carrera.getCorredorActivo().isTrampa()) {
				JOptionPane.showMessageDialog(this, "Ha caido en una trampa");
				if (carrera.getCorredorActivo() == carrera.getLiebre()) {
					lblPuntosTortuga.setText("0");
				} else {
					lbPuntosLiebre.setText("0");
				}

			} else
				btDado.setEnabled(true);
		}
	}

	private void pintarCorredor() {
		pintarCalle(carrera.getLiebre(), pnLiebre.getComponents());
		pintarCalle(carrera.getTortuga(), pnTortuga.getComponents());
	}

	private void pintarCalle(Corredor corredor, Component[] botones) {
		ImageIcon imagen = new ImageIcon(getClass().getResource(
				"/img/" + corredor.getFoto()));
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			if (i == corredor.getPosicion()) {
				boton.setIcon(imagen);
				boton.setDisabledIcon(imagen);
			} else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}
		if (corredor.getNombre() == "liebre") {
			((JButton) botones[carrera.getPosArbol()]).setIcon(new ImageIcon(
					getClass().getResource("/img/arbol.JPG")));
			((JButton) botones[carrera.getPosArbol()])
					.setDisabledIcon(new ImageIcon(getClass().getResource(
							"/img/arbol.JPG")));
			if (carrera.getLiebre().getPosicion() == carrera.getPosArbol()) {
				((JButton) botones[carrera.getPosArbol()])
						.setIcon(new ImageIcon(getClass().getResource(
								"/img/liebre_durmiendo.JPG")));
				((JButton) botones[carrera.getPosArbol()])
						.setDisabledIcon(new ImageIcon(getClass().getResource(
								"/img/liebre_durmiendo.JPG")));
			}
		}
	}

	private void pintarPuntos() {
		lbPuntosLiebre.setText(String.valueOf(carrera.getLiebre()
				.getPuntuacion()));
		lblPuntosTortuga.setText(String.valueOf(carrera.getTortuga()
				.getPuntuacion()));
	}

	private JPanel getPnTortuga() {
		if (pnTortuga == null) {
			pnTortuga = new JPanel();
			pnTortuga.setBorder(new LineBorder(Color.BLUE, 10));
			pnTortuga.setBackground(Color.BLUE);
			pnTortuga.setBounds(25, 227, 690, 85);
			pnTortuga.setLayout(new GridLayout(1, 11, 2, 0));
		}
		return pnTortuga;
	}

	private JLabel getLblPuntosTortuga() {
		if (lblPuntosTortuga == null) {
			lblPuntosTortuga = new JLabel("0");
			lblPuntosTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntosTortuga.setForeground(Color.MAGENTA);
			lblPuntosTortuga.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblPuntosTortuga.setBorder(new LineBorder(Color.WHITE));
			lblPuntosTortuga.setBackground(Color.BLACK);
			lblPuntosTortuga.setBounds(548, 64, 167, 32);
		}
		return lblPuntosTortuga;
	}

	private JLabel getLabel_1_1() {
		if (lblLiebrePeque == null) {
			lblLiebrePeque = new JLabel("");
			lblLiebrePeque.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/liebre_peq.JPG")));
			lblLiebrePeque.setBounds(493, 25, 56, 32);
		}
		return lblLiebrePeque;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/tortuga_peq.JPG")));
			label.setBounds(493, 64, 56, 32);
		}
		return label;
	}

	// Borre todos los jugar de los botones y los meto en el evento ActionEvent,
	// en mi caso para pulsar un boton
	class AccionBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton bt = (JButton) e.getSource(); // ActionComand, para que
													// pueda poner un valor a
													// cada botón
			jugar(Integer.parseInt(bt.getActionCommand()));
		}
		// Una vez creada la clase, creo el objeto y lo inicializo en el
		// constructor
		//en resumen. creo la clase receptora del evento, creo un objeto de la clase.
	}

	private void asociarEventos(JPanel panel) {
		for (int i = 0; i < Calle.DIM; i++) {
			bt = (JButton) panel.getComponent(i);
			bt.setActionCommand(String.valueOf(i));
			bt.addActionListener(aB);
		}
	}
	
	//IMPORTANTE PARA EL MENU, TODOS LOS ELEMENTOS LLEVAN MNEMONICS, no todos los elementos del menu llevan aceleradores
	//Separadores: (antes del exit o salir, hay un separador) Salir siempre al final del primer menu
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnConfiguracin());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('j');
			mnJuego.add(getItNuevo());
			mnJuego.add(getSeparator());
			mnJuego.add(getItSalir());
		}
		return mnJuego;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('a');
			mnAyuda.add(getItContenidos());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getItAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem("Nuevo");
			itNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nuevo();
				}
			});
			itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			itNuevo.setMnemonic('n');
		}
		return itNuevo;
	}
	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem("Salir");
			itSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			itSalir.setMnemonic('s');
		}
		return itSalir;
	}
	private JMenuItem getItContenidos() {
		if (itContenidos == null) {
			itContenidos = new JMenuItem("Contenidos");
			itContenidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarContenidos();
				}
			});
			itContenidos.setMnemonic('c');
			
		}
		return itContenidos;
	}
	
	private void mostrarContenidos(){
		JOptionPane.showMessageDialog(this, "Estamos trabajando en ello.", "Contenidos de la ayuda.", JOptionPane.WARNING_MESSAGE);
	}
	
	
	
	private JMenuItem getItAcercaDe() {
		if (itAcercaDe == null) {
			itAcercaDe = new JMenuItem("Acerca de");
			itAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAcercaDe();
				}
			});
			itAcercaDe.setMnemonic('d');
		}
		return itAcercaDe;
	}
	
	private void mostrarAcercaDe(){
		JOptionPane.showMessageDialog(this, "Juego de la liebre y de la tortuga. \n Autor: Luis Carlos. \n Versión: 0.5", "Acerca del juego de la liebre y la tortuga", JOptionPane.WARNING_MESSAGE);
	}
	
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	
	private void nuevo(){//tenemos que dejar siempre preparado para el siguiente jugador
		carrera.inicializarJuego();
		representarEstadoJuego();
	}
	private JMenu getMnConfiguracin() {
		if (mnConfiguracin == null) {
			mnConfiguracin = new JMenu("Configuraci\u00F3n");
			mnConfiguracin.setMnemonic('f');
			mnConfiguracin.add(getItCasillas());
			mnConfiguracin.add(getMntmrboles());
		}
		return mnConfiguracin;
	}
	private JMenuItem getItCasillas() {
		if (itCasillas == null) {
			itCasillas = new JMenuItem("Casillas");
			itCasillas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numCasillas = getNumCasillas();
				}
			});
			itCasillas.setMnemonic('s');
		}
		return itCasillas;
	}
	
	private int getNumCasillas(){
		String text = JOptionPane.showInputDialog(null, "Introduce el número de casillas (10-14)", "Casillas", JOptionPane.PLAIN_MESSAGE);
		int casillas = Integer.parseInt(text);
		return casillas;
	}
	
	private void CrearBotones(JPanel panel){
		panel.removeAll();
		for(int i=0; i< numCasillas; i++){
			JButton bt = new JButton();
			bt.setBackground(Color.BLACK);
			panel.add(bt);
			}
	}//falta cambiar la logica de las casillas en calle
	private JMenuItem getMntmrboles() {
		if (mntmrboles == null) {
			mntmrboles = new JMenuItem("\u00C1rboles");
		}
		return mntmrboles;
	}
}
