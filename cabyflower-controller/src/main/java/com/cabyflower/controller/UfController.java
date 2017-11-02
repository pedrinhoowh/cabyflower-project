package com.cabyflower.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cabyflower.service.UfService;

import controller.CabyflowerController;

@Stateless
@Path("/uf")
public class UfController extends CabyflowerController {

	private static final long serialVersionUID = -19763962481207512L;

	@EJB
	private UfService ufService;
	
	@GET
	@Path("/get-uf/{idUf}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getUf(@PathParam("idUf") Long idUf) {
		return ok(ufService.findOne(idUf));
	}
	
	@GET
	@Path("/get-all-uf")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAll() {
		return ok(ufService.getAll());
	}
}
