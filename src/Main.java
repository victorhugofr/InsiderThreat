import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DataBase db=new DataBase();
			Device de = new Device();
			ler("src/device2.csv",db,de);
			Logon de2 = new Logon();
			ler("src/logon2.csv",db,de2);
		db.print();
	}

	private static void ler(String nomearquivo,DataBase db,Action de) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
