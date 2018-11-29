package br.ufrn.imd.lp2.io;

/**
 * Classe que armazena os tipos de ações da atividade Device,
 * que podem ser "Connect" ou "Disconnect"
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Device extends AbstractSuper {
	// Ação de conexão ou desconexão de um pendrive
	private String activity;
	
	/**
	 * Construtor de objeto Device
	 * @param activity Ação de conexão ou desconexão de um pendrive
	 */
	public Device(String activity) {
		this.setActivity(activity);
	}

	/**
	 * Método para retornar atividade de Device
	 * @return Ação de conexão ou desconexão de um pendrive
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * Método para mudar o tipo de atividade de Device
	 * @param activity Ação de conexão ou desconexão de um pendrive
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	/**
	 * Imprime a ação de conexão ou desconexão de um pendrive
	 */
	public void show() {
		System.out.println(getActivity());
	}
}
