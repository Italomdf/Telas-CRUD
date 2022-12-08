package br.com.devti.abs.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.abs.core.dao.connection.ConexaoMySQL;
import br.com.devti.abs.core.entity.PassageiroEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class PassageiroDao extends UsuarioDao{
	
	public String SalvarPassageiro(PassageiroEntity passageiro) throws NegocioException{
		
		String sql = "INSERT INTO usuario (TIPO_USU, NOME_USU, LOGIN_USU, SENHA_USU, EMAIL_USU, CPF_PASS, IDADE_PASS) VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, "PASS");
			ps.setString(2, passageiro.getNome());
			ps.setString(3, passageiro.getLogin());
			ps.setString(4, passageiro.getSenha());
			ps.setString(5, passageiro.getEmail());
			ps.setString(6, passageiro.getCpf());
			ps.setInt(7, passageiro.getIdade());
			
			ps.execute();
		
		} catch (SQLException e) {
			throw new NegocioException("Erro ao cadastrar Passageiro");
			//e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		//implementar o cadastro no banco de dados
		return "Passageiro Cadastrado no banco de dados com sucesso";
	}

public List<PassageiroEntity> listarPassageiro() throws NegocioException{
	
	String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, SENHA_USU, EMAIL_USU, CPF_PASS, IDADE_PASS FROM usuario WHERE TIPO_USU = 'PASS'";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	List<PassageiroEntity> passageiros = new ArrayList<PassageiroEntity>();
		try {	
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				PassageiroEntity pass = new PassageiroEntity();
				pass.setCodigo(rs.getLong("ID_USUARIO"));
				pass.setNome(rs.getString("NOME_USU"));
				pass.setLogin(rs.getString("LOGIN_USU"));
				pass.setSenha(rs.getString("SENHA_USU"));
				pass.setEmail(rs.getString("EMAIL_USU"));
				pass.setCpf(rs.getString("CPF_PASS"));
				pass.setIdade(rs.getInt("IDADE_PASS"));
				passageiros.add(pass);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao listar os passageiros");
		}finally {
			try {
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	return passageiros;
}

public void excluirPassageiro (Long codigoPassageiro) throws NegocioException{
	
	String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";
	
	PreparedStatement ps = null;
	
	try {
		ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		ps.setLong(1, codigoPassageiro);
			
		ps.execute();
		
	} catch (SQLException e) {
		throw new NegocioException("Não foi possível excluir o Passageiro");
	} finally {
		try {
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

public PassageiroEntity buscarPassageiroPorId(Long codigoPassageiro) throws NegocioException{
	
	String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, SENHA_USU, EMAIL_USU, CPF_PASS, IDADE_PASS FROM usuario WHERE ID_USUARIO = ?";
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		ps.setLong(1, codigoPassageiro);
		
		rs = ps.executeQuery();
		
		PassageiroEntity passageiroEncontrado = null;
		
		if(rs.next()) {
			passageiroEncontrado = new PassageiroEntity();
			passageiroEncontrado.setCodigo(rs.getLong("ID_USUARIO"));
			passageiroEncontrado.setNome(rs.getString("NOME_USU"));
			passageiroEncontrado.setLogin(rs.getString("LOGIN_USU"));
			passageiroEncontrado.setSenha(rs.getString("SENHA_USU"));
			passageiroEncontrado.setEmail(rs.getString("EMAIL_USU"));
			passageiroEncontrado.setCpf(rs.getString("CPF_PASS"));
			passageiroEncontrado.setIdade(rs.getInt("IDADE_PASS"));
		}
		
		return passageiroEncontrado;
		
	} catch (SQLException e) {
		throw new NegocioException("Houve um erro ao buscar o passageiro");
	} finally {
		try {
			ps.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
			
}

public String alterarPassageiro(PassageiroEntity passageiro) throws NegocioException{
	
	String sql = "UPDATE usuario SET NOME_USU = ?, LOGIN_USU = ?, SENHA_USU = ?, EMAIL_USU = ?, CPF_PASS = ?, IDADE_PASS = ? WHERE ID_USUARIO = ?";
	
	PreparedStatement ps = null;
	
	try {
		ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		
		ps.setString(1, passageiro.getNome());
		ps.setString(2, passageiro.getLogin());
		ps.setString(3, passageiro.getSenha());
		ps.setString(4, passageiro.getEmail());
		ps.setString(5, passageiro.getCpf());
		ps.setInt(6, passageiro.getIdade());
		ps.setLong(7, passageiro.getCodigo());
		
		ps.execute();
		
	} catch (SQLException e) {
		throw new NegocioException("Ocorreu um erro ao atualizar os dados de passageiro");
		
	} finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return "O passageiro foi alterado com sucesso";
	
}

}
