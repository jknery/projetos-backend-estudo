package br.com.ctis.hackathon.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.ctis.hackathon.enumeration.Status;

public class PessoaDTO extends BaseDTO
{
	private static final long serialVersionUID = -6213745649014907846L;

	@NotBlank(message = "Nome nao pode esta vazio")
	@NotNull(message = "Nome nao pode esta nulo")
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@NotBlank(message = "Sobrenome nao pode esta vazio")
	@NotNull(message = "Sobrenome nao pode esta nulo")
	@Column(name = "sobreNome", nullable = false, length = 255)
	private String sobreNome;

	@CPF
	@NotBlank(message = "cpf nao pode ser vazio")
	@NotNull(message = "cpf nao pode esta nulo")
	@Column(name = "cpf", nullable = false, length = 255)
	private String cpf;

	@Email
	@NotBlank(message = "Email nao pode ser vazio")
	@NotNull(message = "Email nao pode ser nulo")
	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private EnderecoDTO enderecos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoas")
	private List<TelefoneDTO> telefones;

	private Status status;
	
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getSobreNome()
	{
		return sobreNome;
	}

	public void setSobreNome(String sobreNome)
	{
		this.sobreNome = sobreNome;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public EnderecoDTO getEndereco() {
		return enderecos;
	}

	public void setEndereco(EnderecoDTO enderecos) {
		this.enderecos = enderecos;
	}
	
	public List<TelefoneDTO> getTelefone() {
		return telefones;
	}

	public void setTelefone(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
