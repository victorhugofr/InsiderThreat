package br.ufrn.imd.lp2.domain;

import java.util.ArrayList;
import br.ufrn.imd.lp2.io.*;
import br.ufrn.imd.lp2.io.Action;
import br.ufrn.imd.lp2.io.Node;
import br.ufrn.imd.lp2.io.Tree;

public class DataBase {
	
	public ArrayList<Tree>users;

	public static DataBase databaseSingleton;
	
	public DataBase() {
		users = new ArrayList<Tree>();
	}
	
	public static DataBase getInstance() {
		if (databaseSingleton == null) {
			databaseSingleton = new DataBase();
		}
		return databaseSingleton;
	}
	
	public void getUsers() {
		for(int i = 0; i < users.size(); i++) {
			AbstractSuper aux = users.get(i).getRoot().getValue();
			if(aux instanceof User) {
				User member = (User) aux;
				member.show();
			}
		}
	}
	
	public int[] getHistMed() {
		int histmedio[]=new int[24];
		int aux[]=new int[24];
		for(int i=0;i<users.size();i++) {
			for(int j=0;j<24;j++) {
			//	System.out.print(users.get(i).getRoot().getHist()[j]+" ");
				aux[j]+=users.get(i).getRoot().getHist()[j];
			}
			//System.out.println();
		}
		for (int i=0;i<24;i++) {
			histmedio[i]=aux[i]/users.size();
		}
		return histmedio;
	}
/**	public double[] getHistNormal() {
		double dp[]=new double[users.size()];
		for(int i=0;i<users.size();i++) {
			for(int j=0;j<24;j++) {
				dp[j]=(users.get(i).getRoot().getHist()[j]-getHistMed()[j])/getHistDp()[j];
			}
		}
		return dp;
	}*/
	public double[] getHistDp() {
		double dp[]=new double[24];
		double aux[]=new double[24];
		for(int i=0;i<users.size();i++) {
			for(int j=0;j<24;j++) {
			//	System.out.print(users.get(i).getRoot().getHist()[j]+" ");
				aux[j]+=Math.pow(users.get(i).getRoot().getHist()[j]-getHistMed()[j],2);
			}
			//System.out.println();
		}
		for (int i=0;i<24;i++) {
			dp[i]=Math.sqrt(aux[i]/users.size());
		}
		return dp;
	}
	
	
	public void verifica(AbstractSuper lido) { 
		// VERIFICA SE O ARGUMENTO É DO TIPO USER
		if(lido instanceof User) {
			User member = (User) lido;
			Node aux;
			// VERIFICA SE JA EXISTE UMA ÁRVORE COM AQUELE USER
			boolean existe= false;
			for(int i=0;i<users.size();i++) {
				aux=users.get(i).searchUser(users.get(i).getRoot(), member.getId()); 
				if(aux!=null) {//procura usuario
					existe=true;
				}
			}
			
			if(existe==false) {
				Node userRoot = new Node(lido);
				Tree tree = new Tree(userRoot);
				//tree.setRoot(userRoot);
				users.add(tree);
			}
			
		}
		
		
		// VERIFICA SE O ARGUMENTO É DO TIPO ACTION
		if(lido instanceof Action) {
			Action teste = (Action) lido;
			// VERIFICA SE JÁ EXISTE ÁRVORE PARA AQUELE USUÁRIO
			Node aux;
			int histaux2[]=new int[24];
			//boolean existe= false;
			for(int i=0;i<users.size();i++) {
				aux = users.get(i).searchUser(users.get(i).getRoot(), teste.getUser()); 
				if(aux!=null) {//procura usuario
					histaux2=aux.getHist();
					histaux2[Integer.parseInt(teste.getHour())]++;
					//existe=true;
					aux.setHist(histaux2);
					users.get(i).refresh(aux, teste);
				}
			}
			
			/*
			if(existe==false) {// CASO NAO EXISTA, CRIE E ADICIONE SUAS RAIZES
				int histaux[]=new int[24];
				Node id= new Node(teste.getUser());
				Node data=new Node(teste.getDateString());
				Node PC= new Node(teste.getPc());
				Node activity=new Node(teste.getActivity());
				
				
				histaux[Integer.parseInt(teste.getHour())]++;
				activity.setHist(histaux);
				
				PC.setHist(histaux);
				PC.getChilds().add(activity);
				
				data.setHist(histaux);		
				data.getChilds().add(PC);
				
				id.setHist(histaux);
				id.getChilds().add(data);
				
				Tree user = new Tree();
				user.setRoot(id);
				users.add(user);
			}
			*/
		}
		
	}
	
	public void getDates() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			if(dates.isEmpty()) {
				//System.out.println("Vazio");
			} else {
				for(Node act: dates) {
					AbstractSuper tmp = (AbstractSuper) act.getValue();
					//if(tmp instanceof SystemDate) {
						SystemDate aux = (SystemDate) act.getValue();
						aux.show();
					//}
				}
			}
		}
	}
	
	
	public void getPcs() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			for(Node date: dates) {
				ArrayList<Node> pcs = date.getChilds();
				if(pcs.isEmpty()) {
					System.out.println("Vazio");
				} else {
					//System.out.println("Chegou");
					for(Node aux: pcs) {
						AbstractSuper tmp = (AbstractSuper) aux.getValue();
						//if(tmp instanceof PC) {
							//System.out.println("Chegou");
							PC pc = (PC) aux.getValue();
							pc.show();
						//}
					}
				}
				
			}
		}
	}
	
	public void getActions() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			for(Node date: dates) {
				ArrayList<Node> pcs = date.getChilds();
				for(Node pc: pcs) {
					ArrayList<Node> actions = pc.getChilds();
					if(actions.isEmpty()) {
						System.out.println("Vazio");
					} else {
						//System.out.println("Chegou");
						for(Node aux: actions) {
							AbstractSuper tmp = (AbstractSuper) aux.getValue();
							//if(tmp instanceof Action) {
								//System.out.println("Chegou");
								Action act = (Action) aux.getValue();
								act.show();
							//}
						}
					}
				}
			}
		}
	}
	
	public void print() { // print das arvores
		Node aux,aux2,aux3,aux4;
		int i,j,z,h;
		for(i=0;i<users.size();i++) {
			aux=users.get(i).getRoot();
			System.out.println(aux.getValue());
			for(z=0;z<aux.getChilds().size();z++) {
				aux2=aux.getChildAt(z);
				System.out.println(aux2.getValue());
				for(j=0;j<aux2.getChilds().size();j++) {
					aux3=aux2.getChildAt(j);
					System.out.println(aux3.getValue());
					for(h=0;h<aux3.getChilds().size();h++){
						aux4=aux3.getChildAt(h);
						System.out.println(aux4.getValue());
					}
				}
			}
		}
	}
}
