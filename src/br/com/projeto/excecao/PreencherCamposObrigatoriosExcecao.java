package br.com.projeto.excecao;

import br.com.projeto.util.MsgConstantes;
import br.com.projeto.util.Properties;

public class PreencherCamposObrigatoriosExcecao extends RuntimeException {

	private static final long serialVersionUID = -4449977740851771578L;

	public PreencherCamposObrigatoriosExcecao() {
		super(Properties.obterMensagem(MsgConstantes.NENHUM_CAMPO_PREENCHIDO));
	}

}
