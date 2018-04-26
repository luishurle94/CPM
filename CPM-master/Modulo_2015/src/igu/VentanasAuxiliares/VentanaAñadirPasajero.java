package igu.VentanasAuxiliares;

import igu.VentanaPrincipal;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import logica.Pasajero;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaAñadirPasajero extends JDialog {
	private static final long serialVersionUID = 6108482249162521863L;
	private VentanaPrincipal vp;
	private JPanel pnPrincipal;
	private JPanel pnBotones;
	private JPanel pnDatosPasajero;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private JPanel pnDni;
	private JPanel pnNombrePasajero;
	private JPanel pnPrimerApellido;
	private JPanel pnSegundoApellido;
	private JPanel pnFechaNacimiento;
	private JLabel lblNombre;
	private JTextField txtNombrePasajero;
	private JLabel lblPrimerApellido;
	private JTextField txtPrimerApellido;
	private JLabel lblSegundoApellido;
	private JTextField txtSegundoApellido;
	private JLabel lblDni;
	private JTextField txtDniPasajero;
	private JLabel lblFechaDeNacimiento;
	private JPanel pnAñadirFecha;
	private JComboBox<String> cbDia;
	private JComboBox<String> cbMes;
	private JComboBox<String> cbAño;
	private JPanel pnObservaciones;
	private JLabel lblObservaciones;
	private JScrollPane scObservaciones;
	private JTextArea txtObservaciones;
	private JPanel pnTitulo;
	private JLabel lblTitulo;

	public VentanaAñadirPasajero(VentanaPrincipal vp) {
		setTitle("A\u00F1adir pasajero");
		this.vp = vp;
		setBounds(100, 100, 615, 450);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new BorderLayout(0, 0));
		pnPrincipal.add(getPnDatosPasajero(), BorderLayout.CENTER);
		pnPrincipal.add(getPnBotones(), BorderLayout.SOUTH);
		pnPrincipal.add(getPnTitulo(), BorderLayout.NORTH);
		cambiarCbDias();
		cargaAyuda();
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnBotones.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones.add(getBtnAgregar());
			pnBotones.add(getBtnCancelar());
		}
		return pnBotones;
	}

	private JPanel getPnDatosPasajero() {
		if (pnDatosPasajero == null) {
			pnDatosPasajero = new JPanel();
			pnDatosPasajero.setLayout(new GridLayout(6, 0, 0, 0));
			pnDatosPasajero.add(getPnNombrePasajero());
			pnDatosPasajero.add(getPnPrimerApellido());
			pnDatosPasajero.add(getPnSegundoApellido());
			pnDatosPasajero.add(getPnDni());
			pnDatosPasajero.add(getPnFechaNacimiento());
			pnDatosPasajero.add(getPnObservaciones());
		}
		return pnDatosPasajero;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setToolTipText(
					"Cierra la ventana actual y vuelve a la ventana principal");
			btnCancelar.setMnemonic('C');
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}

	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setToolTipText(
					"A\u00F1ade un pasajero a la lista de pasajeros");
			btnAgregar.setMnemonic('A');
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Pasajero pasajero = new Pasajero(
							txtNombrePasajero.getText(),
							txtPrimerApellido.getText() + " "
									+ txtSegundoApellido.getText(),
							txtDniPasajero.getText(),
							cbDia.getSelectedItem() + "-"
									+ (cbMes.getSelectedIndex() + 1) + "-"
									+ cbAño.getSelectedItem(),
							txtObservaciones.getText());
					boolean añadido = false;
					for (Pasajero a : vp.getListaPasajeros()) {
						if (a.getNombre().equals(pasajero.getNombre())
								&& a.getApellidos()
										.equals(pasajero.getApellidos())
								&& a.getDni().equals(pasajero.getDni())
								&& a.getFechaNacimiento().equals(
										pasajero.getFechaNacimiento())) {
							añadido = true;
							break;
						}
					}
					if (!añadido) {
						vp.getListaPasajeros().add(pasajero);
						vp.getModeloListaPasajeros()
								.addRow(new Object[] { pasajero.getNombre(),
										pasajero.getApellidos(),
										pasajero.getDni(),
										pasajero.getFechaNacimiento() });
						vp.activarBtnSiguientePasajeros();
						String[] opciones = { "Si", "No" };
						int seleccion = JOptionPane.showOptionDialog(null,
								"Â¿Desea añadir mÃ¡s pasajeros?",
								"Añadir mÃ¡s pasajeros",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, opciones,
								opciones[0]);
						if (seleccion == 0) {
							txtPrimerApellido.setText("");
							txtSegundoApellido.setText("");
							txtNombrePasajero.setText("");
							txtDniPasajero.setText("");
							cbDia.setSelectedIndex(0);
							cbMes.setSelectedIndex(0);
							cbAño.setSelectedIndex(0);
							btnAgregar.setEnabled(false);
						} else {
							dispose();
							if (vp.getListaPasajeros().size() > 0)
								vp.getBtnBorrarPasajero().setEnabled(true);
							vp.getBtnSiguientePasajeros().grabFocus();
						}
					} else
						JOptionPane.showMessageDialog(null,
								"Pasajero ya añadido", "Error",
								JOptionPane.ERROR_MESSAGE);
				}
			});
			btnAgregar.setEnabled(false);
		}
		return btnAgregar;
	}

	private JPanel getPnDni() {
		if (pnDni == null) {
			pnDni = new JPanel();
			pnDni.setLayout(new GridLayout(1, 0, 0, 0));
			pnDni.add(getLblDni());
			pnDni.add(getTxtDniPasajero());
		}
		return pnDni;
	}

	private JPanel getPnNombrePasajero() {
		if (pnNombrePasajero == null) {
			pnNombrePasajero = new JPanel();
			pnNombrePasajero.setLayout(new GridLayout(0, 2, 0, 0));
			pnNombrePasajero.add(getLblNombre());
			pnNombrePasajero.add(getTxtNombrePasajero());
		}
		return pnNombrePasajero;
	}

	private JPanel getPnPrimerApellido() {
		if (pnPrimerApellido == null) {
			pnPrimerApellido = new JPanel();
			pnPrimerApellido.setLayout(new GridLayout(0, 2, 0, 0));
			pnPrimerApellido.add(getLblPrimerApellido());
			pnPrimerApellido.add(getTxtPrimerApellido());
		}
		return pnPrimerApellido;
	}

	private JPanel getPnSegundoApellido() {
		if (pnSegundoApellido == null) {
			pnSegundoApellido = new JPanel();
			pnSegundoApellido.setLayout(new GridLayout(1, 0, 0, 0));
			pnSegundoApellido.add(getLblSegundoApellido());
			pnSegundoApellido.add(getTxtSegundoApellido());
		}
		return pnSegundoApellido;
	}

	private JPanel getPnFechaNacimiento() {
		if (pnFechaNacimiento == null) {
			pnFechaNacimiento = new JPanel();
			pnFechaNacimiento.setLayout(new GridLayout(1, 0, 0, 0));
			pnFechaNacimiento.add(getLblFechaDeNacimiento());
			pnFechaNacimiento.add(getPnAñadirFecha());
		}
		return pnFechaNacimiento;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setDisplayedMnemonic('N');
			lblNombre.setLabelFor(getTxtNombrePasajero());
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblNombre;
	}

	private JTextField getTxtNombrePasajero() {
		if (txtNombrePasajero == null) {
			txtNombrePasajero = new JTextField();
			txtNombrePasajero
					.setToolTipText("Introduzca aqui el nombre del pasajero");
			txtNombrePasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombrePasajero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposTexto();
				}
			});
			txtNombrePasajero.setColumns(10);
		}
		return txtNombrePasajero;
	}

	private void comprobarCamposTexto() {
		if (txtPrimerApellido.getText().isEmpty()
				|| txtSegundoApellido.getText().isEmpty()
				|| txtNombrePasajero.getText().isEmpty()
				|| txtDniPasajero.getText().isEmpty())
			btnAgregar.setEnabled(false);
		else
			btnAgregar.setEnabled(true);
	}

	private JLabel getLblPrimerApellido() {
		if (lblPrimerApellido == null) {
			lblPrimerApellido = new JLabel("Primer Apellido:");
			lblPrimerApellido.setDisplayedMnemonic('P');
			lblPrimerApellido.setLabelFor(getTxtPrimerApellido());
			lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPrimerApellido.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblPrimerApellido;
	}

	private JTextField getTxtPrimerApellido() {
		if (txtPrimerApellido == null) {
			txtPrimerApellido = new JTextField();
			txtPrimerApellido.setToolTipText(
					"Introduzca aqui el primer apellido del pasajero");
			txtPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPrimerApellido.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposTexto();
				}
			});
			txtPrimerApellido.setColumns(10);
		}
		return txtPrimerApellido;
	}

	private JLabel getLblSegundoApellido() {
		if (lblSegundoApellido == null) {
			lblSegundoApellido = new JLabel("Segundo Apellido:");
			lblSegundoApellido.setDisplayedMnemonic('S');
			lblSegundoApellido.setLabelFor(getTxtSegundoApellido());
			lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSegundoApellido.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblSegundoApellido;
	}

	private JTextField getTxtSegundoApellido() {
		if (txtSegundoApellido == null) {
			txtSegundoApellido = new JTextField();
			txtSegundoApellido.setToolTipText(
					"Introduzca aqui el segundo apellido del pasajero");
			txtSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtSegundoApellido.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposTexto();
				}
			});
			txtSegundoApellido.setColumns(10);
		}
		return txtSegundoApellido;
	}

	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("Dni:");
			lblDni.setToolTipText("");
			lblDni.setDisplayedMnemonic('D');
			lblDni.setLabelFor(getTxtDniPasajero());
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDni.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblDni;
	}

	private JTextField getTxtDniPasajero() {
		if (txtDniPasajero == null) {
			txtDniPasajero = new JTextField();
			txtDniPasajero
					.setToolTipText("Introduzca aqui el dni del pasajero");
			txtDniPasajero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDniPasajero.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					comprobarCamposTexto();
				}
			});
			txtDniPasajero.setColumns(10);
		}
		return txtDniPasajero;
	}

	private JLabel getLblFechaDeNacimiento() {
		if (lblFechaDeNacimiento == null) {
			lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
			lblFechaDeNacimiento.setToolTipText("");
			lblFechaDeNacimiento.setDisplayedMnemonic('F');
			lblFechaDeNacimiento.setLabelFor(getCbDia());
			lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblFechaDeNacimiento;
	}

	private JPanel getPnAñadirFecha() {
		if (pnAñadirFecha == null) {
			pnAñadirFecha = new JPanel();
			pnAñadirFecha.setLayout(new GridLayout(0, 3, 0, 0));
			pnAñadirFecha.add(getCbDia());
			pnAñadirFecha.add(getCbMes());
			pnAñadirFecha.add(getCbAño());
		}
		return pnAñadirFecha;
	}

	private JComboBox<String> getCbDia() {
		if (cbDia == null) {
			cbDia = new JComboBox<String>();
			cbDia.setToolTipText("Dia de la fecha de nacimiento del pasajero");
			cbDia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return cbDia;
	}

	private JComboBox<String> getCbMes() {
		if (cbMes == null) {
			String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
					"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
					"Noviembre", "Diciembre" };
			cbMes = new JComboBox<String>();
			cbMes.setToolTipText("Mes de la fecha de nacimiento del pasajero");
			cbMes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int posicion = cbDia.getSelectedIndex();
					cambiarCbDias();
					if (posicion >= cbDia.getModel().getSize()) {
						cbDia.setSelectedIndex(cbDia.getModel().getSize() - 1);
					} else
						cbDia.setSelectedIndex(posicion);
				}
			});
			cbMes.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbMes.setModel(new DefaultComboBoxModel<String>(meses));
		}
		return cbMes;
	}

	private void cambiarCbDias() {
		String[] dias = calcularDiasMes();
		cbDia.setModel(new DefaultComboBoxModel<String>(dias));
	}

	private String[] calcularDiasMes() {
		String[] dias;
		String aux = String.valueOf(cbMes.getSelectedItem());
		if (aux.equals("Enero") || aux.equals("Marzo") || aux.equals("Mayo")
				|| aux.equals("Julio") || aux.equals("Agosto")
				|| aux.equals("Octubre") || aux.equals("Diciembre")) {
			dias = new String[31];
			for (int i = 0; i < 31; i++)
				dias[i] = "" + (i + 1);
		} else if (aux.equals("Febrero")) {
			dias = new String[28];
			for (int i = 0; i < 28; i++)
				dias[i] = "" + (i + 1);
		} else {
			dias = new String[30];
			for (int i = 0; i < 30; i++)
				dias[i] = "" + (i + 1);
		}
		return dias;
	}

	private JComboBox<String> getCbAño() {
		if (cbAño == null) {
			cbAño = new JComboBox<String>();
			cbAño.setToolTipText(
					"A\u00F1o de la fecha de nacimiento del pasajero");
			cbAño.setFont(new Font("Tahoma", Font.PLAIN, 12));
			String[] años = new String[90];
			for (int i = 0; i < años.length; i++)
				años[i] = "" + (2014 - i);
			cbAño.setModel(new DefaultComboBoxModel<String>(años));
		}
		return cbAño;
	}

	private JPanel getPnObservaciones() {
		if (pnObservaciones == null) {
			pnObservaciones = new JPanel();
			pnObservaciones.setLayout(new GridLayout(1, 1, 0, 0));
			pnObservaciones.add(getLblObservaciones());
			pnObservaciones.add(getScObservaciones());
		}
		return pnObservaciones;
	}

	private JLabel getLblObservaciones() {
		if (lblObservaciones == null) {
			lblObservaciones = new JLabel(
					"Observaciones: (Alergias, intolerancias...)");
			lblObservaciones.setToolTipText("");
			lblObservaciones.setDisplayedMnemonic('O');
			lblObservaciones.setLabelFor(getTxtObservaciones());
			lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblObservaciones.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lblObservaciones;
	}

	private JScrollPane getScObservaciones() {
		if (scObservaciones == null) {
			scObservaciones = new JScrollPane();
			scObservaciones.setViewportView(getTxtObservaciones());
		}
		return scObservaciones;
	}

	private JTextArea getTxtObservaciones() {
		if (txtObservaciones == null) {
			txtObservaciones = new JTextArea();
			txtObservaciones.setToolTipText(
					"Indique si el pasajero tiene alguna enfermedad o alg\u00FAn dato de interes");
			txtObservaciones.setLineWrap(true);
			txtObservaciones.setWrapStyleWord(true);
		}
		return txtObservaciones;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setBorder(new EmptyBorder(0, 0, 5, 0));
			pnTitulo.add(getLblTitulo());
		}
		return pnTitulo;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Añadir pasajero");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return lblTitulo;
	}

	private void cargaAyuda() {
		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/Ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ayuda no encontrada", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		HelpBroker hb = hs.createHelpBroker();
		hb.initPresentation();

		// Asocia un atajo de teclado a la ayuda, a F1
		hb.enableHelpKey(pnPrincipal, "ventanaAñadirPasajero", hs);
	}
}
