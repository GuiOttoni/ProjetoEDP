package bo;

import javax.swing.JOptionPane;

import beans.Instalacao;
import dao.InstalacaoDAO;

public class InstalacaoBO {

	public static String cadastrarInstalacao(Instalacao inst) throws Exception{
		try{
			if(inst.getCodCliente() == 0){
				return null;
			}
			InstalacaoDAO dao = new InstalacaoDAO();
			return dao.cadastrarInstalacao(inst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String removerInstalacao(int idInstalacao) throws Exception{
		try{
			if(idInstalacao == 0){
				return null;
			}
			InstalacaoDAO dao = new InstalacaoDAO();
			return dao.deletarInstalacao(idInstalacao);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
