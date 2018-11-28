package br.ufrn.imd.lp2.io;

public class DeviceLE extends LogEntry{
	private String connection;
	
	public DeviceLE(String id, String date, String user, String pc, String connection) {
		super(id, date, user, pc);
		this.setConnection(connection);
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}
}

