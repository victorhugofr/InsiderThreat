package br.ufrn.imd.lp2.io;

public class LogonLE extends LogEntry{
	private String login;
	
	public LogonLE(String id, String date, String user, String pc, String login) {
		super(id, date, user, pc);
		this.setLogin(login);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
