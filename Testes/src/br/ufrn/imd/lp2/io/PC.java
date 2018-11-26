package br.ufrn.imd.lp2.io;
import java.util.ArrayList;

public class PC extends AbstractSuper{

	private String pcId;
	//private ArrayList<Action> actions;
	
	public PC(String pcId) {
		this.pcId = pcId;
		//actions = new ArrayList<Action>();
	}
	
	public String getPcId() {
		return pcId;
	}
	
	/*
	public ArrayList<Action> getActions(){
		return actions;
	}
	*/
}
