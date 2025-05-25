package br.com.sampaio.model;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sampaio.enums.Uf;
import br.com.sampaio.enums.Pessoa;
import br.com.sampaio.enums.SimNao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "O campo nome não pode estar em branco")
	private Long idEdificio;
	
	@Column (name = "apto", length = 10)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String apto;
	
	@Column (name = "fracada", precision = 15, scale = 2)
	private BigDecimal fracada = BigDecimal.ZERO;

	@Column (name = "fracaog", precision = 15, scale = 2)
	private BigDecimal fracaog = BigDecimal.ZERO;

	@Column (name = "proprietario", length = 40)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String proprietario;

	@Column (name = "responsavel", length = 40)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String responsavel;

	@Column (name = "contato", length = 40)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String contato;

	@Column (name = "correio", length = 3)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String correio;

	@Column (name = "endereco", length = 40)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String endereco;

	@Column (name = "bairro", length = 40)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String bairro;

	@Column (name = "cidade", length = 40)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String cidade;

	@Column (name = "cep", length = 15)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String cep;

	@NotBlank(message = "Selecione uma UF")
	@Column (name = "uf", length = 2)
	@Enumerated(EnumType.STRING)
	private Uf uf;

	@Column (name = "fone1", length = 20)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String fone1;

	@Column (name = "fone2", length = 20)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String fone2;

	@Column (name = "fone3", length = 20)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String fone3;

	@Column (name = "fone4", length = 20)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String fone4;

	@Column (name = "cpf", length = 20)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String cpf;

	@NotBlank(message = "Selecione uma Pessoa")
	@Column (name = "pessoa", length = 5)
	@Enumerated(EnumType.STRING)
	private Pessoa pessoa;

	@Column (name = "email", length = 100)
	@NotNull(message = "O campo nome não pode estar em branco")
	private String email;

	@NotBlank(message = "Selecione uma opção")
	@Column (name = "imprimir", length = 3)
	@Enumerated(EnumType.STRING)
	private SimNao imprimir;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(Long idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getApto() {
		return apto;
	}	

	public void setApto(String apto) {
		this.apto = apto;
	}

	public BigDecimal getFracada() {
		return fracada;
	}

	public void setFracada(BigDecimal fracada) {
		this.fracada = fracada;
	}	

	public BigDecimal getFracaog() {
		return fracaog;
	}			

	public void setFracaog(BigDecimal fracaog) {
		this.fracaog = fracaog;
	}	

	public String getProprietario() {
		return proprietario;
	}	

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}	

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}	

	public String getCorreio() {
		return correio;
	}

	public void setCorreio(String correio) {
		this.correio = correio;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getCep() {
		return cep;
	}	

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}	

	public String getFone3() {
		return fone3;
	}	

	public void setFone3(String fone3) {
		this.fone3 = fone3;
	}

	public String getFone4() {
		return fone4;
	}

	public void setFone4(String fone4) {
		this.fone4 = fone4;
	}	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}	

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SimNao getImprimir() {
		return imprimir;
	}
	public void setImprimir(SimNao imprimir) {
		this.imprimir = imprimir;
	}
}
