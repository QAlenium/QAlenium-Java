package br.com.empresa.almintegration.helper;

import java.io.Serializable;

/**
 * Fabrica<BR>
 *
 * AUT-126 - Relatorio de execucao em Excel<BR>
 *
 * @since 8 de jul de 2016 13:23:54
 * @author Gabriel Aguido Fraga<BR>
 *         Fabrica<BR>
 * 
 *         automation
 */
public class CT implements Serializable {

	private static final long serialVersionUID = 6465805313364021835L;

	private String id;
	private String classe;
	private String tipo;
	private String modulo;
	private String ct;
	private String observacao;
	
	// Getters and Setters
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}