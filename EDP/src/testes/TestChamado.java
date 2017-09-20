package testes;

import javax.swing.JOptionPane;

import beans.Chamado;
import bo.ChamadoBO;

public class TestChamado {

	public static void main(String[] args) {
		String resultado = ChamadoBO.cadastrarChamado(retornarNovoChamado());
		JOptionPane.showMessageDialog(null, resultado, "Cadastro", 0, null);
	}
	
	public static Chamado retornarNovoChamado() {
		return 
				new Chamado
				(
						Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da região: ")),
						null,
						null,
						JOptionPane.showInputDialog("Digite a descrição do chamado: ")
				);
	}
}
