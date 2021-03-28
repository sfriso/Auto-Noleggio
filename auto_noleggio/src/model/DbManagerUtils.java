package model;

public final class DbManagerUtils {
	
	
	public static final String INSERISCI_IMPIEAGATI = "insert into IMPIEGATI (Username, Password, Salt) values (?, ?, ?) ";
	public static final String LOGIN = "select password, salt FROM IMPIEGATI WHERE Username=?";
	public static final String LOGIN_CLIENTE = "Select password, salt FROM CLIENTI WHERE Username=?";
	
	
	public static final String TUTTI_INFOCLIENTI = "select * from INFOCLIENTI";
	
	public static final String SALVA_TUTTI_INFOCLIENTI = "update INFOCLIENTI set Nome=?, Cognome=?, Patente=?, Ratio=?,"
			+ " Email=?, AccountVerificato=?, Username = ?, DataScadenzaPatente = ?, DataDiNascita = ?, NumeroDiCellulare = ?, CartaDiCredito = ? WHERE Username = ?";
	
	
	public static final String REGISTRA_CLIENTE = "insert into INFOCLIENTI (Nome,Cognome,Patente,Ratio,Email,AccountVerificato,Username,DataScadenzaPatente,DataDiNascita, NumeroDiCellulare, CartaDiCredito)"
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
	public static final String NUOVA_ENTRY_CLIENTI = " insert into CLIENTI (Username, Password, Salt) values (?, ?, ?) ";
	
	public static final String CANCELLA_UTENTE = "delete from infoclienti where username = ?";

	public static final String CANCELLA_AUTO = "delete from infoauto where targa = ?";
	public static final String INSERISCI_AUTO = "insert into INFOAUTO (targa, marca, modello, posti, cilindrata, cavalli, consumi, prossimaRevisione, prossimoBollo, cambioRuote, rinnovoAssicurazione, danniCarrozzeria,"
			+ "danniInterno, pulizia, prezzo) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SELECT_INFO_AUTO = "SELECT * FROM INFOAUTO";
	public static final String INSERISCI_INFOAUTO = "update INFOAUTO set targa = ?, marca= ?, modello = ?, posti= ?, cilindrata= ?, cavalli= ?, consumi= ?, prossimaRevisione= ?, prossimoBollo= ?,"
			+ " cambioRuote= ?, rinnovoAssicurazione= ?, danniCarrozzeria= ?, danniInterno = ?, pulizia = ?, prezzo = ? where targa = ? ";
	
	
	public static final String RICERCA_TUTTO = "select DISTINCT targa, marca, modello, posti, cilindrata, cavalli, consumi, prezzo from INFOAUTO AS A LEFT  NATURAL JOIN NOLEGGIO " + 
			"where  NOT EXISTS (SELECT  * from NOLEGGIO as B WHERE B.dataInizio BETWEEN ? and ? and B.dataFine BETWEEN ? and ? and A.targa = B.targa) and A.marca like ? and A.modello like ? "
			+ "and A.posti like ? and A.cilindrata like ? and A.cavalli like ? and A.consumi like ?";
	
	public static final String RICERCA_TUTTO_IL_RESTO = "select DISTINCT targa, marca, modello, posti, cilindrata, cavalli, consumi, prezzo, dataInizio, dataFine from INFOAUTO AS A LEFT  NATURAL JOIN NOLEGGIO " + 
			"where   EXISTS (SELECT  * from NOLEGGIO as B WHERE B.dataInizio BETWEEN ? and ? and B.dataFine BETWEEN ? and ? and A.targa = B.targa) and A.marca like ? and A.modello like ? "
			+ "and A.posti like ? and A.cilindrata like ? and A.cavalli like ? and A.consumi like ?";

	public static final String RATIO_USERPAT = "select ratio from INFOCLIENTI where username = ? and patente = ?";
	
	public static final String ACCOUNT_VERIFICATO = "select AccountVerificato from INFOCLIENTI where username = ?";
	
	public static final String INSERISCI_NOLEGGIO = "insert into NOLEGGIO (targa, username, dataInizio, dataFine, assicurazione, luogoConsegna, preventivo) values (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String ESISTE_USER = "select count(*) from INFOCLIENTI where username = ?";
	public static final String TUTTO_NOLO = "select targa, username, dataInizio, dataFine, assicurazione, luogoConsegna, preventivo from NOLEGGIO";
	public static final String SELECT_SPECIFICA_INFOAUTO = "select * from INFOAUTO where targa = ?";
	public static final String SELECT_SPECIFICO_UTENTE = "select * from INFOCLIENTI where username = ?";
	public static final String CANCELLA_NOLEGGIO = "DELETE FROM NOLEGGIO WHERE username = ?  and targa = ?";
	
	public static final String IMPOSTA_PASSWORD_CLIENTE = "update CLIENTI set password = ? where username = ? ";
	
	public static final String SELECT_IMPIEGATO = "select username, nome, cognome FROM INFOIMPIEGATI where username = ?";
	public static final String ACCOUNT_ESISTE = "select count(*) FROM clienti where username = ?";
	public static final String LISTA_NOLEGGI = "SELECT * FROM NOLEGGIO WHERE username = ?";
	public static final String SALT_CLIENTE = "SELECT SALT FROM CLIENTI WHERE username = ?";
	public static final String SALT_IMPIEGATO = "SELECT SALT FROM IMPIEGATI WHERE username = ?";
}
