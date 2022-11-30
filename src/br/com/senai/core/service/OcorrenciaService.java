package br.com.senai.core.service;

import java.time.LocalDate;
import java.util.List;

import br.com.senai.core.dao.DaoOcorrencia;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Ocorrencia;

public class OcorrenciaService {

	private DaoOcorrencia daoOcorrencia;
	
	public  OcorrenciaService() {
		this.daoOcorrencia = FactoryDao.getInstance().getDaoOcorrencia();
	}
	
	public void salvar(Ocorrencia ocorrencia) {
		this.validar(ocorrencia);
		boolean isJaPersistido = ocorrencia.getId() > 0;
		if (isJaPersistido) {
			this.daoOcorrencia.alterar(ocorrencia);
		} else {
			this.daoOcorrencia.inserir(ocorrencia);
		}
	}
	
	private void validar(Ocorrencia ocorrencia) {
		if (ocorrencia != null) {
			
			boolean isDataInvalida = ocorrencia.getData() == null
					|| ocorrencia.getData().isBefore(LocalDate.now());
			
			if (isDataInvalida) {
				throw new IllegalArgumentException("A data é obrigatória e não pode ser anterior a data atual");
			}
			
			boolean isDetalhamentoInvalido = ocorrencia.getDetalhamento() == null
					|| ocorrencia.getDetalhamento().isBlank();
			
			if (isDetalhamentoInvalido) {
				throw new IllegalArgumentException("O detalhamento é obrigatório");
			}
			
		} else {
			throw new NullPointerException("A ocorrência não pode ser nula");
		}
	}
	
	public void excluirPor(int idDaOcorrencia) {
		if (idDaOcorrencia > 0) {
			this.daoOcorrencia.excluirPor(idDaOcorrencia);
		} else {
			throw new IllegalArgumentException("O id para remoção da ocorrência deve ser maior que 0");
		}
	}
	
	public List<Ocorrencia> listarPor(String descricao) {
	if (descricao != null && !descricao.isBlank()) {
		String filtro = descricao + "%";
		return daoOcorrencia.listarPor(filtro);
	} else {
		throw new IllegalArgumentException("O filtro para listagem é obrigatório");
	}
	}
}
