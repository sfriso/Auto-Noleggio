package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Auto;
import controller.Utente;

public class DbManager {

	private Connection connection;
	DbManagerUtils dbu;

	public DbManager(String DbFilePath) throws SQLException {
// TODO Auto-generated constructor stub
		this.connection = DriverManager.getConnection(DbFilePath);
		dbu = new DbManagerUtils();
	}

	public String generateSalt() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String string = "";
		for (int i = 0; i < bytes.length; i++) {
			string += (char) bytes[i];
		}
		return string;
	}

	public String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes(StandardCharsets.UTF_8));
			byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

//	public void modificaadmin() {
//		try {
//			PreparedStatement prst = connection.prepareStatement(dbu.INSERISCI_IMPIEAGATI);
//			String salt = generateSalt();
//			prst.setString(1, "admin");
//			prst.setString(2, get_SHA_512_SecurePassword("admin", salt));
//			prst.setString(3, salt);
//			prst.execute();
//			prst.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void creaLoginUtenti(String username, String password) throws SQLException {
		PreparedStatement prst = connection.prepareStatement(DbManagerUtils.INSERISCI_IMPIEAGATI);
		String salt = generateSalt();
		prst.setString(1, username);
		prst.setString(2, get_SHA_512_SecurePassword(password, salt));
		prst.setString(3, salt);
		prst.execute();
		prst.close();
	}

	public ResultSet ritornaImpiegato(String username) throws SQLException {
		PreparedStatement prst = connection.prepareStatement(DbManagerUtils.SELECT_IMPIEGATO);
		prst.setString(1, username);
		return prst.executeQuery();
	}

	public void registraUtente(Utente u) throws SQLException {
		PreparedStatement prst = connection.prepareStatement(DbManagerUtils.REGISTRA_CLIENTE);
		prst.setString(1, u.getNome());
		prst.setString(2, u.getCognome());
		prst.setString(3, u.getPatente());
		prst.setFloat(4, u.getRatio());
		prst.setString(5, u.getEmail());
		prst.setBoolean(6, u.getAccountVerificato());
		prst.setString(7, u.getUsername());
		prst.setString(8, u.getDataScadenzaPatente().toString());
		prst.setString(9, u.getDataDiNascita().toString());
		prst.setString(10, u.getNumeroDiCellulare());
		prst.setString(11, u.getCartaDiCredito());
		prst.executeUpdate();

		// isnerimento Username e Password
		PreparedStatement prs = connection.prepareStatement(DbManagerUtils.NUOVA_ENTRY_CLIENTI);
		String salt = generateSalt();
		prs.setString(1, u.getUsername());
		prs.setString(2, get_SHA_512_SecurePassword(u.getUsername(), salt));
		prs.setString(3, salt);
		prs.executeUpdate();

	}

	public void cancellaAuto(String targa) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.CANCELLA_AUTO);
			prst.setString(1, targa);
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registraUtenteDaSolo(Utente u, String pas) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.REGISTRA_CLIENTE);

			prst.setString(1, u.getNome());
			prst.setString(2, u.getCognome());
			prst.setString(3, u.getPatente());
			prst.setFloat(4, u.getRatio());
			prst.setString(5, u.getEmail());
			prst.setBoolean(6, u.getAccountVerificato());
			prst.setString(7, u.getUsername());
			prst.setString(8, u.getDataScadenzaPatente().toString());
			prst.setString(9, u.getDataDiNascita().toString());
			prst.setString(10, u.getNumeroDiCellulare());
			prst.setString(11, u.getCartaDiCredito());
			prst.executeUpdate();

			// isnerimento Username e Password
			PreparedStatement prs = connection.prepareStatement(DbManagerUtils.NUOVA_ENTRY_CLIENTI);
			String salt = generateSalt();
			prs.setString(1, u.getUsername());
			prs.setString(2, get_SHA_512_SecurePassword(pas, salt));
			prs.setString(3, salt);
			prs.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modificaUtente(Utente u) {
		try {
			PreparedStatement prst = connection.prepareStatement(DbManagerUtils.SALVA_TUTTI_INFOCLIENTI);
			prst.setString(1, u.getNome());
			prst.setString(2, u.getCognome());
			prst.setString(3, u.getPatente());
			prst.setFloat(4, u.getRatio());
			prst.setString(5, u.getEmail());
			prst.setBoolean(6, u.getAccountVerificato());
			prst.setString(7, u.getUsername());
			prst.setString(8, u.getDataScadenzaPatente().toString());
			prst.setString(9, u.getDataDiNascita().toString());
			prst.setString(10, u.getNumeroDiCellulare());
			prst.setString(11, u.getCartaDiCredito());
			prst.setString(12, u.getUsername());
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setPasswordCliente(String psw, String user) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.SALT_CLIENTE);
			prst.setString(1, user);
			String salt = prst.executeQuery().getString(1);
			prst = connection.prepareStatement(DbManagerUtils.IMPOSTA_PASSWORD_CLIENTE);
			prst.setString(1, get_SHA_512_SecurePassword(psw, salt));
			prst.setString(2, user);
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet selectInfoClienti() {

		try {
			PreparedStatement prst = connection.prepareStatement(DbManagerUtils.TUTTI_INFOCLIENTI);
			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean loginImpiegati(String username, String password) throws SQLException {
		boolean risultato = false;
		PreparedStatement prst = this.connection.prepareStatement(DbManagerUtils.LOGIN);
		prst.setString(1, username);
		ResultSet rs = prst.executeQuery();
		rs.getString(1);
		risultato = (rs.getString(1).equals(get_SHA_512_SecurePassword(password, rs.getString(2)))) ? true : false;
		System.out.println(risultato);
		System.out.println(rs.getInt(1));
		return risultato;
	}

	public void insertInfoClienti(ArrayList<Utente> list) throws SQLException {
		int index = 0;
		PreparedStatement prst = connection.prepareStatement(DbManagerUtils.SALVA_TUTTI_INFOCLIENTI);
		while (index < list.size()) {
			prst.setString(1, list.get(index).getNome());
			prst.setString(2, list.get(index).getCognome());
			prst.setString(3, list.get(index).getPatente());
			prst.setFloat(4, list.get(index).getRatio());
			prst.setString(5, list.get(index).getEmail());
			prst.setBoolean(6, list.get(index).getAccountVerificato());
			prst.setString(7, list.get(index).getUsername());
			prst.setString(8, list.get(index).getDataScadenzaPatente().toString());
			prst.setString(9, list.get(index).getDataDiNascita().toString());
			prst.setString(10, list.get(index).getNumeroDiCellulare());
			prst.setString(11, list.get(index).getCartaDiCredito());
			prst.setString(12, list.get(index).getUsername());
			prst.executeUpdate();
			System.out.println(index + " " + list.get(index).getNome());
			index++;
		}
		return;
	}

	public boolean registraAuto(Auto a) {
		// TODO Auto-generated method stub
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.INSERISCI_AUTO);
			prst.setString(1, a.getTarga());
			prst.setString(2, a.getMarca());
			prst.setString(3, a.getModello());
			prst.setString(4, a.getPosti());
			prst.setString(5, a.getCilindrata());
			prst.setString(6, a.getCavalli());
			prst.setString(7, a.getConsumi());
			prst.setString(8, a.getProssimaRevisione().toString());
			prst.setString(9, a.getProssimoBollo().toString());
			prst.setString(10, a.getCambioRuote().toString());
			prst.setString(11, a.getRinnovoAssicurazione().toString());
			prst.setString(12, a.getDanniCarrozzeria());
			prst.setString(13, a.getDanniInterno());
			prst.setString(14, a.getPulizia());
			prst.setString(15,  a.getPrezzo());
			prst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean inserisciInfoAuto(ArrayList<Auto> a) {
		int index = 0;
		try {
			while (index < a.size()) {
				PreparedStatement prst = connection.prepareStatement(DbManagerUtils.INSERISCI_INFOAUTO);
				prst.setString(1, a.get(index).getTarga());
				prst.setString(2, a.get(index).getMarca());
				prst.setString(3, a.get(index).getModello());
				prst.setString(4, a.get(index).getPosti());
				prst.setString(5, a.get(index).getCilindrata());
				prst.setString(6, a.get(index).getCavalli());
				prst.setString(7, a.get(index).getConsumi());
				prst.setString(8, a.get(index).getProssimaRevisione().toString());
				prst.setString(9, a.get(index).getProssimoBollo().toString());
				prst.setString(10, a.get(index).getCambioRuote().toString());
				prst.setString(11, a.get(index).getRinnovoAssicurazione().toString());
				prst.setString(12, a.get(index).getDanniCarrozzeria());
				prst.setString(13, a.get(index).getDanniInterno());
				prst.setString(14, a.get(index).getPulizia());
				prst.setString(15, a.get(index).getPrezzo());
				prst.setString(16, a.get(index).getTarga());
				prst.executeUpdate();
				index++;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet selectInfoAuto() {
		// TODO Auto-generated method stub
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.SELECT_INFO_AUTO);

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet ricercaNolo(String dataInizio, String dataFine, String marca, String modello, String posti,
			String cilindrata, String cavalli, String consumi, String luogo) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.RICERCA_TUTTO);
			prst.setString(1, dataInizio);
			prst.setString(2, dataFine);
			prst.setString(3, dataInizio);
			prst.setString(4, dataFine);
			prst.setString(5, "%" + marca + "%");
			prst.setString(6, "%" + modello + "%");
			prst.setString(7, "%" + posti + "%");
			prst.setString(8, "%" + cilindrata + "%");
			prst.setString(9, "%" + cavalli + "%");
			prst.setString(10, "%" + consumi + "%");

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet ricercaNonNolo(String dataInizio, String dataFine, String marca, String modello, String posti,
			String cilindrata, String cavalli, String consumi, String luogo) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.RICERCA_TUTTO_IL_RESTO);
			prst.setString(1, dataInizio);
			prst.setString(2, dataFine);
			prst.setString(3, dataInizio);
			prst.setString(4, dataFine);
			prst.setString(5, "%" + marca + "%");
			prst.setString(6, "%" + modello + "%");
			prst.setString(7, "%" + posti + "%");
			prst.setString(8, "%" + cilindrata + "%");
			prst.setString(9, "%" + cavalli + "%");
			prst.setString(10, "%" + consumi + "%");

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean inserisciNolo(String targa, String username, String dataInizio, String dataFine,
			String assicurazione, String luogoConsegna, String preventivo) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.INSERISCI_NOLEGGIO);
			prst.setString(1, targa);
			prst.setString(2, username);
			prst.setString(3, dataInizio);
			prst.setString(4, dataFine);
			prst.setString(5, assicurazione);
			prst.setString(6, luogoConsegna);
			prst.setString(7, preventivo);
			prst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public float ratioUser(String user, String pat) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.RATIO_USERPAT);
			prst.setString(1, user);
			prst.setString(2, pat);
			ResultSet rs = prst.executeQuery();
			float result = -1;
			if (rs.next()) {
				result = rs.getFloat("ratio");
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public String esisteUser(String user) {
		int result = 0;
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.ESISTE_USER);

			prst.setString(1, user);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 1) {
			return user;
		}
		return "ERROR";

	}

	public ResultSet tuttiNolo() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prst = connection.prepareStatement(DbManagerUtils.TUTTO_NOLO);

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getAuto(String valueAt) {
		// TODO Auto-generated method stub
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.SELECT_SPECIFICA_INFOAUTO);
			prst.setString(1, valueAt);

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getUtente(String valueAt) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.SELECT_SPECIFICO_UTENTE);
			prst.setString(1, valueAt);

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void cancellaNoleggio(String username, String targa) {
		try {
			PreparedStatement prst = connection.prepareStatement(DbManagerUtils.CANCELLA_NOLEGGIO);
			prst.setString(1, username);
			prst.setString(2, targa);
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean verificaAccount(String username) {
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.ACCOUNT_VERIFICATO);
			prst.setString(1, username);
			return prst.executeQuery().getBoolean(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean loginCliente(String user, String pass) {
		// TODO Auto-generated method stub
		boolean risultato = false;
		PreparedStatement prst;
		ResultSet rs;
		try {
			prst = this.connection.prepareStatement(DbManagerUtils.LOGIN_CLIENTE);
			prst.setString(1, user);
			rs = prst.executeQuery();

			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			risultato = (rs.getString(1).equals(get_SHA_512_SecurePassword(pass, rs.getString(2)))) ? true : false;
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risultato;
	}

	public void eliminaCliente(Utente u) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prst = connection.prepareStatement(DbManagerUtils.CANCELLA_UTENTE);
			prst.setString(1, u.getUsername());
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean esistitoUser(String user) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prst = connection.prepareStatement(DbManagerUtils.ACCOUNT_ESISTE);
			prst.setString(1, user);
			return prst.executeQuery().getInt(1) == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public ResultSet listaNoloUtente(String username) {
		// TODO Auto-generated method stub
		PreparedStatement prst;
		try {
			prst = connection.prepareStatement(DbManagerUtils.LISTA_NOLEGGI);
			prst.setString(1, username);

			return prst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
