package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import player.MusicPlayer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5767732953572960676L;
	private JPanel pnPrincipal;
	private JPanel pnNorte;
	private JLabel lblLogo;
	private JSlider slVolumen;
	private JPanel pnVolumen;
	private JLabel lblVol;
	private JTextField txtVolumen;
	private JPanel pnCentral;
	private JPanel pnLibrary;
	private JPanel pnPlayList;
	private JLabel lblLibrary;
	private JPanel pnLibraryButtons;
	private JScrollPane scrPnLibrary;
	private JList<File> listSongsLibrary;
	private JButton btnAddPlayList;
	private JButton btnDelete;
	private JLabel lblPlaylist;
	private JScrollPane scrPnPlayList;
	private JList<File> listSongsPlaylist;
	private JPanel pnPlayListButtons;
	private JButton btnBefore;
	private JButton btnPlay;
	private JButton btnStop;
	private JButton btnNext;
	private JButton btnDel;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPlay;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmExit;
	private JMenuItem mntmNext;
	private JMenuItem mntmRandom;
	private JMenuItem mntmContent;
	private JMenuItem mntmAbout;
	private JSeparator separator;
	private JSeparator separator_1;

	// Para las listas
	private DefaultListModel<File> modeloListaLib;
	private DefaultListModel<File> modeloListaPlay;

	// Para reproducir musica
	private MusicPlayer mP = new MusicPlayer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties props = new Properties();
					props.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(props);
					UIManager.setLookAndFeel(
							"com.jtattoo.plaf.hifi.HiFiLookAndFeel");
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
				VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 605);
		setJMenuBar(getMenuBar_1());
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.BLACK);
		pnPrincipal.setBorder(null);
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnNorte(), BorderLayout.NORTH);
		pnPrincipal.add(getPnCentral(), BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
	}

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.BLACK);
			pnNorte.setLayout(new GridLayout(1, 0, 0, 0));
			pnNorte.add(getLblLogo());
			pnNorte.add(getSlVolumen());
			pnNorte.add(getPnVolumen());
		}
		return pnNorte;
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setBackground(Color.BLACK);
			lblLogo.setBorder(null);
			lblLogo.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lblLogo;
	}

	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					modificarVolumen();
				}
			});
			slVolumen.setFont(new Font("Dialog", Font.PLAIN, 14));
			slVolumen.setMajorTickSpacing(20);
			slVolumen.setPaintLabels(true);
			slVolumen.setPaintTicks(true);
			slVolumen.setBackground(Color.BLACK);
			slVolumen.setForeground(Color.WHITE);
		}
		return slVolumen;
	}

	private void modificarVolumen() {
		txtVolumen.setText(String.valueOf(slVolumen.getValue()));
		mP.setVolume(slVolumen.getValue(), slVolumen.getMaximum());
	}

	private JPanel getPnVolumen() {
		if (pnVolumen == null) {
			pnVolumen = new JPanel();
			pnVolumen.setBorder(null);
			pnVolumen.setBackground(Color.BLACK);
			pnVolumen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnVolumen.add(getVol());
			pnVolumen.add(getTxtVolumen());
		}
		return pnVolumen;
	}

	private JLabel getVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol:");
			lblVol.setFont(new Font("Dialog", Font.PLAIN, 24));
			lblVol.setForeground(Color.GREEN);
		}
		return lblVol;
	}

	private JTextField getTxtVolumen() {
		if (txtVolumen == null) {
			txtVolumen = new JTextField();
			txtVolumen.setHorizontalAlignment(SwingConstants.LEFT);
			txtVolumen.setBorder(null);
			txtVolumen.setEditable(false);
			txtVolumen.setFont(new Font("Tahoma", Font.PLAIN, 34));
			txtVolumen.setText("50  ");
			txtVolumen.setBackground(Color.BLACK);
			txtVolumen.setForeground(Color.WHITE);
		}
		return txtVolumen;
	}

	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setForeground(Color.GREEN);
			pnCentral.setBackground(Color.BLACK);
			pnCentral.setLayout(new GridLayout(1, 0, 0, 0));
			pnCentral.add(getPnLibrary());
			pnCentral.add(getPnPlayList());
		}
		return pnCentral;
	}

	private JPanel getPnLibrary() {
		if (pnLibrary == null) {
			pnLibrary = new JPanel();
			pnLibrary.setForeground(Color.GREEN);
			pnLibrary.setBackground(Color.BLACK);
			pnLibrary.setLayout(new BorderLayout(0, 0));
			pnLibrary.add(getLblLibrary(), BorderLayout.NORTH);
			pnLibrary.add(getPnLibraryButtons(), BorderLayout.SOUTH);
			pnLibrary.add(getScrPnLibrary(), BorderLayout.CENTER);
		}
		return pnLibrary;
	}

	private JPanel getPnPlayList() {
		if (pnPlayList == null) {
			pnPlayList = new JPanel();
			pnPlayList.setForeground(Color.GREEN);
			pnPlayList.setBackground(Color.BLACK);
			pnPlayList.setLayout(new BorderLayout(0, 0));
			pnPlayList.add(getLblPlaylist(), BorderLayout.NORTH);
			pnPlayList.add(getScrPnPlayList(), BorderLayout.CENTER);
			pnPlayList.add(getPnPlayListButtons(), BorderLayout.SOUTH);
		}
		return pnPlayList;
	}

	private JLabel getLblLibrary() {
		if (lblLibrary == null) {
			lblLibrary = new JLabel("Library:");
			lblLibrary.setFont(new Font("Dialog", Font.BOLD, 14));
			lblLibrary.setForeground(Color.GREEN);
		}
		return lblLibrary;
	}

	private JPanel getPnLibraryButtons() {
		if (pnLibraryButtons == null) {
			pnLibraryButtons = new JPanel();
			pnLibraryButtons.setBackground(Color.BLACK);
			pnLibraryButtons.setForeground(Color.GREEN);
			pnLibraryButtons.setLayout(new GridLayout(1, 0, 0, 0));
			pnLibraryButtons.add(getBtnAddPlayList());
			pnLibraryButtons.add(getBtnDelete());
		}
		return pnLibraryButtons;
	}

	private JScrollPane getScrPnLibrary() {
		if (scrPnLibrary == null) {
			scrPnLibrary = new JScrollPane();
			scrPnLibrary.setBorder(null);
			scrPnLibrary.setForeground(Color.GREEN);
			scrPnLibrary.setBackground(Color.BLACK);
			scrPnLibrary.setViewportView(getListSongsLibrary());
		}
		return scrPnLibrary;
	}

	private JList<File> getListSongsLibrary() {
		if (listSongsLibrary == null) {
			modeloListaLib = new DefaultListModel<File>();
			listSongsLibrary = new JList<File>(modeloListaLib);
			listSongsLibrary.setBorder(new LineBorder(new Color(0, 255, 0), 2));
			listSongsLibrary.setBackground(Color.BLACK);
			listSongsLibrary.setForeground(Color.WHITE);
		}
		return listSongsLibrary;
	}

	private JButton getBtnAddPlayList() {
		if (btnAddPlayList == null) {
			btnAddPlayList = new JButton("Add to PlayList");
			btnAddPlayList.setMnemonic('d');
			btnAddPlayList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (listSongsLibrary.getSelectedIndices().length > 0) {
						List<File> lista = listSongsLibrary
								.getSelectedValuesList();
						for (File f : lista)
							modeloListaPlay.addElement(f);
					} else {
						JOptionPane.showMessageDialog(null,
								"No hay canciones en la lista de la librer�a",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnAddPlayList.setBackground(Color.BLACK);
			btnAddPlayList.setForeground(Color.WHITE);
			btnAddPlayList.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return btnAddPlayList;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.setMnemonic('e');
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!listSongsLibrary.isSelectionEmpty())
						modeloListaLib
								.remove(listSongsLibrary.getSelectedIndex());
					else
						JOptionPane.showMessageDialog(null,
								"Seleccione una cancion para borrarla de la lista de la biblioteca",
								"Error", JOptionPane.ERROR_MESSAGE);
				}
			});
			btnDelete.setBackground(Color.BLACK);
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return btnDelete;
	}

	private JLabel getLblPlaylist() {
		if (lblPlaylist == null) {
			lblPlaylist = new JLabel("Playlist:");
			lblPlaylist.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPlaylist.setForeground(Color.GREEN);
		}
		return lblPlaylist;
	}

	private JScrollPane getScrPnPlayList() {
		if (scrPnPlayList == null) {
			scrPnPlayList = new JScrollPane();
			scrPnPlayList.setViewportView(getListSongsPlaylist());
		}
		return scrPnPlayList;
	}

	private JList<File> getListSongsPlaylist() {
		if (listSongsPlaylist == null) {
			modeloListaPlay = new DefaultListModel<File>();
			listSongsPlaylist = new JList<File>(modeloListaPlay);
			listSongsPlaylist.setBorder(new LineBorder(Color.GREEN, 2));
			listSongsPlaylist.setBackground(Color.BLACK);
			listSongsPlaylist.setForeground(Color.GREEN);
		}
		return listSongsPlaylist;
	}

	private JPanel getPnPlayListButtons() {
		if (pnPlayListButtons == null) {
			pnPlayListButtons = new JPanel();
			pnPlayListButtons.setLayout(new GridLayout(0, 5, 0, 0));
			pnPlayListButtons.add(getBtnBefore());
			pnPlayListButtons.add(getBtnPlay());
			pnPlayListButtons.add(getBtnStop());
			pnPlayListButtons.add(getBtnNext());
			pnPlayListButtons.add(getBtnDel());
		}
		return pnPlayListButtons;
	}

	private JButton getBtnBefore() {
		if (btnBefore == null) {
			btnBefore = new JButton("\u25C4\u25C4");
			btnBefore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!listSongsPlaylist.isSelectionEmpty())
						reproducirAnteriorCancion();
					else
						JOptionPane.showMessageDialog(null,
								"No hay canciones a�adidas a la lista de reproduccion",
								"Error", JOptionPane.ERROR_MESSAGE);
				}
			});
			btnBefore.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnBefore.setBackground(Color.BLACK);
			btnBefore.setForeground(Color.WHITE);
		}
		return btnBefore;
	}

	private void reproducirAnteriorCancion() {
		int index = listSongsPlaylist.getSelectedIndex();
		if (index > 0)
			listSongsPlaylist.setSelectedIndex(index - 1);
		else
			listSongsPlaylist.setSelectedIndex(
					listSongsLibrary.getSelectedIndices().length - 1);
		mP.play(listSongsPlaylist.getSelectedValue());
		modificarVolumen();
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("\u25BA");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File aux;
					if (listSongsPlaylist.isSelectionEmpty())
						listSongsPlaylist.setSelectedIndex(0);
					aux = listSongsPlaylist.getSelectedValue();
					if (aux != null) {
						modificarVolumen();
						mP.play(aux);
					} else
						JOptionPane.showMessageDialog(null,
								"No hay canciones a�adidas a la lista de reproduccion",
								"Error", JOptionPane.ERROR_MESSAGE);
					modificarVolumen();
				}
			});
			btnPlay.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnPlay.setBackground(Color.BLACK);
			btnPlay.setForeground(Color.WHITE);
		}
		return btnPlay;
	}

	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("\u25A0");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mP.stop();
				}
			});
			btnStop.setBackground(Color.BLACK);
			btnStop.setForeground(Color.WHITE);
			btnStop.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return btnStop;
	}

	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("\u25BA\u25BA");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!listSongsPlaylist.isSelectionEmpty())
						reproducirSiguienteCancion();
					else
						JOptionPane.showMessageDialog(null,
								"No hay canciones a�adidas a la lista de reproduccion",
								"Error", JOptionPane.ERROR_MESSAGE);
					modificarVolumen();
				}
			});
			btnNext.setFont(new Font("Dialog", Font.PLAIN, 14));
			btnNext.setBackground(Color.BLACK);
			btnNext.setForeground(Color.WHITE);
		}
		return btnNext;
	}

	private void reproducirSiguienteCancion() {
		int index = listSongsPlaylist.getSelectedIndex();
		if (index < listSongsLibrary.getSelectedIndices().length - 1)
			listSongsPlaylist.setSelectedIndex(index + 1);
		else
			listSongsPlaylist.setSelectedIndex(0);
		mP.play(listSongsPlaylist.getSelectedValue());
	}

	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Del");
			btnDel.setMnemonic('l');
			btnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!listSongsPlaylist.isSelectionEmpty()) {
						modeloListaPlay
								.remove(listSongsPlaylist.getSelectedIndex());
						mP.stop();
					} else
						JOptionPane.showMessageDialog(null,
								"Seleccione una cancion para borrarla de la lista de reproduccion",
								"Error", JOptionPane.ERROR_MESSAGE);

				}
			});
			btnDel.setBackground(Color.BLACK);
			btnDel.setForeground(Color.WHITE);
			btnDel.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return btnDel;
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
			mnFile.setMnemonic('f');
			mnFile.add(getMntmOpen());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
			mnPlay.setMnemonic('P');
			mnPlay.add(getMntmNext());
		}
		return mnPlay;
	}

	private JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Options");
			mnOptions.setMnemonic('o');
			mnOptions.add(getMntmRandom());
		}
		return mnOptions;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.setMnemonic('h');
			mnHelp.add(getMntmContent());
			mnHelp.add(getSeparator_1());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open...");
			mntmOpen.setMnemonic('o');
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// Para abrir ficheros
					JFileChooser selector = new JFileChooser();
					selector.setMultiSelectionEnabled(true);
					selector.setFileFilter(
							new FileNameExtensionFilter("Archivos mp3", "mp3"));
					selector.setCurrentDirectory(new File("D:/Music/"));
					int result = selector.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION)
						for (int i = 0; i < selector
								.getSelectedFiles().length; i++)
							modeloListaLib
									.addElement(selector.getSelectedFiles()[i]);

				}
			});
		}
		return mntmOpen;
	}

	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setMnemonic('e');
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}

	private JMenuItem getMntmNext() {
		if (mntmNext == null) {
			mntmNext = new JMenuItem("Next");
			mntmNext.setMnemonic('N');
			mntmNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
					InputEvent.CTRL_MASK));
			mntmNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reproducirSiguienteCancion();
				}
			});
		}
		return mntmNext;
	}

	private JMenuItem getMntmRandom() {
		if (mntmRandom == null) {
			mntmRandom = new JMenuItem("Random");
			mntmRandom.setMnemonic('R');
			mntmRandom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
					InputEvent.CTRL_MASK));
			mntmRandom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (listSongsPlaylist.getSelectedIndices().length > 0) {
						int index = (int) (Math.random()
								* listSongsPlaylist.getSelectedIndices().length
								- 1);
						listSongsPlaylist.setSelectedIndex(index);
						mP.play(listSongsPlaylist.getSelectedValue());
					} else {
						JOptionPane.showMessageDialog(null,
								"No hay canciones en la lista de reproduccion",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return mntmRandom;
	}

	private JMenuItem getMntmContent() {
		if (mntmContent == null) {
			mntmContent = new JMenuItem("Content");
			mntmContent.setMnemonic('c');
		}
		return mntmContent;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setMnemonic('a');
		}
		return mntmAbout;
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
}
