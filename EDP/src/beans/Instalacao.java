package beans;

public class Instalacao {

	private int codInstalacao;
	private int codCliente;
	private int codRegiao;
	
	public Instalacao(){}
		
	public Instalacao(int codInstalacao, int codCliente, int codRegiao) {
		super();
		this.codInstalacao = codInstalacao;
		this.codCliente = codCliente;
		this.codRegiao = codRegiao;
	}
	
	public Instalacao(int codCliente, int codRegiao) {
		super();
		this.codCliente = codCliente;
		this.codRegiao = codRegiao;
	}

	public int getCodInstalacao() {
		return codInstalacao;
	}
	public void setCodInstalacao(int codInstalacao) {
		this.codInstalacao = codInstalacao;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodRegiao() {
		return codRegiao;
	}
	public void setCodRegiao(int codRegiao) {
		this.codRegiao = codRegiao;
	}
	
	
}
