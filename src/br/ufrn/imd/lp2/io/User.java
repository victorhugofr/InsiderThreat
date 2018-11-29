package br.ufrn.imd.lp2.io;

/**
 * Classe que armazena informacoes sobre os usuarios
 * @author Gabriel Igor e Victor Hugo
 * @version 2018.29.11
 */
public class User extends AbstractSuper {
	// Nome do usuario
	private String employee_name;
	// ID do usuario
	private String user_id;
	// Dominio do usuario
	private String domain;
	// Email do usuario
	private String email;
	// Cargo do usuario
	private String role;

	/**
	 * Construtor padrão de User
	 */
	public User() {
		super();
	}
	
	/**
	 * Construtor parametrizavel
	 * @param employee_name Nome do usuario
	 * @param user_id ID do usuario
	 * @param domain Dominio do usuario
	 * @param email Email do usuario
	 * @param role Cargo do usuario
	 */
	public User(String employee_name, String user_id, String domain, String email, String role) {
		this.employee_name = employee_name;
		this.user_id = user_id;
		this.domain = domain;
		this.email = email;
		this.role = role;
	}
	
	/**
	 * Metodo que retorna nome do usuario
	 * @return Nome do usuario
	 */
	public String getName() {
		return employee_name;
	}
	
	/**
	 * Metodo que retorna ID do usuario
	 * @return ID do usuario
	 */
	public String getId() {
		return user_id;
	}
	
	/**
	 * Metodo que retorna dominio do usuario
	 * @return Dominio do usuario
	 */
	public String getDomain() {
		return domain;
	}
	
	/**
	 * Metodo que retorna email do usuario
	 * @return Email do usuario
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Metodo que retorna cargo do usuario
	 * @return Cargo do usuario
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Metodo para imprimir dados do usuario
	 */
	public void show() {
		System.out.println("Nome: " + getName());
		System.out.println("ID: " + getId());
		System.out.println("Dominio: " + getDomain());
		System.out.println("Email: " + getEmail());
		System.out.println("Função: " + getRole());
	}

}

