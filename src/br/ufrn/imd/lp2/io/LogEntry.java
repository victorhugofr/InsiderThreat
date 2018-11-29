package br.ufrn.imd.lp2.io;

public class LogEntry {
	
	private String id;
	private String date;
	private String user;
	private String pc;
	
	public LogEntry() {
		
	}
	
	public LogEntry(String id, String date, String user, String pc) {
		this.setId(id);
		this.setDate(date);
		this.setUser(user);
		this.setPc(pc);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user.substring(5,12);
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}
	
}
