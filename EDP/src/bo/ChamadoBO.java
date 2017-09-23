package bo;

import beans.Chamado;
import dao.ChamadoDAO;

public class ChamadoBO {

    public static String cadastrarChamado(Chamado chamado) {

        if(chamado == null)
            return null;

        if (chamado.getCodigoRegiao() == 0)
            return "Codigo da região inválido";

        if (chamado.getDescricaoChamado() == null || chamado.getDescricaoChamado().isEmpty())
            return "Descrição inválida";

        try {
            return new ChamadoDAO().gravar(chamado);
        } catch (Exception e) {
            return "Erro ao cadastrar!";
        }

    }

    public static Chamado buscarChamado(int codigoChamado) throws Exception {
        if (codigoChamado < 1)
            throw new Exception("Código inválido");

        Chamado c;

        try {
            c = new ChamadoDAO().retornarChamado(codigoChamado);
        } catch (Exception ignored) {
            throw new Exception("Erro ao buscar chamado");
        }

        if (c == null)
            throw new Exception("Chamado não encontrado");

        return c;
    }

}
