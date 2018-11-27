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
	
	public void addLE(LogEntry le) {
		// Para a Data
		String ts= le.getDate();
		Node dataNode = getDateChild(ts);
		AbstractSuper dataAs = dataNode.getValue();
		SystemDate dataFinal = (SystemDate) dataAs;
		dataNode.atualizaHist(dataFinal.getHour());
		// Para o PC
		String pcId= le.getPc();
		Node pcNode = getPcChild(dataNode, pcId);
		SystemDate date = new SystemDate(le.getDate());
		pcNode.atualizaHist(date.getHour());
		// Para as Actions
		if(le instanceof DeviceLE) {
			DeviceLE devicele = (DeviceLE) le;
			Node deviceNode = getActionChild(pcNode, "Device");
			SystemDate deviceDate = new SystemDate(le.getDate());
			deviceNode.atualizaHist(deviceDate.getHour());
			
			String connection = devicele.getConnection();
			Node cntNode = getCntChild(deviceNode, connection);
			SystemDate cntDate = new SystemDate(le.getDate());
			cntNode.atualizaHist(cntDate.getHour());
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
}

