package br.com.ctis.hackathon.service;

import java.util.List;

import br.com.ctis.hackathon.dto.EmpresaDTO;
import br.com.ctis.hackathon.persistence.model.Empresa;

public interface EmpresaService extends GenericService<Long,Empresa> {

	/**
	 * Listar todos os Empresa cadastrados no sistema
	 * 
	 * @return {@link List<Empresa>} - Lista com Pessoas cadastrados
	 */
	List<Empresa> listarTodos();

	/**
	 * Cadastrar um novo Empresa no sistema
	 * 
	 * @param empresaDTO - Parâmetro de entrada para cadastro do Empresa
	 */
	void cadastrar(EmpresaDTO empresaDTO);


	/**
	 * Recuperar Echo pelo Id
	 * 
	 * @param id - Identificado do Empresa na base de dados
	 * 
	 * @return {@link Empresa} - Representa uma Empresa cadastrado no sistema
	 */
	Empresa buscarEmpresaPorId(Long id);
	
	void atualizar(EmpresaDTO empresaDTO, Long id);

}
