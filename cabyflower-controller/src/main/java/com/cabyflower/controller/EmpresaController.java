package com.cabyflower.controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cabiflower.dto.EmpresaDTO;
import com.cabiflower.dto.EmpresaFIlterDTO;
import com.cabyflower.service.EmpresaService;

import controller.CabyflowerController;

@Stateless
@Path("/empresa")
public class EmpresaController extends CabyflowerController {

	private static final long serialVersionUID = -19763962481207512L;

	@EJB
	private EmpresaService empresaService;
	
	@POST
	@Path("/save-empresa")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveEmpresa(EmpresaDTO empresaDTO) {
		return ok(empresaService.save(empresaDTO));
	}
	
	@GET
	@Path("/get-empresa/{idEmpresa}")
	public Response getEmpresa(@PathParam("idEmpresa") Long idEmpresa) {
		return ok(empresaService.findOne(idEmpresa));
	}
	
	@GET
	@Path("/get-empresas")
	public Response getEmpresasForFilter(@BeanParam EmpresaFIlterDTO empresaFilter) {
		return ok(empresaService.getEmpresaForFilter(empresaFilter));
	}
	
	@GET
	@Path("/get-empresa/{idUser}")
	public Response getEmpresaForUser(@PathParam("idUser") Long idUser) {
		return ok(empresaService.getEmpresaForUsuario(idUser));
	}
}
