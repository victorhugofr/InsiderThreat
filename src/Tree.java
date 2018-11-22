
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
	 
	 public void refresh(Action teste) {// VERIFICA SE JA EXISTE AS FOLHAS(DATA,PC,ATIVIDADE)
		 Node aux2,aux,aux3,aux4;
		 aux=search(getRoot(),teste.getUser());
		 aux2=search(aux,teste.getDateString()); 
			if(aux2!=null) {//procura data
				aux.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
				aux3=search(aux,teste.getPc());
				if(aux3!=null) {//procura PC
					aux3.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
					aux4=search(aux,teste.getActivity());
					if(aux4!=null) {//procura atividade
						aux4.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
					}else {
						Node activity=new Node(teste.getActivity());
						activity.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
						aux2.getChilds().add(activity);
					}
				}else {
					Node PC= new Node(teste.getPc());
					Node activity=new Node(teste.getActivity());
					PC.getChilds().add(activity);
					PC.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
					aux.getChilds().add(PC);
				}
			}else {
				Node data=new Node(teste.getDateString());
				Node PC= new Node(teste.getPc());
				Node activity=new Node(teste.getActivity());
				PC.getChilds().add(activity);
				data.getChilds().add(PC);
				
				data.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
				PC.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
				aux.getChilds().add(data);
			}
		}
	public void setRoot(Node root) {
		this.root=root;
	}
	public Node getRoot() {
		return root;
	}
}
