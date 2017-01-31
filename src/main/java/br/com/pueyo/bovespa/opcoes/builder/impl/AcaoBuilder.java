package br.com.pueyo.bovespa.opcoes.builder.impl;

import br.com.pueyo.bovespa.opcoes.builder.Registro;

public class AcaoBuilder<T extends Registro>  extends BuilderFactory<T> {

	private Registro local;
	
	public AcaoBuilder(Registro reg) {
		this.local = reg;
	}
	
	@Override
	public T converte() {
		return (T) new AcaoDecorator(this.local);
	}

}
