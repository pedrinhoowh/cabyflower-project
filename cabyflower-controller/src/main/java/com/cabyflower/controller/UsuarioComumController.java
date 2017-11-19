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

import com.cabiflower.dto.UsuarioComumDTO;
import com.cabyflower.service.UsuarioComumService;

import controller.CabyflowerController;

@Stateless
@Path("/usuario-comum")
public class UsuarioComumController extends CabyflowerController {

	private static final long serialVersionUID = -19763962481207512L;

	@EJB
	private UsuarioComumService usuarioComumService;

	@POST
	@Path("/save-usuario-comum")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveUsuarioComum(UsuarioComumDTO usuarioComumDTO) {
		return ok(usuarioComumService.save(usuarioComumDTO));
	}
	
	@GET
	@Path("/get-usuario-comum/{idUser}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getUsuarioComum(@PathParam("idUser") Long idUser) {
		return ok(usuarioComumService.findOne(idUser));
	}
	
	@GET
	@Path("/get-usuario-comum-usuario/{idUsuario}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getUsuarioComumForUsuario(@PathParam("idUsuario") Long idUsuario) {
		return ok(usuarioComumService.getUsuarioComumForUsuario(idUsuario));
	}
}
