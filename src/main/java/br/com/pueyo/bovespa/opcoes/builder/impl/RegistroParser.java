package br.com.pueyo.bovespa.opcoes.builder.impl;

import br.com.pueyo.bovespa.opcoes.builder.Registro;

public class RegistroParser{

	public static Registro parse(String registro) {
		
		Registro o = new Registro();
		
		o.setTipreg(registro.substring(0, 2));

		o.setCodbdi(registro.substring(2, 4));

		o.setDesbdi(registro.substring(4,34));

		o.setNomres(registro.substring(34,46));

		o.setEspeci(registro.substring(46,56));

		o.setIndcar(registro.substring(56,57));

		o.setCodneg(registro.substring(57,69));

		o.setTpmerc(registro.substring(69,72));

		o.setNomerc(registro.substring(72,87));

		o.setPrazot(registro.substring(87,90));

		o.setPreabe(registro.substring(90,101));

		o.setPremax(registro.substring(101,112));

		o.setPremin(registro.substring(112,123));

		o.setPremed(registro.substring(123,134));

		o.setPreult(registro.substring(134,145));

		o.setSinosc(registro.substring(145,146));

		o.setOscila(registro.substring(146,151));

		o.setPreofc(registro.substring(151,162));

		o.setPreofv(registro.substring(162,173));

		o.setTotneg(registro.substring(173,178));

		o.setQuatot(registro.substring(178,193));

		o.setVoltot(registro.substring(193,210));

		o.setPreexe(registro.substring(210,221));

		o.setDatven(registro.substring(221,229));

		o.setIndopc(registro.substring(229,230));

		o.setNomind(registro.substring(230,245));

		o.setFatcot(registro.substring(245,252));

		o.setPtoexe(registro.substring(252,265));

		o.setCodisi(registro.substring(265,277));

		o.setDismes(registro.substring(277,280));

		o.setEstilo(registro.substring(280,281));

		o.setNomest(registro.substring(281,296));

		o.setIcoatv(registro.substring(296,299));

		o.setOscpre(registro.substring(299,306));

		o.setReserva(registro.substring(306,350));

		
		return o;
	}

}
