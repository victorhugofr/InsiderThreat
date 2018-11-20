import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Action {
	private String id;
	private Date date;
	private String user;
	private String pc;
	private String activity;
	protected SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	public Action() {
		
	}
	public Action(String id, String date, String user, String pc, String activity) {
		this.id = id;
//		this.date = date;
		this.user = user;
		this.pc = pc;
		this.activity = activity;
		try {
			this.date = format.parse(date.substring(0,10));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDateString() {
		return date.toString();
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
