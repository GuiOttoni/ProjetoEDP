package testes;

import java.util.List;

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
			/*CADASTRAR*/
			//Instalacao inst = new Instalacao(paramInt("CodCliente"),paramInt("CodRegiao"));
			//String retorno = InstalacaoBO.cadastrarInstalacao(inst);
			
			/*REMOVER*/
			//String retorno = InstalacaoBO.removerInstalacao(paramInt("Deletar CodCli:"));
			
			/*ALTERAR*/
			/*Instalacao inst = new Instalacao(paramInt("CodCliente"),paramInt("CodRegiao"));
			String retorno = InstalacaoBO.alterarInstalacao(paramInt("IdInstalacao"), inst);*/
			
			/*LISTAR*/
			List<Instalacao> listaInstalacao = InstalacaoBO.getInstPorRegiao(paramInt("CodRegiao"));
			if(listaInstalacao == null){
				System.out.println("N�o h� registros para retornar.");
			}else{
				for(Instalacao inst : listaInstalacao){
					System.out.println("C�digo Instalacao: " + inst.getCodInstalacao());
					System.out.println("C�digo Cliente: " + inst.getCodCliente());
					System.out.println("C�digo Regi�o: " + inst.getCodRegiao());
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
