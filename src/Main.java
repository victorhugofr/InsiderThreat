import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Leitor arquivo = new Leitor();
		String[] teste;
		try {
			Scanner leitor = new Scanner(arquivo.leitura("src/device.csv"));
			String linha = new String();
			leitor.nextLine();
			while(leitor.hasNext()){
				linha = leitor.nextLine();
				arquivo.setValoresEntreVirgulas(linha);
				teste= arquivo.quebrandoLinhas();
				System.out.println(Arrays.toString(teste));		
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
