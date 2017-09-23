package bo;

//import java.sql.PreparedStatement;
import beans.Regiao;
//import conexao.ConexaoFactory;
import dao.RegiaoDAO;

public class RegiaoBO {
	
	public static String adicionarRegiao(Regiao reg) throws Exception{
		if (reg.getNome().length() > 255){
			return "Nome grande demais";
		}
		
		if(reg.getCodigo() == 0){
			return "Código de região Inválida";
		}
		
		RegiaoDAO dao = new RegiaoDAO();
		
		String msgRetorno = dao.gravar(reg);
		dao.fechar();
		return msgRetorno;
	}
		
		public static Regiao consultaRegiaoPorCodigo(int codigo) throws Exception{
			if(codigo < 1){
				return new Regiao();
			}
			
			RegiaoDAO dao = new RegiaoDAO();
			Regiao retorno = dao.consultaPorCodigo(codigo);
			dao.fechar();
			return retorno;
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
		
		
		public static int alterarPorCodigo(int cod)throws Exception{
			
			return new RegiaoDAO().atualizar(cod);
            
		}
		
		
	}
		
		
	

