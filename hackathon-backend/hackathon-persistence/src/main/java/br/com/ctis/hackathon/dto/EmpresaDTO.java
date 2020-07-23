package br.com.ctis.hackathon.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.ctis.hackathon.enumeration.Status;

public class EmpresaDTO extends BaseDTO
{

	private static final long serialVersionUID = -4391224680210251695L;

	@Column(name = "razaoSocial", nullable = false, length = 255)
	private String razaoSocial;

	@Column(name = "nomeFantasia", nullable = false, length = 255)
	private String nomeFantasia;
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	@Column(name = "cnpj", nullable = false, length = 255)
	private String cnpj;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "empresas")
	private List<TelefoneDTO> telefones;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "empresas")
	private EnderecoDTO endereco;
	
	private Status status;

	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia()
	{
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia)
	{
		this.nomeFantasia = nomeFantasia;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	public List<TelefoneDTO> getTelefones()
	{
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones)
	{
		this.telefones = telefones;
	}

	public EnderecoDTO getEndereco()
	{
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco)
	{
		this.endereco = endereco;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
