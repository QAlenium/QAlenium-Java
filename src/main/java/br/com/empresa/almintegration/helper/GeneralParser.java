package br.com.empresa.almintegration.helper;

import java.io.Serializable;

/**
 * Fabrica<BR>
 *
 * AUT-28 - Minha Conta - Criacao de Endereco<BR>
 *
 * @since 27 de jun de 2016 14:50:05
 * @author Gabriel Aguido Fraga<BR>
 *         Fabrica<BR>
 * 
 *         automation
 */
public class GeneralParser implements Serializable {

	private static final long serialVersionUID = -8570261318668339986L;
	
	
	
	/**
	 * Fabrica<BR>
	 *
	 * AUT-126 - Relatorio de execucao em Excel<BR>
	 *
	 * @since 11 de jul de 2016 16:45:35
	 * @author Gabriel Aguido Fraga<BR>
	 */
	public static CT parseToCT (String line) {
		
		String[] linha = line.split(";");

		int cont = 0;
		
		if (linha != null) {

			CT ct = new CT();
			ct.setId(linha[cont++]);
			ct.setClasse(linha[cont++]);
			ct.setTipo(linha[cont++]);
			ct.setModulo(linha[cont++]);
			ct.setCt(linha[cont++]);
			ct.setObservacao(linha[cont++]);

			return ct;
		}
		
		return null;
	}
}
