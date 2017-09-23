package bo;

import beans.ReclamacaoInstalacao;
import dao.ReclamacaoInstalacaoDAO;

public class ReclamacaoInstalacaoBO
{
    private ReclamacaoInstalacaoDAO dao;
    public ReclamacaoInstalacaoBO(){
         dao = new ReclamacaoInstalacaoDAO();
    }

    public static String cadastrarRecI(ReclamacaoInstalacao rec) throws Exception
    {
        try{
            if(inst.getCodCliente() == 0)
                return null;

            return dao.cadastrarReclamacao(rec);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String removerRecI(int idReclamacao) throws Exception
    {
        try{
            if(idReclamacao == 0)
                return null;

            return dao.deletarReclamacao(idReclamacao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String AlterarRecI(int idReclamacao, ReclamacaoInstalacao rec) throws Exception
    {
        try{
            if(inst.getCodCliente() == 0)
                return null;

            return dao.alterarReclamacao(idReclamacao, rec);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<ReclamacaoInstalacao> getRecInstPorRegiao(int idRegiao) throws Exception
    {
        try{
            if(idRegiao == 0)
                return null;

            return dao.getRecPorRegiao(idRegiao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<ReclamacaoInstalacao> getRecInstPorCliente(int idCliente) throws Exception
    {
        try{
            if(idCliente == 0)
                return null;

            return dao.getRecPorCliente(idCliente);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<ReclamacaoInstalacao> getRecInstPorInstalacao(int idInstalacao) throws Exception
    {
        try{
            if(idInstalacao == 0)
                return null;

            return dao.getRecPorInstalacao(idInstalacao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
