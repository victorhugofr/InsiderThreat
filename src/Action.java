import java.util.Date;

public class Action {
	private String id;
	private Date date;
	private String user;
	private String pc;
	private String activity;
	
	public Action(String id, Date date, String user, String pc, String activity) {
		this.id = id;
		this.date = date;
		this.user = user;
		this.pc = pc;
		this.activity = activity;
	}
	
	public String getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPc() {
		return pc;
	}
	
	public String getActivity() {
		return activity;
	}
}
