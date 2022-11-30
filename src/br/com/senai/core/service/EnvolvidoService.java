package br.com.senai.core.service;

import java.util.List;

import br.com.senai.core.dao.DaoEnvolvido;
import br.com.senai.core.dao.FactoryDao;
import br.com.senai.core.domain.Envolvido;

public class EnvolvidoService {

	private DaoEnvolvido daoEnvolvido;
	
	public EnvolvidoService() {
		this.daoEnvolvido = FactoryDao.getInstance().getDaoEnvolvido();
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
			
			Envolvido envolvidoJaSalvo = daoEnvolvido.buscarPorDocumento(envolvido.getDocumento());
			
			if (envolvidoJaSalvo != null && envolvidoJaSalvo.getId() != envolvido.getId()) {
				throw new IllegalArgumentException("O documento do envolvido cadastrado já está inserido no banco");
			}
			
		} else {
			throw new NullPointerException("O envolvido não pode ser nulo");
		}
	}
	
	public void excluirPorEnvolvido(int idDoEnvolvido) {
		if (idDoEnvolvido > 0) {
			this.daoEnvolvido.excluirPor(idDoEnvolvido);
		} else {
			throw new IllegalArgumentException("O id para remoção do envolvido deve ser maior que 0");
		}
	}
	
	public List<Envolvido> listarPor(String descricao) {
		if (descricao != null && !descricao.isBlank()) {
			String filtro = descricao + "%";
			return daoEnvolvido.listarPor(filtro);
		} else {
			throw new IllegalArgumentException("O filtro para listagem é obrigatório");
		}
	}
}
