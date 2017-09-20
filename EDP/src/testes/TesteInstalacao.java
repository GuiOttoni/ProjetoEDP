package testes;

import javax.swing.JOptionPane;

import beans.Instalacao;
import bo.InstalacaoBO;

public class TesteInstalacao {
	static int paramInt(){
		return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
	}
	static String paramString(){
		return JOptionPane.showInputDialog("Escolha uma opção:");
	}
	
	public static void main(String[] args) {
		try{
			//Instalacao inst = new Instalacao(paramInt(),paramInt());
			//String retorno = InstalacaoBO.cadastrarInstalacao(inst);
			String retorno = InstalacaoBO.removerInstalacao(paramInt());
			if(retorno == null){
				System.out.println("Não cadastrado!");
			}else{
				System.out.println(retorno);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
