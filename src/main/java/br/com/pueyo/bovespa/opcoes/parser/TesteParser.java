package br.com.pueyo.bovespa.opcoes.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.builder.RegistroPosicaoOpcao;
import br.com.pueyo.bovespa.opcoes.builder.impl.BuilderFactory;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcoesParser;
import br.com.pueyo.bovespa.opcoes.builder.impl.RegistroParser;
import br.com.pueyo.bovespa.opcoes.download.ArquivoCotacaoUtils;
import br.com.pueyo.bovespa.opcoes.model.decorator.DadosOpcoesDecorator;
import br.com.pueyo.bovespa.opcoes.model.decorator.OpcaoDecorator;

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
		
		
		
		 
		for(String str: conteudoArquivo){
			 Registro reg = RegistroParser.parse(str);
			 
			BuilderFactory fac = BuilderFactory.criarBuilder(reg);
			if(fac != null){
				Registro registro = fac.converte();
				if(registro instanceof OpcaoDecorator){
					OpcaoDecorator opcao = (OpcaoDecorator) registro;
					
					RegistroPosicaoOpcao rpo = new RegistroPosicaoOpcao();
					rpo.setCodigoPapelNegociado(opcao.getCodigoNegociado());
					DadosOpcoesDecorator dod = new DadosOpcoesDecorator(rpo);
					
					int i = dadosOpcao.indexOf(dod);
					if(i >= 0){
						DadosOpcoesDecorator d = dadosOpcao.get(i);
						System.out.println("############################");
						System.out.println(opcao.toString());
						System.out.println(d.toString());
					}
				}
				
			}
		}
		
		
		
	}
	
}
