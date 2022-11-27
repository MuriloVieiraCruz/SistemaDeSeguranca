package br.com.senai.core.service;

import java.time.LocalDate;

import br.com.senai.core.dao.DaoEnvolvido;
import br.com.senai.core.dao.DaoIncidente;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Envolvido;
import br.com.senai.core.domain.Incidente;
import br.com.senai.core.domain.Ocorrencia;


public class SegurancaService {

	private DaoEnvolvido daoEnvolvido;
	
	private DaoIncidente daoIncidente;
	
	public SegurancaService() {
		this.daoEnvolvido = FactoryDao.getInstance().getDaoEnvolvido();
		this.daoIncidente = FactoryDao.getInstance().getDaoIncidente();
	}
	
	public void salvar(Envolvido envolvido) {
		this.validar(envolvido);
		boolean isJaPersistido = envolvido.getId() > 0;
		if (isJaPersistido) {
			this.daoEnvolvido.alterar(envolvido);
		} else {
			this.daoEnvolvido.inserir(envolvido);
		}
	}
	
	public void salvar(Incidente incidente) {
		this.validar(incidente);
		boolean isJaPersistido = incidente.getId() > 0;
		if (isJaPersistido) {
			this.daoIncidente.alterar(incidente);
		} else {
			this.daoIncidente.inserir(incidente);
		}
	}

	public void salvar(Ocorrencia ocorrencia) {
	
	}
	
	private void validar(Envolvido envolvido) {
		if (envolvido != null) {
			boolean isNomeCompletoInvalida = envolvido.getNomeCompleto() == null
					|| envolvido.getNomeCompleto().isBlank()
					|| envolvido.getNomeCompleto().length() < 2
					|| envolvido.getNomeCompleto().length() > 100;
					
			if (isNomeCompletoInvalida) {
				throw new IllegalArgumentException("O nome é obrigatório "
						+ "e deve possuir entre 2 e 100 caracteres");
			}
			
			boolean isDocumentoInvalida = envolvido.getDocumento() == null
					|| envolvido.getDocumento().isBlank()
					|| envolvido.getDocumento().length() != 20;
			
			if (isDocumentoInvalida) {
				throw new IllegalArgumentException("A descrição é "
						+ "obrigatória e deve possuir 20 caracteres");
			}
			
		} else {
			throw new NullPointerException("O envolvido não pode ser nulo");
		}
	}
	
	private void validar(Incidente incidente) {
		if (incidente != null) {
			boolean isDescricaoInvalida = incidente.getDescricaoCurta() == null
					|| incidente.getDescricaoCurta().isBlank()
					|| incidente.getDescricaoCurta().length() < 2
					|| incidente.getDescricaoCurta().length() > 100;
					
			if (isDescricaoInvalida) {
				throw new IllegalArgumentException("A descrição é obrigatória e deve possuir entre 2 e 100 caracteres");
			}
			
			boolean isGravidadeInvalida = incidente.getGravidade() <= 0
					|| incidente.getGravidade() > 1000;
			
			if (isGravidadeInvalida) {
				throw new IllegalArgumentException("O valor da gravidade deve estar entre 1 e 1000");
			}
		} else {
			throw new NullPointerException("O incidente não pode ser nulo");
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
	
}
