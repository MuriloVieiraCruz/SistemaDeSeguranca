package br.com.senai.core.dao;

import java.util.List;

import br.com.senai.core.domain.Incidente;

public interface DaoIncidente {
	
	public void inserir(Incidente incidente);
	public void alterar(Incidente incidente);
	public void excluirPor(int id);
	public Incidente buscarPor(int id);
	public List<Incidente> listarPor(String descricaoCurta);

}
