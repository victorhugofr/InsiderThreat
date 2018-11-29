package br.ufrn.imd.lp2.io;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.ParseException;

public class SystemDate extends AbstractSuper {
	
	/*
	private Date date;
	
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	//rotected SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public SystemDate(String date) {
		
		try {
			this.date = df.parse(date.substring(0,10) +" "+ date.substring(11, 19));
		//System.out.println(date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
	}
	*/
	private String tudo;
	private String dia;
	private String horas;
	
	public SystemDate(String data) {
		tudo = data;
		dia = data.substring(0, 10);
		horas = data.substring(11, 13);
	}
	
	/*
	public String getDate() {
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public String getDay() {
		return df.format(date).substring(0,10);
	}
	
	public String getHour() {
		String ts = df.format(date).substring(11, 13);
		return ts;
	}
	
	public void show() {
		System.out.println(getDay());
	}
	*/
	public String getDate() {
		return dia;
	}
	
	public void setDate(String date){
		this.dia = date;
	}
	
	public String getTudo() {
		return tudo;
	}
	
	public String getDay() {
		return dia;
	}
	
	public String getHour() {
		//String ts = df.format(date).substring(11, 13);
		return horas;
	}
	
	public void show() {
		System.out.println(getDay());
	}
}
