package br.com.pueyo.bovespa.opcoes.model.decorator;

import org.apache.commons.lang3.StringUtils;

import br.com.pueyo.bovespa.opcoes.builder.RegistroPosicaoOpcao;

public class DadosOpcoesDecorator extends RegistroPosicaoOpcao{

	private RegistroPosicaoOpcao local;
	
	public DadosOpcoesDecorator(RegistroPosicaoOpcao in) {
		this.local = in;
	}

	
	public String getCodigoPapelNegociado(){
		return StringUtils.trim(this.local.getCodigoPapelNegociado());
	}
	
	public String getValorExercicio(){
		return convertePreco(this.local.getPrecoExercicio());
	}
	public String convertePreco(String preco) {
		StringBuilder i = new StringBuilder();
		StringBuilder f = new StringBuilder();
		f.append(preco.substring(11, 13));
		i.append(Integer.valueOf(preco.substring(0, 11)));
		return i.append(",").append(f).toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.local.getCodigoPapelNegociado()).append("|");
		sb.append(this.local.getNomeSociedadeEmissora()).append(this.local.getEspecificacaoPapel()).append("|");
		sb.append(this.local.getNumeroSerie()).append("|");
		return sb.toString();
	}



	@Override
	public int hashCode() {
		if(StringUtils.isNotBlank(this.local.getCodigoPapelNegociado())){
			return this.getCodigoPapelNegociado().hashCode();
		}
		return -1;
	}



	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DadosOpcoesDecorator)){
			return false;
		}
		DadosOpcoesDecorator dpd = (DadosOpcoesDecorator) obj;
		if((dpd.hashCode() != -1 && this.hashCode() != -1) && (this.hashCode() == dpd.hashCode())){
			return true;
		}
		return false;
	}


	public String getChaveDeBuscaAcao() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.local.getNomeSociedadeEmissora()).append(this.local.getEspecificacaoPapel());
		return StringUtils.removeAll(sb.toString(), " ");
	}

	public String getChaveDeBuscaOpcao() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.local.getCodigoPapelNegociado());
		return StringUtils.removeAll(sb.toString(), " ");
	}


	@Override
	public String getTipoMercado() {
		return this.local.getTipoMercado();
	}

	
	
	
	
	
}
