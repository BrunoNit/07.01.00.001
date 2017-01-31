package br.com.pueyo.bovespa.opcoes.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;

import br.com.pueyo.bovespa.opcoes.CodigoPapelPredicate;
import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.builder.RegistroPosicaoOpcao;
import br.com.pueyo.bovespa.opcoes.builder.impl.AcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.BuilderFactory;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcoesParser;
import br.com.pueyo.bovespa.opcoes.builder.impl.RegistroParser;
import br.com.pueyo.bovespa.opcoes.download.ArquivoCotacaoUtils;
import br.com.pueyo.bovespa.opcoes.model.decorator.DadosOpcoesDecorator;

public class TesteParser {

	
	public static void main(String[] args) throws IOException {
		
		List<DadosOpcoesDecorator> dadosOpcao = new ArrayList<DadosOpcoesDecorator>();
		URL url = TesteParser.class.getResource("/ROPC.dat");
		InputStream isDados = new FileInputStream(new File(url.getPath()));
		List<String> conteudoArquivoDados = IOUtils.readLines(isDados, Charset.defaultCharset());
		for(String s: conteudoArquivoDados){
			dadosOpcao.add(new DadosOpcoesDecorator(OpcoesParser.parse(s)));
		}
		
		
		InputStream is = new FileInputStream(ArquivoCotacaoUtils.buscarArquivoDiario());
 
		List<String> conteudoArquivo = IOUtils.readLines(is, Charset.defaultCharset());

		List<Registro> listaRegistroCotacoes = new ArrayList<Registro>();
		
		for(String str: conteudoArquivo){
			 Registro reg = RegistroParser.parse(str);
			 
			BuilderFactory fac = BuilderFactory.criarBuilder(reg);
			if(fac != null){
				listaRegistroCotacoes.add(fac.converte());
			}
		}
		
		for(DadosOpcoesDecorator dod: dadosOpcao){
			CodigoPapelPredicate predicate = new CodigoPapelPredicate(dod.getChaveDeBusca());
			Collection retorno = CollectionUtils.select(listaRegistroCotacoes, predicate);
			if(!retorno.isEmpty()){
				System.out.println("=============================================================");
				System.out.println("Codigo Negociado: " + dod.getCodigoPapelNegociado());
				System.out.println("Valor Exerc.: " + dod.getValorExercicio());
				for(Object o: retorno.toArray()){
					if(o instanceof OpcaoDecorator){
						OpcaoDecorator opcao = (OpcaoDecorator) o;
						System.out.println("[OPÇÃO]------------------------------------------------------");
						System.out.println("Cod.: " + opcao.getCodigoNegociado());
						System.out.println("Data Vencimento: " + opcao.getDataVencimento());
						System.out.println("Ultim. Neg. (R$): " + opcao.getPrecoUltimoNegocio());
					} else if(o instanceof AcaoDecorator){
						AcaoDecorator acao = (AcaoDecorator) o;
						System.out.println("[AÇÃO]-------------------------------------------------------");
						System.out.println("Cod.: " + acao.getCodigoNegociacao());
						System.out.println("Ultim. Neg. (R$): " + acao.getValorUltimoNegocio());
					}
				}
				
				
			}
			
		}
		
		
		
	}
	
}
