package br.com.projeto.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PACIENTE")
@SequenceGenerator(name = "SQ_PACIENTE", sequenceName = "SQ_PACIENTE", allocationSize = 1)
public class Paciente extends GenericEntity {

	private static final long serialVersionUID = -2513438435284835378L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PACIENTE")
	@Column(name = "ID_PACIENTE")
	private Long id;
	
	@Column(name = "DS_NOME")
	private String nome;
	
	@Column(name = "NU_CPF")
	private String cpf;
	
	@Column(name = "NU_RG")
	private String rg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// public LocalDate getDataDeNascimento() {
	// return dataDeNascimento;
	// }
	//
	// public void setDataDeNascimento(LocalDate dataDeNascimento) {
	// this.dataDeNascimento = dataDeNascimento;
	// }

	@Override
	public Serializable obterIdentificador() {
		return this.id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
