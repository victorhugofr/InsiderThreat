package br.ufrn.imd.lp2.io;

public class HttpLE extends LogEntry {
	
	private String url;
	
	public HttpLE(String id, String date, String user, String pc, String url) {
		super(id, date, user, pc);
		this.setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
