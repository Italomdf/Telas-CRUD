package br.com.devti.abs.core.bo;

import br.com.devti.abs.core.dao.GrupoUsuarioDao;
import br.com.devti.abs.core.entity.GrupoUsuarioEntity;


public class GrupoUsuarioBo {
	
	public String salvarGrupoUsuario(GrupoUsuarioEntity grupousuario) {
		
		if (grupousuario.getNomeGrupo() == null && !grupousuario.getNomeGrupo().equals("")) {		
			return "O nome do usuário precisa ser preenchido";
		}
		
		GrupoUsuarioDao gudao = new GrupoUsuarioDao();
		return gudao.salvarGrupoUsuario(grupousuario);
		
		//fazer mais validações
		
		
	}

}
