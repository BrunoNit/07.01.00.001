package br.com.pueyo.bovespa.opcoes.builder;

public class Registro{
	
	private String tipreg;
	private String codbdi;
	private String desbdi;
	private String nomres;
	private String especi;
	private String indcar;
	private String codneg;
	private String tpmerc;
	private String nomerc;
	private String prazot;
	private String preabe;
	private String premax;
	private String premin;
	private String premed;
	private String preult;
	private String sinosc;
	private String oscila;
	private String preofc;
	private String preofv;
	private String totneg;
	private String quatot;
	private String voltot;
	private String preexe;
	private String datven;
	private String indopc;
	private String nomind;
	private String fatcot;
	private String ptoexe;
	private String codisi;
	private String dismes;
	private String estilo;
	private String nomest;
	private String icoatv;
	private String oscpre;
	private String reserva;
	public String getTipreg() {
		return tipreg;
	}
	public void setTipreg(String tipreg) {
		this.tipreg = tipreg;
	}
	public String getCodbdi() {
		return codbdi;
	}
	public void setCodbdi(String codbdi) {
		this.codbdi = codbdi;
	}
	public String getDesbdi() {
		return desbdi;
	}
	public void setDesbdi(String desbdi) {
		this.desbdi = desbdi;
	}
	public String getNomres() {
		return nomres;
	}
	public void setNomres(String nomres) {
		this.nomres = nomres;
	}
	public String getEspeci() {
		return especi;
	}
	public void setEspeci(String especi) {
		this.especi = especi;
	}
	public String getIndcar() {
		return indcar;
	}
	public void setIndcar(String indcar) {
		this.indcar = indcar;
	}
	public String getCodneg() {
		return codneg;
	}
	public void setCodneg(String codneg) {
		this.codneg = codneg;
	}
	public String getTpmerc() {
		return tpmerc;
	}
	public void setTpmerc(String tpmerc) {
		this.tpmerc = tpmerc;
	}
	public String getNomerc() {
		return nomerc;
	}
	public void setNomerc(String nomerc) {
		this.nomerc = nomerc;
	}
	public String getPrazot() {
		return prazot;
	}
	public void setPrazot(String prazot) {
		this.prazot = prazot;
	}
	public String getPreabe() {
		return preabe;
	}
	public void setPreabe(String preabe) {
		this.preabe = preabe;
	}
	public String getPremax() {
		return premax;
	}
	public void setPremax(String premax) {
		this.premax = premax;
	}
	public String getPremin() {
		return premin;
	}
	public void setPremin(String premin) {
		this.premin = premin;
	}
	public String getPremed() {
		return premed;
	}
	public void setPremed(String premed) {
		this.premed = premed;
	}
	public String getPreult() {
		return preult;
	}
	public void setPreult(String preult) {
		this.preult = preult;
	}
	public String getSinosc() {
		return sinosc;
	}
	public void setSinosc(String sinosc) {
		this.sinosc = sinosc;
	}
	public String getOscila() {
		return oscila;
	}
	public void setOscila(String oscila) {
		this.oscila = oscila;
	}
	public String getPreofc() {
		return preofc;
	}
	public void setPreofc(String preofc) {
		this.preofc = preofc;
	}
	public String getPreofv() {
		return preofv;
	}
	public void setPreofv(String preofv) {
		this.preofv = preofv;
	}
	public String getTotneg() {
		return totneg;
	}
	public void setTotneg(String totneg) {
		this.totneg = totneg;
	}
	public String getQuatot() {
		return quatot;
	}
	public void setQuatot(String quatot) {
		this.quatot = quatot;
	}
	public String getVoltot() {
		return voltot;
	}
	public void setVoltot(String voltot) {
		this.voltot = voltot;
	}
	public String getPreexe() {
		return preexe;
	}
	public void setPreexe(String preexe) {
		this.preexe = preexe;
	}
	public String getDatven() {
		return datven;
	}
	public void setDatven(String datven) {
		this.datven = datven;
	}
	public String getIndopc() {
		return indopc;
	}
	public void setIndopc(String indopc) {
		this.indopc = indopc;
	}
	public String getNomind() {
		return nomind;
	}
	public void setNomind(String nomind) {
		this.nomind = nomind;
	}
	public String getFatcot() {
		return fatcot;
	}
	public void setFatcot(String fatcot) {
		this.fatcot = fatcot;
	}
	public String getPtoexe() {
		return ptoexe;
	}
	public void setPtoexe(String ptoexe) {
		this.ptoexe = ptoexe;
	}
	public String getCodisi() {
		return codisi;
	}
	public void setCodisi(String codisi) {
		this.codisi = codisi;
	}
	public String getDismes() {
		return dismes;
	}
	public void setDismes(String dismes) {
		this.dismes = dismes;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getNomest() {
		return nomest;
	}
	public void setNomest(String nomest) {
		this.nomest = nomest;
	}
	public String getIcoatv() {
		return icoatv;
	}
	public void setIcoatv(String icoatv) {
		this.icoatv = icoatv;
	}
	public String getOscpre() {
		return oscpre;
	}
	public void setOscpre(String oscpre) {
		this.oscpre = oscpre;
	}
	public String getReserva() {
		return reserva;
	}
	public void setReserva(String reserva) {
		this.reserva = reserva;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codneg == null) ? 0 : codneg.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		if (codneg == null) {
			if (other.codneg != null)
				return false;
		} else if (!codneg.equals(other.codneg))
			return false;
		return true;
	}
	
	

}
