package beans;

import java.util.Calendar;

public class Chamado {
    
	private int codigo;
    private int codigoRegiao;
    private Calendar dataHoraCadastro;
    private Calendar dataHoraFinalizado;
    private String descricaoChamado;
	 
	public Chamado() {
		
	}

	public Chamado(int codigo, int codigoRegiao, Calendar dataHoraCadastro, Calendar dataHoraFinalizado,
			String descricaoChamado) {
		super();
		this.codigo = codigo;
		this.codigoRegiao = codigoRegiao;
		this.dataHoraCadastro = dataHoraCadastro;
		this.dataHoraFinalizado = dataHoraFinalizado;
		this.descricaoChamado = descricaoChamado;
	}

	public Chamado(int codigoRegiao, Calendar dataHoraCadastro, Calendar dataHoraFinalizado,
			String descricaoChamado) {
		super();
		this.codigoRegiao = codigoRegiao;
		this.dataHoraCadastro = dataHoraCadastro;
		this.dataHoraFinalizado = dataHoraFinalizado;
		this.descricaoChamado = descricaoChamado;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoRegiao() {
		return codigoRegiao;
	}

	public void setCodigoRegiao(int codigoRegiao) {
		this.codigoRegiao = codigoRegiao;
	}

	public Calendar getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Calendar dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Calendar getDataHoraFinalizado() {
		return dataHoraFinalizado;
	}

	public void setDataHoraFinalizado(Calendar dataHoraFinalizado) {
		this.dataHoraFinalizado = dataHoraFinalizado;
	}

	public String getDescricaoChamado() {
		return descricaoChamado;
	}

	public void setDescricaoChamado(String descricaoChamado) {
		this.descricaoChamado = descricaoChamado;
	}
    
	
	
}
