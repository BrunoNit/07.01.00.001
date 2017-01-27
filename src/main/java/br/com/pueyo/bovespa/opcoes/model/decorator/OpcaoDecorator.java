package br.com.pueyo.bovespa.opcoes.model.decorator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.enums.TipoMercado;

public class OpcaoDecorator extends Registro{
	
	private Registro local;
	
	public OpcaoDecorator(Registro opcao) {
		this.local = opcao;
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
	private String convertePreco(String preco) {
		StringBuilder i = new StringBuilder();
		StringBuilder f = new StringBuilder();
		f.append(preco.substring(9, 11));
		i.append(Integer.valueOf(preco.substring(0, 9)));
		return i.append(",").append(f).toString();
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(local.getCodneg()).append("|").append(this.getTipoMercado()).append("|").append(this.getPrecoUltimoNegocio()).append("|").append(this.getDataVencimento())
		.append("|").append(this.getPrecoExercicio());
		return sb.toString();
	}

}
