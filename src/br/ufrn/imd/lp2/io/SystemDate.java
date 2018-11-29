package br.ufrn.imd.lp2.io;

public class SystemDate extends AbstractSuper {
	
	private String all;
	private String day;
	private String hour;
	
	public SystemDate(String data) {
		all = data;
		day = data.substring(0, 10);
		hour = data.substring(11, 13);
	}
	
	public String getDate() {
		return day;
	}
	
	public void setDate(String date){
		this.day = date;
	}
	
	public String getAll() {
		return all;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void show() {
		System.out.println(getDay());
	}
}
