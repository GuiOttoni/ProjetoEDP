package beans;

public class Regiao {
	private int codigo;
	private String nome;
	
	
	//get and set
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Construtor cheio e vazio
	public Regiao(int codigo, String nome) {
		super();
		setCodigo(codigo);
		setCodigo(nome);
	}
	public Regiao() {
		super();
	}
	
	//get all e set all

	public String getAll(){
		return getCodigo() + "\n" + getNome();
	}
	
	public void setAll(int codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	
}
