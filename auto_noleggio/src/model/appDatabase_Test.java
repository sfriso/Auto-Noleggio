package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class appDatabase_Test{
	
	public static void main(String[] Args) throws SQLException {
		boolean ris;
		DbManager db= new DbManager("jdbc:sqlite:C:/Users/aless/DesktopAutoNoleggio.db");
		ResultSet rs = db.selectInfoClienti();
		while(rs.next()) {
			System.out.print(rs.getString("Username"));
		}
	}
}
