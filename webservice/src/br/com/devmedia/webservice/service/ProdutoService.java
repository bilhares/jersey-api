package br.com.devmedia.webservice.service;

import java.util.List;

import br.com.devmedia.webservice.model.DAO.ProdutoDAO;
import br.com.devmedia.webservice.model.domain.Produto;
import br.com.devmedia.webservice.model.domain.RetornoProdutos;

public class ProdutoService {
	private ProdutoDAO dao = new ProdutoDAO();

	public RetornoProdutos getProdutos() {
		return gerarRetorno(dao.getAll(), 0, 0);
	}

	public Produto getProduto(Long id) {
		return dao.getById(id);
	}

	public Produto saveProduto(Produto produto) {
		return dao.save(produto);
	}

	public Produto updateProduto(Produto produto) {
		return dao.update(produto);
	}

	public Produto deleteProduto(Long id) {
		return dao.delete(id);
	}

	public RetornoProdutos getProdutosByPagination(int firstResult, int maxResults) {
		return gerarRetorno(dao.getByPagination(firstResult, maxResults), Math.ceil(dao.getTotalPaginas() / maxResults),
				firstResult);
	}

	public RetornoProdutos getProdutoByName(String name) {
		return gerarRetorno(dao.getByName(name), 0, 0);
	}

	private RetornoProdutos gerarRetorno(List<Produto> produtos, double totalPaginas, int paginaAtual) {
		RetornoProdutos retorno = new RetornoProdutos();
		retorno.setProdutos(produtos);
		retorno.setTotalPaginas(totalPaginas);
		retorno.setPaginaAtual(paginaAtual);
		return retorno;
	}

}
