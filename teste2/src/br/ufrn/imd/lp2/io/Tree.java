package br.ufrn.imd.lp2.io;

import java.util.ArrayList;
//import br.ufrn.imd.lp2.io.*;

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
	
	
	 public Node searchUser(Node currentNode, String dataToFind) {
		 Node returnNode = null;
	        AbstractSuper aux = currentNode.getValue();
	        
	        if(aux instanceof User) {
	        	User member = (User) aux;
		        if (member.getId().equals(dataToFind)) {
		            returnNode = currentNode;
		        }
	        } 
	        
		 return returnNode;
	 }
	 
	 public Node searchDate(Node currentNode, String dataToFind) {
		 Node returnNode = null;
	        ArrayList<Node> dates = currentNode.getChilds();
	        for(Node aux: dates) {
	        	AbstractSuper tmp = (AbstractSuper) aux.getValue();
	        	//if(tmp instanceof SystemDate) {
		        	SystemDate date = (SystemDate) aux.getValue();
		        	if(date.getDateString().equals(dataToFind)) {
		        		returnNode = aux;
		        	}
	        	//}
	        }
	        
		 return returnNode;
	 }
	 
	 public Node searchPC(Node currentNode, String dataToFind) {
		 Node returnNode = null;
	        ArrayList<Node> pcs = currentNode.getChilds();
	        for(Node aux: pcs) {
	        	AbstractSuper tmp = (AbstractSuper) aux.getValue();
	        	//if(tmp instanceof PC) {
		        	PC pc = (PC) aux.getValue();
		        	if(pc.getPcId().equals(dataToFind)) {
		        		returnNode = aux;
		        	}
	        	//}
	        }
	        
		 return returnNode;
	 }
	 
	 public Node searchAct(Node currentNode, String dataToFind) {
		 Node returnNode = null;
	        ArrayList<Node> acts = currentNode.getChilds();
	        for(Node aux: acts) {
	        	AbstractSuper tmp = (AbstractSuper) aux.getValue();
	        	//if(tmp instanceof Action) {
		        	Action act = (Action) aux.getValue();
		        	if(act.getActivity().equals(dataToFind)) {
		        		returnNode = aux;
		        	}
	        	//}
	        }
	        
		 return returnNode;
	 }
	
	 public void refresh(Node user, AbstractSuper lido) {
		 // VERIFICA SE JA EXISTE AS FOLHAS(DATA,PC,ATIVIDADE)
		 // Downcast
		 
		 Action teste = (Action) lido;

		 int histaux2[]=new int[24];
		 int histaux[]=new int[24];
		 Node aux2,aux3,aux4,aux5;
		 // aux=search(getRoot(),teste.getUser());
		 // PROCURA DATA PARA AQUELE USUÁRIO
		 aux2 = searchDate(user,teste.getDateString()); 
			if(aux2!=null) {// PROCURA DATA
				histaux2=aux2.getHist();
				histaux2[Integer.parseInt(teste.getHour())]++;
				aux2.setHist(histaux2);
				// PROCURA PC PARA AQUELA DATA
				aux3=searchPC(aux2,teste.getPc().getPcId());
				if(aux3!=null) {// PROCURA PC
					histaux2=aux3.getHist();
					histaux2[Integer.parseInt(teste.getHour())]++;
					aux3.setHist(histaux2);
					// PROCURA ATIVIDADE DENTRO DO PC
					if(teste instanceof HTTP) {// PROCURA ATIVIDADE
						aux4=searchAct(aux3,"http");
						if(aux4!=null) {
							histaux2=aux4.getHist();
							histaux2[Integer.parseInt(teste.getHour())]++;
							aux4.setHist(histaux2);
							aux5=searchAct(aux4,teste.getActivity());
							if(aux5!=null) {
								histaux2=aux5.getHist();
								histaux2[Integer.parseInt(teste.getHour())]++;
								aux5.setHist(histaux2);
							}else {
								Node activity = new Node(teste);
								histaux[Integer.parseInt(teste.getHour())]++;
								activity.setHist(histaux);
								aux3.getChilds().add(activity);
							}
						}
						else {// SE NÃO TEM ATIVIDADE, ADICIONA NO PC
							Action novo=new Action();
							novo.setActivity("http");
							Node activity = new Node(novo);
							histaux[Integer.parseInt(teste.getHour())]++;
							activity.setHist(histaux);
							aux3.getChilds().add(activity);
						}
					}else if(teste instanceof Device) {
						aux4=searchAct(aux3,"device");
						if(aux4!=null) {
							histaux2=aux4.getHist();
							histaux2[Integer.parseInt(teste.getHour())]++;
							aux4.setHist(histaux2);
							aux5=searchAct(aux4,teste.getActivity());
							if(aux5!=null) {
								histaux2=aux5.getHist();
								histaux2[Integer.parseInt(teste.getHour())]++;
								aux5.setHist(histaux2);
							}else {
								Node activity = new Node(teste);
								histaux[Integer.parseInt(teste.getHour())]++;
								activity.setHist(histaux);
								aux3.getChilds().add(activity);
							}
						}
						else {// SE NÃO TEM ATIVIDADE, ADICIONA NO PC
							Action novo=new Action();
							novo.setActivity("device");
							Node activity = new Node(novo);
							histaux[Integer.parseInt(teste.getHour())]++;
							activity.setHist(histaux);
							aux3.getChilds().add(activity);
						}
					}else if(teste instanceof Logon) {
						aux4=searchAct(aux3,"logon");
						if(aux4!=null) {
							histaux2=aux4.getHist();
							histaux2[Integer.parseInt(teste.getHour())]++;
							aux4.setHist(histaux2);
							aux5=searchAct(aux4,teste.getActivity());
							if(aux5!=null) {
								histaux2=aux5.getHist();
								histaux2[Integer.parseInt(teste.getHour())]++;
								aux5.setHist(histaux2);
							}else {
								Node activity = new Node(teste);
								histaux[Integer.parseInt(teste.getHour())]++;
								activity.setHist(histaux);
								aux3.getChilds().add(activity);
							}
						}
						else {// SE NÃO TEM ATIVIDADE, ADICIONA NO PC
							Action novo=new Action();
							novo.setActivity("logon");
							Node activity = new Node(novo);
							histaux[Integer.parseInt(teste.getHour())]++;
							activity.setHist(histaux);
							aux3.getChilds().add(activity);
						}
					}
				}else { // SE NÃO TEM PC
					histaux[Integer.parseInt(teste.getHour())]++;
					Node activity=new Node(teste);
					Action tmp = (Action) activity.getValue();
					
					AbstractSuper newPC = tmp.getPc();
					Node pc = new Node(newPC);
					activity.setHist(histaux);
					pc.getChilds().add(activity);
					pc.setHist(histaux);
					aux2.getChilds().add(pc);
				}
			}else { // SE NÃO TEM DATA
				histaux[Integer.parseInt(teste.getHour())]++;
				Node activity=new Node(teste);
				Action tmp = (Action) activity.getValue();
				
				AbstractSuper newDate = tmp.getDate();
				Node date = new Node(newDate);
				
				AbstractSuper newPC = tmp.getPc();
				Node pc = new Node(newPC);
				
				pc.getChilds().add(activity);
				date.getChilds().add(pc);
				
				date.setHist(histaux);
				pc.setHist(histaux);
				activity.setHist(histaux);
				user.getChilds().add(date);
			}
	}
	 
}
