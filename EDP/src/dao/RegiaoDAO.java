 package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
						+ "(Nome) VALUES"+ " (?)");
		estrutura.setString(1, reg.getNome());
		estrutura.execute();
		estrutura.close();
		return "Gravado com sucesso";
	}

	public Regiao getCliente(int n) throws Exception{
		Regiao reg = new Regiao();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT * FROM Regiao WHERE Codigo = ?");
		estrutura.setInt(1, n);
		ResultSet resultado = estrutura.executeQuery();
		if(resultado.next()){
			reg.setNome(resultado.getString("NM_CLIENTE"));
		}
		System.out.println("pegou e " + reg.getNome());
		resultado.close();
		estrutura.close();
		return reg;
	}

	public int delete(int num)throws Exception{
		PreparedStatement estrutura = 
				con.prepareStatement
				("DELETE FROM TB_TAP_CLIENTE WHERE NR_CLIENTE = ?");
		estrutura.setInt(1, num);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
	public int uparNivel(int num)throws Exception{
		PreparedStatement estrutura = 
				con.prepareStatement
				("UPDATE TB_TAP_CLIENTE SET QT_ESTRELAS="
						+ "QT_ESTRELAS+1 WHERE NR_CLIENTE=?");
		estrutura.setInt(1, num);
		int x = estrutura.executeUpdate();
		estrutura.close();
		return x;
	}
	public List<Regiao> listarPorNome(String n)throws Exception{
		List<Regiao> lista = new ArrayList<Regiao>();
		Regiao obj = new Regiao();
		PreparedStatement estrutura = 
				con.prepareStatement
				("SELECT * FROM TB_TAP_CLIENTE WHERE NM_CLIENTE LIKE ?");
		estrutura.setString(1, "%" + n + "%");
		ResultSet resultado = estrutura.executeQuery();
		while(resultado.next()){
			obj = new Regiao();
			obj.setNome(resultado.getString("NM_CLIENTE"));
			lista.add(obj);
		}
		resultado.close();
		estrutura.close();
		return lista;
	}
	
	
	
}
