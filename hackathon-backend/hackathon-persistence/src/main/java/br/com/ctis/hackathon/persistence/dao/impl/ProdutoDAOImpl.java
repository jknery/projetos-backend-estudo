package br.com.ctis.hackathon.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.ProdutoDAO;
import br.com.ctis.hackathon.persistence.model.Produto;

@Stateless
public class ProdutoDAOImpl extends GenericDAOImpl<Long, Produto> implements ProdutoDAO
{

	@Override
	public List<Produto> listarTodos() throws DAOException {

		TypedQuery<Produto> query = getEntityManager().createQuery("SELECT e FROM Produto e JOIN FETCH e.categorias JOIN FETCH e.produtos", Produto.class);

		try {
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException();
		}

	}

	@Override
	public Produto buscarProdutoPorId(Long id) throws RegistroNaoEncontradoException, DAOException {

		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT e FROM Produto e JOIN FETCH e.categorias JOIN FETCH e.produtos").append(" WHERE e.id =:id ");

		TypedQuery<Produto> query = getEntityManager().createQuery(builder.toString(), Produto.class);
		query.setParameter("id", id);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			throw new RegistroNaoEncontradoException();
		} catch (PersistenceException e) {
			throw new DAOException();
		}

	}

}
