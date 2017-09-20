package testes;

import javax.swing.JOptionPane;

import beans.Instalacao;
import bo.InstalacaoBO;

public class TesteInstalacao {
	static int paramInt(String txt){
		return Integer.parseInt(JOptionPane.showInputDialog(txt));
	}
	static String paramString(String txt){
		return JOptionPane.showInputDialog(txt);
	}
	
	public static void main(String[] args) {
		try{
			//Instalacao inst = new Instalacao(paramInt("CodCliente"),paramInt("CodRegiao"));
			//String retorno = InstalacaoBO.cadastrarInstalacao(inst);
			
			//String retorno = InstalacaoBO.removerInstalacao(paramInt("Deletar CodCli:"));
			
			Instalacao inst = new Instalacao(paramInt("CodCliente"),paramInt("CodRegiao"));
			String retorno = InstalacaoBO.alterarInstalacao(paramInt("IdInstalacao"), inst);
			
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
