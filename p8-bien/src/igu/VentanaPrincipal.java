package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JList;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.swing.ListModel;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import player.MusicPlayer;
import player.MyFile;

import javax.swing.JToggleButton;
import javax.swing.JCheckBoxMenuItem;

import javax.help.*;
import java.net.*;
import java.io.*;

import java.awt.FlowLayout;

public class VentanaPrincipal<modeloListaPlayList> extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFileChooser selector;
	private Font fuenteDigital;
	private DefaultListModel<MyFile> modeloListaLibreria;
	private DefaultListModel<MyFile> modeloListaPlayList;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPlay;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JPanel pnNorte;
	private JLabel lblLogo;
	private JSlider slVol;
	private JPanel pnVol;
	private JLabel lblVol;
	private JTextField txVol;
	private JPanel pnCentro;
	private JPanel pnLibreria;
	private JPanel pnPlayList;
	private JLabel lblLibrary;
	private JPanel pnBotonesLib;
	private JButton btnAdd;
	private JButton btnDelete;
	private JScrollPane spLib;
	private JLabel lblPlayList;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnPlay;
	private JButton btnParar;
	private JButton btnSiguiente;
	private JButton btnBorrar;
	private JScrollPane spPlayList;
	private JList<MyFile> listLib;
	private JList<MyFile> listPlayList;
	private JMenuItem mntmOpen;
	private JMenuItem mntmExit;
	private JSeparator separator;
	private MusicPlayer mp;
	private JMenuItem mntmNext;
	private JMenuItem mntmPrevious;
	private JMenuItem mntmClearLibrary;
	private JMenuItem mntmClearPlaylist;
	private JPanel panel_1;
	private JLabel lblPuerba;
	private JMenuItem mntmRandom;
	private JMenuItem mntmContents;
	private JMenuItem mntmAbout;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties p = new Properties();
					p.put("logoString", "");
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
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
		cargarFuente();
		mp = new MusicPlayer();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 564);
		setJMenuBar(getMenuBar_1());
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		cargarAyuda();
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnPlay());
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmClearLibrary());
			mnFile.add(getMntmClearPlaylist());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
			mnPlay.add(getMntmRandom());
			mnPlay.add(getMntmNext());
			mnPlay.add(getMntmPrevious());
		}
		return mnPlay;
	}

	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
		}
		return mnOptions;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmContents());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.BLACK);
			pnNorte.setLayout(new GridLayout(1, 3, 0, 0));
			pnNorte.add(getLblLogo());
			// pnNorte.add(getPanel_1());
			pnNorte.add(getSlVol());
			pnNorte.add(getPnVol());
		}
		return pnNorte;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/logo.png")));
		}
		return lblLogo;
	}

	private JSlider getSlVol() {
		if (slVol == null) {
			slVol = new JSlider();
			slVol.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					txVol.setText(String.valueOf(slVol.getValue()));
					setVolume(slVol.getValue());

				}
			});
			slVol.setPaintTicks(true);
			slVol.setPaintLabels(true);
			slVol.setMinorTickSpacing(10);
			slVol.setMajorTickSpacing(20);
			slVol.setForeground(Color.GREEN);
			slVol.setBackground(Color.BLACK);
		}
		return slVol;
	}

	private JPanel getPnVol() {
		if (pnVol == null) {
			pnVol = new JPanel();
			pnVol.setBackground(Color.BLACK);
			pnVol.add(getLblVol());
			pnVol.add(getTxVol());
		}
		return pnVol;
	}

	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol:");
			lblVol.setForeground(Color.GREEN);
			lblVol.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblVol;
	}

	private JTextField getTxVol() {
		if (txVol == null) {
			txVol = new JTextField();
			txVol.setText("50");
			txVol.setHorizontalAlignment(SwingConstants.CENTER);
			txVol.setForeground(Color.GREEN);
			txVol.setFont(new Font("Tahoma", Font.PLAIN, 30));
			txVol.setEditable(false);
			txVol.setColumns(3);
			txVol.setBorder(null);
			txVol.setBackground(Color.BLACK);
			Font fuente = fuenteDigital.deriveFont(Font.PLAIN, 50);
			txVol.setFont(fuente);
		}
		return txVol;
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(Color.BLACK);
			pnCentro.setLayout(new GridLayout(0, 2, 0, 2));
			pnCentro.add(getPnLibreria());
			pnCentro.add(getPnPlayList());
		}
		return pnCentro;
	}

	private JPanel getPnLibreria() {
		if (pnLibreria == null) {
			pnLibreria = new JPanel();
			pnLibreria.setBackground(Color.BLACK);
			pnLibreria.setLayout(new BorderLayout(0, 0));
			pnLibreria.add(getLblLibrary(), BorderLayout.NORTH);
			pnLibreria.add(getPnBotonesLib(), BorderLayout.SOUTH);
			pnLibreria.add(getSpLib(), BorderLayout.CENTER);

		}
		return pnLibreria;
	}

	private JPanel getPnPlayList() {
		if (pnPlayList == null) {
			pnPlayList = new JPanel();
			pnPlayList.setBackground(Color.BLACK);
			pnPlayList.setLayout(new BorderLayout(0, 0));
			pnPlayList.add(getLblPlayList(), BorderLayout.NORTH);
			pnPlayList.add(getPanel(), BorderLayout.SOUTH);
			pnPlayList.add(getSpPlayList(), BorderLayout.WEST);
			pnPlayList.add(getListPlayList(), BorderLayout.CENTER);

		}
		return pnPlayList;
	}

	private JLabel getLblLibrary() {
		if (lblLibrary == null) {
			lblLibrary = new JLabel("\u266A Library:");
			lblLibrary.setForeground(Color.GREEN);
			lblLibrary.setFont(new Font("Dialog", Font.BOLD, 16));
			lblLibrary.setBackground(Color.BLACK);
		}
		return lblLibrary;
	}

	private JPanel getPnBotonesLib() {
		if (pnBotonesLib == null) {
			pnBotonesLib = new JPanel();
			pnBotonesLib.setBackground(Color.BLACK);
			pnBotonesLib.setLayout(new GridLayout(0, 2, 0, 4));
			pnBotonesLib.add(getBtnAdd());
			pnBotonesLib.add(getBtnDelete());
		}
		return pnBotonesLib;
	}

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add to PlayList");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pasarAlPlayList();
				}
			});
			btnAdd.setMargin(new Insets(0, 0, 0, 0));
			btnAdd.setForeground(Color.BLACK);
			btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
			btnAdd.setBackground(Color.LIGHT_GRAY);
		}
		return btnAdd;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					List<MyFile> cancionesBorrar = listLib
							.getSelectedValuesList();
					for (int i = 0; i < listLib.getSelectedValuesList().size(); i++) {
						modeloListaLibreria.removeElement(cancionesBorrar
								.get(i));
					}
				}
			});
			btnDelete.setMargin(new Insets(0, 0, 0, 0));
			btnDelete.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnDelete;
	}

	private JScrollPane getSpLib() {
		if (spLib == null) {
			spLib = new JScrollPane();
			spLib.setBorder(new LineBorder(new Color(0, 255, 0), 5));
			spLib.setBackground(Color.BLACK);
			spLib.setViewportView(getListLib());
		}
		return spLib;
	}

	private JLabel getLblPlayList() {
		if (lblPlayList == null) {
			lblPlayList = new JLabel("\u266B PlayList:");
			lblPlayList.setForeground(Color.GREEN);
			lblPlayList.setFont(new Font("Dialog", Font.BOLD, 16));
		}
		return lblPlayList;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 5, 0, 2));
			panel.add(getBtnAtras());
			panel.add(getBtnPlay());
			panel.add(getBtnParar());
			panel.add(getBtnSiguiente());
			panel.add(getBtnBorrar());
		}
		return panel;
	}

	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("\u25C4\u25C4");
			btnAtras.setToolTipText("Previous");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					retroceder();
					lblPuerba.setText(listPlayList.getSelectedValue()
							.toString());
				}
			});
			btnAtras.setMargin(new Insets(0, 0, 0, 0));
			btnAtras.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnAtras;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25BA");
			btnPlay.setToolTipText("Play");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					playMusic();
					lblPuerba.setText(listPlayList.getSelectedValue()
							.toString());
				}
			});
			btnPlay.setMargin(new Insets(0, 0, 0, 0));
			btnPlay.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnPlay;
	}

	private JButton getBtnParar() {
		if (btnParar == null) {
			btnParar = new JButton("\u25A0");
			btnParar.setToolTipText("Stop");
			btnParar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mp.stop();
					lblPuerba.setText("");
				}
			});
			btnParar.setMargin(new Insets(0, 0, 0, 0));
			btnParar.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnParar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("\u25BA\u25BA");
			btnSiguiente.setToolTipText("Next");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					foward();
					lblPuerba.setText(listPlayList.getSelectedValue()
							.toString());
				}
			});
			btnSiguiente.setMargin(new Insets(0, 0, 0, 0));
			btnSiguiente.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnSiguiente;
	}

	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("Delete");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					List<MyFile> cancionesBorrar = listPlayList
							.getSelectedValuesList();
					for (int i = 0; i < listPlayList.getSelectedValuesList()
							.size(); i++) {
						modeloListaPlayList.removeElement(cancionesBorrar
								.get(i));

					}
				}
			});
			btnBorrar.setMargin(new Insets(0, 0, 0, 0));
			btnBorrar.setFont(new Font("Dialog", Font.BOLD, 14));
		}
		return btnBorrar;
	}

	private JScrollPane getSpPlayList() {
		if (spPlayList == null) {
			spPlayList = new JScrollPane();
		}
		return spPlayList;
	}

	private JList<MyFile> getListLib() {
		if (listLib == null) {
			modeloListaLibreria = new DefaultListModel<MyFile>();
			listLib = new JList<MyFile>(modeloListaLibreria);
			listLib.setForeground(Color.WHITE);
			listLib.setFont(new Font("Tahoma", Font.PLAIN, 15));
			listLib.setBackground(Color.BLACK);
		}
		return listLib;
	}

	private JList<MyFile> getListPlayList() {
		if (listPlayList == null) {
			modeloListaPlayList = new DefaultListModel<MyFile>();
			listPlayList = new JList<MyFile>(modeloListaPlayList);
			listPlayList.setFont(new Font("Tahoma", Font.PLAIN, 15));
			listPlayList.setBorder(new LineBorder(new Color(0, 255, 0), 4));
			listPlayList.setBackground(Color.BLACK);
		}
		return listPlayList;
	}

	private JFileChooser getSelector() {
		if (selector == null) {
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true); // permite la seleccion
														// multiple de ficheros
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3",
					"mp3"));// filtro para los archivos mp3, no machacan al
							// resto
			String desktopPath = System.getProperty("user.home")
					+ "/Desktop/MUSICA";
			selector.setCurrentDirectory(new File(desktopPath));
		}
		return selector;
	}

	private void abrirFicheros() {
		int respuesta = getSelector().showOpenDialog(this);
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			for (int i = 0; i < selector.getSelectedFiles().length; i++)
				modeloListaLibreria.addElement(new MyFile(selector
						.getSelectedFiles()[i])); // recorro el array de
													// ficheros y lo meto en la
													// lista de libreria
		}
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					abrirFicheros();
				}
			});
		}
		return mntmOpen;
	}

	private void pasarAlPlayList() {
		for (int i = 0; i < listLib.getSelectedValuesList().size(); i++) {
			modeloListaPlayList.addElement(listLib.getSelectedValuesList().get(
					i));
		}
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(DISPOSE_ON_CLOSE);
				}
			});
		}
		return mntmExit;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private void playMusic() {
		if (listPlayList.getSelectedIndex() == -1) {
			listPlayList.setSelectedIndex(0);
		}
		mp.play(listPlayList.getSelectedValue().getF());
	}

	private void foward() {
		int indiceSeleccionado = listPlayList.getSelectedIndex();
		int numeroCanciones = modeloListaPlayList.getSize();
		if (indiceSeleccionado != numeroCanciones - 1)
			listPlayList.setSelectedIndex(listPlayList.getSelectedIndex() + 1);
		else
			listPlayList.setSelectedIndex(0);
		mp.play(listPlayList.getSelectedValue().getF());
	}

	private void retroceder() {
		int indiceSeleccionado = listPlayList.getSelectedIndex();
		// int numeroCanciones = modeloListaPlayList.getSize();
		if (indiceSeleccionado != 0)
			listPlayList.setSelectedIndex(indiceSeleccionado - 1);
		mp.play(listPlayList.getSelectedValue().getF());
	}

	private void setVolume(double vol) {
		double volMax = slVol.getMaximum();
		mp.setVolume(vol, volMax);
	}

	private JMenuItem getMntmNext() {
		if (mntmNext == null) {
			mntmNext = new JMenuItem("Next");
			mntmNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					foward();
					lblPuerba.setText(listPlayList.getSelectedValue()
							.toString());
				}
			});
		}
		return mntmNext;
	}

	private JMenuItem getMntmPrevious() {
		if (mntmPrevious == null) {
			mntmPrevious = new JMenuItem("Previous");
			mntmPrevious.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					retroceder();
					lblPuerba.setText("");
				}
			});
		}
		return mntmPrevious;
	}

	private JMenuItem getMntmClearLibrary() {
		if (mntmClearLibrary == null) {
			mntmClearLibrary = new JMenuItem("Clear library");
			mntmClearLibrary.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					modeloListaLibreria.clear();
				}
			});
		}
		return mntmClearLibrary;
	}

	private JMenuItem getMntmClearPlaylist() {
		if (mntmClearPlaylist == null) {
			mntmClearPlaylist = new JMenuItem("Clear playlist");
			mntmClearPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					modeloListaPlayList.clear();
				}
			});
		}
		return mntmClearPlaylist;
	}

	// private JPanel getPanel_1() {
	// if (panel_1 == null) {
	// panel_1 = new JPanel();
	// FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
	// panel_1.setBackground(Color.WHITE);
	// panel_1.add(getLblPuerba());
	// }
	// return panel_1;
	// }
	private JLabel getLblPuerba() {
		if (lblPuerba == null) {
			lblPuerba = new JLabel("");
			lblPuerba.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblPuerba.setForeground(Color.GREEN);
			lblPuerba.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPuerba;
	}

	private JMenuItem getMntmRandom() {
		if (mntmRandom == null) {
			mntmRandom = new JMenuItem("Random");
		}
		return mntmRandom;
	}

	private void cargarFuente() {
		try {
			InputStream mystream = getClass().getResourceAsStream(
					"/ttf/DS-DIGIB.ttf");
			fuenteDigital = Font.createFont(Font.TRUETYPE_FONT, mystream);
		} catch (Exception ex) {
			System.err.println("No se puede cargar la fuente.");
		}
	}

	private void cargarAyuda() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();

		hb.enableHelpKey(getRootPane(), "introduccion", hs); // módulo
																		// final
																		// /!\
		hb.enableHelpOnButton(mntmContents, "introduccion", hs);
		hb.enableHelp(btnPlay, "reproducir", hs);
	}

	private JMenuItem getMntmContents() {
		if (mntmContents == null) {
			mntmContents = new JMenuItem("Contents");
		}
		return mntmContents;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
}
