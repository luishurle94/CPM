package igu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class VentanaConfirmacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txCodigo;
	private VentanaPrincipal vp;
	private JLabel lblPrecioTotal;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public VentanaConfirmacion(VentanaPrincipal vp) {
		
		this.vp = vp;
		vp.getPedido().setCodigo(new Random().nextInt(1000));
		setTitle("Venta de Accesorios: Confirmaci\u00F3n de pedido");
		setBounds(100, 100, 551, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbOk = new JLabel("");
			lbOk.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lbOk.setBounds(39, 41, 50, 57);
			contentPanel.add(lbOk);
		}
		{
			JLabel lbAviso = new JLabel("Estamos preparando su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 21));
			lbAviso.setBounds(115, 54, 353, 30);
			contentPanel.add(lbAviso);
		}
		{
			JLabel lbCodigo = new JLabel("El c\u00F3digo de recogida es:");
			lbCodigo.setBounds(99, 90, 152, 31);
			contentPanel.add(lbCodigo);
		}
		{
			txCodigo = new JTextField();
			txCodigo.setEditable(false);
			txCodigo.setBounds(261, 95, 112, 20);
			contentPanel.add(txCodigo);
			txCodigo.setColumns(10);
			txCodigo.setText(vp.getPedido().generarCodigo());
		}
		{
			JButton btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//System.exit(0);
					dispose(); //cierro la ventana de confirmación
					vp.Inicializar(); //inicializa una nueva
				}
			});
			btFinalizar.setMnemonic('F');
			btFinalizar.setBounds(361, 234, 89, 23);
			contentPanel.add(btFinalizar);
			
			
		}
		
		JLabel lblImporte = new JLabel("Importe: ");
		lblImporte.setBounds(33, 150, 68, 16);
		contentPanel.add(lblImporte);
		
		JLabel lblPrecioTotal = new JLabel("0.0 ");
		lblPrecioTotal.setBounds(115, 150, 56, 16);
		contentPanel.add(lblPrecioTotal);
	}
	
	private JLabel getLbPrecio() {
		if (lblPrecioTotal == null) {
			lblPrecioTotal = new JLabel("Precio total:");
			lblPrecioTotal.setFont(new Font("Times New Roman", Font.BOLD, 21));
			lblPrecioTotal.setBounds(535, 301, 93, 33);
			lblPrecioTotal.setText(String.valueOf(vp.getPedido().calcularTotalSinIva()));
		}
		return lblPrecioTotal;
	}
}
