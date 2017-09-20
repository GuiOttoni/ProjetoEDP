package bo;

import beans.Regiao;
import dao.RegiaoDAO;

public class RegiaoBO {
	
	public static String adicionarRegiao(Regiao reg) throws Exception{
		if (reg.getNome().length() > 255){
			return "Nome grande demais";
		}
			
		RegiaoDAO dao = new RegiaoDAO();
		
		if(dao.getNome(reg.getCodigo())> 0){
			dao.fechar();
			return "Cliente já existe";
		}
		String msgRetorno = dao.gravar(reg);
		dao.fechar();
		return msgRetorno;
	}
		
		public static Regiao consultaRegiaoPorCodigo(int codigo) throws Exception{
			if(codigo < 1){
				return new Regiao();
			}
			
			RegiaoDAO dao = new RegiaoDAO();
			Regiao reg = dao.getCodigo(codigo);
			dao.fechar();
			return reg;
		}
		
		
		public static int excluirPorCodigo(int codigo) throws Exception{
			if(codigo < 1){
				throw new RuntimeException();
			}
			
			RegiaoDAO dao = new RegiaoDAO();
			int retorno= dao.delete(codigo);
			dao.fechar();
			return retorno;
		}
		
	}
		
		
	
	
}
