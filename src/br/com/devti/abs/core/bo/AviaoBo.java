package br.com.devti.abs.core.bo;


import java.util.List;

import br.com.devti.abs.core.dao.AviaoDao;
import br.com.devti.abs.core.entity.AviaoEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class AviaoBo {
	
public String salvarAviao(AviaoEntity aviao) throws NegocioException {
			
	validarAviao(aviao);
	
	AviaoDao avdao = new AviaoDao();
	return avdao.SalvarAviao(aviao);
			
}

public List<AviaoEntity> listarAviao() throws NegocioException{
	return new AviaoDao().listarAviao();
	
}

public void excluirAviao(String idAviao) throws NegocioException{
	new AviaoDao().excluirAviao(idAviao);
}

public AviaoEntity buscarAviaoPorId(String numeroIdent) throws NegocioException{
	return new AviaoDao().buscarAviaoPorId(numeroIdent);
	
}

public String alterarAviao(AviaoEntity aviao) throws NegocioException{
	
	validarAviao(aviao);
	
	return new AviaoDao().alterarAviao(aviao);
	
}

private void validarAviao(AviaoEntity aviao) throws NegocioException{
	
	
	if (aviao.getMarca() == null && !aviao.getMarca().equals("")) {		
		throw new NegocioException("A marca do avião precisa ser preenchida");
	}
	
	//fazer mais validações
	
}

}
