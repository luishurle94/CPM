package igu;

/**
 * TODO:
 *   ï¿½ï¿½ï¿½Na siquiera!!!
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Image;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;

import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import logica.Cinema;
import logica.Moment;
import logica.Movie;
import logica.Purchase;
import logica.Room;
import logica.Seat;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private Locale locale;
	private ResourceBundle txt;
	private VentanaPrincipal main;
	private JPanel cardPanel;
	private boolean screen4mode;
	private static final boolean MODE_REVIEW = false;
	private static final boolean MODE_DELETE = true;
	private CardSwipe siguiente = new CardSwipe(CardSwipe.SIGUIENTE);
	private CardSwipe anterior = new CardSwipe(CardSwipe.ANTERIOR);
	private CardSwipe primero = new CardSwipe(CardSwipe.PRIMERO);
	private CardSwipeByName capa1 = new CardSwipeByName("capa1");
	private Cinema cimera;
	private Purchase pedido;
	private String fecha;
	private DefaultListModel<Movie> peliculas;
	private DefaultComboBoxModel<String> fechas;
	private boolean override;
	private URL helpSetURI;
	private HelpSet help;
	private HelpBroker liara;
	// Capa 0: Pantalla de bienvenida
	private JPanel screen0;
	private JPanel s0footer;
	private Component s0fleadingseparator;
	private JButton s0fbtnespañol;
	private Component s0fmiddleseparator;
	private JButton s0fbtnenglish;
	private Component s0ftrailingseparator;
	private Component s0leadingseparator;
	private JLabel s0logo;
	private Component s0middleseparator;
	private JLabel s0name;
	private Component s0trailingseparator;
	private Component s0footerseparator;
	// Capa 1: Selecciï¿½n de pelï¿½cula
	private JPanel screen1;
	private JPanel s1head;
	private JLabel s1htitle;
	private JPanel s1hbuttoncontainer;
	private JButton s1hbsalir;
	private JButton s1hbayuda;
	private JPanel s1body;
	private JScrollPane s1bmoviescroll;
	private JList<Movie> s1bmovielist;
	private JPanel s1bdetailcontainer;
	private JPanel s1bdheadercontainer;
	private JLabel s1bdhmovieposter;
	private JTextArea s1bdhmovieinfo;
	private JPanel s1bdbodycontainer;
	private JTextArea s1bdbmoviesinopsis;
	private JPanel s1bdbfootercontainer;
	private JButton s1bdbfcontinuar;
	// Capa 2: Selecciï¿½n de fecha y hora
	private JPanel screen2;
	private JPanel s2head;
	private JPanel s2hbackcontainer;
	private JButton s2hback;
	private JLabel s2htitle;
	private JPanel s2hbuttoncontainer;
	private JButton s2hbsalir;
	private JButton s2hbayuda;
	private JPanel s2body;
	private JComboBox<String> s2bdatepicker;
	private JPanel s2bhourcontainer;
	private JPanel s2bhbuttoncontainer;
	private JPanel s2bdatecontainer;
	private Component s2bdupperseparator;
	// Capa 3: Selecciï¿½n de asientos
	private JPanel screen3;
	private JPanel s3head;
	private JPanel s3hbackcontainer;
	private JButton s3hback;
	private JLabel s3htitle;
	private JPanel s3hbuttoncontainer;
	private JButton s3hbayuda;
	private JButton s3hbsalir;
	private Component s2bhseparator;
	private JPanel s3body;
	private JPanel s3bmapcontainer;
	private JPanel s3bfooter;
	private JLabel s3bfverbose;
	private JLabel s3bfentradas;
	private Component s3bfseparator;
	private JButton s3bfcontinuar;
	private JPanel s3bfbuttoncontainer;
	private Component s1hseparator;
	private Component s3bmleadingseparator;
	private JPanel s3bmgrid;
	private Component s3bmtrailingseparator;
	// Capa 4: Revisiï¿½n de la compra
	private JPanel screen4;
	private JPanel s4head;
	private Component s4hseparator;
	private JLabel s4htitle;
	private JPanel s4hbuttoncontainer;
	private JButton s4hbayuda;
	private JButton s4hbsalir;
	private JPanel s4footer;
	private JButton s4fcomprarmas;
	private Component s4fleadingseparator;
	private JButton s4feliminar;
	private Component s4ftrailingseparator;
	private JButton s4fcontinuar;
	private JScrollPane s4bodyscroll;
	private JPanel s4body;
	private JTextArea tempmovie1;
	private JTextArea tempmovie2;
	private Component s4bleadingseparator;
	private Component s4btrailingseparator;
	// Capa 5: Informaciï¿½n de pago
	private JPanel screen5;
	private JPanel s5head;
	private JPanel s5hbackcontainer;
	private JButton s5hback;
	private JLabel s5htitle;
	private JPanel s5hbuttoncontainer;
	private JButton s5bayuda;
	private JButton s5bsalir;
	private JPanel s5body;
	private JPanel s5bcontainer;
	private JPanel s5bfooter;
	private Component s5bcleadingseparator;
	private JPanel s5bcdescuentos;
	private Component s5bctrailingseparator;
	private Component s5bcdleadingseparator;
	private JCheckBox ckJubilados;
	private Component s5bcdmiddleseparator;
	private JCheckBox ckCumpleaños;
	private Component s5bcdtrailingseparator;
	private JLabel lbPrecioFinal;
	private JLabel lbNumeroPrecio;
	private Component s5bfseparator;
	private JButton s5bfpagar;
	// Capa 6: Introfucir DNI
	private JPanel screen6;
	private JPanel s6head;
	private JPanel s6hbackcontainer;
	private JLabel s6htitle;
	private JPanel s6hbuttoncontainer;
	private JButton s6hbatras;
	private JButton s6hbayuda;
	private JButton s6hbsalir;
	private JPanel s6body;
	private Component s6bleadingseparator;
	private JPanel s6bcontainer;
	private Component s6btrailingseparator;
	private Component s6bcleadingseparator;
	private JLabel lbIntroDNI;
	private JTextField tfDNI;
	private Component s6bctrailingseparator;
	private JPanel s6footer;
	private JButton s6fadelante;
	// Capa 7: Despedida
	private JPanel screen7;
	private JPanel s7head;
	private JLabel s7htitle;
	private JPanel s7body;
	private Component s7bleadingseparator;
	private JPanel s7boutercontainer;
	private Component s7btrailingseparator;
	private Component s7bocleadingseparator;
	private JPanel s7binnercontainer;
	private Component s7boctrailingseparator;
	private JPanel s7biverbosecontainer;
	private JLabel s7bivlogo;
	private JLabel s7bivtexto;
	private JButton s7biterminar;

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
					;
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		// Evitar que se vean las InvalidHelpSetContextException.
		// No muy ortodoxo, pero efectivo.
		//
		// Comentar esta lï¿½nea para poder depurar excepciones.
		System.setErr(null);
		override = true;
		main = this;
		screen4mode = MODE_REVIEW;
		peliculas = new DefaultListModel<Movie>();
		fechas = new DefaultComboBoxModel<String>();
		peliculas.clear();
		fechas.removeAllElements();
		try {
			cimera = new Cinema();
		} catch (IOException ee) {
			new DialogoAviso(main, "Error grave",
					new ImageIcon(VentanaPrincipal.class
							.getResource("/img/Azur_triste.png")),
					"Algo ha pasado, y no se ha podido iniciar la aplicaciï¿½n correctamente. Comprueba que todos los archivos estï¿½n en su lugar e intï¿½ntalo de nuevo. Los archivos de cartelera y tarifas deben estar en 'scr/files' y en 'bin/files'.",
					"Salir").showDialog();
			System.exit(ABORT);
		}
		for (Movie m : cimera.getPeliculas())
			peliculas.addElement(m);

		setTitle("TPV");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaPrincipal.class.getResource("/img/Azur.png")));
		locale = Locale.getDefault(Locale.Category.FORMAT);
		txt = ResourceBundle.getBundle("files/locale", locale);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		// Centrar la ventana en la pantalla
		setLocationRelativeTo(null);
		cardPanel = new JPanel();
		cardPanel.setBackground(new Color(40, 40, 40));
		cardPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		cardPanel.add(getScreen0(), "name_159759017256467");
		cardPanel.add(getScreen1(), "name_14275299366968");
		cardPanel.add(getScreen2(), "name_17759650846553");
		cardPanel.add(getScreen3(), "name_21799621370465");
		cardPanel.add(getScreen4(), "name_23092145130758");
		((CardLayout) cardPanel.getLayout()).addLayoutComponent(getScreen1(),
				"capa1");
		cardPanel.add(getScreen5(), "name_320809574972681");
		cardPanel.add(getScreen6(), "name_18104668808046");
		cardPanel.add(getScreen7(), "name_19551580290860");
		// Crear la cuadrï¿½cula de butacas para la capa 3
		for (int i = 0; i < 30; i++) {
			JCheckBox seat = new JCheckBox();
			seat.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/seat_empty.png")));
			seat.setSelectedIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/seat_selected.png")));
			seat.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/seat_occupied.png")));
			seat.setText(String.valueOf(i + 1));
			// seat.setBorderPainted(false);
			// seat.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			seat.setBackground(new Color(40, 40, 40));
			seat.setForeground(new Color(255, 255, 255));
			// seat.setPreferredSize(new Dimension(50, 50));
			seat.addItemListener(new SeatStateChanged(i));
			s3bmgrid.add(seat);
		}
		// Ocupar algunas butacas por defecto
		// for (int i = 0; i < 5; i++) {
		// Component[] seats = s3bmgrid.getComponents();
		// ((JCheckBox)seats[new
		// Random().nextInt(seats.length)]).setEnabled(false);
		// }
	}

	class SeatStateChanged implements ItemListener {
		int pos;

		public SeatStateChanged(int pos) {
			this.pos = pos;
		}

		@Override
		public void itemStateChanged(ItemEvent ie) {
			if (override)
				return;
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				s3bfentradas.setText(String
						.valueOf(Integer.valueOf(s3bfentradas.getText()) + 1));
				System.out.println(
						" ** Aï¿½adiendo la butaca " + pos + " al pedido");
				pedido.añadirButaca(
						pedido.getPelicula().getSala().getButacas().get(pos));
				s3bfcontinuar.setEnabled(true);
			} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
				s3bfentradas.setText(String
						.valueOf(Integer.valueOf(s3bfentradas.getText()) - 1));
				System.out.println(
						" ** Eliminando la butaca " + pos + " del pedido");
				pedido.eliminarButaca(
						pedido.getPelicula().getSala().getButacas().get(pos));
				if (pedido.getButacas().size() == 0)
					s3bfcontinuar.setEnabled(false);
			}
		}
	}

	private JPanel getScreen1() {
		if (screen1 == null) {
			screen1 = new JPanel();
			screen1.setBackground(new Color(40, 40, 40));
			screen1.setLayout(new BorderLayout(0, 10));
			screen1.add(getS1head(), BorderLayout.NORTH);
			screen1.add(getS1body(), BorderLayout.CENTER);
		}
		return screen1;
	}

	private JPanel getS1head() {
		if (s1head == null) {
			s1head = new JPanel();
			s1head.setBackground(new Color(40, 40, 40));
			s1head.setLayout(new BoxLayout(s1head, BoxLayout.LINE_AXIS));
			s1head.add(getS1hseparator());
			s1head.add(getS1htitle());
			s1head.add(getS1hbuttoncontainer());
		}
		return s1head;
	}

	private JLabel getS1htitle() {
		if (s1htitle == null) {
			s1htitle = new JLabel("Seleccione la pel\u00EDcula:");
			s1htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s1htitle.setForeground(new Color(255, 255, 255));
			s1htitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return s1htitle;
	}

	private JPanel getS1hbuttoncontainer() {
		if (s1hbuttoncontainer == null) {
			s1hbuttoncontainer = new JPanel();
			s1hbuttoncontainer.setBackground(new Color(40, 40, 40));
			s1hbuttoncontainer
					.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 5));
			s1hbuttoncontainer.add(getS1hbayuda());
			s1hbuttoncontainer.add(getS1hbsalir());
		}
		return s1hbuttoncontainer;
	}

	private JButton getS1hbsalir() {
		if (s1hbsalir == null) {
			s1hbsalir = new JButton("");
			s1hbsalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_salir.png")));
			// Este botï¿½n quiere ir a la primera capa
			s1hbsalir.addActionListener(primero);
			s1hbsalir.setBorderPainted(false);
			s1hbsalir.setForeground(new Color(255, 255, 255));
			s1hbsalir.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s1hbsalir.setBackground(new Color(178, 34, 34));
		}
		return s1hbsalir;
	}

	private JButton getS1hbayuda() {
		if (s1hbayuda == null) {
			s1hbayuda = new JButton("");
			s1hbayuda.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_ayuda.png")));
			s1hbayuda.setBorderPainted(false);
			s1hbayuda.setForeground(Color.WHITE);
			s1hbayuda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s1hbayuda.setBackground(new Color(65, 105, 225));
		}
		return s1hbayuda;
	}

	private JPanel getS1body() {
		if (s1body == null) {
			s1body = new JPanel();
			s1body.setBackground(new Color(40, 40, 40));
			s1body.setBorder(null);
			s1body.setLayout(new BorderLayout(10, 0));
			s1body.add(getScrollPane_1(), BorderLayout.WEST);
			s1body.add(getS1bdetailcontainer(), BorderLayout.CENTER);
		}
		return s1body;
	}

	private JScrollPane getScrollPane_1() {
		if (s1bmoviescroll == null) {
			s1bmoviescroll = new JScrollPane(getS1bmovielist());
			s1bmoviescroll
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s1bmoviescroll.setHorizontalScrollBarPolicy(
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return s1bmoviescroll;
	}

	private JList<Movie> getS1bmovielist() {
		if (s1bmovielist == null) {
			s1bmovielist = new JList<Movie>();
			s1bmovielist.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					Movie sel = s1bmovielist.getSelectedValue();
					if (sel == null)
						return;
					s1bdhmovieinfo.setText(
							sel.getDetailsForScreen1(locale.toLanguageTag()));
					s1bdbmoviesinopsis
							.setText(sel.getSinopsis(locale.toLanguageTag()));
					System.out.println("****** Cambiando icono a: " + "/img/"
							+ sel.getCodigo() + ".png ******");
					adaptarImagenLabel(s1bdhmovieposter,
							"/img/" + sel.getCodigo() + ".png");
					s1bdbfcontinuar.setEnabled(true);
					for (Purchase p : cimera.getCliente().getPedidos())
						if (p.getPelicula() == sel)
							s1bdbfcontinuar.setEnabled(false);
						else
							s1bdbfcontinuar.setEnabled(true);
				}
			});
			s1bmovielist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			s1bmovielist.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s1bmovielist.setForeground(new Color(255, 255, 255));
			s1bmovielist.setModel(peliculas);
			s1bmovielist.setBorder(new LineBorder(new Color(40, 40, 40), 5));
			s1bmovielist.setBackground(new Color(40, 40, 40));
		}
		return s1bmovielist;
	}

	private JPanel getS1bdetailcontainer() {
		if (s1bdetailcontainer == null) {
			s1bdetailcontainer = new JPanel();
			s1bdetailcontainer
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s1bdetailcontainer.setBackground(new Color(40, 40, 40));
			s1bdetailcontainer.setLayout(new GridLayout(2, 0, 0, 10));
			s1bdetailcontainer.add(getPanel_1());
			s1bdetailcontainer.add(getS1bdbodycontainer());
		}
		return s1bdetailcontainer;
	}

	private JPanel getPanel_1() {
		if (s1bdheadercontainer == null) {
			s1bdheadercontainer = new JPanel();
			s1bdheadercontainer.setBackground(new Color(40, 40, 40));
			s1bdheadercontainer
					.setBorder(new LineBorder(new Color(40, 40, 40), 10));
			s1bdheadercontainer.setLayout(new GridLayout(0, 2, 10, 0));
			s1bdheadercontainer.add(getS1bdhmovieposter());
			s1bdheadercontainer.add(getS1bdhmovieinfo());
		}
		return s1bdheadercontainer;
	}

	private JLabel getS1bdhmovieposter() {
		if (s1bdhmovieposter == null) {
			s1bdhmovieposter = new JLabel("");
			s1bdhmovieposter.setHorizontalAlignment(SwingConstants.CENTER);
			s1bdhmovieposter.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					if (s1bmovielist.getSelectedValue() == null)
						return;
					adaptarImagenLabel(s1bdhmovieposter, "/img/"
							+ s1bmovielist.getSelectedValue().getCodigo()
							+ ".png");
				}
			});
		}
		return s1bdhmovieposter;
	}

	private JTextArea getS1bdhmovieinfo() {
		if (s1bdhmovieinfo == null) {
			s1bdhmovieinfo = new JTextArea();
			s1bdhmovieinfo.setLineWrap(true);
			s1bdhmovieinfo.setWrapStyleWord(true);
			s1bdhmovieinfo.setEditable(false);
			s1bdhmovieinfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s1bdhmovieinfo.setForeground(new Color(255, 255, 255));
			s1bdhmovieinfo.setBackground(new Color(40, 40, 40));
		}
		return s1bdhmovieinfo;
	}

	private JPanel getS1bdbodycontainer() {
		if (s1bdbodycontainer == null) {
			s1bdbodycontainer = new JPanel();
			s1bdbodycontainer.setBackground(new Color(40, 40, 40));
			s1bdbodycontainer.setLayout(new BorderLayout(0, 10));
			s1bdbodycontainer.add(getS1bdbmoviesinopsis(), BorderLayout.CENTER);
			s1bdbodycontainer.add(getPanel_2(), BorderLayout.SOUTH);
		}
		return s1bdbodycontainer;
	}

	private JTextArea getS1bdbmoviesinopsis() {
		if (s1bdbmoviesinopsis == null) {
			s1bdbmoviesinopsis = new JTextArea();
			s1bdbmoviesinopsis.setEditable(false);
			s1bdbmoviesinopsis.setMargin(new Insets(10, 10, 10, 10));
			s1bdbmoviesinopsis.setWrapStyleWord(true);
			s1bdbmoviesinopsis.setLineWrap(true);
			s1bdbmoviesinopsis.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s1bdbmoviesinopsis.setBackground(new Color(40, 40, 40));
			s1bdbmoviesinopsis.setForeground(new Color(255, 255, 255));
		}
		return s1bdbmoviesinopsis;
	}

	private JPanel getPanel_2() {
		if (s1bdbfootercontainer == null) {
			s1bdbfootercontainer = new JPanel();
			s1bdbfootercontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s1bdbfootercontainer
					.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s1bdbfootercontainer.add(getS1bdbfcontinuar());
		}
		return s1bdbfootercontainer;
	}

	private JButton getS1bdbfcontinuar() {
		if (s1bdbfcontinuar == null) {
			s1bdbfcontinuar = new JButton("Elegir esta");
			s1bdbfcontinuar.setEnabled(false);
			// Este botï¿½n quiere ir a la siguiente capa
			s1bdbfcontinuar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(
							"****** Creando nuevo pedido para la pelï¿½cula "
									+ s1bmovielist.getSelectedValue()
									+ " ******");
					pedido = new Purchase(s1bmovielist.getSelectedValue());

					fechas.removeAllElements();
					for (String f : s1bmovielist.getSelectedValue()
							.getFechas(locale.toLanguageTag()))
						fechas.addElement(f);
					s2bdatepicker.setModel(fechas);

					for (Component c : s2bhbuttoncontainer.getComponents())
						s2bhbuttoncontainer.remove(c);
					fecha = (String) s2bdatepicker.getSelectedItem();
					for (Moment m : pedido.getPelicula().getMomentos()) {
						if (m.getDate(locale.toLanguageTag()).equals(fecha)) {
							JButton temp = new JButton(
									m.getHour(locale.toLanguageTag()));
							temp.setPreferredSize(new Dimension(100, 100));
							temp.setBorderPainted(false);
							temp.setBorder(new LineBorder(
									new Color(255, 255, 255), 2));
							temp.setForeground(new Color(255, 255, 255));
							temp.setBackground(new Color(65, 105, 225));
							temp.setFont(new Font("Segoe UI", Font.PLAIN, 15));
							temp.addActionListener(new HourButtonActionListener(
									m.getHour(locale.toLanguageTag())));
							s2bhbuttoncontainer.add(temp);
						}
					}
					((CardLayout) cardPanel.getLayout()).next(cardPanel);
				}

			});
			s1bdbfcontinuar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s1bdbfcontinuar.setPreferredSize(new Dimension(100, 50));
			s1bdbfcontinuar.setBorderPainted(false);
			s1bdbfcontinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
			s1bdbfcontinuar
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s1bdbfcontinuar.setForeground(new Color(255, 255, 255));
			s1bdbfcontinuar.setBackground(new Color(65, 105, 225));
		}
		return s1bdbfcontinuar;
	}

	private JPanel getScreen2() {
		if (screen2 == null) {
			screen2 = new JPanel();
			screen2.setBackground(new Color(40, 40, 40));
			screen2.setLayout(new BorderLayout(0, 10));
			screen2.add(getS2head(), BorderLayout.NORTH);
			screen2.add(getS2body(), BorderLayout.CENTER);
		}
		return screen2;
	}

	private JPanel getS2head() {
		if (s2head == null) {
			s2head = new JPanel();
			s2head.setBackground(new Color(40, 40, 40));
			s2head.setLayout(new BoxLayout(s2head, BoxLayout.X_AXIS));
			s2head.add(getS2hbackcontainer());
			s2head.add(getS2htitle());
			s2head.add(getS2hbuttoncontainer());
		}
		return s2head;
	}

	private JPanel getS2hbackcontainer() {
		if (s2hbackcontainer == null) {
			s2hbackcontainer = new JPanel();
			s2hbackcontainer.setBackground(new Color(40, 40, 40));
			FlowLayout fl_s2hbackcontainer = (FlowLayout) s2hbackcontainer
					.getLayout();
			fl_s2hbackcontainer.setAlignment(FlowLayout.LEADING);
			s2hbackcontainer.add(getS2hback());
		}
		return s2hbackcontainer;
	}

	private JButton getS2hback() {
		if (s2hback == null) {
			s2hback = new JButton("");
			s2hback.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_atras.png")));
			// Este botï¿½n quiere ir a la capa anterior
			s2hback.addActionListener(anterior);
			s2hback.setForeground(Color.WHITE);
			s2hback.setBorderPainted(false);
			s2hback.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s2hback.setBackground(new Color(65, 105, 225));
		}
		return s2hback;
	}

	private JLabel getS2htitle() {
		if (s2htitle == null) {
			s2htitle = new JLabel("Seleccione la sesi\u00F3n:");
			s2htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s2htitle.setForeground(new Color(255, 255, 255));
			s2htitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return s2htitle;
	}

	private JPanel getS2hbuttoncontainer() {
		if (s2hbuttoncontainer == null) {
			s2hbuttoncontainer = new JPanel();
			FlowLayout flowLayout = (FlowLayout) s2hbuttoncontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s2hbuttoncontainer.setBackground(new Color(40, 40, 40));
			s2hbuttoncontainer.add(getS2hbayuda());
			s2hbuttoncontainer.add(getS2hbsalir());
		}
		return s2hbuttoncontainer;
	}

	private JButton getS2hbsalir() {
		if (s2hbsalir == null) {
			s2hbsalir = new JButton("");
			s2hbsalir.setBackground(new Color(178, 34, 34));
			s2hbsalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_salir.png")));
			// Este botï¿½n quiere ir a la primera capa
			s2hbsalir.addActionListener(primero);
			s2hbsalir.setBorderPainted(false);
			s2hbsalir.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		}
		return s2hbsalir;
	}

	private JButton getS2hbayuda() {
		if (s2hbayuda == null) {
			s2hbayuda = new JButton("");
			s2hbayuda.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_ayuda.png")));
			s2hbayuda.setBackground(new Color(65, 105, 225));
			s2hbayuda.setBorderPainted(false);
			s2hbayuda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		}
		return s2hbayuda;
	}

	private JPanel getS2body() {
		if (s2body == null) {
			s2body = new JPanel();
			s2body.setBackground(new Color(40, 40, 40));
			s2body.setLayout(new BorderLayout(0, 10));
			s2body.add(getS2bdatecontainer(), BorderLayout.NORTH);
			s2body.add(getS2bhourcontainer(), BorderLayout.CENTER);
		}
		return s2body;
	}

	private JComboBox<String> getS2bdatepicker() {
		if (s2bdatepicker == null) {
			s2bdatepicker = new JComboBox<String>();
			s2bdatepicker.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					fecha = (String) s2bdatepicker.getSelectedItem();
					/**
					 * for (Component c : s2bhbuttoncontainer.getComponents())
					 * s2bhbuttoncontainer.remove(c);
					 * s2bhbuttoncontainer.repaint(); for (Moment m :
					 * pedido.getPelicula().getMomentos()) { if
					 * (m.getDate(locale.toLanguageTag()).equals(fecha)) {
					 * JButton temp = new
					 * JButton(m.getHour(locale.toLanguageTag()));
					 * temp.setPreferredSize(new Dimension(100, 100));
					 * temp.setBorderPainted(false); temp.setBorder(new
					 * LineBorder(new Color(255, 255, 255), 2));
					 * temp.setForeground(new Color(255, 255, 255));
					 * temp.setBackground(new Color(65, 105, 225));
					 * temp.setFont(new Font("Segoe UI", Font.PLAIN, 15));
					 * temp.addActionListener(new
					 * HourButtonActionListener(m.getHour(locale.toLanguageTag())));
					 * s2bhbuttoncontainer.add(temp); } }
					 */
				}
			});
			s2bdatepicker.setPreferredSize(new Dimension(28, 50));
			s2bdatepicker.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s2bdatepicker.setForeground(new Color(255, 255, 255));
			s2bdatepicker.setBackground(new Color(65, 105, 225));
		}
		return s2bdatepicker;
	}

	private JPanel getS2bhourcontainer() {
		if (s2bhourcontainer == null) {
			s2bhourcontainer = new JPanel();
			s2bhourcontainer
					.setBorder(new LineBorder(new Color(40, 40, 40), 20));
			s2bhourcontainer.setBackground(new Color(40, 40, 40));
			s2bhourcontainer.setLayout(
					new BoxLayout(s2bhourcontainer, BoxLayout.PAGE_AXIS));
			s2bhourcontainer.add(getS2bhseparator());
			s2bhourcontainer.add(getS2bhbuttoncontainer());
		}
		return s2bhourcontainer;
	}

	private JPanel getS2bhbuttoncontainer() {
		if (s2bhbuttoncontainer == null) {
			s2bhbuttoncontainer = new JPanel();
			FlowLayout flowLayout = (FlowLayout) s2bhbuttoncontainer
					.getLayout();
			flowLayout.setVgap(10);
			flowLayout.setHgap(10);
			s2bhbuttoncontainer.setBackground(new Color(40, 40, 40));
		}
		return s2bhbuttoncontainer;
	}

	private JPanel getS2bdatecontainer() {
		if (s2bdatecontainer == null) {
			s2bdatecontainer = new JPanel();
			s2bdatecontainer.setBackground(new Color(40, 40, 40));
			s2bdatecontainer.setLayout(new GridLayout(2, 1, 0, 10));
			s2bdatecontainer.add(getS2bdupperseparator());
			s2bdatecontainer.add(getS2bdatepicker());
		}
		return s2bdatecontainer;
	}

	private Component getS2bdupperseparator() {
		if (s2bdupperseparator == null) {
			s2bdupperseparator = Box.createRigidArea(new Dimension(20, 20));
		}
		return s2bdupperseparator;
	}

	private JPanel getScreen3() {
		if (screen3 == null) {
			screen3 = new JPanel();
			screen3.setBackground(new Color(40, 40, 40));
			screen3.setLayout(new BorderLayout(0, 10));
			screen3.add(getS3head(), BorderLayout.NORTH);
			screen3.add(getS3body(), BorderLayout.CENTER);
		}
		return screen3;
	}

	private JPanel getS3head() {
		if (s3head == null) {
			s3head = new JPanel();
			s3head.setBackground(new Color(40, 40, 40));
			s3head.setLayout(new BoxLayout(s3head, BoxLayout.X_AXIS));
			s3head.add(getS3hbackcontainer());
			s3head.add(getS3htitle());
			s3head.add(getS3hbuttoncontainer());
		}
		return s3head;
	}

	private JPanel getS3hbackcontainer() {
		if (s3hbackcontainer == null) {
			s3hbackcontainer = new JPanel();
			s3hbackcontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s3hbackcontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.LEADING);
			s3hbackcontainer.add(getS3hback());
		}
		return s3hbackcontainer;
	}

	private JButton getS3hback() {
		if (s3hback == null) {
			s3hback = new JButton("");
			s3hback.setBorderPainted(false);
			s3hback.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s3hback.setBackground(new Color(65, 105, 225));
			s3hback.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_atras.png")));
			// Este botï¿½n quiere ir a la capa anterior
			s3hback.addActionListener(anterior);
		}
		return s3hback;
	}

	private JLabel getS3htitle() {
		if (s3htitle == null) {
			s3htitle = new JLabel("Butacas disponibles:");
			s3htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s3htitle.setForeground(new Color(255, 255, 255));
			s3htitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return s3htitle;
	}

	private JPanel getS3hbuttoncontainer() {
		if (s3hbuttoncontainer == null) {
			s3hbuttoncontainer = new JPanel();
			s3hbuttoncontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s3hbuttoncontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s3hbuttoncontainer.add(getS3hbayuda());
			s3hbuttoncontainer.add(getS3hbsalir());
		}
		return s3hbuttoncontainer;
	}

	private JButton getS3hbayuda() {
		if (s3hbayuda == null) {
			s3hbayuda = new JButton("");
			s3hbayuda.setBackground(new Color(65, 105, 225));
			s3hbayuda.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_ayuda.png")));
			s3hbayuda.setBorderPainted(false);
			s3hbayuda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		}
		return s3hbayuda;
	}

	private JButton getS3hbsalir() {
		if (s3hbsalir == null) {
			s3hbsalir = new JButton("");
			s3hbsalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_salir.png")));
			// Este botï¿½n quiere ir a la primera capa
			s3hbsalir.addActionListener(primero);
			s3hbsalir.setBorderPainted(false);
			s3hbsalir.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s3hbsalir.setBackground(new Color(178, 34, 34));
		}
		return s3hbsalir;
	}

	private Component getS2bhseparator() {
		if (s2bhseparator == null) {
			s2bhseparator = Box.createVerticalGlue();
		}
		return s2bhseparator;
	}

	private JPanel getS3body() {
		if (s3body == null) {
			s3body = new JPanel();
			s3body.setBackground(new Color(40, 40, 40));
			s3body.setLayout(new BorderLayout(0, 0));
			s3body.add(getS3bmapcontainer(), BorderLayout.CENTER);
			s3body.add(getS3bfooter(), BorderLayout.SOUTH);
		}
		return s3body;
	}

	private JPanel getS3bmapcontainer() {
		if (s3bmapcontainer == null) {
			s3bmapcontainer = new JPanel();
			s3bmapcontainer.setBackground(new Color(40, 40, 40));
			s3bmapcontainer.setLayout(
					new BoxLayout(s3bmapcontainer, BoxLayout.LINE_AXIS));
			s3bmapcontainer.add(getS3bmleadingseparator());
			s3bmapcontainer.add(getS3bmgrid());
			s3bmapcontainer.add(getS3bmtrailingseparator());
		}
		return s3bmapcontainer;
	}

	private JPanel getS3bfooter() {
		if (s3bfooter == null) {
			s3bfooter = new JPanel();
			s3bfooter.setBackground(new Color(40, 40, 40));
			s3bfooter.setLayout(new BoxLayout(s3bfooter, BoxLayout.LINE_AXIS));
			s3bfooter.add(getS3bfverbose());
			s3bfooter.add(getS3bfentradas());
			s3bfooter.add(getS3bfseparator());
			s3bfooter.add(getS3bfbuttoncontainer());
		}
		return s3bfooter;
	}

	private JLabel getS3bfverbose() {
		if (s3bfverbose == null) {
			s3bfverbose = new JLabel(
					"N\u00FAmero de entradas seleccionadas:  ");
			s3bfverbose.setForeground(new Color(255, 255, 255));
			s3bfverbose.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return s3bfverbose;
	}

	private JLabel getS3bfentradas() {
		if (s3bfentradas == null) {
			s3bfentradas = new JLabel("0");
			s3bfentradas.setForeground(new Color(255, 255, 255));
			s3bfentradas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return s3bfentradas;
	}

	private Component getS3bfseparator() {
		if (s3bfseparator == null) {
			s3bfseparator = Box.createHorizontalGlue();
		}
		return s3bfseparator;
	}

	private JButton getS3bfcontinuar() {
		if (s3bfcontinuar == null) {
			s3bfcontinuar = new JButton("Continuar");
			s3bfcontinuar.setEnabled(false);
			s3bfcontinuar.setForeground(new Color(255, 255, 255));
			s3bfcontinuar.setPreferredSize(new Dimension(100, 50));
			s3bfcontinuar.setBorderPainted(false);
			s3bfcontinuar
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s3bfcontinuar.setBackground(new Color(65, 105, 225));
			s3bfcontinuar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			// Este botï¿½n quiere ir a la siguiente capa
			s3bfcontinuar.addActionListener(new GotoScreen4ActionListener());
		}
		return s3bfcontinuar;
	}

	private JPanel getS3bfbuttoncontainer() {
		if (s3bfbuttoncontainer == null) {
			s3bfbuttoncontainer = new JPanel();
			s3bfbuttoncontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s3bfbuttoncontainer
					.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s3bfbuttoncontainer.add(getS3bfcontinuar());
		}
		return s3bfbuttoncontainer;
	}

	private Component getS1hseparator() {
		if (s1hseparator == null) {
			s1hseparator = Box.createHorizontalGlue();
		}
		return s1hseparator;
	}

	private Component getS3bmleadingseparator() {
		if (s3bmleadingseparator == null) {
			s3bmleadingseparator = Box.createHorizontalGlue();
		}
		return s3bmleadingseparator;
	}

	private JPanel getS3bmgrid() {
		if (s3bmgrid == null) {
			s3bmgrid = new JPanel();
			s3bmgrid.setBackground(new Color(40, 40, 40));
			s3bmgrid.setLayout(new GridLayout(5, 6, 10, 10));
		}
		return s3bmgrid;
	}

	private Component getS3bmtrailingseparator() {
		if (s3bmtrailingseparator == null) {
			s3bmtrailingseparator = Box.createHorizontalGlue();
		}
		return s3bmtrailingseparator;
	}

	private JPanel getScreen0() {
		if (screen0 == null) {
			screen0 = new JPanel();
			screen0.setBackground(new Color(40, 40, 40));
			screen0.setLayout(new BoxLayout(screen0, BoxLayout.PAGE_AXIS));
			screen0.add(getS0leadingseparator());
			screen0.add(getS0logo());
			screen0.add(getS0middleseparator());
			screen0.add(getS0name());
			screen0.add(getS0trailingseparator());
			screen0.add(getS0footer());
			screen0.add(getS0footerseparator());
		}
		return screen0;
	}

	private JPanel getS0footer() {
		if (s0footer == null) {
			s0footer = new JPanel();
			s0footer.setBackground(new Color(40, 40, 40));
			s0footer.setLayout(new BoxLayout(s0footer, BoxLayout.LINE_AXIS));
			s0footer.add(getS0fleadingseparator());
			s0footer.add(getS0fbtnespañol());
			s0footer.add(getS0fmiddleseparator());
			s0footer.add(getS0fbtnenglish());
			s0footer.add(getS0ftrailingseparator());
		}
		return s0footer;
	}

	private Component getS0fleadingseparator() {
		if (s0fleadingseparator == null) {
			s0fleadingseparator = Box.createHorizontalGlue();
		}
		return s0fleadingseparator;
	}

	private JButton getS0fbtnespañol() {
		if (s0fbtnespañol == null) {
			s0fbtnespañol = new JButton("es");
			s0fbtnespañol.setMnemonic('s');
			s0fbtnespañol.setMinimumSize(new Dimension(100, 50));
			s0fbtnespañol.setMaximumSize(new Dimension(100, 50));
			s0fbtnespañol.setToolTipText("Espa\u00F1ol (Espa\u00F1a)");
			s0fbtnespañol.addActionListener(
					new LanguageSelection(LanguageSelection.ES));
			s0fbtnespañol.setPreferredSize(new Dimension(100, 50));
			s0fbtnespañol.setBorderPainted(false);
			s0fbtnespañol
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s0fbtnespañol.setForeground(new Color(255, 255, 255));
			s0fbtnespañol.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s0fbtnespañol.setBackground(new Color(65, 105, 225));
		}
		return s0fbtnespañol;
	}

	private Component getS0fmiddleseparator() {
		if (s0fmiddleseparator == null) {
			s0fmiddleseparator = Box.createHorizontalGlue();
		}
		return s0fmiddleseparator;
	}

	private JButton getS0fbtnenglish() {
		if (s0fbtnenglish == null) {
			s0fbtnenglish = new JButton("en");
			s0fbtnenglish.setMnemonic('n');
			s0fbtnenglish.setMinimumSize(new Dimension(100, 50));
			s0fbtnenglish.setMaximumSize(new Dimension(100, 50));
			s0fbtnenglish.setToolTipText("English (United Kingdom)");
			s0fbtnenglish.addActionListener(
					new LanguageSelection(LanguageSelection.EN));
			s0fbtnenglish.setForeground(new Color(255, 255, 255));
			s0fbtnenglish.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s0fbtnenglish.setBackground(new Color(65, 105, 225));
			s0fbtnenglish.setBorderPainted(false);
			s0fbtnenglish
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s0fbtnenglish.setPreferredSize(new Dimension(100, 50));
		}
		return s0fbtnenglish;
	}

	private Component getS0ftrailingseparator() {
		if (s0ftrailingseparator == null) {
			s0ftrailingseparator = Box.createHorizontalGlue();
		}
		return s0ftrailingseparator;
	}

	private Component getS0leadingseparator() {
		if (s0leadingseparator == null) {
			s0leadingseparator = Box.createVerticalGlue();
		}
		return s0leadingseparator;
	}

	private JLabel getS0logo() {
		if (s0logo == null) {
			s0logo = new JLabel("");
			s0logo.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/Logo\u00C9pico.png")));
			s0logo.setHorizontalAlignment(SwingConstants.CENTER);
			s0logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return s0logo;
	}

	private Component getS0middleseparator() {
		if (s0middleseparator == null) {
			s0middleseparator = Box.createVerticalGlue();
		}
		return s0middleseparator;
	}

	private JLabel getS0name() {
		if (s0name == null) {
			s0name = new JLabel("Cines Cimera");
			s0name.setFont(new Font("Segoe UI", Font.PLAIN, 30));
			s0name.setForeground(new Color(255, 255, 255));
			s0name.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return s0name;
	}

	private Component getS0trailingseparator() {
		if (s0trailingseparator == null) {
			s0trailingseparator = Box.createVerticalGlue();
		}
		return s0trailingseparator;
	}

	private Component getS0footerseparator() {
		if (s0footerseparator == null) {
			s0footerseparator = Box.createVerticalGlue();
		}
		return s0footerseparator;
	}

	private JPanel getScreen4() {
		if (screen4 == null) {
			screen4 = new JPanel();
			screen4.setBackground(new Color(40, 40, 40));
			screen4.setLayout(new BorderLayout(0, 0));
			screen4.add(getS4head(), BorderLayout.NORTH);
			screen4.add(getS4bodyscroll(), BorderLayout.CENTER);
			screen4.add(getS4footer(), BorderLayout.SOUTH);
		}
		return screen4;
	}

	private JPanel getS4head() {
		if (s4head == null) {
			s4head = new JPanel();
			s4head.setBackground(new Color(40, 40, 40));
			s4head.setLayout(new BoxLayout(s4head, BoxLayout.LINE_AXIS));
			s4head.add(getS4hseparator());
			s4head.add(getS4htitle());
			s4head.add(getS4hbuttoncontainer());
		}
		return s4head;
	}

	private Component getS4hseparator() {
		if (s4hseparator == null) {
			s4hseparator = Box.createHorizontalGlue();
		}
		return s4hseparator;
	}

	private JLabel getS4htitle() {
		if (s4htitle == null) {
			s4htitle = new JLabel("Revisi\u00F3n de la compra:");
			s4htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s4htitle.setForeground(new Color(255, 255, 255));
			s4htitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return s4htitle;
	}

	private JPanel getS4hbuttoncontainer() {
		if (s4hbuttoncontainer == null) {
			s4hbuttoncontainer = new JPanel();
			FlowLayout flowLayout = (FlowLayout) s4hbuttoncontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s4hbuttoncontainer.setBackground(new Color(40, 40, 40));
			s4hbuttoncontainer.add(getS4hbayuda());
			s4hbuttoncontainer.add(getS4hbsalir());
		}
		return s4hbuttoncontainer;
	}

	private JButton getS4hbayuda() {
		if (s4hbayuda == null) {
			s4hbayuda = new JButton("");
			s4hbayuda.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_ayuda.png")));
			s4hbayuda.setBorderPainted(false);
			s4hbayuda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s4hbayuda.setBackground(new Color(65, 105, 225));
		}
		return s4hbayuda;
	}

	private JButton getS4hbsalir() {
		if (s4hbsalir == null) {
			s4hbsalir = new JButton("");
			s4hbsalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean result = new DialogoAviso(main,
							txt.getString("d_s4_titulo"),
							new ImageIcon(VentanaPrincipal.class
									.getResource("/img/Azur_exclama.png")),
							txt.getString("d_s4_mensaje"),
							txt.getString("d_s4_boton1"),
							txt.getString("d_s4_boton2")).showDialog();
					if (!result) {
						cimera.getCliente().nuevoCliente();
						((CardLayout) cardPanel.getLayout()).first(cardPanel);
					}
				}
			});
			s4hbsalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_salir.png")));
			s4hbsalir.setBorderPainted(false);
			s4hbsalir.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s4hbsalir.setBackground(new Color(178, 34, 34));
		}
		return s4hbsalir;
	}

	private JPanel getS4footer() {
		if (s4footer == null) {
			s4footer = new JPanel();
			s4footer.setBackground(new Color(40, 40, 40));
			s4footer.setLayout(new BoxLayout(s4footer, BoxLayout.LINE_AXIS));
			s4footer.add(getS4fcomprarmas());
			s4footer.add(getS4fleadingseparator());
			s4footer.add(getS4feliminar());
			s4footer.add(getS4ftrailingseparator());
			s4footer.add(getS4fcontinuar());
		}
		return s4footer;
	}

	private JButton getS4fcomprarmas() {
		if (s4fcomprarmas == null) {
			s4fcomprarmas = new JButton("Comprar m\u00E1s entradas");
			s4fcomprarmas.addActionListener(capa1);
			s4fcomprarmas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s4fcomprarmas.setMaximumSize(new Dimension(200, 50));
			s4fcomprarmas.setMinimumSize(new Dimension(200, 50));
			s4fcomprarmas.setPreferredSize(new Dimension(200, 50));
			s4fcomprarmas.setBorderPainted(false);
			s4fcomprarmas
					.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s4fcomprarmas.setForeground(new Color(255, 255, 255));
			s4fcomprarmas.setBackground(new Color(65, 105, 225));
			s4fcomprarmas.addActionListener(new S4LeftButtonActionListener());
		}
		return s4fcomprarmas;
	}

	private Component getS4fleadingseparator() {
		if (s4fleadingseparator == null) {
			s4fleadingseparator = Box.createHorizontalGlue();
		}
		return s4fleadingseparator;
	}

	private JButton getS4feliminar() {
		if (s4feliminar == null) {
			s4feliminar = new JButton("Eliminar algo");
			s4feliminar.setBorderPainted(false);
			s4feliminar.setPreferredSize(new Dimension(150, 50));
			s4feliminar.setMinimumSize(new Dimension(150, 50));
			s4feliminar.setMaximumSize(new Dimension(150, 50));
			s4feliminar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s4feliminar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s4feliminar.setForeground(new Color(255, 255, 255));
			s4feliminar.setBackground(new Color(178, 34, 34));
			s4feliminar.addActionListener(new S4MiddleButtonActionListener());
		}
		return s4feliminar;
	}

	private Component getS4ftrailingseparator() {
		if (s4ftrailingseparator == null) {
			s4ftrailingseparator = Box.createHorizontalGlue();
		}
		return s4ftrailingseparator;
	}

	private JButton getS4fcontinuar() {
		if (s4fcontinuar == null) {
			s4fcontinuar = new JButton("Esto es todo");
			s4fcontinuar.setMaximumSize(new Dimension(200, 50));
			s4fcontinuar.setMinimumSize(new Dimension(200, 50));
			s4fcontinuar.setPreferredSize(new Dimension(200, 50));
			s4fcontinuar.setBorderPainted(false);
			s4fcontinuar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s4fcontinuar.setBackground(new Color(65, 105, 225));
			s4fcontinuar.setForeground(new Color(255, 255, 255));
			s4fcontinuar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s4fcontinuar.addActionListener(new S4RightButtonActionListener());
		}
		return s4fcontinuar;
	}

	private JScrollPane getS4bodyscroll() {
		if (s4bodyscroll == null) {
			s4bodyscroll = new JScrollPane(getS4body());
			s4bodyscroll.setBorder(null);
		}
		return s4bodyscroll;
	}

	private JPanel getS4body() {
		if (s4body == null) {
			s4body = new JPanel();
			s4body.setBorder(new LineBorder(new Color(40, 40, 40), 10));
			s4body.setBackground(new Color(40, 40, 40));
			s4body.setLayout(new BoxLayout(s4body, BoxLayout.PAGE_AXIS));
			s4body.add(getS4bleadingseparator());
			s4body.add(getTempmovie1());
			s4body.add(getTempmovie2());
			s4body.add(getS4btrailingseparator());
		}
		return s4body;
	}

	private JTextArea getTempmovie1() {
		if (tempmovie1 == null) {
			tempmovie1 = new JTextArea();
			tempmovie1.setMaximumSize(new Dimension(600, 150));
			tempmovie1.setText(
					"\r\nEsta abuela es un peligro IV: La Venganza de Serafina\r\nMi\u00E9rcoles, 26 de Noviembre a las 16:00 h\r\nButacas: B3, B4\r\nPrecio total: 16.384 EUR");
			tempmovie1.setBounds(new Rectangle(10, 10, 10, 10));
			tempmovie1.setBorder(new LineBorder(new Color(255, 255, 255)));
			tempmovie1.setCursor(
					Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			tempmovie1.setPreferredSize(new Dimension(600, 150));
			tempmovie1.setWrapStyleWord(true);
			tempmovie1.setLineWrap(true);
			tempmovie1.setForeground(new Color(255, 255, 255));
			tempmovie1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			tempmovie1.setEditable(false);
			tempmovie1.setBackground(new Color(40, 40, 40));
		}
		return tempmovie1;
	}

	private JTextArea getTempmovie2() {
		if (tempmovie2 == null) {
			tempmovie2 = new JTextArea();
			tempmovie2.setMaximumSize(new Dimension(600, 150));
			tempmovie2.setWrapStyleWord(true);
			tempmovie2.setText(
					"\r\nApple: Una empresa comprometida con la flexibilidad\r\nMi\u00E9rcoles, 26 de Noviembre a las 18:00 h\r\nButaca: C5\r\nPrecio total: 8.192 EUR");
			tempmovie2.setPreferredSize(new Dimension(600, 150));
			tempmovie2.setLineWrap(true);
			tempmovie2.setForeground(Color.WHITE);
			tempmovie2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			tempmovie2.setEditable(false);
			tempmovie2.setBounds(new Rectangle(10, 10, 10, 10));
			tempmovie2.setBorder(new LineBorder(new Color(255, 255, 255)));
			tempmovie2.setBackground(new Color(40, 40, 40));
		}
		return tempmovie2;
	}

	private Component getS4bleadingseparator() {
		if (s4bleadingseparator == null) {
			s4bleadingseparator = Box.createVerticalGlue();
		}
		return s4bleadingseparator;
	}

	private Component getS4btrailingseparator() {
		if (s4btrailingseparator == null) {
			s4btrailingseparator = Box.createVerticalGlue();
		}
		return s4btrailingseparator;
	}

	private JPanel getScreen5() {
		if (screen5 == null) {
			screen5 = new JPanel();
			screen5.setBackground(new Color(40, 40, 40));
			screen5.setLayout(new BorderLayout(0, 0));
			screen5.add(getS5head(), BorderLayout.NORTH);
			screen5.add(getS5body(), BorderLayout.CENTER);
		}
		return screen5;
	}

	private JPanel getS5head() {
		if (s5head == null) {
			s5head = new JPanel();
			s5head.setBackground(new Color(40, 40, 40));
			s5head.setLayout(new BoxLayout(s5head, BoxLayout.LINE_AXIS));
			s5head.add(getS5hbackcontainer());
			s5head.add(getS5htitle());
			s5head.add(getS5hbuttoncontainer());
		}
		return s5head;
	}

	private JPanel getS5hbackcontainer() {
		if (s5hbackcontainer == null) {
			s5hbackcontainer = new JPanel();
			s5hbackcontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s5hbackcontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.LEADING);
			s5hbackcontainer.add(getS5hback());
		}
		return s5hbackcontainer;
	}

	private JButton getS5hback() {
		if (s5hback == null) {
			s5hback = new JButton("");
			s5hback.setBorderPainted(false);
			s5hback.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s5hback.setBackground(new Color(65, 105, 225));
			s5hback.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_atras.png")));
			s5hback.addActionListener(anterior);
		}
		return s5hback;
	}

	private JLabel getS5htitle() {
		if (s5htitle == null) {
			s5htitle = new JLabel("Informaci\u00F3n de pago:");
			s5htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s5htitle.setForeground(new Color(255, 255, 255));
		}
		return s5htitle;
	}

	private JPanel getS5hbuttoncontainer() {
		if (s5hbuttoncontainer == null) {
			s5hbuttoncontainer = new JPanel();
			s5hbuttoncontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s5hbuttoncontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s5hbuttoncontainer.add(getS5bayuda());
			s5hbuttoncontainer.add(getS5bsalir());
		}
		return s5hbuttoncontainer;
	}

	private JButton getS5bayuda() {
		if (s5bayuda == null) {
			s5bayuda = new JButton("");
			s5bayuda.setBorderPainted(false);
			s5bayuda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s5bayuda.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_ayuda.png")));
			s5bayuda.setBackground(new Color(65, 105, 225));
		}
		return s5bayuda;
	}

	private JButton getS5bsalir() {
		if (s5bsalir == null) {
			s5bsalir = new JButton("");
			s5bsalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_salir.png")));
			s5bsalir.setBorderPainted(false);
			s5bsalir.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s5bsalir.setBackground(new Color(178, 34, 34));
			s5bsalir.addActionListener(primero);
		}
		return s5bsalir;
	}

	private JPanel getS5body() {
		if (s5body == null) {
			s5body = new JPanel();
			s5body.setBackground(new Color(40, 40, 40));
			s5body.setLayout(new BorderLayout(0, 0));
			s5body.add(getPanel_3(), BorderLayout.CENTER);
			s5body.add(getS5bfooter(), BorderLayout.SOUTH);
		}
		return s5body;
	}

	private JPanel getPanel_3() {
		if (s5bcontainer == null) {
			s5bcontainer = new JPanel();
			s5bcontainer.setBackground(new Color(40, 40, 40));
			s5bcontainer.setLayout(
					new BoxLayout(s5bcontainer, BoxLayout.LINE_AXIS));
			s5bcontainer.add(getS5bcleadingseparator());
			s5bcontainer.add(getS5bcdescuentos());
			s5bcontainer.add(getS5bctrailingseparator());
		}
		return s5bcontainer;
	}

	private JPanel getS5bfooter() {
		if (s5bfooter == null) {
			s5bfooter = new JPanel();
			s5bfooter.setBackground(new Color(40, 40, 40));
			s5bfooter.setLayout(new BoxLayout(s5bfooter, BoxLayout.LINE_AXIS));
			s5bfooter.add(getLbPrecioFinal());
			s5bfooter.add(getLabel_1());
			s5bfooter.add(getS5bfseparator());
			s5bfooter.add(getS5bfpagar());
		}
		return s5bfooter;
	}

	private Component getS5bcleadingseparator() {
		if (s5bcleadingseparator == null) {
			s5bcleadingseparator = Box.createHorizontalGlue();
		}
		return s5bcleadingseparator;
	}

	private JPanel getS5bcdescuentos() {
		if (s5bcdescuentos == null) {
			s5bcdescuentos = new JPanel();
			s5bcdescuentos.setBackground(new Color(40, 40, 40));
			s5bcdescuentos.setLayout(
					new BoxLayout(s5bcdescuentos, BoxLayout.PAGE_AXIS));
			s5bcdescuentos.add(getS5bcdleadingseparator());
			s5bcdescuentos.add(getCkJubilados());
			s5bcdescuentos.add(getS5bcdmiddleseparator());
			s5bcdescuentos.add(getCkCumpleaños());
			s5bcdescuentos.add(getS5bcdtrailingseparator());
		}
		return s5bcdescuentos;
	}

	private Component getS5bctrailingseparator() {
		if (s5bctrailingseparator == null) {
			s5bctrailingseparator = Box.createHorizontalGlue();
		}
		return s5bctrailingseparator;
	}

	private Component getS5bcdleadingseparator() {
		if (s5bcdleadingseparator == null) {
			s5bcdleadingseparator = Box.createVerticalGlue();
		}
		return s5bcdleadingseparator;
	}

	private JCheckBox getCkJubilados() {
		if (ckJubilados == null) {
			ckJubilados = new JCheckBox("Utilizar descuento para jubilados");
			ckJubilados.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent ie) {
					if (ie.getStateChange() == ItemEvent.SELECTED) {
						cimera.getCliente().applyDelta(
								cimera.getTarifa().getDeltaJubilados());
						lbNumeroPrecio.setText(
								cimera.getCliente().getPrecioTotal(new String())
										+ " ï¿½");
					} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
						cimera.getCliente().removeDelta(
								cimera.getTarifa().getDeltaJubilados());
						lbNumeroPrecio.setText(
								cimera.getCliente().getPrecioTotal(new String())
										+ " ï¿½");
					}
				}
			});
			ckJubilados.setSelectedIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/check_selected.png")));
			ckJubilados.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/check_unselected.png")));
			ckJubilados.setHorizontalAlignment(SwingConstants.CENTER);
			ckJubilados.setFont(new Font("Segoe UI", Font.PLAIN, 22));
			ckJubilados.setForeground(new Color(255, 255, 255));
			ckJubilados.setBackground(new Color(40, 40, 40));
		}
		return ckJubilados;
	}

	private Component getS5bcdmiddleseparator() {
		if (s5bcdmiddleseparator == null) {
			s5bcdmiddleseparator = Box.createVerticalGlue();
		}
		return s5bcdmiddleseparator;
	}

	private JCheckBox getCkCumpleaños() {
		if (ckCumpleaños == null) {
			ckCumpleaños = new JCheckBox("Incluir paquete de cumplea\u00F1os");
			ckCumpleaños.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent ie) {
					if (ie.getStateChange() == ItemEvent.SELECTED) {
						cimera.getCliente().applyDelta(
								cimera.getTarifa().getDeltaCumpleaños());
						lbNumeroPrecio.setText(
								cimera.getCliente().getPrecioTotal(new String())
										+ " ï¿½");
					} else if (ie.getStateChange() == ItemEvent.DESELECTED) {
						cimera.getCliente().removeDelta(
								cimera.getTarifa().getDeltaCumpleaños());
						lbNumeroPrecio.setText(
								cimera.getCliente().getPrecioTotal(new String())
										+ " ï¿½");
					}
				}
			});
			ckCumpleaños.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/check_unselected.png")));
			ckCumpleaños.setSelectedIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/check_selected.png")));
			ckCumpleaños.setHorizontalAlignment(SwingConstants.CENTER);
			ckCumpleaños.setFont(new Font("Segoe UI", Font.PLAIN, 22));
			ckCumpleaños.setBackground(new Color(40, 40, 40));
			ckCumpleaños.setForeground(new Color(255, 255, 255));
		}
		return ckCumpleaños;
	}

	private Component getS5bcdtrailingseparator() {
		if (s5bcdtrailingseparator == null) {
			s5bcdtrailingseparator = Box.createVerticalGlue();
		}
		return s5bcdtrailingseparator;
	}

	private JLabel getLbPrecioFinal() {
		if (lbPrecioFinal == null) {
			lbPrecioFinal = new JLabel("Precio final (incluyendo impuestos): ");
			lbPrecioFinal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lbPrecioFinal.setForeground(new Color(255, 255, 255));
		}
		return lbPrecioFinal;
	}

	private JLabel getLabel_1() {
		if (lbNumeroPrecio == null) {
			lbNumeroPrecio = new JLabel("0,00 \u20AC");
			lbNumeroPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lbNumeroPrecio.setForeground(new Color(255, 255, 255));
		}
		return lbNumeroPrecio;
	}

	private Component getS5bfseparator() {
		if (s5bfseparator == null) {
			s5bfseparator = Box.createHorizontalGlue();
		}
		return s5bfseparator;
	}

	private JButton getS5bfpagar() {
		if (s5bfpagar == null) {
			s5bfpagar = new JButton("Pagar");
			s5bfpagar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s5bfpagar.setMinimumSize(new Dimension(100, 50));
			s5bfpagar.setMaximumSize(new Dimension(100, 50));
			s5bfpagar.setPreferredSize(new Dimension(100, 50));
			s5bfpagar.setBorderPainted(false);
			s5bfpagar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s5bfpagar.setBackground(new Color(65, 105, 225));
			s5bfpagar.setForeground(new Color(255, 255, 255));
			s5bfpagar.addActionListener(siguiente);
		}
		return s5bfpagar;
	}

	private JPanel getScreen6() {
		if (screen6 == null) {
			screen6 = new JPanel();
			screen6.setBackground(new Color(40, 40, 40));
			screen6.setLayout(new BorderLayout(0, 0));
			screen6.add(getS6head(), BorderLayout.NORTH);
			screen6.add(getS6body(), BorderLayout.CENTER);
			screen6.add(getS6footer(), BorderLayout.SOUTH);
		}
		return screen6;
	}

	private JPanel getS6head() {
		if (s6head == null) {
			s6head = new JPanel();
			s6head.setBackground(new Color(40, 40, 40));
			s6head.setLayout(new BoxLayout(s6head, BoxLayout.LINE_AXIS));
			s6head.add(getS6hbackcontainer());
			s6head.add(getS6htitle());
			s6head.add(getS6hbuttoncontainer());
		}
		return s6head;
	}

	private JPanel getS6hbackcontainer() {
		if (s6hbackcontainer == null) {
			s6hbackcontainer = new JPanel();
			s6hbackcontainer.setBackground(new Color(40, 40, 40));
			FlowLayout fl_s6hbackcontainer = (FlowLayout) s6hbackcontainer
					.getLayout();
			fl_s6hbackcontainer.setAlignment(FlowLayout.LEADING);
			s6hbackcontainer.add(getS6hbatras());
		}
		return s6hbackcontainer;
	}

	private JLabel getS6htitle() {
		if (s6htitle == null) {
			s6htitle = new JLabel("Datos de facturaci\u00F3n:");
			s6htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s6htitle.setBackground(new Color(40, 40, 40));
			s6htitle.setForeground(new Color(255, 255, 255));
		}
		return s6htitle;
	}

	private JPanel getS6hbuttoncontainer() {
		if (s6hbuttoncontainer == null) {
			s6hbuttoncontainer = new JPanel();
			s6hbuttoncontainer.setBackground(new Color(40, 40, 40));
			FlowLayout flowLayout = (FlowLayout) s6hbuttoncontainer.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s6hbuttoncontainer.add(getS6hbayuda());
			s6hbuttoncontainer.add(getS6hbsalir());
		}
		return s6hbuttoncontainer;
	}

	private JButton getS6hbatras() {
		if (s6hbatras == null) {
			s6hbatras = new JButton("");
			s6hbatras.setBorderPainted(false);
			s6hbatras.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s6hbatras.setBackground(new Color(65, 105, 225));
			s6hbatras.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_atras.png")));
			s6hbatras.addActionListener(anterior);
		}
		return s6hbatras;
	}

	private JButton getS6hbayuda() {
		if (s6hbayuda == null) {
			s6hbayuda = new JButton("");
			s6hbayuda.setBorderPainted(false);
			s6hbayuda.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s6hbayuda.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_ayuda.png")));
			s6hbayuda.setBackground(new Color(65, 105, 225));
		}
		return s6hbayuda;
	}

	private JButton getS6hbsalir() {
		if (s6hbsalir == null) {
			s6hbsalir = new JButton("");
			s6hbsalir.setBorderPainted(false);
			s6hbsalir.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s6hbsalir.setBackground(new Color(178, 34, 34));
			s6hbsalir.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/icono_salir.png")));
			s6hbsalir.addActionListener(primero);
		}
		return s6hbsalir;
	}

	private JPanel getS6body() {
		if (s6body == null) {
			s6body = new JPanel();
			s6body.setBackground(new Color(40, 40, 40));
			s6body.setLayout(new BoxLayout(s6body, BoxLayout.PAGE_AXIS));
			s6body.add(getS6bleadingseparator());
			s6body.add(getS6bcontainer());
			s6body.add(getS6btrailingseparator());
		}
		return s6body;
	}

	private Component getS6bleadingseparator() {
		if (s6bleadingseparator == null) {
			s6bleadingseparator = Box.createVerticalGlue();
		}
		return s6bleadingseparator;
	}

	private JPanel getS6bcontainer() {
		if (s6bcontainer == null) {
			s6bcontainer = new JPanel();
			s6bcontainer.setBackground(new Color(40, 40, 40));
			s6bcontainer.setLayout(
					new BoxLayout(s6bcontainer, BoxLayout.LINE_AXIS));
			s6bcontainer.add(getS6bcleadingseparator());
			s6bcontainer.add(getLbIntroDNI());
			s6bcontainer.add(getTfDNI());
			s6bcontainer.add(getS6bctrailingseparator());
		}
		return s6bcontainer;
	}

	private Component getS6btrailingseparator() {
		if (s6btrailingseparator == null) {
			s6btrailingseparator = Box.createVerticalGlue();
		}
		return s6btrailingseparator;
	}

	private Component getS6bcleadingseparator() {
		if (s6bcleadingseparator == null) {
			s6bcleadingseparator = Box.createHorizontalGlue();
		}
		return s6bcleadingseparator;
	}

	private JLabel getLbIntroDNI() {
		if (lbIntroDNI == null) {
			lbIntroDNI = new JLabel("Introduzca su DNI: ");
			lbIntroDNI.setFont(new Font("Segoe UI", Font.PLAIN, 22));
			lbIntroDNI.setForeground(new Color(255, 255, 255));
		}
		return lbIntroDNI;
	}

	private JTextField getTfDNI() {
		if (tfDNI == null) {
			tfDNI = new JTextField();
			tfDNI.setHorizontalAlignment(SwingConstants.CENTER);
			tfDNI.setFont(new Font("Segoe UI", Font.PLAIN, 22));
			tfDNI.setMinimumSize(new Dimension(20000, 50));
			tfDNI.setMaximumSize(new Dimension(20000, 50));
			tfDNI.setPreferredSize(new Dimension(20000, 50));
			tfDNI.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			tfDNI.setForeground(new Color(255, 255, 255));
			tfDNI.setBackground(new Color(40, 40, 40));
			tfDNI.setColumns(10);
		}
		return tfDNI;
	}

	private Component getS6bctrailingseparator() {
		if (s6bctrailingseparator == null) {
			s6bctrailingseparator = Box.createHorizontalGlue();
		}
		return s6bctrailingseparator;
	}

	private JPanel getS6footer() {
		if (s6footer == null) {
			s6footer = new JPanel();
			FlowLayout flowLayout = (FlowLayout) s6footer.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			s6footer.setBackground(new Color(40, 40, 40));
			s6footer.add(getS6fadelante());
		}
		return s6footer;
	}

	private JButton getS6fadelante() {
		if (s6fadelante == null) {
			s6fadelante = new JButton("Adelante");
			s6fadelante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (comprobarDNI()) {
						try {
							PrintWriter bw = new PrintWriter(new FileWriter(
									"files/" + tfDNI.getText() + ".txt",
									false));
							bw.println("******** ******** ******** ********");
							bw.println("********    Cines Cimera   ********");
							bw.println("******** ******** ******** ********");
							cimera.getCliente().printClient(bw,
									locale.toLanguageTag());
							if (locale.toLanguageTag().equals("es")) {
								bw.println(
										"****** Gracias por su visita ******");
								bw.println(
										"******** ******** ******** ********");
							} else if (locale.toLanguageTag().equals("en")) {
								bw.println(
										"**** Thank you for visiting us ****");
								bw.println(
										"******** ******** ******** ********");
							}
							bw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (Purchase p : cimera.getCliente().getPedidos()) {
							Room sala = p.getPelicula().getSala();
							for (Seat s : p.getButacas()) {
								for (Seat t : sala.getButacas())
									if (t == s)
										t.setEstado(Seat.OCUPADA,
												p.getMomento());
							}
						}
						((CardLayout) cardPanel.getLayout()).next(cardPanel);
					} else {
						tfDNI.grabFocus();
						new DialogoAviso(main, txt.getString("d_s6_titulo"),
								new ImageIcon(
										Toolkit.getDefaultToolkit().getImage(
												DialogoAviso.class.getResource(
														"/img/Azur_exclama.png"))),
								txt.getString("d_s6_mensaje"),
								txt.getString("d_s6_boton1")).showDialog();
					}
				}
			});
			s6fadelante.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s6fadelante.setMinimumSize(new Dimension(100, 50));
			s6fadelante.setMaximumSize(new Dimension(100, 50));
			s6fadelante.setPreferredSize(new Dimension(100, 50));
			s6fadelante.setForeground(new Color(255, 255, 255));
			s6fadelante.setBorderPainted(false);
			s6fadelante.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s6fadelante.setBackground(new Color(65, 105, 225));
		}
		return s6fadelante;
	}

	private JPanel getScreen7() {
		if (screen7 == null) {
			screen7 = new JPanel();
			screen7.setBackground(new Color(40, 40, 40));
			screen7.setLayout(new BorderLayout(0, 0));
			screen7.add(getS7head(), BorderLayout.NORTH);
			screen7.add(getS7body(), BorderLayout.CENTER);
		}
		return screen7;
	}

	private JPanel getS7head() {
		if (s7head == null) {
			s7head = new JPanel();
			s7head.setBackground(new Color(40, 40, 40));
			s7head.add(getS7htitle());
		}
		return s7head;
	}

	private JLabel getS7htitle() {
		if (s7htitle == null) {
			s7htitle = new JLabel("Ya est\u00E1 todo listo");
			s7htitle.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			s7htitle.setForeground(new Color(255, 255, 255));
		}
		return s7htitle;
	}

	private JPanel getS7body() {
		if (s7body == null) {
			s7body = new JPanel();
			s7body.setBackground(new Color(40, 40, 40));
			s7body.setLayout(new BoxLayout(s7body, BoxLayout.PAGE_AXIS));
			s7body.add(getS7bleadingseparator());
			s7body.add(getS7boutercontainer());
			s7body.add(getS7btrailingseparator());
		}
		return s7body;
	}

	private Component getS7bleadingseparator() {
		if (s7bleadingseparator == null) {
			s7bleadingseparator = Box.createVerticalGlue();
		}
		return s7bleadingseparator;
	}

	private JPanel getS7boutercontainer() {
		if (s7boutercontainer == null) {
			s7boutercontainer = new JPanel();
			s7boutercontainer.setBackground(new Color(40, 40, 40));
			s7boutercontainer.setLayout(
					new BoxLayout(s7boutercontainer, BoxLayout.LINE_AXIS));
			s7boutercontainer.add(getS7bocleadingseparator());
			s7boutercontainer.add(getS7binnercontainer());
			s7boutercontainer.add(getS7boctrailingseparator());
		}
		return s7boutercontainer;
	}

	private Component getS7btrailingseparator() {
		if (s7btrailingseparator == null) {
			s7btrailingseparator = Box.createVerticalGlue();
		}
		return s7btrailingseparator;
	}

	private Component getS7bocleadingseparator() {
		if (s7bocleadingseparator == null) {
			s7bocleadingseparator = Box.createHorizontalGlue();
		}
		return s7bocleadingseparator;
	}

	private JPanel getS7binnercontainer() {
		if (s7binnercontainer == null) {
			s7binnercontainer = new JPanel();
			s7binnercontainer.setBackground(new Color(40, 40, 40));
			s7binnercontainer.setLayout(
					new BoxLayout(s7binnercontainer, BoxLayout.PAGE_AXIS));
			s7binnercontainer.add(getS7biverbosecontainer());
			s7binnercontainer.add(getS7biterminar());
		}
		return s7binnercontainer;
	}

	private Component getS7boctrailingseparator() {
		if (s7boctrailingseparator == null) {
			s7boctrailingseparator = Box.createHorizontalGlue();
		}
		return s7boctrailingseparator;
	}

	private JPanel getS7biverbosecontainer() {
		if (s7biverbosecontainer == null) {
			s7biverbosecontainer = new JPanel();
			s7biverbosecontainer.setBackground(new Color(40, 40, 40));
			s7biverbosecontainer.setLayout(
					new BoxLayout(s7biverbosecontainer, BoxLayout.LINE_AXIS));
			s7biverbosecontainer.add(getS7bivlogo());
			s7biverbosecontainer.add(getS7bivtexto());
		}
		return s7biverbosecontainer;
	}

	private JLabel getS7bivlogo() {
		if (s7bivlogo == null) {
			s7bivlogo = new JLabel("");
			s7bivlogo.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/Azur_feliz_sm.png")));
		}
		return s7bivlogo;
	}

	private JLabel getS7bivtexto() {
		if (s7bivtexto == null) {
			s7bivtexto = new JLabel(" Disfruta de la pel\u00EDcula");
			s7bivtexto.setFont(new Font("Segoe UI", Font.PLAIN, 22));
			s7bivtexto.setForeground(new Color(255, 255, 255));
		}
		return s7bivtexto;
	}

	private JButton getS7biterminar() {
		if (s7biterminar == null) {
			s7biterminar = new JButton("Terminar");
			s7biterminar.setForeground(new Color(255, 255, 255));
			s7biterminar.setAlignmentX(Component.CENTER_ALIGNMENT);
			s7biterminar.setHorizontalTextPosition(SwingConstants.CENTER);
			s7biterminar.setMinimumSize(new Dimension(250, 50));
			s7biterminar.setMaximumSize(new Dimension(250, 50));
			s7biterminar.setPreferredSize(new Dimension(250, 50));
			s7biterminar.setBorderPainted(false);
			s7biterminar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			s7biterminar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			s7biterminar.setBackground(new Color(65, 105, 225));
			s7biterminar.addActionListener(primero);
		}
		return s7biterminar;
	}

	/**
	 * TODO ---- Mï¿½todos no creados por WindowBuilder ----
	 */

	/**
	 * Mï¿½todo que comprueba si el texto introducido en el campo DNI se
	 * corresponde con un DNI vï¿½lido
	 * 
	 * @return Si la comprobaciï¿½n ha sido o no exitosa
	 */
	private boolean comprobarDNI() {
		String text = tfDNI.getText();
		// Asegurarse de que tiene longitud 9
		if (text.toCharArray().length != 9)
			return false;
		// Asegurarse de que los ocho primeros caracteres son nï¿½meros
		for (int i = 0; i < 8; i++) {
			try {
				Integer.valueOf(String.valueOf(text.charAt(i)));
			}
			// Si no, no estï¿½ bien
			catch (NumberFormatException e) {
				return false;
			}
		}
		// Asegurarse de que el ï¿½ltimo caracter es una letra
		try {
			Integer.valueOf(String.valueOf(text.charAt(8)));
		}
		// Si lo es, todo va bien
		catch (NumberFormatException e) {
			return true;
		}
		// Si no, no estï¿½ bien
		return false;
	}

	/**
	 * Mï¿½todo que deja la interfaz como nueva para otro usuario
	 */
	private void reiniciarInterfaz() {
		tfDNI.setText("");
		s1bmovielist.clearSelection();
		s1bdbfcontinuar.setEnabled(false);
		// s2bdatepicker.setSelectedIndex(0);
		ckCumpleaños.setSelected(false);
		ckJubilados.setSelected(false);
		tfDNI.setText("");
		s1bdhmovieinfo.setText("");
		s1bdhmovieposter.setIcon(null);
		translate();
		translateScreen4();
	}

	/**
	 * Mï¿½todo que elimina los pedidos seleccionados por el cliente y reforma
	 * la ventana de Revisiï¿½n de Compra con los que quedan
	 */
	private void removeSelectedPurchases() {
		Purchase[] pedidos = cimera.getCliente().getPedidos()
				.toArray(new Purchase[0]);
		cimera.getCliente().getPedidos().clear();
		for (Purchase p : pedidos) {
			if (!p.is()) {
				cimera.getCliente().getPedidos().add(p);
			}
		}
		for (Component p : s4body.getComponents())
			s4body.remove(p);
		s4body.add(Box.createVerticalGlue());
		for (Purchase p : cimera.getCliente().getPedidos()) {
			JTextArea purch = new JTextArea();
			purch.setMaximumSize(new Dimension(600, 150));
			purch.setBounds(new Rectangle(10, 10, 10, 10));
			purch.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			purch.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			purch.setPreferredSize(new Dimension(600, 150));
			purch.setWrapStyleWord(true);
			purch.setLineWrap(true);
			purch.setForeground(new Color(255, 255, 255));
			purch.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			purch.setEditable(false);
			purch.setBackground(new Color(40, 40, 40));
			purch.setText(p.toString());
			purch.addMouseListener(new SelectPurchaseMouseAdapter(p));
			s4body.add(purch);
		}
		s4body.add(Box.createVerticalGlue());
		s4body.repaint();
		s4feliminar.setEnabled(false);
	}

	/**
	 * Mï¿½todo que modifica los componentes para cambiar de idioma, incluyendo:
	 * - Textos - Tooltips - Mnemï¿½nicos - Cambios de tamaï¿½o (donde fuera
	 * necesario)
	 */
	private void translate() {
		s1htitle.setText(txt.getString("s1header"));
		s1hbayuda.setToolTipText(txt.getString("btnayuda"));
		s1hbsalir.setToolTipText(txt.getString("btnsalir"));
		s1bdbfcontinuar.setText(txt.getString("s1bdbfcontinuar_texto"));
		s1bdbfcontinuar.setMnemonic(s1bdbfcontinuar.getText().toCharArray()[0]);
		s1bdbfcontinuar.setToolTipText(txt.getString("s1bdbfcontinuar_tt"));
		s1bdbmoviesinopsis.setText(txt.getString("s1bdmoviesinopsis"));

		s2htitle.setText(txt.getString("s2header"));
		s2hback.setToolTipText(txt.getString("btnatras"));
		s2hbayuda.setToolTipText(txt.getString("btnayuda"));
		s2hbsalir.setToolTipText(txt.getString("btnsalir"));

		s3htitle.setText(txt.getString("s3header"));
		s3hback.setToolTipText(txt.getString("btnatras"));
		s3hbayuda.setToolTipText(txt.getString("btnayuda"));
		s3hbsalir.setToolTipText(txt.getString("btnsalir"));
		// for (Component seat : s3bmgrid.getComponents()) Las butacas ya no son
		// constantes,
		// if (seat instanceof JButton) sino que cambian al elegir sesiï¿½n
		// ((JButton) seat).setToolTipText(txt.getString("s3bgrid_libre"));
		s3bfcontinuar.setText(txt.getString("s3bfcontinuar_texto"));
		s3bfcontinuar.setMnemonic(s3bfcontinuar.getText().toCharArray()[0]);
		s3bfverbose.setText(txt.getString("s3bfverbose"));

		s5htitle.setText(txt.getString("s5header"));
		s5bfpagar.setText(txt.getString("s5bfpagar_texto"));
		s5bfpagar.setToolTipText(txt.getString("s5bfpagar_tt"));
		s5bfpagar.setMnemonic(s5bfpagar.getText().toCharArray()[0]);
		ckJubilados.setText(txt.getString("ckJubilados"));
		ckJubilados.setToolTipText(txt.getString("ckJubilados_tt"));
		ckCumpleaños.setText(txt.getString("ckCumpleaï¿½os"));
		ckCumpleaños.setToolTipText(txt.getString("ckCumpleaï¿½os_tt"));
		lbPrecioFinal.setText(txt.getString("lbPrecioFinal"));

		s6htitle.setText(txt.getString("s6header"));
		s6fadelante.setText(txt.getString("s6fadelante_texto"));
		s6fadelante.setToolTipText(txt.getString("s6fadelante_tt"));
		s6fadelante.setMnemonic(s6fadelante.getText().toCharArray()[0]);
		lbIntroDNI.setText(txt.getString("lbIntroDNI"));
		tfDNI.setToolTipText(txt.getString("tfDNI_tt"));

		s7htitle.setText(txt.getString("s7header"));
		s7biterminar.setText(txt.getString("s7biterminar_texto"));
		s7biterminar.setToolTipText(txt.getString("s7biterminar_tt"));
		s7biterminar.setMnemonic(s7biterminar.getText().toCharArray()[0]);
		s7bivtexto.setText(txt.getString("s7bivtexto"));
		s7bivlogo.setToolTipText(txt.getString("s7bivlogo_tt"));

		if (locale.getLanguage() == "en") {
			s1bdbfcontinuar.setPreferredSize(new Dimension(150, 50));
			s1hbsalir.setMnemonic('Q'); // Quit
			s2hbsalir.setMnemonic('Q');
			s2hback.setMnemonic('B'); // Back
			s3hbsalir.setMnemonic('Q');
			s3hback.setMnemonic('B');
			s4hbsalir.setMnemonic('Q');
		} else {
			s1bdbfcontinuar.setPreferredSize(new Dimension(100, 50));
			s1hbsalir.setMnemonic('S'); // Salir
			s2hbsalir.setMnemonic('S');
			s2hback.setMnemonic('A'); // Atrï¿½s
			s3hbsalir.setMnemonic('S');
			s3hback.setMnemonic('A');
			s4hbsalir.setMnemonic('S');
		}
	}

	/**
	 * Mï¿½todo que traduce la capa 4
	 */
	private void translateScreen4() {

		if (screen4mode == MODE_REVIEW) {
			s4htitle.setText(txt.getString("s4header"));
			s4fcomprarmas.setText(txt.getString("s4fcomprarmas_texto"));
			s4fcomprarmas.setToolTipText(txt.getString("s4fcomprarmas_tt"));
			s4feliminar.setText(txt.getString("s4feliminar_texto"));
			s4feliminar.setToolTipText(txt.getString("s4feliminar_tt"));
			s4fcontinuar.setText(txt.getString("s4fcontinuar_texto"));
			s4fcontinuar.setToolTipText(txt.getString("s4fcontinuar_tt"));
		} else {
			s4htitle.setText(txt.getString("s4bheader"));
			s4fcomprarmas.setText(txt.getString("s4bfcomprarmas_texto"));
			s4fcomprarmas.setToolTipText(txt.getString("s4bfcomprarmas_tt"));
			s4feliminar.setText(txt.getString("s4bfeliminar_texto"));
			s4feliminar.setToolTipText(txt.getString("s4bfeliminar_tt"));
			s4fcontinuar.setText(txt.getString("s4bfcontinuar_texto"));
			s4fcontinuar.setToolTipText(txt.getString("s4bfcontinuar_tt"));
		}
		s4hbayuda.setToolTipText(txt.getString("btnayuda"));
		s4hbsalir.setToolTipText(txt.getString("btnsalir"));
		s4fcomprarmas.setMnemonic(s4fcomprarmas.getText().toCharArray()[0]);
		s4feliminar.setMnemonic(s4feliminar.getText().toCharArray()[0]);
		s4fcontinuar.setMnemonic(s4fcontinuar.getText().toCharArray()[0]);
	}

	/**
	 * Mï¿½todo que ajusta y coloca una imagen como icono de un componente
	 * segï¿½n su tamaï¿½o
	 * 
	 * @param component
	 *            Componente
	 * @param rutaImagen
	 *            Ruta de acceso a la imagen
	 */
	private void adaptarImagenLabel(JComponent component, String rutaImagen) {
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen))
				.getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(
				(int) (component.getWidth()), (int) (component.getHeight()),
				Image.SCALE_FAST);
		if (component instanceof JLabel)
			((JLabel) component).setIcon(new ImageIcon(imgEscalada));
		else if (component instanceof JButton)
			((JButton) component).setIcon(new ImageIcon(imgEscalada));
	}

	private void cargarAyuda() {
		if (locale.toLanguageTag().equals("es")) {
			try {
				File fichero = new File("help/Ayuda.hs");
				helpSetURI = fichero.toURI().toURL();
				help = new HelpSet(null, helpSetURI);
			} catch (Exception e) {
				return;
			}
			liara = help.createHelpBroker();
			liara.enableHelpKey(getRootPane(), "Default", help);
			liara.enableHelpKey(screen0, "Step1", help);
			liara.enableHelpKey(screen1, "PeliculaStep1", help);
			liara.enableHelpKey(screen2, "SesionStep1", help);
			liara.enableHelpKey(screen3, "ButacaStep1", help);
			liara.enableHelpKey(screen4, "MasCosasStep1", help);
			liara.enableHelpKey(screen5, "PagarStep1", help);
			liara.enableHelpKey(screen6, "PagarStep1", help);
			liara.enableHelpKey(screen7, "Final", help);
			liara.enableHelpOnButton(s1hbayuda, "PeliculaStep1", help);
			liara.enableHelpOnButton(s2hbayuda, "SesionStep1", help);
			liara.enableHelpOnButton(s3hbayuda, "ButacaStep1", help);
			liara.enableHelpOnButton(s4hbayuda, "MasCosasStep1", help);
			liara.enableHelpOnButton(s5bayuda, "PagarStep1", help);
			liara.enableHelpOnButton(s6hbayuda, "PagarStep1", help);
		} else if (locale.toLanguageTag().equals("en")) {
			try {
				File fichero = new File("help/Ayuda_en.hs");
				helpSetURI = fichero.toURI().toURL();
				help = new HelpSet(null, helpSetURI);
			} catch (Exception e) {
				return;
			}
			liara = help.createHelpBroker();
			liara.enableHelpKey(getRootPane(), "Default_en", help);
			liara.enableHelpKey(screen0, "Step1_en", help);
			liara.enableHelpKey(screen1, "PeliculaStep1_en", help);
			liara.enableHelpKey(screen2, "SesionStep1_en", help);
			liara.enableHelpKey(screen3, "ButacaStep1_en", help);
			liara.enableHelpKey(screen4, "MasCosasStep1_en", help);
			liara.enableHelpKey(screen5, "PagarStep1_en", help);
			liara.enableHelpKey(screen6, "PagarStep1_en", help);
			liara.enableHelpKey(screen7, "Final_en", help);
			liara.enableHelpOnButton(s1hbayuda, "PeliculaStep1_en", help);
			liara.enableHelpOnButton(s2hbayuda, "SesionStep1_en", help);
			liara.enableHelpOnButton(s3hbayuda, "ButacaStep1_en", help);
			liara.enableHelpOnButton(s4hbayuda, "MasCosasStep1_en", help);
			liara.enableHelpOnButton(s5bayuda, "PagarStep1_en", help);
			liara.enableHelpOnButton(s6hbayuda, "PagarStep1_en", help);
		}
	}

	/**
	 * TODO ---- Clases gestoras de eventos ----
	 */

	/**
	 * Clase que gestiona los eventos ActionPerformed de los botones 'Adelante',
	 * 'Atrï¿½s' y 'Volver al principio'
	 */
	class CardSwipe implements ActionListener {

		// ï¿½En quï¿½ direcciï¿½n quiere ir el botï¿½n que lanza el evento?
		private int destino;
		public final static int PRIMERO = 0;
		public final static int ULTIMO = 1;
		public final static int SIGUIENTE = 2;
		public final static int ANTERIOR = 3;

		/**
		 * Constructor de la clase CardSwipe
		 * 
		 * @param destino
		 *            Direcciï¿½n del movimiento
		 */
		public CardSwipe(int destino) {
			this.destino = destino;
		}

		/**
		 * Mï¿½todo que cambia de capa
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// Comprobar el atributo 'destino'
			switch (destino) {
			case PRIMERO:
				// Eliminar pedidos
				cimera.getCliente().nuevoCliente();
				((CardLayout) cardPanel.getLayout()).first(cardPanel);
				// Ir a la primera capa del panel
				break;
			case ULTIMO:
				((CardLayout) cardPanel.getLayout()).last(cardPanel);
				// Ir a la ï¿½ltima capa del panel
				break;
			case SIGUIENTE:
				((CardLayout) cardPanel.getLayout()).next(cardPanel);
				// Ir a la siguiente capa del panel
				break;
			case ANTERIOR:
				((CardLayout) cardPanel.getLayout()).previous(cardPanel);
				// Ir a la anterior capa del panel
				break;
			}
		}

	}

	/**
	 * Clase que permite saltar a una capa concreta (por nombre)
	 *
	 */
	class CardSwipeByName implements ActionListener {

		private String destino;

		public CardSwipeByName(String destino) {
			this.destino = destino;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			((CardLayout) cardPanel.getLayout()).show(cardPanel, destino);
		}
	}

	/**
	 * Clase que gestiona los eventos ActionPerformed de los botones de
	 * selecciï¿½n de idioma
	 */
	class LanguageSelection implements ActionListener {

		// ï¿½Quï¿½ idioma corresponde al botï¿½n pulsado?
		private String idioma;
		public final static String ES = "es";
		public final static String EN = "en";

		/**
		 * Constructor de la clase CardSwipe
		 * 
		 * @param destino
		 *            Direcciï¿½n del movimiento
		 */
		public LanguageSelection(String idioma) {
			this.idioma = idioma;
		}

		/**
		 * Mï¿½todo que cambia de idioma y pasa a la capa siguiente
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// Comprobar el atributo 'destino'
			switch (idioma) {
			case ES:
				locale = new Locale("es");
				txt = ResourceBundle.getBundle("files/locale", locale);
				// Reiniciar los pedidos, por si acaso
				cimera.getCliente().nuevoCliente();

				translate();
				translateScreen4();
				cargarAyuda();
				((CardLayout) cardPanel.getLayout()).next(cardPanel);
				break;
			case EN:
				locale = new Locale("en");
				txt = ResourceBundle.getBundle("files/locale", locale);
				// Reiniciar los pedidos, por si acaso
				cimera.getCliente().nuevoCliente();

				translate();
				translateScreen4();
				cargarAyuda();
				((CardLayout) cardPanel.getLayout()).next(cardPanel);
				break;
			}
			// Dejar la interfaz lista para el nuevo cliente
			reiniciarInterfaz();
		}

	}

	/**
	 * Clase que controla el botï¿½n central de la capa 4
	 */
	class S4MiddleButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Si estamos en modo Revisiï¿½n, pasar a modo Eliminar
			if (screen4mode == MODE_REVIEW) {
				screen4mode = MODE_DELETE;
				s4fcomprarmas.setVisible(false);
				s4feliminar.setEnabled(false);
			} else {
				// Si estamos en modo Eliminar, eliminar los seleccionados
				removeSelectedPurchases();
				if (cimera.getCliente().getPedidos().size() > 0) {
					s4feliminar.setEnabled(true);
					s4fcontinuar.setEnabled(true);
				} else {
					s4feliminar.setEnabled(false);
				}
			}
			// Cambiar textos
			translateScreen4();
		}

	}

	/**
	 * Clase que controla el botï¿½n izquierdo de la capa 4
	 */
	class S4LeftButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Si estamos en modo Revisiï¿½n, comprar entradas para otra
			// pelï¿½cula
			if (screen4mode == MODE_REVIEW) {
				((CardLayout) cardPanel.getLayout()).show(cardPanel, "capa1");
				s1bmovielist.clearSelection();
				s1bdbmoviesinopsis.setText("");
				s1bdhmovieinfo.setText("");
				s1bdhmovieposter.setIcon(null);
				s1bdbfcontinuar.setEnabled(false);
				s4fcontinuar.setEnabled(true);
				s4feliminar.setEnabled(true);
			} else {
				// Si estamos en modo Eliminar, no hacer nada
				return;
			}
		}

	}

	/**
	 * Clase que controla el botï¿½n derecho de la capa 4
	 */
	class S4RightButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Si estamos en modo Revisiï¿½n, pasar a la siguiente capa
			if (screen4mode == MODE_REVIEW) {
				cimera.getCliente().updatePrecioTotal();
				lbNumeroPrecio
						.setText(cimera.getCliente().getPrecioFinal() + " ï¿½");
				((CardLayout) cardPanel.getLayout()).next(cardPanel);
			} else {
				// Si estamos en modo Eliminar, pasar a modo Revisiï¿½n
				screen4mode = MODE_REVIEW;
				s4fcomprarmas.setVisible(true);
				if (cimera.getCliente().getPedidos().size() > 0)
					s4fcontinuar.setEnabled(true);
				else
					s4fcontinuar.setEnabled(false);
				for (Component c : s4body.getComponents())
					if (c instanceof JTextArea) {
						c.setFont(new Font("Segoe UI", Font.PLAIN, 15));
						c.setForeground(new Color(255, 255, 255));
					}
			}
			// Cambiar textos
			translateScreen4();
		}

	}

	/**
	 * Clase que controla la selecciï¿½n de pedidos en la ventana de Revisiï¿½n
	 * de Compra
	 */
	class SelectPurchaseMouseAdapter extends MouseAdapter {
		Purchase pch;
		boolean is;

		public SelectPurchaseMouseAdapter(Purchase pch) {
			this.pch = pch;
			is = false;
		}

		public void mouseClicked(MouseEvent me) {
			if (screen4mode == MODE_REVIEW)
				return;
			if (!is) {
				is = true;
				System.out.println("****** Seleccionando el pedido "
						+ pch.getPelicula() + " ******");
				System.out.println("****** Se ha pulsado sobre "
						+ ((JTextArea) me.getComponent()).getText()
						+ " ******");
				pch.set(true);
				me.getComponent()
						.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
				me.getComponent().setForeground(new Color(178, 34, 34));
			} else {
				is = false;
				System.out.println("****** Deseleccionando el pedido "
						+ pch.getPelicula() + " ******");
				System.out.println("****** Se ha pulsado sobre "
						+ ((JTextArea) me.getComponent()).getText()
						+ " ******");
				pch.set(false);
				me.getComponent().setFont(new Font("Segoe UI", Font.PLAIN, 15));
				me.getComponent().setForeground(new Color(255, 255, 255));
			}
			for (Purchase p : cimera.getCliente().getPedidos()) {
				if (p.is()) {
					s4feliminar.setEnabled(true);
					break;
				}
				s4feliminar.setEnabled(false);
			}
		}
	}

	/**
	 * Clase que controla el lo que pasa al llegar a la capa 4
	 */
	class GotoScreen4ActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			override = true;
			pedido.updatePrecio(cimera.getTarifa());
			cimera.getCliente().añadirPedido(pedido);

			for (Component p : s4body.getComponents())
				s4body.remove(p);
			s4body.add(Box.createVerticalGlue());
			// Crear ï¿½reas de Texto para cada pedido
			for (Purchase p : cimera.getCliente().getPedidos()) {
				JTextArea purch = new JTextArea();
				purch.setMaximumSize(new Dimension(600, 150));
				purch.setBounds(new Rectangle(10, 10, 10, 10));
				purch.setBorder(new LineBorder(new Color(255, 255, 255), 2));
				purch.setCursor(
						Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				purch.setPreferredSize(new Dimension(600, 150));
				purch.setWrapStyleWord(true);
				purch.setLineWrap(true);
				purch.setForeground(new Color(255, 255, 255));
				purch.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				purch.setEditable(false);
				purch.setBackground(new Color(40, 40, 40));
				purch.setText(p.toString(locale.toLanguageTag()));
				purch.addMouseListener(new SelectPurchaseMouseAdapter(p));
				s4body.add(purch);
			}
			s4body.add(Box.createVerticalGlue());
			((CardLayout) cardPanel.getLayout()).next(cardPanel);
		}

	}

	/**
	 * Clase que controla lo que pasa al pulsar un botï¿½n con horas
	 */
	class HourButtonActionListener implements ActionListener {
		private String hora;

		public HourButtonActionListener(String hora) {
			this.hora = hora;
		}

		public void actionPerformed(ActionEvent arg0) {
			Moment[] momentos = pedido.getPelicula().getMomentos();
			System.out.println(
					" Estableciendo " + fecha + " como fecha del pedido");
			System.out.println(
					" Estableciendo " + hora + " como hora del pedido");
			for (Moment m : momentos)
				if (m.getDate(locale.toLanguageTag()).equals(fecha)
						&& m.getHour(locale.toLanguageTag()).equals(hora))
					pedido.setMomento(m);
			/**
			 * Como ya tenemos el momento, podemos conseguir la ocupaciï¿½n de
			 * las butacas apropiadas
			 */
			ArrayList<Seat> butacas = s1bmovielist.getSelectedValue().getSala()
					.getButacas();
			for (int i = 0; i < 30; i++) {
				if (butacas.get(i)
						.getEstado(pedido.getMomento()) == Seat.LIBRE) {
					((JCheckBox) s3bmgrid.getComponents()[i]).setEnabled(true);
					((JCheckBox) s3bmgrid.getComponents()[i])
							.setSelected(false);
				} else if (butacas.get(i)
						.getEstado(pedido.getMomento()) == Seat.OCUPADA) {
					((JCheckBox) s3bmgrid.getComponents()[i]).setEnabled(false);
					((JCheckBox) s3bmgrid.getComponents()[i])
							.setSelected(false);
				} else if (butacas.get(i)
						.getEstado(pedido.getMomento()) == Seat.PARA_MI) {
					((JCheckBox) s3bmgrid.getComponents()[i]).setEnabled(true);
					((JCheckBox) s3bmgrid.getComponents()[i])
							.setSelected(false);
				}
				s3bfentradas.setText("0");
				pedido.getButacas().clear();
			}

			s3bfcontinuar.setEnabled(false);
			((CardLayout) cardPanel.getLayout()).next(cardPanel);
			override = false;

		}
	}
}
