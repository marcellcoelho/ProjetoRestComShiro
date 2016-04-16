package br.com.projeto.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.projeto.entidade.GenericEntity;
import br.com.projeto.util.Constantes;

@SuppressWarnings("unchecked")
public abstract class RepositorioGenerico implements Serializable {
	private static final long serialVersionUID = 1394842560895255717L;

	@PersistenceContext
	private EntityManager entityManager;

	public List<? extends GenericEntity> getAll() {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT * FROM ");
		sql.append(obterClasse().getSimpleName());
		return getEntityManager().createQuery(sql.toString()).getResultList();
	}
	
	public List<? extends GenericEntity> getAllPaginado(Integer inicio, Integer qtdDeRegistroPorPagina, String ordenacaoDoCampo, String direcaoDaOrdenacao) {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT T FROM ");
		sql.append(obterClasse().getSimpleName());
		sql.append(" T ORDER BY ");
		sql.append(ordenacaoDoCampo);
		sql.append(Constantes.ESPACO_EM_BRANCO);
		sql.append(direcaoDaOrdenacao);
		Query query = getEntityManager().createQuery(sql.toString());
        query.setFirstResult(inicio);
        query.setMaxResults(qtdDeRegistroPorPagina);
        return query.getResultList();
	}
	
	public Long getQtdDeRegistros() {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT COUNT(T) FROM ");
		sql.append(obterClasse().getSimpleName());
		sql.append(" T");
		Query query = getEntityManager().createQuery(sql.toString());
		return (Long) query.getSingleResult();
	}
	
	public List<? extends GenericEntity> getAllOrdenadoPorAtributo(String atributo) {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT * FROM ");
		sql.append(obterClasse().getSimpleName());
		sql.append(" T ORDER BY ");
		sql.append(atributo);
		return getEntityManager().createQuery(sql.toString()).getResultList();
	}

	public GenericEntity salvar(GenericEntity objeto) {
		return ((GenericEntity) getEntityManager().merge(objeto));
	}

	public void excluir(GenericEntity objeto) {
		this.entityManager.remove(getEntityManager().getReference(obterClasse(), objeto.obterIdentificador()));
	}

	public GenericEntity getId(GenericEntity objeto) {
		return ((GenericEntity) getEntityManager().find(obterClasse(), objeto.obterIdentificador()));
	}
	
	public GenericEntity getId(Long objeto) {
		return ((GenericEntity) getEntityManager().find(obterClasse(), objeto));
	}

	public abstract Class<? extends GenericEntity> obterClasse();

	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}