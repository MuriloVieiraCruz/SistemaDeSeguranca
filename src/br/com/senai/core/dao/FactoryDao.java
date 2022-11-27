package br.com.senai.core.dao;

import br.com.senai.core.dao.postgresql.DaoPostgresqlEnvolvido;
import br.com.senai.core.dao.postgresql.DaoPostgresqlIncidente;

public class FactoryDao {
	
	private static FactoryDao instance;
	
	private FactoryDao() {}
	
	public DaoIncidente getDaoIncidente() {
		return new DaoPostgresqlIncidente();
	}
	
	public DaoEnvolvido getDaoEnvolvido() {
		return new DaoPostgresqlEnvolvido();
	}
	
	public static FactoryDao getInstance() {
		if (instance == null) {
			instance = new FactoryDao();
		}
		return instance;
	}

}
