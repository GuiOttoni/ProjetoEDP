package beans;

public class ReclamacaoInstalacao
{
	private int codigo; 
    private int codigoCliente; 
    private int codigoInstalacao;
    private int codigoRegiao;
    private int status;
    private String dataCadastro;
    private String descricaoOpcional;
	
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

	public int getCodigoInstalacao() {
		return codigoInstalacao;
	}

	public void setCodigoInstalacao(int codigoInstalacao) {
		this.codigoInstalacao = codigoInstalacao;
	}

	public int getCodigoRegiao() {
		return codigoRegiao;
	}

	public void setCodigoRegiao(int codigoRegiao) {
		this.codigoRegiao = codigoRegiao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricaoOpcional() {
		return descricaoOpcional;
	}

	public void setDescricaoOpcional(String descricaoOpcional) {
		this.descricaoOpcional = descricaoOpcional;
	}

	public ReclamacaoInstalacao(int _codigo, 
                                int _codigoCliente, 
                                int _codigoInstalacao,
                                int _codigoRegiao,
                                int _status,
                                String _dataCadastro,
                                String _descricaoOpcional) 
	{
		super();
		setCodigo(_codigo);
		setCodigoCliente(_codigoCliente);
		setCodigoInstalacao(_codigoInstalacao);
	}
	
	public ReclamacaoInstalacao() 
	{
		super();
	}
}
