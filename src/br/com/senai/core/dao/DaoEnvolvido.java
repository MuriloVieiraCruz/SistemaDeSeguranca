package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Envolvido;

public interface DaoEnvolvido {
	
	public void inserir(Envolvido envolvido );
	public void alterar(Envolvido  envolvido);
	public void excluirPor(int id);
	public Envolvido buscarPor(int id);
	public List<Envolvido> listarPor(String nomeCompleto);

}
