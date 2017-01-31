package br.com.pueyo.bovespa.opcoes.builder.impl;

import br.com.pueyo.bovespa.opcoes.builder.Registro;

public class AcaoDecorator extends Registro {
	
	private Registro local;
	
	public AcaoDecorator(Registro reg) {
		this.local = reg;
	}

	public String getCodigoNegociacao(){
		return this.local.getCodneg();
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getCodigoNegociacao()).append("|");
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
