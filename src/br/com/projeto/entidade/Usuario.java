package br.com.projeto.entidade;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
public class Usuario extends GenericEntity {

	private static final long serialVersionUID = -2644240694348222711L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
	@Column(name = "ID_USUARIO")
	private Long id;

	@Column(name = "DS_NOME")
	private String nome;

	@Column(name = "DS_USUARIO")
	private String usuario;

	@Column(name = "SHA_SENHA")
	private String senha;

	@ManyToMany
	@JoinTable(name = "TB_USUARIO_CARGO", joinColumns = { @JoinColumn(name = "FK_USUARIO") }, inverseJoinColumns = {
			@JoinColumn(name = "FK_CARGO") })
	private List<Cargo> cargoList;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Cargo> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}

	@Override
	public Serializable obterIdentificador() {
		return this.id;
	}

}