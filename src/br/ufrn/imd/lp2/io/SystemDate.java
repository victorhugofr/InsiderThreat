package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena a data da ação feita
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class SystemDate extends AbstractSuper {
	//data bruta, contentendo hora e a data completa
	private String all;
	//dia em que ação foi realizada
	private String day;
	//hora em que a ação foi realizada
	private String hour;
	/**
	 * Construtor de objeto SystemDate
	 * @param data Data no formato de string
	 */
	public SystemDate(String data) {
		all = data;
		day = data.substring(0, 10);
		hour = data.substring(11, 13);
	}
	/**
	 * Método para retornar o dia da ação
	 * @return Dia da ação
	 */
	public String getDate() {
		return day;
	}
	/**
	 * Muda o dia da ação realizada
	 * @param date Novo dia da ação realizada
	 */
	public void setDate(String date){
		this.day = date;
	}
	/**
	 * Método para retornar a data bruta da ação
	 * @return Data bruta da ação
	 */
	public String getAll() {
		return all;
	}
	/**
	 * Método para retornar o dia da ação
	 * @return Dia da ação
	 */
	public String getDay() {
		return day;
	}
	/**
	 * Método para retornar a hora da ação
	 * @return Hora da ação
	 */
	public String getHour() {
		return hour;
	}
	/**
	 * Imprime o dia da ação
	 */
	public void show() {
		System.out.println(getDay());
	}
}
