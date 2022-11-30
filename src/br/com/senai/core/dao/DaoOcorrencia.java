package br.com.senai.core.dao;

import java.util.List;
import br.com.senai.core.domain.Ocorrencia;

public interface DaoOcorrencia {
	
	public void inserir(Ocorrencia ocorrencia);
	public void alterar(Ocorrencia ocorrencia);
	public void excluirPor(int id);
	public Ocorrencia buscarPor(int id);
	public List<Ocorrencia> listarPor(String envolvido);

}
