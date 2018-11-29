package br.ufrn.imd.lp2.io;

/**
 * Classe usada para armazenar linhas do arquivo device.csv
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class DeviceLE extends LogEntry{
	// Atividade de conexao ou desconexao de um pendrive
	private String connection;
	
	/**
	 * Construtor do objeto DeviceLE
	 * @param id ID da acao executada
	 * @param date Data da acao
	 * @param user ID do usuario
	 * @param pc Dispositivo que foi usado pelo usuario
	 * @param connection Ação de conexao ou desconexao de um pendrive
	 */
	public DeviceLE(String id, String date, String user, String pc, String connection) {
		super(id, date, user, pc);
		this.setConnection(connection);
	}

	/**
	 * Retorna a atividade de conexao ou desconexao de um pendrive
	 * @return Atividade do usuario com o pendrive
	 */
	public String getConnection() {
		return connection;
	}

	/**
	 * Muda o tipo da atividade com o pendrive
	 * @param connection Atividade de conexao ou desconexao do pendrive
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}
}

