package br.ufrn.imd.lp2.io;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class SystemDate extends AbstractSuper {
	
	private Date date;
	
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	protected SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public SystemDate(String date) {
		try {
			this.date = df.parse(date.substring(0,10) +" "+ date.substring(11, 19));
		//System.out.println(date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public String getDay() {
		return df.format(date).substring(0,10);
	}
	
	public String getHour() {
		return df.format(date).substring(11, 13);
	}
	
	public void show() {
		System.out.println(getDay());
	}
}
