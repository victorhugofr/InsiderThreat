package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena os tipos de ações da atividade Logon,
 * que podem ser "Logon" ou "Logoff"
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Logon extends AbstractSuper{
	
	private String activity;
	
	public Logon(){
		
	}
	/**
	 * Construtor de objeto Logon
	 * @param activity Ação de logon ou logoff de um usuario
	 */
	public Logon(String activity) {
		this.setActivity(activity);
	}
	/**
	 * Método para retornar atividade de Logon
	 * @return Ação de logon ou logoff de um usuario
	 */
	public String getActivity() {
		return activity;
	}
	/**
	 * Método para mudar o tipo de atividade de Logon
	 * @param activity Ação de logon ou logoff de um usuario
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	/**
	 * Imprime a ação de logon ou logoff de um usuario
	 */
	public void show() {
		System.out.println(getActivity());
	}
	
}
