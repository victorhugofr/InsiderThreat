package br.ufrn.imd.lp2.io;

import br.ufrn.imd.lp2.domain.DataBase;
import java.util.Scanner;

/**
 * Classe principal
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class Main {

	public static void main(String[] args) {
	
		System.out.println("AGUARDE A LEITURA DOS ARQUIVOS \n");
		DataBase db = DataBase.databaseSingleton;
		
		System.out.println("----  Lendo Usuários  ----");
		db.lerUser("src/br/ufrn/imd/lp2/files/ldap.csv");
		System.out.println("---- Usuários finalizados ---- \n");
		
		System.out.println("----  Lendo Devices  ----");
		db.ler("src/br/ufrn/imd/lp2/files/device.csv");
		System.out.println("---- Devices finalizados ----\n");
		
		System.out.println("----  Lendo Logons  ----");
		db.ler("src/br/ufrn/imd/lp2/files/logon.csv");
		System.out.println("---- Logons finalizados ----\n");
		
		System.out.println("----  Lendo Https  ----");
		db.ler("src/br/ufrn/imd/lp2/files/http.csv");
		System.out.println("---- Https finalizados ----\n");
		
		int option = 1;
		Scanner leitor = new Scanner(System.in);
		String input;
		
		while(option != 0) {
			System.out.println("\nBEM VINDO AO INSIDER THREAT");
			System.out.println("");
			System.out.println("MENU");
			System.out.println("1 - Buscar Usuário");
			System.out.println("2 - Buscar ameaça por cargo");
			System.out.println("3 - Ver histograma de um usuário");
			System.out.print("Insira o valor de uma operação: ");
			option = leitor.nextInt(); 
			leitor.nextLine();
			switch(option) {
				case 1:
					System.out.println("----- BUSCA POR USUARIO -----");
					System.out.println("Insira o ID de um usuario: ");
					input = leitor.nextLine();
					System.out.println("Resultado: ");
					db.userInfo(input);
					break;
				case 2:
					System.out.println("----- BUSCA POR AMEAÇA POR CARGO -----");
					System.out.println("Insira um cargo na empresa: ");
					input = leitor.nextLine();
					System.out.println("Processando os dados");
					System.out.println("Resultado: ");
					db.anomalie(input);
					break;
				case 3:
					System.out.println("----- BUSCA POR HISTOGRAMA -----");
					System.out.println("Insira o ID de um usuario: ");
					input = leitor.nextLine();
					System.out.println("Resultado: ");
					db.seeHist(input);
			}
		}
		leitor.close();
		System.out.println("Até mais!!");
	}

}
