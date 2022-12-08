package br.com.devti.abs.core.service;

import java.util.List;

import br.com.devti.abs.core.bo.UsuarioBo;
import br.com.devti.abs.core.entity.UsuarioEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class UsuarioService {
	
	public String salvarUsuario( UsuarioEntity usuario) throws NegocioException {
		UsuarioBo bo = new UsuarioBo();
		
		return bo.salvarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarUsuario() throws NegocioException{
		return new UsuarioBo().listarUsuario();	
	}
	
	public void excluirUsuario(Long codigoUsuario) throws NegocioException{
		new UsuarioBo().excluirUsuario(codigoUsuario);
	}
	
	public UsuarioEntity buscarUsuarioPorId(Long codigoUsuario) throws NegocioException{
		return new UsuarioBo().buscarUsuarioPorId(codigoUsuario);
	}

	public String alterarUsuario(UsuarioEntity usuario) throws NegocioException{
		return new UsuarioBo().alterarUsuario(usuario);
	}
}
