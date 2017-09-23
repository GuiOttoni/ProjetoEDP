package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Regiao;
import conexao.ConexaoFactory;

public class RegiaoDAO {

	private Connection con;
	
	public RegiaoDAO() throws Exception {
		con = new ConexaoFactory().conectar();
	}

	public String fechar() throws Exception{
		con.close();
		return "Fechado com sucesso!";
	}
	public String gravar(Regiao reg) throws Exception{

		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement
				("INSERT INTO Regiao "
						+ "(Nome) VALUES (Regiao_seq.nextval,Campo1,Campo2,...);"+ " (?)");
		estrutura.setString(1, reg.getNome());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";
	}
	
	public Regiao consultaPorCodigo(int n) throws Exception{
		PreparedStatement estrutura = con.prepareStatement("SELECT * FROM Regiao WHERE Codigo = ?");
		estrutura.setInt(1, n);
		ResultSet resultado = estrutura.executeQuery();
		Regiao reg = new Regiao();
		
		if(resultado.next()){
			reg.setNome(resultado.getString("Nome"));
		}
		
		return reg;
	}
	
	public Regiao getCliente(int n) throws Exception{
		Regiao reg = new Regiao();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT * FROM Regiao WHERE Codigo = ?");
		estrutura.setInt(1, n);
		ResultSet resultado = estrutura.executeQuery();
		if(resultado.next()){
			reg.setNome(resultado.getString("Nome"));
		}
		System.out.println("pegou e " + reg.getNome());
		resultado.close();
		estrutura.close();
		return reg;
	}

	public int delete(int num)throws Exception{
		PreparedStatement estrutura = 
				con.prepareStatement
				("DELETE FROM Regiao WHERE Nome = ?");
		estrutura.setInt(1, num);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
	
	public List<Regiao> listarPorNome(String n)throws Exception{
		List<Regiao> lista = new ArrayList<Regiao>();
		Regiao obj = new Regiao();
		PreparedStatement estrutura = 
				con.prepareStatement
				("SELECT * FROM Regiao WHERE Nome LIKE ?");
		estrutura.setString(1, "%" + n + "%");
		ResultSet resultado = estrutura.executeQuery();
		while(resultado.next()){
			obj = new Regiao();
			obj.setNome(resultado.getString("Nome"));
			lista.add(obj);
		}
		resultado.close();
		estrutura.close();
		return lista;
	}
	

    public int atualizar(int cod) throws Exception{
         PreparedStatement stmt = con.prepareStatement ("UPDATE Regiao WHERE Codigo = ?");
         int retorno = stmt.executeUpdate();
         stmt.close();
         return retorno;
         
    }





	
	
}
