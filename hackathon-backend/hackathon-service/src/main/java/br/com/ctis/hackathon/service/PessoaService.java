package br.com.ctis.hackathon.service;

import java.util.List;

import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.persistence.model.Pessoa;

public interface PessoaService extends GenericService<Long, Pessoa>
{

	/**
	 * 
	 * Listar todas as Pessoas cadastrados no sistema
	 * 
	 * @return {@link List<Pessoa>} - Lista com Pessoas cadastrados
	 * 
	 *         Listar todos as Pessoas cadastradas no sistema
	 * 
	 * @return {@link List<Pessoa>} - Lista com Pessoas cadastradas
	 * 
	 */
	List<Pessoa> listarTodos();

	/**
	 * Cadastrar uma nova Pessoas no sistema
	 * 
	 * 
	 * @param pessoaDTO - Parâmetro de entrada para cadastro do pessoa
	 * 
	 * @param pessoaDTO - Parâmetro de entrada para cadastro de Pessoa
	 * 
	 */
	void cadastrar(PessoaDTO pessoaDTO);

	/**
	 * Recuperar Pessoa pelo Id
	 * 
	 * @param id - Identificado do Pessoa na base de dados
	 * 
	 * 
	 * @return {@link Pessoa} - Representa um pessoa cadastrado no sistema
	 * 
	 * @return {@link Echo} - Representa um Pessoa cadastradada no sistema
	 * 
	 */
	Pessoa buscarPessoaPorId(Long id);
	
	void atualizar(PessoaDTO pessoaDTO, Long id);

}
