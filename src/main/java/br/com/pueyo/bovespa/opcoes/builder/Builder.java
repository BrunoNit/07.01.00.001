package br.com.pueyo.bovespa.opcoes.builder;

public interface Builder <T extends Registro>{
	T converte(Registro registro);
}
