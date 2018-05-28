package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Catalogue;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnPrincipal;
	private JPanel panelOeste;
	private JPanel panelNorte;
	private JPanel pnBotones;
	private JPanel pnRdBotones;
	private JPanel pnBuscador;
	private JRadioButton rdbtnMostrarTodo;
	private JRadioButton rdbtnEnVenta;
	private JRadioButton rdbtnLegendarias;
	private JRadioButton rdbtnEpicas;
	private JRadioButton rdbtnRaras;
	private JRadioButton rdbtnPocoComunes;
	private ButtonGroup botones = new ButtonGroup();
	private JButton button;
	private JButton button_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catalogue catalogue = new Catalogue();
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Tienda de Fortnite");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MainWindow.class.getResource("/img/Fortnite-logo.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnPrincipal(), "name_2230474924246");
	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getPanel_1(), BorderLayout.WEST);
			pnPrincipal.add(getPanel_1_1(), BorderLayout.NORTH);
		}
		return pnPrincipal;
	}

	private JPanel getPanel_1() {
		if (panelOeste == null) {
			panelOeste = new JPanel();
			panelOeste.setLayout(new GridLayout(0, 1, 0, 0));
			panelOeste.add(getPanel_2());
			panelOeste.add(getPanel_1_2());
			panelOeste.add(getPanel_2_1());
		}
		return panelOeste;
	}

	private JPanel getPanel_1_1() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
		}
		return panelNorte;
	}

	private JPanel getPanel_2() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setLayout(new GridLayout(0, 1, 0, 0));
			pnBotones.add(getButton());
			pnBotones.add(getButton_1());
			pnBotones.add(getBtnNewButton());
		}
		return pnBotones;
	}

	private JPanel getPanel_1_2() {
		if (pnRdBotones == null) {
			pnRdBotones = new JPanel();
			pnRdBotones.setLayout(new GridLayout(0, 1, 0, 0));
			pnRdBotones.add(getRdbtnMostrarTodo());
			pnRdBotones.add(getRdbtnEnVenta());
			pnRdBotones.add(getRdbtnLegendarias());
			pnRdBotones.add(getRdbtnEpicas());
			pnRdBotones.add(getRdbtnRaras());
			pnRdBotones.add(getRdbtnPocoComunes());
			getBotones();
		}
		return pnRdBotones;
	}

	private JPanel getPanel_2_1() {
		if (pnBuscador == null) {
			pnBuscador = new JPanel();
		}
		return pnBuscador;
	}

	private void getBotones() {
		botones.add(rdbtnMostrarTodo);
		botones.add(rdbtnEnVenta);
		botones.add(rdbtnLegendarias);
		botones.add(rdbtnEpicas);
		botones.add(rdbtnRaras);
		botones.add(rdbtnPocoComunes);
	}

	private JRadioButton getRdbtnMostrarTodo() {
		if (rdbtnMostrarTodo == null) {
			rdbtnMostrarTodo = new JRadioButton("Mostrar Todo");

		}
		return rdbtnMostrarTodo;
	}

	private JRadioButton getRdbtnEnVenta() {
		if (rdbtnEnVenta == null) {
			rdbtnEnVenta = new JRadioButton("En venta");
		}
		return rdbtnEnVenta;
	}

	private JRadioButton getRdbtnLegendarias() {
		if (rdbtnLegendarias == null) {
			rdbtnLegendarias = new JRadioButton("Legendarias");
		}
		return rdbtnLegendarias;
	}

	private JRadioButton getRdbtnEpicas() {
		if (rdbtnEpicas == null) {
			rdbtnEpicas = new JRadioButton("Epicas");
		}
		return rdbtnEpicas;
	}

	private JRadioButton getRdbtnRaras() {
		if (rdbtnRaras == null) {
			rdbtnRaras = new JRadioButton("Raras");
		}
		return rdbtnRaras;
	}

	private JRadioButton getRdbtnPocoComunes() {
		if (rdbtnPocoComunes == null) {
			rdbtnPocoComunes = new JRadioButton("Poco comunes");
		}
		return rdbtnPocoComunes;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("1");
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("2");
		}
		return button_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
}
