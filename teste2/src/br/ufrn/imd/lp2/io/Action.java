package br.ufrn.imd.lp2.io;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Action extends AbstractSuper {
	private String id;
	private SystemDate date;
	private String user;
	private PC pc;
	private Activity activity;
	private String act;
	
	
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	protected SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public Action() {
		
	}

	public Action(String id, String date, String user, String pc, String activity) {
		this.id = id;
		this.date = new SystemDate(date);
		this.user = user.substring(5, 12);
		this.pc = new PC(pc);
		this.act = activity;
		/*
		try {
			this.date = df.parse(date.substring(0,10) +" "+ date.substring(11, 19));
		//System.out.println(date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
	
	public String getId() {
		return id;
	}
	public String getAct() {
		return act;
	}
	
	public void setId(String newId) {
		id = newId;
	}
	
	public SystemDate getDate() {
		return date;
	}
	
	public String getDateString() {
		return date.getDateString();
	}
	
	
	public String getHour() {
		return date.getHour();
	}
	
	public String getUser() {
		return user;
	}
	
	public PC getPc() {
		return pc;
	}
	
	public Activity getActivity() {
		return activity;
	}
	
	public void show() {
		System.out.println("Atividade: " + getAct());
	}
}
