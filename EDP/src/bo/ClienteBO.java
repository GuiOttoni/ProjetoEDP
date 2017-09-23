package bo;

import beans.Cliente;
import dao.ClienteDAO;

public class ClienteBO {
	
	public static String cadastrarCliente(Cliente cli)throws Exception{
		if(cli.getNome().length() > 15){
			return "Nome grande demais";
		}
		
		if(cli.getSobrenome().length() > 15){
			return "Sobrenome grande demais";
		}
		
		if(cli.getCep().length() > 9){
			return "CEP inválido";
		}
		
		if(cli.getEstado().length() > 2){
			return "Estado inválido";
		}
		
		try
		{
			ClienteDAO dao = new ClienteDAO();
			dao.inserir(cli);
		} catch(Exception e) {
			return "Erro ao cadastrar";
		}
	
		return "Cliente Cadastrado com sucesso.";	
	}

}
