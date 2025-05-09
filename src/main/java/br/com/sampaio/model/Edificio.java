package br.com.sampaio.model;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sampaio.enums.Uf;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column (name = "nome", length = 100)
	@NotBlank(message = "O campo nome não pode estar em branco")
	@NotNull(message = "O campo nome não pode estar em branco")
	@Size(min=4, max=100, message = "Minimo 4 caracteres")
	private String nome;
		
	@Column (name = "endereco", length = 40)
	@NotBlank(message = "O campo endereço não pode estar em branco")
	private String endereco;
	
	@Column (name = "bairro", length = 40)
	@NotBlank(message = "O campo bairro não pode estar em branco")
    private String bairro;
	
	@NotBlank(message = "O campo cidade não pode estar em branco")
	@Column (name = "cidade", length = 40)
	private String cidade;
	
	@Column (name = "cep", length = 15)
    private String cep;
	
	
	@NotBlank(message = "Selecione uma UF")
	@Column (name = "uf", length = 2)
	@Enumerated(EnumType.STRING)
	private Uf uf;
	
	@Column (name = "sindico", length = 40)
    private String sindico;
	
	@Column (name = "fones1", length = 15)
    private String fones1;
	
	@Column (name = "zelador", length = 40)
    private String zelador;
	
	@Column (name = "fonez1", length = 15)
    private String fonez1;
    
	@Column (name = "mandato")
	private LocalDate mandato;

	@Column (name = "seguro")
	private LocalDate seguro;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getSindico() {
		return sindico;
	}
	public void setSindico(String sindico) {
		this.sindico = sindico;
	}
	public String getFones1() {
		return fones1;
	}
	public void setFones1(String fones1) {
		this.fones1 = fones1;
	}
	public String getZelador() {
		return zelador;
	}
	public void setZelador(String zelador) {
		this.zelador = zelador;
	}
	public String getFonez1() {
		return fonez1;
	}
	public void setFonez1(String fonez1) {
		this.fonez1 = fonez1;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
    
	public LocalDate getMandato() {
		return mandato;
	}	

	public void setMandato(LocalDate mandato) {
		this.mandato = mandato;
	}	

    public LocalDate getSeguro() {
		return seguro;
	}
	public void setSeguro(LocalDate seguro) {
		this.seguro = seguro;
	}
}
