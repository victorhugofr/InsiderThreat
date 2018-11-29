package br.ufrn.imd.lp2.io;

/**
 * Classe usada para armazenar linhas do arquivo device.csv
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class DeviceLE extends LogEntry{
	// Atividade de conexão ou desconexão de um pendrive
	private String connection;
	
	/**
	 * Construtor do objeto DeviceLE
	 * @param id ID da ação executada
	 * @param date Data da ação
	 * @param user ID do usuário
	 * @param pc Dispositivo que foi usado pelo usuário
	 * @param connection Ação de conexão ou desconexão de um pendrive
	 */
	public DeviceLE(String id, String date, String user, String pc, String connection) {
		super(id, date, user, pc);
		this.setConnection(connection);
	}

	/**
	 * Retorna a atividade de conexão ou desconexão de um pendrive
	 * @return Atividade do usuário com o pendrive
	 */
	public String getConnection() {
		return connection;
	}

	/**
	 * Muda o tipo da atividade com o pendrive
	 * @param connection Atividade de conexão ou desconexão do pendrive
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}
}

