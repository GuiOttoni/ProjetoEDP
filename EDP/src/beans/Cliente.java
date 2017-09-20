package beans;

public class Cliente {
	private int codigo;
	private int codigoCliente;
	private String texto;
	
	public String getAll(){
		return getCodigo() + getCodigoCliente() + getTexto();
	}
	
	public void setAll(int codigo, int codigoCliente, String texto) {
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.texto = texto;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigoCliente() {
		return codigoCliente;
	}
	
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Cliente(int codigo, int codigoCliente, String texto) {
		super();
		this.codigo = codigo;
		this.codigoCliente = codigoCliente;
		this.texto = texto;
	}
	
	public Cliente() {
		super();
	}
}


