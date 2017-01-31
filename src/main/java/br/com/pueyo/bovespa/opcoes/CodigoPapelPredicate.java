package br.com.pueyo.bovespa.opcoes;

import org.apache.commons.collections.Predicate;

import br.com.pueyo.bovespa.opcoes.builder.RegistroBusca;
import br.com.pueyo.bovespa.opcoes.builder.impl.AcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcaoDecorator;

public class CodigoPapelPredicate implements Predicate {

	private String chaveLocal;

	public CodigoPapelPredicate(String chave) {
		this.chaveLocal = chave;
	}

	public boolean evaluate(Object arg0) {
		
		if(arg0 instanceof RegistroBusca){
			RegistroBusca reg = (RegistroBusca) arg0;
			if(this.chaveLocal.equalsIgnoreCase(reg.getChaveDeBusca())){
				return true;
			}
		}
		return false;
	}

}
