package br.com.projeto.util;

import java.util.List;

public class Paginador<T> {
	private Integer pagina;
	private Integer registrosPorPagina;
	private String ordenarCampo;
	private String tipoDaOrdenacao;
	private Long totalDeResultado;
	private List<T> list;

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getRegistrosPorPagina() {
		return registrosPorPagina;
	}

	public void setRegistrosPorPagina(Integer registrosPorPagina) {
		this.registrosPorPagina = registrosPorPagina;
	}

	public Long getTotalDeResultado() {
		return totalDeResultado;
	}

	public void setTotalDeResultado(Long totalDeResultado) {
		this.totalDeResultado = totalDeResultado;
	}

	public String getOrdenarCampo() {
		return ordenarCampo;
	}

	public void setOrdenarCampo(String ordenarCampo) {
		this.ordenarCampo = ordenarCampo;
	}

	public String getTipoDaOrdenacao() {
		return tipoDaOrdenacao;
	}

	public void setTipoDaOrdenacao(String tipoDaOrdenacao) {
		this.tipoDaOrdenacao = tipoDaOrdenacao;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}