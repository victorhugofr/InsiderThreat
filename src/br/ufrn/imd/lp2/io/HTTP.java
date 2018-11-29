package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena os tipos de ações da atividade HTTP,
 * que podem conter endereços acessados pelo usuario
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class HTTP extends AbstractSuper {
	// Url do site acessado
	private String url;
	
	/**
	 * Construtor de objeto Device
	 * @param url Url do site acessado
	 */
	public HTTP (String url) {
		this.setActivity(url);
	}

	/**
	 * Método para retornar atividade do HTTP
	 * @return Url do site acessado
	 */
	public String getActivity() {
		return url;
	}
	/**
	 * Método para mudar o tipo de atividade de HTTP
	 * @param activity Site acessado
	 */
	public void setActivity(String activity) {
		this.url = activity;
	}
	/**
	 * Imprime a ação de conexão ou desconexão de um pendrive
	 */
	public void show() {
		System.out.println(getActivity());
	}

}
