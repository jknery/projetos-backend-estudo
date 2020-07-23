package br.com.ctis.hackathon.endpoint.impl;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ctis.hackathon.dto.ProdutoDTO;
import br.com.ctis.hackathon.dto.MensagemRetornoDTO;
import br.com.ctis.hackathon.endpoint.ProdutoEndPoint;
import br.com.ctis.hackathon.service.ProdutoService;

public class ProdutoEndPointImpl implements ProdutoEndPoint
{

	@EJB
	private ProdutoService produtoService;
	
	@Override
	public Response listar() {
		return Response.status(Status.OK).entity(produtoService.listarTodos()).build();
	}

	@Override
	public Response cadastrar(ProdutoDTO produtoDTO) {
		produtoService.cadastrar(produtoDTO);
		return Response.status(Status.CREATED).entity(new MensagemRetornoDTO("Produto cadastrado com sucesso!")).build();
	}

	@Override
	public Response buscarProdutoPorId(Long id) {
		return Response.status(Status.OK).entity(produtoService.buscarProdutoPorId(id)).build();
	}

	@Override
	public Response DeletePorId(Long id)
	{
		produtoService.excluir(id);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produto excluido com sucesso!")).build();

	}

	@Override
	public Response atualizar(ProdutoDTO produtoDTO, Long id) {
		produtoService.atualizar(produtoDTO, id);
		return Response.status(Status.OK).entity(new MensagemRetornoDTO("Produto atualizado com sucesso!")).build();

		}
	
	

}
