package br.ufrn.imd.lp2.domain;

import java.util.ArrayList;

import br.ufrn.imd.lp2.io.Action;
import br.ufrn.imd.lp2.io.Node;
import br.ufrn.imd.lp2.io.Tree;

public class DataBase {
	public ArrayList<Tree>users;
	
	public static DataBase databaseSingleton;
	
	public DataBase() {
		users=new ArrayList<Tree>();
	}
	
	public static DataBase getInstance() {
		if (databaseSingleton == null) {
			databaseSingleton = new DataBase();
		}
		return databaseSingleton;
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
	public void verifica(Action teste) { // VERIFICA SE JA EXISTE UMA ÁRVORE COM AQUELE USER
		
		Node aux;
		int histaux2[]=new int[24];
		boolean existe= false;
		for(int i=0;i<users.size();i++) {
			aux=users.get(i).search(users.get(i).getRoot(),teste.getUser()); 
			if(aux!=null) {//procura usuario
				histaux2=aux.getHist();
				histaux2[Integer.parseInt(teste.getHour())]++;
				existe=true;
				aux.setHist(histaux2);
				users.get(i).refresh(teste);
			}
		}
		
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
