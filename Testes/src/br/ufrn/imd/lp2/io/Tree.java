package br.ufrn.imd.lp2.io;

public class Tree {
	private Node root;
	
	public Tree(Node root) {
		this.root = root;
	}
	
	public void setRoot(Node root) {
		this.root=root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	
	 public Node search(Node currentNode, String dataToFind) {
		 Node returnNode = null;
	        int i = 0;
	        AbstractSuper aux = currentNode.getValue();
	        
	        if(aux instanceof User) {
	        	User member = (User) aux;
		        if (member.getId().equals(dataToFind)) {
		            returnNode = currentNode;
		        }
	        } 
	        
		 return returnNode;
	 }
	 
	 
	 public void refresh(AbstractSuper lido) {
		 // VERIFICA SE JA EXISTE AS FOLHAS(DATA,PC,ATIVIDADE)
		 // Downcast
		 
		 Action teste = (Action) lido;

		 int histaux2[]=new int[24];
		 int histaux[]=new int[24];
		 Node aux2,aux,aux3,aux4;
		 aux=search(getRoot(),teste.getUser());
		 aux2=search(aux,teste.getDateString()); 
			if(aux2!=null) {// PROCURA DATA
				histaux2=aux2.getHist();
				histaux2[Integer.parseInt(teste.getHour())]++;
				aux2.setHist(histaux2);
				aux3=search(aux,teste.getPc().getPcId());
				if(aux3!=null) {// PROCURA PC
					histaux2=aux3.getHist();
					histaux2[Integer.parseInt(teste.getHour())]++;
					aux3.setHist(histaux2);
					aux4=search(aux,teste.getActivity());
					if(aux4!=null) {// PROCURA ATIVIDADE
						histaux2=aux4.getHist();
						histaux2[Integer.parseInt(teste.getHour())]++;
						aux4.setHist(histaux2);
					}else {// SE NÃO TEM ATIVIDADE
						Node activity = new Node(teste);
						histaux[Integer.parseInt(teste.getHour())]++;
						activity.setHist(histaux);
						aux2.getChilds().add(activity);
					}
				}else { // SE NÃO TEM PC
					histaux[Integer.parseInt(teste.getHour())]++;
					Node PC= new Node(teste);
					Node activity=new Node(teste);
					activity.setHist(histaux);
					PC.getChilds().add(activity);
					PC.setHist(histaux);
					aux.getChilds().add(PC);
				}
			}else { // SE NÃO TEM DATA
				histaux[Integer.parseInt(teste.getHour())]++;
				Node activity=new Node(teste);
				Action tmp = (Action) activity.getValue();
				
				AbstractSuper newDate = tmp.getDate();
				Node date = new Node(newDate);
				
				AbstractSuper newPC = tmp.getPc();
				Node pc = new Node(newDate);
				
				pc.getChilds().add(activity);
				date.getChilds().add(pc);
				
				date.setHist(histaux);
				pc.setHist(histaux);
				activity.setHist(histaux);
				aux.getChilds().add(date);
			}
	}
	 
}
