
public class Tree {
	private Node root;
	
	 public Node search(Node currentNode, String dataToFind) {//Buscar node
	        Node returnNode = null;
	        int i = 0;

	        if (currentNode.getValue().equals(dataToFind)) {
	            returnNode = currentNode;
	        }

	        else if(currentNode.hasChildren()) {
	            i = 0;
	            while(returnNode == null && i < currentNode.getNumberOfChildren()) {
	                returnNode = search(currentNode.getChildAt(i), dataToFind);
	                i++;
	            }
	        }

	        return returnNode;
	    }
	 
	public void setRoot(Node root) {
		this.root=root;
	}
	public Node getRoot() {
		return root;
	}
}
