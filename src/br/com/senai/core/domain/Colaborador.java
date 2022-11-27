package br.com.senai.core.domain;

import java.util.Objects;

public class Colaborador {

	
	private int id;
	
	private String nomeCompleto;

	public Colaborador(int id, String nomeCompleto) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return id == other.id;
	}
}
