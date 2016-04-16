package br.com.projeto.repositorio;

import br.com.projeto.entidade.GenericEntity;
import br.com.projeto.entidade.Paciente;

public class PacienteRepositorio extends RepositorioGenerico {

	private static final long serialVersionUID = 2580160965992557736L;
	
	@Override
	public Class<? extends GenericEntity> obterClasse() {
		return Paciente.class;
	}

	public Paciente getCpf(Long cpf) {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT * FROM TB_PACIENTE WHERE NU_CPF = ");
		sql.append(cpf);
		return (Paciente) getEntityManager().createNativeQuery(sql.toString(), Paciente.class).getSingleResult();
	}

}
