package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena o computador acessado pelo nó
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class PC extends AbstractSuper{

	private String pcId;
	/**
	 * Construtor de objeto PC
	 * @param pcId Identificador do computador
	 */
	public PC(String pcId) {
		this.pcId = pcId;
	}
	/**
	 * Método para retornar o identificador do computador
	 * @return Identificador do computador
	 */
	public String getPcId() {
		return pcId;
	}
	/**
	 * Imprime o identificador do computador
	 */
	public void show() {
		System.out.println(getPcId());
	}
}
