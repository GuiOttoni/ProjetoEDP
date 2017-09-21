package testes;

import javax.swing.JOptionPane;

import dao.RegiaoDAO;

public class TesteAtualizar {

	public static void main(String[] args) {
		RegiaoDAO dao = null;
		try{
			dao = new RegiaoDAO();
			int x = dao.atualizar
					(Integer.parseInt
					(JOptionPane.showInputDialog
					("Digite o Codigo")));
			System.out.println
				(x + " regioes(s) foi(ram) atualizado(s)!");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				dao.fechar();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
