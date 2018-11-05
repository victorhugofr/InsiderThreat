import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Leitor {
	
	BufferedReader arquivoDevice;
	String[] valorFinal;
	String valoresEntreVirgulas;
	
	public String[] quebrandoLinhas(){
		this.valorFinal = valoresEntreVirgulas.split(",");
		return valorFinal;
	}
	
	public void setValoresEntreVirgulas(String valor) {
		this.valoresEntreVirgulas=valor;
	}
	
	public BufferedReader leitura(String localDoArquivo) throws FileNotFoundException{
		arquivoDevice = new BufferedReader(new FileReader(localDoArquivo));
		return arquivoDevice;
	}
}