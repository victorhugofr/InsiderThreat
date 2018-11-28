package br.ufrn.imd.lp2.io;

import java.util.ArrayList;

public class Tree {
	private Node root;
	
	public Tree(Node root) {
		this.root = root;
	}
	
	public void setRoot(Node root) {
		this.root=root;
	}
	
	public Node getRoot() {
		return root;
	}
	
	
	public Node getUserChild(Node currentNode, String dataToFind) {
		 Node returnNode = null;
	        int i = 0;
	        AbstractSuper aux = currentNode.getValue();
	        
	        if(aux instanceof User) {
	        	User member = (User) aux;
		        if (member.getId().equals(dataToFind)) {
		            returnNode = currentNode;
		        }
	        } 
	        
		 return returnNode;
	 }
	
	public void addLE(LogEntry le, String hist) {
		// Para a Data
		String ts= le.getDate();
		Node dataNode = getDateChild(ts);
		//AbstractSuper dataAs = dataNode.getValue();
		//SystemDate dataFinal = (SystemDate) dataAs;
		dataNode.atualizaHist(hist);
		// Para o PC
		String pcId= le.getPc();
		Node pcNode = getPcChild(dataNode, pcId);
		//SystemDate date = new SystemDate(le.getDate());
		pcNode.atualizaHist(hist);
		// Para as Actions
		if(le instanceof LogonLE) {
			LogonLE logonle = (LogonLE) le;
			Node logonNode = getActionChild(pcNode, "Log");
			//SystemDate logonDate = new SystemDate(le.getDate());
			logonNode.atualizaHist(hist);
			
			String login = logonle.getLogin();
			Node loginNode = getLoginChild(logonNode, login);
			//SystemDate loginDate = new SystemDate(le.getDate());
			loginNode.atualizaHist(hist);
		} else if(le instanceof DeviceLE) {
			DeviceLE devicele = (DeviceLE) le;
			Node deviceNode = getActionChild(pcNode, "Device");
			//SystemDate deviceDate = new SystemDate(le.getDate());
			deviceNode.atualizaHist(hist);
			
			String connection = devicele.getConnection();
			Node cntNode = getCntChild(deviceNode, connection);
			//SystemDate cntDate = new SystemDate(le.getDate());
			cntNode.atualizaHist(hist);
		} else if(le instanceof HttpLE) {
			HttpLE httple = (HttpLE) le;
			Node httpNode = getActionChild(pcNode, "Http");
			//SystemDate httpDate = new SystemDate(le.getDate());
			httpNode.atualizaHist(hist);
			
			String url = httple.getUrl();
			Node urlNode = getHttpChild(httpNode, url);
			//SystemDate urlDate = new SystemDate(le.getDate());
			urlNode.atualizaHist(hist);
		}
	}
	
	public Node getDateChild(String ts) {
		Node result = null;
		
        int i = 0;
        Node userNode = getRoot();
        ArrayList<Node> children = userNode.getChilds();
        for(Node current: children ) {
        	SystemDate date = (SystemDate) current.getValue();
        	if(date.getDay().equals(ts)) {
        		result = current;
        	}
        		
        }
        if(result == null) {
        	result = new Node();
        	result.setValue(new SystemDate(ts));
        	children.add(result);
        }
        
	 return result;
	}
	
	
	public Node getPcChild(Node dateNode, String ts) {
		Node result = null;
        ArrayList<Node> children = dateNode.getChilds();
        for(Node current: children ) {
        	PC pc = (PC) current.getValue();
        	if(pc.getPcId().equals(ts)) {
        		result = current;
        	}
        }
        if(result == null) {
        	result = new Node();
        	result.setValue(new PC(ts));
        	children.add(result);
        }
        
	 return result;
	}
	
	public Node getActionChild(Node pcNode, String ts) {
		Node result = null;
        ArrayList<Node> children = pcNode.getChilds();
        for(Node current: children ) {
        	Action act = (Action) current.getValue();
        	if(act.getId().equals(ts)) {
        		result = current;
        	}
        }
        if(result == null) {
        	result = new Node();
        	result.setValue(new Action(ts));
        	children.add(result);
        }
        
	 return result;
	}
	
	public Node getCntChild(Node deviceNode, String ts) {
		Node result = null;
        ArrayList<Node> children = deviceNode.getChilds();
        for(Node current: children ) {
        	Device device = (Device) current.getValue();
        	if(device.getActivity().equals(ts)) {
        		result = current;
        	}
        }
        if(result == null) {
        	result = new Node();
        	result.setValue(new Device(ts));
        	children.add(result);
        }
        
	 return result;
	}
	
	public Node getLoginChild(Node loginNode, String ts) {
		Node result = null;
        ArrayList<Node> children = loginNode.getChilds();
        for(Node current: children ) {
        	Logon login = (Logon) current.getValue();
        	if(login.getActivity().equals(ts)) {
        		result = current;
        	}
        }
        if(result == null) {
        	result = new Node();
        	result.setValue(new Logon(ts));
        	children.add(result);
        }
        
	 return result;
	}
	
	public Node getHttpChild(Node httpNode, String ts) {
		Node result = null;
        ArrayList<Node> children = httpNode.getChilds();
        for(Node current: children ) {
        	HTTP site = (HTTP) current.getValue();
        	if(site.getActivity().equals(ts)) {
        		result = current;
        	}
        }
        if(result == null) {
        	result = new Node();
        	result.setValue(new HTTP(ts));
        	children.add(result);
        }
        
	 return result;
	}
}

