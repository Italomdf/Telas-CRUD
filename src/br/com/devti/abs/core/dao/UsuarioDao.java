package br.com.devti.abs.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.abs.core.dao.connection.ConexaoMySQL;
import br.com.devti.abs.core.entity.UsuarioEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class UsuarioDao {
	
	public String SalvarUsuario(UsuarioEntity usuario) throws NegocioException{
		
		String sql = "INSERT INTO usuario (TIPO_USU, NOME_USU, LOGIN_USU, SENHA_USU, EMAIL_USU) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1,"USU");
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getLogin());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getEmail());
			
			ps.execute();
		
		} catch (SQLException e) {
			throw new NegocioException("Erro ao cadastrar Usuario");
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
		return "Usuario Cadastrado no banco de dados com sucesso";
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException{
		String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, SENHA_USU, EMAIL_USU FROM usuario";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
			try {	
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					UsuarioEntity usu = new UsuarioEntity();
					usu.setCodigo(rs.getLong("ID_USUARIO"));
					usu.setNome(rs.getString("NOME_USU"));
					usu.setLogin(rs.getString("LOGIN_USU"));
					usu.setSenha(rs.getString("SENHA_USU"));
					usu.setEmail(rs.getString("EMAIL_USU"));
					usuarios.add(usu);
				}
				
			}catch(SQLException e) {
				throw new NegocioException("Erro ao listar os usuários");
			}finally {
				try {
					ps.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			
		return usuarios;
	}
	
	public void excluirUsuario (Long codigoUsuario) throws NegocioException{
		
		String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoUsuario);
				
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o Usuário");
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException{
		String sql = "SELECT ID_USUARIO, NOME_USU, LOGIN_USU, SENHA_USU, EMAIL_USU FROM usuario WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setLong(1, codigoUsuario);
			
			rs = ps.executeQuery();
			
			UsuarioEntity usuarioEncontrado = null;
			
			if(rs.next()) {
				usuarioEncontrado = new UsuarioEntity();
				usuarioEncontrado.setCodigo(rs.getLong("ID_USUARIO"));
				usuarioEncontrado.setNome(rs.getString("NOME_USU"));
				usuarioEncontrado.setLogin(rs.getString("LOGIN_USU"));
				usuarioEncontrado.setSenha(rs.getString("SENHA_USU"));
				usuarioEncontrado.setEmail(rs.getString("EMAIL_USU"));
			}
			
			return usuarioEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Houve um erro ao buscar o usuário");
		} finally {
			try {
				ps.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				
	}
	
	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException{
		
		String sql = "UPDATE usuario SET NOME_USU = ?, LOGIN_USU = ?, SENHA_USU = ?, EMAIL_USU = ? WHERE ID_USUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			ps.setLong(5, usuario.getCodigo());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados de usuário");
			
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O usuário foi alterado com sucesso";
	}

}
