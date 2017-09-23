package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactoryFeedback {

	public static Connection retornarConexao() throws Exception{
		return DriverManager.getConnection
			("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","RM75008","140297");
	}
}
