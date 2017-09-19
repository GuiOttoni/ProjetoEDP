package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import beans.Chamado;
import conexao.ConexaoFactory;

public class ChamadoDAO {
	private Connection connection;
	
	public ChamadoDAO() throws Exception {
		this.connection = ConexaoFactory.retornarConexao();
	}

	public String gravar(Chamado chamado) throws SQLException {
		String sqlInsert = 
				"INSERT INTO Chamado (Codigo, CodigoRegiao, DataHoraCadastro, DataHoraFinalizado, DescricaoChamado)" 
				+ "VALUES "
				+ "((SELECT NVL(MAX(Codigo), 0) + 1 FROM Chamado), ?, ?, ?, ?);";
		
		PreparedStatement statement = connection.prepareStatement(sqlInsert);
		
		statement.setInt(1, chamado.getCodigoRegiao());
		statement.setDate(2, new Date(chamado.getDataHoraCadastro().getTimeInMillis()));
		statement.setDate(3, new Date(chamado.getDataHoraFinalizado().getTimeInMillis()));
		statement.setString(3, chamado.getDescricaoChamado());
		
		statement.execute();
		statement.close();
		
		return "Sucesso!";
	}
	
	public Chamado retornarChamado() throws SQLException {
		String sqlSelect = 
				"SELECT * FROM Chamado WHERE Codigo = ?";
		
		PreparedStatement statement = connection.prepareStatement(sqlSelect);
		
		ResultSet resultSet = statement.executeQuery();
		
		Chamado chamado = null;
		
		if(resultSet.next()) {
			int codigo = resultSet.getInt(1);
			int codigoRegiao = resultSet.getInt(2);
			
			Calendar dataCadastro = new GregorianCalendar();
			dataCadastro.setTime(resultSet.getDate(3));
			
			Calendar dataFinalizado = new GregorianCalendar();
			dataCadastro.setTime(resultSet.getDate(4));
			
			String descricaoChamado = resultSet.getString(5);
		
			chamado = new Chamado(codigo, codigoRegiao, dataCadastro, dataFinalizado, descricaoChamado);
		}

		statement.close();
		
		return chamado;
	}
	
	
	
}
