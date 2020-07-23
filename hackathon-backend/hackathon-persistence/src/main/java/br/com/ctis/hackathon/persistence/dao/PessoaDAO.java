package br.com.ctis.hackathon.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;

import br.com.ctis.hackathon.persistence.model.Pessoa;

@Local
public interface PessoaDAO extends GenericDAO<Long, Pessoa>{

	List<Pessoa> listarTodos() throws DAOException;

	Pessoa buscarPessoaPorId(Long id) throws RegistroNaoEncontradoException, DAOException;

}
