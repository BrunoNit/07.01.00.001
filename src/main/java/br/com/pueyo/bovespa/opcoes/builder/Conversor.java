package br.com.pueyo.bovespa.opcoes.builder;

public interface Conversor <T extends Registro>{
	public T converter(String registro);
}
