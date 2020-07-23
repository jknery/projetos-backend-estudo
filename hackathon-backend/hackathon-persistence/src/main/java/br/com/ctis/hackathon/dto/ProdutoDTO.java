package br.com.ctis.hackathon.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.ctis.hackathon.enumeration.Status;

public class ProdutoDTO extends BaseDTO
{

	private static final long serialVersionUID = -6215189734906537262L;

	@NotBlank(message = "Nome nao pode esta vazio")
	@NotNull(message = "Nome nao pode esta nulo")
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "preco", nullable = false, length = 255)
	private BigDecimal preco;

	@NotBlank(message = "Data nao pode esta vazio")
	@NotNull(message = "Data nao pode esta nulo")
	@Column(name = "dataCriacao", nullable = false, length = 255)
	private String dataCriacao;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produtos")
	private List<CategoriaDTO> categorias;
	
	private Status status;
	

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public BigDecimal getPreco()
	{
		return preco;
	}

	public void setPreco(BigDecimal preco)
	{
		this.preco = preco;
	}

	public String getDataCriacao()
	{
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao)
	{
		this.dataCriacao = dataCriacao;
	}

	public List<CategoriaDTO> getCategoria()
	{
		return categorias;
	}

	public void setCategoria(List<CategoriaDTO> categoria)
	{
		this.categorias = categoria;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	

}
