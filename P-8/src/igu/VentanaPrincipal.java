package igu;

import javax.swing.*;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Properties;

public class VentanaPrincipal extends JFrame{
	
	private JFileChooser selector;
	private DefaultListModel<File> modeloListLibrary;
	private DefaultListModel<File> modeloListPlay;
	
	private JPanel panel;
	private JLabel lblLogo;
	private JSlider slVolumen;
	private JPanel panelVolumen;
	private JLabel lblVol;
	private JLabel lblVolNum;
	private JPanel panelCentro;
	private JPanel panelLibreria;
	private JPanel panelPlayList;
	private JLabel lblLibreria;
	private JLabel lblPlaylist;
	private JPanel panelBotonesLibreria;
	private JPanel panelBotonesReproduccion;
	private JButton btnAñadirLibreria;
	private JButton btnBorrarLibreria;
	private JButton btnCancionAnt;
	private JButton btnReproducir;
	private JButton btnParar;
	private JButton btnCancionSig;
	private JButton btnBorrarPlayList;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList<File> listLibreria;
	private JList<File> listPlayList;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnPlay;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmExit;
	private JSeparator separator;
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					Properties p = new Properties();
					p.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(p);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e){
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	
	public VentanaPrincipal() {
		setTitle("Eii Music Player");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanelCentro(), BorderLayout.CENTER);
		setJMenuBar(getMenuBar_1());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setLayout(new GridLayout(0, 3, 0, 0));
			panel.add(getLblLogo());
			panel.add(getSlVolumen());
			panel.add(getPanelVolumen());
		}
		return panel;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return lblLogo;
	}
	private JSlider getSlVolumen() {
		if (slVolumen == null) {
			slVolumen = new JSlider();
			slVolumen.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					lblVolNum.setText(String.valueOf(slVolumen.getValue()));
					
				}
			});
			slVolumen.setFont(new Font("Tahoma", Font.BOLD, 11));
			slVolumen.setForeground(Color.WHITE);
			slVolumen.setPaintLabels(true);
			slVolumen.setPaintTicks(true);
			slVolumen.setMinorTickSpacing(10);
			slVolumen.setMajorTickSpacing(20);
			slVolumen.setBackground(Color.BLACK);
		}
		return slVolumen;
	}
	private JPanel getPanelVolumen() {
		if (panelVolumen == null) {
			panelVolumen = new JPanel();
			panelVolumen.setBackground(Color.BLACK);
			panelVolumen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelVolumen.add(getLblVol());
			panelVolumen.add(getLblVolNum());
		}
		return panelVolumen;
	}
	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("VOL:");
			lblVol.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblVol.setForeground(Color.GREEN);
		}
		return lblVol;
	}
	private JLabel getLblVolNum() {
		if (lblVolNum == null) {
			lblVolNum = new JLabel("");
			lblVolNum.setForeground(Color.WHITE);
			lblVolNum.setFont(new Font("Tahoma", Font.PLAIN, 30));
			//lblVolNum.setText(String.valueOf(slVolumen.getValue()));
			
		}
		return lblVolNum;
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
			pnLibreria.add(getLbLibreria(), BorderLayout.NORTH);
			pnLibreria.add(getPnBotLib(), BorderLayout.SOUTH);
			pnLibreria.add(getSpLibreria(), BorderLayout.CENTER);
		}
		return pnLibreria;
	}
	private JPanel getPnPlayList() {
		if (pnPlayList == null) {
			pnPlayList = new JPanel();
			pnPlayList.setBackground(Color.BLACK);
			pnPlayList.setLayout(new BorderLayout(0, 0));
			pnPlayList.add(getLbPlayList(), BorderLayout.NORTH);
			pnPlayList.add(getPnBotPList(), BorderLayout.SOUTH);
			pnPlayList.add(getSpPlayList(), BorderLayout.CENTER);
		}
		return pnPlayList;
	}
	private JLabel getLbLibreria() {
		if (lbLibreria == null) {
			lbLibreria = new JLabel("\u266A Library:");
			lbLibreria.setFont(new Font("Dialog", Font.BOLD, 16));
			lbLibreria.setBackground(Color.BLACK);
			lbLibreria.setForeground(Color.GREEN);
		}
		return lbLibreria;
	}
	private JPanel getPnBotLib() {
		if (pnBotLib == null) {
			pnBotLib = new JPanel();
			pnBotLib.setBackground(Color.BLACK);
			pnBotLib.setLayout(new GridLayout(0, 2, 0, 4));
			pnBotLib.add(getBtAdd());
			pnBotLib.add(getBtDelete());
		}
		return pnBotLib;
	}
	private JButton getBtAdd() {
		if (btAdd == null) {
			btAdd = new JButton("Add to PlayList");
			btAdd.setFont(new Font("Dialog", Font.BOLD, 14));
			btAdd.setMargin(new Insets(0, 0, 0, 0));
			btAdd.setBackground(Color.WHITE);
			btAdd.setForeground(Color.BLACK);
		}
		return btAdd;
	}
	private JButton getBtDelete() {
		if (btDelete == null) {
			btDelete = new JButton("Delete");
			btDelete.setFont(new Font("Dialog", Font.BOLD, 14));
			btDelete.setMargin(new Insets(0, 0, 0, 0));
		}
		return btDelete;
	}
	private JScrollPane getSpLibreria() {
		if (spLibreria == null) {
			spLibreria = new JScrollPane();
			spLibreria.setBackground(Color.BLACK);
			spLibreria.setBorder(new LineBorder(new Color(0, 255, 0), 5));
			spLibreria.setViewportView(getListaLibreria());
		}
		return spLibreria;
	}
	private JList<File> getListaLibreria() {
		if (listaLibreria == null) {
			modeloListaLibreria= new DefaultListModel<File>();
			listaLibreria = new JList<File>(modeloListaLibreria);
			listaLibreria.setFont(new Font("Tahoma", Font.PLAIN, 15));
			listaLibreria.setForeground(Color.WHITE);
			listaLibreria.setBackground(Color.BLACK);
		}
		return listaLibreria;
	}
	private JLabel getLbPlayList() {
		if (lbPlayList == null) {
			lbPlayList = new JLabel("\u266B PlayList:");
			lbPlayList.setFont(new Font("Dialog", Font.BOLD, 16));
			lbPlayList.setForeground(Color.GREEN);
		}
		return lbPlayList;
	}
	private JPanel getPnBotPList() {
		if (pnBotPList == null) {
			pnBotPList = new JPanel();
			pnBotPList.setLayout(new GridLayout(0, 5, 0, 2));
			pnBotPList.add(getBtAtrasPl());
			pnBotPList.add(getBtPlay());
			pnBotPList.add(getBtPause());
			pnBotPList.add(getBtSiguiente());
			
			pnBotPList.add(getBtDeletePl());
		}
		return pnBotPList;
	}
	private JButton getBtAtrasPl() {
		if (btnCancionAnt == null) {
			btnCancionAnt = new JButton("\u25c4");
			btnCancionAnt.setFont(new Font("Dialog", Font.BOLD, 14));
			btnCancionAnt.setMargin(new Insets(0, 0, 0, 0));
		}
		return btnCancionAnt;
	}
	private JButton getBtPlay() {
		if (btnReproducir == null) {
			btnReproducir = new JButton("\u25B0");
			btnReproducir.setFont(new Font("Dialog", Font.BOLD, 14));
			btnReproducir.setMargin(new Insets(0, 0, 0, 0));
		}
		return btnReproducir;
	}
	private JButton getBtPause() {
		if (btnParar == null) {
			btnParar = new JButton("\u25A0");
			btnParar.setFont(new Font("Dialog", Font.BOLD, 14));
			btnParar.setMargin(new Insets(0, 0, 0, 0));
		}
		return btnParar;
	}
	private JButton getBtSiguiente() {
		if (btnCancionSig == null) {
			btnCancionSig = new JButton("\u25BA\u25BA");
			btnCancionSig.setFont(new Font("Dialog", Font.BOLD, 14));
			btnCancionSig.setMargin(new Insets(0, 0, 0, 0));
		}
		return btnCancionSig;
	}
	
	private JButton getBtDeletePl() {
		if (btnBorrarPlayList == null) {
			btnBorrarPlayList = new JButton("Delete");
			btnBorrarPlayList.setFont(new Font("Dialog", Font.BOLD, 14));
			btnBorrarPlayList.setMargin(new Insets(0, 0, 0, 0));
		}
		return btnBorrarPlayList;
	}
	private JScrollPane getSpPlayList() {
		if (spPlayList == null) {
			spPlayList = new JScrollPane();
			spPlayList.setViewportView(getListaPlayList());
		}
		return spPlayList;
	}
	private JList<File> getListaPlayList() {
		if (listPlayList == null) {
			modeloListaPlayList= new DefaultListModel<File>();
			listPlayList = new JList<File>(modeloListaPlayList);
			listPlayList.setFont(new Font("Tahoma", Font.PLAIN, 15));
			listPlayList.setBorder(new LineBorder(Color.GREEN, 4));
			listPlayList.setBackground(Color.BLACK);
		}
		return listPlayList;
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
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnPlay() {
		if (mnPlay == null) {
			mnPlay = new JMenu("Play");
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
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
		}
		return mntmOpen;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
		}
		return mntmExit;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
}
