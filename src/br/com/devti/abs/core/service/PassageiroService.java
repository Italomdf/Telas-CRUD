package br.com.devti.abs.core.service;

import java.util.List;

import br.com.devti.abs.core.bo.PassageiroBo;
import br.com.devti.abs.core.entity.PassageiroEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class PassageiroService extends UsuarioService{
	
	public String salvarPassageiro( PassageiroEntity passageiro) throws NegocioException {
		PassageiroBo bo = new PassageiroBo();
		
		return bo.salvarPassageiro(passageiro);
	}
	
	public List<PassageiroEntity> listarPassageiro() throws NegocioException{
		return new PassageiroBo().listarPassageiro();	
	}
	
	public void excluirPassageiro(Long codigoPassageiro) throws NegocioException{
		new PassageiroBo().excluirPassageiro(codigoPassageiro);
	}
	
	public PassageiroEntity buscarPassageiroPorId(Long codigoPassageiro) throws NegocioException{
		return new PassageiroBo().buscarPassageiroPorId(codigoPassageiro);
	}

	public String alterarPassageiro(PassageiroEntity passageiro) throws NegocioException{
		return new PassageiroBo().alterarPassageiro(passageiro);
	}

}
