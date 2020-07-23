package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.converter.Converter;
import br.com.ctis.hackathon.dto.CategoriaDTO;
import br.com.ctis.hackathon.dto.ProdutoDTO;

import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.ProdutoDAO;
import br.com.ctis.hackathon.persistence.model.Categoria;

import br.com.ctis.hackathon.persistence.model.Produto;

import br.com.ctis.hackathon.service.ProdutoService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProdutoServiceImpl extends GenericServiceImpl<Long, Produto> implements ProdutoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5475003271403115509L;

	@EJB
	private ProdutoDAO produtoDAO;

	@Override
	public List<Produto> listarTodos() {

		try {
			return produtoDAO.listarTodos();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(ProdutoDTO produtoDTO) {

		produtoDAO.gravar(Converter.getInstance().converter(produtoDTO, Produto.class));

	}

	@Override
	public Produto buscarProdutoPorId(Long id) {

		try {
			return produtoDAO.buscarProdutoPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Produto com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	@Override
	public void atualizar(ProdutoDTO produtoDTO, Long id) {
		try {
			Produto produto = produtoDAO.buscarProdutoPorId(id);
			produtoDAO.gravar(mapper(produto, produtoDTO));
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Pessoa com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	private Produto mapper(Produto produto, ProdutoDTO produtoDTO) {

		produto.setCategoria(mapper(produto.getCategoria(), produtoDTO.getCategoria()));
		produto.setDataCriacao(produtoDTO.getDataCriacao());
		produto.setPreco(produtoDTO.getPreco());
		produto.setNome(produtoDTO.getNome());

		return produto;
	}

	private List<Categoria> mapper(List<Categoria> categoria, List<CategoriaDTO> categoriaDTO) {

		for (int i = 0; i < categoriaDTO.size(); i++) {
			categoria.set(i, mapper(categoria.get(i), categoriaDTO.get(i)));

		}

		return categoria;
	}

	private Categoria mapper(Categoria categoria, CategoriaDTO categoriaDTO) {
		categoria.setCategoria(categoriaDTO.getCategoria());
		categoria.setProduto(categoriaDTO.getProdutos());
		return categoria;

	}

}
