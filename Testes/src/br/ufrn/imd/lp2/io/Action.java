package br.ufrn.imd.lp2.io;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Action extends AbstractSuper {
	private String id;
	private Date date;
	private String user;
	private String pc;
	private String activity;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
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
			this.date = df.parse(date.substring(0,10) +" "+ date.substring(11, 19));
		System.out.println(date);
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
		return df.format(date);
	}
	public String getHour() {
		return df.format(date).substring(11, 13);
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
