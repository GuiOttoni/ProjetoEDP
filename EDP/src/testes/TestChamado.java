package testes;

import javax.swing.JOptionPane;

import beans.Chamado;
import bo.ChamadoBO;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestChamado {

	public static void main(String[] args) {
		int opt = 0;

		do {
			opt = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar chamado\n2 - Buscar chamado\n 3 - Apagar Chamado\n4 - Ultimo chamado realizado\n5 - Sair"));

			switch (opt) {
				case 1:
					JOptionPane.showMessageDialog(null, ChamadoBO.cadastrarChamado(retornarNovoChamado()),"Cadastro,", JOptionPane.INFORMATION_MESSAGE, null);
					break;
				case 2:
					try {
						Chamado c = ChamadoBO.buscarChamado(perguntarCodigoChamado());
						JOptionPane.showMessageDialog(null, c.toString(), "Cadastro,", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro,", JOptionPane.ERROR_MESSAGE, null);
					}
					break;
				case 3:
					try {
						Chamado c = ChamadoBO.buscarChamado(perguntarCodigoChamado());

						ChamadoBO.excluirChamado(c);

						// Se não lançou excessão, excluiu com sucesso!
						JOptionPane.showMessageDialog(null, "Chamado excluído com sucesso!", "Cadastro,", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro,", JOptionPane.ERROR_MESSAGE, null);
					}
					break;
				case 4:
					try {
						Chamado c = ChamadoBO.buscarUltimoChamado();
						JOptionPane.showMessageDialog(null, c.toString(), "Cadastro,", JOptionPane.INFORMATION_MESSAGE, null);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro,", JOptionPane.ERROR_MESSAGE, null);
					}
					break;
			}
		} while (opt != 5);
	}

	private static int perguntarCodigoChamado() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite o código do chamado para buscar!"));
	}

	private static Chamado retornarNovoChamado() {
	    try {
            return
                    new Chamado
                            (
                                    Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da regi�o: ")),
                                    new GregorianCalendar(),
                                    new GregorianCalendar(),
                                    JOptionPane.showInputDialog("Digite a descrição do chamado: ")
                            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dados para cadastro inválidos", "Cadastro,", JOptionPane.ERROR_MESSAGE, null);
            return null;
        }
	}
}
