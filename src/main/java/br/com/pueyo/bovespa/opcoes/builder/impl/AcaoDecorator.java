package br.com.pueyo.bovespa.opcoes.builder.impl;

import org.apache.commons.lang3.StringUtils;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.builder.RegistroBusca;

public class AcaoDecorator extends Registro implements RegistroBusca{
	
	private Registro local;
	
	public AcaoDecorator(Registro reg) {
		this.local = reg;
	}

	public String getCodigoNegociacao(){
		return this.local.getCodneg();
	}

	public String getCodigoBdi(){
		return this.local.getCodbdi();
	}
	
	public String getNomeResumidoEmissor(){
		return this.local.getNomres();
	}
	public String getEspecificacaoPapel(){
		return this.local.getEspeci();
	}
	
	public String getValorUltimoNegocio(){
		return convertePreco(this.local.getPreult());
	}
	
	public String getChaveDeBusca(){
		StringBuilder sb = new StringBuilder();
		sb.append(removerNumeros(this.local.getCodneg())).append(this.local.getEspeci());
		return StringUtils.removeAll(sb.toString(), " ");
	}
	
	private String removerNumeros(String codneg) {
		return StringUtils.removePattern(codneg, "[0-9]");
		
	}
	
	
	public static void main(String[] args) {
		Registro r = new Registro();
		r.setCodneg("LIXC14   ");
		r.setEspeci("ON     NM");
		AcaoDecorator acao = new AcaoDecorator(r);
		System.out.println(acao.getChaveDeBusca());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getCodigoNegociacao()).append("|");
		sb.append(this.getCodigoBdi()).append("|");
		sb.append(this.getNomeResumidoEmissor()).append(this.getEspecificacaoPapel());
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcaoDecorator other = (AcaoDecorator) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}

	
	
	
}
