package br.com.ctis.hackathon.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.model.Produto;



/**
 *	Classe de interfaceamento de Produtos!
 * 	Lista Todos
 * 	Busca pro Id
 */

@Local
public interface ProdutoDAO extends GenericDAO<Long, Produto> {

	List<Produto> listarTodos() throws DAOException;
	
	Produto buscarProdutoPorId(Long id) throws RegistroNaoEncontradoException, DAOException;
}

