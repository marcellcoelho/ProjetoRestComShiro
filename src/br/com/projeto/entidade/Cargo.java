package br.com.projeto.entidade;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CARGO")
@SequenceGenerator(name = "SQ_CARGO", sequenceName = "SQ_CARGO", allocationSize = 1)
public class Cargo extends GenericEntity {

	private static final long serialVersionUID = -8661575897844960995L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARGO")
	@Column(name = "ID_CARGO")
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@Column(name = "DS_NOME")
	private String nome;

	@ManyToMany(mappedBy = "cargoList")
	private List<Permissao> permissaoList;

	@ManyToMany(mappedBy = "cargoList")
	private List<Usuario> usuarioList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Permissao> getPermissaoList() {
		return permissaoList;
	}

	public void setPermissaoList(List<Permissao> permissaoList) {
		this.permissaoList = permissaoList;
	}

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	@Override
	public Serializable obterIdentificador() {
		return this.id;
	}

}