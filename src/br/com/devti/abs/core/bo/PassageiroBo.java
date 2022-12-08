package br.com.devti.abs.core.bo;

import java.util.List;

import br.com.devti.abs.core.dao.PassageiroDao;
import br.com.devti.abs.core.entity.PassageiroEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class PassageiroBo extends UsuarioBo{
	
	public String salvarPassageiro(PassageiroEntity passageiro) throws NegocioException {

		validarPassageiro(passageiro);
		
		PassageiroDao udao = new PassageiroDao();
		return udao.SalvarPassageiro(passageiro);
				
	}
	
	public List<PassageiroEntity> listarPassageiro() throws NegocioException{
		return new PassageiroDao().listarPassageiro();
		
	}
	
	public void excluirPassageiro(Long codigoPassageiro) throws NegocioException{
		new PassageiroDao().excluirPassageiro(codigoPassageiro);
	}
	
	public PassageiroEntity buscarPassageiroPorId(Long codigoPassageiro) throws NegocioException{
		return new PassageiroDao().buscarPassageiroPorId(codigoPassageiro);
		
	}
	
	public String alterarPassageiro(PassageiroEntity passageiro) throws NegocioException{
		
		validarPassageiro(passageiro);
		
		return new PassageiroDao().alterarPassageiro(passageiro);
		
	}

	private void validarPassageiro(PassageiroEntity passageiro) throws NegocioException{
		
		
		if (passageiro.getCpf() == null && !passageiro.getCpf().equals("")) {		
			throw new NegocioException("O Cpf do passageiro precisa ser preenchido");
		}
		
		//fazer mais validações
		
	}

}
