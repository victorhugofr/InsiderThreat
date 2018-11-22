import java.util.ArrayList;

public class DataBase {
	public ArrayList<Tree>users;
	
	public DataBase() {
		users=new ArrayList<Tree>();
	}
	
	public void verifica(Action teste) { // VERIFICA SE JA EXISTE UMA ÁRVORE COM AQUELE USER
		Node aux;
		boolean existe= false;
		for(int i=0;i<users.size();i++) {
			aux=users.get(i).search(users.get(i).getRoot(),teste.getUser()); 
			if(aux!=null) {//procura usuario
				existe=true;
				aux.getHist()[Integer.parseInt(teste.getDateString().substring(11, 13))]++;
				users.get(i).refresh(teste);
			}
		}
		
		if(existe==false) {// CASO NAO EXISTA, CRIE E ADICIONE SUAS RAIZES
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
	
	public void print() { // print das arvores
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
