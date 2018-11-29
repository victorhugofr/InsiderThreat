package br.ufrn.imd.lp2.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * Classe usada para leitura do arquivo
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class Reader {

	BufferedReader arquivoDevice;
	/**
	 * Consulta se o arquivo é legivel, caso contrario dispara uma excecao
	 * @param localDoArquivo local do arquivo a ser lido
	 * @throws FileNotFoundException Excecao de arquivo nao encontrado
	 * @return arquivo legivel na forma de BufferedReader
	 */
	public BufferedReader leitura(String localDoArquivo) throws FileNotFoundException{
		arquivoDevice = new BufferedReader(new FileReader(localDoArquivo));
		return arquivoDevice;
	}
	
}
