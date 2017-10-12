package com.cabyflower.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.cabyflower.service.MunicipioService;

import controller.CabyflowerController;

@Stateless
@Path("/municipio")
public class MunicipioController extends CabyflowerController {

	private static final long serialVersionUID = -19763962481207512L;

	@EJB
	private MunicipioService municipioService;
	
	@GET
	@Path("/get-municipio/{idMunicipio}")
	public Response getMunicipio(@PathParam("idMunicipio") Long idMunicipio) {
		return ok(municipioService.findOne(idMunicipio));
	}
	
	@GET
	@Path("/get-all-municipiof")
	public Response getAll() {
		return ok(municipioService.getAll());
	}
	
	@GET
	@Path("/get-municipio/{idUf}")
	public Response getAllMunicipioInUf(@PathParam("idUf") Long idUf) {
		return ok(municipioService.getAllMunicipioInUf(idUf));
	}
}
