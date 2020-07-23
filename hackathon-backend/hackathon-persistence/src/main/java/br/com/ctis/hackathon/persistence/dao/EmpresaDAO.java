package br.com.ctis.hackathon.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;

import br.com.ctis.hackathon.persistence.model.Empresa;

@Local
public interface EmpresaDAO extends GenericDAO<Long,Empresa>{
	
List<Empresa> listarTodos() throws DAOException;
	
	Empresa buscarEmpresaPorId(Long id) throws RegistroNaoEncontradoException, DAOException;

}
