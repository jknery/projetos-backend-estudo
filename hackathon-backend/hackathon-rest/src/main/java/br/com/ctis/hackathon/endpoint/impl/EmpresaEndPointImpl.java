package br.com.ctis.hackathon.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.hackathon.dto.EmpresaDTO;
import br.com.ctis.hackathon.dto.MensagemRetornoDTO;
import br.com.ctis.hackathon.endpoint.EmpresaEndPoint;
import br.com.ctis.hackathon.service.EmpresaService;

public class EmpresaEndPointImpl implements EmpresaEndPoint {

	@EJB
	private EmpresaService empresaService;

	@Override
	public Response listar() {
		return Response.status(Status.OK).entity(empresaService.listarTodos()).build();
	}

	@Override
	public Response cadastrar(EmpresaDTO empresaDTO) {
		empresaService.cadastrar(empresaDTO);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Empresa cadastrado com sucesso!"))
				.build();
	}

	@Override
	public Response buscarEmpresaPorId(Long id) {
		return Response.status(Status.OK).entity(empresaService.buscarEmpresaPorId(id)).build();
	}

	@Override
	public Response deletarEmpresaPorId(Long id) {
		// TODO Auto-generated method stub
		empresaService.excluir(id);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Empresa excluida com sucesso")).build();
		}

	@Override
	public Response atualizar(EmpresaDTO empresaDTO, Long id)
	{
		empresaService.atualizar(empresaDTO, id);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Empresa atualizada com sucesso")).build();
	}

}
