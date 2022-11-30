package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.core.dao.DaoIncidente;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Incidente;

public class DaoPostgresqlIncidente implements DaoIncidente {

	private final String INSERT = "INSERT INTO incidentes (descricao_curta, "
			+ " gravidade) VALUES (?, ?)";
	private final String UPDATE = "UPDATE incidentes SET descricao_curta = ?,"
			+ " gravidade = ? WHERE id = ?";
	private final String DELETE = "DELETE FROM incidentes WHERE id = ?";
	private final String SELECT_BY_ID = "SELECT id, descricao_curta, gravidade "
			+ " FROM incidentes WHERE id = ?";
	private final String SELECT_BY_DESC = "SELECT id, descricao_curta, gravidade "
			+ " FROM incidentes WHERE Upper(descricao_curta) LIKE"
			+ " Upper(?)";
	
	private Connection conexao;
	
	public DaoPostgresqlIncidente() {
		this.conexao = ManagerDb.getInstance().getConexao();
		
	}
	
	@Override
	public void inserir(Incidente incidente) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, incidente.getDescricaoCurta());
			ps.setInt(2, incidente.getGravidade());
			ps.execute();
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao"
					+ " inserir o Incidente. O motivo é: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public void alterar(Incidente incidente) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, incidente.getDescricaoCurta());
			ps.setInt(2, incidente.getGravidade());
			ps.setInt(3, incidente.getId());
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, true);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorre um erro ao "
					+ " alterar o incidente. O motivo é: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public void excluirPor(int id) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, false);
			ps = conexao.prepareStatement(DELETE);
			ps.setInt(1, id);
			boolean isExclusaoOK = ps.executeUpdate() == 1;
			if (isExclusaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, true);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao"
					+ " excluir o incidente. O motivo é: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public Incidente buscarPor(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return extrairDo(rs);
			}
			return null;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao buscar "
					+ " por incidente. O motivo é: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}

	@Override
	public List<Incidente> listarPor(String descricaoCurta) {
		List<Incidente> incidentes = new ArrayList<Incidente>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_DESC);
			ps.setString(1, descricaoCurta);
			rs = ps.executeQuery();
			while (rs.next()) {
				incidentes.add(extrairDo(rs));
			}
			return incidentes;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao"
					+ " listar os incidentes. O motivo é: " + ex.getMessage());
		}
		finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	private Incidente extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			String descricaoCurta = rs.getString("descricao_curta");
			int garantia = rs.getInt("garantia");
			return new Incidente(id, descricaoCurta, garantia);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair o incidente. Motivo: " + ex.getMessage());
		}
	}

}
