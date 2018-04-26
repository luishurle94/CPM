/**
 * 
 */
package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import logica.Calle;
import logica.Carrera;
import logica.Corredor;
import logica.Dado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Alumno
 *
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Carrera carrera;
	private JPanel contentPane;
	private JButton btnDado;
	private JLabel lbDado;
	private JLabel lblScore;
	private JTextField txtScore;
	private JPanel panelLiebre;
	private JButton bt9;
	private JButton bt8;
	private JButton bt7;
	private JButton bt6;
	private JButton bt5;
	private JButton bt3;
	private JButton bt2;
	private JButton bt1;
	private JButton bt0;
	private JButton bt4;
	private JButton bt10;

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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		this.carrera = new Carrera();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setTitle("El Juego de la Liebre y la Zanahoria");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 345);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDado());
		contentPane.add(getLbDado());
		contentPane.add(getLblScore());
		contentPane.add(getTxtScore());
		contentPane.add(getPanelLiebre());
		deshabilitarPanel();
		
	}
	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lanzarDado();
				}
			});
			btnDado.setFocusPainted(false);
			btnDado.setContentAreaFilled(false);
			btnDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setBorderPainted(false);
			btnDado.setForeground(Color.WHITE);
			btnDado.setBackground(Color.WHITE);
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setBounds(53, 57, 75, 81);
		}
		return btnDado;
	}
	private JLabel getLbDado() {
		if (lbDado == null) {
			lbDado = new JLabel("");
			lbDado.setFont(new Font("Tahoma", Font.PLAIN, 55));
			lbDado.setForeground(Color.GREEN);
			lbDado.setBackground(Color.BLACK);
			lbDado.setBounds(151, 53, 48, 61);
		}
		return lbDado;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("SCORE");
			lblScore.setLabelFor(getTxtScore());
			lblScore.setForeground(Color.YELLOW);
			lblScore.setFont(new Font("Jokerman", Font.PLAIN, 35));
			lblScore.setBounds(576, 57, 129, 61);
		}
		return lblScore;
	}
	private JTextField getTxtScore() {
		if (txtScore == null) {
			txtScore = new JTextField();
			txtScore.setEditable(false);
			txtScore.setHorizontalAlignment(SwingConstants.CENTER);
			txtScore.setFont(new Font("Tahoma", Font.PLAIN, 50));
			txtScore.setForeground(Color.MAGENTA);
			txtScore.setBackground(Color.BLACK);
			txtScore.setBounds(715, 57, 171, 61);
			txtScore.setColumns(10);
		}
		return txtScore;
	}
	private JPanel getPanelLiebre() {
		if (panelLiebre == null) {
			panelLiebre = new JPanel();
			panelLiebre.setBorder(new LineBorder(Color.BLUE));
			panelLiebre.setForeground(Color.BLACK);
			panelLiebre.setBackground(Color.BLUE);
			panelLiebre.setBounds(53, 170, 833, 81);
			panelLiebre.setLayout(new GridLayout(1, 11, 2, 0));
			panelLiebre.add(getBt0());
			panelLiebre.add(getBt1());
			panelLiebre.add(getBt2());
			panelLiebre.add(getBt3());
			panelLiebre.add(getBt4());
			panelLiebre.add(getBt5());
			panelLiebre.add(getBt6());
			panelLiebre.add(getBt7());
			panelLiebre.add(getBt8());
			panelLiebre.add(getBt9());
			panelLiebre.add(getBt10());
		}
		return panelLiebre;
	}
	private JButton getBt9() {
		if (bt9 == null) {
			bt9 = new JButton("");
			bt9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(9);
				}
			});
			bt9.setForeground(Color.WHITE);
			bt9.setBackground(Color.BLACK);
		}
		return bt9;
	}
	private JButton getBt8() {
		if (bt8 == null) {
			bt8 = new JButton("");
			bt8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(8);
				}
			});
			bt8.setForeground(Color.WHITE);
			bt8.setBackground(Color.BLACK);
		}
		return bt8;
	}
	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton("");
			bt7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(7);
				}
			});
			bt7.setForeground(Color.WHITE);
			bt7.setBackground(Color.BLACK);
		}
		return bt7;
	}
	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("");
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(6);
				}
			});
			bt6.setForeground(Color.WHITE);
			bt6.setBackground(Color.BLACK);
		}
		return bt6;
	}
	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("");
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(5);
				}
			});
			bt5.setForeground(Color.WHITE);
			bt5.setBackground(Color.BLACK);
		}
		return bt5;
	}
	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("");
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(3);
				}
			});
			bt3.setForeground(Color.WHITE);
			bt3.setBackground(Color.BLACK);
		}
		return bt3;
	}
	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("");
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(2);
				}
			});
			bt2.setForeground(Color.WHITE);
			bt2.setBackground(Color.BLACK);
		}
		return bt2;
	}
	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(1);
				}
			});
			bt1.setForeground(Color.WHITE);
			bt1.setBackground(Color.BLACK);
		}
		return bt1;
	}
	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("");
			bt0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			bt0.setForeground(Color.BLACK);
			bt0.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			bt0.setBackground(Color.BLACK);
		}
		return bt0;
	}
	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("");
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(4);
				}
			});
			bt4.setForeground(Color.WHITE);
			bt4.setBackground(Color.BLACK);
		}
		return bt4;
	}
	private JButton getBt10() {
		if (bt10 == null) {
			bt10 = new JButton("");
			bt10.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
			bt10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(10);
				}
			});
			bt10.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
			bt10.setForeground(Color.WHITE);
			bt10.setBackground(Color.BLACK);
		}
		return bt10;
	}
	
	private void lanzarDado(){
		boolean jugadaPosible = carrera.lanzarDado();
		lbDado.setText(String.valueOf(Dado.getValor()));
		if(jugadaPosible){
			habilitarPanel();
			btnDado.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(this, "La jugada no es posible.");
			deshabilitarPanel();
			lbDado.setToolTipText("");
		}
		
	}
	
	private void modificarPanel(JPanel panel, boolean habilitar){
		for (Component comp : panel.getComponents()){
			comp.setEnabled(habilitar);
		}
		
	}

	private void deshabilitarPanel() {
		modificarPanel(panelLiebre, false);
		
	}

	private void habilitarPanel() {
		modificarPanel(panelLiebre, true);
		
	}
	private void jugar(int i) {
		if (carrera.resolverJugada(i)){
			representarEstadoJuego();
			deshabilitarPanel();
		}
		
	}

	private void representarEstadoJuego() {
		lbDado.setText("");
		pintarPuntos();
		pintarCorredor();
		if(carrera.getLiebre().getPosicion() == carrera.getSuperPowerPos()){
			JOptionPane.showMessageDialog(this, "Has recibido un Super Poder! Recibes 500 pts extra");
		}
		if(carrera.getLiebre().getPosicion() == carrera.getTrapPos()){
			if(!carrera.getLiebre().isSP()){
				JOptionPane.showMessageDialog(this, "Ha caido en una trampa");	
				txtScore.setText("0");
			}
			else{
				JOptionPane.showMessageDialog(this, "Ha caido en una trampa, pero consigues librarte de ella gracias a tu super poder. 1000pts Extra!!");
			}
		}
		if(carrera.isPartidaFinalizada()){
			JOptionPane.showMessageDialog(this, "Partida finalizada");
		}else{
			btnDado.setEnabled(true);
		}
		
	}
	private void pintarPuntos() {
		if(carrera.isPartidaFinalizada()){
			txtScore.setText(String.valueOf(carrera.getLiebre().getPuntuacion()+200));
		}else{
		txtScore.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));}
	}
	private void pintarCorredor() {	
		pintarCalle(carrera.getLiebre(),panelLiebre.getComponents());
	}
	private void pintarCalle(Corredor corredor, Component[] botones) {
		ImageIcon imagen = new ImageIcon(getClass().getResource("/img/" + corredor.getFoto()));
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
		((JButton)botones[carrera.getTrapPos()]).setBackground(Color.RED);
		((JButton)botones[carrera.getSuperPowerPos()]).setBackground(Color.GREEN);
		((JButton)botones[botones.length-1]).setIcon(new ImageIcon(getClass().getResource("/img/zanahoria.jpg")));
		((JButton)botones[botones.length-1]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/zanahoria.jpg")));
		if(carrera.getLiebre().getPosicion() == Calle.POSICION_META){
			((JButton)botones[botones.length-1]).setIcon(new ImageIcon(getClass().getResource("/img/liebre - comiendo.JPG")));
			((JButton)botones[botones.length-1]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/liebre - comiendo.JPG")));
		}
		
		
	}
	
	
}

