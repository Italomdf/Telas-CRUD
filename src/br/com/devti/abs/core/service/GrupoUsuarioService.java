package br.com.devti.abs.core.service;

import br.com.devti.abs.core.bo.GrupoUsuarioBo;
import br.com.devti.abs.core.entity.GrupoUsuarioEntity;

public class GrupoUsuarioService {
	
	
	public String salvarGrupoUsuario( GrupoUsuarioEntity grupousuario) {
		GrupoUsuarioBo gbo = new GrupoUsuarioBo();
		
		return gbo.salvarGrupoUsuario(grupousuario);
	}

}
