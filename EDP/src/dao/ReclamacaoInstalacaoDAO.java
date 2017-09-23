package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ReclamacaoInstalacao ;
import conexao.ConexaoFactory;

public class ReclamacaoInstalacaoDAO
{
    private Connection con;

    public ReclamacaoInstalacaoDAO() throws Exception{
        con = new ConexaoFactory().conectar();
    }

    public void fechar() throws SQLException{
        con.close();
    }

    public String cadastrarReclamacao(ReclamacaoInstalacao RecInst) throws SQLException{
        PreparedStatement ps = null;
        int idx = 0;
        try{
            ps = con.prepareStatement(" INSERT INTO ReclamacaoInstalacao "
                    + "values(SEQUENCE_EDP.Nextval,?,?,?,?,?,?,?) ");
            ps.setInt(++idx, RecInst.getCodigo));
            ps.setInt(++idx, RecInst.getCodigoCliente);
            ps.setInt(++idx, RecInst.getCodigoInstalacao));
            ps.setInt(++idx, RecInst.getCodigoRegiao);
            ps.setInt(++idx, RecInst.getStatus));
            ps.setString(++idx, RecInst.getDataCadastro);
            ps.setString(++idx, RecInst.getDescricaoOpcional);
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

    public String deletarReclamacao(int idReclamacao) throws SQLException{
        PreparedStatement ps = null;
        int idx = 0;
        try{
            ps = con.prepareStatement("delete from Instalacao where codigo = ?");
            ps.setInt(++idx, idReclamacao);
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

    public String alterarReclamacao(int idReclamacao, ReclamacaoInstalacao rec) throws SQLException{
        PreparedStatement ps = null;
        int idx = 0;
        try{
            ps = con.prepareStatement("UPDATE INSTALACAO SET CODIGOCLIENTE = ?, CODIGOREGIAO =? "
                    + "WHERE CODIGO = ?");
            ps.setInt(++idx, rec.getCodCliente());
            ps.setInt(++idx, rec.getCodRegiao());
            ps.setInt(++idx, idReclamacao);
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

    public List<ReclamacaoInstalacao> getRecPorRegiao(int idRegiao) throws SQLException{
        List<ReclamacaoInstalacao> lista = new ArrayList<ReclamacaoInstalacao>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(" SELECT * FROM INSTALACAO WHERE CODIGOREGIAO = ?");
            ps.setInt(1, idRegiao);
            rs = ps.executeQuery();

            while(rs.next()){
                ReclamacaoInstalacao reclamacao = new ReclamacaoInstalacao();
                reclamacao.setCodInstalacao(rs.getInt("CODIGO"));
                reclamacao.setCodCliente(rs.getInt("CODIGOCLIENTE"));
                reclamacao.setCodRegiao(rs.getInt("CODIGOREGIAO"));
                lista.add(reclamacao);
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

    public List<ReclamacaoInstalacao> getRecPorCliente(int idCliente) throws SQLException{
        List<ReclamacaoInstalacao> lista = new ArrayList<ReclamacaoInstalacao>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(" SELECT * FROM INSTALACAO WHERE CODIGOREGIAO = ?");
            ps.setInt(1, idRegiao);
            rs = ps.executeQuery();

            while(rs.next()){
                ReclamacaoInstalacao reclamacao = new ReclamacaoInstalacao();
                reclamacao.setCodInstalacao(rs.getInt("CODIGO"));
                reclamacao.setCodCliente(rs.getInt("CODIGOCLIENTE"));
                reclamacao.setCodRegiao(rs.getInt("CODIGOREGIAO"));
                lista.add(reclamacao);
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

    public List<ReclamacaoInstalacao> getRecPorInstalacao(int idInstalacao) throws SQLException{
        List<ReclamacaoInstalacao> lista = new ArrayList<ReclamacaoInstalacao>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(" SELECT * FROM INSTALACAO WHERE CODIGOREGIAO = ?");
            ps.setInt(1, idRegiao);
            rs = ps.executeQuery();

            while(rs.next()){
                ReclamacaoInstalacao reclamacao = new ReclamacaoInstalacao();
                reclamacao.setCodInstalacao(rs.getInt("CODIGO"));
                reclamacao.setCodCliente(rs.getInt("CODIGOCLIENTE"));
                reclamacao.setCodRegiao(rs.getInt("CODIGOREGIAO"));
                lista.add(reclamacao);
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
