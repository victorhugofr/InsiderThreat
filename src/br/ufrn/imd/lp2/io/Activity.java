package br.ufrn.imd.lp2.io;

public class Activity extends AbstractSuper {
	private String activityId;
	//private ArrayList<Action> actions;
	
	public Activity(String pcId) {
		this.activityId = pcId;
		//actions = new ArrayList<Action>();
	}
	
	public String getActivityId() {
		return activityId;
	}
	
	/*
	public ArrayList<Action> getActions(){
		return actions;
	}
	*/
	
	public void show() {
		System.out.println(getActivityId());
	}
}
