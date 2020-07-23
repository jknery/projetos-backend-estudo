package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.converter.Converter;
import br.com.ctis.hackathon.dto.EmpresaDTO;
import br.com.ctis.hackathon.dto.EnderecoDTO;
import br.com.ctis.hackathon.dto.TelefoneDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.EmpresaDAO;
import br.com.ctis.hackathon.persistence.model.Empresa;
import br.com.ctis.hackathon.persistence.model.Endereco;
import br.com.ctis.hackathon.persistence.model.Telefone;
import br.com.ctis.hackathon.service.EmpresaService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class EmpresaServiceImpl extends GenericServiceImpl<Long, Empresa> implements EmpresaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293962397290614356L;
	@EJB
	private EmpresaDAO empresaDAO;

	@Override
	public List<Empresa> listarTodos() {
		try {
			return empresaDAO.listarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(EmpresaDTO empresaDTO) {

		empresaDAO.gravar(Converter.getInstance().converter(empresaDTO, Empresa.class));

	}

	@Override
	public Empresa buscarEmpresaPorId(Long id) {
		try {
			return empresaDAO.buscarEmpresaPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Empresa com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void atualizar(EmpresaDTO empresaDTO, Long id) {
		Empresa empresa = empresaDAO.consultarPorId(id);
		empresaDAO.gravar(mapper(empresa, empresaDTO));
	}

	private Empresa mapper(Empresa empresa, EmpresaDTO empresaDTO) {

		empresa.setEmail(empresaDTO.getEmail());
		empresa.setCnpj(empresaDTO.getCnpj());
		empresa.setNomeFantasia(empresaDTO.getNomeFantasia());
		empresa.setRazaoSocial(empresaDTO.getRazaoSocial());
		empresa.setEndereco(mapper(empresa.getEndereco(), empresaDTO.getEndereco()));
		empresa.setTelefones(mapper(empresa.getTelefones(), empresaDTO.getTelefones()));
		return empresa;

	}

	private Endereco mapper(Endereco endereco, EnderecoDTO enderecoDTO) {
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		endereco.setUF(enderecoDTO.getUF());

		return endereco;

	}
	private List<Telefone> mapper(List<Telefone> telefone, List<TelefoneDTO> telefoneDTO)
	{
		for (int i = 0; i < telefoneDTO.size(); i++)
		{
			telefone.set(i, mapper(telefone.get(i),telefoneDTO.get(i)));
		}

		return telefone;
	}
	
	private Telefone mapper(Telefone telefone,TelefoneDTO telefoneDTO)
	{
		telefone.setNumero(telefoneDTO.getNumero());
		
		return telefone;
	}

	

}
