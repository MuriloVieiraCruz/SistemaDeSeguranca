package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoIncidente;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Incidente;

public class IncidenteService {

	private DaoIncidente daoIncidente;
	
	public IncidenteService(){
		this.daoIncidente = FactoryDao.getInstance().getDaoIncidente();
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
	
	public void excluirPor(int idDoIncidente) {
		if (idDoIncidente > 0) {
			this.daoIncidente.excluirPor(idDoIncidente);
		} else {
			throw new IllegalArgumentException("O id para remoção do incidente deve ser maior que 0");
		}
	}
	
	public List<Incidente> listarPor(String descricao) {
		if (descricao != null && !descricao.isBlank()) {
			String filtro = descricao + "%";
			return daoIncidente.listarPor(filtro);
		} else {
			throw new IllegalArgumentException("O filtro para listagem é obrigatório");
		}
	}
}
