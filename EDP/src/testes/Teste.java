package testes;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import beans.Cliente;
import bo.ClienteBO;

public class Teste {
	
	
	
	public static void main(String[] args){
		
		try{
			Cliente obj = new Cliente();
			obj.setNome(JOptionPane.showInputDialog("Digite o nome:"));
			obj.setSobrenome(JOptionPane.showInputDialog("Digite o sobrenome:"));
			
			Calendar c = Calendar.getInstance();
			c.setTime(new Date(JOptionPane.showInputDialog("Digite a Data de Nascimento")));
			
			obj.setDataNascimento(c);
			obj.setEndereco(JOptionPane.showInputDialog("Digite o Endereço:"));
			obj.setCep(JOptionPane.showInputDialog("Digite o CEP:"));
			obj.setCidade(JOptionPane.showInputDialog("Digite a Cidade:"));
			obj.setEstado(JOptionPane.showInputDialog("Digite o Estado:"));
			
			System.out.println(ClienteBO.cadastrarCliente(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
