package testes;

import javax.swing.JOptionPane;

import dao.RegiaoDAO;

public class TesteGravar {

	public static void main(String[] args) {
		public static void main(String[] args) {
			RegiaoDAO dao = null;
			try{
				dao = new RegiaoDAO();
				RegiaoDAO obj = new RegiaoDAO();
				obj.gravar(JOptionPane.showInputDialog("Digite o nome da Regiao"));			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					System.out.println(dao.fechar());
				}catch(Exception e){
					e.printStackTrace();
				}
			}

		}
	}

}
