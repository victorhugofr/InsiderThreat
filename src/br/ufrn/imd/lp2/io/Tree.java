package br.ufrn.imd.lp2.io;

import java.util.ArrayList;

/**
 * Classe que representa a estrutura de arvore
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class Tree {
	// No raiz da arvore, equivalente ao usuario
	private Node root;
	
	/**
	 * Construtor da arvore
	 * @param root Nova raiz da arvore, ou seja, novo usuario
	 */
	public Tree(Node root) {
		this.root = root;
	}
	
	/**
	 * Muda a raiz(Muda o usuario) 
	 * @param root Nova raiz
	 */
	public void setRoot(Node root) {
		this.root=root;
	}
	
	/**
	 * Retorna a raiz da arvore (retorna o usuario)
	 * @return Raiz da arvore
	 */
	public Node getRoot() {
		return root;
	}
	
	/**
	 * Metodo para gerar novo nó de usuario
	 * @param currentNode No de usuario
	 * @param dataToFind Id do usuario
	 * @return No de usuario
	 */
	public Node getUserChild(Node currentNode, String dataToFind) {
		 Node returnNode = null;
		 //AbstractSuper aux = currentNode.getValue();
	        
		 if(currentNode.getValue() instanceof User) {
			 User member = (User) currentNode.getValue();
			 if (member.getId().equals(dataToFind)) {
				 returnNode = currentNode;
			 }
		 } 
	        
		 return returnNode;
	 }
	
	/**
	 * Metodo para construir o perfil de usuario, ou seja,
	 * para construir toda a arvore de dados do usuario
	 * @param le Objeto LogEntry, contendo as informacoes da linha do arquivo lido
	 * @param hist Data da acao usada para atualizar os histogramas de cada nó
	 */
	public void addLE(LogEntry le, String hist) {
		// Para a Data
		
		String ts= le.getDate();
		Node dataNode = getDateChild(ts);
		dataNode.atualizaHist(hist);
		 
		// Para o PC
		String pcId= le.getPc();
		Node pcNode = getPcChild(dataNode, pcId);
		pcNode.atualizaHist(hist);
		// Para as Actions
		if(le instanceof LogonLE) {
			LogonLE logonle = (LogonLE) le;
			Node logonNode = getActionChild(pcNode, "Log");
			logonNode.atualizaHist(hist);
			
			String login = logonle.getLogin();
			Node loginNode = getLoginChild(logonNode, login);
			loginNode.atualizaHist(hist);
		} else if(le instanceof DeviceLE) {
			DeviceLE devicele = (DeviceLE) le;
			Node deviceNode = getActionChild(pcNode, "Device");
			deviceNode.atualizaHist(hist);
			
			String connection = devicele.getConnection();
			Node cntNode = getDvcChild(deviceNode, connection);
			cntNode.atualizaHist(hist);
		} else if(le instanceof HttpLE) {
			HttpLE httple = (HttpLE) le;
			Node httpNode = getActionChild(pcNode, "Http");
			httpNode.atualizaHist(hist);
			
			String url = httple.getUrl();
			Node urlNode = getHttpChild(httpNode, url);
			urlNode.atualizaHist(hist);
		}
	}
	
	/**
	 * Metodo que checa se ja existe um nó para aquela data
	 * Em caso afirmativo, retorna o nó ja existente
	 * Em caso negativo, cria um novo nó e o retorna
	 * @param ts Data usada para comparacao
	 * @return Nó de data
	 */
	public Node getDateChild(String ts) {
		Node result = null;
        Node userNode = getRoot();
        ArrayList<Node> children = userNode.getChilds();
        for(Node current: children ) {
        	SystemDate date = (SystemDate) current.getValue();
        	if(date.getDay().equals(ts.substring(0, 10))) {
        		result = current;
        		break;
        	}
        		
        }
        if(result == null) {
        	result = new Node(new SystemDate(ts));
        	children.add(result);
        }
        
        return result;
	}
	
	/**
	 * Metodo que checa se ja existe um nó para aquele dispositivo
	 * Em caso afirmativo, retorna o nó ja existente
	 * Em caso negativo, cria um novo nó e o retorna
	 * @param dateNode No de data pai de dispositivos
	 * @param ts Dispositivo usada para comparacao
	 * @return Nó do dispositivo
	 */
	public Node getPcChild(Node dateNode, String ts) {
		Node result = null;
        ArrayList<Node> children = dateNode.getChilds();
        for(Node current: children ) {
        	PC pc = (PC) current.getValue();
        	if(pc.getPcId().equals(ts)) {
        		result = current;
        		break;
        	}
        }
        if(result == null) {
        	result = new Node(new PC(ts));
        	children.add(result);
        }
        
        return result;
	}
	
	/**
	 * Metodo que checa se ja existe um nó para aquele tipo de acao
	 * Em caso afirmativo, retorna o nó ja existente
	 * Em caso negativo, cria um novo nó e o retorna
	 * @param pcNode No de dispositivo pai tipos de acoes
	 * @param ts Tipo de acao usada para comparacao
	 * @return Nó do tipo de acao
	 */
	public Node getActionChild(Node pcNode, String ts) {
		Node result = null;
        ArrayList<Node> children = pcNode.getChilds();

        for(Node current: children ) {
        	Action act = (Action) current.getValue();
        	if(act.getId().equals(ts)) {
        		result = current;
        		break;
        	}
        }
        if(result == null) {
        	result = new Node(new Action(ts));
        	children.add(result);
        }
        
        return result;
	}
	
	/**
	 * Metodo que checa se ja existe um nó para aquela atividade de Device
	 * Em caso afirmativo, retorna o nó ja existente
	 * Em caso negativo, cria um novo nó e o retorna
	 * @param deviceNode No de tipo de acao Device
	 * @param ts Atividade de Device usada para comparacao
	 * @return Nó da atividade do tipo Device
	 */
	public Node getDvcChild(Node deviceNode, String ts) {
		Node result = null;
        ArrayList<Node> children = deviceNode.getChilds();
        for(Node current: children ) {
        	Device device = (Device) current.getValue();
        	if(device.getActivity().equals(ts)) {
        		result = current;
        		break;
        	}
        }
        if(result == null) {
        	result = new Node(new Device(ts));
        	children.add(result);
        }
        
        return result;
	}
	
	/**
	 * Metodo que checa se ja existe um nó para aquela atividade de Logon
	 * Em caso afirmativo, retorna o nó ja existente
	 * Em caso negativo, cria um novo nó e o retorna
	 * @param loginNode No de tipo de acao Logon
	 * @param ts Atividade de Logon usada para comparacao
	 * @return Nó da atividade do tipo Logon
	 */
	public Node getLoginChild(Node loginNode, String ts) {
		Node result = null;
        ArrayList<Node> children = loginNode.getChilds();
        for(Node current: children ) {
        	Logon login = (Logon) current.getValue();
        	if(login.getActivity().equals(ts)) {
        		result = current;
        		break;
        	}
        }
        if(result == null) {
        	result = new Node(new Logon(ts));
        	children.add(result);
        }
        
        return result;
	}
	
	/**
	 * Metodo que checa se ja existe um nó para aquela URL
	 * Em caso afirmativo, retorna o nó ja existente
	 * Em caso negativo, cria um novo nó e o retorna
	 * @param httpNode No de tipo de acao Http
	 * @param ts URL usada para comparacao
	 * @return Nó da URL
	 */
	public Node getHttpChild(Node httpNode, String ts) {
		Node result = null;
        ArrayList<Node> children = httpNode.getChilds();
        for(Node current: children ) {
        	HTTP site = (HTTP) current.getValue();
        	if(site.getActivity().equals(ts)) {
        		result = current;
        		break;
        	}
        }
        if(result == null) {
        	result = new Node(new HTTP(ts));
        	children.add(result);
        }
        
        return result;
	}
}

