package br.com.senai.core.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Ocorrencia {

	
	private int id;
	
	private LocalDate data;
	
	private String detalhamento;

	public Ocorrencia(LocalDate data, String detalhamento) {
		this.data = data;
		this.detalhamento = detalhamento;
	}

	public Ocorrencia(int id, LocalDate data, String detalhamento) {
		this(data, detalhamento);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
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
		Ocorrencia other = (Ocorrencia) obj;
		return id == other.id;
	}
}