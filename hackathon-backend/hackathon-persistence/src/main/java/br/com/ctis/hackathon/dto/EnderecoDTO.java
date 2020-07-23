package br.com.ctis.hackathon.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.ctis.hackathon.persistence.model.Empresa;
import br.com.ctis.hackathon.persistence.model.Pessoa;

public class EnderecoDTO
{
	@Column(name = "Logradouro", nullable = false, length = 255)
	private String logradouro;

	@Column(name = "Complemento", nullable = false, length = 255)
	private String complemento;

	@Column(name = "Bairro", nullable = false, length = 255)
	private String bairro;

	@Column(name = "cidade", nullable = false, length = 255)
	private String cidade;

	@Column(name = "UF", nullable = false, length = 255)
	private String UF;

	@OneToOne(mappedBy = "enderecos",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pessoa pessoas;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "enderecos")
	private Empresa empresas;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

}
