package controller;

public class Impiegato {

	private String nome;
	private String cognome;
	private String username;
	
	public Impiegato(String username, String nome, String cognome) {
		// TODO Auto-generated constructor stub
		
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getUsername() {
		return username;
	}
}
