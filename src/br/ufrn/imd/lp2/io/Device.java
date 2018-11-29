package br.ufrn.imd.lp2.io;

/**
 * Classe que armazena os tipos de acoes da atividade Device,
 * que podem ser "Connect" ou "Disconnect"
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class Device extends AbstractSuper {
	// Ação de conexao ou desconexao de um pendrive
	private String activity;
	
	/**
	 * Construtor de objeto Device
	 * @param activity Acao de conexao ou desconexao de um pendrive
	 */
	public Device(String activity) {
		this.setActivity(activity);
	}

	/**
	 * Metodo para retornar atividade de Device
	 * @return Acao de conexao ou desconexao de um pendrive
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * Metodo para mudar o tipo de atividade de Device
	 * @param activity Ação de conexao ou desconexao de um pendrive
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	/**
	 * Imprime a acao de conexao ou desconexao de um pendrive
	 */
	public void show() {
		System.out.println(getActivity());
	}
}
