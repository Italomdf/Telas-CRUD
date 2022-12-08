package br.com.devti.abs.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.abs.core.dao.connection.ConexaoMySQL;
import br.com.devti.abs.core.entity.AviaoEntity;
import br.com.devti.abs.core.util.exception.NegocioException;


public class AviaoDao {
	
	public String SalvarAviao(AviaoEntity aviao) throws NegocioException{
		
		String sql = "INSERT INTO aviao (MARCA_AV, BASE_AV, ANO_AV) VALUES (?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, aviao.getMarca());
			ps.setString(2, aviao.getBase());
			ps.setString(3, aviao.getAnoFabricacao());
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar Aviao");
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
		return "Avião Cadastrado no banco de dados com sucesso";
	}
	
	public List<AviaoEntity> listarAviao() throws NegocioException{
		String sql = "SELECT ID_AVIAO, MARCA_AV, BASE_AV, ANO_AV FROM aviao";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AviaoEntity> avioes = new ArrayList<AviaoEntity>();
			try {	
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					AviaoEntity avi = new AviaoEntity();
					avi.setNumeroIdentificador(rs.getString("ID_AVIAO"));
					avi.setMarca(rs.getString("MARCA_AV"));
					avi.setBase(rs.getString("BASE_AV"));
					avi.setAnoFabricacao(rs.getString("ANO_AV"));
					avioes.add(avi);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new NegocioException("Erro ao listar os aviões");
			}finally {
				try {
					ps.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			
		return avioes;
	}
	
	public String alterarAviao(AviaoEntity aviao) throws NegocioException{
		
		String sql = "UPDATE aviao SET MARCA_AV = ?, BASE_AV = ?, ANO_AV = ? WHERE ID_AVIAO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, aviao.getMarca());
			ps.setString(2, aviao.getBase());
			ps.setString(3, aviao.getAnoFabricacao());
			ps.setString(4, aviao.getNumeroIdentificador());
			
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Ocorreu um erro ao atualizar os dados do avião");
			
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O avião foi alterado com sucesso";
	}

	public void excluirAviao (String idAviao) throws NegocioException{
		
		String sql = "DELETE FROM aviao WHERE ID_AVIAO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, idAviao);
				
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o Avião");
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public AviaoEntity buscarAviaoPorId(String IdAviao) throws NegocioException{
		String sql = "SELECT ID_AVIAO, MARCA_AV, BASE_AV, ANO_AV FROM aviao WHERE ID_AVIAO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, IdAviao);
			
			rs = ps.executeQuery();
			
			AviaoEntity aviaoEncontrado = null;
			
			if(rs.next()) {
				aviaoEncontrado = new AviaoEntity();
				aviaoEncontrado.setNumeroIdentificador(rs.getString("ID_AVIAO"));
				aviaoEncontrado.setMarca(rs.getString("MARCA_AV"));
				aviaoEncontrado.setBase(rs.getString("BASE_AV"));
				aviaoEncontrado.setAnoFabricacao(rs.getString("ANO_AV"));
			}
			
			return aviaoEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Houve um erro ao buscar o avião");
		} finally {
			try {
				ps.close();
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
				
	}
	
}
