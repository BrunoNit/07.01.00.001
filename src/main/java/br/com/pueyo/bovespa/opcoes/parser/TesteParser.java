package br.com.pueyo.bovespa.opcoes.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;

import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.builder.impl.BuilderFactory;
import br.com.pueyo.bovespa.opcoes.builder.impl.RegistroParser;

public class TesteParser {

	
	public static void main(String[] args) throws IOException {
		
		
		URL url = TesteParser.class.getResource("/BDIN");
		
		InputStream is = new FileInputStream(url.getFile());
         
		 
 
		 List<String> conteudoArquivo = IOUtils.readLines(is, Charset.defaultCharset());
				
		 
		 for(String str: conteudoArquivo){
			 Registro reg = RegistroParser.parse(str);
			 
			BuilderFactory fac = BuilderFactory.criarBuilder(reg);
			if(fac != null){
				System.out.println(fac.converte().toString());
			}
			
			 
		 }
	}
}
