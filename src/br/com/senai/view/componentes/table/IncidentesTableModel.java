package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Incidente;

public class IncidentesTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private final int QTDE_COLUNAS = 3;
	private List<Incidente> incidentes;

	@Override
	public int getRowCount() {
		
		return 0;
	}

	@Override
	public int getColumnCount() {
		
		return 0;
	}

	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Código";
		} else if (column == 1) {
			return "Descrição";
		} else if (column == 2) {
			return "Gravidade";
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return null;
	}

}
