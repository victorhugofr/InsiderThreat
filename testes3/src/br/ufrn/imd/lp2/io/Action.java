package br.ufrn.imd.lp2.io;

public class Action extends AbstractSuper {
	
	private String id;
	
	public Action(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void show() {
		System.out.println(getId());
	}
}
