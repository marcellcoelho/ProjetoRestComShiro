package br.com.projeto.servico.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.projeto.entidade.Paciente;
import br.com.projeto.servico.PacienteServico;
import br.com.projeto.util.Paginador;

@Path("/paciente")
public class PacienteServicoRest {

	@Inject
	private PacienteServico pacienteServico;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(
			@DefaultValue("1") @QueryParam("pagina") Integer pagina,
			@DefaultValue("10") @QueryParam("registrosPorPagina") Integer registrosPorPagina,
			@DefaultValue("id") @QueryParam("ordenarCampo") String ordenarCampo,
			@DefaultValue("ASC") @QueryParam("tipoDaOrdenacao") String tipoDaOrdenacao) {
		
		Paginador<Paciente> paginador = new Paginador<>();
        paginador.setPagina(pagina);
        paginador.setOrdenarCampo(ordenarCampo);
        paginador.setTipoDaOrdenacao(tipoDaOrdenacao);
        paginador.setRegistrosPorPagina(registrosPorPagina);
        
        try {
        	return Response.status(Response.Status.OK).entity(pacienteServico.getAllPaginado(paginador)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getId(@PathParam("id") Long id) {
		try {
			return Response.status(Response.Status.OK).entity(pacienteServico.getId(id)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}
	
	@GET
	@Path("/cpf/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCpf(@PathParam("cpf") Long cpf) {
		try {
			return Response.status(Response.Status.OK).entity(pacienteServico.getCpf(cpf)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvar(Paciente paciente) {
		try {
			return Response.status(Response.Status.OK).entity(pacienteServico.salvar(paciente)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

}