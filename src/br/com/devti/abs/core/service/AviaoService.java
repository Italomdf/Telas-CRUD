package br.com.devti.abs.core.service;

import java.util.List;

import br.com.devti.abs.core.bo.AviaoBo;
import br.com.devti.abs.core.entity.AviaoEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class AviaoService {
	
	public String salvarAviao( AviaoEntity aviao) throws NegocioException {
		AviaoBo bo = new AviaoBo();
		
		return bo.salvarAviao(aviao);
	}
	
	public List<AviaoEntity> listarAviao() throws NegocioException{
		return new AviaoBo().listarAviao();	
	}
	
	public String alterarAviao(AviaoEntity aviao) throws NegocioException{
		return new AviaoBo().alterarAviao(aviao);
	}

	public void excluirAviao(String IdAviao) throws NegocioException{
		new AviaoBo().excluirAviao(IdAviao);
	}
	
	public AviaoEntity buscarAviaoPorId(String IdAviao) throws NegocioException{
		return new AviaoBo().buscarAviaoPorId(IdAviao);
	}
}
