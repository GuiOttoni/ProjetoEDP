package bo;

import beans.Chamado;
import dao.ChamadoDAO;

public class ChamadoBO {

	public static String cadastrarChamado(Chamado chamado) {

		if(chamado.getCodigoRegiao() == 0)
			return "Codigo da regi�o inv�lido";
		
		if(chamado.getDescricaoChamado() == null || chamado.getDescricaoChamado().isEmpty())
			return "Descri��o inv�lida";
		
		
		try {
			new ChamadoDAO().gravar(chamado);	
		} catch (Exception e) {
			return "Erro ao cadastrar!";
		}
		
		return "Sucesso";
	}
	
}
