package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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
											+ "((SELECT NVL(MAX(Codigo), 0) + 1 FROM Chamado),?,?,?,?,?,?,?)");	
		
		estrutura.setInt(1, cli.getCodigo());
		estrutura.setString(2, cli.getNome());
		estrutura.setString(3, cli.getSobrenome());
		estrutura.setDate(4, new Date(cli.getDataNascimento().getTimeInMillis()));
		estrutura.setString(5, cli.getEndereco());
		estrutura.setString(6, cli.getCep());
		estrutura.setString(7, cli.getCidade());
		estrutura.setString(8, cli.getEstado());
	
	}
	
	public Cliente getCliente(int n) throws Exception{
		Cliente cli = new Cliente();
		PreparedStatement estutura = con.prepareStatement
				("SELECT * FROM CLIENTE WHERE CODIGO = ?");
		estrutura.setInt(1, n);
		
		
	}
	
	
	
	

}
