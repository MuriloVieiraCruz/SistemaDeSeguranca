package br.com.senai.core.dao.postgresql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.com.senai.core.dao.DaoOcorrencia;
import br.com.senai.core.dao.ManagerDb;
import br.com.senai.core.domain.Ocorrencia;

public class DaoPostgresqlOcorrencia implements DaoOcorrencia {

	private final String INSERT = "INSERT INTO ocorrencias (data, detalhamento, "
			+ " id_envolvido, id_incidente, id_colaborador)"
			+ " VALUES (?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE ocorrencias SET data = ?,"
			+ " detalhamento = ?, id_envolvido = ?, id_incidente = ?,"
			+ " id_colaborador = ? WHERE id = ?";
	private final String DELETE = "DELETE FROM ocorrencias WHERE id_envolvidos = ? ";
	
	//private final String SELECT_BY_ID = "SELECT id, data, detalhamento, "
			//+ " id_envolvido, id_incidente, id_colaborador FROM"
			//+ " ocorrencias WHERE id = ?";
	
	private final String SELECT_BY_ID = "SELECT oco.id_envolvido, envo.nome_completo,"
			+ " inci.descricao_curta "
			+ " FROM ocorrencias AS oco,"
			+ "     envolvidos AS envo, " 
			+ "     incidentes AS inci"
			+ " WHERE oco.id_envolvido = envo.id AND"
			+ " oco.id_incidente = inci.id AND"
			+ " oco.id_envolvido = ?";
	
	private final String SELECT_BY_DESC = "SELECT id, data, detalhamento,"
			+ " id_envolvido, id_incidente, id_colaborador FROM"
			+ " ocorrencias WHERE id_envolvido = ?";
	
	private Connection conexao;
	
	public DaoPostgresqlOcorrencia() {
		this.conexao = ManagerDb.getInstance().getConexao();
	}

	@Override
	public void inserir(Ocorrencia ocorrencia) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT);
			ps.setString(1, ocorrencia.getDetalhamento());
			ps.setDate(2, Date.valueOf(ocorrencia.getData()));
			ps.execute();
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na inserção"
					+ " da ocorrência. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public void alterar(Ocorrencia ocorrencia) {
		PreparedStatement ps = null;
		try {
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, false);
			ps = conexao.prepareStatement(UPDATE);
			ps.setString(1, ocorrencia.getDetalhamento());
			ps.setDate(2, Date.valueOf(ocorrencia.getData()));
			ps.setInt(3, ocorrencia.getId());
			boolean isAlteracaoOK = ps.executeUpdate() == 1;
			if (isAlteracaoOK) {
				this.conexao.commit();
			} else {
				this.conexao.rollback();
			}
			ManagerDb.getInstance().configurarAutoCommitDa(conexao, true);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro na edição"
					+ " da ocorrencia. Motivo: " + ex.getMessage());
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
			throw new RuntimeException("Ocorreu um erro "
					+ " ao excluir a ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
		}
		
	}

	@Override
	public Ocorrencia buscarPor(int id) {
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
			throw new RuntimeException("Ocorreu um erro ao buscar"
					+ " a ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
		
	}

	@Override
	public List<Ocorrencia> listarPor(String envolvido) {
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(SELECT_BY_DESC);
			ps.setString(1, envolvido);
			rs = ps.executeQuery();
			while (rs.next()) {
				ocorrencias.add(extrairDo(rs));
			}
			return ocorrencias;
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao listar"
					+ " a ocorrencia. Motivo: " + ex.getMessage());
		} finally {
			ManagerDb.getInstance().fechar(ps);
			ManagerDb.getInstance().fechar(rs);
		}
	}
	
	private Ocorrencia extrairDo(ResultSet rs) {
		try {
			int id = rs.getInt("id");
			LocalDate data = rs.getDate("data").toLocalDate();
			String detalhamento = rs.getString("detalhamento");
			return new Ocorrencia(id, data, detalhamento);
		} catch (Exception ex) {
			throw new RuntimeException("Ocorreu um erro ao "
					+ "extrair a ocorrencia. Motivo: " + ex.getMessage());
		}

	}
	
	

}
