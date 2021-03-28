package controller;

import java.util.Date;

public class Utente {
	private String nome;
	private String cognome;
	private String patente;
	private String email;
	private Float ratio;
	private String username;
	private Boolean accountVerificato;
	private Date dataScadenzaPatente;
	private Date dataDiNascita;
	private String numeroDiCellulare;
	private String cartaDiCredito;
	
	public Utente(String nome, String cognome, String patente, float ratio, 
			String email, boolean accountVerificato, String username, Date dataScadenzaPatente,
			Date dataDiNascita, String numeroDiCellulare, String cartaDiCredito) {
		this.nome = nome;
		this.cognome = cognome;
		this.patente = patente;
		this.email = email;
		this.ratio = ratio;
		this.accountVerificato = accountVerificato;	
		this.username = username;
		this.dataScadenzaPatente = dataScadenzaPatente;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiCellulare = numeroDiCellulare;
		this.cartaDiCredito = cartaDiCredito;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getPatente() {
		return patente;
	}

	public String getEmail() {
		return email;
	}

	public Float getRatio() {
		return ratio;
	}

	public String getUsername() {
		return username;
	}

	public Boolean getAccountVerificato() {
		return accountVerificato;
	}

	public Date getDataScadenzaPatente() {
		return dataScadenzaPatente;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public String getNumeroDiCellulare() {
		return numeroDiCellulare;
	}

	public String getCartaDiCredito() {
		return cartaDiCredito;
	}

	
	
}
