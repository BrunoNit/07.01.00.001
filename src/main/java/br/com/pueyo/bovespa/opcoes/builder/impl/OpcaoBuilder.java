package br.com.pueyo.bovespa.opcoes.builder.impl;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.model.decorator.OpcaoDecorator;

public class OpcaoBuilder<T extends Registro> extends BuilderFactory<T>{
	
	private Registro local;
	
	public OpcaoBuilder(Registro reg) {
		this.local = reg;
	}
	public T converte() {
		return (T) new OpcaoDecorator(this.local);
	}

	

}
