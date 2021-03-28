package controller;

import java.util.Date;

public class Auto {

	private String targa;
	private String modello;
	private String marca;
	private String posti;
	private String cilindrata;
	private String cavalli;
	private String consumi;
	private Date prossimaRevisione;
	private Date prossimoBollo;
	private Date cambioRuote;
	private Date rinnovoAssicurazione;
	private String danniCarrozzeria;
	private String danniInterno;
	private String pulizia;
	private String prezzo;
	
//	private Boolean disponibile;
	
	private Integer id;
	
	public Auto(String targa, String marca, String modello, String posti, String cilindrata, String cavalli,
			String consumi, Date prossimaRevisione, Date prossimoBollo, Date cambioRuote, Date rinnovoAssicurazione,
			String danniCarrozzeria, String danniInterno,  String pulizia, String prezzo) {
		// TODO Auto-generated constructor stub
		
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.posti = posti;
		this.cilindrata = cilindrata;
		this.cavalli = cavalli;
		this.consumi = consumi;
		this.prossimaRevisione = prossimaRevisione;
		this.prossimoBollo = prossimoBollo;
		this.cambioRuote = cambioRuote;
		this.rinnovoAssicurazione = rinnovoAssicurazione;
		this.danniCarrozzeria = danniCarrozzeria;
		this.danniInterno = danniInterno;
		this.pulizia = pulizia;
		this.prezzo = prezzo;
	}
	
	public Auto(String targa, String marca, String modello, String posti, String cilindrata, String cavalli,
			String consumi, String prezzo) {
		// TODO Auto-generated constructor stub
		
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.posti = posti;
		this.cilindrata = cilindrata;
		this.cavalli = cavalli;
		this.consumi = consumi;
		this.prezzo = prezzo;
	}
	
	public void aggiornaStatoAuto() {
		
	}
	
	public void noleggioAuto() {
		
	}
	
	public void confermaNoleggio() {
		
	}
	
	public void termineAnticipatoNoleggio() {
		
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getPosti() {
		return posti;
	}

	public void setPosti(String posti) {
		this.posti = posti;
	}

	public String getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(String cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getCavalli() {
		return cavalli;
	}

	public void setCavalli(String cavalli) {
		this.cavalli = cavalli;
	}

	public String getConsumi() {
		return consumi;
	}

	public void setConsumi(String consumi) {
		this.consumi = consumi;
	}

	public Date getProssimaRevisione() {
		return prossimaRevisione;
	}

	public void setProssimaRevisione(Date prossimaRevisione) {
		this.prossimaRevisione = prossimaRevisione;
	}

	public Date getProssimoBollo() {
		return prossimoBollo;
	}

	public void setProssimoBollo(Date prossimoBollo) {
		this.prossimoBollo = prossimoBollo;
	}

	public Date getCambioRuote() {
		return cambioRuote;
	}

	public void setCambioRuote(Date cambioRuote) {
		this.cambioRuote = cambioRuote;
	}

	public Date getRinnovoAssicurazione() {
		return rinnovoAssicurazione;
	}

	public void setRinnovoAssicurazione(Date rinnovoAssicurazione) {
		this.rinnovoAssicurazione = rinnovoAssicurazione;
	}

	public String getDanniCarrozzeria() {
		return danniCarrozzeria;
	}

	public void setDanniCarrozzeria(String danniCarrozzeria) {
		this.danniCarrozzeria = danniCarrozzeria;
	}

	public String getDanniInterno() {
		return danniInterno;
	}

	public void setDanniInterno(String danniInterno) {
		this.danniInterno = danniInterno;
	}

	public String getPulizia() {
		return pulizia;
	}

	public void setPulizia(String pulizia) {
		this.pulizia = pulizia;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getPrezzo() {
		return prezzo;
	}
		
	
}
