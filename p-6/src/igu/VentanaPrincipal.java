package igu;

import logica.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel panelPrincipal;
	private JButton btDado;
	private JTextField txDado;
	private JLabel lbScore;
	private JLabel lbPuntosLiebre;
	private JPanel pnLiebre;
	private JButton btn10;
	private JButton btn0;
	private JButton btn9;
	private JButton btn8;
	private JButton btn7;
	private JButton btn6;
	private JButton btn1;
	private JButton btn2;
	private JButton btn5;
	private JButton btn4;
	private JButton btn3;
	private Carrera carrera;
	private JPanel pnTortuga;
	private JButton bt0;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;
	private JButton bt10;
	private JLabel lblPuntosTortuga;
	private JLabel lblLiebrePeque;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Carrera carrera = new Carrera();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(carrera);
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
	public VentanaPrincipal(Carrera c) {
		carrera = c;
		setResizable(false);
		setTitle("El juego de la liebre y la tortuga");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 375);
		panelPrincipal = new JPanel();
		panelPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 36));
		panelPrincipal.setForeground(Color.MAGENTA);
		panelPrincipal.setBackground(Color.BLACK);
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.add(getBtDado());
		panelPrincipal.add(getTxDado());
		panelPrincipal.add(getLbScore());
		panelPrincipal.add(getLabel_1());
		panelPrincipal.add(getPnLiebre());
		panelPrincipal.add(getPnTortuga());
		panelPrincipal.add(getLblPuntosTortuga());
		panelPrincipal.add(getLabel_1_1());
		panelPrincipal.add(getLabel());
		setLocationRelativeTo(null);
		deshabilitarPanel();
	}

	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton("");
			btDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzarDado();
				}

			});
			btDado.setToolTipText("Haga clic para lanzar el dado");
			btDado.setBorder(null);
			btDado.setBorderPainted(false);
			btDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btDado.setBounds(25, 13, 69, 85);
		}
		return btDado;
	}

	private void lanzarDado() {
		boolean posibleJugada = carrera.lanzarDado();
		txDado.setText(String.valueOf(Dado.getValor()));
		if (posibleJugada) {
			habilitarPanelCorredorActivo();
			btDado.setEnabled(false);
		} else {
			mostrarMensajeJuego();

			btDado.setEnabled(true);
			deshabilitarPanel();
		}
	}

	private void mostrarMensajeJuego() {
		JOptionPane.showMessageDialog(this, "La jugada no es posible. Se cambia de turno.");
		txDado.setText("");
	}

	private JTextField getTxDado() {
		if (txDado == null) {
			txDado = new JTextField();
			txDado.setBorder(null);
			txDado.setHorizontalAlignment(SwingConstants.CENTER);
			txDado.setText("0");
			txDado.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 60));
			txDado.setForeground(Color.GREEN);
			txDado.setBackground(Color.BLACK);
			txDado.setEditable(false);
			txDado.setBounds(151, 13, 102, 85);
			txDado.setColumns(10);
		}
		return txDado;
	}

	private JLabel getLbScore() {
		if (lbScore == null) {
			lbScore = new JLabel("Score:");
			lbScore.setHorizontalAlignment(SwingConstants.CENTER);
			lbScore.setForeground(Color.YELLOW);
			lbScore.setFont(new Font("Jokerman", Font.PLAIN, 50));
			lbScore.setBackground(Color.BLACK);
			lbScore.setBounds(265, 13, 196, 85);
		}
		return lbScore;
	}

	private JLabel getLabel_1() {
		if (lbPuntosLiebre == null) {
			lbPuntosLiebre = new JLabel("0");
			lbPuntosLiebre.setBorder(new LineBorder(Color.WHITE));
			lbPuntosLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			lbPuntosLiebre.setForeground(Color.MAGENTA);
			lbPuntosLiebre.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lbPuntosLiebre.setBackground(Color.BLACK);
			lbPuntosLiebre.setBounds(548, 25, 167, 32);
		}
		return lbPuntosLiebre;
	}

	private JPanel getPnLiebre() {
		if (pnLiebre == null) {
			pnLiebre = new JPanel();
			pnLiebre.setBackground(Color.BLUE);
			pnLiebre.setBorder(new LineBorder(Color.BLUE, 10));
			pnLiebre.setBounds(25, 129, 690, 85);
			pnLiebre.setLayout(new GridLayout(1, 11, 2, 0));
			pnLiebre.add(getBtn0());
			pnLiebre.add(getBtn1());
			pnLiebre.add(getBtn2());
			pnLiebre.add(getBtn3());
			pnLiebre.add(getBtn4());
			pnLiebre.add(getBtn5());
			pnLiebre.add(getBtn6());
			pnLiebre.add(getBtn7());
			pnLiebre.add(getBtn8());
			pnLiebre.add(getBtn9());
			pnLiebre.add(getBtn10());
		}
		return pnLiebre;
	}

	private JButton getBtn10() {
		if (btn10 == null) {
			btn10 = new JButton("");
			btn10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(10);
				}
			});
			btn10.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
			btn10.setForeground(Color.BLACK);
			btn10.setBackground(Color.BLACK);
		}
		return btn10;
	}

	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton("");
			btn0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btn0.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btn0.setForeground(Color.BLACK);
			btn0.setBackground(Color.BLACK);
		}
		return btn0;
	}

	private JButton getBtn9() {
		if (btn9 == null) {
			btn9 = new JButton("");
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(9);
				}
			});
			btn9.setForeground(Color.BLACK);
			btn9.setBackground(Color.BLACK);
		}
		return btn9;
	}

	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton("");
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(8);
				}
			});
			btn8.setForeground(Color.BLACK);
			btn8.setBackground(Color.BLACK);
		}
		return btn8;
	}

	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton("");
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(7);
				}
			});
			btn7.setForeground(Color.BLACK);
			btn7.setBackground(Color.BLACK);
		}
		return btn7;
	}

	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton("");
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(6);
				}
			});
			btn6.setForeground(Color.BLACK);
			btn6.setBackground(Color.BLACK);
		}
		return btn6;
	}

	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(1);
				}
			});
			btn1.setForeground(Color.BLACK);
			btn1.setBackground(Color.BLACK);
		}
		return btn1;
	}

	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(2);
				}
			});
			btn2.setForeground(Color.BLACK);
			btn2.setBackground(Color.BLACK);
		}
		return btn2;
	}

	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton("");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(5);
				}
			});
			btn5.setForeground(Color.BLACK);
			btn5.setBackground(Color.BLACK);
		}
		return btn5;
	}

	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(4);
				}
			});
			btn4.setForeground(Color.BLACK);
			btn4.setBackground(Color.BLACK);
		}
		return btn4;
	}

	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(3);
				}
			});
			btn3.setForeground(Color.BLACK);
			btn3.setBackground(Color.BLACK);
		}
		return btn3;
	}

	private void modificarPanel(JPanel panel, boolean habilitado) {
		for (Component componente : panel.getComponents()) {
			componente.setEnabled(habilitado);
		}
	}

	private void habilitarPanelCorredorActivo() {
		if (carrera.getCorredorActivo().equals(carrera.getLiebre()))
			modificarPanel(pnLiebre, true);
		modificarPanel(pnTortuga, true);

	}

	private void deshabilitarPanel() {
		modificarPanel(pnLiebre, false);
		modificarPanel(pnTortuga, false);
	}

	private void jugar(int posicion) {
		if (carrera.resolverJugada(posicion)) {
			representarEstadoJuego();
			deshabilitarPanel();
		}
	}

	private void representarEstadoJuego() {
		txDado.setText("");
		pintarPuntos();
		pintarCorredor();
		if(carrera.isPartidaFinalizada()){
			JOptionPane.showMessageDialog(this, "Partida finalizada.");
			if(carrera.getCorredorActivo().getPosicion() == carrera.getPosTrampa() && carrera.getCorredorActivo().isTrampa()){
				JOptionPane.showMessageDialog(this, "Ha caido en una trampa");
				if(carrera.getCorredorActivo() == carrera.getLiebre()){
					lblPuntosTortuga.setText("0");
				}else{
					lbPuntosLiebre.setText("0");
				}
			
		
			}else
			btDado.setEnabled(true);
	}
	}
	private void pintarCorredor() {
		pintarCalle(carrera.getLiebre(), pnLiebre.getComponents());
		pintarCalle(carrera.getTortuga(), pnTortuga.getComponents());
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
			((JButton)botones[carrera.getPosArbol()]).setIcon(new ImageIcon(getClass().getResource("/img/arbol.JPG")));
			((JButton)botones[carrera.getPosArbol()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/arbol.JPG")));
			if(carrera.getLiebre().getPosicion() == carrera.getPosArbol()){
				((JButton)botones[carrera.getPosArbol()]).setIcon(new ImageIcon(getClass().getResource("/img/liebre_durmiendo.JPG")));
				((JButton)botones[carrera.getPosArbol()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/liebre_durmiendo.JPG")));
			}
		}
	}

	private void pintarPuntos() {
		lbPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		lblPuntosTortuga.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
	}

	private JPanel getPnTortuga() {
		if (pnTortuga == null) {
			pnTortuga = new JPanel();
			pnTortuga.setBorder(new LineBorder(Color.BLUE, 10));
			pnTortuga.setBackground(Color.BLUE);
			pnTortuga.setBounds(25, 227, 690, 85);
			pnTortuga.setLayout(new GridLayout(1, 11, 2, 0));
			pnTortuga.add(getBt0());
			pnTortuga.add(getBt1());
			pnTortuga.add(getBt2());
			pnTortuga.add(getBt3());
			pnTortuga.add(getBt4());
			pnTortuga.add(getBt5());
			pnTortuga.add(getBt6());
			pnTortuga.add(getBt7());
			pnTortuga.add(getBt8());
			pnTortuga.add(getBt9());
			pnTortuga.add(getBt10());
		}
		return pnTortuga;
	}

	private JButton getBt0() {
		if (bt0 == null) {
			bt0 = new JButton("");
			bt0.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			bt0.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			bt0.setForeground(Color.BLACK);
			bt0.setBackground(Color.BLACK);
		}
		return bt0;
	}

	private JButton getBt1() {
		if (bt1 == null) {
			bt1 = new JButton("");
			bt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(1);
				}
			});
			bt1.setForeground(Color.BLACK);
			bt1.setBackground(Color.BLACK);
		}
		return bt1;
	}

	private JButton getBt2() {
		if (bt2 == null) {
			bt2 = new JButton("");
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(2);
				}
			});
			bt2.setForeground(Color.BLACK);
			bt2.setBackground(Color.BLACK);
		}
		return bt2;
	}

	private JButton getBt3() {
		if (bt3 == null) {
			bt3 = new JButton("");
			bt3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(3);
				}
			});
			bt3.setForeground(Color.BLACK);
			bt3.setBackground(Color.BLACK);
		}
		return bt3;
	}

	private JButton getBt4() {
		if (bt4 == null) {
			bt4 = new JButton("");
			bt4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(4);
				}
			});
			bt4.setForeground(Color.BLACK);
			bt4.setBackground(Color.BLACK);
		}
		return bt4;
	}

	private JButton getBt5() {
		if (bt5 == null) {
			bt5 = new JButton("");
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(5);
				}
			});
			bt5.setForeground(Color.BLACK);
			bt5.setBackground(Color.BLACK);
		}
		return bt5;
	}

	private JButton getBt6() {
		if (bt6 == null) {
			bt6 = new JButton("");
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(6);
				}
			});
			bt6.setForeground(Color.BLACK);
			bt6.setBackground(Color.BLACK);
		}
		return bt6;
	}

	private JButton getBt7() {
		if (bt7 == null) {
			bt7 = new JButton("");
			bt7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(7);
				}
			});
			bt7.setForeground(Color.BLACK);
			bt7.setBackground(Color.BLACK);
		}
		return bt7;
	}

	private JButton getBt8() {
		if (bt8 == null) {
			bt8 = new JButton("");
			bt8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(8);
				}
			});
			bt8.setForeground(Color.BLACK);
			bt8.setBackground(Color.BLACK);
		}
		return bt8;
	}

	private JButton getBt9() {
		if (bt9 == null) {
			bt9 = new JButton("");
			bt9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(9);
				}
			});
			bt9.setForeground(Color.BLACK);
			bt9.setBackground(Color.BLACK);
		}
		return bt9;
	}

	private JButton getBt10() {
		if (bt10 == null) {
			bt10 = new JButton("");
			bt10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(10);
				}
			});
			bt10.setForeground(Color.BLACK);
			bt10.setBackground(Color.BLACK);
		}
		return bt10;
	}

	private JLabel getLblPuntosTortuga() {
		if (lblPuntosTortuga == null) {
			lblPuntosTortuga = new JLabel("0");
			lblPuntosTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntosTortuga.setForeground(Color.MAGENTA);
			lblPuntosTortuga.setFont(new Font("Tahoma", Font.PLAIN, 36));
			lblPuntosTortuga.setBorder(new LineBorder(Color.WHITE));
			lblPuntosTortuga.setBackground(Color.BLACK);
			lblPuntosTortuga.setBounds(548, 64, 167, 32);
		}
		return lblPuntosTortuga;
	}

	private JLabel getLabel_1_1() {
		if (lblLiebrePeque == null) {
			lblLiebrePeque = new JLabel("");
			lblLiebrePeque.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
			lblLiebrePeque.setBounds(493, 25, 56, 32);
		}
		return lblLiebrePeque;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga_peq.JPG")));
			label.setBounds(493, 64, 56, 32);
		}
		return label;
	}
}
