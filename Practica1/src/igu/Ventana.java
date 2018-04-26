package igu;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Ventana extends JFrame {
	
	private JPanel panelPrincipal;
	private JButton btAceptar;
	private JLabel texto;
	private JTextField cuadro;

	public Ventana() {
		setBounds(100, 100, 450, 300);
		setTitle("Ventana de ejemplo");
		setLocationRelativeTo(null);
		
		panelPrincipal = new JPanel();
		setContentPane(panelPrincipal);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setLayout(null);
		
		btAceptar = new JButton();
		btAceptar.setBounds(170, 220, 100, 30);
		btAceptar.setText("Aceptar");
		
		texto = new JLabel();
		texto.setText("Introduzca su nombre: ");
		texto.setBounds(100, 100, 100, 100);
		panelPrincipal.add(texto);
		
		cuadro = new JTextField();
		cuadro.setText("");
		cuadro.setBounds(100, 100, 200, 200);
		panelPrincipal.add(cuadro);
		
		
		panelPrincipal.add(btAceptar);
	}

	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}

}
