package br.ufrn.imd.lp2.io;

import java.util.ArrayList;

public class Node {
	private AbstractSuper value;
	private int hist[];
    private ArrayList<Node> childs;
    
    public Node(AbstractSuper value) {
    	this.setValue(value);
    	setHist(new int[24]);
    	childs = new ArrayList<Node>();
    }
    
    public Node() {
    	this.value = new AbstractSuper();
    	setHist(new int[24]);
    	setChilds(new ArrayList<Node>());
    }
    
    public void atualizaHist(String ts) {
    	getHist()[Integer.parseInt(ts)]++;
    }
    
	public int[] getHist() {
		return hist;
	}
	
	public void setHist(int hist[]) {
		this.hist = hist;
	}
	
	public AbstractSuper getValue() {
		return value;
	}
	
	public void setValue(AbstractSuper valor) {
		this.value = valor;
	}
	
	public ArrayList<Node> getChilds() {
		return childs;
	}
	
	public void setChilds(ArrayList<Node> childs) {
		this.childs = childs;
	}
	
	public int getNumberOfChildren() {
        return getChilds().size();
    }
	
    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }
    
    public Node getChildAt(int index) throws IndexOutOfBoundsException {
        return childs.get(index);
    }
    
    public void printHist() {
    	for(int i = 0; i < 24; i++) {
    		System.out.print(hist[i]+ " ");
    	}
    }
}
