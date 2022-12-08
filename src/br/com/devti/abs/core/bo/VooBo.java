package br.com.devti.abs.core.bo;

import java.util.List;

import br.com.devti.abs.core.dao.VooDao;
import br.com.devti.abs.core.entity.VooEntity;
import br.com.devti.abs.core.util.exception.NegocioException;

public class VooBo {
	
	
public String salvarVoo(VooEntity voo) throws NegocioException {
			
	validarVoo(voo);
	
	VooDao voodao = new VooDao();
	return voodao.SalvarVoo(voo);
			
}

public List<VooEntity> listarVoo() throws NegocioException{
	return new VooDao().listarVoo();
	
}

public void excluirVoo(String numVoo) throws NegocioException{
	new VooDao().excluirVoo(numVoo);
}

public VooEntity buscarVooPorNum(String numVoo) throws NegocioException{
	return new VooDao().buscarVooPorNum(numVoo);
	
}

public String alterarVoo(VooEntity voo) throws NegocioException{
	
	validarVoo(voo);
	
	return new VooDao().alterarVoo(voo);
	
}

private void validarVoo(VooEntity voo) throws NegocioException{
	
	
	if (voo.getDestino() == null && !voo.getDestino().equals("")) {		
		throw new NegocioException("O Destino do Voo precisa ser preenchida");
	}
	
	//fazer mais validações
	
}

}
