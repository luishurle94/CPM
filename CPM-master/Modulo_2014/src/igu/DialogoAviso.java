package igu;

import javax.swing.JDialog;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogoAviso extends JDialog {
	private JPanel footer;
	private JButton fboton1;
	private Component fseparator;
	private JButton fboton2;
	private JPanel bodycontainer;
	private JLabel bicono;
	private Component bleadingseparator;
	private Component bmiddleseparator;
	private JPanel body;
	private Component bcleadingseparator;
	private Component bctrailingseparator;
	private Component btrailingseparator;

	private boolean option;
	private JTextArea btexto;
	private VentanaPrincipal main;

	/**
	 * Create the dialog.
	 */
	public DialogoAviso(VentanaPrincipal main, String title, Icon icon,
			String mensaje, String boton1, String boton2) {
		setResizable(false);
		this.main = main;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DialogoAviso.class.getResource("/img/Azur.png")));
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		getContentPane().setBackground(new Color(40, 40, 40));
		getContentPane().add(getBodycontainer(), BorderLayout.CENTER);
		getContentPane().add(getFooter(), BorderLayout.SOUTH);
		setBounds(100, 100, 600, 450);
		setTitle(title);
		bicono.setIcon(icon);
		btexto.setText(mensaje);
		fboton1.setText(boton1);
		fboton1.setToolTipText(boton1);
		fboton1.setMnemonic(boton1.toCharArray()[0]);
		if (boton2 == "") {
			fboton2.setVisible(false);
		} else {
			fboton2.setText(boton2);
			fboton2.setToolTipText(boton2);
			fboton2.setMnemonic(boton2.toCharArray()[0]);
		}
	}

	public DialogoAviso(VentanaPrincipal main, String title, Icon icon,
			String mensaje, String boton) {
		setResizable(false);
		this.main = main;
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DialogoAviso.class.getResource("/img/Azur.png")));
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		getContentPane().setBackground(new Color(40, 40, 40));
		getContentPane().add(getBodycontainer(), BorderLayout.CENTER);
		getContentPane().add(getFooter(), BorderLayout.SOUTH);
		setBounds(100, 100, 600, 450);
		setTitle(title);
		bicono.setIcon(icon);
		btexto.setText(mensaje);
		fboton1.setVisible(false);
		fboton2.setText(boton);
		fboton2.setToolTipText(boton);
		fboton2.setMnemonic(boton.toCharArray()[0]);
	}

	public boolean showDialog() {
		this.setLocationRelativeTo(main);
		this.setModal(true);
		this.setVisible(true);
		return option;
	}

	private JPanel getFooter() {
		if (footer == null) {
			footer = new JPanel();
			footer.setBorder(new LineBorder(new Color(40, 40, 40), 10));
			footer.setBackground(new Color(40, 40, 40));
			footer.setLayout(new BoxLayout(footer, BoxLayout.LINE_AXIS));
			footer.add(getFboton1());
			footer.add(getFseparator());
			footer.add(getFboton2());
		}
		return footer;
	}

	private JButton getFboton1() {
		if (fboton1 == null) {
			fboton1 = new JButton("Bot\u00F3n 1");
			fboton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					option = true;
					setVisible(false);
					dispose();
				}
			});
			fboton1.setMaximumSize(new Dimension(150, 50));
			fboton1.setPreferredSize(new Dimension(150, 50));
			fboton1.setBorderPainted(false);
			fboton1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			fboton1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			fboton1.setForeground(new Color(255, 255, 255));
			fboton1.setBackground(new Color(65, 105, 225));
		}
		return fboton1;
	}

	private Component getFseparator() {
		if (fseparator == null) {
			fseparator = Box.createHorizontalGlue();
		}
		return fseparator;
	}

	private JButton getFboton2() {
		if (fboton2 == null) {
			fboton2 = new JButton("Bot\u00F3n 2");
			fboton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					option = false;
					setVisible(false);
					dispose();
				}
			});
			fboton2.setPreferredSize(new Dimension(150, 50));
			fboton2.setMaximumSize(new Dimension(150, 50));
			fboton2.setForeground(Color.WHITE);
			fboton2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			fboton2.setBorderPainted(false);
			fboton2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			fboton2.setBackground(new Color(65, 105, 225));
		}
		return fboton2;
	}

	private JPanel getBodycontainer() {
		if (bodycontainer == null) {
			bodycontainer = new JPanel();
			bodycontainer.setBorder(new LineBorder(new Color(40, 40, 40), 10));
			bodycontainer.setBackground(new Color(40, 40, 40));
			bodycontainer.setLayout(
					new BoxLayout(bodycontainer, BoxLayout.PAGE_AXIS));
			bodycontainer.add(getBcleadingseparator());
			bodycontainer.add(getBody());
			bodycontainer.add(getBctrailingseparator());
		}
		return bodycontainer;
	}

	private JLabel getBicono() {
		if (bicono == null) {
			bicono = new JLabel("");
			bicono.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return bicono;
	}

	private Component getBleadingseparator() {
		if (bleadingseparator == null) {
			bleadingseparator = Box.createHorizontalGlue();
		}
		return bleadingseparator;
	}

	private Component getBmiddleseparator() {
		if (bmiddleseparator == null) {
			bmiddleseparator = Box.createHorizontalGlue();
		}
		return bmiddleseparator;
	}

	private JPanel getBody() {
		if (body == null) {
			body = new JPanel();
			body.setBorder(new LineBorder(new Color(40, 40, 40), 10));
			body.setBackground(new Color(40, 40, 40));
			body.setLayout(new BoxLayout(body, BoxLayout.LINE_AXIS));
			body.add(getBleadingseparator());
			body.add(getBicono());
			body.add(getBmiddleseparator());
			body.add(getBtexto());
			body.add(getBtrailingseparator());
		}
		return body;
	}

	private Component getBcleadingseparator() {
		if (bcleadingseparator == null) {
			bcleadingseparator = Box.createVerticalGlue();
		}
		return bcleadingseparator;
	}

	private Component getBctrailingseparator() {
		if (bctrailingseparator == null) {
			bctrailingseparator = Box.createVerticalGlue();
		}
		return bctrailingseparator;
	}

	private Component getBtrailingseparator() {
		if (btrailingseparator == null) {
			btrailingseparator = Box.createHorizontalGlue();
		}
		return btrailingseparator;
	}

	private JTextArea getBtexto() {
		if (btexto == null) {
			btexto = new JTextArea();
			btexto.setMinimumSize(new Dimension(300, 200));
			btexto.setMaximumSize(new Dimension(300, 200));
			btexto.setPreferredSize(new Dimension(300, 200));
			btexto.setEditable(false);
			btexto.setWrapStyleWord(true);
			btexto.setLineWrap(true);
			btexto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btexto.setForeground(new Color(255, 255, 255));
			btexto.setBackground(new Color(40, 40, 40));
		}
		return btexto;
	}
}
