package testes;

import javax.swing.JOptionPane;

import dao.RegiaoDAO;

public class TesteApagar {

	public static void main(String[] args) {
		
		RegiaoDAO dao = null;
		try{
			dao = new RegiaoDAO();
			int x = dao.delete
					(Integer.parseInt
					(JOptionPane.showInputDialog
					("Digite o número da Regiao")));
			System.out.println
				(x + " regiao(s) foi(ram) excluido(s)!");
			
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
