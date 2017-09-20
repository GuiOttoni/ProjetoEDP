package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.FeedbackCliente;
import conexao.ConexaoFactoryFeedback;

public class FeedbackDAO {
	private Connection con;

	public FeedbackDAO() throws Exception {
		con = new ConexaoFactoryFeedback().conectar();
	}
	
	public String fechar() throws Exception{
		con.close();
		return "Conexão fechada com sucesso.";
	}
	
	public String gravar(FeedbackCliente cli) throws Exception{

		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("INSERT INTO Feedback "
						+ "VALUES (Feedback_seq.nexval,?,?)");
		//estrutura.setInt(1, cli.getCodigo());
		//estrutura.setInt(2, cli.getCodigoCliente());
		//estrutura.setString(3, cli.getTexto());
		estrutura.setInt(1, cli.getCodigoCliente());
		estrutura.setString(2, cli.getTexto());
		estrutura.execute();
		estrutura.close();
		return "Obrigado pelo feedback";
	}
	
}
