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
	
	public static void main(String[] args) throws Exception {
		
		String opcao = paramString("Escolha uma op��o entre Cadastrar, Remover, Alterar, Listar");
		Instalacao inst;
		switch(opcao){
			case "Cadastrar":
				    inst = new Instalacao(paramInt("Digite o c�digo do cliente"),
					        			  paramInt("Digite o c�digo da regi�o"));
					try{
						JOptionPane.showMessageDialog(null, InstalacaoBO.cadastrarInstalacao(inst));
					}catch(Exception e){
						e.printStackTrace();
					}
				break;
			case "Remover":
					try{
						JOptionPane.showMessageDialog(null, 
									InstalacaoBO.removerInst(paramInt("Digite o c�digo do cliente")));
					}catch(Exception e){
						e.printStackTrace();
					}
				break;
			case "Alterar":
				    inst = new Instalacao(paramInt("Digite o c�digo do cliente"),
					    		   		  paramInt("Digite o c�digo da regi�o"));
				    try{
				    	JOptionPane.showMessageDialog(null, 
									InstalacaoBO.alterarInstalacao(paramInt("Digite o c�digo da instalacao a ser alterada"), inst));
				    }catch(Exception e){
				    	e.printStackTrace();
				    }
				break;
			case "Listar":
					try{
						List<Instalacao> listaInstalacao = InstalacaoBO.getInstPorRegiao(
														   paramInt("Digite o c�digo da regi�o"));
						
					if(listaInstalacao == null)
						System.out.println("Erro ao retornar listagem.");
					else{
							for(Instalacao instalacao : listaInstalacao){
								System.out.print("C�digo Instala��o: " + instalacao.getCodInstalacao()+", ");
								System.out.print("C�digo Cliente: " + instalacao.getCodCliente()+", ");
								System.out.print("C�digo Regi�o: " + instalacao.getCodRegiao()+ System.lineSeparator());
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				break;
			default:
					JOptionPane.showMessageDialog(null, "Digite um par�metro correto!");
				break;
		}
	}
}
