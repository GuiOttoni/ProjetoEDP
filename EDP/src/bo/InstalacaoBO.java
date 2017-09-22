package bo;

import java.util.List;

import beans.Instalacao;
import dao.InstalacaoDAO;

public class InstalacaoBO {

	public static String cadastrarInstalacao(Instalacao inst) throws Exception{
		try{
			if(inst.getCodCliente() == 0)
				return null;
			
			InstalacaoDAO dao = new InstalacaoDAO();
			return dao.cadastrarInstalacao(inst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String removerInst(int idInstalacao) throws Exception{
		try{
			if(idInstalacao == 0)
				return null;
			
			InstalacaoDAO dao = new InstalacaoDAO();
			return dao.deletarInstalacao(idInstalacao);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String alterarInstalacao(int idInstalacao, Instalacao inst) throws Exception{
		try{
			if(inst.getCodCliente() == 0)
				return null;
			
			InstalacaoDAO dao = new InstalacaoDAO();
			return dao.alterarInstalacao(idInstalacao, inst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Instalacao> getInstPorRegiao(int idRegiao) throws Exception{
		try{
			if(idRegiao == 0)
				return null;
			
			InstalacaoDAO dao = new InstalacaoDAO();
			return dao.getInstPorRegiao(idRegiao);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
