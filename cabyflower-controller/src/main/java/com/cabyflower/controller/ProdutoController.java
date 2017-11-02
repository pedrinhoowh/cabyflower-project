package com.cabyflower.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cabiflower.dto.ProdutoDTO;
import com.cabyflower.service.ProdutoService;

import controller.CabyflowerController;

@Stateless
@Path("/produto")
public class ProdutoController extends CabyflowerController {

	private static final long serialVersionUID = -19763962481207512L;

	@EJB
	private ProdutoService produtoService;

	@POST
	@Path("/save-produto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveProduto(ProdutoDTO produtoDTO) {
		return ok(produtoService.save(produtoDTO));
	}
	
	@GET
	@Path("/get-produto/{idProduto}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getProduto(@PathParam("idProduto") Long idProduto) {
		return ok(produtoService.getProduto(idProduto));
	}
	
	@GET
	@Path("/get-produtos-for-home")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getProdutosForHome() {
		return ok(produtoService.getProdutosForHome());
	}
}
