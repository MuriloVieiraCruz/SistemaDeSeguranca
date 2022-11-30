package br.com.senai.core.domain;

import java.util.Objects;

public class Envolvido {

	private int id;
	
	private String nomeCompleto;
	
	private String documento;

	public Envolvido(String nomeCompleto, String documento) {
		this.nomeCompleto = nomeCompleto;
		this.documento = documento;
	}

	public Envolvido(int id, String nomeCompleto, String documento) {
		this(nomeCompleto, documento);
		this.id = id;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
		Envolvido other = (Envolvido) obj;
		return id == other.id;
	}
}
