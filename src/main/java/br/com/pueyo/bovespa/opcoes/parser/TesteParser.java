package br.com.pueyo.bovespa.opcoes.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;

import br.com.pueyo.bovespa.opcoes.CodigoPapelPredicate;
import br.com.pueyo.bovespa.opcoes.builder.Registro;
import br.com.pueyo.bovespa.opcoes.builder.impl.AcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.BuilderFactory;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcaoDecorator;
import br.com.pueyo.bovespa.opcoes.builder.impl.OpcoesParser;
import br.com.pueyo.bovespa.opcoes.builder.impl.RegistroParser;
import br.com.pueyo.bovespa.opcoes.download.ArquivoCotacaoUtils;
import br.com.pueyo.bovespa.opcoes.enums.TipoMercado;
import br.com.pueyo.bovespa.opcoes.model.decorator.DadosOpcoesDecorator;

public class TesteParser {

	public static void main(String[] args) throws IOException {

		List<DadosOpcoesDecorator> dadosOpcao = new ArrayList<DadosOpcoesDecorator>();
		URL url = TesteParser.class.getResource("/ROPC.dat");
		InputStream isDados = new FileInputStream(new File(url.getPath()));
		List<String> conteudoArquivoDados = IOUtils.readLines(isDados, Charset.defaultCharset());
		for (String s : conteudoArquivoDados) {
			DadosOpcoesDecorator d = new DadosOpcoesDecorator(OpcoesParser.parse(s));
			if (TipoMercado.OPCOES_COMPRA.equals(TipoMercado.buscarPorCodigo(d.getTipoMercado()))) {
				dadosOpcao.add(d);
			}

		}

		InputStream is = new FileInputStream(ArquivoCotacaoUtils.buscarArquivoDiario());

		List<String> conteudoArquivo = IOUtils.readLines(is, Charset.defaultCharset());

		List<Registro> listaRegistroCotacoes = new ArrayList<Registro>();

		for (String str : conteudoArquivo) {
			Registro reg = RegistroParser.parse(str);

			BuilderFactory fac = BuilderFactory.criarBuilder(reg);
			if (fac != null) {
				listaRegistroCotacoes.add(fac.converte());
			}
		}
		List<AnaliseOpcao> listaAnalises = new ArrayList<AnaliseOpcao>();
		for (DadosOpcoesDecorator dod : dadosOpcao) {
			CodigoPapelPredicate predicate = new CodigoPapelPredicate(dod.getChaveDeBuscaAcao(),
					dod.getChaveDeBuscaOpcao());
			Collection retorno = CollectionUtils.select(listaRegistroCotacoes, predicate);
			AnaliseOpcao analise = new AnaliseOpcao();
			if (!retorno.isEmpty()) {
				analise.setDadosLocal(dod);
				OpcaoDecorator opcao = null;
				AcaoDecorator acao = null;
				for (Object o : retorno.toArray()) {
					if (o instanceof OpcaoDecorator) {
						opcao = (OpcaoDecorator) o;
						analise.setOpcaoLocal(opcao);
					} else if (o instanceof AcaoDecorator) {
						acao = (AcaoDecorator) o;
						analise.setAcaoLocal(acao);
					}
				}
			}
			listaAnalises.add(analise);
		}

		Collections.sort(listaAnalises);

		for (AnaliseOpcao a : listaAnalises) {
			if (a.hasAnalise()) {
				System.out.println(a.toString());
			}
		}

	}

}
