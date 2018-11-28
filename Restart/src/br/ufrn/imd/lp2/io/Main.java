package br.ufrn.imd.lp2.io;

import br.ufrn.imd.lp2.domain.DataBase;

public class Main {

	public static void main(String[] args) {
		/* 
		double dfinal[];
		double media=0;
		double dp=0;
		double normal[];
		*/
		DataBase db = new DataBase();
		db.lerUser("src/br/ufrn/imd/lp2/files/ldap.csv");
		db.ler("src/br/ufrn/imd/lp2/files/device.csv");
		System.out.println("Device lido");
		//db.ler("src/br/ufrn/imd/lp2/files/http-completo.csv");
		//System.out.println("HTTP lido");
		//db.ler("src/br/ufrn/imd/lp2/files/logon-completo.csv");
		//System.out.println("Logon lido");
		//db.checkDates();
		//db.checkPcs();
		//db.checkActions();
		//db.checkDevices();
		//db.seeHist("RES0962");
		//db.userInfo("RES0962");
		//db.anomalie("Administrative Assistant");
		//	histnormal=db.getHistNormal();
		/// Vetor de double do tamanho da quantidade de usuários
		/*
		dfinal = new double[db.users.size()];
		for(int j=0;j<db.users.size();j++) {
			for(int i=0;i<24;i++) {
				// Somatorio
				dfinal[j]+=Math.pow(db.users.get(j).getRoot().getHist()[i]-db.getHistMed()[i], 2);
			}
			
			// Raiz do somatorio
			dfinal[j]=Math.sqrt(dfinal[j]);
			//System.out.print(dfinal[j] + " ");
		}
		*/
		/*
		for(int i=0;i<db.users.size();i++) {
			media+=dfinal[i];
		}
			
		media=media/db.users.size();
			
		for(int i=0;i<db.users.size();i++) {
			dp+=Math.pow(dfinal[i]-media,2);
		}
			
		dp=Math.sqrt(dp/db.users.size());
			
		normal = new double[db.users.size()];
		*/
		/*
		for(int i=0;i<db.users.size();i++) {
			//	System.out.println(dfinal[i]);
			//normal[i]=(dfinal[i]-media)/dp;
			System.out.println(Math.abs(dfinal[i])+" ");
		}
		*/
	}
}
