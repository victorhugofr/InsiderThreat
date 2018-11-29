package br.ufrn.imd.lp2.io;
public class Logon extends AbstractSuper{
	
	private String activity;
	
	public Logon(){
		
	}
	
	public Logon(String activity) {
		this.setActivity(activity);
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public void show() {
		System.out.println(getActivity());
	}
	
}
