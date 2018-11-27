package br.ufrn.imd.lp2.io;
import java.io.FileNotFoundException;
import java.util.Scanner;

import br.ufrn.imd.lp2.domain.DataBase;

public class Main {

	private static double dfinal[];
	private static double media=0;
	private static double dp=0;
	private static double normal[];

	public static void main(String[] args) {
		DataBase db=new DataBase();
		
		User all = new User();
		lerUser("src/br/ufrn/imd/lp2/files/ldap.csv",db,all);
		//db.getUsers();
		
		Device de = new Device();
		ler("src/br/ufrn/imd/lp2/files/device.csv",db,de);
		db.getDates();
		
		/*
		Device de = new Device();
		ler("src/br/ufrn/imd/lp2/files/device2.csv",db,de);
		Logon de2 = new Logon();
		ler("src/br/ufrn/imd/lp2/files/logon2.csv",db,de2);
		
		//	histnormal=db.getHistNormal();
			dfinal = new double[db.users.size()];
				for(int j=0;j<db.users.size();j++) {
					for(int i=0;i<24;i++) {
						dfinal[j]+=Math.pow(db.users.get(j).getRoot().getHist()[i]-db.getHistMed()[i], 2);
					}
					dfinal[j]=Math.sqrt(dfinal[j]);
					//System.out.print(dfinal[j] + " ");
				}
			for(int i=0;i<db.users.size();i++) {
				media+=dfinal[i];
			}
			media=media/db.users.size();
			for(int i=0;i<db.users.size();i++) {
				dp+=Math.pow(dfinal[i]-media,2);
			}
			dp=Math.sqrt(dp/db.users.size());
			normal = new double[db.users.size()];
			for(int i=0;i<db.users.size();i++) {
				normal[i]=(dfinal[i]-media)/dp;
				System.out.print(Math.abs(normal[i])+" ");
			}
			
			
			*/
		
	    }
	
			
	private static void lerUser(String nomearquivo,DataBase db,AbstractSuper de) {
		Scanner leitor;
		Leitor arquivo = new Leitor();
		String[] teste;
		try {
			leitor = new Scanner(arquivo.leitura(nomearquivo));	
			String linha = new String();
			leitor.nextLine();
			
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				arquivo.setValoresEntreVirgulas(linha);
				teste= arquivo.quebrandoLinhas();
				
				de=new User(teste[0],teste[1],teste[2],teste[3],teste[4]);
				
				db.verifica(de);	
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void ler(String nomearquivo,DataBase db,AbstractSuper de) {
		Scanner leitor;
		Leitor arquivo = new Leitor();
		String[] teste;
		try {
			leitor = new Scanner(arquivo.leitura(nomearquivo));	
			String linha = new String();
			leitor.nextLine();
			
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				arquivo.setValoresEntreVirgulas(linha);
				teste= arquivo.quebrandoLinhas();
				
				if(de instanceof Device)
					de=new Device(teste[0],teste[1],teste[2],teste[3],teste[4]);
				else if(de instanceof Logon)
					de=new Logon(teste[0],teste[1],teste[2],teste[3],teste[4]);
				else if(de instanceof HTTP)
					de=new HTTP(teste[0],teste[1],teste[2],teste[3],teste[4]);
				
				db.verifica(de);	
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
