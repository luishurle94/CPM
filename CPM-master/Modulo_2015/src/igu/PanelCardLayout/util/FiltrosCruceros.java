package igu.PanelCardLayout.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import igu.PanelCardLayout.PanelListaCruceros;
import logica.Crucero;

public class FiltrosCruceros implements ActionListener {
	private PanelListaCruceros panel;

	public FiltrosCruceros(PanelListaCruceros panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		agregarCrucerosTabla();
	}

	private void agregarCrucerosTabla() {
		borrarTabla();
		if (panel.getCbOpcionesFiltros().getSelectedIndex() == 0)
			agregarTablaZona();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 1)
			panel.agregarTablaPuertoSalida();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 2)
			panel.agregarTablaItinerario();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 3)
			panel.agregarTablaMenores();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 4)
			panel.agregarTablaDiasDuracion();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 5)
			panel.agregarTablaFechas();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 6)
			panel.agregarTablaBarco();
		else if (panel.getCbOpcionesFiltros().getSelectedIndex() == 7)
			panel.agregarTablaPrecio();
	}

	private void borrarTabla() {
		while (panel.getModeloTablaCruceros().getRowCount() > 0) {
			panel.getModeloTablaCruceros().removeRow(0);
		}
	}

	private void agregarTablaZona() {
		String filtro = new String();
		for (Component componente : panel.getPnOpcionesFiltros()
				.getComponents()) {
			JRadioButton radio = (JRadioButton) componente;
			if (radio.isSelected()) {
				filtro = radio.getText();
				break;
			}
		}
		if (filtro.equals("Todos"))
			panel.agregarTodo();
		else {
			for (Crucero crucero : panel.getVp().getCatalogo().getCruceros()) {
				if (crucero.getZona().equals(filtro)) {
					panel.añadirCruceroTabla(crucero);
				}
			}
		}
	}
}
