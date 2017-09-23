package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import beans.Cliente;
import conexao.ConexaoFactory;

public class ClienteDAO {
	private Connection con;
	
	public ClienteDAO() throws Exception {
		con = ConexaoFactory.retornarConexao();
	}
	
	public String inserir(Cliente cli) throws Exception{
		PreparedStatement estrutura = null;
		estrutura = con.prepareStatement("INSERT INTO Cliente"
											+ "(Codigo, Nome, Sobrenome, DataNascimento, Endereco, Cep, Cidade, Estado) VALUES"
											+ "(Cliente_seq.nextval,?,?,?,?,?,?,?)");	
		
		estrutura.setInt(1, cli.getCodigo());
		estrutura.setString(2, cli.getNome());
		estrutura.setString(3, cli.getSobrenome());
		estrutura.setDate(4, new Date(cli.getDataNascimento().getTimeInMillis()));
		estrutura.setString(5, cli.getEndereco());
		estrutura.setString(6, cli.getCep());
		estrutura.setString(7, cli.getCidade());
		estrutura.setString(8, cli.getEstado());
		return "Inserido com sucesso";
	
	}
	
	public Cliente getCliente(int n) throws Exception{
		Cliente cli = new Cliente();
		PreparedStatement estrutura = con.prepareStatement
				("SELECT * FROM CLIENTE WHERE CODIGO = ?");
		estrutura.setInt(1, n);
		ResultSet resultado = estrutura.executeQuery();
		if(resultado.next()){
			cli.setCodigo(resultado.getInt("Codigo"));
			cli.setNome(resultado.getString("Nome"));
			cli.setSobrenome(resultado.getString("Sobrenome"));
			Calendar c = Calendar.getInstance();
			c.setTime(resultado.getDate("DataNascimento"));
			cli.setDataNascimento(c);
			cli.setEndereco(resultado.getString("Endereco"));
			cli.setCep(resultado.getString("Cep"));
			cli.setCidade(resultado.getString("Cidade"));
			cli.setEstado(resultado.getString("Estado"));
		}
		resultado.close();
		estrutura.close();
		return cli;
	}
	
	
	public int delete(int num) throws Exception{
		PreparedStatement estrutura = con.prepareStatement
				("DELETE FROM CLIENTE WHERE CODIGO = ?");
		estrutura.setInt(1, num);
		int i = estrutura.executeUpdate();
		estrutura.close();
		return i;
	}
	
	public String uparNivel(Cliente cli)throws Exception{
		PreparedStatement estrutura = con.prepareStatement
				("UPDATE CLIENTE SET"
						+ "Nome = ?,"
						+ "Sobrenome = ?,"
						+ "DataNascimento = ?,"
						+ "Endereco = ?,"
						+ "Cep = ?,"
						+ "Cidade = ?,"
						+ "Estado = ? WHERE CODIGO =?");

		estrutura.setString(1, cli.getNome());
		estrutura.setString(2, cli.getSobrenome());
		estrutura.setDate(3, new Date(cli.getDataNascimento().getTimeInMillis()));
		estrutura.setString(4, cli.getEndereco());
		estrutura.setString(5, cli.getCep());
		estrutura.setString(6, cli.getCidade());
		estrutura.setString(7, cli.getEstado());
		return "Atualizado com sucesso";			
	}
		

}
