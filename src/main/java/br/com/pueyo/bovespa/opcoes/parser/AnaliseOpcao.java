package br.com.pueyo.bovespa.opcoes.parser;

import org.apache.commons.lang3.StringUtils;

import br.com.pueyo.bovespa.opcoes.builder.impl.AcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcaoDecorator;
import br.com.pueyo.bovespa.opcoes.model.decorator.DadosOpcoesDecorator;

public class AnaliseOpcao implements Comparable<AnaliseOpcao>{

	private AcaoDecorator acaoLocal;
	private OpcaoDecorator opcaoLocal;
	private DadosOpcoesDecorator dadosLocal;
	
	
	private double delta01;
	
	public AnaliseOpcao(AcaoDecorator acao, OpcaoDecorator opcao, DadosOpcoesDecorator dados) {
		this.acaoLocal = acao;
		this.opcaoLocal = opcao;
		this.dadosLocal = dados;
		
		gerarDelta();
		
	}
	
	public AnaliseOpcao() {
		
	}

	public boolean hasAnalise() {
		return (acaoLocal != null && opcaoLocal != null);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=============================================================").append("\n");
		sb.append("Codigo Negociado: " + this.dadosLocal.getCodigoPapelNegociado()).append("\n");
		sb.append("Valor Exerc.: " + this.dadosLocal.getValorExercicio()).append("\n");
		
		sb.append("[OPÇÃO]------------------------------------------------------").append("\n");
		sb.append("Cod.: " + opcaoLocal.getCodigoNegociado()).append("\n");
		sb.append("Data Vencimento: " + opcaoLocal.getDataVencimento()).append("\n");
		sb.append("Ultim. Neg. (R$): " + opcaoLocal.getPrecoUltimoNegocio()).append("\n");
		
		sb.append("[AÇÃO]-------------------------------------------------------").append("\n");
		sb.append("Cod.: " + acaoLocal.getCodigoNegociacao()).append("\n");
		sb.append("Ultim. Neg. (R$): " + acaoLocal.getValorUltimoNegocio()).append("\n");
		sb.append("[ANALISE]-------------------------------------------------------").append("\n");
		sb.append("DELTA : " + this.delta01);
		
		return sb.toString();
	}
	
	
	private void gerarDelta(){
		if (this.opcaoLocal != null && this.dadosLocal != null && this.acaoLocal != null) {
			Double valorAcao = Double.valueOf(StringUtils.replace(acaoLocal.getValorUltimoNegocio(), ",", "."));
			Double valorOpcao = Double.valueOf(StringUtils.replace(opcaoLocal.getPrecoUltimoNegocio(), ",", "."));
			Double valorExercicio = Double.valueOf(StringUtils.replace(dadosLocal.getValorExercicio(), ",", "."));

			if (!valorAcao.equals(0d)) {
				delta01 = valorAcao - (valorExercicio+ valorOpcao);
			}
		}
		
	}

	public int compareTo(AnaliseOpcao o) {
		if(this.delta01 < o.delta01){
			return -1;
		}else if(this.delta01 > o.delta01){
			return 1;
		}
		return 0;
	}

	public void setAcaoLocal(AcaoDecorator acaoLocal) {
		this.acaoLocal = acaoLocal;
		gerarDelta();
	}

	public void setOpcaoLocal(OpcaoDecorator opcaoLocal) {
		this.opcaoLocal = opcaoLocal;
		gerarDelta();
	}

	public void setDadosLocal(DadosOpcoesDecorator dadosLocal) {
		this.dadosLocal = dadosLocal;
		gerarDelta();
	}

}
