package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.DbManager;
import view.FineNoleggioV;
import view.InserisciAutoV;
import view.LoggatoClienteV;
import view.LoggatoV;
import view.LoginV;
import view.ModificaAutoV;
import view.ModificaClientiV;
import view.ModificaProfiloUtenteV;
import view.NoleggiUtenteV;
import view.NoleggioAutoV;
import view.RegistraNonLoggatoV;
import view.RegistraV;
import view.RicercaNoleggioV;
import view.RicercaNoloClienteV;
import view.RicercaNoloNonRegistratoV;
import view.View;

public class GestioneAutonoleggio {
	
	String path = "C:/Users/aless/Desktop/AutoNoleggio.db";
	
	private View view;
	private LoginV login;
	private LoggatoV loggato;
	private ModificaClientiV modClienti;
	private RegistraV registrazione;
	private InserisciAutoV insAuto;
	private ModificaAutoV modAuto;
	private NoleggioAutoV noleggioAutoV;
	private RicercaNoleggioV ricercaNoloV;
	private FineNoleggioV fineNolo;
	private Impiegato impiegato;
	private LoggatoClienteV loggatoCliente;
	private Utente cliente;
	private ModificaProfiloUtenteV modCliente;
	private NoleggioAutoV noleggioAutoUtente;
	private RicercaNoloClienteV ricercaNoloCliente;
	private RegistraNonLoggatoV registraNuovoUtente;
	private NoleggiUtenteV noleggiUtenti;
	private NoleggioAutoV ricercaNonRegistrato;
	private RicercaNoloNonRegistratoV risRicercaNonRegistrato;
//	private PagaNoloV pagaNoloV;
	private DbManager db;
	private ArrayList<Utente> utenti;
	private ArrayList<Auto> macchine;
	private ArrayList<Noleggio> noleggi;

	private Format s = new SimpleDateFormat("dd/MM/yy");

	public GestioneAutonoleggio() throws SQLException {
		initView();

	}

	public void initView() throws SQLException {
		view = new View();
//		ga = new GestioneAutonoleggio();
		db = new DbManager("jdbc:sqlite:" + path);
//		db.modificaadmin();

	}
//	da modificare il controller 

	protected void mostraLogin() {
		login = new LoginV(view.getFrame());
		System.out.println("mostra Login");
		login.getButtonLoginLogin().addActionListener(e -> loginImpiegato());
		login.getBtnCliente().addActionListener(e -> loginCliente());
		login.getBtnRegistrati().addActionListener(e -> mostraNuovoUtente());
		login.getBtnRicercaAuto().addActionListener(e -> mostraRicercaNonRegistrato());
	}

	private void mostraLoggato() {
		System.out.println("mostra loggato");
		loggato = new LoggatoV(view.getFrame());
		loggato.setLabelUsernameLoggato(impiegato.getUsername());
		loggato.getButtonLogoutLoggato().addActionListener(e -> mostraLogin());
		loggato.getButtonModificaClienteLoggato().addActionListener(e -> mostraModifcaCliente());
		loggato.getBtnRegistrazioneLoggato().addActionListener(e -> mostraRegistrazione());
		loggato.getBtnInsAutoLoggato().addActionListener(e -> mostraInserisciAuto());
		loggato.getButtonModificaautoLoggato().addActionListener(e -> mostraModificaAuto());
		loggato.getButtonNoleggiaautoLoggato().addActionListener(e -> mostraNoleggio());
		loggato.getBtnFineNoleggio().addActionListener(e -> mostraFineNolo());
	}

	private void mostraLoggatoCliente() {
		loggatoCliente = new LoggatoClienteV(view.getFrame());
		loggatoCliente.setLblUser(cliente.getUsername());
		loggatoCliente.getBtnLogout().addActionListener(e -> mostraLogin());
		loggatoCliente.getBtnModificaProfilo().addActionListener(e -> mostraModificaCliente());
		loggatoCliente.getBtnNoleggiaAuto().addActionListener(e -> mostraNoleggioCliente());
		loggatoCliente.getBtnCancellaNolo().addActionListener(e -> mostraCancellaNoleggioUtente());
	}

