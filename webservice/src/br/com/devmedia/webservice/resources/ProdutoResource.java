package br.com.devmedia.webservice.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.devmedia.webservice.model.domain.Produto;
import br.com.devmedia.webservice.model.domain.RetornoProdutos;
import br.com.devmedia.webservice.resources.beans.ProdutoFilterBean;
import br.com.devmedia.webservice.service.ProdutoService;

@Path("/produtos")
public class ProdutoResource {

	private ProdutoService service = new ProdutoService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoProdutos getProdutos(@BeanParam ProdutoFilterBean produtoFilter) {
		if ((produtoFilter.getOffset() >= 0) && (produtoFilter.getLimit() > 0)) {
			return service.getProdutosByPagination(produtoFilter.getOffset(), produtoFilter.getLimit());
		}
		if (produtoFilter.getName() != null) {
			return service.getProdutoByName(produtoFilter.getName());
		}

		return service.getProdutos();
	}

	@GET
	@Path("{produtoId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProduto(@PathParam("produtoId") long id) {
		return service.getProduto(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Produto produto) {
		produto = service.saveProduto(produto);
		return Response.status(Status.CREATED).entity(produto).build();
	}

	@PUT
	@Path("{produtoId}")
	public void update(@PathParam("produtoId") long id, Produto produto) {
		produto.setId(id);
		service.updateProduto(produto);
	}

	@DELETE
	@Path("{produtoId}")
	public void delete(@PathParam("produtoId") long id) {
		service.deleteProduto(id);
	}
}
