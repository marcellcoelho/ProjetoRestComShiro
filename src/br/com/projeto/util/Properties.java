package br.com.projeto.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Properties {
	private static final String PATH_MENSAGENS_PROPERTIES = "META-INF/mensagens";

	public static String obterMensagem(String chave) {
		try {
			return obterResource(PATH_MENSAGENS_PROPERTIES).getString(chave);
		} catch (Exception e) {
			return chave;
		}
	}

	public static String obterMensagem(String chave, Object params) {
		String texto = obterMensagem(chave);
		if (texto == null) {
			return chave;
		}
		return MessageFormat.format(texto, params);
	}

	private static ResourceBundle obterResource(String path) {
		return ResourceBundle.getBundle(path);
	}
}