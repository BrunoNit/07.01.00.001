package br.com.pueyo.bovespa.opcoes.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import br.com.pueyo.bovespa.opcoes.parser.TesteParser;

public class ArquivoCotacaoUtils {
	
	final static int BUFFER = 2048;
	
	private static File gravaArquivoDeURL(String stringUrl, String pathLocal) {
		try {
	
		    BufferedOutputStream dest = null;
			URL url = new URL(stringUrl);
		
			InputStream is = url.openStream();
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
			String caminho ="";
			
			 ZipEntry entry;
	         while((entry = zis.getNextEntry()) != null) {
	            int count;
	            byte data[] = new byte[BUFFER];
	            caminho = pathLocal +"/" + entry.getName();
	            FileOutputStream fos = new FileOutputStream(caminho);
	            dest = new BufferedOutputStream(fos, BUFFER);
	            while ((count = zis.read(data, 0, BUFFER)) 
	              != -1) {
	               dest.write(data, 0, count);
	            }
	            dest.flush();
	            dest.close();
	         }
	         zis.close();
			return new File(caminho);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Busca o arquivo do ultimo pregao
	 * 
	 * @return File
	 */
	public static File buscarArquivoDiario(){
		StringBuilder sb = new StringBuilder("http://bvmf.bmfbovespa.com.br/fechamento-pregao/bdi/bdi");
		DateFormat df = new SimpleDateFormat("MMdd");
		Calendar dataUltimoPregao = buscarUltimoPregao();
		URL url = TesteParser.class.getResource("/");
		return gravaArquivoDeURL(sb.append(df.format(dataUltimoPregao.getTime())).append(".zip").toString(), url.getPath());
	}
	
	public static File buscarArquivoOpcoes(){
		StringBuilder sb = new StringBuilder("http://bvmf.bmfbovespa.com.br/fechamento-pregao/bdi/bdi");
		DateFormat df = new SimpleDateFormat("MMdd");
		Calendar dataUltimoPregao = buscarUltimoPregao();
		URL url = ArquivoCotacaoUtils.class.getResource("/ROPC.dat");
		return gravaArquivoDeURL(sb.append(df.format(dataUltimoPregao.getTime())).append(".zip").toString(), url.getPath());
	}

	private static Calendar buscarUltimoPregao(){
		
		Calendar c = Calendar.getInstance();
		do {
			int dia = c.get(Calendar.DATE);
			c.set(Calendar.DATE, dia -1);
		} while (Calendar.SUNDAY == c.get(Calendar.DAY_OF_WEEK) || Calendar.SATURDAY == c.get(Calendar.DAY_OF_WEEK));
		return c;
	}
}
