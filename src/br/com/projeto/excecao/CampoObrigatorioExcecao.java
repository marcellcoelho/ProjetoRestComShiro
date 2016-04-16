package br.com.projeto.excecao;

import br.com.projeto.util.MsgConstantes;
import br.com.projeto.util.Properties;

public class CampoObrigatorioExcecao extends RuntimeException {

  private static final long serialVersionUID = -4449977740851771578L;

  public CampoObrigatorioExcecao(String campo) {
    super(Properties.obterMensagem(MsgConstantes.CAMPO_OBRIGATORIO, campo));
  }

}
