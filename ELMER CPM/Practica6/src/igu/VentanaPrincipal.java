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
	private JTextField txtScoreLiebre;
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
	private JPanel panelTortuga;
	private JButton bt00;
	private JButton bt11;
	private JButton bt22;
	private JButton bt33;
	private JButton bt44;
	private JButton bt55;
	private JButton bt66;
	private JButton bt77;
	private JButton bt88;
	private JButton bt99;
	private JButton bt100;
	private JTextField txtScoreTortuga;
	private JLabel lblLiebre;
	private JLabel lblTortuga;

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
		setBounds(100, 100, 965, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDado());
		contentPane.add(getLbDado());
		contentPane.add(getLblScore());
		contentPane.add(getTxtScoreLiebre());
		contentPane.add(getPanelLiebre());
		contentPane.add(getPanelTortuga());
		contentPane.add(getTxtScoreTortuga());
		contentPane.add(getLblLiebre());
		contentPane.add(getLblTortuga());
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
			lblScore.setLabelFor(getTxtScoreLiebre());
			lblScore.setForeground(Color.YELLOW);
			lblScore.setFont(new Font("Eras Bold ITC", Font.PLAIN, 35));
			lblScore.setBounds(497, 57, 129, 61);
		}
		return lblScore;
	}
	private JTextField getTxtScoreLiebre() {
		if (txtScoreLiebre == null) {
			txtScoreLiebre = new JTextField();
			txtScoreLiebre.setEditable(false);
			txtScoreLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			txtScoreLiebre.setFont(new Font("Tahoma", Font.PLAIN, 50));
			txtScoreLiebre.setForeground(Color.MAGENTA);
			txtScoreLiebre.setBackground(Color.BLACK);
			txtScoreLiebre.setBounds(715, 38, 171, 51);
			txtScoreLiebre.setColumns(10);
		}
		return txtScoreLiebre;
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
	private JButton getBt10() {
		if (bt10 == null) {
			bt10 = new JButton("");
			bt10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(10);
				}
			});
			bt10.setForeground(Color.WHITE);
			bt10.setBackground(Color.BLACK);
		}
		return bt10;
	}
	
	private JPanel getPanelTortuga() {
		if (panelTortuga == null) {
			panelTortuga = new JPanel();
			panelTortuga.setForeground(Color.BLACK);
			panelTortuga.setBorder(new LineBorder(Color.BLUE));
			panelTortuga.setBackground(Color.BLUE);
			panelTortuga.setBounds(53, 262, 833, 81);
			panelTortuga.setLayout(new GridLayout(1, 11, 2, 0));
			panelTortuga.add(getBt00());
			panelTortuga.add(getBt11());
			panelTortuga.add(getBt22());
			panelTortuga.add(getBt33());
			panelTortuga.add(getBt44());
			panelTortuga.add(getBt55());
			panelTortuga.add(getBt66());
			panelTortuga.add(getBt77());
			panelTortuga.add(getBt88());
			panelTortuga.add(getBt99());
			panelTortuga.add(getBt100());
		}
		return panelTortuga;
	}
	private JButton getBt00() {
		if (bt00 == null) {
			bt00 = new JButton("");
			bt00.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(0);
				}
			});
			bt00.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			bt00.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			bt00.setForeground(Color.BLACK);
			bt00.setBackground(Color.BLACK);
		}
		return bt00;
	}
	private JButton getBt11() {
		if (bt11 == null) {
			bt11 = new JButton("");
			bt11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(1);
				}
			});
			bt11.setForeground(Color.WHITE);
			bt11.setBackground(Color.BLACK);
		}
		return bt11;
	}
	private JButton getBt22() {
		if (bt22 == null) {
			bt22 = new JButton("");
			bt22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(2);
				}
			});
			bt22.setForeground(Color.WHITE);
			bt22.setBackground(Color.BLACK);
		}
		return bt22;
	}
	private JButton getBt33() {
		if (bt33 == null) {
			bt33 = new JButton("");
			bt33.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(3);
				}
			});
			bt33.setForeground(Color.WHITE);
			bt33.setBackground(Color.BLACK);
		}
		return bt33;
	}
	private JButton getBt44() {
		if (bt44 == null) {
			bt44 = new JButton("");
			bt44.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(4);
				}
			});
			bt44.setForeground(Color.WHITE);
			bt44.setBackground(Color.BLACK);
		}
		return bt44;
	}
	private JButton getBt55() {
		if (bt55 == null) {
			bt55 = new JButton("");
			bt55.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(5);
				}
			});
			bt55.setForeground(Color.WHITE);
			bt55.setBackground(Color.BLACK);
		}
		return bt55;
	}
	private JButton getBt66() {
		if (bt66 == null) {
			bt66 = new JButton("");
			bt66.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(6);
				}
			});
			bt66.setForeground(Color.WHITE);
			bt66.setBackground(Color.BLACK);
		}
		return bt66;
	}
	private JButton getBt77() {
		if (bt77 == null) {
			bt77 = new JButton("");
			bt77.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(7);
				}
			});
			bt77.setForeground(Color.WHITE);
			bt77.setBackground(Color.BLACK);
		}
		return bt77;
	}
	private JButton getBt88() {
		if (bt88 == null) {
			bt88 = new JButton("");
			bt88.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(8);
				}
			});
			bt88.setForeground(Color.WHITE);
			bt88.setBackground(Color.BLACK);
		}
		return bt88;
	}
	private JButton getBt99() {
		if (bt99 == null) {
			bt99 = new JButton("");
			bt99.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(9);
				}
			});
			bt99.setForeground(Color.WHITE);
			bt99.setBackground(Color.BLACK);
		}
		return bt99;
	}
	private JButton getBt100() {
		if (bt100 == null) {
			bt100 = new JButton("");
			bt100.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(10);
				}
			});
			bt100.setForeground(Color.WHITE);
			bt100.setBackground(Color.BLACK);
		}
		return bt100;
	}
	
	private JTextField getTxtScoreTortuga() {
		if (txtScoreTortuga == null) {
			txtScoreTortuga = new JTextField();
			txtScoreTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			txtScoreTortuga.setForeground(Color.MAGENTA);
			txtScoreTortuga.setFont(new Font("Tahoma", Font.PLAIN, 50));
			txtScoreTortuga.setEditable(false);
			txtScoreTortuga.setColumns(10);
			txtScoreTortuga.setBackground(Color.BLACK);
			txtScoreTortuga.setBounds(715, 87, 171, 51);
		}
		return txtScoreTortuga;
	}
	private JLabel getLblLiebre() {
		if (lblLiebre == null) {
			lblLiebre = new JLabel("");
			lblLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			lblLiebre.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
			lblLiebre.setBorder(new LineBorder(Color.WHITE));
			lblLiebre.setBounds(659, 38, 57, 51);
		}
		return lblLiebre;
	}
	private JLabel getLblTortuga() {
		if (lblTortuga == null) {
			lblTortuga = new JLabel("");
			lblTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			lblTortuga.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga_peq.JPG")));
			lblTortuga.setBorder(new LineBorder(Color.WHITE));
			lblTortuga.setBounds(659, 87, 57, 51);
		}
		return lblTortuga;
	}
	
	private void lanzarDado(){
		boolean jugadaPosible = carrera.lanzarDado();
		lbDado.setText(String.valueOf(Dado.getValor()));
		if(jugadaPosible){
			habilitarPanel();
			deshabilitarPanel();
			btnDado.setEnabled(false);
		}else{
			JOptionPane.showMessageDialog(this, "La jugada no es posible.");
			deshabilitarPanel();			
			lbDado.setText("");
		}
		
	}
	
	private void modificarPanel(JPanel panel, boolean habilitar){
		for (Component comp : panel.getComponents()){
			comp.setEnabled(habilitar);
		}
		
	}
	private void deshabilitarPanel() {
		if(carrera.getCorredorActivo() == carrera.getTortuga()){
			modificarPanel(panelLiebre, false);
		}
		if(carrera.getCorredorActivo() == carrera.getLiebre()){
			modificarPanel(panelTortuga, false);
		}
		
		
	}
	private void habilitarPanel() {
		if(carrera.getCorredorActivo() == carrera.getLiebre()){
			modificarPanel(panelLiebre, true);
		}
		if(carrera.getCorredorActivo() == carrera.getTortuga()){
			modificarPanel(panelTortuga, true);
		}
		
		
	}
	
	private void jugar(int i) {
		if (carrera.resolverJugada(i)){
			representarEstadoJuego();
			deshabilitarPanel();
		}
		
	}

	private void representarEstadoJuego() {
		lbDado.setText("");
		pintarCorredor();
		pintarPuntos();
		
		if(carrera.isPartidaFinalizada()){
			JOptionPane.showMessageDialog(this, "Partida finalizada");
			if(carrera.getCorredorActivo().getPosicion() == carrera.getTrapPos() && carrera.getCorredorActivo().isTrap()){
					JOptionPane.showMessageDialog(this, "Ha caido en una trampa");
					if(carrera.getCorredorActivo() == carrera.getLiebre()){
						txtScoreTortuga.setText("0");
					}else{
						txtScoreLiebre.setText("0");
					}
				}
			
		}else{
			btnDado.setEnabled(true);
		}
		
	}
	private void pintarPuntos() {
		
			if(carrera.getCorredorActivo() == carrera.getTortuga()){
				txtScoreLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));}
			if(carrera.getCorredorActivo() == carrera.getLiebre()){
				txtScoreTortuga.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
			}
		
	}
	private void pintarCorredor() {	
		pintarCalle(carrera.getLiebre(),panelLiebre.getComponents());
		pintarCalle(carrera.getTortuga(),panelTortuga.getComponents());

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
		if(corredor.getNombre() == "liebre"){
			((JButton)botones[carrera.getTreePos()]).setIcon(new ImageIcon(getClass().getResource("/img/arbol.JPG")));
			((JButton)botones[carrera.getTreePos()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/arbol.JPG")));
			if(carrera.getLiebre().getPosicion() == carrera.getTreePos()){
				((JButton)botones[carrera.getTreePos()]).setIcon(new ImageIcon(getClass().getResource("/img/liebre_durmiendo.JPG")));
				((JButton)botones[carrera.getTreePos()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/liebre_durmiendo.JPG")));
			}
		}
		
	}
	
}

