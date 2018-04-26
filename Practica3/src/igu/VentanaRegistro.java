package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaRegistro frame = new VentanaRegistro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Ventana de Registro\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JComboBox<String> comboMes = new JComboBox<String>();
		comboMes.setModel(new DefaultComboBoxModel<String>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo ",
				"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		comboMes.setBounds(66, 21, 134, 20);
		panelFechaNacimiento.add(comboMes);

		
		String [] años = new String[97];
		for(int i = 0; i<97; i++)
		{
			años[i] = String.valueOf(i+1920);
		}
		JComboBox<String> comboAño = new JComboBox<String>();
		comboAño.setModel(new DefaultComboBoxModel<String>(años));
		comboAño.setToolTipText("");
		comboAño.setBounds(210, 21, 70, 20);
		panelFechaNacimiento.add(comboAño);

		
		String [] dias = new String[31];
		for(int i = 0; i<31; i++)
		{
			dias[i] = String.valueOf(i+1);
		}
		JComboBox<String> comboDia = new JComboBox<String>();
		comboDia.setModel(new DefaultComboBoxModel<String>(dias));
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