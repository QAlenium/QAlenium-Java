package br.com.empresa.almintegration.testing.tn3270.applications.tiv25e01.at02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.empresa.almintegration.testing.tn3270.applications.MainframeFormScreens;

class TipoPagamento extends MainframeFormScreens{

	private String domBancario;
	private String banco;
	private String agencia;
	private String cc;
	
	public TipoPagamento(String text) {
		final String regex = "DOM.BANC.\\s*(.*)\\s*BCO:\\s*(.*)\\s*AG:\\s*(.*)\\s*C/C:\\s*(.*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		int i = 0;
		if(matcher.find()) {
			this.domBancario = matcher.group(++i).trim();
			this.banco = matcher.group(++i).trim();
			this.agencia = matcher.group(++i).trim();
			this.cc = matcher.group(++i).trim();
		}		
		System.out.println(String.format("Domicílio Bancário: %s\r\nBanco: %s\r\nAgência: %s\r\nCC:%s", this.domBancario, this.banco, this.agencia, this.cc));
	}

	public String getDomBancario() {
		return domBancario;
	}

	public String getBanco() {
		return banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getCc() {
		return cc;
	}	
}
