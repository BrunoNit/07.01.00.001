package br.com.pueyo.bovespa.opcoes.builder.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.builder.RegistroBusca;
import br.com.pueyo.bovespa.opcoes.enums.TipoMercado;

public class OpcaoDecorator extends Registro implements RegistroBusca{
	
	private Registro local;
	
	public OpcaoDecorator(Registro opcao) {
		this.local = opcao;
	}

	
	public String getCodigoNegociado(){
		return this.local.getCodneg();
	}
	
	public String getTipoMercado() {
		return TipoMercado.buscarPorCodigo(local.getTpmerc()).getNome();
	}
	
	
	public String getPrecoFechamento() {
		return convertePreco(local.getPreofc());
	}
	
	public String getPrecoUltimoNegocio(){
		return convertePreco(local.getPreult());
	}


	public String getDataVencimento(){
		DateFormat sdfIn = new SimpleDateFormat("yyyyMMdd");
		DateFormat sdfOu = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdfOu.format(sdfIn.parse(local.getDatven()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "xx/xx/xxxx";
	}
	
	public String getNomeResumidoEmpresa(){
		return this.local.getNomres();
	}
	
	public String getPrecoExercicio(){
		return convertePreco(this.local.getPreexe());
	}
	
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(local.getCodneg()).append("|").append(this.getTipoMercado()).append("|").append(this.getPrecoUltimoNegocio()).append("|").append(this.getDataVencimento())
		.append("|").append(this.getPrecoExercicio());
		return sb.toString();
	}


	public String getChaveDeBusca() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.local.getNomres()).append(this.local.getEspeci());
		return StringUtils.removeAll(sb.toString(), " ");
	}

}
