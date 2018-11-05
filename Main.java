import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LeituraDevice leitor = new LeituraDevice();
		String[] teste;
		try {
			Scanner leitor = new Scanner(leitor.leitura("src/device.csv"));
			String linha = new String();
			leitor.nextLine();
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				leitor.setValoresEntreVirgulas(linha);
				for (int i=0;i<10;i++) {
					 teste=leitor.quebrarLinha();
					 System.out.println(Arrays.toString(teste));
					
				}
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}