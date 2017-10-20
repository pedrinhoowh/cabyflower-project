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

import com.cabiflower.dto.UsuarioDTO;
import com.cabyflower.service.UsuarioService;

import controller.CabyflowerController;
import exception.SenhaException;


@Stateless
@Path("/usuario")
public class UsuarioController extends CabyflowerController {

	private static final long serialVersionUID = -19763962481207512L;

	@EJB
	private UsuarioService usuarioService;
	
	@POST
	@Path("/save-usuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveUsuario(UsuarioDTO usuarioDTO) {
		try {
			return ok(usuarioService.save(usuarioDTO));
		} catch (SenhaException e) {
			return badRequest();
		}
	}
	
	@GET
	@Path("/get-usuario/{idUsuario}")
	public Response getUsuario(@PathParam("idUsuario") Long idUsuario) {
		return ok(usuarioService.findOne(idUsuario));
	}
	
	@GET
	@Path("/login-user/{dsEmail}/{dsPassword}")
	public Response loginUser(@PathParam("dsEmail") String dsEmail, @PathParam("dsPassword") String dsPassword) {
		try {
			return ok(usuarioService.loginUser(dsEmail, dsPassword));
		} catch (SenhaException e) {
			return badRequest();
		}
	}

}
