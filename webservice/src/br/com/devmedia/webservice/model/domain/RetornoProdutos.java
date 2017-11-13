package br.com.devmedia.webservice.model.domain;

import java.util.List;

public class RetornoProdutos {
	private List<Produto> produtos;
	private double totalPaginas;
	private int paginaAtual;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(double totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

}
