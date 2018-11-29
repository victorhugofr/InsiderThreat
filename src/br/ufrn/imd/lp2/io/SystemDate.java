package br.ufrn.imd.lp2.io;
/**
 * Classe que armazena a data da acao feita
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class SystemDate extends AbstractSuper {
	//data bruta, contentendo hora e a data completa
	private String all;
	//dia em que acao foi realizada
	private String day;
	//hora em que a acao foi realizada
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
	 * Metodo para retornar o dia da acao
	 * @return Dia da acao
	 */
	public String getDate() {
		return day;
	}
	/**
	 * Muda o dia da acao realizada
	 * @param date Novo dia da acao realizada
	 */
	public void setDate(String date){
		this.day = date;
	}
	/**
	 * Metodo para retornar a data bruta da acao
	 * @return Data bruta da acao
	 */
	public String getAll() {
		return all;
	}
	/**
	 * Metodo para retornar o dia da acao
	 * @return Dia da acao
	 */
	public String getDay() {
		return day;
	}
	/**
	 * Metodo para retornar a hora da acao
	 * @return Hora da acao
	 */
	public String getHour() {
		return hour;
	}
	/**
	 * Imprime o dia da acao
	 */
	public void show() {
		System.out.println(getDay());
	}
}
