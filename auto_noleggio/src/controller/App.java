package controller;

import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws SQLException {
		
		GestioneAutonoleggio c = new GestioneAutonoleggio();
		c.mostraLogin();
	}
}
