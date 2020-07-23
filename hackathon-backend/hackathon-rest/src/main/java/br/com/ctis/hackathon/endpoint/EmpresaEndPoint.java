package br.com.ctis.hackathon.endpoint;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctis.hackathon.dto.EmpresaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Endpoint apenas com o intuito de testes da aplicação
 * 
 * @author Paulo Martins
 *
 */
@Path("empresa")
@Tag(name = "Empresa", description = "EndPoints referentas à Entidade EMPRESA")
public interface EmpresaEndPoint {

	@GET
	@Produces("application/json")
	@Operation(description = "Lista as Empresas cadastrados no sistema", summary = "Listar Empresas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response listar();

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para cadastro de uma nova Empresa no sistema", summary = "Adicionar nova Empresa", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response cadastrar(
			@RequestBody(description = "Objeto Empresa que será adicionado", required = true, content = @Content(schema = @Schema(implementation = EmpresaDTO.class))) @Valid EmpresaDTO empresaDTO);

	
	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para atualizar  uma  Empresa no sistema", summary = "Atualizar Empresa", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response atualizar(
			@RequestBody(description = "Objeto Empresa que será atualizado", required = true, content = @Content(schema = @Schema(implementation = EmpresaDTO.class))) @Valid EmpresaDTO empresaDTO, @PathParam(value = "id") Long id);

	
	@GET
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Recupera a Empresa pelo Id", summary = "Recuperar Empresas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response buscarEmpresaPorId(@PathParam(value = "id") Long id);

	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Excluir empresa pelo Id", summary = "Excluir empresa", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response deletarEmpresaPorId(@PathParam(value = "id") Long id);

}
