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
	
	
	@Override
	public String toString() {
		return new StringBuilder(this.local.getCodigoPapelNegociado()).append("|").append(this.local.getNomeSociedadeEmissora()).append("|").append(this.local.getNumeroSerie()).append("|").append(this.local.getEspecificacaoPapel()).toString();
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



	
	
	
	
	
}
