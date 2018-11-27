package br.ufrn.imd.lp2.io;

import java.util.ArrayList;

public class User extends AbstractSuper {
	private String employee_name;
	private String user_id;
	private String domain;
	private String email;
	private String role;
	
	//private ArrayList<PC> pcs;
	
	public User() {
		super();
	}
	
	public User(String employee_name, String user_id, String domain, String email, String role) {
		this.employee_name = employee_name;
		this.user_id = user_id;
		this.domain = domain;
		this.email = email;
		this.role = role;
		//pcs = new ArrayList<PC>();
	}
	
	public String getName() {
		return employee_name;
	}
	
	public String getId() {
		return user_id;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getRole() {
		return role;
	}
	
	public void show() {
		System.out.println("Nome: " + getName());
		System.out.println("ID: " + getId());
		System.out.println("Dominio: " + getDomain());
		System.out.println("Email: " + getEmail());
		System.out.println("Função: " + getRole());
	}
	/*
	public ArrayList<PC> getPcs(){
		return pcs;
	}
	*/
}
