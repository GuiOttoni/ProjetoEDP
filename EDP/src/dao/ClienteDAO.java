package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.Cliente;
import conexao.ConexaoFactory;

public class ClienteDAO {
	private Connection con;

	public ClienteDAO() throws Exception {
		con = new ConexaoFactory().conectar();
	}
	
	public String fechar() throws Exception{
		con.close();
		return "Conexão fechada com sucesso.";
	}
	
	public String gravar(Cliente cli) throws Exception{

		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("INSERT INTO Feedback "
						+ "(Codigo, CodigoCliente, Texto) VALUES"
						+ " (?,?,?)");
		estrutura.setInt(1, cli.getCodigo());
		estrutura.setInt(2, cli.getCodigoCliente());
		estrutura.setString(3, cli.getTexto());
		estrutura.execute();
		estrutura.close();
		return "Obrigado pelo feedback";
	}
}
