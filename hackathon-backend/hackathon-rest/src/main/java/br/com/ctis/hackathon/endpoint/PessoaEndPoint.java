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

import br.com.ctis.hackathon.dto.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Endpoint apenas com o intuito de testes da aplicação
 * 
 * @author Ivo Nery,Paulo Martins
 *
 */

@Path("pessoas")
@Tag(name = "Pessoa", description = "EndPoints referentas à Entidade PESSOA")
public interface PessoaEndPoint
{

	@GET
	@Produces("application/json")
	@Operation(description = "Lista as Pessoas cadastrados no sistema", summary = "Listar Pessoas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response listar();

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para cadastro de uma nova Pessoa no sistema", summary = "Adicionar nova Pessoa", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response cadastrar(
			@RequestBody(description = "Objeto Pessoa que será adicionado", required = true, content = @Content(schema = @Schema(implementation = PessoaDTO.class))) @Valid PessoaDTO pessoaDTO);

	@PUT
	@Path("{id}")
	@Consumes("application/json")
	@Produces("application/json")
	@Operation(description = "Recurso para atualizar de uma  Pessoa no sistema", summary = "Atualizar  Pessoa", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response atualizar(
			@RequestBody(description = "Objeto Pessoa que será atualizado", required = true, content = @Content(schema = @Schema(implementation = PessoaDTO.class))) @Valid PessoaDTO pessoaDTO, @PathParam(value = "id") Long id);

	
	
	
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Operation(description = "Deleta Pessoa pelo Id", summary = "Deleta Pessoas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response deletarPessoaPorId(@PathParam(value = "id") Long id);

	@GET
	@Produces("application/json")
	@Path("{id}")
	@Operation(description = "Recupera Pessoa pelo Id", summary = "Recuperar Pessoas", responses = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Not found"),
			@ApiResponse(responseCode = "500", description = "Internal Server Error") })
	Response buscarPessoaPorId(@PathParam(value = "id") Long id);

}
