package br.ufrn.imd.lp2.io;

/**
 * Classe pai usada para armazenar informacoes dos arquivos
 * Suas informacoes sao usadas para construcao da arvore
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class LogEntry {
	
	private String id;
	private String date;
	private String user;
	private String pc;
	
	/**
	 * Construtor padrao de LogEntry
	 */
	public LogEntry() {
		
	}
	
	/**
	 * Construtor do objeto LogEntry
	 * @param id ID da acao executada
	 * @param date Data da acao
	 * @param user ID do usuario
	 * @param pc Dispositivo que foi usado pelo usuario
	 */
	public LogEntry(String id, String date, String user, String pc) {
		this.setId(id);
		this.setDate(date);
		this.setUser(user);
		this.setPc(pc);
	}

	/**
	 * Metodo para retornar id da acao
	 * @return Id do acao
	 */
	public String getId() {
		return id;
	}

	/**
	 * Metodo para alterar id da acao
	 * @param id novo id para a acao
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Metodo para retornar a data da acao
	 * @return Data da acao
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Altera data da acao
	 * @param date Nova data a ser inserida
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Metodo para retornar o ID do usuario
	 * @return ID do usuario
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Altera ID de usuario 
	 * @param user Novo ID de usuario 
	 */
	public void setUser(String user) {
		this.user = user.substring(5,12);
	}

	/**
	 * Metodo para retornar dispositivo usado pelo usuario
	 * @return Disposito usado
	 */
	public String getPc() {
		return pc;
	}

	/**
	 * Altera dispositivo usado na acao
	 * @param pc Novo dispositivo a ser armazenado
	 */
	public void setPc(String pc) {
		this.pc = pc;
	}
	
}
