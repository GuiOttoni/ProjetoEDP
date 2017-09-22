package bo;

import beans.ReclamacaoInstalacao;
import dao.ReclamacaoInstalacaoDAO;

public class ReclamacaoInstalacaoBO
{
    private ReclamacaoInstalacaoDAO dao;
    public ReclamacaoInstalacaoBO(){
         dao = new ReclamacaoInstalacaoDAO();
    }

    public static String cadastrarRecI(Instalacao inst) throws Exception
    {
        try{
            if(inst.getCodCliente() == 0)
                return null;

            return dao.cadastrarInstalacao(inst);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String removerRecI(int idInstalacao) throws Exception
    {
        try{
            if(idInstalacao == 0)
                return null;

            return dao.deletarInstalacao(idInstalacao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String AlterarRecI(int idInstalacao, Instalacao inst) throws Exception
    {
        try{
            if(inst.getCodCliente() == 0)
                return null;

            return dao.alterarInstalacao(idInstalacao, inst);
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

            return dao.getInstPorRegiao(idRegiao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<ReclamacaoInstalacao> getRecInstPorCliente(int idRegiao) throws Exception
    {
        try{
            if(idRegiao == 0)
                return null;

            return dao.getInstPorRegiao(idRegiao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<ReclamacaoInstalacao> getRecInstPorInstalacao(int idRegiao) throws Exception
    {
        try{
            if(idRegiao == 0)
                return null;

            return dao.getInstPorRegiao(idRegiao);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
