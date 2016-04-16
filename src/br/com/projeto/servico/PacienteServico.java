package br.com.projeto.servico;

import java.util.List;

import javax.inject.Inject;

import br.com.projeto.entidade.Paciente;
import br.com.projeto.excecao.CampoObrigatorioExcecao;
import br.com.projeto.excecao.PreencherCamposObrigatoriosExcecao;
import br.com.projeto.repositorio.PacienteRepositorio;
import br.com.projeto.util.Paginador;

@SuppressWarnings("unchecked")
public class PacienteServico {

	@Inject
	private PacienteRepositorio pacienteRepositorio;

	public List<Paciente> getAllOrdenadoPorId() {
		return (List<Paciente>) pacienteRepositorio.getAllOrdenadoPorAtributo("id");
	}

	public Paciente getId(Long id) {
		return (Paciente) pacienteRepositorio.getId(id);
	}

	public Paciente salvar(Paciente paciente) {
		validar(paciente);
		return (Paciente) pacienteRepositorio.salvar(paciente);
	}

	private void validar(Paciente paciente) {
		if (paciente == null) {
			throw new PreencherCamposObrigatoriosExcecao();
		}
		if (paciente.getCpf() == null) {
			throw new CampoObrigatorioExcecao("CPF");
		}
	}

	public Paginador<Paciente> getAllPaginado(Paginador<Paciente> paginador) {
		paginador.setTotalDeResultado(pacienteRepositorio.getQtdDeRegistros());
		Integer inicio = (paginador.getPagina() - 1) * paginador.getRegistrosPorPagina();
		paginador.setList((List<Paciente>) pacienteRepositorio.getAllPaginado(inicio,
				paginador.getRegistrosPorPagina(), paginador.getOrdenarCampo(), paginador.getTipoDaOrdenacao()));
		return paginador;
	}

	public Paciente getCpf(Long cpf) {
		return pacienteRepositorio.getCpf(cpf);
	}

}
