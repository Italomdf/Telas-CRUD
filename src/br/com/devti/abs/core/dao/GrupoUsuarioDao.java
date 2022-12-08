package br.com.devti.abs.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.devti.abs.core.dao.connection.ConexaoMySQL;
import br.com.devti.abs.core.entity.GrupoUsuarioEntity;

public class GrupoUsuarioDao {
	
	public String salvarGrupoUsuario(GrupoUsuarioEntity grupousuario){
	
	String sql = "INSERT INTO grupo_usuario (GP_NOME,GP_ACESSO) VALUES (?,?)";
	
	PreparedStatement ps = null;
	
	try {
		ps = ConexaoMySQL.getConexao().prepareStatement(sql);
		ps.setString(1, grupousuario.getNomeGrupo());
		ps.setString(2, grupousuario.getAcesso());

		
		ps.execute();
	
	} catch (SQLException e) {
		return "Erro ao cadastrar Usuario";
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
	return "Grupo de Usuario Cadastrado no banco de dados com sucesso";
}

}
