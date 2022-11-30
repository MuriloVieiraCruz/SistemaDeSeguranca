package br.com.senai.core.domain;

import java.util.Objects;

public class Incidente {

	
	private int id;
	
	private String descricaoCurta;
	
	private int gravidade;

	public Incidente(String descricaoCurta, int gravidade) {
		this.descricaoCurta = descricaoCurta;
		this.gravidade = gravidade;
	}

	public Incidente(int id, String descricaoCurta, int gravidade) {
		this(descricaoCurta, gravidade);
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricaoCurta() {
		return descricaoCurta;
	}

	public void setDescricaoCurta(String descricaoCurta) {
		this.descricaoCurta = descricaoCurta;
	}

	public int getGravidade() {
		return gravidade;
	}

	public void setGravidade(int gravidade) {
		this.gravidade = gravidade;
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
		Incidente other = (Incidente) obj;
		return id == other.id;
	}
}