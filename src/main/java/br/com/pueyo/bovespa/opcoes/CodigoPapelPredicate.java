package br.com.pueyo.bovespa.opcoes;

import org.apache.commons.collections.Predicate;

import br.com.pueyo.bovespa.opcoes.builder.RegistroBusca;
import br.com.pueyo.bovespa.opcoes.builder.impl.AcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcaoDecorator;

public class CodigoPapelPredicate implements Predicate {

	private String chaveLocalAcao;
	private String chaveLocalOpcao;

	public CodigoPapelPredicate(String chaveAcao, String chaveOpcao) {
		this.chaveLocalAcao = chaveAcao;
		this.chaveLocalOpcao = chaveOpcao;
	}

	public boolean evaluate(Object arg0) {
		
		if(arg0 instanceof AcaoDecorator){
			AcaoDecorator reg = (AcaoDecorator) arg0;
			if(this.chaveLocalAcao.equalsIgnoreCase(reg.getChaveDeBusca())){
				return true;
			}	
		}else if(arg0 instanceof OpcaoDecorator){
			OpcaoDecorator reg = (OpcaoDecorator) arg0;
			if(this.chaveLocalOpcao.equalsIgnoreCase(reg.getChaveDeBusca())){
				return true;
			}	
		}
		return false;
	}

}
