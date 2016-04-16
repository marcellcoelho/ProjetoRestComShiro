package br.com.projeto.entidade;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {

	private static final long serialVersionUID = -3711065710407993086L;

	public abstract Serializable obterIdentificador();
}