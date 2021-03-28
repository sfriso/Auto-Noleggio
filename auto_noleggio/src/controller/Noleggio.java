package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Noleggio {

	private String targa;
	private String username;
	private /* @ spec_public @ */ Date inizioNolo;
	private /* @ spec_public @ */ Date fineNolo;
	private String luogoConsegna;
	private String prezzo;
	private /* @ spec_public @ */ long durata;
	private String assicurazione;
	private Pagamento pagamento;

	// @ public invariant inizioNolo.compareTo(fineNolo) <= -1;

	// @ public invariant durata ==
	// TimeUnit.DAYS.convert((fineNolo.getTime()-inizioNolo.getTime()),
	// TimeUnit.MILLISECONDS);

	public Noleggio() {
	}

	public Noleggio(String targa, String username, Date inizioNolo, Date fineNolo, String assicurazione,
			String luogoConsegna, String prezzo) {
		this.targa = targa;
		this.username = username;
		this.inizioNolo = inizioNolo;
		this.assicurazione = assicurazione;
		this.fineNolo = fineNolo;
		this.luogoConsegna = luogoConsegna;
		this.prezzo = prezzo;
		if (inizioNolo.compareTo(fineNolo) <= -1) {
			durata = TimeUnit.DAYS.convert((fineNolo.getTime() - inizioNolo.getTime()), TimeUnit.MILLISECONDS);
		} else {
			System.out.printf("errore durata");
		}
	}

	public Noleggio(String targa, String username, Date inizioNolo, Date fineNolo, String assicurazione,
			String luogoConsegna) {
		this.targa = targa;
		this.username = username;
		this.inizioNolo = inizioNolo;
		this.assicurazione = assicurazione;
		this.fineNolo = fineNolo;
		this.luogoConsegna = luogoConsegna;
		if (inizioNolo.compareTo(fineNolo) <= -1) {
			durata = TimeUnit.DAYS.convert((fineNolo.getTime() - inizioNolo.getTime()), TimeUnit.MILLISECONDS);
		} else {
			System.out.printf("errore durata");
		}
	}

	public Noleggio(Date inizioNolo, Date fineNolo, String assicurazione) {
		this.inizioNolo = inizioNolo;
		this.assicurazione = assicurazione;
		this.fineNolo = fineNolo;
		if (inizioNolo.compareTo(fineNolo) <= -1) {
			durata = TimeUnit.DAYS.convert((fineNolo.getTime() - inizioNolo.getTime()), TimeUnit.MILLISECONDS);
		} else {
			System.out.printf("errore durata");
		}
	}

	public Noleggio(String targa, String username, String inizioNolo, String fineNolo, String assicurazione,
			String luogoConsegna) {
		// TODO Auto-generated constructor stub
		this.targa = targa;
		this.username = username;
		try {
			this.inizioNolo = new SimpleDateFormat("dd/MM/yy").parse(inizioNolo);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.assicurazione = assicurazione;
		try {
			this.fineNolo = new SimpleDateFormat("dd/MM/yy").parse(fineNolo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.luogoConsegna = luogoConsegna;
		if (inizioNolo.compareTo(fineNolo) <= -1) {
			durata = TimeUnit.DAYS.convert((this.fineNolo.getTime() - this.inizioNolo.getTime()), TimeUnit.MILLISECONDS);
		} else {
			System.out.printf("errore durata");
		}
	}

	public String getTarga() {
		return targa;
	}

	public String getUsername() {
		return username;
	}

	public Date getInizioNolo() {
		return inizioNolo;
	}

	public Date getFineNolo() {
		return fineNolo;
	}

	public String getLuogoConsegna() {
		return luogoConsegna;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public long getDurata() {
		return durata;
	}

	public String getAssicurazione() {
		return assicurazione;
	}

	public String calcolaPrezzo(float ratio, String price) {
		prezzo = Float.toString(Pagamento.calcolaPrezzo(ratio, price, assicurazione, durata));
		return prezzo;
	}

//	public static void main(String[] args) {
//		Noleggio n = new Noleggio("targa", "username", "12/12/20", "12/12/20",
//			"assicurazione", "luogoConsegna");
//	}
}
