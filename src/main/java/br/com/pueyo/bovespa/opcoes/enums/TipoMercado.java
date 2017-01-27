package br.com.pueyo.bovespa.opcoes.enums;

public enum TipoMercado {

	ERRO("XXX","TIPO MERCADO INVALIDO", "CODIGO DE TIPO MERCADO INEXISTENTE"),
	VISTA_FUTURO("001","VISTA - FUTURO  ","VFU - VISTA P/ LIQ. MERCADO FUTURO"),
	VISTA("010","VISTA","MERCADO A VISTA"),
	EX_OPC_COMPRA("012","EX OPC COMPRA","EXERCICIO DE OPCOES DE COMPRA"),
	EX_OPC_VENDA("013","EX OPC VENDA","EXERCICIO DE OPCOES DE VENDA"),
	OP_ESTRUTURAD  ("015","OP. ESTRUTURADA ","MERCADO DE OPERACAO ESTRUTURADA"),
	LEILAO("017","LEILAO","LEILAO"),
	FRACIONARIO("020","FRACIONARIO","FRACIONARIO"),
	TERMO("030","TERMO","MERCADO A TERMO"),
	FUTURO("050","FUTURO","FUTURO"),
	FUT_RET_GANHOS("060","FUT.RET.GANHOS","FUTURO COM RETENCAO DE GANHOS"),
	OPCOES_COMPRA("070","OPCOES COMPRA","OPCOES DE COMPRA"),
	OPCOES_VENDA("080","OPCOES VENDA","OPCOES DE VENDA");

	private String codigo;
	private String nome;
	private String descricaoCompleta;
	
	private TipoMercado(String cod, String desc, String descCompl) {
		this.codigo = cod;
		this.nome = desc;
		this.descricaoCompleta = descCompl;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}
	
	public static TipoMercado buscarPorCodigo(String cod){
		for(TipoMercado t: values()){
			if(t.getCodigo().equals(cod)){
				return t;
			}
		}
		return ERRO;
	}
	
	
	
}
