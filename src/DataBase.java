import java.util.ArrayList;

public class DataBase {
	public ArrayList<Tree>users;
	
	public DataBase() {
		users=new ArrayList<Tree>();
	}
	
	public void verifica(Action teste) {
		Node aux;
		Node aux2;
		Node aux3,aux4;
		boolean existe= false;
		for(int i=0;i<users.size();i++) {
			aux=users.get(i).search(users.get(i).getRoot(),teste.getUser()); 
			if(aux!=null) {//procura usuario
				existe=true;
				aux.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
				aux2=users.get(i).search(aux,teste.getDateString()); 
				if(aux2!=null) {//procura data
					aux.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
					aux3=users.get(i).search(aux,teste.getPc());
					if(aux3!=null) {//procura PC
						aux3.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
						aux4=users.get(i).search(aux,teste.getActivity());
						if(aux4!=null) {//procura atividade
							aux4.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
						}else {
							Node activity=new Node(teste.getActivity());
							activity.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
							aux2.getChilds().add(activity);
						}
					}else {
						Node PC= new Node(teste.getPc());
						Node activity=new Node(teste.getActivity());
						PC.getChilds().add(activity);
						PC.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
						aux.getChilds().add(PC);
					}
				}else {
					Node data=new Node(teste.getDateString());
					Node PC= new Node(teste.getPc());
					Node activity=new Node(teste.getActivity());
					PC.getChilds().add(activity);
					data.getChilds().add(PC);
					
					data.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
					PC.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
					aux.getChilds().add(data);
				}
			}
		}
		
		if(existe==false) {
			Node id= new Node(teste.getUser());
			Node data=new Node(teste.getDateString());
			Node PC= new Node(teste.getPc());
			Node activity=new Node(teste.getActivity());
			
			activity.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
			
			PC.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
			PC.getChilds().add(activity);
			
			data.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;		
			data.getChilds().add(PC);
			
			id.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
			id.getChilds().add(data);
			
			Tree user = new Tree();
			user.setRoot(id);
			users.add(user);
		}
	}
	
	public void print() {
		Node aux,aux2,aux3,aux4;
		int i,j,z,h;
		for(i=0;i<users.size();i++) {
			aux=users.get(i).getRoot();
			System.out.println(aux.getValue());
			for(z=0;z<aux.getChilds().size();z++) {
				aux2=aux.getChildAt(z);
				System.out.println(aux2.getValue());
				for(j=0;j<aux2.getChilds().size();j++) {
					aux3=aux2.getChildAt(j);
					System.out.println(aux3.getValue());
					for(h=0;h<aux3.getChilds().size();h++){
						aux4=aux3.getChildAt(h);
						System.out.println(aux4.getValue());
					}
				}
			}
		}
	}
}
