package bo;

import beans.Chamado;
import dao.ChamadoDAO;

public class ChamadoBO {

	public static String cadastrarChamado(Chamado chamado) {

		if(chamado.getCodigoRegiao() == 0)
			return "Codigo da região inválido";
		
		if(chamado.getDescricaoChamado() == null || chamado.getDescricaoChamado().isEmpty())
			return "Descrição inválida";
		
		
		try {
			new ChamadoDAO().gravar(chamado);	
		} catch (Exception e) {
			return "Erro ao cadastrar!";
		}
		
		return "Sucesso";
	}
	
}
