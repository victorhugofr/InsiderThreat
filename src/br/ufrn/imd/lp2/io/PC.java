package br.ufrn.imd.lp2.io;

public class PC extends AbstractSuper{

	private String pcId;
	
	public PC(String pcId) {
		this.pcId = pcId;
	}
	
	public String getPcId() {
		return pcId;
	}
	
	public void show() {
		System.out.println(getPcId());
	}
}
