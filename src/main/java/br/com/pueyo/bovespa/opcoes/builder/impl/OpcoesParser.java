package br.com.pueyo.bovespa.opcoes.builder.impl;

import br.com.pueyo.bovespa.opcoes.builder.RegistroPosicaoOpcao;

public class OpcoesParser {

	public static RegistroPosicaoOpcao parse(String in){
		RegistroPosicaoOpcao r = new RegistroPosicaoOpcao();
		
		r.setTipoRegsitro(in.substring(0, 2));
		
		r.setTipoRegsitro(in.substring(0,2));
		r.setNomeSociedadeEmissora(in.substring(2,14));
		r.setEspecificacaoPapel(in.substring(14,24));
		r.setDataVencimentoOpcao(in.substring(24,32));
		r.setNumeroSerie(in.substring(32,39));
		r.setTipoMercado(in.substring(39,42));
		r.setCodigoPapelNegociado(in.substring(42,54));
		r.setIndicadorMoeda(in.substring(54,55));
		r.setFatorCotacao(in.substring(55,62));
		r.setPrecoExercicio(in.substring(62,75));
		r.setPosicaoTotalCoberta(in.substring(75,90));
		r.setPosicaoTotalTravada(in.substring(90,105));
		r.setPosicaoTotalDescoberta(in.substring(105,120));
		r.setPosicaoTotal(in.substring(120,135));
		r.setQuantidadeClientesTitulares(in.substring(135,142));
		r.setQuantidadeClientesLancadores(in.substring(142,149));
		r.setDistribuicao(in.substring(149,152));
		r.setEstilo(in.substring(152,153));
		r.setTipoAtivoISIN(in.substring(153,156));
		r.setReserva(in.substring(156,160));
		
		return r;
	}
	
}
