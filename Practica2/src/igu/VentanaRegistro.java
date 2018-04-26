package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class VentanaRegistro extends JFrame {

	private JPanel panelPrincipal;
	private JTextField textFieldNombre;
	private JTextField textField_1Apellidos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2Correo;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("Ventana de Registro\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 368);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.LIGHT_GRAY);
		panelPrincipal.setForeground(Color.WHITE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 21, 67, 14);
		panelPrincipal.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(87, 18, 150, 20);
		panelPrincipal.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(247, 21, 58, 14);
		panelPrincipal.add(lblApellidos);

		textField_1Apellidos = new JTextField();
		textField_1Apellidos.setBounds(315, 18, 322, 20);
		panelPrincipal.add(textField_1Apellidos);
		textField_1Apellidos.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(630, 296, 92, 23);
		panelPrincipal.add(btnCancelar);

		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarVacio();
				comprobarPass();		
				
			}
		});

		btnSiguiente.setBounds(509, 296, 98, 23);
		panelPrincipal.add(btnSiguiente);

		JPanel panelSexo = new JPanel();
		panelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelSexo.setToolTipText("");
		panelSexo.setBounds(10, 62, 227, 56);
		panelPrincipal.add(panelSexo);

		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		buttonGroup.add(rdbtnHombre);
		panelSexo.add(rdbtnHombre);

		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		panelSexo.add(rdbtnMujer);

		JPanel panelFechaNacimiento = new JPanel();
		panelFechaNacimiento.setBorder(
				new TitledBorder(null, "Fecha de nacimiento", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelFechaNacimiento.setBounds(247, 62, 390, 56);
		panelPrincipal.add(panelFechaNacimiento);
		panelFechaNacimiento.setLayout(null);

		JComboBox comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo ",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		comboMes.setBounds(66, 21, 134, 20);
		panelFechaNacimiento.add(comboMes);

		JComboBox comboAño = new JComboBox();
		comboAño.setModel(new DefaultComboBoxModel(new String[] { "1930", "1931", "1932", "1933", "1934", "1935",
				"1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948",
				"1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961",
				"1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974",
				"1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987",
				"1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000",
				"2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
				"2014", "2015", "2016", "2017" }));
		comboAño.setToolTipText("");
		comboAño.setBounds(210, 21, 70, 20);
		panelFechaNacimiento.add(comboAño);

		JComboBox comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboDia.setBounds(10, 21, 46, 20);
		panelFechaNacimiento.add(comboDia);

		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de Registro",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.setBounds(10, 150, 489, 168);
		panelPrincipal.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario (Email): ");
		lblUsuario.setBounds(10, 21, 110, 14);
		panelDatos.add(lblUsuario);

		textField_2Correo = new JTextField();
		textField_2Correo.setBounds(140, 18, 339, 20);
		panelDatos.add(textField_2Correo);
		textField_2Correo.setColumns(10);

		JLabel lblPass = new JLabel("Contrase\u00F1a: ");
		lblPass.setBounds(10, 46, 110, 14);
		panelDatos.add(lblPass);

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 43, 339, 20);
		panelDatos.add(passwordField);

		JLabel lblRepetirPass = new JLabel("Repetir contrase\u00F1a: ");
		lblRepetirPass.setBounds(10, 71, 120, 14);
		panelDatos.add(lblRepetirPass);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(140, 68, 339, 20);
		panelDatos.add(passwordField_1);

	}

	public void comprobarVacio()
	{
		String lblPassText = String.valueOf(passwordField.getPassword());
		String lblRepetirPassText = String.valueOf(passwordField_1.getPassword());
		if(textFieldNombre.getText().length() == 0 || textField_1Apellidos.getText().length() == 0 || textField_2Correo.getText().length() == 0 || 
				lblPassText.length() == 0 || lblRepetirPassText.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos.");
		}
	}
	
	public void comprobarPass() {

		String lblPassText = String.valueOf(passwordField.getPassword());
		String lblRepetirPassText = String.valueOf(passwordField_1.getPassword()); //paso de char a string
		if (!lblPassText.equals(lblRepetirPassText)) { //compruebo las pass
			JOptionPane.showMessageDialog(null, "No coinciden las contraseñas.");
		} 
	}
	
	
}

// ACABAR PANEL NUEVO, LABEL, JPASSWORDFIELD
// GARANTIZAR QUE NINGUN CAMPO QUEDE VACIO Y QUE LAS DOS CONTRASEÑAS COINCIDAN