	private void mostraModifcaCliente() {
		ResultSet rs = db.selectInfoClienti();
		utenti = new ArrayList<Utente>();
		Utente user = null;
		try {
			while (rs.next()) {

				user = new Utente(rs.getString("nome"), rs.getString("cognome"), rs.getString("patente"),
						Float.parseFloat(new DecimalFormat("##.##").format(rs.getFloat("ratio"))),
						rs.getString("email"), rs.getBoolean("accountVerificato"), rs.getString("username"),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString("dataScadenzaPatente")),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString("dataDiNascita")),
						rs.getString("numeroDiCellulare"), rs.getString("cartaDiCredito"));
				if (utenti != null) {
					utenti.add(user);
				} else {
					System.out.println(user.getUsername());

				}

			}
		} catch (NumberFormatException | SQLException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		modClienti = new ModificaClientiV(view.getFrame(), utenti);
		modClienti.getBtnHomePageModclienti().addActionListener(e -> mostraLoggato());
		modClienti.getBtnSalvaModclienti().addActionListener(e -> salvaModificaCliente());
		modClienti.getBtnEliminaCliente().addActionListener(e -> EliminaCliente());
	}

	private void mostraRegistrazione() {
		registrazione = new RegistraV(view.getFrame());
		registrazione.getBtnIndietroRegistrazione().addActionListener(e -> mostraLoggato());
		registrazione.getBtnSalvaRegistrazione().addActionListener(e -> registraUtente());
	}

	private void mostraInserisciAuto() {
		insAuto = new InserisciAutoV(view.getFrame());
		insAuto.getBtnIndietroInsAuto().addActionListener(e -> mostraLoggato());
		insAuto.getBtnSalvaInsAuto().addActionListener(e -> inserisciAuto());

	}

	private void mostraModificaAuto() {
		ResultSet rs = db.selectInfoAuto();
		macchine = new ArrayList<Auto>();
		try {
			while (rs.next()) {
				Auto auto = new Auto(rs.getString("targa"), rs.getString("marca"), rs.getString("modello"),
						rs.getString("posti"), rs.getString("cilindrata"), rs.getString("cavalli"),
						rs.getString("consumi"),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString("prossimaRevisione")),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString("prossimoBollo")),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString("cambioRuote")),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString("rinnovoAssicurazione")),
						rs.getString("danniCarrozzeria"), rs.getString("danniInterno"), rs.getString("pulizia"),
						rs.getString("prezzo"));
				macchine.add(auto);
			}
		} catch (SQLException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		modAuto = new ModificaAutoV(view.getFrame(), macchine);
		modAuto.getBtnIndietroModAuto().addActionListener(e -> mostraLoggato());
		modAuto.getBtnEliminaAuto().addActionListener(e -> eliminaAuto());
		modAuto.getBtnSalvaModAuto().addActionListener(e -> salvaModAuto());

	}

	private void mostraNoleggio() {
		noleggioAutoV = new NoleggioAutoV(view.getFrame());
		noleggioAutoV.getBtnIndietro().addActionListener(e -> mostraLoggato());
		noleggioAutoV.getBtnCerca().addActionListener(e -> ricercaNolo());
	}

	private void mostraRicercaNolo(ArrayList<Auto> res, ArrayList<Auto> nonList, String dataInizio, String dataFine,
			String luogo) {
		ricercaNoloV = new RicercaNoleggioV(view.getFrame(), res, nonList, dataInizio, dataFine, luogo);
		System.out.println("mostraRicercaNoleggio");
		ricercaNoloV.getBtnPreventivo().addActionListener(e -> calcolaPreventivo());
		ricercaNoloV.getBtnIndietro().addActionListener(e -> mostraNoleggio());
		ricercaNoloV.getBtnNoleggia().addActionListener(e -> salvaNoleggio());

	}

	private void mostraFineNolo() {
		ResultSet rs = db.tuttiNolo();
		noleggi = new ArrayList<Noleggio>();
		try {
			while (rs.next()) {
				Noleggio n = null;
				n = new Noleggio(rs.getString(1), rs.getString(2),
						new SimpleDateFormat("dd/MM/yy").parse((rs.getString(3))),
						new SimpleDateFormat("dd/MM/yy").parse(rs.getString(4)), rs.getString(5), rs.getString(6),
						rs.getString(7));

				noleggi.add(n);
			}
		} catch (SQLException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fineNolo = new FineNoleggioV(view.getFrame(), noleggi);
		fineNolo.getBtnIndietro().addActionListener(e -> mostraLoggato());
		fineNolo.getBtnCerca().addActionListener(e -> cercaAuto());

//		paga nolo non implementato!
		fineNolo.getBtnPagaNoleggio().addActionListener(e -> mostraFineNolo());
		fineNolo.getBtnCancNolo().addActionListener(e -> cancNolo());
	}

	private void mostraModificaCliente() {
		modCliente = new ModificaProfiloUtenteV(view.getFrame(), cliente);
		System.out.println(" email " + cliente.getEmail());
		modCliente.getBtnSalva().addActionListener(e -> salvaProfiloUtente());
		modCliente.getBtnCambiaPsw().addActionListener(e -> salvaNuovaPassword());
		modCliente.getBtnIndietro().addActionListener(e -> mostraLoggatoCliente());
		modCliente.getBtnCancellaProf().addActionListener(e -> cancellaProfilo());
	}

	private void mostraNoleggioCliente() {
		noleggioAutoUtente = new NoleggioAutoV(view.getFrame());
		noleggioAutoUtente.getBtnIndietro().addActionListener(e -> mostraLoggatoCliente());
		noleggioAutoUtente.getBtnCerca().addActionListener(e -> ricercaNoloUtente());
	}

	private void mostraRicercaNoloUtente(ArrayList<Auto> res, String dataInizio, String dataFine, String luogo) {
		ricercaNoloCliente = new RicercaNoloClienteV(view.getFrame(), res, dataInizio, dataFine, luogo);
		ricercaNoloCliente.getBtnIndietro().addActionListener(e -> mostraNoleggioCliente());
		ricercaNoloCliente.getBtnPreventivo().addActionListener(e -> preventivoUtenteNolo());
		ricercaNoloCliente.getBtnNoleggia().addActionListener(e -> salvaNoleggioCliente());
	}

	private void mostraNuovoUtente() {
		registraNuovoUtente = new RegistraNonLoggatoV(view.getFrame());
		registraNuovoUtente.getBtnIndietroRegistrazione().addActionListener(e -> mostraLogin());
		registraNuovoUtente.getBtnSalvaRegistrazione().addActionListener(e -> salvaRegistrazione());
	}

	private void mostraCancellaNoleggioUtente() {
		ResultSet rs = db.listaNoloUtente(cliente.getUsername());
		ArrayList<Noleggio> list = new ArrayList<Noleggio>();
		Noleggio n = null;
		try {
			while (rs.next()) {
				System.out.println(rs.getString(1));
				n = new Noleggio(rs.getString(1), rs.getString(2),
						new SimpleDateFormat("dd/MM/yy").parse((rs.getString(3))),
						new SimpleDateFormat("dd/MM/yy").parse(rs.getString(4)), rs.getString(5), rs.getString(6),
						rs.getString(7));

				list.add(n);
			}
		} catch (SQLException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		noleggiUtenti = new NoleggiUtenteV(view.getFrame(), list);
		noleggiUtenti.getBtnIndietro().addActionListener(e -> mostraLoggatoCliente());
		noleggiUtenti.getBtnCancellaNoleggio().addActionListener(e -> cancellaNoleggioUtente());
	}

	public void mostraRicercaNonRegistrato() {
		ricercaNonRegistrato = new NoleggioAutoV(view.getFrame());
		ricercaNonRegistrato.getBtnIndietro().addActionListener(e -> mostraLogin());
		ricercaNonRegistrato.getBtnCerca().addActionListener(e -> cercaAutoNonRegistrato());
	}

	public void mostraRisRicercaNonRegistrato(ArrayList<Auto> res, String dataInizio, String dataFine, String luogo) {
		risRicercaNonRegistrato = new RicercaNoloNonRegistratoV(view.getFrame(), res, dataInizio, dataFine, luogo);
		risRicercaNonRegistrato.getBtnPreventivo().addActionListener(e -> preventivoNonRegistrato());
		risRicercaNonRegistrato.getBtnIndietro().addActionListener(e -> mostraRicercaNonRegistrato());
	}

//	*
//	*
//	*		azioni
//	*
//	*

	public void loginImpiegato() {

		try {
			System.out.println("hai schiacciato il tasto");
			if ((db.loginImpiegati(login.getTexfieldUsernameLogin(), login.getTextfieldPasswordLogin()) == true) ? true
					: false) {
				ResultSet a = db.ritornaImpiegato(login.getTexfieldUsernameLogin());
				impiegato = new Impiegato(a.getString("username"), a.getString("nome"), a.getString("cognome"));
				mostraLoggato();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void salvaModificaCliente() {
		try {
			db.insertInfoClienti(modClienti.getTabellaModificaCliente());
		} catch (ParseException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		mostraModifcaCliente();
	}

	public void registraUtente() {
		try {
			if (!(db.esistitoUser(registrazione.utente().getUsername()))) {
				Utente u = registrazione.utente();
				db.registraUtente(new Utente(u.getNome(), u.getCognome(), u.getPatente(), u.getRatio(), u.getEmail(),
						u.getAccountVerificato(), u.getUsername(), u.getDataScadenzaPatente(), u.getDataDiNascita(),
						u.getNumeroDiCellulare(), u.getCartaDiCredito()));
				mostraModifcaCliente();
			} else {
				mostraModifcaCliente();
				System.out.println("utente gia esistito");
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void inserisciAuto() {

		try {
			Auto a = new Auto(insAuto.getTextTargaInsAuto().getText(), insAuto.getTextMarcaInsAuto().getText(),
					insAuto.getTextModelloInsAuto().getText(), insAuto.getTextPostiInsAuto().getText(),
					insAuto.getTextCilindrataInsAuto().getText(), insAuto.getTextCavalliInsAuto().getText(),
					insAuto.getTextConsumiInsAuto().getText(),
					new SimpleDateFormat("dd/MM/yy").parse(insAuto.getTextProsRevisioneInsAuto().getText()),
					new SimpleDateFormat("dd/MM/yy").parse(insAuto.getTextProsBolloAuto().getText()),
					new SimpleDateFormat("dd/MM/yy").parse(insAuto.getTextCamRuoteInsAuto().getText()),
					new SimpleDateFormat("dd/MM/yy").parse(insAuto.getTextAssicurazioneInsAuto().getText()),
					insAuto.getTextDanniCarrInsAuto().getText(), insAuto.getTextDanniInsInsAuto().getText(),
					insAuto.getTextPuliziaInsAuto().getText(), insAuto.getTextPrezzo().getText());
			if (db.registraAuto(a)) {
				mostraLoggato();
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void salvaModAuto() {
		ArrayList<Auto> listAuto = modAuto.listaAuto();
		if (db.inserisciInfoAuto(listAuto)) {
			System.out.println("salvato!");
			mostraLoggato();
		}

	}
	
	public void eliminaAuto() {
		db.cancellaAuto((String) modAuto.getModel().getValueAt(modAuto.getTable().getSelectedRow(), 0));
		mostraModificaAuto();
	}

	public void ricercaNolo() {
//				attezione!!
		System.out.println("Stai Cercando l'auto!");
		try {
			if (new SimpleDateFormat("dd/MM/yy").parse(noleggioAutoV.getTextDataInizio().getText()).compareTo(
					new SimpleDateFormat("dd/MM/yy").parse(noleggioAutoV.getTextDataFine().getText())) <= -1) {
				System.out.println("sei qui!");
				ArrayList<Auto> list = new ArrayList<Auto>();
				ResultSet rs = db.ricercaNolo(noleggioAutoV.getTextDataInizio().getText(),
						noleggioAutoV.getTextDataFine().getText(), noleggioAutoV.getTextMarca().getText(),
						noleggioAutoV.getTextModello().getText(), noleggioAutoV.getTextPosti().getText(),
						noleggioAutoV.getTextCilindrata().getText(), noleggioAutoV.getTextCavalli().getText(),
						noleggioAutoV.getTextConsumi().getText(), (String) noleggioAutoV.getLuogo().getSelectedItem());
				try {
					//lista noleggiato
					while (rs.next())

					{
						Auto rc = new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
						list.add(rc);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//
				// lista non noleggiato
				ArrayList<Auto> listnon = new ArrayList<Auto>();
				rs = db.ricercaNonNolo(noleggioAutoV.getTextDataInizio().getText(),
						noleggioAutoV.getTextDataFine().getText(), noleggioAutoV.getTextMarca().getText(),
						noleggioAutoV.getTextModello().getText(), noleggioAutoV.getTextPosti().getText(),
						noleggioAutoV.getTextCilindrata().getText(), noleggioAutoV.getTextCavalli().getText(),
						noleggioAutoV.getTextConsumi().getText(), (String) noleggioAutoV.getLuogo().getSelectedItem());

				try {
					while (rs.next()) {
						Auto rc = new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
						listnon.add(rc);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("inzio non nolo");
				//
				mostraRicercaNolo(list, listnon, noleggioAutoV.getTextDataInizio().getText(),
						noleggioAutoV.getTextDataFine().getText(), (String) noleggioAutoV.getLuogo().getSelectedItem());
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void calcolaPreventivo() {
		// TODO Auto-generated method stub
		System.out.println(ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 9)); // print
																												// the
																												// price
																												// of
																												// row
		System.out.println((String) ricercaNoloV.getComboBox().getSelectedItem());
		Noleggio n = null;

		System.out.println(" account verificato: " + db.verificaAccount(ricercaNoloV.getTextUsername().getText()));
		if (!(db.verificaAccount(ricercaNoloV.getTextUsername().getText()))) {
			ricercaNoloV.setLblprezzo("Utente non verificato!");
		} else {
			try {
				n = new Noleggio(new SimpleDateFormat("dd/MM/yy").parse(
						(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 1)),
						new SimpleDateFormat("dd/MM/yy").parse((String) ricercaNoloV.getTable()
								.getValueAt(ricercaNoloV.getTable().getSelectedRow(), 2)),
						(String) ricercaNoloV.getComboBox().getSelectedItem());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			float i = db.ratioUser(ricercaNoloV.getTextUsername().getText(), ricercaNoloV.getTextPatente().getText());
			if (i != -1) {
				ricercaNoloV.setLblprezzo(n.calcolaPrezzo(i,
						(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 9)));
				System.out.println("prezzo alla linea "
						+ (String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 9));
				System.out.println(n.calcolaPrezzo(
						db.ratioUser(ricercaNoloV.getTextUsername().getText(), ricercaNoloV.getTextPatente().getText()),
						(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 9)));
			}
			//
			// creo l'oggetto noleggio e poi richiamo il suo metodo per il prezzo lo setto
			//
		}

	}

	public void salvaNoleggio() {
		String username = db.esisteUser(ricercaNoloV.getTextUsername().getText());
		if (!(db.verificaAccount(username))) {
			mostraLoggato();
		}

		else {

			// successivamente rimuover noleggio e richiamare ga

			Noleggio n = new Noleggio(
					(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 0), // targa
					username, (String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 1), // data
																														// inzio
					(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 2), // data
																												// fine
					(String) ricercaNoloV.getComboBox().getSelectedItem(), // assicurazione
					(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 10)); // luogo

			n.calcolaPrezzo(
					db.ratioUser(ricercaNoloV.getTextUsername().getText(), ricercaNoloV.getTextPatente().getText()), // ratio
					(String) ricercaNoloV.getTable().getValueAt(ricercaNoloV.getTable().getSelectedRow(), 9) // prezzo
																												// auto
			);
			if (db.inserisciNolo(n.getTarga(), n.getUsername(), s.format(n.getInizioNolo()), s.format(n.getFineNolo()),
					n.getAssicurazione(), n.getLuogoConsegna(), n.getPrezzo())) {
				mostraLoggato(); // se ritorna un valore che è
			}
		}

	}

	public void cercaAuto() {
		// TODO Auto-generated method stub
		ResultSet rs = db
				.getAuto((String) fineNolo.getTableNoleggio().getValueAt(fineNolo.getTableNoleggioRowSelected(), 0));
		Auto a = null;
		try {
			if (rs.next()) {
				a = new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(8)),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(9)),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(10)),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(11)), rs.getString(12),
						rs.getString(13), rs.getString(14), rs.getString(15));
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rs = db.getUtente((String) fineNolo.getTableNoleggio().getValueAt(fineNolo.getTableNoleggioRowSelected(), 1));
		Utente u = null;
		try {
			if (rs.next()) {
				u = new Utente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getBoolean(6), rs.getString(7),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(8)),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(9)), rs.getString(10),
						rs.getString(11));
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] o = new Object[5];
		o[0] = a.getTarga();
		o[1] = a.getDanniCarrozzeria();
		o[2] = a.getDanniInterno();
		o[3] = a.getPulizia();
		o[4] = a.getPrezzo();
		Object[] ou = new Object[4];
		ou[0] = u.getNumeroDiCellulare();
		ou[1] = u.getRatio();
		ou[2] = u.getEmail();
		ou[3] = u.getUsername();
		fineNolo.addRowAuto(o);
		fineNolo.addRowUtente(ou);
	}

	public void cancNolo() {
		// TODO Auto-generated method stub
		db.cancellaNoleggio((String) fineNolo.getTableNoleggio().getValueAt(fineNolo.getTableNoleggioRowSelected(), 1), // username
				(String) fineNolo.getTableNoleggio().getValueAt(fineNolo.getTableNoleggioRowSelected(), 0)); // targa
		mostraFineNolo();
	}

	public void loginCliente() {
		// TODO Auto-generated method stub
		if (db.loginCliente(login.getTexfieldUsernameLogin(), login.getTextfieldPasswordLogin())) {
			ResultSet rs = db.getUtente(login.getTexfieldUsernameLogin());
			try {
				cliente = new Utente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5),
						rs.getBoolean(6), rs.getString(7),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(8)),
						new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy").parse(rs.getString(9)), rs.getString(10),
						rs.getString(11));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!(cliente == null)) {
				mostraLoggatoCliente();
			} else {
				mostraLogin();
			}
		} else {
			mostraLogin();
		}
	}

	public void salvaProfiloUtente() {
		// TODO Auto-generated method stub
		cliente = modCliente.ritornaCliente();
		db.modificaUtente(cliente);
		System.out.println(" email " + cliente.getEmail());
		mostraModificaCliente();
	}

	public void salvaNuovaPassword() {
		System.out.println(cliente.getUsername());

		System.out.println("vecchia psw" + modCliente.getVecchiaPsw());
		if (db.loginCliente(cliente.getUsername(), modCliente.getVecchiaPsw())) {
			if (new String(modCliente.getNuovaPsw()).equals(modCliente.getRipetiPsw())) {
				db.setPasswordCliente(modCliente.getNuovaPsw(), cliente.getUsername());
				System.out.println("password cambiata");
				modCliente.setLblMessaggio("Password Cambiata!");
			} else {
				modCliente.setLblMessaggio("Password Diverse!");
			}
		} else {
			modCliente.setLblMessaggio("Password Vecchia sbagliata!");
		}
	}

	public void cancellaProfilo() {
		// TODO Auto-generated method stub
		db.eliminaCliente(cliente);
		cliente = null;
		mostraLogin();
	}

	public void ricercaNoloUtente() {
		// TODO Auto-generated method stub
		ArrayList<Auto> listNolo = new ArrayList<Auto>();
		System.out.println(noleggioAutoUtente.getTextDataFine().getText());
		try {
			if (new SimpleDateFormat("dd/MM/yy").parse(noleggioAutoUtente.getTextDataInizio().getText()).compareTo(
					new SimpleDateFormat("dd/MM/yy").parse(noleggioAutoUtente.getTextDataFine().getText())) <= -1) {
				System.out.println("sei qui!");
				ResultSet rs = db.ricercaNolo( /* resituisce la lista di ricerca */
						noleggioAutoUtente.getTextDataInizio().getText(), noleggioAutoUtente.getTextDataFine().getText(),
						noleggioAutoUtente.getTextMarca().getText(), noleggioAutoUtente.getTextModello().getText(),
						noleggioAutoUtente.getTextPosti().getText(), noleggioAutoUtente.getTextCilindrata().getText(),
						noleggioAutoUtente.getTextCavalli().getText(), noleggioAutoUtente.getTextConsumi().getText(),
						(String) noleggioAutoUtente.getLuogo().getSelectedItem());
				try {
					while (rs.next()) {
						Auto rc = new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
						listNolo.add(rc);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mostraRicercaNoloUtente(listNolo, noleggioAutoUtente.getTextDataInizio().getText(),
						noleggioAutoUtente.getTextDataFine().getText(),
						(String) noleggioAutoUtente.getLuogo().getSelectedItem());
			} else {
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void preventivoUtenteNolo() {
		// TODO Auto-generated method stub
		System.out.println(ricercaNoloCliente.getTable().getValueAt(ricercaNoloCliente.getTable().getSelectedRow(), 9)); // print
																															// the
																															// price
																															// of
																															// row
		System.out.println((String) ricercaNoloCliente.getComboBox().getSelectedItem());
		Noleggio n = null;

		System.out.println(" account verificato: " + db.verificaAccount(cliente.getUsername()));
		if (!(db.verificaAccount(cliente.getUsername()))) {
			ricercaNoloCliente.setLblprezzo("Utente non verificato!");
		} else {
			try {
				n = new Noleggio(
						new SimpleDateFormat("dd/MM/yy").parse((String) ricercaNoloCliente.getTable()
								.getValueAt(ricercaNoloCliente.getTable().getSelectedRow(), 1)),
						new SimpleDateFormat("dd/MM/yy").parse((String) ricercaNoloCliente.getTable()
								.getValueAt(ricercaNoloCliente.getTable().getSelectedRow(), 2)),
						(String) ricercaNoloCliente.getComboBox().getSelectedItem());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ricercaNoloCliente.setLblprezzo(n.calcolaPrezzo(cliente.getRatio(), (String) ricercaNoloCliente.getTable()
					.getValueAt(ricercaNoloCliente.getTable().getSelectedRow(), 9)));

			//
			// creo l'oggetto noleggio e poi richiamo il suo metodo per il prezzo lo setto
			//
		}
	}

	public void salvaNoleggioCliente() {
		// TODO Auto-generated method stub
		String username = db.esisteUser(cliente.getUsername());
		if (!(db.verificaAccount(username))) {
			mostraLoggatoCliente();
		}

		else {

			// successivamente rimuover noleggio e richiamare ga
			System.out.println("tutto ok sto eseguendo");
			Noleggio n = new Noleggio(
					(String) ricercaNoloCliente.getTable().getValueAt(ricercaNoloCliente.getTable().getSelectedRow(),
							0), // targa
					username,
					(String) ricercaNoloCliente.getTable().getValueAt(ricercaNoloCliente.getTable().getSelectedRow(),
							1), // data inzio
					(String) ricercaNoloCliente.getTable().getValueAt(ricercaNoloCliente.getTable().getSelectedRow(),
							2), // data fine
					(String) ricercaNoloCliente.getComboBox().getSelectedItem(), // assicurazione
					(String) ricercaNoloCliente.getTable().getValueAt(ricercaNoloCliente.getTable().getSelectedRow(),
							10)); // luogo

			n.calcolaPrezzo(cliente.getRatio(), // ratio
					(String) ricercaNoloCliente.getTable().getValueAt(ricercaNoloCliente.getTable().getSelectedRow(), 9) // prezzo
																															// auto
			);
			if (db.inserisciNolo(n.getTarga(), n.getUsername(), s.format(n.getInizioNolo()), s.format(n.getFineNolo()),
					n.getAssicurazione(), n.getLuogoConsegna(), n.getPrezzo())) {
				mostraLoggatoCliente(); // se ritorna un valore che è
			}
		}

	}

	public void salvaRegistrazione() {
		try {
			Utente u = registraNuovoUtente.utente();
			if (String.valueOf(registraNuovoUtente.getInsPassword()).equals(registraNuovoUtente.getReinsPassword())) {
				if (!(db.esistitoUser(u.getUsername()))) {
					db.registraUtenteDaSolo(u, String.valueOf(registraNuovoUtente.getInsPassword()));
					mostraLogin();
				} else {
					System.out.println("Account esiste gia");
					mostraLogin();
				}

			} else {
				System.out.println("errore nella registrazione");
				System.out.println(registraNuovoUtente.getInsPassword());
				System.out.println(registraNuovoUtente.getReinsPassword());
			}

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void EliminaCliente() {
		// TODO Auto-generated method stub
		int i = modClienti.getTableModificaClienti().getSelectedRow();
		Utente u = null;
		try {
			u = new Utente((String) modClienti.getModel().getValueAt(i, 0),
					(String) modClienti.getModel().getValueAt(i, 1), (String) modClienti.getModel().getValueAt(i, 2),
					Float.valueOf(String.valueOf(modClienti.getModel().getValueAt(i, 3))),
					(String) modClienti.getModel().getValueAt(i, 4), (Boolean) modClienti.getModel().getValueAt(i, 5),
					(String) modClienti.getModel().getValueAt(i, 6),
					new SimpleDateFormat("dd/MM/yy").parse((String) modClienti.getModel().getValueAt(i, 7)),
					new SimpleDateFormat("dd/MM/yy").parse((String) modClienti.getModel().getValueAt(i, 8)),
					(String) modClienti.getModel().getValueAt(i, 9), (String) modClienti.getModel().getValueAt(i, 10));
		} catch (NumberFormatException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		;

		db.eliminaCliente(u);
		mostraModifcaCliente();
	}

//	class CancellaNoleggioUtente implements ActionListener {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			mostraCancellaNoleggioUtente();
//		}
//	}

	public void cancellaNoleggioUtente() {
		// TODO Auto-generated method stub
		Noleggio n = noleggiUtenti.getNoleggioSelezionato();
		Date yesterday = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		if (yesterday.before(n.getInizioNolo())) {
			db.cancellaNoleggio(n.getUsername(), n.getTarga());
			System.out.println("Noleggio Cancellato");
			mostraCancellaNoleggioUtente();
		} else {
			System.out.println("Noleggio non Cancellato");
			mostraCancellaNoleggioUtente();
		}
	}

	public void cercaAutoNonRegistrato() {
		ArrayList<Auto> a = new ArrayList<Auto>();
		try {
			if (new SimpleDateFormat("dd/MM/yy").parse(ricercaNonRegistrato.getTextDataInizio().getText()).compareTo(
					new SimpleDateFormat("dd/MM/yy").parse(ricercaNonRegistrato.getTextDataFine().getText())) <= -1) {
				System.out.println("sei qui!");
				ResultSet rs = db.ricercaNolo( /* resituisce la lista di ricerca */
						ricercaNonRegistrato.getTextDataInizio().getText(),
						ricercaNonRegistrato.getTextDataFine().getText(), ricercaNonRegistrato.getTextMarca().getText(),
						ricercaNonRegistrato.getTextModello().getText(), ricercaNonRegistrato.getTextPosti().getText(),
						ricercaNonRegistrato.getTextCilindrata().getText(),
						ricercaNonRegistrato.getTextCavalli().getText(),
						ricercaNonRegistrato.getTextConsumi().getText(),
						(String) ricercaNonRegistrato.getLuogo().getSelectedItem());
				try {
					while (rs.next())

					{
						Auto rc = new Auto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
						a.add(rc);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mostraRisRicercaNonRegistrato(a, ricercaNonRegistrato.getTextDataInizio().getText(),
						ricercaNonRegistrato.getTextDataFine().getText(),
						(String) ricercaNonRegistrato.getLuogo().getSelectedItem());
			} else {

				try {
					System.out.println(
							new SimpleDateFormat("dd/MM/yy").parse(ricercaNonRegistrato.getTextDataInizio().getText()));
					System.out.println(
							new SimpleDateFormat("dd/MM/yy").parse(ricercaNonRegistrato.getTextDataFine().getText()));
					System.out.println(
							new SimpleDateFormat("dd/MM/yy").parse(ricercaNonRegistrato.getTextDataInizio().getText())
									.compareTo(new SimpleDateFormat("dd/MM/yy")
											.parse(ricercaNonRegistrato.getTextDataFine().getText())));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void preventivoNonRegistrato() {
		// TODO Auto-generated method stub
		Noleggio n = null;
		try {
			n = new Noleggio(
					new SimpleDateFormat("dd/MM/yy").parse((String) risRicercaNonRegistrato.getTable()
							.getValueAt(risRicercaNonRegistrato.getTable().getSelectedRow(), 1)),
					new SimpleDateFormat("dd/MM/yy").parse((String) risRicercaNonRegistrato.getTable()
							.getValueAt(risRicercaNonRegistrato.getTable().getSelectedRow(), 2)),
					(String) risRicercaNonRegistrato.getComboBox().getSelectedItem());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		risRicercaNonRegistrato.setLblprezzo(n.calcolaPrezzo(0, (String) risRicercaNonRegistrato.getTable()
				.getValueAt(risRicercaNonRegistrato.getTable().getSelectedRow(), 9)));

		//
		// creo l'oggetto noleggio e poi richiamo il suo metodo per il prezzo lo setto
		//
	}
}
