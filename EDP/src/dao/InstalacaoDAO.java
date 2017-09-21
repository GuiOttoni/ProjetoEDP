package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import beans.Instalacao;
import conexao.ConexaoFactory;

public class InstalacaoDAO {
	private Connection con;
	
	public InstalacaoDAO() throws Exception{
		con = new ConexaoFactory().conectar();
	}
	
	public void fechar() throws SQLException{
		con.close();
	}	
	
	public String cadastrarInstalacao(Instalacao inst) throws SQLException{
		PreparedStatement ps = null;
		int idx = 0;
		try{
			ps = con.prepareStatement(" INSERT INTO Instalacao "
				+ "values(SEQUENCE_EDP.Nextval,?,?) ");
			ps.setInt(++idx, inst.getCodCliente());
			ps.setInt(++idx, inst.getCodRegiao());
			ps.execute();
			ps.close();
			con.close();
			return "Cadastrado!";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps != null){
				try{
					ps.close();
				}catch(Exception e){}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e){
					
				}
			}
		}
		return "Não cadastrado";
	}
	
	public String deletarInstalacao(int idInstalacao) throws SQLException{
		PreparedStatement ps = null;
		int idx = 0;
		try{
			ps = con.prepareStatement("delete from Instalacao where codigo = ?");
			ps.setInt(++idx, idInstalacao);
			ps.execute();
			ps.close();
			con.close();
			return "Deletado!";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps != null){
				try{
					ps.close();
				}catch(Exception e){}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e){
					
				}
			}
		}
		return "Não deletado";
	}
	
	public String alterarInstalacao(int idInstalacao, Instalacao inst) throws SQLException{
		PreparedStatement ps = null;
		int idx = 0;
		try{
			ps = con.prepareStatement("UPDATE INSTALACAO SET CODIGOCLIENTE = ?, CODIGOREGIAO =? "
					+ "WHERE CODIGO = ?");
			ps.setInt(++idx, inst.getCodCliente());
			ps.setInt(++idx, inst.getCodRegiao());
			ps.setInt(++idx, idInstalacao);
			ps.execute();
			ps.close();
			con.close();
			return "Alterado!";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ps != null){
				try{
					ps.close();
				}catch(Exception e){}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e){
					
				}
			}
		}
		return "Não Alterado";
	}
	
	public List<Instalacao> getInstPorRegiao(int idRegiao) throws SQLException{
		List<Instalacao> lista = new ArrayList<Instalacao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = con.prepareStatement(" SELECT * FROM INSTALACAO WHERE CODIGOREGIAO = ?");
			ps.setInt(1, idRegiao);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Instalacao instalacao = new Instalacao();
				instalacao.setCodInstalacao(rs.getInt("CODIGO"));
				instalacao.setCodCliente(rs.getInt("CODIGOCLIENTE"));
				instalacao.setCodRegiao(rs.getInt("CODIGOREGIAO"));
				lista.add(instalacao);
			}
			rs.close();
			ps.close();
			con.close();
			return lista;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception e){}
			}			
			if(ps != null){
				try{
					ps.close();
				}catch(Exception e){}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e){
					
				}
			}
		}
		return null;
	}
}
