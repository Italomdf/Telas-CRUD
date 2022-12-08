package br.com.devti.abs.core.service;

import java.util.List;

import br.com.devti.abs.core.bo.VooBo;
import br.com.devti.abs.core.entity.VooEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class VooService {
	
	public String salvarVoo( VooEntity voo) throws NegocioException {
		VooBo bo = new VooBo();
		
		return bo.salvarVoo(voo);
	}
	
	public List<VooEntity> listarVoo() throws NegocioException{
		return new VooBo().listarVoo();	
	}
	
	public String alterarVoo(VooEntity voo) throws NegocioException{
		return new VooBo().alterarVoo(voo);
	}

	public void excluirVoo(String numVoo) throws NegocioException{
		new VooBo().excluirVoo(numVoo);
	}
	
	public VooEntity buscarVooPorNum(String numVoo) throws NegocioException{
		return new VooBo().buscarVooPorNum(numVoo);
	}

}
