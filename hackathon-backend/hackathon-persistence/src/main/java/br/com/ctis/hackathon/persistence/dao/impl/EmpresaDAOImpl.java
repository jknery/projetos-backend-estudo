package br.com.ctis.hackathon.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.EmpresaDAO;
import br.com.ctis.hackathon.persistence.model.Empresa;

@Stateless
public class EmpresaDAOImpl extends GenericDAOImpl<Long, Empresa> implements EmpresaDAO {

	@Override
	public List<Empresa> listarTodos() throws DAOException {
		TypedQuery<Empresa> query = getEntityManager().createQuery("SELECT e FROM Empresa e JOIN FETCH e.telefones", Empresa.class);

		try {
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException();
		}

	}

	@Override
	public Empresa buscarEmpresaPorId(Long id) throws RegistroNaoEncontradoException, DAOException {
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT e FROM Empresa e JOIN FETCH e.telefones").append(" WHERE e.id =:id ");

		TypedQuery<Empresa> query = getEntityManager().createQuery(builder.toString(), Empresa.class);
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
