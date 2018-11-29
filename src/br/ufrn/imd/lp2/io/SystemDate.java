package br.ufrn.imd.lp2.io;

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
		return horas;
	}
	
	public void show() {
		System.out.println(getDay());
	}
}
