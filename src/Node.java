import java.util.ArrayList;

public class Node {
	private String value;
	private int hist[];
    private ArrayList<Node> childs;
    
    public Node(String value) {
    	this.setValue(value);
    	setHist(new int[24]);
    	setChilds(new ArrayList<Node>());
    }
    public Node() {
    //	this.value=value;
    	setHist(new int[24]);
    	setChilds(new ArrayList<Node>());
    }
    public void print() {
    	System.out.println(getValue());
    }
	public int[] getHist() {
		return hist;
	}
	public void setHist(int hist[]) {
		this.hist = hist;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
}
