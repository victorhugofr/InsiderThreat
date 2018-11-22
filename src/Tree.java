
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
		 int histaux2[]=new int[24];
		 int histaux[]=new int[24];
		 Node aux2,aux,aux3,aux4;
		 aux=search(getRoot(),teste.getUser());
		 aux2=search(aux,teste.getDateString()); 
			if(aux2!=null) {//procura data
				histaux2=aux2.getHist();
				histaux2[Integer.parseInt(teste.getHour())]++;
				aux2.setHist(histaux2);
				aux3=search(aux,teste.getPc());
				if(aux3!=null) {//procura PC
					histaux2=aux3.getHist();
					histaux2[Integer.parseInt(teste.getHour())]++;
					aux3.setHist(histaux2);
					aux4=search(aux,teste.getActivity());
					if(aux4!=null) {//procura atividade
						histaux2=aux4.getHist();
						histaux2[Integer.parseInt(teste.getHour())]++;
						aux4.setHist(histaux2);
					}else {
						Node activity=new Node(teste.getActivity());
						histaux[Integer.parseInt(teste.getHour())]++;
						activity.setHist(histaux);
						aux2.getChilds().add(activity);
					}
				}else {
					histaux[Integer.parseInt(teste.getHour())]++;
					Node PC= new Node(teste.getPc());
					Node activity=new Node(teste.getActivity());
					activity.setHist(histaux);
					PC.getChilds().add(activity);
					PC.setHist(histaux);
					aux.getChilds().add(PC);
				}
			}else {
				histaux[Integer.parseInt(teste.getHour())]++;
				Node data=new Node(teste.getDateString());
				Node PC= new Node(teste.getPc());
				Node activity=new Node(teste.getActivity());
				PC.getChilds().add(activity);
				data.getChilds().add(PC);
				
				data.setHist(histaux);
				PC.setHist(histaux);
				activity.setHist(histaux);
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
