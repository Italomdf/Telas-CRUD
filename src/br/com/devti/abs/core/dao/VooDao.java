package br.com.devti.abs.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.devti.abs.core.dao.connection.ConexaoMySQL;
import br.com.devti.abs.core.entity.VooEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class VooDao {
	
	public String SalvarVoo(VooEntity voo) throws NegocioException{
		
		String sql = "INSERT INTO voo (DATA_VOO, DESTINO_VOO, ORIGEM_VOO) VALUES (?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, voo.getData());
			ps.setString(2, voo.getDestino());
			ps.setString(3, voo.getOrigem());
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao cadastrar Voo");
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
		return "Voo Cadastrado no banco de dados com sucesso";
	}
	
	public List<VooEntity> listarVoo() throws NegocioException{
		String sql = "SELECT NUMERO_VOO, DATA_VOO, DESTINO_VOO, ORIGEM_VOO FROM voo";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<VooEntity> voos = new ArrayList<VooEntity>();
			try {	
				ps = ConexaoMySQL.getConexao().prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					VooEntity voo = new VooEntity();
					voo.setNumeroVoo(rs.getString("NUMERO_VOO"));
					voo.setData(rs.getString("DATA_VOO"));
					voo.setDestino(rs.getString("DESTINO_VOO"));
					voo.setOrigem(rs.getString("ORIGEM_VOO"));
					voos.add(voo);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new NegocioException("Erro ao listar os voos");
			}finally {
				try {
					ps.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			
		return voos;
	}
	
	public String alterarVoo(VooEntity voo) throws NegocioException{
		
		String sql = "UPDATE voo SET DATA_VOO = ?, DESTINO_VOO = ?, ORIGEM_VOO = ? WHERE NUMERO_VOO	 = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, voo.getData());
			ps.setString(2, voo.getDestino());
			ps.setString(3, voo.getOrigem());
			ps.setString(4, voo.getNumeroVoo());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Ocorreu um erro ao atualizar os dados do voo");
			
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return "O voo foi alterado com sucesso";
	}

	public void excluirVoo (String numVoo) throws NegocioException{
		
		String sql = "DELETE FROM voo WHERE NUMERO_VOO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, numVoo);
				
			ps.execute();
			
		} catch (SQLException e) {
			throw new NegocioException("Não foi possível excluir o Voo");
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public VooEntity buscarVooPorNum(String numVoo) throws NegocioException{
		String sql = "SELECT NUMERO_VOO, DATA_VOO, DESTINO_VOO, ORIGEM_VOO FROM voo WHERE NUMERO_VOO = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConexaoMySQL.getConexao().prepareStatement(sql);
			ps.setString(1, numVoo);
			
			rs = ps.executeQuery();
			
			VooEntity vooEncontrado = null;
			
			if(rs.next()) {
				vooEncontrado = new VooEntity();
				vooEncontrado.setNumeroVoo(rs.getString("NUMERO_VOO"));
				vooEncontrado.setData(rs.getString("DATA_VOO"));
				vooEncontrado.setDestino(rs.getString("DESTINO_VOO"));
				vooEncontrado.setOrigem(rs.getString("ORIGEM_VOO"));
			}
			
			return vooEncontrado;
			
		} catch (SQLException e) {
			throw new NegocioException("Houve um erro ao buscar o voo");
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
