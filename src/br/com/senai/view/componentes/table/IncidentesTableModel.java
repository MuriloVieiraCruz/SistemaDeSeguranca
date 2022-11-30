package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Incidente;

public class IncidentesTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private List<Incidente> incidentes;
	
	public IncidentesTableModel(List<Incidente> incidentes) {
		this.incidentes = incidentes;
	}
	
	public Incidente getPor(int rowIndex) {
		return incidentes.get(rowIndex);
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Código";
		} else if (columnIndex == 1) {
			return "Descrição";
		} else if (columnIndex == 2) {
			return "Gravidade";
		}
		throw new IllegalArgumentException("Índice inválido");
	}

	@Override
	public int getRowCount() {
		return incidentes.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Incidente incidenteDaLinha = incidentes.get(rowIndex);
		if (columnIndex == 0) {
			return incidenteDaLinha.getId();
		} else if (columnIndex == 1) {
			return incidenteDaLinha.getDescricaoCurta();
		} else if (columnIndex == 2) {
			return incidenteDaLinha.getGravidade();
		}
		
		throw new IllegalArgumentException("Indice inválido");
	}

}
