package br.com.senai.view.componentes.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.senai.core.domain.Envolvido;


public class EnvolvidosTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<Envolvido> envolvidos;
	
	public EnvolvidosTableModel(List<Envolvido> envolvidos) {
		this.envolvidos = envolvidos;
	}
	
	public Envolvido getPor(int rowIndex) {
		return envolvidos.get(rowIndex);
	}
	
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Código";
		} else if (columnIndex == 1) {
			return "Nome";
		} else if (columnIndex == 2) {
			return "Documento";
		}
		throw new IllegalArgumentException("Índice inválido.");
		
	}

	@Override
	public int getRowCount() {
		return envolvidos.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Envolvido envolvidoDaLinha = envolvidos.get(rowIndex);
		if (columnIndex == 0) {
			return envolvidoDaLinha.getId();
		} else if (columnIndex == 1) {
			return envolvidoDaLinha.getNomeCompleto();
		} else if (columnIndex == 2) {
			return envolvidoDaLinha.getDocumento();
		}
		throw new IllegalArgumentException("Índice inválido.");
	}

}
