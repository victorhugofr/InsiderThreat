package br.ufrn.imd.lp2.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.imd.lp2.io.*;

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
	
	public int[] getHistMed() {
		int histmedio[]=new int[24];
		int aux[]=new int[24];
		for(int i=0;i<users.size();i++) {
			for(int j=0;j<24;j++) {
			//	System.out.print(users.get(i).getRoot().getHist()[j]+" ");
				aux[j]+=users.get(i).getRoot().getHist()[j];
			//	System.out.println(aux[j]);
			}
			//System.out.println();
		}
		for (int i=0;i<24;i++) {
			histmedio[i]=aux[i]/users.size();
		}
		return histmedio;
	}
	
	public void addUsers(User employee) {
			Node aux;
			// VERIFICA SE JA EXISTE UMA ÁRVORE COM AQUELE USER
			boolean existe= false;
			for(int i=0;i<users.size();i++) {
				aux=users.get(i).getUserChild(users.get(i).getRoot(), employee.getId()); 
				if(aux!=null) {//procura usuario
					existe=true;
				}
			}
			
			if(existe==false) {
				Node userRoot = new Node(employee);
				Tree tree = new Tree(userRoot);
				users.add(tree);
			}
	}
	
	public void checkUsers() {
		for(int i = 0; i < users.size(); i++) {
			AbstractSuper aux = users.get(i).getRoot().getValue();
			if(aux instanceof User) {
				User member = (User) aux;
				member.show();
			}
		}
	}
	
	public void checkDates() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			if(dates.isEmpty()) {
				System.out.println("Vazio");
			} else {
				for(Node act: dates) {
					//AbstractSuper tmp = (AbstractSuper) act.getValue();
					SystemDate aux = (SystemDate) act.getValue();
					aux.show();
				}
			}
		}
	}
	
	public void checkPcs() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			for(Node date: dates) {
				ArrayList<Node> pcs = date.getChilds();
				for(Node aux: pcs) {
					PC pc = (PC) aux.getValue();
					pc.show();
				}
			}
				
		}
	}
	
	public void checkActions() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			for(Node date: dates) {
				ArrayList<Node> pcs = date.getChilds();
				for(Node aux: pcs) {
					ArrayList<Node> actions = aux.getChilds();
					for(Node acts: actions) {
						Action act = (Action) acts.getValue();
						act.show();
					}
				}
			}
				
		}
	}
	
	public void checkDevices() {
		for(int i = 0; i < users.size(); i++) {
			ArrayList<Node> dates = users.get(i).getRoot().getChilds();
			for(Node date: dates) {
				ArrayList<Node> pcs = date.getChilds();
				for(Node aux: pcs) {
					ArrayList<Node> actions = aux.getChilds();
					for(Node acts: actions) {
						ArrayList<Node> devices = acts.getChilds();
						for(Node device: devices) {
							Device act = (Device) device.getValue();
							act.show();
						}
					}
				}
			}
				
		}
	}
	
	public void userInfo(String id) {
		boolean existe = false;
		for(int i = 0; i < users.size(); i++) {
			AbstractSuper aux = users.get(i).getRoot().getValue();
				User member = (User) aux;
				if(member.getId().equals(id)) {
					existe = true;
					member.show();
					ArrayList<Node> dates = users.get(i).getRoot().getChilds();
					for(Node date: dates) {
						SystemDate data = (SystemDate) date.getValue();
						data.show();
						ArrayList<Node> pcs = date.getChilds();
						for(Node pc: pcs) {
							PC computer = (PC) pc.getValue();
							computer.show();
							ArrayList<Node> acts = pc.getChilds();
							for(Node act: acts) {
								Action action = (Action) act.getValue();
								action.show();
								ArrayList<Node> activities = act.getChilds();
								for(Node end: activities) {
									if(end.getValue() instanceof Device) {
										Device dvc = (Device) end.getValue();
										dvc.show();
									}
									
									if(end.getValue() instanceof HTTP) {
										HTTP site = (HTTP) end.getValue();
										site.show();
									}
									if(end.getValue() instanceof Logon) {
										Logon site = (Logon) end.getValue();
										site.show();
									}
								}
							}
						}
					}
				}
		}
		if(existe == false) {
			System.out.println("ID invalido");
		}
	}
	
	public void seeHist(String user) {
		for(Tree usuario: users) {
			AbstractSuper aux = usuario.getRoot().getValue();
			User u = (User) aux;
			if(u.getId().equals(user)) {
				usuario.getRoot().printHist();
			}
		}
	}
	
	public void lerUser(String nomearquivo) {
		Scanner leitor;
		Reader arquivo = new Reader();
		String[] teste;
		//AbstractSuper de = new AbstractSuper();
		try {
			leitor = new Scanner(arquivo.leitura(nomearquivo));	
			String linha = new String();
			leitor.nextLine();
			
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				arquivo.setValoresEntreVirgulas(linha);
				teste= arquivo.quebrandoLinhas();
				
				User de=new User(teste[0],teste[1],teste[2],teste[3],teste[4]);
				
				addUsers(de);	
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void ler(String nomearquivo) {
		Scanner leitor;
		Reader arquivo = new Reader();
		String[] teste;
		LogEntry de = new LogEntry();
		try {
			leitor = new Scanner(arquivo.leitura(nomearquivo));	
			String linha = new String();
			leitor.nextLine();
			
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				//arquivo.setValoresEntreVirgulas(linha);
				teste = linha.split(",");
				//teste= arquivo.quebrandoLinhas();
				//System.out.println(teste[1]);
				if(nomearquivo.equals("C:/Users/vale1c/workspace/src/br/ufrn/imd/lp2/files/device.csv"))
					de=new DeviceLE(teste[0],teste[1],teste[2],teste[3],teste[4]);
				else if(nomearquivo.equals("C:/Users/vale1c/workspace/src/br/ufrn/imd/lp2/files/logon.csv"))
					de=new LogonLE(teste[0],teste[1],teste[2],teste[3],teste[4]);
				else if(nomearquivo.equals("C:/Users/vale1c/workspace/src/br/ufrn/imd/lp2/files/http.csv"))
					de=new HttpLE(teste[0],teste[1],teste[2],teste[3],teste[4]);
				
				//System.out.println(de.getDate());
				SystemDate date = new SystemDate(de.getDate());
				
				for(int i = 0; i < users.size(); i++) {
					AbstractSuper aux = users.get(i).getRoot().getValue();
					User member = (User) aux;
					if(member.getId().equals(de.getUser())) {
						//System.out.println("Encontrou");
						//SystemDate date = new SystemDate(de.getDate());
						users.get(i).getRoot().atualizaHist(date.getHour());
						users.get(i).addLE(de, date.getHour());
						break;
					}
				}
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void anomalie(String funcao) {
		double dfinal[]  = new double[users.size()];
		double media=0;
		double dp=0;
		int aux2=0;
		for(int k = 0; k < users.size(); k++) {
			AbstractSuper aux = users.get(k).getRoot().getValue();
			User member = (User) aux;
			if(member.getRole().equals(funcao)) {
				aux2++;
				//dfinal = new double[users.size()];
				//for(int j=0;j<users.size();j++) {
					for(int i=0;i<24;i++) {
						// Somatorio
						dfinal[k]+=Math.pow(users.get(k).getRoot().getHist()[i]-getHistMed()[i], 2);
					}
					
					// Raiz do somatorio
					dfinal[k]=Math.sqrt(dfinal[k]);
				//}
				//System.out.println(Math.abs(dfinal[k]));
			}
		}
		double normal[]=new double[aux2];
		aux2=0;
		for(int i=0;i<users.size();i++) {
			if(dfinal[i]!=0){
				normal[aux2]=dfinal[i];
				aux2++;
			}
		}
		for(int i=0;i<aux2;i++) {
			media+=normal[i];
		}
			
		media=media/aux2;
			
		for(int i=0;i<aux2;i++) {
			dp+=Math.pow(normal[i]-media,2);
		}
			
		dp=Math.sqrt(dp/aux2);
			
		//normal = new double[users.size()];
		
		
		for(int i=0;i<aux2;i++) {
			//	System.out.println(dfinal[i]);
			//normal[i]=(dfinal[i]-media)/dp;
			System.out.println(Math.abs(normal[i]));
		}
		
	}
}
