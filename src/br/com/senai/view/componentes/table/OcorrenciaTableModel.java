package br.com.senai.view.componentes.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.core.domain.Ocorrencia;

public class OcorrenciaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Ocorrencia> ocorrencias;
	
	public OcorrenciaTableModel(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	public Ocorrencia getPor(int rowIndex) {
		return ocorrencias.get(rowIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Código";
		} else if (columnIndex == 1) {
			return "Envolvido";
		} else if (columnIndex == 2) {
			return "Incidente";
		}
		throw new IllegalArgumentException("Indice inválido");
	}

	@Override
	public int getRowCount() {
		return ocorrencias.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ocorrencia ocorrenciaDaLinha = ocorrencias.get(columnIndex);
		if (columnIndex == 0) {
			return ocorrenciaDaLinha.getId();
		} else if (columnIndex == 1) {
			//should return envolved
			return null;
		} else if (columnIndex == 2) {
			//should return incidente
		return null;
	}
		return ocorrenciaDaLinha; 
		
		}

}
