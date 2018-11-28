package br.ufrn.imd.lp2.io;

public class Device extends AbstractSuper {
	
	private String activity;
	
	public Device(String activity) {
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
