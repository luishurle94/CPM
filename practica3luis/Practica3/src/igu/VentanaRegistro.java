package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class VentanaRegistro extends JDialog {
	
	private VentanaPrincipal vp;

	private JPanel pnPrincipal;
	private JTextField txNombre;
	private JTextField txApellidos;
	private JButton btSiguiente;
	private JButton btCancelar;
	private JPanel pnSexo;
	private JRadioButton rbMujer;
	private JRadioButton rdHombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pnNacimiento;
	private JComboBox<String> cbDia;
	private JComboBox<String> cbMes;
	private JComboBox<String> cbAño;
	private JPanel pnDatosRegistro;
	private JLabel lbUsuario;
	private JLabel lbPassword;
	private JLabel lbPassword2;
	private JTextField txUsuario;
	private JPasswordField psPassword2;
	private JPasswordField psPassword;
	private JLabel lbPrecio;
	private JLabel lbPrecioTotal;

	public VentanaRegistro(VentanaPrincipal vp) {
		
		this.vp = vp;
		
		setTitle("Formulario de Registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 505);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.PINK);
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNombre.setBounds(44, 62, 86, 36);
		pnPrincipal.add(lblNombre);
		
		txNombre = new JTextField();
		txNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txNombre.setBounds(106, 63, 150, 33);
		pnPrincipal.add(txNombre);
		txNombre.setColumns(10);
		
		JLabel lbApellidos = new JLabel("Apellidos:");
		lbApellidos.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbApellidos.setBounds(325, 63, 86, 30);
		pnPrincipal.add(lbApellidos);
		
		txApellidos = new JTextField();
		txApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txApellidos.setBounds(395, 61, 178, 33);
		pnPrincipal.add(txApellidos);
		txApellidos.setColumns(10);
		
		btSiguiente = new JButton("Siguiente");
		btSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comprobarVacios()) {
					if (comprobarContraseña()) {
						JOptionPane.showMessageDialog(null, "Datos correctos");
						mostrarVentanaConfirmacion();
					} else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos");
				}
				
				vp.getPedido().grabarPedido("Hola");
			}

		});
		btSiguiente.setBounds(451, 410, 89, 23);
		pnPrincipal.add(btSiguiente);
		
		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btCancelar.setBounds(567, 410, 89, 23);
		pnPrincipal.add(btCancelar);
		pnPrincipal.add(getPnSexo());
		pnPrincipal.add(getPnNacimiento());
		pnPrincipal.add(getPnDatosRegistro());
		pnPrincipal.add(getLbPrecio());
		pnPrincipal.add(getLbPrecioTotal());
	}
	private JPanel getPnSexo() {
		if (pnSexo == null) {
			pnSexo = new JPanel();
			pnSexo.setBackground(Color.LIGHT_GRAY);
			pnSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnSexo.setToolTipText("");
			pnSexo.setName("");
			pnSexo.setBounds(44, 133, 218, 70);
			pnSexo.setLayout(null);
			pnSexo.add(getRdHombre());
			pnSexo.add(getRbMujer());
		}
		return pnSexo;
	}
	private JRadioButton getRbMujer() {
		if (rbMujer == null) {
			rbMujer = new JRadioButton("Mujer");
			buttonGroup.add(rbMujer);
			rbMujer.setBackground(Color.LIGHT_GRAY);
			rbMujer.setBounds(115, 27, 77, 23);
		}
		return rbMujer;
	}
	private JRadioButton getRdHombre() {
		if (rdHombre == null) {
			rdHombre = new JRadioButton("Hombre");
			rdHombre.setSelected(true);
			buttonGroup.add(rdHombre);
			rdHombre.setBackground(Color.LIGHT_GRAY);
			rdHombre.setBounds(36, 27, 77, 23);
		}
		return rdHombre;
	}
	private JPanel getPnNacimiento() {
		if (pnNacimiento == null) {
			pnNacimiento = new JPanel();
			pnNacimiento.setBackground(Color.LIGHT_GRAY);
			pnNacimiento.setBorder(new TitledBorder(null, "Fecha de Nacimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnNacimiento.setBounds(302, 133, 326, 70);
			pnNacimiento.setLayout(null);
			pnNacimiento.add(getCbDia());
			pnNacimiento.add(getCbMes());
			pnNacimiento.add(getCbAño());
		}
		return pnNacimiento;
	}
	private JComboBox<String> getCbDia() {
		if (cbDia == null) {
			cbDia = new JComboBox<String>();
			//ArrayList<String> dias = new ArrayList<>();
			String[] dias = new String[31];
			for(int i=0; i<31; i++) {
				dias[i] = String.valueOf(i+1);
				//dias.add(String.valueOf(i+1));
			}
			cbDia.setModel(new DefaultComboBoxModel<String>(dias));
			cbDia.setBounds(25, 35, 44, 20);
		}
		return cbDia;
	}
	private JComboBox<String> getCbMes() {
		if (cbMes == null) {
			cbMes = new JComboBox<String>();
			cbMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo ", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
			cbMes.setBounds(105, 35, 88, 20);
		}
		return cbMes;
	}
	private JComboBox<String> getCbAño() {
		if (cbAño == null) {
			cbAño = new JComboBox<String>();
			String[] anios = new String[51];
			for(int i=0; i<51; i++) {
				anios[i] = String.valueOf(i+1950);
				
			}
			cbAño.setModel(new DefaultComboBoxModel<String>(anios));
			cbAño.setBounds(226, 35, 74, 20);
		}
		return cbAño;
	}
	private JPanel getPnDatosRegistro() {
		if (pnDatosRegistro == null) {
			pnDatosRegistro = new JPanel();
			pnDatosRegistro.setLayout(null);
			pnDatosRegistro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Registro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnDatosRegistro.setBackground(Color.LIGHT_GRAY);
			pnDatosRegistro.setBounds(44, 236, 408, 123);
			pnDatosRegistro.add(getLbUsuario());
			pnDatosRegistro.add(getLbPassword());
			pnDatosRegistro.add(getLbPassword2());
			pnDatosRegistro.add(getTxUsuario());
			pnDatosRegistro.add(getPsPassword2());
			pnDatosRegistro.add(getPsPassword());
		}
		return pnDatosRegistro;
	}
	private JLabel getLbUsuario() {
		if (lbUsuario == null) {
			lbUsuario = new JLabel("Usuario (email)");
			lbUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lbUsuario.setBounds(10, 28, 90, 14);
		}
		return lbUsuario;
	}
	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Password: ");
			lbPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lbPassword.setBounds(10, 53, 90, 14);
		}
		return lbPassword;
	}
	private JLabel getLbPassword2() {
		if (lbPassword2 == null) {
			lbPassword2 = new JLabel("Reintroduzca password: ");
			lbPassword2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lbPassword2.setBounds(10, 78, 167, 14);
		}
		return lbPassword2;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setColumns(10);
			txUsuario.setBounds(211, 22, 174, 20);
		}
		return txUsuario;
	}
	private JPasswordField getPsPassword2() {
		if (psPassword2 == null) {
			psPassword2 = new JPasswordField();
			psPassword2.setBounds(211, 75, 174, 20);
		}
		return psPassword2;
	}
	private JPasswordField getPsPassword() {
		if (psPassword == null) {
			psPassword = new JPasswordField();
			psPassword.setBounds(211, 50, 174, 20);
		}
		return psPassword;
	}
	
	public boolean comprobarVacios() {
		//Si falla alguna de las condiciones muestro esto
		
		if(txApellidos.getText().equals("") || txNombre.getText().equals("") || txUsuario.getText().equals("") || psPassword.getText().equals("") || psPassword2.getText().equals("")) {
			
			return false;
		} 
		else{
			//JOptionPane.showMessageDialog(null, "Datos correctos");
			return true;
		}
	}
	
	public boolean comprobarContraseña() {

		/*
		 * if(psPassword.getText().equals(psPassword2.getText()) &&
		 * !psPassword.getText().equals("")) {
		 * JOptionPane.showMessageDialog(null, "Contraseña correcta"); } else {
		 * JOptionPane.showMessageDialog(null, "Contraseña incorrecta"); }
		 */

		char[] p1 = psPassword.getPassword();
		char[] p2 = psPassword2.getPassword();

		if (p1.length != p2.length) {
			return false;
		} else {
			boolean iguales = true;
			for (int i = 0; i < p1.length; i++) {
				if (p1[i] != p2[i]) {
					iguales = false;
				}

			}

			if (p1.length == 0) {
				iguales = false;
			}

			return iguales;

		}
	}
	
	private void mostrarVentanaConfirmacion() {
		
		VentanaConfirmacion vc = new VentanaConfirmacion(vp);
		vc.setLocationRelativeTo(this);
		vc.setModal(true);
		vc.setVisible(true);
		
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio total:");
			lbPrecio.setFont(new Font("Times New Roman", Font.BOLD, 21));
			lbPrecio.setBounds(535, 301, 93, 33);
			lbPrecio.setText(String.valueOf(vp.getPedido().calcularTotalSinIva()));
		}
		return lbPrecio;
	}
	private JLabel getLbPrecioTotal() {
		if (lbPrecioTotal == null) {
			lbPrecioTotal = new JLabel("Precio Total");
			lbPrecioTotal.setFont(new Font("Times New Roman", Font.BOLD, 21));
			lbPrecioTotal.setBounds(505, 267, 165, 23);
		}
		return lbPrecioTotal;
	}
}
