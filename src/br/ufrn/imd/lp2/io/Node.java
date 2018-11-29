package br.ufrn.imd.lp2.io;

import java.util.ArrayList;
/**
 * Classe que representa o nó da arvore
 * @author Gabriel Igor and Victor Hugo
 * @version 2018.29.11
 */
public class Node {
	//valor real (informacao) do nó
	private AbstractSuper value;
	//histograma do nó
	private int hist[];
	//lista de filhos do nó
    private ArrayList<Node> childs;
    /**
	 * Construtor do nó
	 * @param value Valor real(informacao) do nó
	 */
    public Node(AbstractSuper value) {
    	this.setValue(value);
    	setHist(new int[24]);
    	childs = new ArrayList<Node>();
    }
    
    /**
     * Construtor padrao
     */
    public Node() {
    	this.value = new AbstractSuper();
    	setHist(new int[24]);
    	setChilds(new ArrayList<Node>());
    }
    
    /**
	 * Atualiza o histograma do nó, somando 1
	 * @param ts Hora da ação realizada
	 */
    public void atualizaHist(String ts) {
    	getHist()[Integer.parseInt(ts)]++;
    }
    
    /**
	 * Retorna o histograma do nó
	 * @return histograma do nó
	 */
	public int[] getHist() {
		return hist;
	}
	
	/**
	 * Muda o histograma do nó
	 * @param hist Novo histograma
	 */
	public void setHist(int hist[]) {
		this.hist = hist;
	}
	
	/**
	 * Retorna o valor real(informacao) do nó
	 * @return valor do nó
	 */
	public AbstractSuper getValue() {
		return value;
	}
	
	/**
	 * Muda o valor real(informacao) do nó
	 * @param valor Novo valor real
	 */
	public void setValue(AbstractSuper valor) {
		this.value = valor;
	}
	
	/**
	 * Retorna uma lista com todos os filhos do nó
	 * @return lista com os filhos do nó
	 */
	public ArrayList<Node> getChilds() {
		return childs;
	}
	
	/**
	 * Muda os filhos do nó
	 * @param childs Novos filhos do nó
	 */
	public void setChilds(ArrayList<Node> childs) {
		this.childs = childs;
	}
	
	/**
	 * Retorna o numero de filhos do nó
	 * @return numero de filhos do nó
	 */
	public int getNumberOfChildren() {
        return getChilds().size();
    }
	
	/**
     * Consulta se o nó possui filhos ou não
     * @return True se houver filhos False caso contrario
     */
    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }
    
    /**
	 * Retorna o filho correspondente a posicao index da lista de flihos do nó
	 * @param index Posicao do filho requerida
	 * @return filho correspondente a posicao index da lista de flihos do nó
	 */
    public Node getChildAt(int index) throws IndexOutOfBoundsException {
        return childs.get(index);
    }
    
    /**
     * Imprime o histograma do nó
     */
    public void printHist() {
    	for(int i = 0; i < 24; i++) {
    		System.out.print(hist[i]+ " ");
    	}
    }
}
