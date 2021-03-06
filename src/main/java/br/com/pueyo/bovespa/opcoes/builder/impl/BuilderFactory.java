package br.com.pueyo.bovespa.opcoes.builder.impl;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.enums.TipoMercado;

public abstract class BuilderFactory<T extends Registro> {
	
	public static BuilderFactory criarBuilder(Registro registro){
		
		if(!"02".equals(registro.getTipreg())){
			return null;
		}
		
		if(TipoMercado.OPCOES_COMPRA.equals(TipoMercado.buscarPorCodigo(registro.getTpmerc()))){
			return (BuilderFactory) new OpcaoBuilder<OpcaoDecorator>(registro);
		}else if(TipoMercado.VISTA.equals(TipoMercado.buscarPorCodigo(registro.getTpmerc()))){
			return (BuilderFactory) new AcaoBuilder<AcaoDecorator>(registro);
		}
		return null;
	}
	
	public abstract T converte();
	

}
