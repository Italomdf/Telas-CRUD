package br.com.devti.abs.core.bo;

import java.util.List;

import br.com.devti.abs.core.dao.UsuarioDao;
import br.com.devti.abs.core.entity.UsuarioEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class UsuarioBo {
	
	public String salvarUsuario(UsuarioEntity usuario) throws NegocioException {

		validarUsuario(usuario);
		
		UsuarioDao udao = new UsuarioDao();
		return udao.SalvarUsuario(usuario);
				
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException{
		return new UsuarioDao().listarUsuario();
		
	}
	
	public void excluirUsuario(Long codigoUsuario) throws NegocioException{
		new UsuarioDao().excluirUsuario(codigoUsuario);
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException{
		return new UsuarioDao().buscarUsuarioPorId(codigoUsuario);
		
	}
	
	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException{
		
		validarUsuario(usuario);
		
		return new UsuarioDao().alterarUsuario(usuario);
		
	}

	private void validarUsuario(UsuarioEntity usuario) throws NegocioException{
		
		
		if(!usuario.getEmail().contains("@")) {
			throw new NegocioException("Formato de email Invalido");
		}
		
		if (usuario.getNome() == null && !usuario.getNome().equals("")) {		
			throw new NegocioException("O nome do usuário precisa ser preenchido");
		}
		
		//fazer mais validações
		
	}
}
