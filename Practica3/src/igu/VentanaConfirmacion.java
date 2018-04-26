package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;


	
	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.jpg")));
		setTitle("Venta de Accesorios: Confirmaci\u00F3n de pedido");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton cancelButton = new JButton("Finalizar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					System.exit(0);
					}
				});
				cancelButton.setMnemonic('f');
				cancelButton.setBounds(296, 5, 133, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Estamos preparando su pedido");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_1.setBounds(126, 98, 298, 43);
			getContentPane().add(lblNewLabel_1);
		}
		{
			JLabel lblElCdigoDe = new JLabel("El c\u00F3digo de recogida es: ");
			lblElCdigoDe.setBounds(126, 152, 130, 14);
			getContentPane().add(lblElCdigoDe);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(258, 149, 86, 20);
			getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblNewLabel.setBounds(46, 81, 70, 85);
			getContentPane().add(lblNewLabel);
		}
	}

}


//Enlazar ventana registro en el boton siguiente, y generar el codigo aleatorio al finalizar la compra, meter los datos y 
//VentanaRegistro vR = new VentanaRegistro();
//vR.setLocationRelativeTo(this);
//vR.setModal(true);
//vR.setVisible(true);