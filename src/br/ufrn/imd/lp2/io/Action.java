package br.ufrn.imd.lp2.io;

/**
 * Classe que armazena o tipo de atividade exercida pelo usuario
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Action extends AbstractSuper {
	// Tipo de atividade
	private String id;
	
	/**
	 * Construtor do objeto Action
	 * @param id Tipo de atividade exercida pelo usuario
	 */
	public Action(String id) {
		this.id = id;
	}

	/**
	 * Metodo que retorna o tipo de atividade
	 * @return Tipo de atividade
	 */
	public String getId() {
		return id;
	}

	/**
	 * Altera o tipo de atividade
	 * @param id Tipo de atividade
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Imprime o tipo de atividade
	 */
	public void show() {
		System.out.println(getId());
	}
}
